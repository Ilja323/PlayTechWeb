import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileWriter;
import java.io.IOException;


public class Bonus {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\iljas\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testGlobalPresence() {
        // Step 1: Open the webpage
        driver.get("https://www.playtech.ee");

        // Switch the language to (ET).
        WebElement languageSelector = driver.findElement(By.xpath("//div[@class='language-select-inner bg-primary']"));
        languageSelector.click();
        WebElement estonianOption = driver.findElement(By.xpath("//a[@class='styled-link' and text()='ET']"));
        estonianOption.click();

        //Step 2: Use coordinates to click on the "Meist" tab.
        WebElement meistTab = driver.findElement(By.xpath("//a[@href='/meist' and contains(@class, 'menu-item')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(meistTab, 6, 3).click().build().perform();

        // Scroll to the "Meie asukond" element.
        WebElement meieAsukond = driver.findElement(By.xpath("//h2[contains(text(), 'Meie asukohad')]"));
        actions.moveToElement(meieAsukond).perform();

        //Step 3:  Verify if the "Meie asukond" is shown on the page.
        // Write the result to a .txt file.
        try {
            FileWriter writer = new FileWriter("result.txt");
            if (meieAsukond.isDisplayed()) {
                writer.write("Element is present on the web page");
            } else {
                writer.write("Element is Not present on the web page");
            }
            writer.close();
            System.out.println("Result exported to result.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        // Close the browser.
        driver.quit();
    }
}


