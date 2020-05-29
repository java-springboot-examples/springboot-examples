package springboot.examples.keycloak.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import springboot.examples.keycloak.model.Product;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private List<Product> products = Arrays.asList(
            new Product(1, "Product A"),
            new Product(2, "Product B"),
            new Product(3, "Product C")
    );

    @GetMapping
    public List<Product> getProducts() {
        return products;
    }

    @GetMapping(path = "/{id}")
    public Product getProduct(@PathVariable int id) {
        return products.stream()
                .filter(product -> product.getId() == id).findFirst()
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND, String.format("Product with id: %d not found", id))
                );
    }
}
