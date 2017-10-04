package IncidentNearMiss;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;

import common_Function.RW;

public class IncidentReport extends RW {

	private static ExtentReports report;

	public synchronized static ExtentReports getReporter(String filePath) {

		if (report == null) {
			report = new ExtentReports(path.concat("Report\\Cars.html"));

			report.addSystemInfo("Host Name", "Priti") // Environment Setup For
														// Report
					.addSystemInfo("Environment", "QA");
		}

		return report;
	}

	public void IncidentReports(WebDriver driver1) throws Exception {

		// Create Multiple type Incident Report
		     // MultipleIncidentReport(driver1);
		      
		// Edit Multiple Incident Report
	         // EditIncidentReport(driver1);
		
		// Delete Incident Report using ID
		    //  DeleteIncidentReport(driver1);
		
		// Check All Field Validation On Incident Report 
		     //  CreateNewJob(driver1);
		
		      EditValidation(driver1);		
		
	}
	private void GetPageURL(WebDriver driver1) throws Exception {

		driver1.get("http://192.168.1.102/JIBE/Technical/JMS/JMS_Index.aspx");
	}
	private void MultipleIncidentReport(WebDriver driver1) throws Exception {
		GetPageURL(driver1);
		
		ArrayList<Row> locator = OR_Locator.searchSheet("MultipleIncidentReport", 1, 9);

		ArrayList<Row> Inputdata = input_Data.searchSheet("MultipleIncidentReport", 2, 0);
		// Loop for multiple Validation
		for (int TestCase = 1; TestCase < Inputdata.size(); TestCase++) {
			GetPageURL(driver1);
			NavigateLocators(driver1, locator, Inputdata, TestCase);
			ADDCAR(driver1);
		}
		System.out.println("Multiple Incident Report is Created successfully.");
	}

	private void EditIncidentReport(WebDriver driver1) throws Exception {
		GetPageURL(driver1);
		ArrayList<Row> locator = OR_Locator.searchSheet("EditIncidentReport", 1, 9);

		ArrayList<Row> Inputdata = input_Data.searchSheet("EditIncidentReport", 2, 0);
		// Loop for mumtiple Validation
		for (int TestCase = 1; TestCase < Inputdata.size(); TestCase++) {
			GetPageURL(driver1);
			NavigateLocators(driver1, locator, Inputdata, TestCase);
		}
		System.out.println("Multiple Incident Report is Edited successfully.");

	}

	private void DeleteIncidentReport(WebDriver driver1) throws Exception {
		GetPageURL(driver1);
		
		ArrayList<Row> locator = OR_Locator.searchSheet("DeleteIncidentReport", 1, 9);

		ArrayList<Row> Inputdata = input_Data.searchSheet("DeleteIncidentReport", 2, 0);
		// Loop for multiple Validation
		for (int TestCase = 1; TestCase < Inputdata.size(); TestCase++){
			NavigateLocators(driver1, locator, Inputdata, TestCase);
		}
		System.out.println("Multiple Incident Report is Deleted successfully.");
	}

	private void CreateNewJob(WebDriver driver1) throws Exception {
		GetPageURL(driver1);
		
		ArrayList<Row> locator = OR_Locator.searchSheet("NCreateNewJob", 1, 9);
		ArrayList<Row> Inputdata = input_Data.searchSheet("NCreateNewJob", 2, 0);
		
		// Loop for Negative Validation
		for (int TestCase = 1; TestCase < Inputdata.size(); TestCase++) {	
			///
			GetPageURL(driver1);
			NavigateLocators(driver1, locator, Inputdata, TestCase);
		}
		System.out.println("Negative Validation On Create Job of Incident Type is executed successfully.");
//---------------------------------------------------------------------------------------------------------//
		
		ArrayList<Row> locator1 = OR_Locator.searchSheet("PCreateNewJob", 1, 9);

		ArrayList<Row> Inputdata1 = input_Data.searchSheet("PCreateNewJob", 2, 0);
		// Loop for Positive Validation
		for (int TestCase = 1; TestCase < Inputdata1.size(); TestCase++) {
			GetPageURL(driver1);
			NavigateLocators(driver1, locator1, Inputdata1, TestCase);
		}
		System.out.println("Positive Validation On Create Job of Incident Type is executed successfully.");

	}
	
	private void AddIncidentReport(WebDriver driver1) throws Exception {

		ArrayList<Row> locator = OR_Locator.searchSheet("AddIncidentReport", 1, 9);
		ArrayList<Row> Inputdata = input_Data.searchSheet("AddIncidentReport", 2, 0);
		// Loop for Positive Validation
		for (int TestCase = 1; TestCase < Inputdata.size(); TestCase++) {
			NavigateLocators(driver1, locator, Inputdata, TestCase);
		}
	}

