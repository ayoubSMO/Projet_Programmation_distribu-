package orgsid.billingservice.Web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import orgsid.billingservice.Entities.Bill;
import orgsid.billingservice.Entities.ProductItem;
import orgsid.billingservice.Feign.CustomerRestClient;
import orgsid.billingservice.Feign.ProductRestClient;
import orgsid.billingservice.Model.Customer;
import orgsid.billingservice.Model.Product;
import orgsid.billingservice.Repositories.BillRepository;
import orgsid.billingservice.Repositories.ProductItemRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class BillingRestController {

    private double prix = 0;
    private double qte = 0;
    private List<Product> liste_produit = new ArrayList<Product>();
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private ProductRestClient productRestClient;

    public BillingRestController(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerRestClient customerRestClient, ProductRestClient productRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClient = customerRestClient;
        this.productRestClient = productRestClient;
    }

  /*  @GetMapping(path = "fullBill/{id}")
    public Bill getBill(@PathVariable(name = "id") Long id){
        Bill bill = billRepository.findById(id).get();
        Customer customer = customerRestClient.getCustomerById(bill.getCustomerID());
        bill.setCustomer(customer);
        bill.setProductItems(productItemRepository.findByBillId(id));
        bill.getProductItems().forEach(pi->{
            Product product = productRestClient.getProductById(pi.getProductID());
            pi.setProduct(product);
        });

        return bill;
    }*/

    // afficher toutes les factures
    @GetMapping(path = "/Allbills")
    public List<Bill> getAll(){
        List<Bill> bills = billRepository.findAll();
        bills.forEach(b->{
            Customer customer = customerRestClient.getCustomerById(b.getCustomerID());
            b.setCustomer(customer);
            b.setProductItems(productItemRepository.findByBillId(b.getId()));
        });

        bills.forEach(b->{
            liste_produit.clear();
            prix = 0;
            qte = 0;
            b.getProductItems().forEach(pi->{
                Product product = productRestClient.getProductById(pi.getProductID());
                liste_produit.add(product);
                prix = prix+pi.getPrix();
                qte = qte+pi.getQuantite();
            });

            b.setProduct(liste_produit);
            b.setPrix(prix);
            b.setQte(qte);
        });
        return bills;
    }

   /* @GetMapping(path = "/bills/del/{id}")
    public void deleteBillsByCustomerId(@PathVariable Long id){
        Collection<Bill> bills = billRepository.getBillsByCustomerID(id);
        bills.forEach(b->{
            Bill bill = billRepository.findById(b.getId()).get();
            bill.getProductItems().forEach(pt->{
                productItemRepository.deleteById(pt.getId());
            });
            billRepository.deleteById(b.getId());
        });
    }*/

    // supprimer facture
    @GetMapping(path = "/bills/del/{id}")
    public void deleteBillsbyId(@PathVariable Long id){
        Bill bill = billRepository.findById(id).get();
        bill.getProductItems().forEach(b->{
            productItemRepository.deleteById(b.getId());
        });

        billRepository.deleteById(bill.getId());
    }

    // supprimer produit
    @GetMapping(path = "/bills/delProduct/{id}")
    public void deleteProductsById(@PathVariable Long id){
        Collection<ProductItem> productItems = productItemRepository.findAll();
        for (ProductItem b : productItems) {
            if (b.getProductID() == id) {
                productItemRepository.deleteById(b.getId());
            } else break;
        }

        productRestClient.deleteProductById(id);
    }

    // supprimer client
    @GetMapping(path = "/bills/delCustomer/{id}")
    public void deleteCustomersById(@PathVariable Long id){
        Collection<Bill> bills = billRepository.findAll();
        for (Bill f : bills) {
            if (f.getCustomerID() == id) {
                f.getProductItems().forEach(p->{
                    productItemRepository.deleteById(p.getId());
                });
                billRepository.deleteById(f.getId());
            }
        }

        customerRestClient.deleteCustomerById(id);

    }




}