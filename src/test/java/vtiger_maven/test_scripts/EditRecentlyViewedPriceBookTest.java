package vtiger_maven.test_scripts;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericlibrary.BaseTest;
import com.vtiger.pageObjectRepository.EditPriceBookInformationPage;
import com.vtiger.pageObjectRepository.PriceBookInformationPage;
import com.vtiger.pageObjectRepository.PriceBooksPage;

/**
 * This Test Class used to editing recently viewed price book.
 * @author Manjunath
 *
 */
@Listeners(com.vtiger.genericlibrary.MyListeners.class)
public class EditRecentlyViewedPriceBookTest extends BaseTest {
	
	@Test
	public void editRecentView() throws Throwable {
		PriceBooksPage pbPage=new PriceBooksPage();
		EditPriceBookInformationPage edtPage=new EditPriceBookInformationPage();
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
		//Click on Edit button
		pbInfoPage.getEditBtn().click();
		String actualPage=edtPage.getEditPage().getText();
		//Verify the Edit Price Book Information page
		wdlib.verify(actualPage.substring(actualPage.lastIndexOf("-")), flib.getPropKeyValue(PROP_PATH, "EditPriceBookPage"), "Editing Price Book information page");
		//Enter the new price book name to edit
		String editText = flib.getCellData(EXCEL_PATH, "Data", 17, 1);
		edtPage.enterBookName(editText);
		String description=flib.getCellData(EXCEL_PATH, "Data", 12, 1);
		edtPage.enterDescription(description);
		//click on save button
		edtPage.getSaveBtn().click();;
	}

}
