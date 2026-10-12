package uk.ac.westminster.products_api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class ProductController {

    // Spring creates the ProductService and hands it over.
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }

//    @GetMapping("/{id}")
//    public Product getById(@PathVariable Long id) {
//        return new Product(id, "Laptop", 999.99);
//    }

//    @GetMapping("/products/{id}")
//    public Product getById2(@PathVariable Long id) {
//        return new Product(id, "Laptop", 999.99);
//    }

    // ---- in ProductController.java ----
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id).orElse(null);
    }
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    // ---- in ProductController.java ----
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {

    }

    // ---- in ProductController.java ----
    @GetMapping("/products/search")
    public List<Product> search(@RequestParam String name) {
        return productService.findByName(name);

    }


}

//Thrid part of Optional tasks: We can either have RequestMapping("/products") alongside @GetMapping("/{id}")
//Or we can have just  @GetMapping("/products/{id}") to gain access to the necassary url , I believe RequestMapping can
//be used to set url for multiple GetMapping commands as opposed to the second option which only works for itself.