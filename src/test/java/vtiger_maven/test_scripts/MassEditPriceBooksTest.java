package vtiger_maven.test_scripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericlibrary.BaseTest;
import com.vtiger.pageObjectRepository.PriceBooksPage;
/**
 * This Test Class used to select records and mass editing them in Price Book page
 * @author Manjunath
 *
 */
@Listeners(com.vtiger.genericlibrary.MyListeners.class)

public class MassEditPriceBooksTest extends BaseTest {
	
	@Test
	public void massEditPB() throws Throwable {
		PriceBooksPage pbpage=new PriceBooksPage();
		//clicking PriceBook 
		pbpage.goToPriceBookPage();
		//Select  two records by check box
		pbpage.selectPriceBook(1);
		pbpage.selectPriceBook(2);
		//Click on Mass Edit button after selecting two records
		pbpage.goToMassEdit();
		//get the new price book name from excel
		String massEditText = flib.getCellData(EXCEL_PATH, "Data", 18, 1);
		//enter new edit price book name value and click on save button
		pbpage.massEditRecords(massEditText);
	}

}
