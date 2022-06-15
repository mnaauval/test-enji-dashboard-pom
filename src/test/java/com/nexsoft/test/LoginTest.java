package com.nexsoft.test;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nexsoft.pom.DashboardPage;
import com.nexsoft.pom.HomePage;
import com.nexsoft.utilities.Screenshoot;
import com.nexsoft.utilities.Utilities;

public class LoginTest {

	private WebDriver driver;
	private HomePage home;
	private DashboardPage dashBoard;
	private Utilities util;
	private Screenshoot ss;
	private List<String> lstError;

	@BeforeClass
	public void init() {
		System.setProperty("url", "http://localhost/cicool/");
		System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
		driver = new ChromeDriver();
		home = PageFactory.initElements(driver, HomePage.class);
		dashBoard = PageFactory.initElements(driver, DashboardPage.class);
		util = new Utilities();
		ss = new Screenshoot();
		lstError = new ArrayList<String>();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void checkSession() {
		driver.get(System.getProperty("url"));
	}

	@Test(priority = 1)
	public void login_validUnameAndPassword() {
		String uname = home.clickSignIn().login("mnaauval@gmail.com", "admin123").getUsername();
		Assert.assertEquals(uname, "Kaeka");
		String file = "<img src='file://" + ss.screenShoot(driver) + "'height=\"350\" width=\"792\"/>";
		Reporter.log(file);
		dashBoard.logout();
	}

	@Test(priority = 2)
	public void login_validUname_notValidPassword() {
		lstError = home.clickSignIn().login("mnaauval@gmail.com", "admin555").getErrorText();
//		System.out.println(error);
		String[] expected = { "E-mail, Username or Password do not match." };
		Assert.assertEquals(lstError.toArray(), expected);
		String file = "<img src='file://" + ss.screenShoot(driver) + "'height=\"350\" width=\"792\"/>";
		Reporter.log(file);
	}

	@Test(priority = 3)
	public void login_notValidUnameAndPassword() {
		lstError = home.clickSignIn().login("islan_chelsea@gmail.com", "testadmin").getErrorText();
//		System.out.println(error);
		String[] expected = { "User does not exist" };
		Assert.assertEquals(lstError.toArray(), expected);
		String file = "<img src='file://" + ss.screenShoot(driver) + "'height=\"350\" width=\"792\"/>";
		Reporter.log(file);
	}

	@Test(priority = 4)
	public void login_emptyFields() {
		lstError = home.clickSignIn().login("", "").getErrorText();
//		System.out.println(error);
		String[] expected = { "", "The Username field is required.", "The Password field is required.", "" };
		Assert.assertEquals(lstError.toArray(), expected);
		String file = "<img src='file://" + ss.screenShoot(driver) + "'height=\"350\" width=\"792\"/>";
		Reporter.log(file);
	}

	@Test(priority = 5)
	public void checkForgetPassword() {
		String label = home.clickSignIn().clickForgetPassword().getLabel();
		assertEquals(label, "Send a link to reset the password");
		String file = "<img src='file://" + ss.screenShoot(driver) + "'height=\"350\" width=\"792\"/>";
		Reporter.log(file);
	}

	@AfterClass
	public void closeConn() {
//		dashBoard.logout();

		util.sleep(3000);
		driver.close();
	}
}
