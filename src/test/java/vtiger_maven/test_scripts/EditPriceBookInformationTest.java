package vtiger_maven.test_scripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericlibrary.BaseTest;
import com.vtiger.pageObjectRepository.EditPriceBookInformationPage;
import com.vtiger.pageObjectRepository.PriceBookInformationPage;
import com.vtiger.pageObjectRepository.PriceBooksPage;

/**
 * This Test Class used to editing the price book record.
 * @author Manjunath
 *
 */
@Listeners(com.vtiger.genericlibrary.MyListeners.class)
public class EditPriceBookInformationTest extends BaseTest {

	@Test
	public void editPBInformation() throws Throwable {
		PriceBooksPage pbpage=new PriceBooksPage();
		PriceBookInformationPage pbInfoPage=new PriceBookInformationPage();
		EditPriceBookInformationPage edtpage=new EditPriceBookInformationPage();
		//clicking PriceBook 
		pbpage.goToPriceBookPage();
		//click on edit link on first record
		pbpage.selectPriceBook();
		//verify the Price Book display
        String priceBook = pbInfoPage.getPriceBookPage().getText();
		wdlib.verify(priceBook, flib.getCellData(EXCEL_PATH, "Data", 22, 1), priceBook);
		pbInfoPage.getEditBtn().click();
		//verify the Price Book display
		wdlib.verify(priceBook, flib.getCellData(EXCEL_PATH, "Data", 22, 1),"Edit Price Boook ");
		//Clear the name field
		//Enter the new value
		String editName=flib.getCellData(EXCEL_PATH, "Data", 7, 1);
		edtpage.enterText(editName);
		//Entering mandatory field Description
		String description=flib.getCellData(EXCEL_PATH, "Data", 12, 1);
		edtpage.enterDescription(description);
		//click on save button
		edtpage.getSaveBtn().click();
	}
	
}
