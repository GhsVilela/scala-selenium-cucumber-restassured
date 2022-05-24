package ui.pages

import org.openqa.selenium.chrome.ChromeDriver
import org.scalatestplus.selenium.Page

class HomePage(implicit driver: ChromeDriver) extends Page {
  val url = "http://localhost:8080/"

  val username: String = "//input[@id=\"uname\"]"
  val email: String = "//input[@id=\"mail\"]"
  val password: String = "//input[@id=\"psw\"]"
  val signUpButton: String = "//button[@type=\"submit\"]"
}
