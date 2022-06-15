package com.nexsoft.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CRUDBuilderPage {

	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"form_crud\"]/div/table/thead/tr/th")
	List<WebElement> cols;
	@FindBy(xpath = "//*[@id=\"tbody_crud\"]/tr/td[1]")
	List<WebElement> rows;
//	@FindBy(xpath = "//*[@id=\"tbody_crud\"]/tr")
//	List<WebElement> lstElement;

	public CRUDBuilderPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickSeeBtnFromTitle(String title) {
		int colLn = cols.size();
		int rowLn = rows.size();
		int iter = 1;
		System.out.println(colLn);
		System.out.println(rowLn);

		for (WebElement webElement : rows) {
			System.out.println(webElement.getText());
			WebElement see = driver.findElement(By.xpath("//tbody[@id='tbody_crud']/tr[" + iter + "]/td/a[1]"));
			WebElement titleText = driver.findElement(By.xpath("//tbody[@id='tbody_crud']/tr[" + iter + "]//td[2]"));

			System.out.println(titleText.getText());
			if (titleText.getText().equalsIgnoreCase(title)) {
				see.click();
				break;
			}
			iter++;
		}

//		WebElement[] arrElement = new WebElement[rowLn];
		/*
		 * for (WebElement webElement : lstElement) {
		 * System.out.println(webElement.getText()); arrElement[iter] = webElement;
		 * iter++; }
		 */

		/*
		 * for (int i = 0; i < rows.size(); i++) {
		 * System.out.println(arrElement[i].getText().substring(0,
		 * arrElement[i].getText().indexOf(" "))); }
		 */
	}
}
