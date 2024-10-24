package Utils;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {
    WebDriver driver;
    public Screenshot(WebDriver driver){
        this.driver=driver;
    }


    public static void takeSnapShot(WebDriver webdriver) throws Exception{
//Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

//Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//Move image file to new destination
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        String DestFile = "/Users/krithikj/Desktop/DemoQa/src/main/resources/shots" + timeStamp + ".png";
        File destFile = new File(DestFile);
        destFile.getParentFile().mkdirs();

        //Copy file at destination
        FileUtils.copyFile(SrcFile, destFile);
    }
}


