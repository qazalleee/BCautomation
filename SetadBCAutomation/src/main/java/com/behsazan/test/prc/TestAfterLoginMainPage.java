package com.behsazan.test.prc;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.behsazan.exception.CustomizedWebDriverException;
import com.behsazan.pagefactory.prc.AfterLoginMainPageFactory;
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

public class TestAfterLoginMainPage {

    WebDriver driver;
    ExtentTest reportTest;
    ExtentReports report;
    AfterLoginMainPageFactory afterLoginMainPageFactory;


    @BeforeClass(alwaysRun = true)
    public void getCtx(ITestContext ctx){
        driver = (WebDriver) ctx.getAttribute("driver");
        reportTest = (ExtentTest) ctx.getAttribute("reportTest");
        report = (ExtentReports) ctx.getAttribute("report");
    }



    @Test(groups = {"ALL"})
    public void cartableClick() throws IOException, CustomizedWebDriverException {
        try {
            afterLoginMainPageFactory = new AfterLoginMainPageFactory(driver);
            reportTest = report.createTest("تست کلیک بر روی کارتابل صدور صورتحساب","از کارتابل تامین کننده بر روی صدور صورتحساب کلیک می کنیم");

            Assert.assertTrue(afterLoginMainPageFactory.isAtLoginPage());
            reportTest.log(Status.INFO, "logged in successfully");

            afterLoginMainPageFactory.clickCartable();
            reportTest.log(Status.INFO, "confirm popups and then click on issuance invoice cartable" );

            Assert.assertTrue(afterLoginMainPageFactory.isAt());
            reportTest.log(Status.PASS, "TestCase cartableClick passed :)");

        }catch (Exception ex){
            String msg = "TestCase cartableClick failed on exception: \n" + ex.getMessage();
            throw new CustomizedWebDriverException(report, reportTest, driver, msg, "cartableClick");
        }
    }


    @Test(groups = {"CONTRACT"})
    public void ContractCartableClick() throws IOException, CustomizedWebDriverException {
        try {
            afterLoginMainPageFactory = new AfterLoginMainPageFactory(driver);
            reportTest = report.createTest("شروع فرآیند");

            Assert.assertTrue(afterLoginMainPageFactory.isAtLoginPage());
            reportTest.log(Status.INFO, "در صفحه لاگین می باشد");

            afterLoginMainPageFactory.ContractCartableClick();
            reportTest.log(Status.PASS.INFO, "کلیک بر روی کارتابل قرارداد" );

            reportTest.log(Status.PASS, "TestCase cartableClick passed :)");

        }catch (Exception ex){
            String msg = "TestCase cartableClick failed on exception: \n" + ex.getMessage();
            throw new CustomizedWebDriverException(report, reportTest, driver, msg, "cartableClick");
        }
    }

}
