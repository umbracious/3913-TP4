import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainWindowTest {

    //test boite blanche pour currencyConverter.MainWindow.convert(String, String, ArrayList<Currency>, Double)
    @Test
    void testConvertInstructionsCoverage() {
        MainWindow mainWindow = new MainWindow();
        Double result = MainWindow.convert("USD", "EUR", mainWindow.currencies, 100.0);

        assertEquals(93.0, result, 0.01);


    }

    @Test
    void testConvertControlFlowCoverage() {
        Currency.init();
        Double amount = 100.0;
        Double exchangeValue = 1.5;
        Double result1 = Currency.convert(amount, exchangeValue);
        Double result2 = Currency.convert(amount, 0.0);
        assertEquals(150.0, result1, 0.01);
        assertEquals(0.0, result2, 0.01);
    }

    @Test
    void testConvertIndependentPaths() {
        Currency.init();
        Double amount = 100.0;
        Double exchangeValue = 1.5;
        Double result1 = Currency.convert(amount, exchangeValue);
        Double result2 = Currency.convert(amount, 0.0);
        assertEquals(150.0, result1, 0.01);
        assertEquals(0.0, result2, 0.01);
    }

    @Test
    void testConvertConditions() {
        Currency.init();
        Double amount = 100.0;
        Double positiveExchangeValue = 1.5;
        Double zeroExchangeValue = 0.0;
        Double result1 = Currency.convert(amount, positiveExchangeValue);
        Double result2 = Currency.convert(amount, zeroExchangeValue);
        assertEquals(150.0, result1, 0.01);
        assertEquals(0.0, result2, 0.01);
    }

    @Test
    void testConvertIPaths() {
        Currency.init();
        Double amount = 100.0;
        Double positiveExchangeValue = 1.5;
        Double zeroExchangeValue = 0.0;
        Double result1 = Currency.convert(amount, positiveExchangeValue);
        Double result2 = Currency.convert(amount, zeroExchangeValue);
        assertEquals(150.0, result1, 0.01);
        assertEquals(0.0, result2, 0.01);
    }
}
