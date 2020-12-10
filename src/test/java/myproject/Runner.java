package myproject;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/java/myproject/api"},
        glue = "myproject",
        tags = {"@Billing-02"},
        plugin = {
                "html:target/result",
                "pretty",
                "json:target/test-classes/reports/result.json"
        },
        monochrome = true
)

public class Runner extends  AbstractTestNGCucumberTests{
}

