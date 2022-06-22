package org.sid.customerservice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProductItem {
    private Long id;
    private double prix;
    private double quantite;
    private Long productID;
    private Product product;
    private Bill bill;
}
