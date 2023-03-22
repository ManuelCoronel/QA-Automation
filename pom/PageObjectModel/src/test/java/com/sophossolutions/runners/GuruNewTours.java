package com.sophossolutions.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		glue = "com.sophossolutions.stepdefinition",
		features = "src/test/resources/com/sophossolutions/features/guru_new_tours.feature",
		snippets = SnippetType.CAMELCASE
		)
public class GuruNewTours {

}
