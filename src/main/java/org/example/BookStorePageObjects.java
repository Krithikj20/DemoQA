package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookStorePageObjects {
    public WebDriver driver;

    public BookStorePageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "(//div[@class='card-body'])[6]")
    public WebElement BooksAppCard;

    @FindBy(xpath="//span[contains(text(),'Login')]")
    public WebElement loginTab;

    @FindBy(xpath = "//input[@id='firstname']")
    public WebElement firstname;

    @FindBy(xpath = "//input[@id='lastname']")
public WebElement lastname;

    @FindBy(xpath = "//input[@id='userName']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@id='newUser']")
    public WebElement newUserButton;

 //   @FindBy(xpath = "//span[@id='recaptcha-anchor']")
    @FindBy(xpath="//div[@class='recaptcha-checkbox-border']")
    public WebElement CaptchaCheckbox;

    @FindBy(xpath="(//span[contains(text(),'Book Store')])[1]")
    public WebElement BookstoreTab;

    @FindBy(xpath = "//input[@id='searchBox']")
    public WebElement searchBox;
    @FindBy(xpath="//span[@id='see-book-Git Pocket Guide']")
    public WebElement GitBook;

    public void BooksLogin(){
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", BooksAppCard);
        BooksAppCard.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginTab);
        loginTab.click();

        newUserButton.click();
        firstname.sendKeys("krithi");
        lastname.sendKeys("kj");
        userName.sendKeys("krithikj");
        password.sendKeys("password");
//        CaptchaCheckbox.click(); cannot automate captcha
    }
    public void BookStoreFlow(){
        BookstoreTab.click();
        searchBox.sendKeys("Git");
        GitBook.click();
driver.navigate().back();
    }
}
