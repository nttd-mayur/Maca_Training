package SC01_Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class cssSelector_learning {
	
	static String actual_string="";
	static String expected_string = "";
	
	public static void cssSelector() {
		// 1) Login (Chrome)
					// ChromeDriver driverCss=new ChromeDriver(); //WebDriver driverCss=new EdgeDriver();
					WebDriver driverCss = new ChromeDriver();

					// 2) Open URL https://demoblaze.com/
					driverCss.get("https://demo.nopcommerce.com/");
					
					// 3) Open URL https://demoblaze.com/3) Validate Text "STORE"
						try {
							actual_string = driverCss.getTitle();
						} catch (Exception e) {
								e.printStackTrace();
						}
						expected_string = "nopCommerce demo store";
						myAssertion(actual_string, expected_string);
					/*
					 * CSSSelector with below combination 
					 * 1-A) tag Id 					tag#id 
					 * 1-B) tag class		  		tag.classname 
					 * 1-C) tag attribute 			tag[attribute="value"] 
					 * 1-D) tag class attribute 	tag.classnmae[attribute="value"]
					 */

					// 1-A) CSS selector with Tag id and class tag#id Syntax: tag#id
					driverCss.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-Shirts");
					
					System.out.println("Test Pass Tag ID");

					// 1-B) CSS selector with Tag Class tag.classname Syntax: tag.classname
					driverCss.findElement(By.cssSelector("input.search-box-text")).clear();
					driverCss.findElement(By.cssSelector("input.search-box-text")).sendKeys("Phone");
					System.out.println("Test Pass Tag Class.classname");
					// driverCss.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

					// 1-C) CSS selector with Tag & attribute tag[attribute="value"] Syntax:
					// tag[attribute='value']
					driverCss.findElement(By.cssSelector("[placeholder='Search store']")).clear();
					driverCss.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("Shirts");
					System.out.println("Test Pass Tag tag[attribute=\"value\"]");

					// 1-D) CSS selector with Tag, class & attribute
					// tag.classname[attribute="value"] Syntax: tag[attribute='value']
					// Login to application scenario
					driverCss.findElement(By.cssSelector("a.ico-login")).click();
					// Assertions
						actual_string = driverCss.getTitle();
						expected_string = "nopCommerce demo store. Login";
						myAssertion(actual_string, expected_string);

					driverCss.findElement(By.cssSelector("input.email[type='email']")).sendKeys("mayur11.karote@nttdata.com");
					driverCss.findElement(By.cssSelector("input.password[type='password']")).sendKeys("ntt123");
					driverCss.findElement(By.cssSelector("button[class='button-1 login-button']")).click();
						actual_string = driverCss.findElement(By.cssSelector("div[class='topic-block-title'] h2")).getText();
						expected_string = "Welcome to our store";
						myAssertion(actual_string, expected_string);
						
					driverCss.findElement(By.cssSelector("a[class='ico-logout']"));
					// Close Browser
					 driverCss.quit();
					// driverCss.close();
	} // public static void cssSelector()
	
	public static void myAssertion(String actual_string, String expected_string) {
		// TODO Assertion stub
		if (actual_string.equals(expected_string)) {
			System.out.println("Assertion: Test PASS text: " + actual_string);
		} else {
			System.out.println("Assertion: Test FAIL text: " + actual_string);
		}
		actual_string = "";
		expected_string = "";
	} // public static void myAssertion(String actual_string, String expected_string) {
}// public class cssSelector_learning
