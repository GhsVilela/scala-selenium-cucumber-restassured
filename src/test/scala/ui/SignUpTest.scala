package ui

import io.cucumber.scala.{EN, ScalaDsl}
import org.scalatest.matchers.should.Matchers
import org.scalatest.time.{Seconds, Span}
import org.scalatestplus.selenium.WebBrowser
import ui.pages.HomePage

import scala.language.postfixOps

class SignUpTest extends ScalaDsl with EN with Matchers with WebBrowser {

  val homePage = new HomePage

  implicitlyWait(Span(3, Seconds))

  Given("""that registration page is opened""") { () =>
    go to homePage
  }

  And("""a username {string} field is filled""") { (username: String) =>
    click on xpath(homePage.username)
    enter(username)
  }

  And("""a email {string} field is filled""") { (email: String) =>
    click on xpath(homePage.email)
    enter(email)
  }

  When("""click on sign up button""") { () =>
    click on xpath(homePage.signUpButton)
  }

  Then("""a required field message is displayed""") { () =>
    //TODO
  }
}
