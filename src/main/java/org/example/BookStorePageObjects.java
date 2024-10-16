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

    @FindBy(xpath = "//input[@id='userName']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
public WebElement password;

    @FindBy(xpath = "//button[@id='newUser']")
    public WebElement newUserButton;


    public void BooksLogin(){
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", BooksAppCard);
        BooksAppCard.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginTab);
        loginTab.click();
userName.sendKeys("krithi");
        password.sendKeys("password");
        newUserButton.click();
    }
}
