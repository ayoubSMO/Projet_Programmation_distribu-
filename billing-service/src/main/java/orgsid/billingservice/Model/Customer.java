package orgsid.billingservice.Model;

import lombok.Data;

@Data
public class Customer {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
}
