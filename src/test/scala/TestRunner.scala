import io.cucumber.junit.{Cucumber, CucumberOptions}
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions(plugin = Array("pretty",
  "html:target/cucumber/test-report.html",
  "json:target/cucumber/test-report.json",
  "junit:target/cucumber/test-report.xml"), monochrome = true)
class TestRunner {}
