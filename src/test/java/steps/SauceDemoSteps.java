package steps;

import java.util.concurrent.TimeUnit;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceDemoSteps {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user login in https:\\/\\/www.saucedemo.com\\/")
    public void user_login_in_https_www_saucedemo_com() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(500);
    }

    @Given("user should be open https:\\/\\/www.saucedemo.com\\/ in web browser")
    public void user_should_be_open_https_www_saucedemo_com_in_web_browser() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @When("user input valid username")
    public void user_input_valid_username() throws Exception {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(500);
    }

    @When("user input invalid username")
    public void user_input_invalid_username() throws Exception {
        driver.findElement(By.id("user-name")).sendKeys("wrong_user");
        Thread.sleep(500);
    }

    @When("user input empty username")
    public void user_input_empty_username() throws Exception {
        driver.findElement(By.id("user-name")).sendKeys("");
        Thread.sleep(500);
    }

    @And("user input valid password")
    public void user_input_valid_password() throws Exception {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(500);
    }

    @And("user click button Login")
    public void user_click_button_login() throws Exception {
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(500);
    }

    @Then("home page should be displayed")
    public void home_page_should_be_displayed() {
        Assert.assertEquals("Products",driver.findElement(By.className("title")).getText());
        System.out.println("Scenario : Login as valid username");
        driver.quit();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        try {
            driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        } catch (NoSuchElementException e) {
            System.out.println("Scenario : Login as valid username");
        }
            System.out.println("Scenario : Login as invalid username");
        driver.quit();
    }

    @Then("empty username message should be displayed")
    public void empty_username_message_be_displayed() {
        Assert.assertEquals("Epic sadface: Username is required",driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText());
        System.out.println("Scenario : Login with empty username");
        driver.quit();
    }

    @Then("empty password message should be displayed")
    public void empty_password_message_be_displayed() {
        Assert.assertEquals("Epic sadface: Password is required",driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText());
        System.out.println("Scenario : Login with empty password");
        driver.quit();
    }

    @When("user click button Add to Cart in first list product")
    public void user_click_button_add_to_cart_in_first_list_product() throws Exception {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        Thread.sleep(500);
    }

    @And("user click icon cart")
    public void user_click_icon_cart() throws Exception {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        Thread.sleep(500);
    }

    @And("user click checkout button")
    public void userClickCheckoutButton() throws Exception {
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        Thread.sleep(500);
    }

    @Then("Your Information page should be displayed")
    public void yourInformationPageShouldBeDisplayed() {
        Assert.assertEquals("Checkout: Your Information",driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText());
        System.out.println("Scenario : Checkout: Your Information");
        driver.quit();
    }

    @When("user click side menu button")
    public void userClickSideMenuButton() throws Exception {
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
        Thread.sleep(500);
    }

    @And("user click logout")
    public void userClickLogout() throws Exception {
        driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
        Thread.sleep(500);
    }

    @Then("login page should be displayed")
    public void loginPageShouldBeDisplayed() throws Exception {
        driver.findElement(By.xpath("//*[@id=\"login_button_container\"]"));
        System.out.println("Scenario : Logout");
        driver.quit();
    }

    @And("user input first name")
    public void userInputFirstName() throws Exception {
        driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("Rakamin");
        Thread.sleep(500);
    }

    @And("user input last name")
    public void userInputLastName() throws Exception {
        driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("SQA");
        Thread.sleep(500);
    }

    @And("user input postal code")
    public void userInputPostalCode() throws Exception {
        driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("123456");
        Thread.sleep(500);
    }

    @And("user click continue button")
    public void userClickContinueButton() throws Exception {
        driver.findElement(By.xpath("//*[@id='continue']")).click();
        Thread.sleep(500);
    }

    @Then("checkout overview page should be displayed")
    public void checkoutOverviewPageShouldBeDisplayed() {
        Assert.assertEquals("Checkout: Overview",driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText());
        System.out.println("Scenario : Checkout: Your Information");
        driver.quit();
    }

    @And("user click button remove in first list product")
    public void user_Click_Button_Remove_In_First_List_Product() throws Exception {
        driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']")).click();
        Thread.sleep(500);
    }

    @Then("product should be removed from cart")
    public void productShouldBeRemovedFromCart() throws Exception {
        Assert.assertNotEquals("Sauce Labs Backpack",driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText());
        System.out.println("Scenario : Removing product from cart");
        driver.quit();
    }

    @Then("Your Item should be in cart")
    public void yourItemShouldBeInCart() throws Exception{
        Assert.assertEquals("Sauce Labs Backpack",driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText());
        System.out.println("Scenario : Adding product to cart");
        driver.quit();
    }
}