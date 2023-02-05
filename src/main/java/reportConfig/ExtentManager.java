package reportConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import commons.GlobalConstants;

public class ExtentManager  {
	private static ExtentReports extent;
	private static String reportFileName = "ExtentReport.html";
	private static String extentReportPath = GlobalConstants.EXTENT_PATH_V3 + reportFileName;
	
	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();
		return extent;
	}

	// Create an extent report instance
	public static ExtentReports createInstance() {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(extentReportPath);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Nopcommerce HTML Report");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Nopcommerce HTML Report");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		return extent;
	}

	
}