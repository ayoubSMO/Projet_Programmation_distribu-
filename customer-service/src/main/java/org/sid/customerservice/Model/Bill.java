package org.sid.customerservice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.customerservice.Entities.Customer;

import java.util.Collection;
import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class Bill {
    private Long id;
    private Date billingDate;
    private Collection<ProductItem> productItems;
    private Long customerID;
    private Customer customer;
}