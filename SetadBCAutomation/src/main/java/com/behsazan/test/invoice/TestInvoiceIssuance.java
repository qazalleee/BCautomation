/*
package com.behsazan.test.invoice;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.behsazan.dataproviders.invoice.InvoiceProviderValues;
import com.behsazan.ddl.invoice.InvoiceDDL;
import com.behsazan.pagefactory.invoice.InvoiceIssuanceCartableFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.IOException;
import com.behsazan.exception.CustomizedWebDriverException;
import com.behsazan.dataproviders.contract.SignDataProviderValues;

*/
/**
 * Created by ${Eftekharnejad} on Apr, 2021
 **//*



public class TestInvoiceIssuance  {


    WebDriver driver;
    ExtentTest reportTest;
    ExtentReports report;
    InvoiceIssuanceCartableFactory invoiceIssuanceCartableFactory;
    String invoiceType = "";
    SignDDL signDDL;
    String loginRole;


    @BeforeClass(alwaysRun = true)
    @Parameters({"invoiceType"})
    public void getCtx(ITestContext ctx, String InvoiceType){
        driver = (WebDriver) ctx.getAttribute("driver");
        reportTest = (ExtentTest) ctx.getAttribute("reportTest");
        report = (ExtentReports) ctx.getAttribute("report");
        this.invoiceType = InvoiceType;
        loginRole = (String) ctx.getAttribute("LoginRole");
    }


    @Test(groups = {"SENDPRICE"}, dataProvider = "SignDataProviderValues", dataProviderClass = SignDataProviderValues.class)
    public void initSignDDL(SignDDL signDDL){
        this.signDDL = signDDL;
    }


    @Test(groups = {"ALL"}, dependsOnMethods = {"initSignDDL"}, dataProvider = "InvoiceProviderValues", dataProviderClass = InvoiceProviderValues.class)
    public void invoiceIssuance(InvoiceDDL invoiceDDL) throws IOException, CustomizedWebDriverException {
        try {
            invoiceIssuanceCartableFactory = new InvoiceIssuanceCartableFactory(driver);
            reportTest = report.createTest("تست صدور صورتحساب","کلیک بر روی لینک عددی در انتظار صدور صورتحساب فروش/ در انتظار صدور صورتحساب برگشت از فروش");
            Assert.assertTrue(invoiceIssuanceCartableFactory.isAt());

            invoiceIssuanceCartableFactory.ClickInvoiceIssuanceLink(invoiceType);
            reportTest.log(Status.INFO, "Clicked on Invoice Issuance Link" );

            Assert.assertTrue(invoiceIssuanceCartableFactory.isAtIssuancePage());
            reportTest.log(Status.INFO, "we are at invoic issuance page");

            if(invoiceType.equals("ReturnInvoiceIssuance")){
                invoiceIssuanceCartableFactory.buttonForSelectInvoice(invoiceType); }

                if(invoiceType.equals("InvoiceIssuance")){
            invoiceIssuanceCartableFactory.fillAddress(invoiceDDL);
            reportTest.log(Status.INFO, "address selected" );}


            invoiceIssuanceCartableFactory.FillSerialNumber(invoiceDDL);
            reportTest.log(Status.INFO, "serial number filled" );

            if(invoiceIssuanceCartableFactory.CheckTransitionList()== true){

            invoiceIssuanceCartableFactory.AddToTransitionList();
            reportTest.log(Status.INFO, "added to transition list" );}

            invoiceIssuanceCartableFactory.Save();
            reportTest.log(Status.INFO, "invoice saved" );

            String getmessage = invoiceIssuanceCartableFactory.getMessage();
            reportTest.log(Status.INFO, getmessage );

            invoiceIssuanceCartableFactory.IssuanceInvoice();
            reportTest.log(Status.INFO, "clicked on invoice issuance button" );

            reportTest.log(Status.INFO, "sign process started" );
            */
/*------------------------------------امضا-----------------------------------------------*//*

            //todo
            Thread.sleep(2000);
            String returnMsg = invoiceIssuanceCartableFactory.SignInvoice(signDDL, loginRole);
            Thread.sleep(10000);

            org.testng.Assert.assertNotNull(returnMsg);
            reportTest.log(Status.INFO, " Signature process ends with message : " +
                    returnMsg);
            */
/*-----------------------------------------------------------------------------------*//*

            if(invoiceIssuanceCartableFactory.hasResult() != null) {
                //امضا با موفقیت
                reportTest.log(Status.PASS, invoiceIssuanceCartableFactory.hasResult() );
                reportTest.log(Status.PASS, "TestCase invoiceIssuance passed :)");
            }
            else{

                // امضا با خطا
                String returnMsg1 = invoiceIssuanceCartableFactory.returnFailMsg();
                reportTest.log(Status.FAIL, " Signature process ends with : " +
                        returnMsg1);
                reportTest.log(Status.PASS, "TestCase invoiceIssuance failed :(");
            }

        }catch (Exception ex){
            String msg = "TestCase cartableClick failed on exception: \n" + ex.getMessage();
            throw new CustomizedWebDriverException(report, reportTest, driver, msg, "cartableClick");
        }
    }

}


*/
