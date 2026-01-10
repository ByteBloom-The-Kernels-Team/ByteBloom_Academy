package data.repository

import data.datasource.EcosystemDataSource
import domain.model.Project
import domain.repository.ProjectRepository
import data.mapper.toDomainModel

class ProjectRepositoryImplementation(
    private val dataSource: EcosystemDataSource
) : ProjectRepository {

    override fun getAllProjects(): List<Project> {
        return dataSource.getProjects()
            .map {it.toDomainModel()}
    }
}