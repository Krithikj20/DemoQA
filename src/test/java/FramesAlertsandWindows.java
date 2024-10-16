import org.example.FramesAlertsandWindowsPageObjects;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FramesAlertsandWindows extends BaseTest{
    @Test
    public void FramesAlertsandWindowsTest(){
        FramesAlertsandWindowsPageObjects Frames=new FramesAlertsandWindowsPageObjects(driver);
       Assert.assertEquals(Frames.BrowserWindow(), "This is a sample page");

    }
    @Test
    public void WindowsTest(){
        FramesAlertsandWindowsPageObjects Frames=new FramesAlertsandWindowsPageObjects(driver);
        Frames.NewWindowFlow();
    }
}