	public void EditValidation(WebDriver driver1) throws Exception {
		GetPageURL(driver1);
		AddIncidentReport(driver1);

	/*	ArrayList<Row> locator2 = OR_Locator.searchSheet("PDateValidation", 1, 9);

		ArrayList<Row> Inputdata2 = input_Data.searchSheet("PDateValidation", 2, 0);

		// Loop on Multiple data for Positive Date Validation
		for (int TestCase = 1; TestCase < Inputdata2.size(); TestCase++) {

			NavigateLocators(driver1, locator2, Inputdata2, TestCase);
		}
		System.out.println("Positive Validation On Date is executed successfully.");
//-------------------------------------------------------------------------------------------------------//
		
		ArrayList<Row> locator3 = OR_Locator.searchSheet("NDateValidation", 1, 9);

		ArrayList<Row> Inputdata3 = input_Data.searchSheet("NDateValidation", 2, 0);

		// Loop on Multiple data for Negative Date Validation
		for (int TestCase = 1; TestCase < Inputdata3.size(); TestCase++) {

			NavigateLocators(driver1, locator3, Inputdata3, TestCase);
		}
		System.out.println("Negative Validation On Date is executed successfully.");
//-------------------------------------------------------------------------------------------------------//
		
		ArrayList<Row> locator4 = OR_Locator.searchSheet("NDescriptionValidation", 1, 9);

		ArrayList<Row> Inputdata4 = input_Data.searchSheet("NDescriptionValidation", 2, 0);

		// Loop on Multiple data for Negative Date Validation
		for (int TestCase = 1; TestCase < Inputdata4.size(); TestCase++) {

			NavigateLocators(driver1, locator4, Inputdata4, TestCase);
		}
		System.out.println("Negative Validation On Description is executed successfully.");
		
//-------------------------------------------------------------------------------------------------------//
		ArrayList<Row> locator5 = OR_Locator.searchSheet("PDescriptionValidation", 1, 9);

		ArrayList<Row> Inputdata5 = input_Data.searchSheet("PDescriptionValidation", 2, 0);

		// Loop on Multiple data for Negative Description Validation
		for (int TestCase = 1; TestCase < Inputdata5.size(); TestCase++) {

			NavigateLocators(driver1, locator5, Inputdata5, TestCase);
		}
		System.out.println("Positive Validation On Description is executed successfully.");
	
// -------------------------------------------------------------------------------------------------------//
		ArrayList<Row> locator6 = OR_Locator.searchSheet("PIncidentDetails", 1, 9);

		ArrayList<Row> Inputdata6 = input_Data.searchSheet("PIncidentDetails", 2, 0);

		// Loop on Multiple data for Negative Description Validation
		for (int TestCase = 1; TestCase < Inputdata6.size(); TestCase++) {

			NavigateLocators(driver1, locator6, Inputdata6, TestCase);
		}
		System.out.println("Positive Validation On Incident Details is executed successfully.");

	
// -------------------------------------------------------------------------------------------------------//
		ArrayList<Row> locator7 = OR_Locator.searchSheet("NIncidentDetails", 1, 9);

		ArrayList<Row> Inputdata7 = input_Data.searchSheet("NIncidentDetails", 2, 0);

		// Loop on Multiple data for Negative Description Validation
		for (int TestCase = 1; TestCase < Inputdata7.size(); TestCase++) {

			NavigateLocators(driver1, locator7, Inputdata7, TestCase);
		}
		System.out.println("Negative Validation On Incident Details is executed successfully.");

// -------------------------------------------------------------------------------------------------------//
		ArrayList<Row> locator8 = OR_Locator.searchSheet("PInvestigationDetails", 1, 9);

		ArrayList<Row> Inputdata8 = input_Data.searchSheet("PInvestigationDetails", 2, 0);

		// Loop on Multiple data for Negative Description Validation
		for (int TestCase = 1; TestCase < Inputdata8.size(); TestCase++) {

			NavigateLocators(driver1, locator8, Inputdata8, TestCase);
		}
		System.out.println("Positive Validation On Investigation Details is executed successfully.");
	
// -------------------------------------------------------------------------------------------------------//
		ArrayList<Row> locator9 = OR_Locator.searchSheet("PEquipmentLocation", 1, 9);

		ArrayList<Row> Inputdata9 = input_Data.searchSheet("PEquipmentLocation", 2, 0);

		// Loop on Multiple data for Negative Description Validation
		for (int TestCase = 1; TestCase < Inputdata9.size(); TestCase++) {

			NavigateLocators(driver1, locator9, Inputdata9, TestCase);
		}
		System.out.println("Positive Validation On  Equipment Location is executed successfully.");
	
// -------------------------------------------------------------------------------------------------------//
		ArrayList<Row> locator10 = OR_Locator.searchSheet("NEquipmentLocation", 1, 9);

		ArrayList<Row> Inputdata10 = input_Data.searchSheet("NEquipmentLocation", 2, 0);

		// Loop on Multiple data for Negative Description Validation
		for (int TestCase = 1; TestCase < Inputdata10.size(); TestCase++) {

			NavigateLocators(driver1, locator10, Inputdata10, TestCase);
		}
		System.out.println("Negative Validation On  Equipment Location is executed successfully.");
	
// -------------------------------------------------------------------------------------------------------//
		ArrayList<Row> locator11 = OR_Locator.searchSheet("PFollow-ups", 1, 9);

		ArrayList<Row> Inputdata11 = input_Data.searchSheet("PFollow-ups", 2, 0);

		// Loop on Multiple data for Negative Description Validation
		for (int TestCase = 1; TestCase < Inputdata11.size(); TestCase++) {

			NavigateLocators(driver1, locator11, Inputdata11, TestCase);
		}
		System.out.println("Positive Validation On  Workflow and Follow-ups is executed successfully.");
	
// -------------------------------------------------------------------------------------------------------//
		ArrayList<Row> locator12 = OR_Locator.searchSheet("NFollow-ups", 1, 9);

		ArrayList<Row> Inputdata12 = input_Data.searchSheet("NFollow-ups", 2, 0);

		// Loop on Multiple data for Negative Description Validation
		for (int TestCase = 1; TestCase < Inputdata12.size(); TestCase++) {

			NavigateLocators(driver1, locator12, Inputdata12, TestCase);
		}
		System.out.println("Negative Validation On  Workflow and Follow-ups is executed successfully.");
		
// -------------------------------------------------------------------------------------------------------//

		ArrayList<Row> locator13 = OR_Locator.searchSheet("AddAttachment", 1, 9);

		ArrayList<Row> Inputdata13 = input_Data.searchSheet("AddAttachment", 2, 0);

		// Loop on Multiple data for Negative Description Validation
		for (int TestCase = 1; TestCase < Inputdata13.size(); TestCase++) {

			NavigateLocators(driver1, locator13, Inputdata13, TestCase);
		}
		System.out.println("Validation On Attachment is executed successfully.");
		
// -------------------------------------------------------------------------------------------------------//

		ArrayList<Row> locator14 = OR_Locator.searchSheet("PEvidenceReview", 1, 9);

		ArrayList<Row> Inputdata14 = input_Data.searchSheet("PEvidenceReview", 2, 0);

		// Loop on Multiple data for Negative Description Validation
		for (int TestCase = 1; TestCase < Inputdata14.size(); TestCase++) {

			NavigateLocators(driver1, locator14, Inputdata14, TestCase);
		}
		System.out.println("Positive Validation On Evidence Review is executed successfully.");
		
		
// -------------------------------------------------------------------------------------------------------//
		
		ArrayList<Row> locator15 = OR_Locator.searchSheet("NEvidenceReview", 1, 9);

		ArrayList<Row> Inputdata15 = input_Data.searchSheet("NEvidenceReview", 2, 0);

		// Loop on Multiple data for Negative Description Validation
		for (int TestCase = 1; TestCase < Inputdata15.size(); TestCase++) {

			NavigateLocators(driver1, locator15, Inputdata15, TestCase);
		}
		System.out.println("Negative Validation On Evidence Review is executed successfully.");
		
// -------------------------------------------------------------------------------------------------------//
		

		ArrayList<Row> locator16 = OR_Locator.searchSheet("PCrewInvolved", 1, 9);

		ArrayList<Row> Inputdata16 = input_Data.searchSheet("PCrewInvolved", 2, 0);

		// Loop on Multiple data for Negative Description Validation
		for (int TestCase = 1; TestCase < Inputdata16.size(); TestCase++) {

			NavigateLocators(driver1, locator16, Inputdata16, TestCase);
		}
		System.out.println("Positive Validation On Crew Involved is executed successfully.");
		
// -------------------------------------------------------------------------------------------------------//
		
		ArrayList<Row> locator17 = OR_Locator.searchSheet("NCasualFactor", 1, 9);

		ArrayList<Row> Inputdata17 = input_Data.searchSheet("NCasualFactor", 2, 0);

		// Loop on Multiple data for Negative Description Validation
		for (int TestCase = 1; TestCase < Inputdata17.size(); TestCase++) {

			NavigateLocators(driver1, locator17, Inputdata17, TestCase);
		}
		System.out.println("Negative Validation On Casual Factor is executed successfully.");
		*/
// -------------------------------------------------------------------------------------------------------//
		
		ArrayList<Row> locator18 = OR_Locator.searchSheet("PCasualFactor", 1, 9);

		ArrayList<Row> Inputdata18 = input_Data.searchSheet("PCasualFactor", 2, 0);

		// Loop on Multiple data for Negative Description Validation
		for (int TestCase = 1; TestCase < Inputdata18.size(); TestCase++) {

			NavigateLocators(driver1, locator18, Inputdata18, TestCase);
			ADDCAR(driver1);
			
		}
		System.out.println("Positive Validation On Casual Factor is executed successfully.");
		
// -------------------------------------------------------------------------------------------------------//
		
		
}

