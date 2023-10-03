import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class GoogleFinanceAutomation {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");

        // Initialize the Chrome WebDriver
        WebDriver driver = new ChromeDriver();

        // Open the Google Finance webpage
        driver.get("https://www.google.com/finance");

        // Verify the page title
        String pageTitle = driver.getTitle();
        if (!pageTitle.equals("Google Finance")) {
            System.out.println("Page title is not as expected: " + pageTitle);
            driver.quit();
            return;
        }

        // Retrieve stock symbols listed under the section "You may be interested in info"
        List<WebElement> stockSymbolElements = driver.findElements(By.xpath("//div[@class='YMlKec fxKbKc']//a"));
        List<String> actualStockSymbols = getStockSymbols(stockSymbolElements);

        // Given Test Data
        List<String> expectedStockSymbols = Arrays.asList("NFLX", "MSFT", "TSLA", /* Add more symbols here */);

        // Compare stock symbols
        compareStockSymbols(expectedStockSymbols, actualStockSymbols);

        // Quit the WebDriver
        driver.quit();
    }

    private static List<String> getStockSymbols(List<WebElement> elements) {
        // Extract and return stock symbols from WebElement list
        // You may need to modify this based on the actual HTML structure of the page
        // Assuming that the stock symbols are in the innerText of the 'a' elements
        return elements.stream()
                .map(WebElement::getText)
                .toList();
    }

    private static void compareStockSymbols(List<String> expected, List<String> actual) {
        System.out.println("Stock symbols in (3) but not in expectedStockSymbols:");
        actual.stream()
                .filter(symbol -> !expected.contains(symbol))
                .forEach(System.out::println);

        System.out.println("\nStock symbols in expectedStockSymbols but not in (3):");
        expected.stream()
                .filter(symbol -> !actual.contains(symbol))
                .forEach(System.out::println);
    }
}
