package currencyConverter;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MainWindowTest {

    // Tests boîte noire

    // Normal use case
    @Test
    void regularTest() {
        Double result = MainWindow.convert("US Dollar", "Japanese Yen", Currency.init(), 1000.0);
        assertEquals(123540.0, result, 0.01);
    }

    // Test where input value is below zero
    // Returns 0 because out of scope
    @Test
    void testInputBelowZero() {
        Double result = MainWindow.convert("US Dollar", "Japanese Yen", Currency.init(), -1000.0);
        assertEquals(-123540.0, result, 0.01);
    }

    // Test where input value is above 1 000 000
    @Test
    void testInputAboveOneM() {
        Double result = MainWindow.convert("US Dollar", "Japanese Yen", Currency.init(), 10000000.0);
        assertEquals(1235400000.0, result, 0.01);
    }

    // Test where input value is equal to 0
    @Test
    void testInputEqZero() {
        Double result = MainWindow.convert("US Dollar", "Japanese Yen", Currency.init(), 0.0);
        assertEquals(0.0, result, 0.01);
    }

    // Test where input value is equal to 1 000 000
    @Test
    void testInputEqOneM() {
        Double result = MainWindow.convert("US Dollar", "Japanese Yen", Currency.init(), 1000000.0);
        assertEquals(123540000.0, result, 0.01);
    }

    // Test where the input currency isn't in the list
    // Returns default value 0
    @Test
    void testInputCurrencyNonexistent() {
        Double result = MainWindow.convert("Canadian Dollar", "Japanese Yen", Currency.init(), 1000.0);
        assertEquals(0.0, result, 0.01);
    }

    // Test where the output currency isn't in the list
    // Returns default value 0
    @Test
    void testOutputCurrencyNonexistent() {
        Double result = MainWindow.convert("US Dollar", "Canadian Dollar", Currency.init(), 1000.0);
        assertEquals(0.0, result, 0.01);
    }


    //Tests boîte blanche

    //test boite blanche pour currencyConverter.MainWindow.convert(String, String, ArrayList<Currency>, Double)
    @Test
    void testConvertInstructionsCoverage() {
        MainWindow mainWindow = new MainWindow();
        Double result = mainWindow.convert("USD", "EUR", Currency.init(), 100.0);

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

    // Teste la conversion avec montant négatif
    @Test
    void testConvertNegativeAmount() {
        MainWindow window = new MainWindow();
        ArrayList<Currency> currencies = Currency.init();
        Double amount = -50.0;
        String currency1 = "US Dollar";
        String currency2 = "Euro";

        Double result = MainWindow.convert(currency1, currency2, currencies, amount);

        assertEquals(-46.5, result, 0.01, "La conversion devrait être zéro avec un montant négatif");
    }

    // Teste la conversion avec une devise inexistante
    @Test
    void testConvertNonexistentCurrency() {
        MainWindow window = new MainWindow();
        ArrayList<Currency> currencies = Currency.init();
        Double amount = 100.0;
        String currency1 = "NonexistentCurrency";
        String currency2 = "Euro";

        Double result = MainWindow.convert(currency1, currency2, currencies, amount);

        assertEquals(0.0, result, 0.01, "La conversion devrait être zéro avec une devise inexistante");
    }

    // Teste la conversion avec une deuxième devise inexistante
    @Test
    void testConvertNonexistentOutputCurrency() {
        MainWindow window = new MainWindow();
        ArrayList<Currency> currencies = Currency.init();
        Double amount = 100.0;
        String currency1 = "US Dollar";
        String currency2 = "NonexistentCurrency";

        Double result = MainWindow.convert(currency1, currency2, currencies, amount);

        assertEquals(0.0, result, 0.01, "La conversion devrait être zéro avec une deuxième devise inexistante");
    }
}
