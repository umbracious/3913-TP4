import currencyConverter.Currency;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//Classe de tests pour la classe Currency en utilisant des tests de boîte blanche
public class CurrencyTest {

    // Tests boîte noire

    // Regular test case
    @Test
    void testCasRegulier() {
        Double amount = 100.0;
        Double exchangeValue = 1.32;
        Double result = Currency.convert(amount, exchangeValue);
        assertEquals(132.0, result, 0.01);
    }

    // Test case where input amount is below 0
    @Test
    void testInputBelowZero() {
        Double amount = -100.0;
        Double exchangeValue = 1.32;
        Double result = Currency.convert(amount, exchangeValue);
        assertEquals(-132.0, result, 0.01);
    }

    // Test case where input amount is above 1 000 000
    @Test
    void testInputAboveOneMillion () {
        Double amount = 10000000.0;
        Double exchangeValue = 1.32;
        Double result = Currency.convert(amount, exchangeValue);
        assertEquals(13200000.0, result, 0.01);
    }

    // Test case where input value is equal to 1 000 000
    @Test
    void testInputEqualsOneMillion () {
        Double amount = 1000000.0;
        Double exchangeValue = 1.32;
        Double result = Currency.convert(amount, exchangeValue);
        assertEquals(1320000.0, result, 0.01);
    }

    // Test case where input value is equal to zero
    @Test
    void testInputEqualsZero () {
        Double amount = 0.0;
        Double exchangeValue = 1.32;
        Double result = Currency.convert(amount, exchangeValue);
        assertEquals(0.0, result, 0.01);
    }

    // Tests boîte blanche

    //Teste la conversion avec une valeur de change positive
    @Test
    void testConvertWithPositiveExchangeValue() {
        Currency.init();
        Double amount = 100.0;
        Double positiveExchangeValue = 1.5;
        Double result = Currency.convert(amount, positiveExchangeValue);
        assertTrue(result > 0, "La conversion devrait être positive");
    }

    //Teste la conversion avec une valeur de change nulle
    @Test
    void testConvertWithZeroExchangeValue() {
        Currency.init();
        Double amount = 100.0;
        Double zeroExchangeValue = 0.0;
        Double result = Currency.convert(amount, zeroExchangeValue);
        assertEquals(0.0, result, 0.01, "La conversion devrait " +
                "être zéro avec un taux de change nul");
    }

    //Teste la conversion pour couvrir les instructions
    @Test
    void testConvertInstructionsCoverage() {
        Currency.init();
        Double amount = 100.0;
        Double exchangeValue = 1.5;
        Double result = Currency.convert(amount, exchangeValue);
        assertEquals(150.0, result, 0.01);
    }

    //Teste la conversion pour couvrir les chemins de contrôle meme chose que pour les instructions
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
//pour les criteres de jeux manquants il y a une grande similarité..

}

/**
 * Documentation JUnit :
 * - https://www.guru99.com/white-box-testing.html
 * - https://www.softwaretestinghelp.com/white-box-testing-techniques-with-example/
 * - https://www.softwaretestinghelp.com/junit-assertions/
 * - https://www.parasoft.com/blog/junit-tutorial-setting-up-writing-and-running-java-unit-tests/
 *
 * Pour les tests :
 * - https://www.baeldung.com/junit-5
 */
