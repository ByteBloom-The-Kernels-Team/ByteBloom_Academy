package data.repository

import data.datasource.EcosystemDataSource
import domain.model.Team
import domain.repository.TeamRepository
import data.model.TeamRaw

class TeamRepositoryImplementation(
    private val dataSource: EcosystemDataSource
) : TeamRepository {

    override fun getAllTeams(): List<Team> {
        return dataSource.getTeams()
            .map{it.toDomainModel()}
    }
    override fun getTeamById(id: String): Team? {
        return dataSource.getTeams()
            .firstOrNull{ it.id == id }
            ?.toDomainModel()
    }

    override fun getTeamByMentor(mentorName: String): List<Team> {
        return dataSource.getTeams()
            .filter { it.mentor.contains(mentorName, ignoreCase = true) }
            .map { it.toDomainModel() }
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