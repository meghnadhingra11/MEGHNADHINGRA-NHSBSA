package invocation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.CommonUtility;

public class BrowserInvoke extends CommonUtility {

	 public static WebDriver finalDriver = null;

	    public static WebDriver browserInitialise() {
	        String browserIntialize = CommonUtility.getPropertyValue("./data/configuration.properties", "browser");
	        WebDriver driver = null;
	        if (browserIntialize.equalsIgnoreCase("chrome")) {
	        	ChromeOptions opt = new ChromeOptions();
	        	opt.addArguments("--remote-allow-origins=*");
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver(opt);
	        } else {
	            WebDriverManager.firefoxdriver().setup();
	            driver = new FirefoxDriver();
	        }
	        driver.manage().window().maximize();
	        return driver;
	    }
	}

