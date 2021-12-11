package vtiger_maven.test_scripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericlibrary.BaseTest;
import com.vtiger.pageObjectRepository.MoreInformationPage;
import com.vtiger.pageObjectRepository.PriceBookInformationPage;
import com.vtiger.pageObjectRepository.PriceBooksPage;

/**
 * This Test Class used to edit the service price of opened Price Book.
 * @author Manjunath
 *
 */
@Listeners(com.vtiger.genericlibrary.MyListeners.class)
public class EditPriceOfTheServiceInPriceBookTest extends BaseTest {
	@Test
	public void editServicePrice() throws Throwable {
		PriceBookInformationPage pbInfoPage=new PriceBookInformationPage();
		PriceBooksPage pbpage=new PriceBooksPage();
		MoreInformationPage mrInfopage=new MoreInformationPage();
		//clicking PriceBook 
		pbpage.goToPriceBookPage();
		/*selecting first record in the price book
		Selection starts from zero*/
		pbpage.selectPB(0);
		//Click on more information link
		pbInfoPage.getMoreInfoLink().click();
		//verify the more information page
		mrInfopage.verifyMoreInfoPage();
		//click on service
		mrInfopage.getSelServicOpt().click();
		//get price value from excel
		 String newServicePrice = flib.getCellData(EXCEL_PATH, "Data", 16, 1);
		 //edit new price value
		 mrInfopage.editServicePrice(newServicePrice);
	}
	

}
