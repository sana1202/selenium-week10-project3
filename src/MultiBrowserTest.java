import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/*
BaseUrl = http://the-internet.herokuapp.com/login
1. Setup Chrome browser.
2. Open URL.
3. Print the title of the page.
4. Print the current url.
5. Print the page source.
6. Enter the email to email field.
7. Enter the password to password field.
8. Click on Login Button.
9. Print the current url.
10. Refresh the page.
11. Close the browser.
 */
public class MultiBrowserTest {

    //BaseUrl = http://the-internet.herokuapp.com/login
    static String baseUrl = "http://the-internet.herokuapp.com/login";
    static String browser = "Chrome";
    //static String browser = "Firefox";
    //static String browser = "Edge";
    //static String browser = "Safari";

    public static void main(String[] args) throws InterruptedException {

        //1. Setup Chrome browser
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();
        //WebDriver driver = new EdgeDriver();
        //WebDriver driver = new SafariDriver();
        System.setProperty("webdriver.chrome.driver" , "chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        //2. Open URL.
        driver.get(baseUrl);

        //3. Print the title of the page
        String title = driver.getTitle();
        System.out.println("Title of hte Page:" +title);

        //4. Print the current url
        System.out.println(baseUrl);

        //5. Print the page source
        String pageSource = driver.getPageSource();
        System.out.println(driver.getPageSource());

        //6. Enter the email to email field
        WebElement emailField = driver.findElement(By.id("username"));
        emailField.sendKeys("tomsmith");

        //7. Enter the password to password field
        WebElement passField = driver.findElement(By.id("password"));
        passField.sendKeys("SuperSecretPassword");
        Thread.sleep(3000);

        //8. Click on Login Button
        WebElement loginLink = driver.findElement(By.xpath("//button[@type='submit']"));
        loginLink.click();
        Thread.sleep(3000);

        //9. Print the current url
        System.out.println("The current Url: "+ driver.getCurrentUrl());

        //10. Refresh the page
        driver.navigate().refresh();

        //11. Close the browser
        driver.quit();
    }

}
