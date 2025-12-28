package domain.module

data class Team(
    val id: String,
    val name: String,
    val mentor: String,
    val mentees: MutableList<Mentee>
)