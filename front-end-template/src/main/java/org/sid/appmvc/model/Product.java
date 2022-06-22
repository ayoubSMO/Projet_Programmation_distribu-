package org.sid.appmvc.model;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String designation;
    private double prix;
    private int quantite;
}
