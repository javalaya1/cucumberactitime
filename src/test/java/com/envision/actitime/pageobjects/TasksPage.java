package com.envision.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TasksPage extends BasePage {
    private WebDriver driver;

    public TasksPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//div[text()='Add New']")
    private WebElement addNewTaskElement;

    @FindBy(className = "item createNewCustomer")
    private WebElement addCustomerLink;

    @FindBy(xpath="//div[@class='customerNameDiv']/input")
    private WebElement customerNameInputAsk;

    @FindBy(xpath="")
    public WebElement createCustomerButton;

    public void clickAddNewTask() {
        addNewTaskElement.click();
    }

    public void clickAddNewCustomerLink() {
        addCustomerLink.click();
    }

    public void enterCustomerName(String input){
        customerNameInputAsk.sendKeys(input);
    }

}
