package com.vtiger.pageObjectRepository;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.vtiger.genericlibrary.BaseTest;

/**
 * This generic class is used to store all the WebElement and generic method on Layout Editor Page
 * @author User
 *
 */
public class LayoutEditorPage extends BaseTest {

	@FindBy(xpath="//td[@class='heading2']/b") private WebElement layoutpage;
	@FindBy(xpath="//img[@title='Delete']") private List<WebElement> blockDelete;
	@FindBy(xpath="//input[@title='Add Block']") private WebElement addBlock;
	@FindBy(id="blocklabel") private WebElement blockName;
	@FindBy(id="after_blockid") private WebElement blockPosition;
	@FindBy(xpath="//div[@id='addblock']//input[@name='save']") private WebElement saveBtn;
	@FindBy(xpath="(//img[@title='Add Custom Field'])[1]") private WebElement addCustomBtn;
	@FindBy(xpath="//a[text()='  Date ']") private WebElement dateField;
	@FindBy(xpath="//input[contains(@id,'fldLabel')]") private WebElement fieldLabel;
	@FindBy(xpath="(//input[@name='save' and @value=' Save'])[1]") private WebElement saveCFBtn;
	@FindBy(xpath="//td[@id='colourButton']/span[text()='Date Info']") private WebElement dateInfo;
	@FindBy(xpath="//span[text()='Date Info']/ancestor::tr/td[2]/img[@title='Edit Properties']") private WebElement editProperties;
	@FindBy(xpath="//th[contains(text(),'Date Info')]/ancestor::div/table[2]//input[@name='delete']") private WebElement deleteProperties;
	@FindBy(xpath="//td[@id='colourButton']/span") private List<WebElement> labelsFind;
	@FindBy(xpath="//img[@title='Edit Properties']") private List<WebElement> editCheckBox;
	@FindBy(xpath="//th[contains(text(),'Description')]/ancestor::div/table[2]//input[contains(@id,'check')]") private List<WebElement> checkList;
	@FindBy(xpath="//tr[@class='detailedViewHeader']/th[contains(text(),'Description')]") private WebElement descLabel;
	@FindBy(xpath="//td[@class='dvtCellInfo'][2]") private  List<WebElement> checkboxText;
	@FindBy(xpath="(//td[@class='dvtCellInfo'][2]/input)[3]") private WebElement deftValue;
	@FindBy(xpath="//th[contains(text(),'Description')]/ancestor::div/table[2]//input[@name='save']") private WebElement descSaveBtn;
	@FindBy(xpath="(//span[text()='Price Book Name']/ancestor::tr/td[@class='colData small']/img[@title='Down'])[1]") private WebElement downArrow;
	@FindBy(xpath="(//span[text()='Price Book Name']/ancestor::tr/td[@class='colData small']/img[@title='Up'])[1]") private WebElement upArrow;
	@FindBy(xpath="//a[text()='  Pick List ']")private WebElement pickListOpt;
	@FindBy(xpath="//textarea[contains(@id,'fldPickList')]")private WebElement pickListValues;
	@FindBy(xpath="//span[text()='List Of Items']")private WebElement listLabel;
	@FindBy(xpath="//img[@title='Edit Properties']")private List<WebElement> editListlabel;
	@FindBy(xpath="//th[contains(text(),'List Of Items')]/ancestor::div/table[2]//input[@name='delete']")private WebElement delListLabel;
	@FindBy(xpath="//td[@id='colourButton']/span")private List<WebElement> showPropList;
	
	public LayoutEditorPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getLayoutpage() {
		return layoutpage;
	}
	
	


	public void getBlockName(String name) {
		blockName.sendKeys(name);;
	}


	public List<WebElement> getBlockDelete() {
		return blockDelete;
	}


	public WebElement getAddBlock() {
		return addBlock;
	}


