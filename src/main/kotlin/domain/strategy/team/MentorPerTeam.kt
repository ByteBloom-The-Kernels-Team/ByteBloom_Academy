package domain.strategy.team

import domain.models.Mentee
import domain.models.Team

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