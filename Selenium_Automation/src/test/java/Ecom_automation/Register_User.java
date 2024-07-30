package Ecom_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Register_User {
	public static void registeruser(){
		WebDriver driverReg = new ChromeDriver();
		driverReg.get("https://demo.nopcommerce.com/");
		//driverReg.manage().window().minimize();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driverReg.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		driverReg.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Mayur");
		driverReg.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Mayur");
		driverReg.findElement(By.xpath("//input[@id='Email']")).sendKeys("Mayur11.karote@nttdata.com");
		driverReg.findElement(By.xpath("//input[@id='Newsletter']")).click();
		driverReg.findElement(By.xpath("//input[@id='Password']")).sendKeys("ntt123");
		driverReg.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("ntt123");
		driverReg.findElement(By.xpath("//button[@id='register-button']")).click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		System.out.println("User Registered ....");
	}
}
