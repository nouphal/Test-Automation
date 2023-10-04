import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoogleFinacePageTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");

        // Initialize the Chrome WebDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testStockSymbols() {
        // Open the Google Finance webpage
        driver.get("https://www.google.com/finance");

        // Verify the page title
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Google Finance", "Page title is not as expected.");

        // Retrieve stock symbols listed under the section "You may be interested in"
        List<WebElement> stockSymbolElements = driver.findElements(By.xpath("//div[@class='YMlKec fxKbKc']//a"));
        List<String> actualStockSymbols = getStockSymbols(stockSymbolElements);

        // Given Test Data as Expected Stock Symbols
        List<String> expectedStockSymbols = Arrays.asList("NFLX", "MSFT", "TSLA");

        // Compare stock symbols
        List<String> missingInExpected = new ArrayList<>();
        List<String> missingInActual = new ArrayList<>();

        for (String symbol : actualStockSymbols) {
            if (!expectedStockSymbols.contains(symbol)) {
                missingInExpected.add(symbol);
            }
        }

        for (String symbol : expectedStockSymbols) {
            if (!actualStockSymbols.contains(symbol)) {
                missingInActual.add(symbol);
            }
        }

        // Print missing stock symbols
        System.out.println("Stock symbols in (3) but not in expectedStockSymbols: " + missingInExpected);
        System.out.println("Stock symbols in expectedStockSymbols but not in (3): " + missingInActual);
    }

    @AfterClass
    public void endTest() {
        // Quit the WebDriver
        driver.quit();
    }

    private List<String> getStockSymbols(List<WebElement> elements) {
        List<String> symbols = new ArrayList<>();
        for (WebElement element : elements) {
            symbols.add(element.getText());
        }
        return symbols;
    }
}
