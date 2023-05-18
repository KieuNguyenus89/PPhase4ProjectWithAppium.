package SauceDemoTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class addShortcutToHomeScreen extends BaseTest {

	@Test
	public void addShortcutToHomeScreen() throws InterruptedException {

		driver.context("NATIVE_APP");

		driver.findElement(By.id("com.android.chrome:id/menu_button")).click();

		driver.findElement(By.xpath("//android.widget.TextView[@text='Add to Home screen']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.android.chrome:id/positive_button")));
		driver.findElement(By.id("com.android.chrome:id/positive_button")).click();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//android.widget.Button[@text='Add to Home screen']")));
		driver.findElement(By.xpath("//android.widget.Button[@text='Add to Home screen']")).click();

	}

}
