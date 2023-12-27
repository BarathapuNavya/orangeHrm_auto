package Stepdefinations;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Feature/Login.feature",//we hAve to give the feature file path
glue="Stepdefinations"//package of the current project package name

)


public class Testrunner {

}
