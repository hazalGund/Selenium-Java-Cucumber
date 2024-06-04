package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import utils.ConfigReader;
import utils.DriverManager;
import utils.HelperClass;

public class AccentureSteps {

    private WebDriver driver;
    private HomePage hm;

    @Given("I am on the Accenture homepage")
    public void i_am_on_the_Accenture_homepage() {

        //launch Browser
        driver = DriverManager.getDriver();
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
        if (gridName.equals("hero")) {
            element = HelperClass.waitForElementWithFluentWait(driver, By.id(ConfigReader.getProperty(gridName)));
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

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }

}
