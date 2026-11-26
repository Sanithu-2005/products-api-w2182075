package uk.ac.westminster.products_api;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import uk.ac.westminster.products_api.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService service;

    private final Product ebook =
            new DigitalProduct(1L, "E-book", 9.99, "/dl/1", 4.2);
    private final Product monitor =
            new PhysicalProduct(2L, "Monitor", 249.99, 5.4, "60x40");

    @Test
    void shouldReturnAllProducts() {
        when(repository.findAll()).thenReturn(List.of(ebook, monitor));

        List<Product> result = service.getAllProducts();

        assertEquals(2, result.size());
        assertEquals("E-book", result.get(0).getName());
        verify(repository).findAll();
    }

    @Test
    void shouldReturnProductById() {
        when(repository.findById(1L)).thenReturn(Optional.of(ebook));

        Product result = service.getProductById(1L);

        assertSame(ebook, result);
        verify(repository).findById(1L);
    }

    @Test
    void shouldThrowExceptionWhenProductNotFound() {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class,
                () -> service.getProductById(99L));
    }

    @Test
    void shouldSaveNewProduct() {
        Product notes = new DigitalProduct(null, "Course notes", 4.99, "/dl/2", 1.1);
        when(repository.save(notes)).thenReturn(notes);

        Product result = service.addProduct(notes);

        verify(repository).save(notes);
        assertSame(notes, result);
    }

    @Test
    void shouldDeleteExistingProduct() {
        when(repository.findById(1L)).thenReturn(Optional.of(ebook));

        service.deleteProduct(1L);

        verify(repository).delete(1L);
    }

    @Test
    void shouldNotDeleteWhenProductMissing() {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class,
                () -> service.deleteProduct(99L));
        verify(repository, never()).delete(any());
    }

    @Test
    void shouldFindProductsByName() {
        when(repository.findAll()).thenReturn(List.of(ebook, monitor));

        List<Product> result = service.findByName("Mon");

        assertEquals(1, result.size());
        assertSame(monitor, result.get(0));
    }
}