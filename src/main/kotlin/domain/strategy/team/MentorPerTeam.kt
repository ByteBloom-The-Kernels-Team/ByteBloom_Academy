package domain.strategy.team

import domain.model.Mentee
import domain.model.Team

class MentorPerTeam : MentorSearchStrategy {

    override fun findMentorForMentee(
        menteeId: String,
        mentees: List<Mentee>,
        teams: List<Team>
    ): String? {
        val mentee = findMenteeById(menteeId, mentees) ?: return null
        val team = findTeamForMentee(mentee, teams) ?: return null
        return team.mentor
    }

    private fun findMenteeById(
        menteeId: String,
        mentees: List<Mentee>
    ): Mentee? {
        return mentees.firstOrNull { it.id == menteeId }
    }

    private fun findTeamForMentee(
        mentee: Mentee,
        teams: List<Team>
    ): Team? {
        val teamId = mentee.team ?: return null
        return teams.firstOrNull { it.id == teamId }
    }
}