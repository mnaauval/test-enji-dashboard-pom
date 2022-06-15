package com.nexsoft.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	protected WebDriver driver;

	@FindBy(name = "username")
	private WebElement uname;
	@FindBy(name = "password")
	private WebElement password;
	@FindBy(css = ".btn.btn-primary.btn-block.btn-flat")
	private WebElement btnSignIn;
	@FindBy(css = "a[href='http://localhost:80/cicool/administrator/forgot-password']")
	private WebElement forgetPasswordBtn;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}

	public DashboardPage login(String uname, String password) {
		this.uname.clear();
		this.uname.sendKeys(uname);
		this.password.clear();
		this.password.sendKeys(password);
		btnSignIn.click();

		return PageFactory.initElements(driver, DashboardPage.class);
	}
	
	public ForgetPasswordPage clickForgetPassword() {
		forgetPasswordBtn.click();
		return PageFactory.initElements(driver, ForgetPasswordPage.class);
	}
	
	

}
