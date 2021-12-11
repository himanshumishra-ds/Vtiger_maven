package com.vtiger.pageObjectRepository;

import com.vtiger.genericlibrary.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

/**
 * This generic class used for store the all element present in Edit Price Book Information Page
 * @author Manjunath
 *
 */

public class EditPriceBookInformationPage extends BaseTest {


	@FindBy(name="bookname")private WebElement bookName;
	@FindBy(name="description")private WebElement descTB;
	@FindBy(xpath="//input[@class='crmbutton small cancel']") private WebElement cancelBtn;
	@FindBy(xpath="//input[@class='crmbutton small save']")private WebElement saveBtn;
	@FindBy(xpath="//span[@class='lvtHeaderText']")private WebElement editPage;
	
	
	public EditPriceBookInformationPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getEditPage() {
		return editPage;
	}
	
	

	public WebElement getBookName() {
		return bookName;
	}

	/**
	 * this method is used to enter new price book name
	 * @param name
	 */
	public void enterBookName(String name) {
		bookName.clear();
		bookName.sendKeys(name);
		Reporter.log(name+" price book name entered");
	}
	public WebElement getDescTB() {
		return descTB;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}


	public void setDescTB(String desc) {
		descTB.sendKeys(desc);;
	}


	public WebElement getCancleBtn() {
		return cancelBtn;
	}
	
	public void enterText(String name)
	{
		bookName.clear();
		bookName.sendKeys(name);
		Reporter.log(name+" new price book name entered",true);
	}
	
	public void cancelEdit()
	{
		cancelBtn.click();
		Reporter.log("Edit was canceled ",true);
	}
	
	public void enterDescription(String desc){
		descTB.clear();
		descTB.sendKeys(desc);
	}
	
	/**
	 * This method is used to get the Edit page title
	 * @return
	 */
	public String editPBPage(){
		String st=getEditPage().getText();
		String pageText=st.substring(st.lastIndexOf("-"));
		return pageText;
	}
}
