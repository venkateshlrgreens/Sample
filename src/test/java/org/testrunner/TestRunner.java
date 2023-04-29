package org.testrunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.report.GenerateCucumberReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features="FeatureFile\\adactin.feature", glue="org.stepdefinition",monochrome=true, dryRun=false,
plugin= {"pretty","json:src/test/resources/report/cucumber.json","junit:src/test/resources/report/cucumber.xml",
		"html:src/test/resources/report/cucumber.html",
		"rerun:FeatureFile\\Rerun.txt"})


public class TestRunner {

	@AfterClass
public static void afterClass() {
		GenerateCucumberReport.executeReport();
	}
}
