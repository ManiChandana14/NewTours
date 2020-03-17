package com.TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(features = "OrangeHRM", glue = {"com.StepDefinition"}, monochrome = true)

public class RunCuke {

}