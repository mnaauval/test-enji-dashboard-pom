package com.nexsoft.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CRUDBuilderPage {
//	table[1]/tbody[1]/tr/td[2]

	WebDriver driver;
	@FindBy(xpath = "//table[1]/tbody[1]/tr")
	List<WebElement> lstTable;
	
	public CRUDBuilderPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickSeeBtnFromTitle(String title) {
		int iter = 0;
		for (WebElement webElement : lstTable) {
//			System.out.println(iter++);
//			iter++;
			System.out.println(webElement);
//			WebElement see = webElement.findElement(By.xpath("//td/a[1]"));
//			WebElement text = webElement.findElement(By.xpath("//td[2]"));
//			
//			if (text.getText().contains(title)) see.click();
		}
	}
	
}
