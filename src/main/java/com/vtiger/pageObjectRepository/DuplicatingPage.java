package com.vtiger.pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericlibrary.BaseTest;

/**
 * This Test Class used to store elements of price book duplicating page
 * @author Manjunath
 *
 */
public class DuplicatingPage extends BaseTest {
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")private WebElement duplicatePage;
	@FindBy(xpath="//input[@class='crmbutton small save']") private WebElement saveBtn;
	
	public DuplicatingPage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getDuplicatePage() {
		return duplicatePage;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	

}
