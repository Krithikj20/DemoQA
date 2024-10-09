package org.example;

import Utils.NewTab;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class FramesAlertsandWindowsPageObjects {
    public WebDriver driver;

    public FramesAlertsandWindowsPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[3]")
    private WebElement Card;

    @FindBy(xpath = "//span[contains(text(),'Browser Windows')]")
    private WebElement BrowserWindowTab;

    @FindBy(xpath = "//button[@id='tabButton']")
    private WebElement NewTabButton;

    @FindBy(xpath = "//h1[@id=\"sampleHeading\"]")
    public WebElement Title;

public String BrowserWindow(){
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Card);

    Card.click();
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",BrowserWindowTab);
    BrowserWindowTab.click();
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",NewTabButton);
    NewTabButton.click();
    NewTab tab=new NewTab(driver);
    tab.NewTabHandle();
    String NewPageTitle= Title.getText();
    System.out.println(NewPageTitle);
   return NewPageTitle;

}
}
