package vtiger_maven.test_scripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericlibrary.BaseTest;
import com.vtiger.pageObjectRepository.PriceBooksPage;

/**
 * This Test Class used to delete filters From Price Book page
 * @author Manjunath
 *
 */
@Listeners(com.vtiger.genericlibrary.MyListeners.class)

public class DeleteFilterTest extends BaseTest {

	@Test
	public void deleteFilterInList() throws Throwable{
		PriceBooksPage pbPage=new PriceBooksPage();
		//clicking PriceBook 
		pbPage.goToPriceBookPage();
		pbPage.deleteFilter();
	}
}
