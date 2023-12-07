import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CurrencyTest {

    //numero 1 type de test
    @Test
    void testConvertInstructionsCoverage() {
        Currency.init();
        Double amount = 100.0;
        Double exchangeValue = 1.5;
        Double result = Currency.convert(amount, exchangeValue);
        assertEquals(150.0, result, 0.01);
    }


}
