package com.vtiger.pageObjectRepository;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import com.vtiger.genericlibrary.BaseTest;

/**
 * This generic class is used to store all the WebElement and generic method on price book More Information page
 * @author User
 *
 */
public class MoreInformationPage extends BaseTest {
	@FindBy(xpath="(//td[text()='More Information'])[1]") private WebElement moreInfoPage;
	@FindBy(xpath="//img[@id='show_PriceBooks_Products']") private WebElement selProductOpt;
	@FindBy(xpath="(//div[@id='tbl_PriceBooks_Products']/table[2]//tr/td[1])[2]") private WebElement productText;
	@FindBy(xpath="//input[@title='Select Products']") private WebElement selPproductBtn;
	@FindBy(xpath="//div[@id='tbl_PriceBooks_Products']/table[2]//tr/td[5]/img[@title='Delete']") private WebElement deleteProduct;
	@FindBy(xpath="//img[@id='show_PriceBooks_Services']")private WebElement selServicOpt;
	@FindBy(xpath="(//div[@id='tbl_PriceBooks_Services']/table[2]//tr/td[1])[2]") private WebElement serviceText;
	@FindBy(xpath="//input[@title='Select Services']")private WebElement selServiceBtn;
	@FindBy(xpath="//div[@id='tbl_PriceBooks_Services']/table[2]//tr/td[4]/img[@title='Delete']")private WebElement deleteService;
	@FindBy(xpath="//div[@id='tbl_PriceBooks_Products']/table[2]//tr/td[5]/img[@title='Edit']")private WebElement editBtn;
	@FindBy(xpath="//input[@id='list_price']")private WebElement  editPrice;
	@FindBy(xpath="//input[@class='crmbutton small save']")private WebElement saveBtn;
	@FindBy(xpath="(//div[@id='tbl_PriceBooks_Services']/table[2]//tr/td[4]/img[@title='Edit'])[1]")private WebElement editService;
	
	
	public MoreInformationPage() {
		PageFactory.initElements(BaseTest.driver, this);
	}


	public WebElement getMoreInfoPage() {
		return moreInfoPage;
	}
	/**
	 * This method used to verify the more information page.
	 * @throws Throwable
	 */
	public void verifyMoreInfoPage() throws Throwable{
		wdlib.verify(getMoreInfoPage().getText(),flib.getPropKeyValue(PROP_PATH, "MoreInfo"), "More Information page");
	}

	public WebElement getSelProductOpt() {
		return selProductOpt;
	}


	public WebElement getProductText() {
		return productText;
	}


	public WebElement getSelPproductBtn() {
		return selPproductBtn;
	}


	public WebElement getDeleteProduct() {
		return deleteProduct;
	}
	
	
	public WebElement getSelServicOpt() {
		return selServicOpt;
	}


	public WebElement getServiceText() {
		return serviceText;
	}


	public WebElement getSelServiceBtn() {
		return selServiceBtn;
	}


	public WebElement getDeleteService() {
		return deleteService;
	}


	public void goToProductsSection(){
		selProductOpt.click();
	}
	

	public void deleteProduct() throws Throwable{
		
		verifyMoreInfoPage();
		wdlib.waitForElement(getDeleteProduct());
		deleteProduct.click();
		wdlib.handleAlert();
	}
	
	/**
	 * This method is used to verify product is added to the opened price book.
	 * @throws Throwable
	 */
	public void verifyProduct() throws Throwable{
		wdlib.waitForElement(getProductText());
		
		if(!getProductText().getText().equals("None Included"))
		{
			Reporter.log(getProductText().getText()+" was deleted",true);
			deleteProduct();
		}
		
	}
	public void verifyAndDeleteProduct() throws Throwable{
		goToProductsSection();
		wdlib.waitForElement(getProductText());
		Reporter.log(getProductText().getText(),true);
		if(getProductText().getText().equals("None Included"))
		{
			selPproductBtn.click();
			wdlib.verify(wdlib.getPageTitle(),flib.getPropKeyValue(PROP_PATH, "ProductsPage") , "Products Page ");
			ProductsPage pdpage=new ProductsPage();
			pdpage.selectProducts();
			deleteProduct();
			driver.navigate().refresh();
		}
		else
		{
			deleteProduct();
			driver.navigate().refresh();
		}
	}
	/**
	 * This generic reusable method is used to Add the product to opened Price Book 
	 * @throws Throwable
	 */
	
