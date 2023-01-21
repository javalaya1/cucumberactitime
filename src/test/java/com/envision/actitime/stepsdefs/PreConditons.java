package com.envision.actitime.stepsdefs;

import com.envision.actitime.utility.BrowserFactory;
import io.cucumber.java.en.Given;

public class PreConditons {
    @Given("user launches the url {string}")
    public void user_launches_the_url(String url) {
        BrowserFactory.launchApplication(url);
    }
}
