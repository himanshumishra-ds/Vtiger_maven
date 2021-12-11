package com.vtiger.pageObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.vtiger.genericlibrary.BaseTest;

/**
 * This generic class used for store the all element  present in Price book page
 * @author Manjunath
 *
 */
public class PriceBooksPage extends BaseTest{


	@FindBy(xpath="(//input[@class='crmbutton small edit' and @value='Mass Edit'])[1]") private WebElement massEdit;
	@FindBy(name="bookname") private WebElement editText;
	@FindBy(xpath="//input[@class='crmbutton small save']") private WebElement saveBtn;
	@FindBy(id="qccombo") private WebElement quickCreate;
	@FindBy(name="bookname") private WebElement quickTextField;
	@FindBy(xpath="//textarea[@class='detailedViewTextBox']")private WebElement quickDescription;
	@FindBy(xpath="//a[text()='Delete']") private WebElement deletLink;
	@FindBy(id="viewname") private WebElement selFilter;
	@FindBy(xpath="//a[text()='Edit']") private WebElement editLink;
	@FindBy(xpath="//img[@title='Last Viewed']") private WebElement lastView;
	@FindBy(xpath="//table[@class='hdrNameBg']//a")private List<WebElement> viewLists;
	@FindBy(xpath="//img[@title='Create Price Book...']") private WebElement CreateNewPB;
	@FindBy(xpath="//a[text()='More']") private WebElement moreLink;
	@FindBy(xpath="//a[text()='Price Books']") private WebElement morePB;
	@FindBy(xpath="//img[@title='Price Books Settings']") private WebElement settingLink;
	@FindBy(xpath="//td[@class='small']/img[@src='themes/softed/images/user.PNG']") private WebElement logoutImage;
	@FindBy(xpath="//a[text()='Sign Out']") private WebElement logoutLink;
	@FindBy(xpath="//tr[contains(@id,'row')]//td[3]/a") private List<WebElement> pbList;
	@FindBy(xpath="//tr[contains(@id,'row')]/td/input") private List<WebElement> pbCheckBox;
	@FindBy(xpath="(//input[@class='crmbutton small delete'])[1]")private WebElement deletePBBtn;
	@FindBy(xpath="//span[@class='genHeaderSmall']")private WebElement worrning;
	@FindBy(xpath="//a[@title='Price Books']")private List<WebElement> pbNameList;
	@FindBy(xpath="//a[text()='Go to Advanced Search']")private WebElement advSearchLink;
	@FindBy(className="detailedViewTextBox")private WebElement searchForFirstOpt;
	@FindBy(className="repBox")private WebElement searchInFirstOpt;
	@FindBy(xpath="//input[@class='repBox']")private WebElement searchTBFirst;
	@FindBy(xpath="//input[@value='New Condition']")private WebElement newCustBtn;
	@FindBy(xpath="(//select[@class='detailedViewTextBox'])[3]")private WebElement searchForSecondOpt;
	@FindBy(xpath="(//select[@class='repBox'])[2]")private WebElement searchInSecOpt;
	@FindBy(xpath="(//input[@class='repBox'])[2]")private WebElement searchTBSecond;
	@FindBy(xpath="(//input[@class='crmbutton small create'])[2]")private WebElement searchNowBtn;
	@FindBy(xpath="//td[contains(@id,'alpha')]")private List<WebElement> alphList;
	@FindBy(name="search_text")private WebElement searchTextBox;
	@FindBy(id="bas_searchfield")private WebElement searchByList;
	@FindBy(name="submit")private WebElement searchBtn;
	
	public PriceBooksPage() {
		PageFactory.initElements(driver, this);
	}
	public WebElement getLogoutImage() {
		return logoutImage;
	}


	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
	
	public List<WebElement> getPbNameList() {
		return pbNameList;
	}
	
	/**
	 * This method is used to select price book from the records
	 */
	
	public void selectPriceBook(){
		Reporter.log(pbNameList.get(0).getText()+" price book is selected",true);
		pbNameList.get(0).click();
		
	}
	
	
	public WebElement getWorrning() {
		return worrning;
	}
	public List<WebElement> getPbCheckBox() {
		return pbCheckBox;
	}
	public WebElement getDeletePBBtn() {
		return deletePBBtn;
	}
	public WebElement getLastView() {
		return lastView;
	}

