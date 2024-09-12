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

//progress bar
    @FindBy(xpath="//span[contains(text(),'Progress Bar')]")
    private WebElement ProgressBar;
    @FindBy(xpath = "//button[@id='startStopButton']")
    private WebElement StartStopButton;
    @FindBy(xpath="//button[contains(text(),'Stop')]")
    private WebElement StopButton;
    @FindBy(xpath = "//div[@id='progressBar']")
    private WebElement ProgressBarTooltip;

    public void slider() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", WidgetsCard);
        WidgetsCard.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(widgets));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SliderTab);
     SliderTab.click();
        Actions moveSlider = new Actions(driver);
  moveSlider.clickAndHold(SliderTooltip).moveByOffset(0, 40).release().perform(); // Adjust the x-offset value as needed


    }

    public void progressbar() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ProgressBar);
        ProgressBar.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", StartStopButton);
        StartStopButton.click();
        String ProgressBarTooltip = "0";
        while (ProgressBarTooltip.equals("50%")) {
            StopButton.click();

//System.out.println(ProgressBarTooltip);
        }
        System.out.println("Progress bar crossed 50%!");
    }
}