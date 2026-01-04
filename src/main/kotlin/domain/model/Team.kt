package domain.model

data class Team(
    val id: String,
    val name: String,
    val mentor: String,
    val menteeIds: MutableList<String>
)