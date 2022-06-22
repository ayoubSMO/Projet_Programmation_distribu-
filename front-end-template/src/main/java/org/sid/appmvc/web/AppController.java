package org.sid.appmvc.web;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.sid.appmvc.model.Bill;
import org.sid.appmvc.model.Customer;
import org.sid.appmvc.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AppController {

    @Autowired
    private KeycloakRestTemplate keycloakRestTemplate;
    private List<Bill> bills;

    @GetMapping("/")
    public String index(){
        return "index_";
    }

    // get all customers
    @GetMapping("/customers")
    @RolesAllowed("USER")
    public String customers(Model model){
        PagedModel<Customer> pagedCustomer = keycloakRestTemplate.getForObject("http://localhost:8087/customers", PagedModel.class);
        model.addAttribute("customers", pagedCustomer);
        return "customers";
    }

    // get all products
    @GetMapping("/products")
    @RolesAllowed("USER")
    public String products(Model model){
        PagedModel<Product> pagedProduct = keycloakRestTemplate.getForObject("http://localhost:8082/products", PagedModel.class);
        model.addAttribute("products", pagedProduct);
        return "products";
    }

    //supprimer customer
    @GetMapping(path = "/customers/{id}")
    @RolesAllowed("USER")
    public String delcustomer(@PathVariable Long id, Model model){
        keycloakRestTemplate.getForObject("http://localhost:8083/bills/delCustomer/"+id, PagedModel.class);
        return "redirect:/customers";
    }

    //supprimer product
    @GetMapping(path = "/products/{id}")
    public String products(@PathVariable Long id, Model model){
        keycloakRestTemplate.getForObject("http://localhost:8083/bills/delProduct/"+id, PagedModel.class);
        return "redirect:/products";
    }

    //supprimer facture
    @GetMapping(path = "/factures/{id}")
    @RolesAllowed("USER")
    public String factures(@PathVariable Long id){
        keycloakRestTemplate.getForObject("http://localhost:8083/bills/del/"+id, PagedModel.class);
        return "redirect:/factures";
    }

    // get all factures
    @GetMapping("/factures")
    @RolesAllowed("USER")
    public String factures(Model model){
        ResponseEntity<List<Bill>> response= keycloakRestTemplate.exchange("http://localhost:8083/Allbills",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Bill>>() { });
        model.addAttribute("factures", response.getBody());
        return "factures";
    }


    @GetMapping("/jwt")
    @ResponseBody
    public Map<String,String> map(HttpServletRequest request){
        KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) request.getUserPrincipal();
        KeycloakPrincipal principal = (KeycloakPrincipal) token.getPrincipal();
        KeycloakSecurityContext keycloakSecurityContext = principal.getKeycloakSecurityContext();
        Map<String,String> map = new HashMap<>();
        map.put("access_token",keycloakSecurityContext.getTokenString());
        return map;
    }
}
