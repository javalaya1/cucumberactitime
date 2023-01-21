package com.envision.actitime.stepsdefs;


import com.envision.actitime.pageobjects.LoginPage;
import com.envision.actitime.pageobjects.TimeTrackPage;
import com.envision.actitime.utility.BrowserFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.Browser;
import org.testng.Assert;

public class LoginPageStepDefs {

    LoginPage lp = new LoginPage(BrowserFactory.getBrowser());

    @Given("user enters {string} as user id")
    public void user_enters_as_user_id(String usernameInputValue) {
        lp.enterUserName(usernameInputValue);
    }

    @Given("user enters {string} as password")
    public void user_enters_as_password(String passwordInputValue) {
        lp.enterPassword(passwordInputValue);
    }

    @When("user click on login button")
    public void user_click_on_login_button() {
        lp.clickLoginButton();
    }

    TimeTrackPage ttp = new TimeTrackPage(BrowserFactory.getBrowser());

    @Then("User  should see the home page title as {string}")
    public void user_should_see_the_home_page_title_as_acti_time_enter_time_track(String expectedTitle) {
        String actualTitle = ttp.getPageTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Then("User should see the error message as {string}")
    public void user_should_see_the_error_message_as(String string) {

    }

}
