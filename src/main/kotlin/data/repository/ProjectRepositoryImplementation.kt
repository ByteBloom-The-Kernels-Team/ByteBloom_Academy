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

    override fun getProjectById(projectId: String): Project? {
        return dataSource.getProjects()
            .find { it.id == projectId }
            ?.toDomainModel()
    }

    override fun getProjectByTeamId(teamId: String): Project? {
        return dataSource.getProjects()
            .find { it.teamId == teamId }
            ?.toDomainModel()
    }
}