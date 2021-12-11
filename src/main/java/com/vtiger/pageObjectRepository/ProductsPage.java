package com.vtiger.pageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import com.vtiger.genericlibrary.BaseTest;

/**
 * This generic class is used to store all the WebElement and generic method on product window Page
 * @author User
 *
 */
public class ProductsPage extends BaseTest {
	@FindBy(name="selected_id")private WebElement checkBox;
	@FindBy(xpath="//input[@name='selected_id']/ancestor::td/following-sibling::td[1]")private List<WebElement> selProductText;
	@FindBy(xpath="//input[@class='crmbutton small save']")private WebElement saveBtn;
	
	
	public ProductsPage() {
		PageFactory.initElements(BaseTest.driver, this);
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}


	public WebElement getCheckBox() {
		return checkBox;
	}


	public List<WebElement> getSelProductText() {
		return selProductText;
	}
	/**
	 * This method is used to add product to Price book
	 */
	public void selectProducts(){
		
		try{
		Reporter.log(getSelProductText().get(0).getText()+" added",true);
		getSelProductText().get(0).click();
		checkBox.click();
		saveBtn.click();
		}
		catch(Exception e)
		{
			Reporter.log("Please add products  ",true);
		}
	}

}
