package vtiger_maven.test_scripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericlibrary.BaseTest;
import com.vtiger.pageObjectRepository.EditPriceBookInformationPage;
import com.vtiger.pageObjectRepository.PriceBookInformationPage;
import com.vtiger.pageObjectRepository.PriceBooksPage;

/**
 * This Test Class used to cancel operation after editing recently viewed Price Book
 * @author Manjunath
 *
 */
@Listeners(com.vtiger.genericlibrary.MyListeners.class)

public class CancleTheEditOnRecentlyViewedPBTest extends BaseTest {
	@Test
	public void cancleEditViewPB() throws Throwable {
		PriceBooksPage pbpage=new PriceBooksPage();
		PriceBookInformationPage pginfo=new PriceBookInformationPage();
		EditPriceBookInformationPage edinfo=new EditPriceBookInformationPage();
		//clicking PriceBook 
		pbpage.goToPriceBookPage();
		//Click on Last Viewed Icon
		pbpage.pickLastView(0);
		//Click on first last viewed price book
		pginfo.editPickedLastView();
		//Enter the new price book name to edit
		String editText = flib.getCellData(EXCEL_PATH, "Data", 9, 1);
		edinfo.enterText(editText);
		//click on cancel button
		edinfo.cancelEdit();
	}

}
