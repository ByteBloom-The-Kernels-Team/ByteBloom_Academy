package domain.filter

import domain.model.Mentee

class TeamMenteeFilter {
    fun filterByTeam(
        teamId: String,
        mentees: List<Mentee>
    ): List<Mentee> {
        return mentees.filter { it.team == teamId }
    }
}