package domain.strategy.team

import domain.filter.filterById
import domain.model.Mentee
import domain.model.Team
import domain.repository.MenteeRepository
import domain.repository.TeamRepository

class MentorPerTeam(
    private val menteeRepository: MenteeRepository,
    private val teamRepository: TeamRepository
) : MentorSearchStrategy {

    override fun findMentorForMentee(menteeId: String): String? {
        val mentee = findMenteeById(menteeId) ?: return null
        val team = findTeamForMentee(mentee) ?: return null
        return team.mentor
    }

    private fun findMenteeById(menteeId: String): Mentee? {
        val allMentees = menteeRepository.getAllMentees()
        return allMentees.filterById(menteeId)
    }

    private fun findTeamForMentee(mentee: Mentee): Team? {
        val teamId = mentee.team ?: return null
        val allTeams = teamRepository.getAllTeams()
        return allTeams.filterById(teamId)
    }
}