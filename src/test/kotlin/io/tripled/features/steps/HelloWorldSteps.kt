package io.tripled.features.steps

import io.cucumber.java.en.*
import io.kotest.matchers.*
import io.kotest.matchers.string.*
import io.tripled.*

class HelloWorldSteps {

    private val testContext: TestContext = TestContext()

    @Given("a person named Guido")
    fun a_person_named_guido() {
        testContext.personName = "guido"
    }

    @When("the person says hello")
    fun guido_says_hello() {
        val helloWorld = HelloWorld()
        testContext.response =  helloWorld.sayHello(testContext.personName)

    }

    @Then("the person got an answer")
    fun guido_get_an_answer() {
        testContext.response.shouldContain(testContext.personName)
        testContext.response.shouldBe("Hello " + testContext.personName)
    }

}