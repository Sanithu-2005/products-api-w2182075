package uk.ac.westminster.products_api;

import org.junit.jupiter.api.Test;
import uk.ac.westminster.products_api.DigitalProduct;

import static org.junit.jupiter.api.Assertions.*;
class DigitalProductTest {
    @Test
    void shouldUpdatePriceWhenValid() {
        DigitalProduct ebook = new DigitalProduct(1L, "E-book", 9.99, "/dl/1", 4.2);
        ebook.setPrice(7.49);
        assertEquals(7.49, ebook.getPrice(), 0.001);
    }
    @Test
    void shouldRejectNegativePrice() {
        DigitalProduct ebook = new DigitalProduct(1L, "E-book", 9.99, "/dl/1", 4.2);
        assertThrows(IllegalArgumentException.class,
                () -> ebook.setPrice(-0.01));
    }
}