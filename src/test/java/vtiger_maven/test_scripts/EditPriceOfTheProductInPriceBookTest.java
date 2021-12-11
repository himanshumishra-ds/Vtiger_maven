package vtiger_maven.test_scripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericlibrary.BaseTest;
import com.vtiger.pageObjectRepository.MoreInformationPage;
import com.vtiger.pageObjectRepository.PriceBookInformationPage;
import com.vtiger.pageObjectRepository.PriceBooksPage;

/**
 * This Test Class used to edit the product price of opened Price Book.
 * @author Manjunath
 *
 */
@Listeners(com.vtiger.genericlibrary.MyListeners.class)
public class EditPriceOfTheProductInPriceBookTest extends BaseTest {
	@Test
	public void editProductPrice() throws Throwable {
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
		mrInfopage.verifyMoreInfoPage();
		mrInfopage.getSelProductOpt().click();
		//change the Price 2800
		 String newPrice = flib.getCellData(EXCEL_PATH, "Data", 15, 1);
		mrInfopage.editProductPrice(newPrice);
	}

}