	public WebElement getBlockPosition() {
		return blockPosition;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	/**
	 * This generic reusable method is used to delete created custom block from Layout Editor page
	 * @throws Throwable
	 */
	public void deleteBlock() throws Throwable
	{
		try
		{			
			blockDelete.get(0).click();
			wdlib.handleAlert();
			Reporter.log(" Custom Block deleted",true);
		}
		catch(Exception e)
		{
			addBlock();
			wdlib.waitForListElement(getBlockDelete());
			Thread.sleep(4000);
			blockDelete.get(0).click();
			wdlib.handleAlert();
			Reporter.log(" Custom Block deleted",true);
		}
	}
	public void clickAddBlockBtn(){
		addBlock.click();
	}
	
	public void blockVerify(){
		if(!getBlockDelete().isEmpty())
		{
			blockDelete.get(0).click();
			wdlib.handleAlert();
			Reporter.log(" Custom Block deleted",true);
		}else
		{
			Reporter.log("Add Block ",true);
		}
		
	}
	
	public void addNewBlock(String block,int position){
		blockName.sendKeys(block);
		wdlib.selectOption(blockPosition, 1);
		saveBtn.click();
	}

	public WebElement getAddCustomBtn() {
		return addCustomBtn;
	}

	public WebElement getDateField() {
		return dateField;
	}

	public void getFieldLabel(String lebal) {
		 fieldLabel.sendKeys(lebal);;
	}

	public WebElement getSaveCFBtn() {
		return saveCFBtn;
	}

	public WebElement getDateInfo() {
		return dateInfo;
	}

	public WebElement getEditProperties() {
		return editProperties;
	}

	public WebElement getDeleteProperties() {
		return deleteProperties;
	}
	
	public void addBlock() throws Throwable
	{
		
		blockVerify();
		driver.navigate().refresh();
		clickAddBlockBtn();
		//Enter the Block name 
		String priceBookTitle=flib.getCellData(EXCEL_PATH, "Data", 1, 1);
		addNewBlock(priceBookTitle,1);
		Reporter.log(priceBookTitle+" block added",true);
	}
	
	public void addField(String label){
		addCustomBtn.click();
		dateField.click();
		fieldLabel.sendKeys(label);
		Reporter.log(label+" field added ",true);
		saveCFBtn.click();
	}
	
	
	public List<WebElement> getShowPropList() {
		return showPropList;
	}


	public void deleteField(String label){
		for(int i=0;i<showPropList.size();i++){
		if(showPropList.get(i).getText().contains(label)){
			editListlabel.get(i).click();
			deleteProperties.click();
			Alert al =BaseTest.driver.switchTo().alert();
			al.accept();
			Reporter.log("Date Info  deleted",true);
		}
		}
	}

	public List<WebElement> getLabelsFind() {
		return labelsFind;
	}


	public List<WebElement> getEditCheckBox() {
		return editCheckBox;
	}


	public List<WebElement> getCheckList() {
		return checkList;
	}


	public List<WebElement> getCheckboxText() {
		return checkboxText;
	}


	public WebElement getDescSaveBtn() {
		return descSaveBtn;
	}
	
	
	
	public WebElement getDescLabel() {
		return descLabel;
	}


	public WebElement getDeftValue() {
		return deftValue;
	}

	/**
	 * This method is used to edit Description field in Layout Editor page
	 */
	public void clickDescriptionEdit(){
		for(int i=0;i<getLabelsFind().size();i++){
		   if(getLabelsFind().get(i).getText().contains("Description")){
			   	Reporter.log(getLabelsFind().get(i).getText()+" label edit clicked",true);
			  getEditCheckBox().get(i).click();
		   }	
		}
	}
	/**
	 * This method is used to select the check box from Description edit pop-up in Layout Editor page
	 * @throws Throwable
	 */
	public void selectCheckBox() throws Throwable{
		String text = flib.getCellData(EXCEL_PATH, "Data", 12, 1);
		wdlib.waitForElement(getDescLabel());
		for(int i=0;i<getCheckList().size();i++)
		{
			if(!getCheckList().get(i).isSelected())
			{
				getCheckList().get(i).click();
				Reporter.log(getCheckboxText().get(i).getText()+" Option selected",true);
				getDeftValue().sendKeys(text);
				break;
			}
		}
		
		getDescSaveBtn().click();
	}


	public WebElement getDownArrow() {
		return downArrow;
	}


	public WebElement getUpArrow() {
		return upArrow;
	}
	/**
	 * This method is used to rearrange price book label in layout editor page 
	 */
	public void arragePBLabel(){
		downArrow.click();
		Reporter.log("PriceBook Name come down now",true);
		wdlib.waitForElement(getUpArrow());
		upArrow.click();
		Reporter.log("PriceBook Name come up now",true);
	}


	/**
	 * This generic reusable method is used to create date Info custom field under Layout Editor page
	 * @param lable
	 */
	
	public void createDateInfoCustomField(String lable)	{
		deleteField(lable);
		addField(lable);
	}
	
	public WebElement getPickListValues() {
		return pickListValues;
	}


	public void setPickListValues(String value){
		pickListValues.sendKeys(value);
	}


	public WebElement getPickListOpt() {
		return pickListOpt;
	}

	
	public List<WebElement> getEditListlabel() {
		return editListlabel;
	}


	public WebElement getDelListLabel() {
		return delListLabel;
	}

	/**
	 * This method is used to create  Pick List custom field in Layout Editor Page
	 * @param value
	 * @throws Throwable
	 */
	public void createPickListCustomField(String value) throws Throwable{
		verifyListLabel(value);
		addCustomBtn.click();
		pickListOpt.click();
		fieldLabel.clear();
		fieldLabel.sendKeys(value);
		pickListValues.clear();
		int cellCount = flib.getCellCount(EXCEL_PATH, "Data", 11);
		try{
		  for(int i=2;i<=cellCount;i++)
		  {
			String cellText = flib.getCellData(EXCEL_PATH, "Data", 11, i);
			pickListValues.sendKeys(cellText+"\n");
			Reporter.log(cellText,true);
			
		  }
		  
		}
		catch(Exception e)
		{
			saveCFBtn.click();
			Reporter.log("ListValues Added",true);
			
		}
		
		
		
	}
	
	public void verifyListLabel(String lable){
		for(int i=0;i<showPropList.size();i++){
		if(showPropList.get(i).getText().contains(lable))
		{
			//Click on Editor
			editListlabel.get(i).click();
			delListLabel.click();
			wdlib.handleAlert();
		}
		
		
	  }
	}

}
