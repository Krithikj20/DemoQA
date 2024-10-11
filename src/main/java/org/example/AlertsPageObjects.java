package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPageObjects {
    public WebDriver driver;

    public AlertsPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[3]")
    private WebElement Card;
@FindBy(xpath = "(//li[@class=\"btn btn-light active\"])[1]")
    public WebElement AlertsTab;

public void alertsFlow(){
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Card);
    Card.click();
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AlertsTab);
    AlertsTab.click();
}
}
