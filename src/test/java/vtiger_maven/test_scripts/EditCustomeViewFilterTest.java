package vtiger_maven.test_scripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericlibrary.BaseTest;
import com.vtiger.pageObjectRepository.EditCustomViewPage;
import com.vtiger.pageObjectRepository.PriceBooksPage;

/**
 * This Test Class used to create new Filter for records in Price Book page
 * @author Manjunath
 *
 */
@Listeners(com.vtiger.genericlibrary.MyListeners.class)
public class EditCustomeViewFilterTest extends BaseTest {
	
	@Test
	public void editViewFilter() throws Throwable {
		PriceBooksPage pbpage=new PriceBooksPage();
		EditCustomViewPage edt=new EditCustomViewPage();
		//clicking PriceBook 
		pbpage.goToPriceBookPage();
		//Select first filter
		pbpage.selectFilter(1);
		//Click on Edit filter link
		wdlib.waitForElement(pbpage.getEditLink());
		pbpage.getEditLink().click();
		wdlib.waitForElement(edt.getEditPage());
		wdlib.verify(edt.getEditPage().getText(), flib.getCellData(EXCEL_PATH, "Data", 23, 1), " Price Book Edit Custom View");
		//Enter the text value to View name text box and click on save
		String name=flib.getCellData(EXCEL_PATH, "Data", 24, 1);
		edt.editFilter(name);
		edt.getSaveBtn().click();
	}

}
