package com.behsazan.pagefactory.prc;

import com.behsazan.pagefactory.AbstractPageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by ${Eftekharnejad} on Apr, 2021
 **/

public class AfterLoginMainPageFactory extends AbstractPageFactory {

    // تایید مدال صفحه اصلی تامین کننده
    By cnfrmBtn = By.xpath("//input[@type='button' and @onclick='closeDialog()']");

    // خروج مدال صفحه اصلی تامین کننده
    By exitBtn = By.xpath("//input[@type='button' and @value='خروج']");

    //زمان باقیمانده
    By remainTimeLbl = By.xpath("//font[contains(text(),'زمان باقیمانده')]");

    //صدور صورت حساب الکترونیکی در کارتابل تامین کننده
    By invoiceCartable = By.id("stUI26_txt");

    //شماره معامله برای جستجو
    By tradeNumber = By.id("tradeNumberObject");

    //کارتابل مدیریت قراداد ها
    By ContractCartable = By.id("stUI36_txt");

    /*-------------------------------------------------------------*/
    public AfterLoginMainPageFactory(WebDriver driver) { super(driver); }
    /*-------------------------------------------------------------*/

    public void clickCartable() throws InterruptedException {
        withElement(cnfrmBtn).click();
        withElement(exitBtn).click();
        withElement(invoiceCartable).click();
    }

    // added by hengameh for contract
    public void ContractCartableClick() {
        withElement(cnfrmBtn).click();
        withElement(ContractCartable).click();
    }

    public boolean isAtLoginPage(){
        return withElement(remainTimeLbl).isAtPage();
    }


    public boolean isAt(){
        return withElement(tradeNumber).isAtPage();
    }


    }

