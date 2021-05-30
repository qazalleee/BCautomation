package com.behsazan.setups;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SetupTestDriver {

    private WebDriver driver = null;
    private String browser = null;
    private String baseUrl = null;
    private String os = null;
    private String node = null;

    public SetupTestDriver(String os, String browser, int browserVersion, String baseUrl, String node) throws MalformedURLException {
        this.browser = browser;
        this.os = os;
        this.node = node;
        Platform platform = Platform.fromString(os.toUpperCase());
        //  System.out.println("BROOOOWSER is:"+browser );
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setCapability("platform", platform);
            // this.driver = new RemoteWebDriver(new URL(node + "/wd/hub"), chromeOptions);
            //new
           /* System.setProperty("webdriver.chrome.driver", "/C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
            this.driver = new ChromeDriver(chromeOptions);*/

            //End
        } else if (browser.equalsIgnoreCase("firefox")) {
            this.baseUrl = baseUrl;
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setCapability("platform", platform);
            /*switch(browserVersion) {
                case 57:
                    firefoxOptions.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
                    break;
                case 59:
                    firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\V 59.0.1\\firefox.exe");
                    break;
                case 60:
                    firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\V 60.0.1\\firefox.exe");
                case 61:
                case 62:
                case 64:
                case 65:
                default:
                    break;
                case 63:
                    firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\V 63.0.1\\firefox.exe");
                    break;
                case 66:
                    firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\V 66.0.2\\firefox.exe");
                    break;
                case 67:
                    firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\V 67.0.2\\firefox.exe");
                    break;
                case 68:
                    firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\V 68.0\\firefox.exe");
            }*/

            //remote run
            //this.driver = new RemoteWebDriver(new URL(node + "/wd/hub"), firefoxOptions);

            //local run
            //**************************************************************************
            FirefoxBinary binary64 = new FirefoxBinary(new File(/*"/C:\\Program Files\\Mozilla Firefox\\firefox.exe"*/ "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"));
            //C:\Program Files\Mozilla Firefox\firefox.exe
            System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
            DesiredCapabilities capabilities64 = DesiredCapabilities.firefox();
            FirefoxOptions firefoxOptions64 = new FirefoxOptions().setBinary(binary64);
            driver = new FirefoxDriver(firefoxOptions64);
            //**************************************************************************




        } else {
            InternetExplorerOptions ieOption = new InternetExplorerOptions();
            ieOption.setCapability("platform", platform);
            this.driver = new RemoteWebDriver(new URL(node + "/wd/hub"), ieOption);
        }

        this.driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
        this.driver.get(baseUrl);
    }

    public String getOs() {
        return this.os;
    }

    public String getBrowser() {
        return this.browser;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getNode() {
        return this.node;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

}
