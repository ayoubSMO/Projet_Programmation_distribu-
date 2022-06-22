package orgsid.billingservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.hateoas.PagedModel;
import orgsid.billingservice.Entities.Bill;
import orgsid.billingservice.Entities.ProductItem;
import orgsid.billingservice.Feign.CustomerRestClient;
import orgsid.billingservice.Feign.ProductRestClient;
import orgsid.billingservice.Model.Customer;
import orgsid.billingservice.Model.Product;
import orgsid.billingservice.Repositories.BillRepository;
import orgsid.billingservice.Repositories.ProductItemRepository;

import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(RepositoryRestConfiguration restConfiguration){

        restConfiguration.exposeIdsFor(Bill.class);
        return args -> {

           /* Customer customer = customerRestClient.getCustomerById(1L);
            Bill bill =  billRepository.save(new Bill(null, new Date(), null, customer.getId(),null));
            PagedModel<Product> productPagedModel = productRestClient.pageProducts();
            productPagedModel.forEach(p->{
                ProductItem productItem = new ProductItem();
                productItem.setProductID(p.getId());
                productItem.setPrix(p.getPrix());
                productItem.setQuantite(1+ new Random().nextInt(100));
                productItem.setBill(bill);
                productItemRepository.save(productItem);
            });*/
            /*System.out.println("-------------------------------------");
            System.out.println(customer.getId());
            System.out.println(customer.getNom());
            System.out.println(customer.getPrenom());
            System.out.println(customer.getEmail());*/
        };
    }

}
