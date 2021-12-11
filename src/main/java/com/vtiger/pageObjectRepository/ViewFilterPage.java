package com.vtiger.pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vtiger.genericlibrary.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

/**
 * This generic class used for store the all element present in View Filter Page
 * @author Manjunath
 *
 */
public class ViewFilterPage extends BaseTest {
	@FindBy(xpath="//a[text()='Create Filter']") private WebElement createfilterbtn;
	@FindBy(name="viewName") private WebElement viewNameText;
	@FindBy(xpath="(//select[contains(@name,'colum')])[3]") private WebElement selectCol;
	@FindBy(xpath="//input[@class='crmbutton small save']") private WebElement saveBtn;
	@FindBy(xpath="//span[@class='lvtHeaderText']")private WebElement pageDisplay;
	
	public ViewFilterPage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreatefilterbtn() {
		return createfilterbtn;
	}

	public void clickCreatefilterbtn() {
		createfilterbtn.click();
	}

	public WebElement getPageDisplay() {
		return pageDisplay;
	}

	public WebElement getViewNameText() {
		return viewNameText;
	}

	public void setViewNameText(String text) {
		viewNameText.sendKeys(text);
	}

	public WebElement getSelectCol() {
		return selectCol;
	}

	public void setSelectCol(String text) {
		selectCol.sendKeys(text);
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void setSaveBtn() {
		saveBtn.click();
	}
	
	public void clickCreatViewFilter()
	{
		createfilterbtn.click();
	}
	
	public void createNewFilter(String text,String colName)
	{
		viewNameText.sendKeys(text);
		wdlib.selectOption(selectCol, colName);
		saveBtn.click();
		Reporter.log(text+" New Filter displayed",true);
	}
	/**
	 * This generic reusable method is used to create Filter under Price Book Page
	 * @throws Throwable
	 */
	public void createFilter() throws Throwable
	{
		//verify the New Custom view page
		    clickCreatViewFilter();
		wdlib.verify(getPageDisplay().getText(), flib.getCellData(EXCEL_PATH, "Data", 2, 1), "New Custom view ");
		
		String addFilter=flib.getCellData(EXCEL_PATH, "Data", 3, 1);
		//Enter the text value to View name textbox
		String colText=flib.getCellData(EXCEL_PATH, "Data", 4, 1);
		createNewFilter(addFilter, colText);
	}

}
