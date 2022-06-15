package com.nexsoft.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CRUDBuilderPage {
//	table[1]/tbody[1]/tr/td[2]

	WebDriver driver;
	@FindBy(xpath = "//*[@id=\"form_crud\"]/div/table/thead/tr/th")
	List<WebElement> cols;
	@FindBy(xpath = "//*[@id=\"form_crud\"]/div/table/tbody/tr/td[1]")
	List<WebElement> rows;
	@FindBy(xpath = "//*[@id=\\\"form_crud\\\"]/div/table/thead/tr")
	List<WebElement> lstElement;
	

	public CRUDBuilderPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickSeeBtnFromTitle(String title) {
		System.out.println(cols.size());
		System.out.println(rows.size());
		
		for (WebElement webElement : lstElement) {
			System.out.println(webElement.getText());
		}
		
		for (int i = 1; i < rows.size(); i++) {
			
		}
	}
}
