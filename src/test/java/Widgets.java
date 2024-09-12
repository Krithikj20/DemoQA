import org.example.WidgetsPageObjects;
import org.testng.annotations.Test;

public class Widgets extends BaseTest{
    @Test
    public void testWidgets() throws InterruptedException {
        WidgetsPageObjects widgets= new WidgetsPageObjects(driver);
        widgets.slider();
        widgets.progressbar();

    }

}
