package vtiger_maven.test_scripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericlibrary.BaseTest;
import com.vtiger.pageObjectRepository.PriceBooksPage;
import com.vtiger.pageObjectRepository.ViewFilterPage;

/**
 * This Test Class used to create new Filter for records in Price Book page
 * @author Manjunath
 *
 */
@Listeners(com.vtiger.genericlibrary.MyListeners.class)
public class CreateNewFilterTest extends BaseTest{

	@Test
	public void addNewFilter() throws Throwable{

		PriceBooksPage pbPage=new PriceBooksPage();
		ViewFilterPage vf=new ViewFilterPage();
		//clicking PriceBook 
		pbPage.goToPriceBookPage();
		//Click on Create filter link
		vf.createFilter();
		
	}
	
	
}
