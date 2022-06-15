package com.nexsoft.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nexsoft.pom.DashboardPage;
import com.nexsoft.pom.HomePage;
import com.nexsoft.utilities.Utilities;

public class LoginAndCRUDTest {
	private WebDriver driver;
	private HomePage home;
	private DashboardPage dashBoard;
	private Utilities util;

	@BeforeClass
	public void init() {
		System.setProperty("url", "http://localhost/cicool/");
		System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
		driver = new ChromeDriver();
		home = PageFactory.initElements(driver, HomePage.class);
		dashBoard = PageFactory.initElements(driver, DashboardPage.class);
		util = new Utilities();
		driver.get(System.getProperty("url"));
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void loginAndGoToCRUD() {
		home.clickSignIn().login("mnaauval@gmail.com", "admin123").clickCrudBuilder().clickSeeBtnFromTitle("Testdb");
	}

	@AfterClass
	public void closeConn() {
//		dashBoard.logout();

		util.sleep(3000);
		driver.close();
	}

}
