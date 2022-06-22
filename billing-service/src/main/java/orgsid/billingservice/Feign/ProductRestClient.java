package orgsid.billingservice.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import orgsid.billingservice.Model.Product;

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductRestClient {
    /*@GetMapping(path = "/products")
    public PagedModel<Product> pageProducts(@RequestParam(value = "page") int page, @RequestParam(value = "size") int size);*/

    @GetMapping(path = "/products")
    public PagedModel<Product> pageProducts();

    @GetMapping(path = "/products/{id}")
    public Product getProductById( @PathVariable Long id);

    @GetMapping(path = "/products/del/{id}")
    public void deleteProductById(@PathVariable Long id);
}
