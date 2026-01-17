package Definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class invitation {

    WebDriver driver = null;

    @Given("browser is openss")
    public void browser_is_open() {
        System.out.println("Inside step - Browser is open");
        System.setProperty("webdriver.gecko.marionette","E:\\Testing\\src\\test\\resources\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @And("user is on login pagess")
    public void user_is_on_login_page() throws Exception {
        driver.navigate().to("http://127.0.0.1:8000/login");
        Thread.sleep(2000);  // Wait for the page to load
    }

    @When("user enters username and passwordss")
    public void user_enters_username_and_password() throws Throwable {
        driver.findElement(By.id("email")).sendKeys("fathimaps521050@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Fathima@123");
    }

    @And("user clicks on loginss")
    public void user_clicks_on_login() {
        driver.findElement(By.id("login")).click();
    }

    @Then("user clicks on Planning")
    public void user_clicks_on_Planning() {
        driver.findElement(By.id("Planning")).click();  // Ensure the ID matches your HTML
    }

    @And("user clicks on Invitation")
    public void user_clicks_on_Invitation() {
        driver.findElement(By.id("Invitation")).click();  // Ensure the ID matches your HTML
    }

    @When("user enters event name, event date, event time, venue, venue address, phone number, location link,guestname,guestemail, and event description")
    public void user_enters_event_details() throws Throwable {
        driver.findElement(By.id("event_name")).sendKeys("Wedding");
        driver.findElement(By.id("event_date")).sendKeys("2024-12-20");  // Use YYYY-MM-DD format
        driver.findElement(By.id("event_time")).sendKeys("17:19");
        driver.findElement(By.id("venue")).sendKeys("KMA Hall");
        driver.findElement(By.id("venue_address")).sendKeys("Padipurackal (H), Edakkunnam P.O, Kanjirappally");
        driver.findElement(By.id("phone_number")).sendKeys("9744685155");
        driver.findElement(By.id("location_link")).sendKeys("https://maps.app.goo.gl/a67tBVPPw63MUMdu7");
        driver.findElement(By.id("event_description")).sendKeys("We heartily welcome one and all");
        driver.findElement(By.id("guest_name")).sendKeys("fathima P.S");
        driver.findElement(By.id("guest_email")).sendKeys("fathimaps521050@gmail.com");
    }

    @And("user clicks on send invitation")
    public void user_clicks_on_send_invitation() {
        driver.findElement(By.id("submit")).click();  // Ensure the ID matches your HTML
    }
}