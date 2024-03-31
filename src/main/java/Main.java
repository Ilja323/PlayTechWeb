import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\iljas\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Step 1: Open the webpage.
        driver.get("https://www.playtech.ee");

        //Step 2: Click on the "Who we are" tab.
        WebElement whoWeAreTab = driver.findElement(By.xpath("//a[@href='/who-we-are' and contains(@class, 'menu-item')]"));
        whoWeAreTab.click();

        // Scroll to the "Global presence" element.
        WebElement globalPresence = driver.findElement(By.xpath("//h2[contains(text(), 'Global presence')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(globalPresence).perform();

        //Step 3:  Verify if the "Global presence" is shown on the page.
        if (globalPresence.isDisplayed()) {
            System.out.println("Element is present on the web page");
        } else {
            System.out.println("Element is Not present on the web page");
        }

        // Close the browser.
        driver.quit();
    }
}







