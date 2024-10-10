package org.example;

import Utils.NewTab;
import Utils.SwitchToPreviousTab;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;


public class FramesAlertsandWindowsPageObjects {
    public WebDriver driver;

    public FramesAlertsandWindowsPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //newTab
    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[3]")
    private WebElement Card;

    @FindBy(xpath = "//span[contains(text(),'Browser Windows')]")
    private WebElement BrowserWindowTab;

    @FindBy(xpath = "//button[@id='tabButton']")
    private WebElement NewTabButton;

    @FindBy(xpath = "//h1[@id=\"sampleHeading\"]")
    public WebElement Title;

    //New window
    @FindBy(xpath="//button[@id='windowButton']")
    public WebElement NewWindowButton;

    @FindBy(xpath = "//h1[@id=\"sampleHeading\"]")
    public WebElement NewWindowText;

    //NewWindowMessage
    @FindBy(xpath = "//button[@id=\"messageWindowButton\"]")
    public WebElement NewWindowMessageButton;
    @FindBy(xpath = "//body[contains(text(),'Knowledge')]")
public WebElement Window3Title;

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
public void NewWindowFlow(){
    SwitchToPreviousTab PreviousTab=new SwitchToPreviousTab(driver);
   PreviousTab.closeCurrentTabAndSwitchToPrevious(driver);
  NewWindowButton.click();

    NewTab tab2=new NewTab(driver);
    tab2.NewTabHandle();

    String title=NewWindowText.getText();
    System.out.println(title);

    PreviousTab.closeCurrentTabAndSwitchToPrevious(driver);
    NewWindowMessageButton.click();

    // tab2.NewTabHandle();

//    String text=Window3Title.getText();
//    System.out.println(text);
}

}
