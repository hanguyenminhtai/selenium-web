package driver;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    public static WebDriver getChromeDriver(){

        String currentProjectLocation = System.getProperty("user.dir");
        String chromDriverLocation = "";
        if(OS.isFamilyWindows()){
            chromDriverLocation = currentProjectLocation + "\\src\\test\\resources\\drivers\\chromedriver.exe";
        }

        if(OS.isFamilyMac()){
            chromDriverLocation = currentProjectLocation + "/src/test/resources/drivers/chromedriver";
        }

        if(chromDriverLocation.isEmpty()){
            throw new IllegalArgumentException("cant");
        }

        System.setProperty("qw", chromDriverLocation);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--inc");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return driver;
    }
}
