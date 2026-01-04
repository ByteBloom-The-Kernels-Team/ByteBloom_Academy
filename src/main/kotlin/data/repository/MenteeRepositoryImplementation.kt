package data.repository

import data.datasource.EcosystemDataSource
import domain.model.Mentee
import domain.repository.MenteeRepository
import data.mapper.toDomainModel

class MenteeRepositoryImplementation(
    private val dataSource: EcosystemDataSource
) : MenteeRepository {

    override fun getAllMentees(): List<Mentee> {
        return dataSource.getMentees()
            .map {it.toDomainModel()}
    }

    override fun getMenteeById(id: String): Mentee? {
        return dataSource.getMentees()
            .find{ it.id == id }
            ?.toDomainModel()
    }

    override fun getMenteesByTeamId(teamId: String): List<Mentee> {
        return dataSource.getMentees()
            .filter { it.teamId == teamId }
            .map { it.toDomainModel() }
    }

    override fun getMenteeByName(name: String): List<Mentee> {
        return dataSource.getMentees()
            .filter { it.name.contains(name, ignoreCase = true) }
            .map { it.toDomainModel() }
    }
}