package data.repository

import data.datasource.EcosystemDataSource
import domain.module.Mentee
import domain.repository.MenteeRepository

class MenteeRepositoryImplementation(
    private val dataSource: EcosystemDataSource
) : MenteeRepository {

    override fun getAll(): List<Mentee> {
        return dataSource.getMenteesRaw().map { raw ->
            Mentee(
                id = raw.id,
                name = raw.name,
                team = raw.teamId,
                submissions = emptyList()
            )
        }
    }

    override fun getById(id: String): Mentee? {
        return getAll().find { it.id == id }
    }

    override fun getByTeamId(teamId: String): List<Mentee> {
        return getAll().filter { it.team == teamId }
    }

    override fun getByName(name: String): List<Mentee> {
        return getAll().filter { it.name.contains(name, ignoreCase = true) }
    }
}