package uk.ac.westminster.products_api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return new Product(id, "Laptop", 999.99);
    }

//    @GetMapping("/products/{id}")
//    public Product getById2(@PathVariable Long id) {
//        return new Product(id, "Laptop", 999.99);
//    }
}

//Thrid part of Optional tasks: We can either have RequestMapping("/products") alongside @GetMapping("/{id}")
//Or we can have just  @GetMapping("/products/{id}") to gain access to the necassary url , I believe RequestMapping can
//be used to set url for multiple GetMapping commands as opposed to the second option which only works for itself.