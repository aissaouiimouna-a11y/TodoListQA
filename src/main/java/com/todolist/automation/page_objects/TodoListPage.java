package com.todolist.automation.page_objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.todolist.automation.utils.Setup;

public class TodoListPage {

    // ========================================
    //           LOCATORS @FindBy
    // ========================================

	// Champ Nom de la tâche
	@FindBy(how = How.XPATH, using = "(//input[@type='text'])[1]")
	public WebElement taskNameField;

	// Champ Description de la tâche
	@FindBy(how = How.XPATH, using = "(//input[@type='text'])[2]")
	public WebElement taskDescField;
	
	

	// Lien Supprimer
	@FindBy(how = How.LINK_TEXT, using = "Supprimer")
	public WebElement deleteTaskLink;

	// Bouton statut ← UNIQUEMENT CELUI-CI
	@FindBy(how = How.XPATH, using = "//button[contains(@class,'btn')]")
	public WebElement taskStatusButton;

	// Bouton Ajouter la tâche
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Ajouter la tâche')]")
	public WebElement addTaskButton;

    // ========================================
    //           CONSTRUCTOR
    // ========================================

    public TodoListPage() {
        PageFactory.initElements(Setup.getDriver(), this);
    }

    // ========================================
    //           ACTIONS
    // ========================================

    public void fillTaskName(String task) {
        taskNameField.clear();
        taskNameField.sendKeys(task);
    }

    public void fillTaskDesc(String desc) {
        taskDescField.clear();
        taskDescField.sendKeys(desc);
    }

    public void clickAddTaskButton() {
        addTaskButton.click();
    }

    public void addTask(String task) {
        fillTaskName(task);
        fillTaskDesc(task);
        try { Thread.sleep(1000); } catch (Exception e) {}
        clickAddTaskButton();
        try { Thread.sleep(1000); } catch (Exception e) {}
    }
    

    public void deleteTask() {
        deleteTaskLink.click();  // ← lien pas bouton
    }
    public void clickTaskStatusButton() {
        taskStatusButton.click();
    }

    // ========================================
    //           GETTERS localStorage
    // ========================================

    public String getLocalStorage(String key) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) Setup.getDriver();
            Object result = js.executeScript(
                "return window.localStorage.getItem(arguments[0]);", key
            );
            return result != null ? result.toString() : null;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean isTaskInLocalStorage(String task) {
        String storage = getLocalStorage("tasks");
        if (storage == null || storage.equals("null")) return false;
        return storage.contains(task);
    }

    public boolean isAddTaskButtonEnabled() {
        return addTaskButton.isEnabled();
    }
}