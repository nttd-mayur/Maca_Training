package Ecom_automation;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import SC01_Login.Register_User;

public class SC01 {

	WebDriver driverM;
	WebElement elementV;
	int mSleep=1000;
	int mSleepL=6000;
	String actualText=""; 
	
	@BeforeClass
	public void launchMe() throws InterruptedException {
	
		System.out.println("In Launch block 1 ..... ");
		driverM = new ChromeDriver();
		//driverM.manage().timeouts().implicitlyWait(Duration.ofSeconds(mSleepL));
		driverM.get("https://demo.nopcommerce.com/");
		Thread.sleep(mSleep);
	} // public void launchMe() throws InterruptedException {
// --------------------------------------------- Login -------------------------------------------------------------------------	
	@Test(priority=1)
	public void loginMe() throws InterruptedException {
		System.out.println("In Login block 2 ..... ");
		loginExt();
			try {
				elementV = driverM.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
				boolean isPresent= elementV.isDisplayed();
				System.out.println("In Login block 3 ..... ");
					if(isPresent)
					{
						System.out.println("In User Registration block 3 ..... ");
						Register_User.registeruser();
						Thread.sleep(mSleep);
						loginExt();
						Thread.sleep(mSleep);
						actualText="";
					}
			}catch(NoSuchElementException e) {
				actualText="";
				System.out.println("In Login Success block 3 ..... ");
			}
	}  // public void loginMe() throws InterruptedException {
// --------------------------------------------- Search ---------------------------------------------------------------------
	@Test(priority=2, dependsOnMethods= {"loginMe"})
	public void searchMe() throws InterruptedException {
		System.out.println("In Search block 3 ..... ");
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
			boolean displayStatus = driverM.findElement(By.xpath("//*[text()='per page']")).isDisplayed();
			System.out.println("Label 1 Display status: " + displayStatus);
	}  // public void searchMe() throws InterruptedException {

// --------------------------------------------- Logout -------------------------------------------------------------------------	
	@Test(priority=10, dependsOnMethods= {"loginMe"})
	public void logoutMe() throws Exception {
		//driverM.manage().timeouts().implicitlyWait(Duration.ofSeconds(mSleepL));
		System.out.println("In Logout block 5 ..... ");
		driverM.findElement(By.className("ico-logout")).click();
		Thread.sleep(mSleep);
		actualText= driverM.getTitle();
		assertEquals(actualText, "nopCommerce demo store");
	} // public void logoutMe() throws Exception {
// --------------------------------------------- Close -------------------------------------------------------------------------	
	@AfterClass
	public void closeMe() {
		driverM.quit();
		System.out.println("In Close block 6 ..... ");
	}  // public void closeMe() {
// --------------------------------------------- Login common method ------------------------------------------------------------	
	public void loginExt() throws InterruptedException {
		System.out.println("In LoginExt block last ..... ");
		driverM.findElement(By.cssSelector("a.ico-login")).click();
		Thread.sleep(mSleep);
		actualText= driverM.findElement(By.xpath("//*[text()='Returning Customer']")).getText();
		assertEquals(actualText, "Returning Customer");
		actualText="";
			driverM.findElement(By.cssSelector("input.email[type='email']")).sendKeys("mayur11.karote@nttdata.com");
			driverM.findElement(By.cssSelector("input.password[type='password']")).sendKeys("ntt123");
			driverM.findElement(By.cssSelector("button[class='button-1 login-button']")).click();
		Thread.sleep(mSleep);
	}  // public void loginExt() throws InterruptedException {
}