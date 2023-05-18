package SauceDemoTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class addItemToCart extends BaseTest {

	@Test
	public void addItemToCart() throws InterruptedException {
		// System.out.println(driver.getContext());
		// Login
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

		driver.findElement(By.xpath("//input[@id='login-button']")).click();

		// Add Item to cart
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();

		// Scroll up to view cart
		JavascriptExecutor js = driver;
		js.executeScript("window.scrollBy(0,-350)", "");
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

		// Verify Item Name
		String chooseItem = "Sauce Labs Bike Light";
		String itemInCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
		Assert.assertEquals(chooseItem, itemInCart);
		System.out.println("Correct Item");

	}

}
