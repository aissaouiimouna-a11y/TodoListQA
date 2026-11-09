package com.todolist.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.todolist.automation.utils.Setup;

public class NavBarPage {

    // ========================================
    //           LOCATORS @FindBy
    // ========================================

	@FindBy(how = How.LINK_TEXT, using = "Tâches")
	public WebElement tachesLink;

	@FindBy(how = How.LINK_TEXT, using = "Déconnexion")
	public WebElement deconnexionLink;

	@FindBy(how = How.LINK_TEXT, using = "Home")
	public WebElement homeLink;
    // ========================================
    //           CONSTRUCTOR
    // ========================================

    public NavBarPage() {
        PageFactory.initElements(Setup.getDriver(), this);
    }

    // ========================================
    //           ACTIONS
    // ========================================

    public void clickTaches() {
        tachesLink.click();
    }

    public void clickDeconnexion() {
        deconnexionLink.click();
    }

    // ========================================
    //           GETTERS
    // ========================================

    public boolean isTachesLinkVisible() {
        try {
            return tachesLink.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDeconnexionLinkVisible() {
        try {
            return deconnexionLink.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
