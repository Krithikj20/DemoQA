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
@FindBy(xpath="//div[@id='draggable']")
private WebElement DragMe;
@FindBy(xpath="(//div[@id='droppable' and @class='drop-box ui-droppable'])[1]")
private WebElement DropMe;

//dragggable
@FindBy(xpath = "//span[contains(text(),'Dragabble')]")
private WebElement dragabbleTab;
@FindBy(xpath = "//div[@id='dragBox']")
private WebElement dragBoxTab;

//selectable
    @FindBy(xpath="//span[contains(text(),'Sortable')]")
    private WebElement SortableTab;


    public void resizableFlow() {
        // Scroll to the interactions card and click on the resizable tab
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", InteractionsCard);
        InteractionsCard.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ResizableTab);

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
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DragMe);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(DragMe, DropMe).perform();

        System.out.println("Drag and Drop action performed successfully.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(DropMe)).click();
    }
    public void dragabble() {
        // Scroll into view for the draggable tab
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dragabbleTab);

        // Wait until the draggable tab is clickable
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(dragabbleTab));

        // Click on the draggable tab
        dragabbleTab.click();

        // Wait for the draggable box to be present and visible
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(dragBoxTab));

        // Scroll into view for the drag box
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dragBoxTab);

        // Perform the drag and drop action
        Actions actions = new Actions(driver);
        actions.clickAndHold(dragBoxTab)
                .moveByOffset(100, 100) // Drag to the desired offset
                .release()
                .perform();
    }
    public void sortable()
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", InteractionsCard);
        InteractionsCard.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SortableTab);
        SortableTab.click();

    }

}
