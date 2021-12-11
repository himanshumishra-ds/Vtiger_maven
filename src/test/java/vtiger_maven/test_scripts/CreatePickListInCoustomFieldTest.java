package vtiger_maven.test_scripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericlibrary.BaseTest;
import com.vtiger.pageObjectRepository.LayoutEditorPage;
import com.vtiger.pageObjectRepository.PriceBookSettingPage;
import com.vtiger.pageObjectRepository.PriceBooksPage;

/**
 * This Test Class used to create custom field in Layout Editor
 * @author Manjunath
 *
 */
@Listeners(com.vtiger.genericlibrary.MyListeners.class)
public class CreatePickListInCoustomFieldTest  extends BaseTest{
	@Test
	public void addPickListToCustomField() throws Throwable  {
		PriceBooksPage pbpage=new PriceBooksPage();
		PriceBookSettingPage setpage=new PriceBookSettingPage();
		LayoutEditorPage lypage=new LayoutEditorPage();
		//clicking PriceBook 
		pbpage.goToPriceBookPage();
		//Click on plus button
		pbpage.createNewPriceBook();
		//Click on Price Books Settings
		pbpage.goToSetting();
		//Click on Layout Editor
		setpage.goToLayoutEditorPage();
		//Click on Add Custom Field of  Custom Information 
		//Click on Pick List
		//Enter the label and values
		String lable=flib.getCellData(EXCEL_PATH, "Data", 11, 1);
		//Click on save button
		lypage.createPickListCustomField(lable);
	}


}
