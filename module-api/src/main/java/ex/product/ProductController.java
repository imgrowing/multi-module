package ex.product;

import ex.db2.product.domain.Product;
import ex.db2.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public Product get(@RequestParam(name = "name") String name) {
        Product newProduct = new Product(name, (int)(System.currentTimeMillis() % 10000));
        Long newId = productService.register(newProduct);
        return productService.getById(newId);
    }
}
