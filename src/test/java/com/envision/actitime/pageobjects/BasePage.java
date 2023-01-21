package com.envision.actitime.pageobjects;


import com.envision.actitime.utility.CommonUtil;
import com.envision.actitime.utility.PropertyFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public WebElement getElement(String objectRepoValue) {
        String[] locator_locatorValue = objectRepoValue.split("::::");
        String locator = locator_locatorValue[0];
        String locatorValue = locator_locatorValue[1];
        WebElement element = null;
        switch (locator.toLowerCase().intern()) {
            case "id":
                element = driver.findElement(By.id(locatorValue));
                break;
            case "name":
                element = driver.findElement(By.name(locatorValue));
                break;
            case "classname":
                element = driver.findElement(By.className(locatorValue));
                break;
            case "linktext":
                element = driver.findElement(By.linkText(locatorValue));
                break;
            case "partiallink":
                element = driver.findElement(By.partialLinkText(locatorValue));
                break;
            case "xpath":
                element = driver.findElement(By.xpath(locatorValue));
                break;
            case "css":
                element = driver.findElement(By.cssSelector(locatorValue));
                break;
            case "tagname":
                element = driver.findElement(By.tagName(locatorValue));
                break;
        }
        return element;
    }


    public List<WebElement> getElementList(String objectRepoValue) {
        String[] locator_locatorValue = objectRepoValue.split("::::");
        String locator = locator_locatorValue[0];
        String locatorValue = locator_locatorValue[1];
        List<WebElement> elements = null;
        switch (locator.toLowerCase().intern()) {
            case "id":
                elements = new WebDriverWait(driver, Duration.ofSeconds(120)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(locatorValue)));
                //  elements = driver.findElements(By.id(locatorValue));
                break;
            case "name":
                elements = driver.findElements(By.name(locatorValue));
                break;
            case "classname":
                elements = driver.findElements(By.className(locatorValue));
                break;
            case "linktext":
                elements = driver.findElements(By.linkText(locatorValue));
                break;
            case "partiallink":
                elements = driver.findElements(By.partialLinkText(locatorValue));
                break;
            case "xpath":
                elements = driver.findElements(By.xpath(locatorValue));
                break;
            case "css":
                elements = driver.findElements(By.cssSelector(locatorValue));
                break;
            case "tagname":
                elements = driver.findElements(By.tagName(locatorValue));
                break;
        }
        return elements;
    }

    public void clickLogout() {
        String logoutLink = PropertyFileReader.getPropertyValue("actitime.timetrackpage.logout_link");
        WebElement logout = getElement(logoutLink);
        logout.click();
    }

    public String getPageTitle() {
        CommonUtil.waitDefinite(3);
        return this.driver.getTitle();
    }

}
