package SC01_Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xPath_Learning {
	
	public static void xPathSelector() {
		WebDriver xPathdriver = new ChromeDriver();
		String actual_string = "";
		String expected_string = "";
		
		// 2) Open URL https://demoblaze.com/
		xPathdriver.get("https://demo.nopcommerce.com/");
		//  //tagname[@attribute='value']
		//  //*[@attribute='value]  -> If tag name is not known, use '*' is regX.
		
		//xPath with Single attribute //*[@attributeName='value]/tag OR //tagname[@attributeName='value]
		String search_word;
		search_word = xPathdriver.findElement(By.xpath("//h2[normalize-space()='Welcome to our store']")).getText();
		System.out.println("TEst is: "+search_word);
		xPathdriver.findElement(By.xpath("//img[@title='Show products in category Apparel']")).click();
			actual_string= xPathdriver.findElement(By.xpath("//h1[normalize-space()='Apparel']")).getText();
			expected_string="Apparel";
			cssSelector_learning.myAssertion(actual_string, expected_string);
				
		// xPath with Multiple attribute //tagname[@attributeName='value][@attributeName='value]
		xPathdriver.findElement(By.xpath("//img[@alt='Picture for category Shoes'][@title='Show products in category Shoes']")).click();
			actual_string= xPathdriver.findElement(By.xpath("//h1[normalize-space()='Shoes']")).getText();
			expected_string="Shoes";
			cssSelector_learning.myAssertion(actual_string, expected_string);
		
		// xPath with AND operator //tagname[@attributeName='value and @attributeName='value]
		// xPath with OR operator //tagname[@attributeName='value or @attributeName='value]
		// xPath with text() if the attribute is not there and only text is tehre then use fn text() //*[text()='TEXT']
			boolean displayStatus = xPathdriver.findElement(By.xpath("//*[text()='per page']")).isDisplayed();
			System.out.println("Label 1 Display status: " + displayStatus);
			
		// xPath with contains method operator //tagname[contains(@attributeName,'valuehalf')]
		// xPath with contains method operator //tagname[starts-with(@attributeName,'valuehalf')]
			displayStatus = xPathdriver.findElement(By.xpath("//select[starts-with(@name,'products-orderby')]")).isDisplayed();
			System.out.println("Label 2 Display status: " + displayStatus);
			
			
			
				
		// ------------------End Test----------------------	
		xPathdriver.quit();
	} // public static void xPathSelector() {

} // public class xPath_Learning {
