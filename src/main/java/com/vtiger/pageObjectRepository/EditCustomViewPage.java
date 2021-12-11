package com.vtiger.pageObjectRepository;

import com.vtiger.genericlibrary.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
/**
 * This generic class is used to store all the WebElement and generic method on Edit Custom View page
 * @author User
 *
 */
public class EditCustomViewPage extends BaseTest {

	@FindBy(xpath="//span[@class='lvtHeaderText']") private WebElement editwPage;
	@FindBy(name="viewName")private WebElement viewNameText;
	@FindBy(xpath="//input[@class='crmbutton small save']") private WebElement saveBtn;
	@FindBy(xpath="(//select[contains(@id,'column')])[3]") private WebElement selCol;
	
	
	
	public EditCustomViewPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void getViewNameText(String name) {
		viewNameText.sendKeys(name);
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getEditPage() {
		return editwPage;
	}
	/**
	 * This method is used to enter value to filter name text field
	 * @param name
	 */
	public void editFilter(String name)
	{
		viewNameText.clear();
		viewNameText.sendKeys(name);
		
		Reporter.log(name+" Filter name edited",true);
	}
	/**
	 * This method is used to select options from drop-down
	 * 	 * @param name
	 */
	public void selectColOpt(String name)
	{
		Select s1=new Select(selCol);
		s1.selectByVisibleText(name);	
	}
}
