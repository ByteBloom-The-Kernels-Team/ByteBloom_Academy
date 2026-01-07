package data.repository

import data.datasource.EcosystemDataSource
import domain.model.Team
import domain.repository.TeamRepository
import data.mapper.toDomainModel

class TeamRepositoryImplementation(
    private val dataSource: EcosystemDataSource
) : TeamRepository {

    override fun getAllTeams(): List<Team> {
        return dataSource.getTeams()
            .map{it.toDomainModel()}
    }
}