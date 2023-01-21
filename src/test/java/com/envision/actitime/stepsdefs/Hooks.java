package com.envision.actitime.stepsdefs;

import com.envision.actitime.utility.BrowserFactory;
import com.envision.actitime.utility.PropertyFileReader;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;

public class Hooks {
    WebDriver driver;

    @Before
    public void openBrowser() {
        String brname = PropertyFileReader.getPropertyValue("actitime.browsername");
        String rmode = PropertyFileReader.getPropertyValue("actitime.runmode");
        this.driver = BrowserFactory.getBrowser(brname,rmode);

//        String url = PropertyFileReader.getPropertyValue("actitime.url");
//        BrowserFactory.launchApplication(url);
    }

    @After
    public void closeBrowser() {
        BrowserFactory.closeCurrentWindow();
    }

    @AfterAll
    public static void before_or_after_all(){
        BrowserFactory.closeAllWindow();
    }
}
