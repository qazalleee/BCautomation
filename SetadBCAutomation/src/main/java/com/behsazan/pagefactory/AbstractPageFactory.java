package com.behsazan.pagefactory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.Iterator;
import java.util.List;


/**
 * Created by HanaBizhani on Apr, 2021
 **/
public class AbstractPageFactory {

    private WebElement webElement;

   public enum ELEMENT_INDEXING {
        BY_SIZE
    }

    private static final long SLEEP_FOR = 200L;
    //How long should I wait until the element be fined
    private long timeoutInSeconds = 10;

    public final WebDriver driver;

    public AbstractPageFactory(WebDriver driver) {
        this.driver = driver;
    }


    private List<WebElement> getElements(By by) {
        try {
            return driver.findElements(by);
        } catch (StaleElementReferenceException ex) {
            waitFor();
            return driver.findElements(by);
        }
    }

    //working element with by and index
    public AbstractPageFactory withElements(By by, int index) {
        this.webElement = getElements(by).get(index);
        return this;
    }

    //click on a ulist and select one of it's elements
    public void uListClickAndSelect(String elementTxt){
        webElement.click();
        (new WebDriverWait(driver, timeoutInSeconds)).until
                (ExpectedConditions.elementToBeClickable(By.cssSelector("li[value='" + elementTxt + "']"))).click();
    }
    

    //working element with by and size of elements - decrementalValue
    public AbstractPageFactory withElements(By by, ELEMENT_INDEXING elementIndexing, int decrementalValue) {
        if (elementIndexing == ELEMENT_INDEXING.BY_SIZE) {
            List<WebElement> webElements = getElements(by);
            this.webElement = webElements.get(webElements.size() - decrementalValue);
            return this;
        }
        return null;
    }

    //working element with by
    public AbstractPageFactory withElement(By by) {
        try {
            this.webElement = (new WebDriverWait(driver, timeoutInSeconds)).until(ExpectedConditions.elementToBeClickable(by));
        } catch (StaleElementReferenceException ex) {
            waitFor();
            this.webElement = driver.findElement(by);
        }
        return this;
    }

    //Simply click a button
    public AbstractPageFactory click() {
        (new WebDriverWait(driver, timeoutInSeconds)).until(ExpectedConditions.elementToBeClickable(webElement)).click();
        return this;
    }

    //Write text in an element
    public AbstractPageFactory writeText(String text) {
        (new WebDriverWait(driver, timeoutInSeconds)).until(ExpectedConditions.visibilityOf(webElement)).sendKeys(text);
        return this;
    }

    //Get text of an element
    public String getText() {
        return (new WebDriverWait(driver, timeoutInSeconds)).until(ExpectedConditions.elementToBeClickable(webElement)).getText();
    }

    public AbstractPageFactory writeAndSelectWithArrows(String txtToSelect) throws InterruptedException {
        clearText();
        writeText(txtToSelect);
        Thread.sleep(2000);
        webElement.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        webElement.sendKeys(Keys.ENTER);
        return this;
    }

    //Clear element text
    public AbstractPageFactory clearText() {
        (new WebDriverWait(driver, timeoutInSeconds)).until(ExpectedConditions.elementToBeClickable(webElement)).clear();
        return this;
    }

    //Check if is at page
    public boolean isAtPage() {
        return (new WebDriverWait(driver, timeoutInSeconds))
                .until(ExpectedConditions.visibilityOf(webElement)).isDisplayed();
    }


    private void waitFor() {
        try {
            Thread.sleep(SLEEP_FOR);
        } catch (InterruptedException var2) {
            throw new AssertionError(var2);
        }
    }


    //-------------------added by ghazale for selecting combobox-----------------------
//todo
    public void selectComboBoxByValue(String value){
        selectByValue(value);
   }

        private void selectByValue(String value) {
            this.findOptionsByValue(value).iterator();
        }

        private List<WebElement> findOptionsByValue(String value) {
            List<WebElement> options = webElement.findElements(By.xpath(".//li[@data-value = " + Quotes.escape(value) + "]"));
            if (options.isEmpty()) {
                throw new NoSuchElementException("Cannot locate option with value: " + value);
            } else {
                options.get(0).click();
                return options;
            }
        }


    //-------------------added by ghazale for isDisplayed-----------------------

        public String isDisplayed() throws InterruptedException {
        try {
             (new WebDriverWait(driver, 5))
                    .until(ExpectedConditions.visibilityOf(webElement)).isDisplayed();
           if(webElement.isDisplayed())
            return webElement.getText();
           else return null;
        }
                  catch(Exception ex){ return null;}
        }
      /*  -----------------------*/
      private WebElement webElement1;

      public boolean isDisplayed1(By by1) throws InterruptedException {
                    try {
              this.webElement1 = (new WebDriverWait(driver, timeoutInSeconds)).until(ExpectedConditions.elementToBeClickable(by1));
              if (webElement1.isDisplayed())
                  return true;
              else return false;
          } catch (Exception ex) {
              this.webElement1 = driver.findElement(by1);
              return false;
          }
      }









}