package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
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

    //tooltips
    @FindBy(xpath = "//span[contains(text(),'Tool Tips')]")
    private WebElement ToolTipTab;
@FindBy(xpath="//button[@id='toolTipButton']")
    private WebElement Hoverbutton;
@FindBy(xpath = "//button[@aria-describedby='buttonToolTip']")
private WebElement HoverTooltip;

//datepicker
    @FindBy(xpath = "(//li[@id='item-2'])[3]")
    private WebElement DatePickerTab;
    @FindBy(xpath="//input[@id='datePickerMonthYearInput']")
    private WebElement DatePickerMonthYearInput;
@FindBy(xpath="//div[contains(@class, 'react-datepicker__day') and contains(@class, 'react-datepicker__day--020') and contains(text(),'20')]")
private WebElement Date;

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
        }
    }

    public String tooltips(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ToolTipTab);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(ToolTipTab));
        ToolTipTab.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(Hoverbutton).perform();
        String tooltipText = HoverTooltip.getText();
        System.out.println("Tooltip text: " + tooltipText);
        return tooltipText;

    }

    public void datepicker(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(DatePickerTab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", DatePickerTab);
        DatePickerTab.click();
        DatePickerMonthYearInput.click();
        wait.until(ExpectedConditions.visibilityOf(Date));
        Date.click();
    }
}