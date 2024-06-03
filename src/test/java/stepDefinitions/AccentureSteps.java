package stepDefinitions;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;
import utils.ConfigReader;
import utils.HelperClass;

public class AccentureSteps {

    public WebDriver driver;
    HomePage hm;

    @Given("I am on the Accenture homepage")
    public void i_am_on_the_Accenture_homepage() {

        //setup
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        //launch Browser
        driver = new ChromeDriver(options);
        hm = new HomePage(driver);


        String url = ConfigReader.getProperty("baseUrl");
        driver.get(url);
        hm.maximizeWindow();

       //Assert Title
       HelperClass.assertPageTitle(driver, ConfigReader.getProperty("homepageTitle"));
    }


    @When("I click {string} grid")
    public void I_click_grid(String gridName) {
        WebElement element;
        if(gridName.equals("hero")) {
            element =HelperClass.waitForElementWithFluentWait(driver, By.id(ConfigReader.getProperty(gridName)));
        } else {
            String cssSelector = "button.rad-content-grid-card__front-toggle[aria-label='" + gridName + "']";
            element = HelperClass.waitForElementWithFluentWait(driver, By.cssSelector(cssSelector));
        }
        element.click();    
    }

    @Then("I should see the {string} page")
    public void I_should_see_the_page(String pageTitle) {
         HelperClass.assertPageTitle(driver, pageTitle);
    }

    @AfterAll
    public void tearDown() {
    if (driver != null) {
        driver.quit();
    }
}


}
