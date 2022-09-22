package org.rahulshettyacademy.TestUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
public class testBS {

  // WebDriver driver;
	AndroidDriver driver;
   public static String userName = "archanacgaikwad_PG5Yvi"; 
   public static String accessKey = "17kdLByk3SjUprV1xqKy";
   @BeforeTest
   public void setup() throws MalformedURLException {
      DesiredCapabilities caps = new DesiredCapabilities();      
      HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
      // Set your access credentials
      //browserstackOptions.put("userName", "archanacgaikwad_PG5Yvi");
      //browserstackOptions.put("accessKey", "17kdLByk3SjUprV1xqKy");
      // Set other BrowserStack capabilities
		/*
		 * browserstackOptions.put("appiumVersion", "1.22.0");
		 * browserstackOptions.put("projectName", "First Java Project");
		 * browserstackOptions.put("buildName", "browserstack-build-1");
		 * browserstackOptions.put("sessionName", "first_test");
		 */      // Passing browserstack capabilities inside bstack:options
      //caps.setCapability("bstack:options", browserstackOptions);
      // Set URL of the application under test
      caps.setCapability("app", "bs://e7a7fc83aee8d7beb9bf1d06e3c365f11447e1f7");
      // Specify deviceName and platformName for testing
      caps.setCapability("platformName", "android");
      caps.setCapability("platformVersion", "11.0");
      caps.setCapability("deviceName", "Google Pixel 5");
      //AndroidDriver driver = new AndroidDriver(new URL("http://hub.browserstack.com/wd/hub"),caps);
      driver = new AndroidDriver(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);
   }

   @Test
   public void testSearchAppium() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
      driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
      driver.findElement(By.id("android:id/text1")).click();
      driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
      driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
      driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
      //String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
      //AssertJUnit.assertEquals(toastMessage,"Please enter your name");
   }
   
   @AfterTest
   public void tearDown() {
      driver.quit();
   }

}


