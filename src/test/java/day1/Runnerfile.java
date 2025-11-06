package day1;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:\\Neha\\NG_PROJECT\\cucumberproject1\\features", // Path to your feature files
    glue = "day1" // optional: step definitions package
)
public class Runnerfile {
    // This class remains empty; it only serves as a test runner.
}
