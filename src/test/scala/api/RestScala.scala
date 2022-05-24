package api

import io.restassured.RestAssured.given
import io.restassured.module.scala.RestAssuredSupport.AddThenToResponse
import org.scalatest.funsuite.AnyFunSuite

class RestScala extends AnyFunSuite {
  private val url = "https://d26923e2-0412-48b9-8a71-564cdc1947c3.mock.pstmn.io/"
  private val endpoint = "users"

  test("Request to /users should return status as ACTIVE") {
    val response = given()
      .when()
      .get(url+endpoint)
    response.Then().assertThat().statusCode(200)
    val jsonPathEvaluator = response.jsonPath()
    assert(jsonPathEvaluator.get("results[0].status").equals("ACTIVE"))
  }
}
