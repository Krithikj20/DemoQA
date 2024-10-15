import org.example.FramesPageObjects;
import org.testng.annotations.Test;

public class Frames extends BaseTest {
    @Test
    public void FramesFlow(){
        FramesPageObjects frame = new FramesPageObjects(driver);
        String PrintFirstFrameTitle=frame.FramesTest();
        System.out.println(PrintFirstFrameTitle);


        String PrintSecondFrameTitle=  frame.Frames2Test();
        System.out.println(PrintSecondFrameTitle + "test");

    }
}
