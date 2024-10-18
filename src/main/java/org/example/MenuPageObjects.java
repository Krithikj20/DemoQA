package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.time.Duration;
import java.util.List;

public class MenuPageObjects {
    public WebDriver driver;

    public MenuPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[4]")
    public WebElement WidgetsCard;
    @FindBy(xpath = "(//div[@class='header-wrapper'])[4]")
    public WebElement widgets;

    //select Menu Tab
    @FindBy(xpath = "(//li[@id='item-8'])[2]")
    public WebElement SelectMenuTab;

    @FindBy(xpath = "(//div[@class=' css-2b097c-container'])[1]")
    public WebElement SelectValueDropdown;
    @FindBy(xpath = "(//div[@class=' css-2b097c-container'])[2]")
    public WebElement SelectOneDropdown;
    @FindBy(xpath = "//select[@id='oldSelectMenu']")
    public WebElement OldStyleSelectMenu;
    @FindBy(xpath = "//option[@value='5']")
    public WebElement Black;
    @FindBy(xpath = "(//div[@class=' css-2b097c-container'])[4]")
    public WebElement multiselect;

    public void SelectMenu() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", WidgetsCard);
        WidgetsCard.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(widgets));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SelectMenuTab);
        SelectMenuTab.click();
        SelectValueDropdown.click();

//    Select dropdown = new Select(driver.findElement(By.xpath("(//div[@class=' css-1hwfws3'])[1]")));
//    dropdown.selectByVisibleText("Group 1, option 1");


    //  SelectOneDropdown.click();


//        List<WebElement> op = SelectOneDropdown.findElements(By.tagName("class"));
//        int size = op.size();
//        for (int i = 0; i < size; i++) {
//            String options = op.get(i).getText();
//            System.out.println(options);

//            Select select = new Select(SelectOneDropdown);
//            List<WebElement> options = select.getOptions();
//            for (WebElement t : options)
//            {
//                System.out.println(t.getText());
//            }

//        try {
//            WebElement elem= driver.findElement(By.xpath("(//*[name()='svg'][@class='css-19bqh2r'])[1]"));
//            elem.click();
//        } catch(Exception e) {
////            break;
//        }
       // WebElement dropdownElement = driver.findElement(By.xpath("(//*[name()='svg'][@class='css-19bqh2r'])[1]"));
//        Select select = new Select(driver.findElement(By.xpath("//div[@id='withOptGroup']//div[contains(@class,'css-1hwfws3')]")));
//        select.selectByVisibleText("Group 1, option 2");


        WebElement dropdownElement = driver.findElement(By.xpath("//div[@id='withOptGroup']//div[contains(@class,'css-1hwfws3')]"));
                dropdownElement.click();
        WebElement option = driver.findElement(By.xpath("//li[text()='Group 1, option 1']"));
        option.click();

        
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", OldStyleSelectMenu);
//        OldStyleSelectMenu.click();
////        Select oldvalue = new Select(Black);
////   oldvalue.selectByVisibleText("Black");
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Black);
//        Black.click();
//        Thread.sleep(4000);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", multiselect);
//
//        multiselect.click();
        }
}


