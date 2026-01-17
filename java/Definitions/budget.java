package Definitions;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import io.cucumber.java.en.*;

public class budget {
    private WebDriver driver;
    private WebDriverWait wait;

    @Given("browser is open for budget")
    public void browser_is_open() {
        System.setProperty("webdriver.gecko.marionette", "E:\\Testing\\src\\test\\resources\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @And("user is logged in for budget")
    public void user_is_logged_in() throws InterruptedException {
        driver.navigate().to("http://127.0.0.1:8000/login");
        Thread.sleep(2000);
        driver.findElement(By.id("email")).sendKeys("fathimaps521050@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Fathima@123");
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);
    }

    @When("user navigates to budget optimization page")
    public void user_navigates_to_budget_page() {
        driver.navigate().to("http://127.0.0.1:8000/budget/optimize/");
    }

    @Then("user should see the budget form")
    public void user_should_see_budget_form() {
    	
    	 WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(
    	            By.xpath("//button[@onclick='showBudgetForm()']")));
    	        editButton.click();
    }
   
    

    @When("user fills in the budget form")
    public void user_fills_in_budget_form() {
        // Fill in total budget
        WebElement totalBudget = driver.findElement(By.name("total_budget"));
        totalBudget.sendKeys("500000");

        // Fill in guest count
        WebElement guestCount = driver.findElement(By.name("guest_count"));
        guestCount.sendKeys("100");

        // Select wedding type
        WebElement weddingType = driver.findElement(By.name("wedding_type"));
        weddingType.sendKeys("North_Indian");

        // Fill in wedding date (current date + 6 months)
        String futureDate = java.time.LocalDate.now().plusMonths(6).toString();
        WebElement weddingDate = driver.findElement(By.name("wedding_date"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1]", weddingDate, futureDate);

        // Fill in location
        WebElement location = driver.findElement(By.name("location"));
        location.sendKeys("Mumbai");
    }

    @And("user submits the budget form")
    public void user_submits_budget_form() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("button[type='submit']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        submitButton.click();
    }

 
  
}