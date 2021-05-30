package com.behsazan.test.prc;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.behsazan.exception.CustomizedWebDriverException;
import com.behsazan.pagefactory.prc.PRCLoginPageFactory;
import com.behsazan.pagefactory.prc.PrcHomePageFactory;
import com.behsazan.setups.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;


/**
 * Created by ${Eftekharnejad} on Apr, 2021
 **/

public class
TestPrcHomePage extends BaseTest {

    WebDriver driver;
    PrcHomePageFactory prcHomePageFactory;
    PRCLoginPageFactory PRCLoginPageFactory;
    ExtentTest reportTest;
    ExtentReports report;


    @BeforeClass( alwaysRun = true)
    public void getCtx(ITestContext ctx){
        this.driver = (WebDriver)ctx.getAttribute("driver");
        this.reportTest = (ExtentTest)ctx.getAttribute("reportTest");
        this.report = (ExtentReports)ctx.getAttribute("report");
    }

    //کلیک بر روی تامین کننده
    @Test(groups = {"SUPPLIER"})
    public void clickSupplierLoginTest() throws CustomizedWebDriverException, IOException{
        try {
            this.reportTest = this.report.createTest("تست کلیک بر روی تامین کننده","کلیک بر روی تامین کننده برای لاگین");
            this.prcHomePageFactory = new PrcHomePageFactory(this.driver);
            Assert.assertTrue(this.prcHomePageFactory.isAt());

            //کلیک بر روی تامین کننده
            this.prcHomePageFactory.clickOnSupplier();
            this.PRCLoginPageFactory = new PRCLoginPageFactory(this.driver);
            Assert.assertTrue(this.PRCLoginPageFactory.isAtLoginPage());
            reportTest.log(Status.PASS, "TestCase clickSupplierLoginTest passed:)");

        } catch (Exception ex){
            String msg = "TestCase clickBuyerLoginTest failed on exeption: \n" + ex.getMessage();
            throw new CustomizedWebDriverException(this.report, this.reportTest, this.driver, msg, "clickSupplierLoginTest");
        }
    }
    /**
     *  کلیک برروی خریدار
     *  added by hengameh
     */
    @Test(groups = {"BUYER"})
    public void clickBuyerLoginTest() throws CustomizedWebDriverException, IOException {
        try {
            this.reportTest = this.report.createTest("کلیک بر روی خریدار");
            this.prcHomePageFactory = new PrcHomePageFactory(this.driver);
            Assert.assertTrue(this.prcHomePageFactory.isAt());
            reportTest.log(Status.INFO, "صفحه مربوط به لاگین خریدار");
            this.prcHomePageFactory.clickOnBuyer();
            this.PRCLoginPageFactory = new PRCLoginPageFactory(this.driver);
            Assert.assertTrue(this.PRCLoginPageFactory.isAtLoginPage());
            this.reportTest.log(Status.PASS, "TestCase clickBuyerLoginTest passed :)");
        } catch (Exception ex){
            String msg = "TestCase clickBuyerLoginTest failed on exception: \n" + ex.getMessage();
            throw new CustomizedWebDriverException(this.report, this.reportTest, this.driver, msg, "clickBuyerLoginTest");
        }
    }

}
