package orgsid.billingservice.Model;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String designation;
    private double prix;
    private double quantite;
}