	public List<WebElement> getViewLists() {
		return viewLists;
	}
	/**
	 * This generic reused method is used to find the recently viewed Price book  
	 * @param index
	 */
	public void pickLastView(int index)
	{
		lastView.click();
		Reporter.log(viewLists.get(index).getText()+" last viewed Price Book selected ",true);
		viewLists.get(index).click();
		
	}
	
	
	public WebElement getEditLink() {
		return editLink;
	}

	public WebElement getSelFilter() {
		return selFilter;
	}

	
	public WebElement getDeletLink() {
		return deletLink;
	}


	public WebElement getEditText() {
		return editText;
	}
	public void setEditText(String text) {
		editText.sendKeys(text);
	}
	

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	/**
	 * This generic reused method is used to Mass editing option on selected records by clicking on mass edit button button in Price Book page
	 */
	public void goToMassEdit()
	{
		massEdit.click();
	}
	/**
	 *  This generic reused method is used to Mass editing the price book name on selected recodes in Price book page
     *  @param name
	 */
	public void massEditRecords(String name)
	{
		wdlib.waitForElement(getEditText());
		editText.sendKeys(name);
		saveBtn.click();
		Reporter.log("Selected records name text field was changed to  "+name+" by Mass Editting",true);
	}
	
	


	public WebElement getQuickCreate() {
		return quickCreate;
	}

	public WebElement getQuickTextField() {
		return quickTextField;
	}
	
	public void getQuickTextField(String text) {
		quickTextField.sendKeys(text);
	}

	public void getQuickDescription(String text) {
		quickDescription.sendKeys(text);;
	}

	/**
	 * This generic method is used to  quick create Price book 
	 * @param nm
	 */
	public void selectQuickCreateOption(String nm){
		Select sel=new Select(quickCreate);
		sel.selectByVisibleText(nm);
		Reporter.log(nm+" is selected from Quick create",true);
	}
	
	/**
	 * This generic reused method  is use to enter Name and Description on quick create Price book pop-up  
	 * @param name
	 * @param desc
	 */
	public void quickCreatePriceBook(String name,String desc)
	{
		wdlib.waitForElement(getQuickTextField());
		quickTextField.sendKeys(name);
		quickDescription.sendKeys(desc);
		saveBtn.click();
		Reporter.log(name+" price book created",true);
	}
	/**
	 * This method used to select options from drop-down list
	 * @param index
	 */
	public void selectFilter(int index)
	{
		Select sel=new Select(selFilter);
		Reporter.log(sel.getOptions().get(index).getText()+" filter selected");
		sel.selectByIndex(index);
	}
	
	/**
	 * This generic reusable method is used to delete Price Book from records under Price Book Page
	 */
	public void deletePriceBook()
	{
		try{
			//Click on delete button
			getDeletePBBtn().click();
			//Handling pop-up
			wdlib.handleAlert();
			Reporter.log("Checked record was deleted from price book",true);
		}
		catch(Exception e)
		{
			Reporter.log(""+e,true);
			
		}
		driver.navigate().refresh();
	}
	
	
	
	public void clickDeleteFilter()
	{
		deletLink.click();
	}
	
	

	public WebElement getCreateNewPB() {
		return CreateNewPB;
	}
	/**
	 * This method is used to do clicking operation on Plus icon in the Price book page
	 */
	public void createNewPriceBook(){
		CreateNewPB.click();
	}


	public WebElement getMoreLink() {
		return moreLink;
	}


	public WebElement getMorePB() {
		return morePB;
	}


	public WebElement getSettingLink() {
		return settingLink;
	}
	
	public void selectPriceBookFromMore()
	{
		Actions a = new Actions(driver);
		a.moveToElement(moreLink).perform();
		morePB.click();
	}
    /**
     * This method is used to do clicking operation on Setting 
     */
	public void goToSetting(){
		settingLink.click();
	}
	public List<WebElement> getPbList() {
		return pbList;
	}
	/**
	 * This method is used to select particular price book by index
	 * @param index
	 */
	public void selectPB(int index){
		Reporter.log(getPbList().get(1).getText()+" price book was selected",true);
		getPbList().get(index).click();
	}
	public WebElement getSearchTBFirst() {
		return searchTBFirst;
	}
	public void setSearchTBFirst(String value) {
		searchTBFirst.sendKeys(value);
	}
	public WebElement getSearchTBSecond() {
		return searchTBSecond;
	}
	public void setSearchTBSecond(String value) {
		searchTBSecond.sendKeys(value);
	}
	public WebElement getAdvSearchLink() {
		return advSearchLink;
	}
	public WebElement getSearchForFirstOpt() {
		return searchForFirstOpt;
	}
	public WebElement getSearchInFirstOpt() {
		return searchInFirstOpt;
	}
	public WebElement getSearchForSecondOpt() {
		return searchForSecondOpt;
	}
	public WebElement getSearchInSecOpt() {
		return searchInSecOpt;
	}
	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	/**
	 * this method is used to advance search for record
	 */
	
