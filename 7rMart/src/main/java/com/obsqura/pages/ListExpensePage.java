package com.obsqura.pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.PageActions;

public class ListExpensePage extends PageActions{

	private WebDriver driver;
	
	public ListExpensePage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="ex_type")
	private WebElement selectDropdownExpenseType;
	
	@FindBy(id="amount")
	private WebElement amountInput;
	
//	@FindBy(xpath="//*[@type='file']")
//	private WebElement chooseFile;
	

	public String createListExpense(String filePath) throws AWTException {
		clickElement(newBtn);
		setstaticDropdown(selectDropdownExpenseType ,"Credit Bank");
		setTextBox(amountInput,"456");
		scrollToBottomofPage();
		ShortWait();
		WebElement chooseFile=	driver.findElement(By.xpath("//*[@for='userfile']//following-sibling::input"));
		uploadFile(chooseFile,filePath);
		clickElement(saveBtn);
		String alertText=alertMsg.getText();
		return getSplitStringText(alertText);
		
	}
	
}