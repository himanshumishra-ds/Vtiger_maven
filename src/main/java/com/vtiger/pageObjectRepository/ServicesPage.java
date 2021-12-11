package com.vtiger.pageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import com.vtiger.genericlibrary.BaseTest;
/**
 * This generic class is used to store all the WebElement and generic method on Service window Page
 * @author User
 *
 */
public class ServicesPage extends BaseTest {
	@FindBy(xpath="//input[@name='selected_id']") private WebElement checkBox;
	@FindBy(xpath="//input[@name='selected_id']/ancestor::td/following-sibling::td[1]")private List<WebElement> selServiceText;
	@FindBy(xpath="//input[@class='crmbutton small save']")private WebElement saveBtn;
	
	public ServicesPage() {
		PageFactory.initElements(BaseTest.driver, this);
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getCheckBox() {
		return checkBox;
	}

  public List<WebElement> getSelServiceText() {
		return selServiceText;
	}

/**
 * This method is used to add service to price book.
 */
  public void selectServices(){
		try{
		Reporter.log(getSelServiceText().get(0).getText()+" added",true);
		getSelServiceText().get(0).click();
		checkBox.click();
		saveBtn.click();
		}
		catch(Exception e)
		{
			Reporter.log("Please Add Service  ",true);
		}
	}

}
