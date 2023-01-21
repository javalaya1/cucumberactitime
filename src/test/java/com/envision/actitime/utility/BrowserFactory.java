package com.envision.actitime.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class BrowserFactory {


    //  private static WebDriver driver = null;
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    static String rm;

    private static void openChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        //String rm = PropertyFileReader.getPropertyValue("actitime.runmode");
        if (rm.equalsIgnoreCase("headless")) {
            co.addArguments(rm);
        }
//        driver = new ChromeDriver();
        driver.set(new ChromeDriver(co));
    }

    private static void openFirefoxBrowser() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions co = new FirefoxOptions();
        // String rm = PropertyFileReader.getPropertyValue("actitime.runmode");
        if (rm.equalsIgnoreCase("headless")) {
            co.addArguments(rm);
        }
        // driver = new FirefoxDriver(co);
        driver.set(new FirefoxDriver(co));
    }

    private static void openEdgeBrowser() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions co = new EdgeOptions();
//        String rm = PropertyFileReader.getPropertyValue("actitime.runmode");
//        if (rm.equalsIgnoreCase("headless")) {
//            co.addArguments(rm);
//        }
        // driver = new EdgeDriver(co);
        driver.set(new EdgeDriver(co));
    }


    public static WebDriver getBrowser(String browserName) {
        switch (browserName.toLowerCase().intern()) {
            case "chrome":
                openChromeBrowser();
                break;
            case "firefox":
                openFirefoxBrowser();
                break;
            case "edge":
                openEdgeBrowser();
                break;
        }
        return driver.get();
    }

    public static WebDriver getBrowser(String browserName, String runMode) {
        rm = runMode;
        return getBrowser(browserName);
    }


    public static WebDriver getBrowser() {

        return driver.get();
    }

    public static void launchApplication(String url) {
        driver.get().get(url);
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.get().manage().window().maximize();
    }

    public static void closeCurrentWindow() {
        driver.get().close();
    }

    public static void closeAllWindow() {
        driver.get().quit();
    }

}
