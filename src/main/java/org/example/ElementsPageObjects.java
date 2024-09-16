package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementsPageObjects {
    public WebDriver driver;

    public ElementsPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[1]")
    private WebElement ElementsCard;

    //textbox
    @FindBy(xpath = "//span[@class='text' and contains(text(),'Text Box')]")
    private WebElement TextBox;
    @FindBy(xpath = "//input[@id='userName']")
    private WebElement Username;
    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement Email;
    @FindBy(xpath = "//textarea[@id='currentAddress']")
    private WebElement CurrentAddress;
    @FindBy(xpath = "//textarea[@id='permanentAddress']")
    private WebElement permanentAddress;
    @FindBy(xpath = "//button[@id='submit']")
    private WebElement Submit;

//webtables
    @FindBy(xpath = "//span[@class='text' and contains(text(),'Web Tables')]")
    private WebElement WebTables;
    @FindBy(xpath = "//button[@id='addNewRecordButton']")
    private WebElement AddButton;
@FindBy(xpath="//iframe[@src='https://www.google.com/recaptcha/api2/aframe']")
    private WebElement AddModalFrame;

@FindBy(xpath="//input[@id='firstName']")
private WebElement FirstName;
    @FindBy(xpath="//input[@id='lastName']")
    private WebElement LastName;
    @FindBy(xpath="//input[@id='userEmail']")
    private WebElement userEmail;
    @FindBy(xpath="//input[@id='age']")
        private WebElement Age;
    @FindBy(xpath="//input[@id='salary']")
    private WebElement Salary;
    @FindBy(xpath="//input[@id='department']")
    private WebElement Department;


    public void TextBox() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ElementsCard);
        ElementsCard.click();
        TextBox.click();
        Username.click();
        Username.sendKeys("krithi");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(Email));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Email);

        Email.click();
        Email.sendKeys("krithik@geekyants.com");

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CurrentAddress);
        CurrentAddress.click();
        CurrentAddress.sendKeys("Udupi");
        permanentAddress.click();
        permanentAddress.sendKeys("Udupi");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Submit);
        Submit.click();
    }

    public void WebTables() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", WebTables);
        WebTables.click();
        AddButton.click();
        //driver.switchTo().frame(AddModalFrame);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(FirstName));// Switch using WebElement
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", FirstName);

        FirstName.click();
        FirstName.sendKeys("testUser");
        LastName.click();
        LastName.sendKeys("1");
        wait.until(ExpectedConditions.visibilityOf(userEmail));
        userEmail.click();
        userEmail.sendKeys("test@geekyants.com");
        Age.click();
        Age.sendKeys("25");
        Salary.click();
        Salary.sendKeys("100");
        Department.click();
        Department.sendKeys("QA");
        Submit.click();
    }
}
