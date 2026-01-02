package data.repository

import data.datasource.EcosystemDataSource
import domain.model.Team
import domain.repository.TeamRepository
import data.model.TeamRaw

class TeamRepositoryImplementation(
    private val dataSource: EcosystemDataSource
) : TeamRepository {

    override fun getAllTeams(): List<Team> {
        return dataSource.getTeams().map{it.toDomainModel()}
    }

    override fun getTeamById(id: String): Team? {
        return getAllTeams().find { it.id == id }
    }

    override fun getTeamByMentor(mentorName: String): List<Team> {
        return getAllTeams().filter { it.mentor.contains(mentorName, ignoreCase = true) }
    }
    override fun getTeamByMenteeId(menteeId: String): List<Team> {
        return getAllTeams().filter { it.menteeIds.contains(menteeId) }
    }
}
private fun TeamRaw.toDomainModel(): Team {
    return Team(
        id = id,
        name = name,
        mentor = mentor,
        menteeIds = emptyList()
    )
}