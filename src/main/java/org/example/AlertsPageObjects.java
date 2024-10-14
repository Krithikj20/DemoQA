package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsPageObjects {
    public WebDriver driver;

    public AlertsPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[3]")
    public WebElement Card;
@FindBy(xpath = "(//*[contains(text(),'Alerts')])[2]")
    public WebElement AlertsTab;

@FindBy(xpath = "//button[@id='alertButton']")
public WebElement AlertButton;

@FindBy(xpath = "//button[@id='timerAlertButton']")
public WebElement Alert5SecondsButton;

public void alertsFlow() {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Card);
    Card.click();
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AlertsTab);
    AlertsTab.click();
    AlertButton.click();
    driver.switchTo().alert().accept();
}
public void Alert5Seconds()
{
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Alert5SecondsButton);
    Alert5SecondsButton.click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.alertIsPresent());
    driver.switchTo().alert().accept();

}
}
