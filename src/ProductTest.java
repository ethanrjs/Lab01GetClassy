import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ProductTest {
    private Product product;

    @Before
    public void setUp() {
        product = new Product("Laptop", "High performance gaming laptop", "123456", 1200.00);
    }

    @Test
    public void testGetters() {
        assertEquals("Laptop", product.getName());
        assertEquals("High performance gaming laptop", product.getDescription());
        assertEquals("123456", product.getID());
        assertTrue(product.getCost() == 1200.00);
    }

    @Test
    public void testToCSVDataRecord() {
        assertEquals("Laptop,High performance gaming laptop,123456,1200.0", product.toCSVDataRecord());
    }
}
