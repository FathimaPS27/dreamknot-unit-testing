package Definitions;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;

public class stepdefinition {

             WebDriver driver=null;

             @Given("browser is open")

             public void browser_is_open() {

              System.out.println("Inside step-Browser is open");

              System.setProperty("webdriver.gecko.marionette","E:\\Testing\\src\\test\\resources\\drivers\\geckodriver.exe");

              driver=new FirefoxDriver();

              driver.manage().window().maximize();

             }

             @And("user is on login page")

             public void user_is_on_login_page() throws Exception {

              driver.navigate().to("http://127.0.0.1:8000/login");

              Thread.sleep(2000);

             }

             @When("user enters username and password")

            public void user_enters_username_and_password() throws Throwable{

              driver.findElement(By.id("email")).sendKeys("fathimaps521050@gmail.com");

              driver.findElement(By.id("password")).sendKeys("Fathima@123");

             }

             @When("user clicks on login")

             public void user_clicks_on_login() {

              driver.findElement(By.id("login")).click(); }
}