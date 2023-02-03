package CucumberRunner;

import io.cucumber.testng.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources/featureFilesLogin","src/test/resources/featureFilesSorting"},
        glue = {"cucumber.StepDefinitionsLogin","cucumber.StepDefinitionsSorting"})


public class TestRunnerCucumber extends AbstractTestNGCucumberTests {



    private static TestNGCucumberRunner testNGCucumberRunner;


    @BeforeTest
    public void setup() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

    }


    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {

        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());

    }

    @DataProvider
    public Object[][] scenarios() {

        return testNGCucumberRunner.provideScenarios();
    }


}
