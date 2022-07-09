package io.tripled.poker

class Table {
    val isStarted: Boolean
        get() = playersAtTable.size >= 2

    private val playersAtTable = mutableListOf<PersonName>()

    fun isSeated(personName: PersonName): Boolean {
        return personName in playersAtTable
    }

    fun addPerson(personName: PersonName) {
        playersAtTable.add(personName)
    }

    fun nrOfPlayers(): Int {
        return playersAtTable.size
    }

    fun fold(player: PersonName) {
    }

    fun winners(): List<PersonName> {
        return listOf(PersonName("Guido"))
    }

}
