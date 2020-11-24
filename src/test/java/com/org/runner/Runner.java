package com.org.runner;

import org.testng.annotations.AfterSuite;

import com.org.utlity.MasterReport;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "features", plugin = { "json:target/cucumber.json" }, glue = { "com.org.steps",
		"com.org.hooks" }, //tags = { "@LoginWithValidCredentials" , " @LoginWithInvalidCredentials"  },   
monochrome = true)
public class Runner extends AbstractTestNGCucumberTests {

	@AfterSuite
	public void generateReport() {
		MasterReport.generateJVMReport();
	}
}
