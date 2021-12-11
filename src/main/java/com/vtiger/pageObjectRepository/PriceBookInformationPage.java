package com.vtiger.pageObjectRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import com.vtiger.genericlibrary.BaseTest;
/**
 * This generic class used for store the all element present in Price book information page
 * @author Manjunath
 *
 */
public class PriceBookInformationPage extends BaseTest {

	@FindBy(name="Edit") private WebElement editBtn;
	@FindBy(xpath="//a[text()='More Information']") private WebElement moreInfoLink;
	@FindBy(xpath="//span[@class='lvtHeaderText']")private WebElement createPage;
	@FindBy(name="bookname")private WebElement bookNameTB;
	@FindBy(name="description") private WebElement descTB;
	@FindBy(xpath="//input[@class='crmbutton small save']") private WebElement saveBtn;
	@FindBy(xpath="//td[@class='dvtSelectedCell']")private WebElement priceBookPage;
	@FindBy(name="Duplicate")private WebElement duplicate;
	@FindBy(xpath="//a[@class='hdrLink']") private WebElement backToPB;
	@FindBy(id="jumpBtnIdTop") private WebElement jumpToBtn;
	@FindBy(xpath="//div[@id='lstRecordLayout']//a")private List<WebElement> jumpList;

	public PriceBookInformationPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getMoreInfoLink() {
		return moreInfoLink;
	}
	


	public WebElement getDuplicate() {
		return duplicate;
	}


	public WebElement getJumpToBtn() {
		return jumpToBtn;
	}


	public List<WebElement> getJumpList() {
		return jumpList;
	}


	public WebElement getBackToPB() {
		return backToPB;
	}


	public WebElement getEditBtn() {
		return editBtn;
	}
	
	public void editPickedLastView()
	{
		editBtn.click();
		Reporter.log("Edit link clicked",true);
	}
	
	public WebElement getBookNameTB() {
		return bookNameTB;
	}


	public void setBookNameTB(String bookName) {
		bookNameTB.sendKeys(bookName);
	}


	public WebElement getDescTB() {
		return descTB;
	}


	public void setDescTB(String desc) {
		descTB.sendKeys(desc);
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}


	public WebElement getPriceBookPage() {
		return priceBookPage;
	}
	
	
	public WebElement getCreatePage() {
		return createPage;
	}


	public void createNewPB(String name,String desc){
		bookNameTB.sendKeys(name);
		descTB.clear();
		descTB.sendKeys(desc);
		saveBtn.click();
		Reporter.log(name+" price book created",true);
		
		
	}
	/**
	 * This method is used to move opened price book information to another price book by click the jump to button 
	 * @param num
	 */
	public void jumpToPB(int num){
		wdlib.waitForElement(getJumpToBtn());
		jumpToBtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("Jumped to  "+getJumpList().get(num).getText()+" Price book",true);
		getJumpList().get(num).click();
		
	}
}
