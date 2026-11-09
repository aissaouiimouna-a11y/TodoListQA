package com.todolist.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.todolist.automation.utils.ConfigFileReader;
import com.todolist.automation.utils.Setup;

public class LoginPage {

    private ConfigFileReader configFileReader;

    // ========================================
    //           LOCATORS @FindBy
    // ========================================

    @FindBy(how = How.XPATH, using = "//input[@type='email']")
    public WebElement emailField;

    @FindBy(how = How.XPATH, using = "//input[@type='password']")
    public WebElement passwordField;

    // ✅ Corrigé : input type submit
    @FindBy(how = How.XPATH, using = "//input[@type='submit']")
    public WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'alert')]")
    public WebElement errorMessage;

    // ========================================
    //           CONSTRUCTOR
    // ========================================

    public LoginPage() {
        PageFactory.initElements(Setup.getDriver(), this);
        this.configFileReader = new ConfigFileReader();
    }

    // ========================================
    //           ACTIONS
    // ========================================

    public void goToUrl() {
        Setup.getDriver().get(configFileReader.getProperties("todolist.url"));
    }

    public void fillEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void fillPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void login() {
        goToUrl();
        try { Thread.sleep(2000); } catch (Exception e) {}
        fillEmail(configFileReader.getProperties("todolist.email"));
        fillPassword(configFileReader.getProperties("todolist.password"));
        try { Thread.sleep(1000); } catch (Exception e) {}
        clickLoginButton();
        try { Thread.sleep(2000); } catch (Exception e) {}
    }

    public void loginWithCredentials(String email, String password) {
        goToUrl();
        try { Thread.sleep(2000); } catch (Exception e) {}
        fillEmail(email);
        fillPassword(password);
    }

    // ========================================
    //           GETTERS
    // ========================================

    public boolean isLoginButtonEnabled() {
        return loginButton.isEnabled();
    }

    public boolean isErrorMessageDisplayed() {
        try {
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessageColor() {
        return errorMessage.getCssValue("color");
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }
}
