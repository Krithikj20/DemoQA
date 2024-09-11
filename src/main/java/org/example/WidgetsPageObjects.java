package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WidgetsPageObjects {
    public WebDriver driver;

    public WidgetsPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
@FindBy(xpath = "//div[contains(text(),'Widgets')]")
    private WebElement widgets;
@FindBy(xpath="(//div[@class='card mt-4 top-card'])[4]")
private WebElement WidgetsCard;
@FindBy(xpath="//span[contains(text(),'Slider')]")
private WebElement Slider;

    public void slider() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", WidgetsCard);
        WidgetsCard.click();
        widgets.click();
        Slider.click();

    }



}