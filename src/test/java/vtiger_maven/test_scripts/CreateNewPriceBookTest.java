package vtiger_maven.test_scripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericlibrary.BaseTest;
import com.vtiger.pageObjectRepository.PriceBookInformationPage;
import com.vtiger.pageObjectRepository.PriceBooksPage;
/**
 * This Test Class used to create new price book
 * @author Manjunath
 *
 */
@Listeners(com.vtiger.genericlibrary.MyListeners.class)
public class CreateNewPriceBookTest extends BaseTest {
	
	@Test
	public void createNewPB() throws Throwable {
		PriceBooksPage pbpage=new PriceBooksPage();
		PriceBookInformationPage pbInfoPage=new PriceBookInformationPage();
		//clicking PriceBook 
		pbpage.goToPriceBookPage();
		//Click on plus button
		pbpage.createNewPriceBook();
		//passing data to price book name
		String key1 = flib.getCellData(EXCEL_PATH, "Data", 8, 1);
		//Entering mandatory field Description
		String key2 = flib.getCellData(EXCEL_PATH, "Data", 12, 1);
		//verify the Price Book creation
		wdlib.verify(pbInfoPage.getCreatePage().getText(), flib.getPropKeyValue(PROP_PATH, "CreatePage"), "Create New Price Book ");
		pbInfoPage.createNewPB(key1, key2);
		wdlib.verify(pbInfoPage.getPriceBookPage().getText(),flib.getPropKeyValue(PROP_PATH, "CreatedPB"),key1+ " Price Book Information");
	}

}
