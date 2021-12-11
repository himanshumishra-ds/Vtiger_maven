package vtiger_maven.test_scripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericlibrary.BaseTest;
import com.vtiger.pageObjectRepository.PriceBooksPage;

/**
 * This Test Class used to quickly create the Price Book
 * @author Manjunath
 *
 */
@Listeners(com.vtiger.genericlibrary.MyListeners.class)
public class QuickCreateNewPBTest extends BaseTest {
	
	@Test
	public void quickCreate() throws Throwable {
		PriceBooksPage pbpage=new PriceBooksPage();
		//clicking PriceBook 
		pbpage.goToPriceBookPage();
		//Click on Quick create drop down and select price book
		String priceBook = flib.getCellData(EXCEL_PATH, "Data", 19, 1);
		//enter the text value in Price book name on Quick create window
		String priceBookName = flib.getCellData(EXCEL_PATH, "Data", 20, 1);
		String description = flib.getCellData(EXCEL_PATH, "Data", 21, 1);
		pbpage.selectQuickCreateOption(priceBook);
		//Quick create price book and click on save button 
		pbpage.quickCreatePriceBook(priceBookName, description);
	}

}
