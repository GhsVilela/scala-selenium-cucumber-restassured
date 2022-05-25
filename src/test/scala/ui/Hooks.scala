package ui

import java.io.File

import io.cucumber.scala.{ScalaDsl, Scenario}
import org.apache.commons.io.FileUtils
import org.openqa.selenium.{OutputType, TakesScreenshot}
import org.slf4j.{Logger, LoggerFactory}

object Hooks extends ScalaDsl {
  private def takeScreenshot(): Option[File] = {
    if (isAlertPresent) {
      alertBox.switch(webDriver).dismiss()
    }
    Option(webDriver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE))
  }
  AfterAll {
    quit()
  }
}

class Hooks extends ScalaDsl {
 private  val logger: Logger = LoggerFactory.getLogger(classOf[Hooks])

  After { scenario : Scenario =>
    if (scenario.isFailed) {
      val screenShot = Hooks.takeScreenshot()
      if (screenShot.isDefined) {
        logger.info(s"Taking error screenshot scenarioName: ${scenario.getName} scenarioId: ${scenario.getId}")
        FileUtils.copyFile(Hooks.takeScreenshot().get, new File(s"target/screenshots/${scenario.getId}.png"))
      } else {
        logger.error(s"Error getting web-driver screenshot scenarioName: ${scenario.getName} scenarioId: ${scenario.getId}")
      }
    }
  }
}
