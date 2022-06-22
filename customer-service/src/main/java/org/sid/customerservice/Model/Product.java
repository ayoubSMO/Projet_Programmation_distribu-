package org.sid.customerservice.Model;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String nom;
    private double prix;
    private int quantite;
}
