import org.example.ElementsPageObjects;
import org.testng.annotations.Test;

public class Elements extends BaseTest
{
    @Test
    public void ElementsTest() throws InterruptedException{
        ElementsPageObjects Elements = new ElementsPageObjects(driver);
        Elements.TextBox();
       Elements.WebTables();
    }
}
