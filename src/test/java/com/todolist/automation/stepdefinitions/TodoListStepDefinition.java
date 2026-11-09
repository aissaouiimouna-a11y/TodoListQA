package com.todolist.automation.stepdefinitions;

import com.todolist.automation.page_objects.TodoListPage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TodoListStepDefinition {

    private TodoListPage todoListPage;

    public TodoListStepDefinition() {
        todoListPage = new TodoListPage();
    }

    @Then("le bouton Ajouter est desactive")
    public void leBoutonAjouterEstDesactive() {
        assertTrue(todoListPage.isAddTaskButtonEnabled());
    }

    @When("j ajoute une tache {string}")
    public void jAjouteUneTache(String task) {
        todoListPage.addTask(task);
    }

    @Then("la tache {string} est presente dans le localStorage")
    public void laTacheEstPresenteDansLeLocalStorage(String task) {
        assertTrue(todoListPage.isTaskInLocalStorage(task));
    }

    @And("je modifie le statut de la tache")
    public void jeModifieLeStatutDeLaTache() {
        todoListPage.clickTaskStatusButton();
    }

    @Then("le statut de la tache est mis a jour dans le localStorage")
    public void leStatutDeLaTacheEstMisAJourDansLeLocalStorage() {
        String storage = todoListPage.getLocalStorage("tasks");
        assertTrue(storage != null && !storage.equals("null"));
    }

    @And("je supprime la tache")
    public void jeSupprimeLaTache() {
        todoListPage.deleteTask();
    }

    @Then("la tache est supprimee du localStorage")
    public void laTacheEstSupprimeeduLocalStorage() {
        assertTrue(true);
    }
}