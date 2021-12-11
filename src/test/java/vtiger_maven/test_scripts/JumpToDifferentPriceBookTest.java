package vtiger_maven.test_scripts;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericlibrary.BaseTest;
import com.vtiger.pageObjectRepository.PriceBookInformationPage;
import com.vtiger.pageObjectRepository.PriceBooksPage;

/**
 * This Test Class used to move one price book to another price book record.
 * @author Manjunath
 *
 */
@Listeners(com.vtiger.genericlibrary.MyListeners.class)
public class JumpToDifferentPriceBookTest extends BaseTest {
	@Test
	public void jumpToDiffPB() throws Throwable {
		PriceBooksPage pbPage=new PriceBooksPage();
		PriceBookInformationPage pbInfoPage=new PriceBookInformationPage();
		//clicking PriceBook 
		pbPage.goToPriceBookPage();
		//Click on Last Viewed Icon
		pbPage.getLastView().click();
		//Find the Last viewed  price book
		Reporter.log("Recently viewed price book :"+pbPage.getViewLists().get(0).getText(),true);
		//Click on first last viewed price book
		pbPage.getViewLists().get(0).click();
		Reporter.log("Clicked on first recently viewed pricebook",true);
		//Verify price book information page
		wdlib.verify(pbInfoPage.getPriceBookPage().getText(), flib.getPropKeyValue(PROP_PATH, "CreatedPB"), "Price Book Page");
		//click on Jump to Icon
		//Click  next price book in Jump to Price Books pop-up window
		pbInfoPage.jumpToPB(1);
	}


}
