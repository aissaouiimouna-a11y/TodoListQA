package com.todolist.automation.stepdefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/spec/features"},
        plugin = {
            "pretty",
            "html:target/cucumber-report.html"
        },
        tags = "@login_bouton_desactive or @login_invalide or @login_valide" +
               " or @navbar_non_connecte or @navbar_connecte" +
               " or @tache_bouton_desactive or @tache_ajout" +
               " or @tache_modification or @tache_suppression",
        glue = {
            "com.todolist.automation.stepdefinitions",
            "com.todolist.automation.utils"
        },
        monochrome = true,
        snippets = CAMELCASE
)
public class RunWebSuiteTest {
}