	public void goToAdvanceSearch(){
		advSearchLink.click();
		Reporter.log("Advance Search option displayed",true);
	}
	/**
	 * this method is used to get new condition options for search
	 */
	public void getNewCondition(){
		newCustBtn.click();
		Reporter.log("New Condition Option are displayed",true);
	}
	public void searchNow(){
		searchNowBtn.click();
		Reporter.log("Adavance Search Done",true);
	}
	
	public void selectFirstSearch(String value1,String value2,String text){
		Select s1=new Select(getSearchForFirstOpt());
		s1.selectByVisibleText(value1);
		Select s2=new Select(getSearchInFirstOpt());
		s2.selectByVisibleText(value2);
		searchTBFirst.sendKeys(text);
	}
	
	public void selectSecondSearch(String value1,String value2,String text){
		Select s1=new Select(getSearchForSecondOpt());
		s1.selectByVisibleText(value1);
		Select s2=new Select(getSearchInSecOpt());
		s2.selectByVisibleText(value2);
		searchTBSecond.sendKeys(text);
	}
	public List<WebElement> getAlphList() {
		return alphList;
	}
	 
	/**
	 * This method is used to search by given alphabet
	 * @param value
	 */
	public void searchByAlph(String value){
		for (WebElement ele : alphList) {
			if(ele.getText().equalsIgnoreCase(value)){
				ele.click();
			}
		}
		
	}
	/**
	 * This generic reusable method is used to select Price book under Price Book page
	 * @param index
	 */
	
	public void selectPriceBook(int index)
	{
		//Select the record by check box
		wdlib.waitForElement(getPbCheckBox().get(0));
		if(getPbCheckBox().size()!=0)
			{
			    getPbCheckBox().get(index-1).click();
				Reporter.log(index+"th record is checked",true);
			}
			else
			{
				handleWarning();
			}
	}
	/**
	 * This method is used to get the searched results
	 */
	public void checkSearchResult(){
		if(getPbCheckBox().size()!=0)
		{
			Reporter.log("Search result found ",true);
			for(WebElement ele:pbNameList){
				Reporter.log(ele.getText(),true);
			}
		}
		else
		{
			handleWarning();
		}
	}
	public void handleWarning()
	{
		if(getWorrning().isDisplayed())
		{
			Reporter.log(getWorrning().getText(),true);
		}
	}
	
	
	
	public WebElement getSearchTextBox() {
		return searchTextBox;
	}
	public void setSearchTextBox(String text) {
		searchTextBox.sendKeys(text);;
	}
	public WebElement getSearchByList() {
		return searchByList;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public void searchNow(String value,String opt){
		searchTextBox.sendKeys(value);
		Select sel=new Select(getSearchByList());
		sel.selectByVisibleText(opt);
		searchBtn.click();
	}
	
	/**
	 * This generic reusable method is used to open the PriceBook page
	 * @throws Throwable
	 */
	public void goToPriceBookPage() throws Throwable
	{
		selectPriceBookFromMore();
	    wdlib.waitForPage(flib.getPropKeyValue(PROP_PATH, "priceBookTitle"));
	    //verify the priceBook Page 
	    wdlib.verify(wdlib.getPageTitle(), flib.getPropKeyValue(PROP_PATH, "priceBookTitle"), "Price Book Page");
	}
	
	
	/**
	 * This generic reusable method is used to delete filter under price book page
	 */
	public void deleteFilter()
	{
		try
		{
		//select Filter
		selectFilter(1);
		//Click on Delete link to delete selected filter
		clickDeleteFilter();
		//handle the Alert window
		wdlib.handleAlert();
		}
		catch(Exception e)
		{
			Reporter.log("Except 'All' filter any other filter must be there");
		}
	}
	

	
	
}
