package com.behsazan.setups;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.behsazan.exception.CustomizedWebDriverException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by HanaBizhani on 7/13/2019.
 */
public class BaseTest {

    DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("yy-MM-dd HH-mm-ss");
    LocalDateTime now = LocalDateTime.now();
    String reportName = dateTime.format(now);

    private WebDriver driver;
    private ExtentReports extent;
    private ExtentHtmlReporter htmlReporter;
    public ExtentTest test;

    /*@BeforeSuite(alwaysRun = true)
    @Parameters({"os", "browser", "browserVersion", "url", "node"})
    public void setupDriver(String os, String browser, int browserVersion, String url, String node) throws MalformedURLException {

        SetupTestDriver setupTestDriver = new SetupTestDriver(os, browser, browserVersion, url, node);
        driver = setupTestDriver.getDriver();
    }*/

    @BeforeTest(alwaysRun = true)
    @Parameters({"os", "browser", "browserVersion", "url", "node"})
    public void setUp(String os, String browser, int browserVersion, String url, String node) throws MalformedURLException {
        SetupTestDriver setupTestDriver = new SetupTestDriver(os, browser, browserVersion, url, node);
        driver = setupTestDriver.getDriver();

        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\test-output\\"+"ExtentReport-"+ reportName + ".html");
        extent = new ExtentReports();  //create object of ExtentReports
        extent.attachReporter(htmlReporter);

        htmlReporter.config().setDocumentTitle("Automation Report"); // Tittle of Report
        htmlReporter.config().setReportName("Extent Report V4"); // Name of the report
        htmlReporter.config().setTheme(Theme.DARK);//Default Theme of Report

        // General information releated to application
        extent.setSystemInfo("co", "BehsazanMellat");
        extent.setSystemInfo("dev", "Toseh 5");
        extent.setSystemInfo("group", "QC");
    }

    @BeforeClass(alwaysRun = true)
    public void storeDriver(ITestContext ctx){
        ctx.setAttribute("driver", driver);
        ctx.setAttribute("reportTest", test);
        ctx.setAttribute("report", extent);
    }


    @AfterMethod(alwaysRun = true)
    public void setFailLog(ITestResult result) throws IOException, CustomizedWebDriverException {
        if (result.getStatus() == ITestResult.FAILURE){
            test = extent.createTest(result.getName());
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            test.log(Status.FAIL, "Throws: " + result.getThrowable());
            throw new CustomizedWebDriverException(extent, test, driver, "Assert Fail", result.getMethod().getMethodName());

        }
    }

    @AfterSuite(alwaysRun = true)
    public void endReport(){
        extent.flush();
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser() {

        driver.quit();
    }

}
