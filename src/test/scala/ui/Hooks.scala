package ui

import java.io.File

import io.cucumber.scala.{EN, ScalaDsl, Scenario}
import org.apache.commons.io.FileUtils
import org.openqa.selenium.{OutputType, TakesScreenshot}
import org.slf4j.{Logger, LoggerFactory}

object Hooks extends ScalaDsl with EN {
  def takeScreenshot(): Option[File] = {
    Option(webDriver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE))
  }
  AfterAll {
    quit()
  }
}

class Hooks extends ScalaDsl with EN {
  val logger: Logger = LoggerFactory.getLogger(classOf[Hooks])

  After { scenario : Scenario =>
    if (scenario.isFailed) {
      val screenShot = Hooks.takeScreenshot()
      if (screenShot.isDefined) {
        logger.info(s"Taking error screenshot scenarioName: ${scenario.getName} scenarioId: ${scenario.getId}")
        FileUtils.copyFile(Hooks.takeScreenshot().get, new File(s"target/screenshots/${scenario.getId}.jpg"))
      } else {
        logger.error(s"Error getting web-driver screenshot scenarioName: ${scenario.getName} scenarioId: ${scenario.getId}")
      }
    }
  }
}
