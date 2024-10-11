import org.example.AlertsPageObjects;
import org.example.ElementsPageObjects;
import org.testng.annotations.Test;

public class Alerts extends BaseTest{

        @Test
        public void AlertsTest() throws InterruptedException{
            AlertsPageObjects alert=new AlertsPageObjects(driver);
alert.alertsFlow();
    }

}
