package io.tripled

import io.kotest.core.spec.style.*
import io.kotest.matchers.*

class HelloWorldTest : BehaviorSpec({

    Given("a helloWorld") {
        val world = HelloWorld()

        When("we say hello") {
            val response = world.sayHello("Guido")

            Then("we get hello back") {
                response shouldBe "Hello Guido"
            }
        }

    }
})
