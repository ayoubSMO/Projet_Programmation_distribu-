package orgsid.inventoryservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import orgsid.inventoryservice.Repositories.ProductRepository;

@RestController
public class ProductRestController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "/products/del/{id}")
    public void deleteProduct(@PathVariable(name = "id") Long id){
        productRepository.deleteById(id);
    }
}
