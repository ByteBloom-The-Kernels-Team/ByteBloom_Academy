package data.repository

import data.datasource.EcosystemDataSource
import domain.model.Project
import domain.repository.ProjectRepository
import data.model.ProjectRaw

class ProjectRepositoryImplementation(
    private val dataSource: EcosystemDataSource
) : ProjectRepository {

    override fun getAllProjects(): List<Project> {
        return dataSource.getProjects().map {it.toDomainModel()}
    }

    override fun getProjectById(projectId: String): Project? {
        return getAllProjects().find { it.id == projectId }
    }

    override fun getProjectByTeamId(teamId: String): Project? {
        return getAllProjects().find { it.id == teamId }
    }
}
private fun ProjectRaw.toDomainModel(): Project {
    return Project(
        id = id,
        title = title,
        teamId = teamId
    )
}