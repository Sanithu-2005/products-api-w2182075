package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;



    public List<Product> getAllProducts() {
        return products;
    }


    public Product addDigitalProduct(Product product) {
        product.setId(nextId++);
        products.add(new DigitalProduct(
                nextId++, "Clean Code (E-book)", 29.99,
                "/downloads/clean-code.pdf", 4.2));
        return product;
    }

    public Product addPhysicalProduct(Product product) {
        product.setId(nextId++);
        products.add(new PhysicalProduct(nextId++, "27-inch Monitor", 249.99,
                5.4, "61cm x 41cm x 18cm"));
        return product;
    }



    public Product addProduct(Product product) {
        product.setId(nextId++); // use the value, then add one
        products.add(product);
        return product;
}
    // ---- in ProductService.java ----
    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    // ---- in ProductService.java ----
    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    // ---- in ProductService.java ----
    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();


    }

    public List<String> getAllSummaries(){
        List<String> summaries = new ArrayList<>();
        for(Product p:products){
            summaries.add(p.getSummary());
        }
        return summaries;
    }

}


