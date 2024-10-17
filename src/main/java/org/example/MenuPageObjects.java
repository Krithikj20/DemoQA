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

    public void SelectMenu() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", WidgetsCard);
        WidgetsCard.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(widgets));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SelectMenuTab);
        SelectMenuTab.click();
        //   SelectValueDropdown.click();

//    Select dropdown = new Select(driver.findElement(By.xpath("(//div[@class=' css-1hwfws3'])[1]")));
//    dropdown.selectByVisibleText("Group 1, option 1");
        SelectOneDropdown.click();
//        List<WebElement> op = SelectOneDropdown.findElements(By.tagName("class"));
//        int size = op.size();
//        for (int i = 0; i < size; i++) {
//            String options = op.get(i).getText();
//            System.out.println(options);

            Select select = new Select(SelectOneDropdown);
            List<WebElement> options = select.getOptions();
            for (WebElement t : options)
            {
                System.out.println(t.getText());
            }
        }

}
