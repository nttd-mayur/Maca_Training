package Ecom_automation_Multi;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import SC01_Login.Register_User;

public class SC02 {

	WebDriver driverM;
	WebElement elementV;
	int mSleep=1000;
	int mSleepL=4000;
	String actualText=""; 
	
	@Test(priority=0)
	public void launchMe() throws InterruptedException {
	
		//System.out.println("In Launch block 1 ..... ");
		driverM = new ChromeDriver();
		driverM.get("https://demo.nopcommerce.com/");
		Thread.sleep(mSleep);
	} // public void launchMe() throws InterruptedException {
// --------------------------------------------- Login -------------------------------------------------------------------------	
	@Test(priority=1)
	public void loginMe() throws InterruptedException {
		//System.out.println("In Login block 2 ..... ");
		loginExt();
			try {
				elementV = driverM.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
				boolean isPresent= elementV.isDisplayed();
					if(isPresent)
					{
						Register_User.registeruser();
						Thread.sleep(mSleep);
						loginExt();
						Thread.sleep(mSleep);
						actualText="";
					}
			}catch(NoSuchElementException e) {
				actualText="";
			}
	}  // public void loginMe() throws InterruptedException {
// --------------------------------------------- Search -------------------------------------------------------------------------
	@Test(priority=2, dependsOnMethods= {"loginMe"})
	public void searchMe() throws InterruptedException {
		//System.out.println("In Search block 3 ..... ");
		driverM.findElement(By.xpath("//img[@title='Show products in category Apparel']")).click();
		Thread.sleep(mSleep);
			actualText= driverM.findElement(By.xpath("//h1[normalize-space()='Apparel']")).getText();
			assertEquals(actualText, "Apparel");
			actualText="";
		driverM.findElement(By.xpath("//img[@alt='Picture for category Shoes'][@title='Show products in category Shoes']")).click();
		Thread.sleep(mSleep);
			actualText = driverM.findElement(By.xpath("//h1[normalize-space()='Shoes']")).getText();
			assertEquals(actualText, "Shoes");
			actualText="";
			//boolean displayStatus = driverM.findElement(By.xpath("//*[text()='per page']")).isDisplayed();
			//System.out.println("Label 1 Display status: " + displayStatus);
	}  // public void searchMe() throws InterruptedException {
// --------------------------------------------- Add to Cart ------------------------------------------------------------	
	@Test(priority=3, dependsOnMethods= {"loginMe"})
	public void addToCart() throws InterruptedException {
		//driverM.findElement(By.xpath("div[class='product-item'] img[title='Show details for adidas Consortium Campus 80s Running Shoes']")).click();
		driverM.findElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'adidas Consortium Campus 80s Running Shoes')]")).click();
		Thread.sleep(mSleep);
			actualText = driverM.findElement(By.xpath("//strong[@class='current-item']")).getText();
			//System.out.println("ACTUAL TEXT : " + actualText);
			assertEquals(actualText, "adidas Consortium Campus 80s Running Shoes");
			actualText="";
			
		driverM.findElement(By.xpath("//select[@id='product_attribute_9']")).sendKeys("9");
		driverM.findElement(By.xpath("//button[@id='add-to-cart-button-25']")).click();
			Thread.sleep(mSleep);
			actualText = driverM.findElement(By.xpath("//h1[normalize-space()='adidas Consortium Campus 80s Running Shoes']")).getText();
			assertEquals(actualText, "adidas Consortium Campus 80s Running Shoes");
			actualText="";
			Thread.sleep(mSleep);
	} // public void addToCart() 
// --------------------------------------------- Logout -------------------------------------------------------------------------
	@Test(priority=10, dependsOnMethods= {"loginMe"})
	public void logoutMe() throws Exception {
		//System.out.println("In Logout block 5 ..... ");
		Thread.sleep(mSleepL);
		driverM.findElement(By.className("ico-logout")).click();
		Thread.sleep(mSleep);
		actualText= driverM.getTitle();
		assertEquals(actualText, "nopCommerce demo store");
	} // public void logoutMe() throws Exception {
// --------------------------------------------- End Test -----------------------------------------------------------------------	
	@AfterTest
	public void closeMe() {
		driverM.quit();
		//System.out.println("In Close block 6 ..... ");
	}  // public void closeMe() {
	
	public void loginExt() throws InterruptedException {
		//System.out.println("In LoginExt block last ..... ");
		driverM.findElement(By.cssSelector("a.ico-login")).click();
		Thread.sleep(mSleep);
		actualText= driverM.findElement(By.xpath("//*[text()='Returning Customer']")).getText();
		assertEquals(actualText, "Returning Customer");
		actualText="";
			driverM.findElement(By.cssSelector("input.email[type='email']")).sendKeys("mayur11.karote@nttdata.com");
			driverM.findElement(By.cssSelector("input.password[type='password']")).sendKeys("ntt123");
			driverM.findElement(By.cssSelector("button[class='button-1 login-button']")).click();
		Thread.sleep(mSleep);
	}
	
}
