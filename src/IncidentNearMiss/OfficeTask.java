package IncidentNearMiss;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;

import common_Function.RW;

public class OfficeTask extends RW {

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

	public void OfficeTasks(WebDriver driver1) throws Exception {

		// Create Multiple type Incident Report
		     // MultipleIncidentReport(driver1);
		
		
	}

}
