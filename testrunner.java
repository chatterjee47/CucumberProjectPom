package runner;

import java.io.File;


import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;

import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "classpath:features" }, 
glue="seleniumgluecode",
plugin = {"pretty", "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/ExtendedReport.html","html:target/cucumber-html-report","json:target/cucumber.json","html:target/Cucumber-JVM-report"},
monochrome =true //display the console output in a proper readable format
,strict=true //it will check if any step is not defined in step definition file
,dryRun = false  //to check the mapping is proper btw feature file and step defn file
//,tags = {"@FuntionalTest" , "~@SmokeTest" , "~@End2EndTest"}
)
        


public class testrunner extends AbstractTestNGCucumberTests{
    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("config/extent-config.xml"));
    
    }
}


