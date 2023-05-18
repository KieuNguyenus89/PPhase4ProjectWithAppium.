package SauceDemoTesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BaseTest {

	AndroidDriver<AndroidElement> driver;;

	@BeforeTest(alwaysRun = true)
	public void launchApplication() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "emulator-5556");
		dc.setCapability("platformName", "Android");
		dc.setCapability("browserName", "Chrome");
		dc.setCapability("noReset", true);
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
		driver.get("https://www.saucedemo.com/");

	}

	@AfterMethod(alwaysRun = true)
	protected void cleanUpActivities() {

		driver.quit();
	}

}
