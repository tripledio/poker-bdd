package io.tripled.poker

class Table {
    val isStarted: Boolean
        get() = playersAtTable.size >= 2

    private val playersAtTable = mutableListOf<PersonName>()

    fun isSeated(personName: String): Boolean {
        return PersonName(personName) in playersAtTable
    }

    fun addPerson(personName: String) {
        playersAtTable.add(PersonName(personName))
    }

    fun nrOfPlayers(): Int {
        return playersAtTable.size
    }

}
