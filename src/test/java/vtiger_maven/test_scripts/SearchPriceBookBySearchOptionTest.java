package vtiger_maven.test_scripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericlibrary.BaseTest;
import com.vtiger.pageObjectRepository.PriceBooksPage;

/**
 * This Test Class used to do search for records in price book page.
 * @author Manjunath
 *
 */
@Listeners(com.vtiger.genericlibrary.MyListeners.class)
public class SearchPriceBookBySearchOptionTest extends BaseTest {
	@Test
	public void searchPB() throws Throwable {
		PriceBooksPage pbPage=new PriceBooksPage();
		//clicking PriceBook 
		pbPage.goToPriceBookPage();
		//send the search value in search text box
		String pbName = flib.getCellData(EXCEL_PATH, "Data", 8, 1);
		//search type Options
		String searchList = flib.getCellData(EXCEL_PATH, "Data", 5, 1);
		pbPage.searchNow(pbName, searchList);
		//Search result
		pbPage.checkSearchResult();
	}

}
