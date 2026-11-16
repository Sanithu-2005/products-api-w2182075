package uk.ac.westminster.products_api.repository;

import uk.ac.westminster.products_api.Product;

import java.util.List;
import java.util.Optional;

// A contract. No annotation, no bodies, no fields.
// It says WHAT storage must do, never HOW.
public interface ProductRepository {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    void delete(Long id);;
}