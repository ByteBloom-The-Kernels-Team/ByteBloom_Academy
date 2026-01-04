package domain.strategy.team

import domain.model.Mentee
import domain.model.Team

class MentorPerTeam : MentorSearchStrategy {
    override fun findMentorForMentee(
        menteeId: String,
        mentees: List<Mentee>,
        teams: List<Team>
    ): String? {
        val mentee = mentees.firstOrNull { it.id == menteeId }
            ?: return null

        val teamId = mentee.team ?: return null

        val team = teams.firstOrNull { it.id == teamId }
            ?: return null

        return team.mentor
    }
}