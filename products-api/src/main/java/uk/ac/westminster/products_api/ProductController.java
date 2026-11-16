package uk.ac.westminster.products_api;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class ProductController {

    // Spring creates the ProductService and hands it over via the constructor.
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/products/search")
    public List<Product> search(@RequestParam String name) {
        return productService.findByName(name);
    }

    @GetMapping("/product/summaries")
    public List<String> getSummaries() {
        return productService.getAllSummaries();
    }
}
//Thrid part of Optional tasks: We can either have RequestMapping("/products") alongside @GetMapping("/{id}")
//Or we can have just  @GetMapping("/products/{id}") to gain access to the necassary url , I believe RequestMapping can
//be used to set url for multiple GetMapping commands as opposed to the second option which only works for itself.