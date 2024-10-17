package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.time.Duration;

public class MenuPageObjects {
    public WebDriver driver;

    public  MenuPageObjects(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath="(//div[@class='card mt-4 top-card'])[4]")
    public WebElement WidgetsCard;
    @FindBy(xpath = "(//div[@class='header-wrapper'])[4]")
    public WebElement widgets;

    //select Menu Tab
    @FindBy(xpath="(//li[@id='item-8'])[2]")
    public WebElement SelectMenuTab;

public void SelectMenu(){
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", WidgetsCard);
    WidgetsCard.click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(widgets));
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",SelectMenuTab);
    SelectMenuTab.click();
}
}
