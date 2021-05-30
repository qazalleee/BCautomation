package com.behsazan.setups;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by HanaBizhani on 7/9/2019.
 */
public class SetupTestDriver_Grid {
    //private WebDriver driver = null;
    private RemoteWebDriver driver = null;
    private String browser = null;
    private String baseUrl = null;
    private String os = null;
    private String node = null;

    public SetupTestDriver_Grid(String os, String browser, int browserVersion, String baseUrl, String node) throws MalformedURLException {
        this.browser = browser;
        this.os = os;
        this.node = node;

        Platform platform = Platform.fromString(os.toUpperCase());
        /*if(browser.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setCapability("platform", platform);
            this.driver = new RemoteWebDriver(new URL(node + "/wd/hub"), chromeOptions);
            //System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
            //this.driver = new ChromeDriver(chromeOptions);

        } else if (browser.equalsIgnoreCase("firefox")) {


            this.baseUrl = baseUrl;
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setCapability("platform", platform);
            //firefoxOptions.setCapability("marionette", false);

            switch (browserVersion){
                case 59:
                    firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\V 59.0.1\\firefox.exe");
                    break;
                case 60:
                    firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\V 60.0.1\\firefox.exe");
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
                    break;

                case 72:
                    firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
                    break;
            }


            System.setProperty("webdriver.gecko.logfile", "TestLog.txt");
            System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
            this.driver = new RemoteWebDriver(new URL(node + "/wd/hub"), firefoxOptions);


            //**************************************************************************
            *//*System.setProperty("webdriver.gecko.logfile", "TestLog.txt");
            System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
            FirefoxBinary binary64 = new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe"));
            DesiredCapabilities capabilities64 = DesiredCapabilities.firefox();
            FirefoxOptions firefoxOptions64 = new FirefoxOptions().setBinary(binary64);
            driver = new FirefoxDriver(firefoxOptions64);*//*
            //**************************************************************************



        } else {
            InternetExplorerOptions ieOption = new InternetExplorerOptions();
            ieOption.setCapability("platform", platform);
            this.driver = new RemoteWebDriver(new URL(node + "/wd/hub"), ieOption);
        }*/

        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
        DesiredCapabilities desiredCapabilities = null;
        if (browser.equals("firefox")){
            System.out.println("i'm firefox");
            desiredCapabilities = DesiredCapabilities.firefox()
                    ;
            desiredCapabilities.setBrowserName("firefox");
            //desiredCapabilities.setVersion("67.0.4");
            desiredCapabilities.setPlatform(Platform.WINDOWS);
            //String fireFoxPath = "C:\\Program File\\Mozilla Firefox\\V 67.0.4\\firefox.exe";
            //desiredCapabilities.setCapability(FirefoxDriver.BINARY, fireFoxPath);
        }
        else if (browser.equals("chrome")){
            System.out.println("i'm chrome");
            desiredCapabilities = DesiredCapabilities.chrome()
            ;
            desiredCapabilities.setBrowserName("chrome");
            //desiredCapabilities.setVersion("67.0.4");
            desiredCapabilities.setPlatform(Platform.WINDOWS);
        }

        System.out.println("i'm out");
        this.driver = new RemoteWebDriver(new URL("http://172.20.160.187:4444/wd/hub") , desiredCapabilities);

        System.out.println("i'm after");
        this.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