	public void addProduct() throws Throwable
	{
		goToProductsSection();
		verifyProduct();
		selPproductBtn.click();
		wdlib.verify(wdlib.getPageTitle(),flib.getPropKeyValue(PROP_PATH, "ProductsPage") , "Products Page ");
		ProductsPage pdpage=new ProductsPage();
		pdpage.selectProducts();
	}
	
	/**
	 * This generic reusable method is used to Add Service to opened Price Book
	 * @throws Throwable
	 */
	public void addService() throws Throwable
	{
		selServicOpt.click();
		verifyService();
		wdlib.waitForElement(getSelServiceBtn());
		selServiceBtn.click();
		wdlib.verify(wdlib.getPageTitle(),flib.getPropKeyValue(PROP_PATH, "ServicesPage") , "Services Page ");
		ServicesPage svpage=new ServicesPage();
		svpage.selectServices();
		
	}
		
	
	public void deleteService() throws Throwable{
		verifyMoreInfoPage();
		wdlib.waitForElement(getDeleteService());
		deleteService.click();
		wdlib.handleAlert();
		driver.navigate().refresh();
		
	}
	/**
	 * This method is used to verify service in opened price book.
	 * @throws Throwable
	 */
	public void verifyService() throws Throwable{
		wdlib.waitForElement(getServiceText());
		
		if(!getServiceText().getText().equals("None Included"))
		{
			Reporter.log(getServiceText().getText()+" is deleted",true);
			deleteService();
		}
	}
	/**
	 * This method is used to verify the service and if present delete otherwise add and delete.
	 * @throws Throwable
	 */
	public void verifyToDeleteService() throws Throwable{
		ServicesPage srvpage=new ServicesPage();
		selServicOpt.click();
		wdlib.waitForElement(getServiceText());
		
		if(getServiceText().getText().equals("None Included"))
		{
			Reporter.log(getServiceText().getText()+" is deleted",true);
			selServiceBtn.click();
			wdlib.verify(wdlib.getPageTitle(),flib.getPropKeyValue(PROP_PATH, "ServicesPage") , "Services Page ");
			srvpage.selectServices();
			deleteService();
			
		}
		else
		{
			deleteService();
		}
	}


	public WebElement getEditService() {
		return editService;
	}


	public WebElement getEditBtn() {
		return editBtn;
	}


	public WebElement getEditPrice() {
		return editPrice;
	}


	public void setEditPrice(String editPrice) {
		editPrice.split(editPrice);
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void addNewPrice(String price){
		
		BaseTest.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		editPrice.clear();
		editPrice.sendKeys(price);
		Reporter.log("new price value "+price+" is updated ",true);
		saveBtn.click();
	}
	
	/**
	 * This method is used to edit product price.
	 * @param price
	 */
	public void editProductPrice(String price){
		wdlib.waitForElement(getProductText());
		if(getProductText().getText().equals("None Included")){
			selPproductBtn.click();
			ProductsPage pdpage=new ProductsPage();
			pdpage.selectProducts();
			driver.navigate().refresh();
			selProductOpt.click();
			wdlib.waitForElement(getProductText());
			editBtn.click();
			addNewPrice(price);
		}
		else{
			
			editBtn.click();
			addNewPrice(price);
		}
		driver.navigate().refresh();
	}
/**
 * this method is used to edit price value of service from opened price book
 * @param price
 */
	public void editServicePrice(String price){
		wdlib.waitForElement(getServiceText());
		if(getServiceText().getText().equals("None Included")){
			selServiceBtn.click();
			ServicesPage srvpage=new ServicesPage();
			srvpage.selectServices();
//			driver.navigate().refresh();
			selServicOpt.click();
			wdlib.waitForElement(getServiceText());
			editService.click();
			addNewPrice(price);
		}
		else{
			editService.click();
			addNewPrice(price);
		}
		driver.navigate().refresh();
	}

}
