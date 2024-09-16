import org.example.InteractionsPageObjects;
import org.testng.annotations.Test;

public class Interactions extends BaseTest{
    @Test
    public void interaction() {
        InteractionsPageObjects interactions = new InteractionsPageObjects(driver);
        interactions.resizableFlow();
        interactions.droppable();
    }
}
