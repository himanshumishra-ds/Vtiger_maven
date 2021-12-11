package vtiger_maven.test_scripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericlibrary.BaseTest;
import com.vtiger.pageObjectRepository.LayoutEditorPage;
import com.vtiger.pageObjectRepository.PriceBookSettingPage;
import com.vtiger.pageObjectRepository.PriceBooksPage;

/**
 * This Test Class used to Edit custom field in Layout Editor
 * @author Manjunath
 *
 */
@Listeners(com.vtiger.genericlibrary.MyListeners.class)

public class EditCustomFieldInLayoutSettingTest extends BaseTest{

	@Test
	public void editCustomField() throws Throwable {
		PriceBooksPage pbpage=new PriceBooksPage();
		PriceBookSettingPage setpage=new PriceBookSettingPage();
		LayoutEditorPage lypage=new LayoutEditorPage();
		//clicking PriceBook 
		pbpage.goToPriceBookPage();
		//Click on Price Books Settings
		pbpage.goToSetting();
		//Click on Layout Editor
		setpage.goToLayoutEditorPage();
		//Select Description block edit option
		lypage.clickDescriptionEdit();
		//Select default value enter text and save
		lypage.selectCheckBox();
	}
	
	
}
