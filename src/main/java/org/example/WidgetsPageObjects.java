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

public class WidgetsPageObjects {
    public WebDriver driver;

    public WidgetsPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="(//div[@class='card mt-4 top-card'])[4]")
    private WebElement WidgetsCard;
@FindBy(xpath = "(//div[@class='header-wrapper'])[4]")
    private WebElement widgets;

@FindBy(xpath="//span[contains(text(),'Slider')]")
private WebElement SliderTab;
@FindBy(xpath="//input[@class='range-slider range-slider--primary']")
private WebElement SliderTooltip;

    public void slider() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", WidgetsCard);
        WidgetsCard.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(widgets));
//    widgets.click();
//        widgets.click();
//        wait.until(ExpectedConditions.visibilityOf(SliderTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SliderTab);

     SliderTab.click();
        Actions moveSlider = new Actions(driver);
  moveSlider.clickAndHold(SliderTooltip).moveByOffset(0, 40).release().perform(); // Adjust the x-offset value as needed


    }



}