package vtiger_maven.test_scripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericlibrary.BaseTest;
import com.vtiger.pageObjectRepository.PriceBooksPage;

/**
 * This Test Class used to do alphabetical search for records in price book page.
 * @author Manjunath
 *
 */
@Listeners(com.vtiger.genericlibrary.MyListeners.class)
public class AlphabeticalSearchOfPriceBookTest extends BaseTest {
	@Test
	public void alphaSearch() throws Throwable {
		PriceBooksPage pbPage=new PriceBooksPage();
		//clicking PriceBook 
		pbPage.goToPriceBookPage();
		//Select alphabetical search like 'P'
		pbPage.searchByAlph("P");
		//Search Result display
		pbPage.checkSearchResult();
	}

}
