package Definitions;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;
import java.time.Duration;
import io.cucumber.java.en.*;

public class priority {
    private WebDriver driver;
    private WebDriverWait wait;

    @Given("browser is open for priority")
    public void browser_is_open() {
        System.setProperty("webdriver.gecko.marionette", "E:\\Testing\\src\\test\\resources\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @And("user is logged in for priority")
    public void user_is_logged_in() throws InterruptedException {
        driver.navigate().to("http://127.0.0.1:8000/login");
        Thread.sleep(2000);
        driver.findElement(By.id("email")).sendKeys("fathimaps521050@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Fathima@123");
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);
    }

    @When("user navigates to budget page for priority")
    public void user_navigates_to_budget_page() {
        driver.navigate().to("http://127.0.0.1:8000/budget/optimize/");
    }

    @Then("user clicks on edit priority")
    public void user_clicks_edit_priority() {
        WebElement editPriorityButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[contains(., 'Edit Priority')]")));
        editPriorityButton.click();
    }

    @When("user selects new priority")
    public void user_selects_priority() {
        WebElement prioritySelect = wait.until(ExpectedConditions.elementToBeClickable(
            By.id("priority_level")));
        Select select = new Select(prioritySelect);
        select.selectByValue("2"); // Select Medium Priority
    }

    @And("user saves the changes")
    public void user_saves_changes() {
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[contains(text(), 'Save changes')]")));
        saveButton.click();
    }

    @Then("priority should be updated successfully")
    public void verify_priority_update() {
        WebElement priorityBadge = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//span[contains(@class, 'badge') and contains(text(), 'Priority: 2')]")));
        Assert.assertTrue("Updated priority should be visible", priorityBadge.isDisplayed());
    }

    @And("close browser for priority")
    public void close_browser() {
        if (driver != null) {
            driver.quit();
        }
    }
}