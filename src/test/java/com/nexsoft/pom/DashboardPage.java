package com.nexsoft.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nexsoft.utilities.Utilities;

public class DashboardPage {

	protected WebDriver driver;
	private Utilities util = new Utilities();

	@FindBy(css = "img.user-image")
	private WebElement profileBtn;
	@FindBy(css = ".pull-right a.btn.btn-default.btn-flat")
	private WebElement exitBtn;
	@FindBy(linkText = "CRUD Builder")
	private WebElement btnCrudBuilder;
	@FindBy(css = "span[class='hidden-xs']")
	private WebElement unameLabel;
	@FindBy(xpath = "//body/div[1]/div[2]/div/p")
	private List<WebElement> lstError;
	
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public CRUDBuilderPage clickCrudBuilder() {
		btnCrudBuilder.click();
		return PageFactory.initElements(driver, CRUDBuilderPage.class);
	}
	
	public String getUsername() {
		String uname = unameLabel.getText();
		return uname;
	}
	
	public List<String> getErrorText() {
		List<String> errorText = new ArrayList<String>();
		for (WebElement webElement : lstError) {
			errorText.add(webElement.getText());
		}
		return errorText;
	}
	
	public HomePage logout() {
		profileBtn.click();
		util.sleep(1000);
		exitBtn.click();

		return PageFactory.initElements(driver, HomePage.class);
	}
}
