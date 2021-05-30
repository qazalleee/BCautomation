package com.behsazan.pagefactory.prc;

import com.behsazan.pagefactory.AbstractPageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by ${Eftekharnejad} on Apr, 2021
 **/

public class PrcHomePage extends AbstractPageFactory {

    //دکمه خریدار
    By buyerLoginBtn = By.xpath("//img[contains(@src,'buyerButton.jpg')]");

    //دکمه تامین کننده
    By supplierLoginBtn = By.xpath("//img[contains(@src,'supplierButton.jpg')]");


    public PrcHomePage(WebDriver driver) {
        super(driver);
    }


    /**
     *  کلیک برروی خریدار
     */
    public void clickOnBuyer(){
        withElement(buyerLoginBtn).click(); }

    
    /**
     *  کلیک تامین کننده
     */
    public void clickOnSupplier(){ withElement(supplierLoginBtn).click(); }


    public boolean isAtLoginPage(){
        return withElement(buyerLoginBtn).isAtPage();
    }

}
