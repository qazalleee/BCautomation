package com.behsazan.test.prc;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.behsazan.dataproviders.prc.PRCLoginDataProviderValues;
import com.behsazan.exception.CustomizedWebDriverException;
import com.behsazan.pagefactory.prc.AfterLoginMainPageFactory;
import com.behsazan.pagefactory.prc.PRCLoginPageFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.IOException;

/**
 * Created by ${Eftekharnejad} on Apr, 2021
 **/


public class TestPrcLoginPage {

    WebDriver driver;
    PRCLoginPageFactory loginPageFactory;
    ExtentTest reportTest;
    ExtentReports report;

    String loginRole = "";

    // change login role by hengameh for contract
    @DataProvider(name="LoginDataProvider")
    public Object[][] getDataFromDataprovider(){
        switch (loginRole){
            case "maghamLogin":
                return PRCLoginDataProviderValues.maghamLoginData;
            case "AnbardarLogin":
                return PRCLoginDataProviderValues.AnbardarLoginData;
            case "supplierLogin":
                return PRCLoginDataProviderValues.supplierLoginData;
            default:
                return null;}}

    @BeforeClass(alwaysRun = true)
    @Parameters({"loginType"})
    public void getGtx(String loginType, ITestContext ctx){
        driver = (WebDriver) ctx.getAttribute("driver");
        reportTest = (ExtentTest) ctx.getAttribute("reportTest");
        report = (ExtentReports) ctx.getAttribute("report");
        ctx.setAttribute("LoginRole" , loginType);
        loginRole = loginType;
    }


    @Test(groups = {"ALL","LOGIN"}, dataProvider = "LoginDataProvider")
    private void login(String userName, String passsword, String securityCode) throws IOException, CustomizedWebDriverException {
        try {
            reportTest = report.createTest("تست لاگین به سامانه خرید", "لاگین تامین کننده یا خریدار به سامانه خرید");
            loginPageFactory = new PRCLoginPageFactory(driver);
            Assert.assertTrue(loginPageFactory.isAtLoginPage());
            reportTest.log(Status.INFO, "we are at login page");

            //لاگین تامین کننده
            loginPageFactory.userLogin(userName, passsword, securityCode);
            reportTest.log(Status.INFO, "userName=" + userName + ",password=" + passsword + ",securityCode=" + securityCode);


            AfterLoginMainPageFactory afterLoginMainPageFactory = new AfterLoginMainPageFactory(driver);
            Assert.assertTrue(afterLoginMainPageFactory.isAtLoginPage());

            reportTest.log(Status.PASS, "TestCase login passed :)");
        }
        catch (Exception ex){
            String msg = "TestCase login failed on exception: \n" + ex.getMessage();
            throw new CustomizedWebDriverException(report , reportTest , driver, msg, "login");
        }
    }


}
