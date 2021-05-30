package com.behsazan.pagefactory.prc;

import com.behsazan.pagefactory.AbstractPageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by ${Eftekharnejad} on Apr, 2021
 **/

public class PRCLoginPageFactory extends AbstractPageFactory {

    // نام کاربری
    By userName = By.name("userName");

    //رمز عبور
    By password =By.name("password");

    //کد امنیتی
    By securityCode = By.id("securitycode");

    // دکمه عبور
    By submitBtn = By.name("imgUser");

    // پیغام شناسه کاربری یا کلمه عبور اشتباه است
    By errorMsg = By.className("errortext");

    /*-------------------------------------------------------------*/
    public PRCLoginPageFactory(WebDriver driver) { super(driver); }
    /*-------------------------------------------------------------*/

    public void userLogin(String userNameVal, String passwordVal, String securityCodeVal){
        withElement(userName).clearText().writeText(userNameVal);
        withElement(password).clearText().writeText(passwordVal);
        withElement(securityCode).clearText().writeText(securityCodeVal);
        withElement(submitBtn).click();
    }


    public boolean isAtLoginPage(){
        return withElement(securityCode).isAtPage();
    }

    }