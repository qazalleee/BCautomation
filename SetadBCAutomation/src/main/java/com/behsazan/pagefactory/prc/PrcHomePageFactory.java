package com.behsazan.pagefactory.prc;

import com.behsazan.pagefactory.AbstractPageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by ${Eftekharnejad} on Apr, 2021
 **/

public class PrcHomePageFactory extends AbstractPageFactory {

    //دکمه خریدار
    By buyerLoginBtn = By.xpath("//img[contains(@src,'buyerButton.jpg')]");

    //دکمه تامین کننده
    By supplierLoginBtn = By.xpath("//img[contains(@src,'supplierButton.jpg')]");

    /*-------------------------------------------------------------*/
    public PrcHomePageFactory(WebDriver driver) { super(driver); }
    /*-------------------------------------------------------------*/

    //کلیک روی خریدار
    public void clickOnBuyer(){withElement(buyerLoginBtn
    ).click(); }


    // کلیک روی تامین کننده
    public void clickOnSupplier(){withElement(supplierLoginBtn).click(); }


    public boolean isAt(){ return withElement(buyerLoginBtn).isAtPage(); }

}
