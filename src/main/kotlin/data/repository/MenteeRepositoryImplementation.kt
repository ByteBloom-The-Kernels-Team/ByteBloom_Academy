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
}