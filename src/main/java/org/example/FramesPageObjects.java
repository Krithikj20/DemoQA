package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesPageObjects {
    public WebDriver driver;

    public FramesPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[3]")
    public WebElement Card;
    @FindBy(xpath = "(//li[@id='item-2'])[2]")
    public WebElement FramesTab;
    @FindBy(xpath = "//iframe[@id='frame1']")
    public WebElement NewFrame1;
    @FindBy(xpath = "//iframe[@id='frame2']")
    public WebElement NewFrame2;

    @FindBy(xpath = "(//h1[@id='sampleHeading'])[1]")
    public WebElement Frame1Text;


    public String FramesTest(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Card);
        Card.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", FramesTab);
        FramesTab.click();
        driver.switchTo().frame(NewFrame1);
        String Frame1Title= Frame1Text.getText();
        return Frame1Title;
    }
public String Frames2Test(){
    driver.switchTo().defaultContent();//no such elemt exeption
    driver.switchTo().frame(NewFrame2);

    String Frame2Title= Frame1Text.getText();
    return Frame2Title;

}
}
