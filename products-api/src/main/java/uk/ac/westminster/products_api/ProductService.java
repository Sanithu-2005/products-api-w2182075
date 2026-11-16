package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import uk.ac.westminster.products_api.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    // The interface, never the implementation.
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    public Product addProduct(Product product) {
        return repository.save(product);
    }

    public void deleteProduct(Long id) {
        getProductById(id);          // throws 404 if it is not there
        repository.delete(id);
    }

    public List<Product> findByName(String name) {
        return repository.findAll().stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }

    public List<String> getAllSummaries() {
        return repository.findAll().stream()
                .map(Product::getSummary)
                .toList();
    }
}

