package Definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

public class feedback {
    WebDriver driver = null;

    @Given("browser is openx")
    public void browser_is_openx() {
        System.out.println("Inside step-Browser is open");
        System.setProperty("webdriver.gecko.marionette", "E:\\Testing\\src\\test\\resources\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @And("user is on login pagex")
    public void user_is_on_login_pagex() throws Exception {
        driver.navigate().to("http://127.0.0.1:8000/login");
        Thread.sleep(2000);
    }

    @When("user enters username and passwordx")
    public void user_enters_username_and_passwordx() throws Throwable {
        driver.findElement(By.id("email")).sendKeys("fathimaps521050@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Fathima@123");
    }

    @And("user clicks on loginx")
    public void user_clicks_on_loginx() {
        driver.findElement(By.id("login")).click();
    }

    @Then("user navigates to feedback form")
    public void user_navigates_to_feedback_form() {
        // Assuming there's a URL pattern for the feedback form
        driver.navigate().to("http://127.0.0.1:8000/feedback/98/");
    }

    @When("user submits feedback")
    public void user_submits_feedback() {
        // Create wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        try {
            // Click on star labels
            List<WebElement> ratingGroups = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("rating-stars")));
            for (WebElement group : ratingGroups) {
                WebElement fiveStarLabel = group.findElement(By.cssSelector("label[class='star-label']:last-child"));
                wait.until(ExpectedConditions.elementToBeClickable(fiveStarLabel));
                executor.executeScript("arguments[0].scrollIntoView(true);", fiveStarLabel);
                executor.executeScript("arguments[0].click();", fiveStarLabel);
            }

            // Fill in feedback text
            List<WebElement> textareas = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("feedback-textarea")));
            for (WebElement textarea : textareas) {
                wait.until(ExpectedConditions.elementToBeClickable(textarea));
                executor.executeScript("arguments[0].scrollIntoView(true);", textarea);
                textarea.sendKeys("Great service! Very satisfied with the experience.");
            }

            // Submit form
            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("submit-btn")));
            executor.executeScript("arguments[0].scrollIntoView(true);", submitButton);
            submitButton.click();

        } catch (Exception e) {
            System.out.println("Error during feedback submission: " + e.getMessage());
            throw e;
        }
    }
    @Then("feedback submission should be successful")
    public void feedback_submission_should_be_successful() {
        
    }

    @And("close browserx")
    public void close_browserx() {
        driver.quit();
    }
}