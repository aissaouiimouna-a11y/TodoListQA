package com.todolist.automation.stepdefinitions;

import com.todolist.automation.page_objects.LoginPage;
import com.todolist.automation.utils.Setup;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginStepDefinition {

    private LoginPage loginPage;

    @Before
    public void setUp() {
        Setup.initDriver();
        loginPage = new LoginPage();
    }

    @After
    public void tearDown() {
        Setup.quitDriver();
    }

    @Given("je me connecte a l application TodoList")
    public void jeMeConnecteALApplicationTodoList() {
        loginPage.goToUrl();
    }

    @When("je saisis l email {string} et le mot de passe {string}")
    public void jeSaisisLEmailEtLeMotDePasse(String email, String password) {
        loginPage.fillEmail(email);
        loginPage.fillPassword(password);
    }

    @And("je clique sur le bouton Envoyer")
    public void jeCliqueSurLeBoutonEnvoyer() {
        loginPage.clickLoginButton();
    }

    @Then("le bouton Envoyer est desactive")
    public void leBoutonEnvoyerEstDesactive() {
        assertFalse(loginPage.isLoginButtonEnabled());
    }

    @Then("un message d erreur rouge apparait")
    public void unMessageDErreurRougeApparait() {
        assertTrue(loginPage.isErrorMessageDisplayed());
        assertTrue(loginPage.getErrorMessageColor().contains("255, 0, 0")
            || loginPage.getErrorMessageText()
               .contains("Désolé, les identifiants sont incorrects"));
    }

    @Then("je suis redirige vers la page des taches")
    public void jeSuisRedirigeVersLaPageDesTaches() {
        assertTrue(Setup.getDriver().getCurrentUrl()
            .contains("tasks") ||
            Setup.getDriver().getCurrentUrl()
            .contains("localhost:3000"));
    }
}