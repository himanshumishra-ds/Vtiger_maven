package vtiger_maven.test_scripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericlibrary.BaseTest;
import com.vtiger.pageObjectRepository.DuplicatingPage;
import com.vtiger.pageObjectRepository.PriceBookInformationPage;
import com.vtiger.pageObjectRepository.PriceBooksPage;
/**
 * This Test Class used to duplicate the price book record.
 * @author Manjunath
 *
 */
@Listeners(com.vtiger.genericlibrary.MyListeners.class)
public class DuplicateThePriceBookTest extends BaseTest {
	
	@Test
	public void createDuplicatePB() throws Throwable {
		PriceBooksPage pbpage=new PriceBooksPage();
		PriceBookInformationPage pbInfoPage=new PriceBookInformationPage();
		DuplicatingPage dp=new DuplicatingPage();
		//clicking PriceBook 
		pbpage.goToPriceBookPage();
		//click on first record
		pbpage.selectPriceBook();
		//verify the Price Book display
        String priceBook = pbInfoPage.getPriceBookPage().getText();
		wdlib.verify(priceBook, flib.getCellData(EXCEL_PATH, "Data", 22, 1), priceBook);
		//Create Duplicate by clicking Duplicate Button
		pbInfoPage.getDuplicate().click();
		//click on save button
		String duplicatepagetext=dp.getDuplicatePage().getText();
		String text=duplicatepagetext.substring(duplicatepagetext.lastIndexOf(" "));
		wdlib.verify(duplicatepagetext, flib.getPropKeyValue(PROP_PATH, "duplicatepage")+text, "Duplicating page ");
		dp.getSaveBtn().click();
		//Move to Price Books page
		pbInfoPage.getBackToPB().click();
	}

}
