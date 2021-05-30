package com.behsazan.exception;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by HanaBizhani on 7/17/2019.
 */
public class CustomizedWebDriverException extends Exception{
    public CustomizedWebDriverException(ExtentReports extent, ExtentTest test,
                                        WebDriver driver, String message, String methodName) throws IOException {
        super(message);

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String fileName = System.getProperty("user.dir") + "\\test-output\\"+ "\\images\\" + methodName + "_" + System.currentTimeMillis() + ".png";
        FileUtils.copyFile(src, new File(fileName));
        test.log(Status.FAIL, methodName + ": " + message + "\n" );
        test.fail("Test Case Failed Snapshot is below " + test.addScreenCaptureFromPath(fileName));
        extent.flush();
        driver.quit();


    }

}
