package org.stepdefinition;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass {
	Scenario sc;
	@Before
	public void beforeHook(Scenario scenario) {
		sc=scenario;
	}
		
	@After
	public void afterHook() {
		if (sc.isFailed()) {
			TakesScreenshot tk = (TakesScreenshot) StepDefinition.driver;
			byte[] screenshotAs = tk.getScreenshotAs(OutputType.BYTES);
			sc.attach(screenshotAs, "image/png", sc.getName());
		}
	}						

}
