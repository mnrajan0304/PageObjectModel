package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pageobjects.Baseclass;
import Pageobjects.LoginPageobjects;
import Pageobjects.SelectHotelPage;

public class LoginTestCase extends Baseclass {
	
	@BeforeMethod
	public void launch() {
		browserLaunch("chrome");
		maximize();
		get("https://adactinhotelapp.com/");
	}
	
	@Test
	public void loginTest() {
		LoginPageobjects loginpage = new LoginPageobjects();
		loginpage.login("manirajan", "Dhoni1234");
		SelectHotelPage selectHoltel = new SelectHotelPage();
		selectHoltel.seachHotel("Sydney", "Hotel Sunshine", "Double", "3 - Three", "02/03/2022", "03/04/2022", "2 - Two", "1 - One");

	}
	
	/*@Test
	public void hotelsSelectTest() {
		SelectHotelPage selectHoltel = new SelectHotelPage();
		selectHoltel.seachHotel("Sydney", "Hotel Sunshine", "Double", "3 - Three", "02/03/2022", "03/04/2022", "2 - Two", "1 - One");
	}*/
	
	@AfterMethod
	public void teardown() {
		quit();
	}
}
