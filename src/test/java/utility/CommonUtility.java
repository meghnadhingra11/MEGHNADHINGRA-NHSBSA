package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class CommonUtility {

	
	 /**
     * This method is used to get the values from configuration file.
     *
     * @author meghnak
     * @param String, String
     * @return String
     */
    public static String getPropertyValue(String fileName, String propertyName) {
        Properties properties = new Properties();
        try {
            String current = new java.io.File(".").getCanonicalPath();
            fileName = fileName.replace("./", "/");
            InputStream inputStream = new FileInputStream(current + fileName);
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println(e);
        }
        return properties.getProperty(propertyName);
    }

    /**
     * This method is used to wait for the element.
     *
     * @author meghnak
     * @param WebDriver, int, WebElement
     */
    public static void waitForElementToBeVisibleFastAndFluent(WebDriver driver, int timeout, WebElement element) {
        FluentWait<WebDriver> wait =
                new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(timeout)).pollingEvery(Duration.ofMillis(10)).ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * This method is used to generate the number.
     *
     * @author meghnak
     * @param int, int
     */
    public static String generateRandomIntInRange(int min, int max) {
        return Integer.toString(ThreadLocalRandom.current().nextInt(min, max + 1));
    }

}
