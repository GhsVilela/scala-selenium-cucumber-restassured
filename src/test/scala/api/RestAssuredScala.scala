package api

import io.restassured.RestAssured.given
import io.restassured.module.scala.RestAssuredSupport.AddThenToResponse
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class RestAssuredScala extends AnyFunSpec with Matchers {
  private val url = "https://d26923e2-0412-48b9-8a71-564cdc1947c3.mock.pstmn.io/"
  private val endpoint = "users"

  describe("User endpoint") {
      it("response should have status as ACTIVE") {
        val response = given().when().get(url+endpoint)
        response.Then().assertThat().statusCode(200)
        response.jsonPath().get("results[0].status").toString shouldBe  "ACTIVE"
      }
  }
}
