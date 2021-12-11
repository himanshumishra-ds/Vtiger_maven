package com.vtiger.pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericlibrary.BaseTest;

/**
 * This generic class is used to store all the WebElement and generic method on Price book setting Page
 * @author User
 *
 */
public class PriceBookSettingPage extends BaseTest {

	@FindBy(xpath="//a[contains(text(),'Layout Editor')]")private WebElement layoutEditor;
	
	public PriceBookSettingPage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLayoutEditor() {
		return layoutEditor;
	}
	/**
	 * This generic reusable method is used to Go to Layout Editor page
	 * @throws Throwable
	 */
	public void goToLayoutEditorPage() throws Throwable
	{
		layoutEditor.click();
		LayoutEditorPage lypage=new LayoutEditorPage();
	    wdlib.verify(lypage.getLayoutpage().getText(),flib.getPropKeyValue(PROP_PATH, "LayoutEditorPage") , "Layout Editor Page");
			
		
	}

}
