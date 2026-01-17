package Definitions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Assert;
import io.cucumber.java.en.*;

public class blog {
    private WebDriver driver;
    private WebDriverWait wait;

    @Given("browser is openzz")
    public void browser_is_open() {
        System.setProperty("webdriver.gecko.marionette", "E:\\Testing\\src\\test\\resources\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @And("user is logged inz")
    public void user_is_logged_in() throws InterruptedException {
        driver.navigate().to("http://127.0.0.1:8000/login");
        Thread.sleep(2000);
        driver.findElement(By.id("email")).sendKeys("fathimaps521050@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Fathima@123");
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);
    }

    @When("user navigates to wedding blogs page")
    public void user_navigates_to_wedding_blogs_page() {
        driver.navigate().to("http://127.0.0.1:8000/wedding-blogs/");
    }

    @Then("user should see the wedding blog banner")
    public void user_should_see_wedding_blog_banner() {
        WebElement banner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("blog-banner")));
        Assert.assertTrue("Banner should be displayed", banner.isDisplayed());
        Assert.assertTrue(banner.findElement(By.tagName("h1")).getText().contains("Wedding Blog"));
    }

   

    @When("user clicks on a category pill")
    public void user_clicks_on_category_pill() {
        WebElement categoryPill = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".category-pill")));
        categoryPill.click();
    }

    @Then("filtered results should be displayed")
    public void filtered_results_should_be_displayed() {
        // Wait for the page to reload with filtered results
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("blog-grid-section")));
        // Verify active category pill
        WebElement activePill = driver.findElement(By.cssSelector(".category-pill.active"));
        Assert.assertTrue("Category pill should be active", activePill.isDisplayed());
    }

    @When("user clicks on a blog post")
    public void user_clicks_on_blog_post() throws Exception {
        try {
            // Wait for blog cards to be present
            WebElement blogPost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".blog-card")));
            
            // Scroll the blog post into view using JavaScript
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", blogPost);
            
            // Add a small pause to allow smooth scrolling to complete
            Thread.sleep(1000);
            
            // Click using JavaScript executor
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", blogPost);
            
            // Alternative: Click the link inside the blog card
            WebElement blogLink = blogPost.findElement(By.cssSelector(".card-media"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", blogLink);
            
        } catch (Exception e) {
            System.out.println("Error clicking blog post: " + e.getMessage());
            throw e;
        }
    }


    @Then("blog post details should be displayed")
    public void blog_post_details_should_be_displayed() {
    }

  
}