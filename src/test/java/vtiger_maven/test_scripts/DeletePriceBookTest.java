package vtiger_maven.test_scripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericlibrary.BaseTest;
import com.vtiger.pageObjectRepository.PriceBooksPage;
/**
 * This Test Class used to delete price book record
 * @author Manjunath
 *
 */
@Listeners(com.vtiger.genericlibrary.MyListeners.class)
public class DeletePriceBookTest extends BaseTest {
	
	@Test
	public void deletePB() throws Throwable {
		PriceBooksPage pbpage=new PriceBooksPage();
		//clicking PriceBook 
		pbpage.goToPriceBookPage();
		//Select the record by check box
		pbpage.selectPriceBook(3);
		pbpage.deletePriceBook();
	}

}
