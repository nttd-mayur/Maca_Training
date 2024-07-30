package Ecom_automation_Group;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import SC01_Login.Register_User;

public class Group_SC01 {

	WebDriver driverM;
	WebElement elementV;
	int mSleep=1000;
	String actualText=""; 
	
	@Test(priority=-2, groups= {"Functional", "Sanity", "Regression"})
	public void launchMe() throws InterruptedException {
	
		System.out.println("In Launch block 1 ..... ");
		driverM = new ChromeDriver();
		driverM.get("https://demo.nopcommerce.com/");
		Thread.sleep(mSleep);
	} // public void launchMe() throws InterruptedException {
// --------------------------------------------- Login -------------------------------------------------------------------------	
	@Test(priority=1, groups= {"Functional", "Sanity", "Regression"})
	public void loginMe() throws InterruptedException {
		System.out.println("In Login block 2 ..... ");
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
// --------------------------------------------- Search ---------------------------------------------------------------------
	@Test(priority=2, dependsOnMethods= {"loginMe"}, groups= {"Functional", "Sanity"})
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
	@Test(priority=10, dependsOnMethods= {"loginMe"},groups= {"Functional", "Sanity", "Regression"})
	public void logoutMe() throws Exception {
		System.out.println("In Logout block 5 ..... ");
		driverM.findElement(By.className("ico-logout")).click();
		Thread.sleep(mSleep);
		actualText= driverM.getTitle();
		assertEquals(actualText, "nopCommerce demo store");
	} // public void logoutMe() throws Exception {
// --------------------------------------------- Close -------------------------------------------------------------------------	
	@Test(priority=11, dependsOnMethods= {"loginMe"},groups= {"Functional", "Sanity", "Regression"})
	public void closeMe() {
		driverM.quit();
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