package vtiger_maven.test_scripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericlibrary.BaseTest;
import com.vtiger.pageObjectRepository.PriceBooksPage;

/**
 * This Test class used to find the last viewed price book
 * @author User
 *
 */
@Listeners(com.vtiger.genericlibrary.MyListeners.class)
public class FindLastViewedPriceBookTest extends BaseTest {
	@Test
	public void lastViewPB() throws Throwable 
	{
		PriceBooksPage pbpage=new PriceBooksPage();
		//clicking PriceBook 
		pbpage.goToPriceBookPage();
		//Find the Last viewed price book
		pbpage.pickLastView(0);
	}
	

}
