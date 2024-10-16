import org.example.InteractionsPageObjects;
import org.junit.Test;

public class Interactions extends BaseTest{
    @Test
    public void Interaction() {
        InteractionsPageObjects interactions = new InteractionsPageObjects(driver);
        interactions.resizableFlow();
        interactions.droppable();
        interactions.dragabble();
       interactions.sortable();

    }
}
