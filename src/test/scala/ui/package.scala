import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.scalatestplus.selenium.WebBrowser

package object ui extends WebBrowser {
  implicit val webDriver: ChromeDriver = {
    WebDriverManager.chromedriver().setup()
    val options = new ChromeOptions
    options.addArguments("--no-sandbox")
    options.addArguments("--disable-dev-shm-usage")
    options.addArguments("--headless")
    new ChromeDriver(options)
  }

  def isAlertPresent: Boolean = {
    try {
      alertBox.switch(webDriver)
      true
    } catch {
      case _: Throwable => false
    }
  }

  def quit(): Unit = {
    webDriver.quit()
  }
}
