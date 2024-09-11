import org.example.WidgetsPageObjects;
import org.testng.annotations.Test;

public class Widgets extends BaseTest{
    @Test
    public void testWidgets(){
        WidgetsPageObjects widgets= new WidgetsPageObjects(driver);
        widgets.slider();


    }

}
