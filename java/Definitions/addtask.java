package Definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class addtask {

    WebDriver driver = null;

    @Given("browser is opensss")
    public void browser_is_open() {
        System.out.println("Inside step - Browser is open");
        System.setProperty("webdriver.gecko.marionette","E:\\Testing\\src\\test\\resources\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @And("user is on login pagesss")
    public void user_is_on_login_page() throws Exception {
        driver.navigate().to("http://127.0.0.1:8000/login");
        Thread.sleep(2000);  // Wait for the page to load
    }

    @When("user enters username and passwordsss")
    public void user_enters_username_and_password() throws Throwable {
        driver.findElement(By.id("email")).sendKeys("fathimaps521050@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Fathima@123");
    }

    @And("user clicks on loginsss")
    public void user_clicks_on_login() {
        driver.findElement(By.id("login")).click();
    }

    @Then("user clicks on Planningsss")
    public void user_clicks_on_Planning() {
        driver.findElement(By.id("Planning")).click();  // Ensure the ID matches your HTML
    }

    @And("user clicks on to-do list")
    public void user_clicks_on_todolist() {
        driver.findElement(By.id("addtask")).click();  // Ensure the ID matches your HTML
    }

    @Then("user clicks on complete")
    public void user_clicks_on_complete() {
        // Assuming there may be multiple tasks, you might want to click the first complete button
        driver.findElement(By.cssSelector(".btn-success")).click();  // Click the first complete button
    }
}