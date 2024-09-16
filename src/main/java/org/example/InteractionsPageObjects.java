package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InteractionsPageObjects {
    public WebDriver driver;

    public InteractionsPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//resizable
    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[5]")
    private WebElement InteractionsCard;
    @FindBy(xpath = "//span[contains(text(),'Resizable')]")
    private WebElement ResizableTab;
    @FindBy(xpath = "(//span[@class='react-resizable-handle react-resizable-handle-se'])[1]")
    private WebElement dragSource;
    @FindBy(xpath = "//div[@class='constraint-area']")
    private WebElement dragTarget;


  //droppable
  @FindBy(xpath="//span[contains(text(),'Droppable')]")
  private WebElement DroppableTab;


    public void resizableFlow() {
        // Scroll to the interactions card and click on the resizable tab
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", InteractionsCard);
        InteractionsCard.click();
        ResizableTab.click();

        // Get the current width and height of the resizable box (dragTarget)
        int currentWidth = dragTarget.getSize().getWidth();
        int currentHeight = dragTarget.getSize().getHeight();

        // Desired width and height (for example, let's assume 600px width and 200px height)
        int desiredWidth = 800;
        int desiredHeight = 500;

        // Calculate the offset required to resize
        int widthOffset = desiredWidth - currentWidth;
        int heightOffset = desiredHeight - currentHeight;

        // Perform drag and drop to resize based on the calculated offsets
        Actions actions = new Actions(driver);
        actions.clickAndHold(dragSource)
                .moveByOffset(widthOffset, heightOffset)  // Move based on the calculated offset
                .release()
                .perform();
    }

    public void droppable(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DroppableTab);
        DroppableTab.click();
    }
}
