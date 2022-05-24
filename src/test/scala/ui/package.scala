import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}

package object ui {
  implicit val webDriver: ChromeDriver = {
    WebDriverManager.chromedriver().setup()
    val options = new ChromeOptions
    options.addArguments("--no-sandbox")
    options.addArguments("--disable-dev-shm-usage")
    options.addArguments("--headless")
    new ChromeDriver(options)
  }

  def sendKeys(element: String, text: String): Unit = {
    webDriver.findElementByXPath(element).sendKeys(text)
  }

  def quit(): Unit = {
    webDriver.quit()
  }
}
