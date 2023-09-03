package api_learning;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {

    public static void main(String[] args) {
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
//        driver.manage().window().maximize();
        driver.get("https://google.com");

        try {
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }


        driver.quit();

    }
}
