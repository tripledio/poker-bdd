package io.tripled.features.steps

import io.cucumber.java.en.*
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldHave
import io.tripled.poker.PersonName
import io.tripled.poker.Table


class GameSteps {

    lateinit var table: Table

    @Given("a Table with Players {string} and {string}")
    fun a_table_with_players_and(firstPlayer: String, secondPlayer: String) {
        table = Table()
        table.addPerson(PersonName(firstPlayer))
        table.addPerson(PersonName(secondPlayer))
    }

    @When("{string} folds")
    fun folds(player: String) {
        table.fold(PersonName(player))
    }

    @Then("{string} wins")
    fun wins(player: String) {
        table.winners() shouldContain PersonName(player)
    }
}