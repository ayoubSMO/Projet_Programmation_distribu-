package org.sid.appmvc.model;

import lombok.Data;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
public class Bill {
    private Long id;
    private Date billingDate;
    private Long customerID;
    private Customer customer;
    private List<Product> product;
    private double prix;
    private double qte;
}
