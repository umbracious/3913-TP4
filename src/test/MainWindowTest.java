import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainWindowTest {

    // Tests boîte noire

    // Normal use case
    @Test
    void testInputBelowZero {
        MainWindow mainWindow = new MainWindow();
        Double result = mainWindow.convert("USD", "JPY", mainWindow.currencies, 1000.0);

        assertEquals(123540.0, result, 0.01)
    }

    // Test where input value is below zero
    @Test
    void testInputBelowZero {
        MainWindow mainWindow = new MainWindow();
        Double result = mainWindow.convert("USD", "JPY", mainWindow.currencies, -1000.0);

        assertEquals(-123540.0, result, 0.01)
    }

    // Test where input value is above 1 000 000
    @Test
    void testInputBelowZero {
        MainWindow mainWindow = new MainWindow();
        Double result = mainWindow.convert("USD", "JPY", mainWindow.currencies, 10000000.0);

        assertEquals(1235400000.0, result, 0.01)
    }

    // Test where input value is equal to 0
    @Test
    void testInputBelowZero {
        MainWindow mainWindow = new MainWindow();
        Double result = mainWindow.convert("USD", "JPY", mainWindow.currencies, 0.0);

        assertEquals(0.0, result, 0.01)
    }

    // Test where input value is equal to 1 000 000
    @Test
    void testInputBelowZero {
        MainWindow mainWindow = new MainWindow();
        Double result = mainWindow.convert("USD", "JPY", mainWindow.currencies, 1000000.0);

        assertEquals(123540000.0, result, 0.01)
    }

    // Test where the input currency isn't in the list
    @Test
    void testInputBelowZero {
        MainWindow mainWindow = new MainWindow();
        Double result = mainWindow.convert("CAD", "JPY", mainWindow.currencies, 1000.0);

        assertEquals(0.0, result, 0.01)
    }

    // Test where the output currency isn't in the list
    @Test
    void testInputBelowZero {
        MainWindow mainWindow = new MainWindow();
        Double result = mainWindow.convert("USD", "CAD", mainWindow.currencies, 1000.0);

        assertEquals(0.0, result, 0.01)
    }


    //Tests boîte blanche

    //test boite blanche pour currencyConverter.MainWindow.convert(String, String, ArrayList<Currency>, Double)
    @Test
    void testConvertInstructionsCoverage() {
        MainWindow mainWindow = new MainWindow();
        Double result = mainWindow.convert("USD", "EUR", mainWindow.currencies, 100.0);

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



    @Test
    void testConvertInstructionsCoverage() {
        MainWindow mainWindow = new MainWindow();
        Double result = MainWindow.convert("USD", "EUR", mainWindow.currencies, 100.0);

        assertEquals(93.0, result, 0.01);


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
 
         assertEquals(0.0, result, 0.01, "La conversion devrait être zéro avec un montant négatif");
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
