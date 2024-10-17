import org.example.BookStorePageObjects;
import org.testng.annotations.Test;

public class BookStore extends BaseTest{
    @Test
    public void BoooksApp(){
        BookStorePageObjects Books =new BookStorePageObjects(driver);
        Books.BooksLogin();
        Books.BookStoreFlow();
    }
}
