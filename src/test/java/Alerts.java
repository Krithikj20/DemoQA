import org.example.AlertsPageObjects;
import org.example.ElementsPageObjects;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Alerts extends BaseTest{

        @Test
        public void AlertsTest() throws InterruptedException{
            AlertsPageObjects alert=new AlertsPageObjects(driver);
    alert.alertsFlow();
    alert.Alert5Seconds();

    String CancelText= alert.Alert3Buttonflow();
    Assert.assertEquals(CancelText, "You selected Cancel");

    String PromptboxText=alert.Alert4ButtonFlow();
    Assert.assertEquals(PromptboxText, "You entered krithi");
    }

}
