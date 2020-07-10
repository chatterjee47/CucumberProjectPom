package BaseClass;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class ScreenShot {
 
              public static void captureScreenShot(WebDriver driver, String ScreenShotName)
              {
                            try {
                                                 File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                                                 FileUtils.copyFile(screenshot,new File(System.getProperty("user.dir")+"\\Screenshots\\Screenshots"+".jpg"));
                                     } catch (Exception e)
                                       {
                                           System.out.println(e.getMessage());
                                            e.printStackTrace();
                                        }
                  }
}
