package data.repository

import data.datasource.EcosystemDataSource
import domain.model.Mentee
import domain.repository.MenteeRepository
import data.model.MenteeRaw

class MenteeRepositoryImplementation(
    private val dataSource: EcosystemDataSource
) : MenteeRepository {

    override fun getAllMentees(): List<Mentee> {
        return dataSource.getMentees().map {it.toDomainModel()}
    }

    override fun getMenteeById(id: String): Mentee? {
        return getAllMentees().find{ it.id == id }
    }

    override fun getMenteeByTeamId(teamId: String): List<Mentee> {
        return getAllMentees().filter { it.team == teamId }
    }

    override fun getMenteeByName(name: String): List<Mentee> {
        return getAllMentees().filter { it.name.contains(name, ignoreCase = true) }
    }
}
private fun MenteeRaw.toDomainModel(): Mentee {
    return Mentee(
        id = id,
        name = name,
        team = teamId,
        submissions = emptyList()
    )
}