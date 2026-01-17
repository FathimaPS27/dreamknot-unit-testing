package Definitions;





import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;

public class AddToFavoritesSteps {

             WebDriver driver=null;

             @Given("browser is opens")

             public void browser_is_open() {

              System.out.println("Inside step-Browser is open");

              System.setProperty("webdriver.gecko.marionette","E:\\Testing\\src\\test\\resources\\drivers\\geckodriver.exe");

              driver=new FirefoxDriver();

              driver.manage().window().maximize();

              

             }

            

             @And("user is on login pages")

             public void user_is_on_login_page() throws Exception {

              driver.navigate().to("http://127.0.0.1:8000/login");

              Thread.sleep(2000);

              

             }

            

             @When("user enters username and passwords")

            public void user_enters_username_and_password() throws Throwable{

              driver.findElement(By.id("email")).sendKeys("fathimaps521050@gmail.com");

              driver.findElement(By.id("password")).sendKeys("Fathima@123");

             }

            

             @And("user clicks on logins")

             public void user_clicks_on_login() {

              driver.findElement(By.id("login")).click(); 
              }
             
             @Then("user clicks on view details")

             public void user_clicks_on_view_details() {

              driver.findElement(By.id("viewdetails")).click(); 
              }
             
             @And("user clicks on addToFavorite")

             public void user_clicks_on_addToFavorite() {

              driver.findElement(By.id("addToFavorite")).click(); 
              }
             
             
             @Then("user clicks on account")
             public void user_clicks_on_account() {
                 driver.findElement(By.id("account")).click();  // Click on the account dropdown
             }

             @And("user clicks on favorite list")
             public void user_clicks_on_favorite_list() {
                 driver.findElement(By.id("favourite")).click();  // Click on the favorite list link
               
             }

                
}