	private void ADDCAR(WebDriver driver1) throws Exception {
		
		ArrayList<Row> locator = OR_Locator.searchSheet("AddCAR", 0, 9);

		ArrayList<Row> Inputdata = input_Data.searchSheet("AddCAR", 1, 0);

		for (int TestCase = 1; TestCase < Inputdata.size(); TestCase++) {
			
			NavigateLocators(driver1, locator, Inputdata, TestCase);
		}


	}
	
	private void OfficeTask(WebDriver driver1) throws Exception {

		ArrayList<Row> locator = OR_Locator.searchSheet("OfficeTask", 0, 9);

		ArrayList<Row> Inputdata = input_Data.searchSheet("OfficeTask", 1, 0);

		for (int TestCase = 1; TestCase < Inputdata.size(); TestCase++) {

			NavigateLocators(driver1, locator, Inputdata, TestCase);
		}

	}
	
    private void NavigateLocators(WebDriver driver1, ArrayList<Row> locator, ArrayList<Row> Inputdata, int TestCase)
			throws Exception {

		for (int i = 0; i < locator.size(); i++) {

			// Get type of element (dropdown, text)
			String strControlTypeKey = locator.get(i).getCell(10).toString();

			if (strControlTypeKey != null) {

				// Get property of element
				String LocatorName = locator.get(i).getCell(0).getStringCellValue();

				// Get property of element
				String LocatorType = locator.get(i).getCell(1).getStringCellValue();

				// Get client ID of the element
				String strControl = locator.get(i).getCell(2).getStringCellValue();

				String InputValue = Inputdata.get(TestCase).getCell(i + 1).toString();

				// Get Sleep Time
				Long SleepTime = (long) locator.get(i).getCell(4).getNumericCellValue();

				// Button Click and navigate page
				
				if (strControlTypeKey.compareTo("Url_Ctrl") == 0) {
					driver1.get(InputValue);
					Thread.sleep(k);
				}

				if (strControlTypeKey.compareTo("Click_Ctrl") == 0) {
					click_element(driver1, LocatorType, strControl);
					Thread.sleep(SleepTime);
				}
				// Text
				if (strControlTypeKey.compareTo("Dropdown_ctrl") == 0) {
					sendkeys(driver1, LocatorType, strControl, InputValue);
					Thread.sleep(SleepTime);
				}
				if (strControlTypeKey.compareTo("Clear_Ctrl") == 0) {
					clear_element(driver1, LocatorType, strControl);
					Thread.sleep(k);
				}
				if (strControlTypeKey.compareTo("SendKey_Ctrl") == 0) {
					sendkeys(driver1, LocatorType, strControl, InputValue);
					Thread.sleep(SleepTime);
				}

				if (strControlTypeKey.compareTo("Alert_accept") == 0) {
					click_element(driver1, LocatorType, strControl);
					Thread.sleep(SleepTime);
					Alert_accept(driver1);
					Thread.sleep(SleepTime);
				}
				if (strControlTypeKey.compareTo("WindowSwitch_Ctrl") == 0) {
					click_element(driver1, LocatorType, strControl);
					Thread.sleep(SleepTime);
					WindowSwitchto(driver1);
				}
				if (strControlTypeKey.compareTo("Upload_Ctrl") == 0) {
					uploadFile(driver1, LocatorType, strControl, strControl, InputValue, strControl);
					Thread.sleep(SleepTime);

				}
				if (strControlTypeKey.compareTo("FrameSwitch_Ctrl") == 0) {

					frameSwitchto(driver1, LocatorType, strControl);
					Thread.sleep(SleepTime);
				}

				if (strControlTypeKey.compareTo("FrameSwitchBack_Ctrl") == 0) {
					click_element(driver1, LocatorType, strControl);
					Thread.sleep(SleepTime);
					frameSwitchBack(driver1);
					Thread.sleep(SleepTime);

				}
				if (strControlTypeKey.compareTo("Refresh_Ctrl") == 0) {
					refresh(driver1);
					Thread.sleep(SleepTime);
				}

				if (strControlTypeKey.compareTo("SwitchtoParent") == 0) {
					click_element(driver1, LocatorType, strControl);
					Thread.sleep(SleepTime);
					Alert_accept(driver1);
					Thread.sleep(SleepTime);
					SwitchtoParent(driver1);
					Thread.sleep(SleepTime);
				}
			}

		}
	}

}
