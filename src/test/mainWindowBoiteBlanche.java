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
}
