package utils;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class HelperClass {

    public static void assertPageTitle(WebDriver driver, String expectedTitle) {
        assertEquals(expectedTitle, driver.getTitle());
    }

    public static WebElement waitForElementWithFluentWait(WebDriver driver, final By locator) {

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(12))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until((WebDriver webDriver) -> driver.findElement(locator));
        return element;

    }

    public static class utils {

        public utils() {
        }
    }
}
