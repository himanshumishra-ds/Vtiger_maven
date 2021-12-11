package vtiger_maven.test_scripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericlibrary.BaseTest;
import com.vtiger.pageObjectRepository.LayoutEditorPage;
import com.vtiger.pageObjectRepository.PriceBookSettingPage;
import com.vtiger.pageObjectRepository.PriceBooksPage;


/**
 * This Test class used to add new block in Layout Editor page
 * @author User
 *
 */
@Listeners(com.vtiger.genericlibrary.MyListeners.class)
public class AddBlockInLayoutEditorSettingTest extends BaseTest {

	   @Test
	   public void addNewBlock()  throws Throwable {
			PriceBooksPage pbpage=new PriceBooksPage();
			PriceBookSettingPage setpage=new PriceBookSettingPage();
			LayoutEditorPage lypage=new LayoutEditorPage();
			//clicking PriceBook 
			pbpage.goToPriceBookPage();
			//Click on plus button
			pbpage.createNewPriceBook();
			pbpage.goToSetting();
			//Click on Layout Editor
			setpage.goToLayoutEditorPage();
			//click on Add Block button
			lypage.addBlock();
		}
	
}
