package org.example;

import org.openqa.selenium.Alert;
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
    @FindBy(xpath = "//button[@id='confirmButton']")
    public WebElement Alert3rdButton;
    @FindBy(xpath = "//span[@id='confirmResult']")
    public WebElement greenText;


    @FindBy(xpath = "//button[@id='promtButton']")
    public WebElement Alert4Button;
    @FindBy(xpath = "//span[@id='promptResult']")
    public WebElement Text4;

    public void alertsFlow() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Card);
        Card.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AlertsTab);
        AlertsTab.click();
        AlertButton.click();
        driver.switchTo().alert().accept();
    }

    public void Alert5Seconds() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Alert5SecondsButton);
        Alert5SecondsButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

    }

    public String Alert3Buttonflow() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Alert3rdButton);
        Alert3rdButton.click();
        driver.switchTo().alert().dismiss();
        String text3 = greenText.getText();

        return text3;
    }

    public String Alert4ButtonFlow() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Alert4Button);
        Alert4Button.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("krithi");
        driver.switchTo().alert().accept();
        String text4 = Text4.getText();
        return text4;
    }
}