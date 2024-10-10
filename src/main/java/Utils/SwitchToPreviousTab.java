package Utils;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class SwitchToPreviousTab {
    WebDriver driver;
    public SwitchToPreviousTab(WebDriver driver) {

        this.driver = driver;
    }
    public void closeCurrentTabAndSwitchToPrevious(WebDriver driver) {


        // Close current tab
        driver.close();

       //  Get all window handles
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
       //  Switch to the last handle in the list (previous tab)
        driver.switchTo().window(tabs.get(tabs.size() - 1));

    }
}
