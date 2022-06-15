package com.nexsoft.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgetPasswordPage {
	
	protected WebDriver driver;
	
	public ForgetPasswordPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(css = ".login-box-msg")
	private WebElement msgLabelReset;
	
	public String getLabel() {
		String label = msgLabelReset.getText();
		return label;
	}
}
