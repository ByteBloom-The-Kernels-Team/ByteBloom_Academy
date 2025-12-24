package repository

import domain.Project
import parseProjectData

class CsvProjectRepository : ProjectRepository {

    override fun getAll(): List<Project> {
        return parseProjectData().map { raw ->
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