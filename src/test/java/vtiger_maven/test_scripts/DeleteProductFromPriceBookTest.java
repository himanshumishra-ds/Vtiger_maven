package vtiger_maven.test_scripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericlibrary.BaseTest;
import com.vtiger.pageObjectRepository.MoreInformationPage;
import com.vtiger.pageObjectRepository.PriceBookInformationPage;
import com.vtiger.pageObjectRepository.PriceBooksPage;

/**
 * This Test Class used to delete the product from opened Price Book.
 * @author Manjunath
 *
 */
@Listeners(com.vtiger.genericlibrary.MyListeners.class)
public class DeleteProductFromPriceBookTest extends BaseTest {
	@Test
	public void deleteProductPB() throws Throwable {
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
		//delete the product
		mrInfopage.verifyAndDeleteProduct();
		
	}

}
