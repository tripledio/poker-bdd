package io.tripled.features.steps

import io.cucumber.java.PendingException
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.kotest.matchers.shouldBe


class TableSteps {

    lateinit var table: Table

    @Given("an empty Table")
    fun an_empty_table() {
        table = Table()
    }

    @When("a person named {string} joins the Table")
    fun a_person_named_joins_the_table(personName: String) {
        table.addPerson(personName)
    }


    @Then("the game has not started yet")
    fun the_game_has_not_started_yet() {
        // Write code here that turns the phrase above into concrete actions
        throw PendingException()
    }

    @Then("a person named {string} is present at the Table")
    fun a_person_named_is_present_at_the_table(personName: String) {
        table.isSeated(personName) shouldBe true
    }

    @When("{string} deals the cards")
    fun deals_the_cards(string: String) {
    }

    @Then("the game is started")
    fun the_game_is_started() {
        table.isStarted shouldBe true
    }

}