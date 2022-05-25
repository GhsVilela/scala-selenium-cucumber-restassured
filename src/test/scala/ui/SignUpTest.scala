package ui

import io.cucumber.scala.{EN, ScalaDsl}
import org.scalatest.matchers.should.Matchers
import org.scalatest.time.{Seconds, Span}
import org.scalatestplus.selenium.WebBrowser
import ui.pages.SignUpPage

import scala.language.postfixOps
import scala.util.Random

class SignUpTest extends ScalaDsl with EN with Matchers with WebBrowser {

  val signUpPage = new SignUpPage

  implicitlyWait(Span(3, Seconds))

  Given("""that registration page is opened""") { () =>
    go to signUpPage
  }

  And("""username {string} field is filled""") { (username: String) =>
    click on xpath(signUpPage.username)
    enter(username)
  }

  And("""email {string} field is filled""") { (email: String) =>
    click on xpath(signUpPage.email)
    enter(email)
  }

  And("""password field is filled""") { () =>
    click on xpath(signUpPage.password)
    enter(Random.nextLong().toString)
  }

  When("""user clicks on sign up button""") { () =>
    click on xpath(signUpPage.signUpButton)
  }

  Then("""sign up is not completed due to missing required field""") { () =>
    val validateRequiredField = find(XPathQuery(signUpPage.password))
    validateRequiredField.isDefined shouldBe true
    validateRequiredField.get.isDisplayed shouldBe true
    validateRequiredField.get.attribute("required") contains "true"
    validateRequiredField.get.attribute("value") contains ""
    isAlertPresent shouldBe false
  }

  Then("""sign up is completed successfully""") { () =>
    isAlertPresent shouldBe true
    val alert = alertBox.switch(webDriver)
    alert.getText shouldBe "Sign up successfully"
    alert.dismiss()
  }
}
