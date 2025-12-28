package data.repository

import data.datasource.EcosystemDataSource
import domain.module.Project
import domain.repository.ProjectRepository

class ProjectRepositoryImplementation(
    private val dataSource: EcosystemDataSource
) : ProjectRepository {

    override fun getAll(): List<Project> {
        return dataSource.getProjectsRaw().map { raw ->
            Project(
                id = raw.id,
                title = raw.title,
                teamId = raw.teamId
            )
        }
    }

    override fun getById(projectId: String): Project? {
        return getAll().find { it.id == projectId }
    }

    override fun getByTeamId(teamId: String): Project? {
        return getAll().find { it.id == teamId }
    }
}