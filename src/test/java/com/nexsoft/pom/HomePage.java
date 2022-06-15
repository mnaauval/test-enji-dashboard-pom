package com.nexsoft.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	protected WebDriver driver;
	
	@FindBy(css = ".fa.fa-sign-in")
	private WebElement signIn;
	@FindBy(css = "flag-icon flag-icon-gb")
	private WebElement language;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public SignInPage clickSignIn() {
		signIn.click();
		return PageFactory.initElements(driver, SignInPage.class);
	}
}
