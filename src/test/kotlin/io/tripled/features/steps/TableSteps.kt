package io.tripled.features.steps

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.kotest.matchers.shouldBe
import io.tripled.poker.*


class TableSteps {

    lateinit var table: Table

    @Given("an empty Table")
    fun an_empty_table() {
        table = Table()
    }

    @When("a person named {string} joins the Table")
    fun a_person_named_joins_the_table(personName: String) {
        table.addPerson(PersonName(personName))
    }


    @Then("the game has not started yet")
    fun the_game_has_not_started_yet() {
        table.isStarted shouldBe false
    }

    @Then("a person named {string} is present at the Table")
    fun a_person_named_is_present_at_the_table(personName: String) {
        table.isSeated(PersonName(personName)) shouldBe true
    }

    @Then("only a person named {string} is present at the Table")
    fun only_a_person_named_is_present_at_the_table(personName: String) {
        table.isSeated(PersonName(personName)) shouldBe true
        table.isSeated(PersonName("someone-else")) shouldBe false
        table.nrOfPlayers() shouldBe 1
    }

    @When("{string} deals the cards")
    fun deals_the_cards(string: String) {
    }

    @Then("the game is started")
    fun the_game_is_started() {
        table.isStarted shouldBe true
    }

}