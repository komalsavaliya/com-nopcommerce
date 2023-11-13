package nop_commerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Project-1 - ProjectName : com-nopcommerce
 * BaseUrl = https://demo.nopcommerce.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Navigate to Url.
 * “https://demo.nopcommerce.com/login?returnUrl=
 * %2F”
 * 7. Print the current url.
 * 8. Navigate back to the home page.
 * 9. Navigate to the login page.
 * 10. Print the current url.
 * 11. Refresh the page.
 * 12. Enter the email to email field.
 * 13. Enter the password to password field.
 * 14. Click on Login Button.
 * 15. Close the browser.
 */
public class NopCommerce {
    static String browser = "Chrome";
    static String baseUrl = "https://demo.nopcommerce.com/";
    static String loginUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
        driver.get(baseUrl);//Open URL
        driver.manage().window().maximize();//Window Maximize
        System.out.println(driver.getTitle());//Print the title of page
        System.out.println(driver.getCurrentUrl());//Print the Current URL
        System.out.println(driver.getPageSource());//Print the page source
        driver.navigate().to(loginUrl);//Navigate to URL
        System.out.println(driver.getCurrentUrl());//Print the current URL
        driver.navigate().back();//Navigate back to home page
        driver.navigate().to(loginUrl);//Navigate to the login page
        System.out.println(driver.getCurrentUrl());//Print the current URL
        driver.navigate().refresh();//Refresh the page

        //Enter email to email field
        WebElement emailFields = driver.findElement(By.id("Email"));
        emailFields.sendKeys("prime123@gmail.com");

        //Enter Password to password field
        WebElement passwordFields = driver.findElement(By.name("Password"));
        passwordFields.sendKeys("prime123");

        //Click on Login Button
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginButton.click();
        driver.quit();//Close the Browser
    }
}