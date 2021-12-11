package vtiger_maven.test_scripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericlibrary.BaseTest;
import com.vtiger.pageObjectRepository.PriceBooksPage;

/**
 * This Test Class used to do advance search for records in price book page.
 * @author Manjunath
 *
 */
@Listeners(com.vtiger.genericlibrary.MyListeners.class)
public class AdvanceSearchInPriceBookTest extends BaseTest {
	@Test
	public void advanceSearch() throws Throwable {
		PriceBooksPage pbPage=new PriceBooksPage();
		//clicking PriceBook 
		pbPage.goToPriceBookPage();
		//click on Go to Advanced Search Link
		pbPage.goToAdvanceSearch();  
		//Select the options from 1st drop down
		String List1 = flib.getCellData(EXCEL_PATH, "Data", 5, 1);
		//select the option from 2nd drop down
		String List2 = flib.getCellData(EXCEL_PATH, "Data", 6, 1);
		//Enter the text value  to search
		String bookName = flib.getCellData(EXCEL_PATH, "Data", 7, 1);
		pbPage.selectFirstSearch(List1, List2, bookName);
		//Click on search now button
		pbPage.searchNow();
	}

}
