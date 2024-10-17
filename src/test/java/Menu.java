import org.example.MenuPageObjects;
import org.testng.annotations.Test;

public class Menu extends BaseTest{
    @Test
    public void MenuTest(){
        MenuPageObjects menu = new MenuPageObjects(driver);
menu.SelectMenu();
    }
}
