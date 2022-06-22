package org.sid.customerservice.Service;

import org.sid.customerservice.Repositories.BillingRestClient;
import org.sid.customerservice.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {
    @Autowired
    private CustomerRepository customerRepository;
    private BillingRestClient billingRestClient;

    public CustomerRestController(CustomerRepository customerRepository, BillingRestClient billingRestClient){
        this.customerRepository = customerRepository;
        this.billingRestClient = billingRestClient;
    }
//    public CustomerRestController(CustomerRepository customerRepository){
//        this.customerRepository = customerRepository;
//    }

    @GetMapping(path = "/customers/del/{id}")
    public void deleteCustomer(@PathVariable(name = "id") Long id){
        //billingRestClient.deleteBillsByCustomerID(id);
        customerRepository.deleteById(id);
    }
}
