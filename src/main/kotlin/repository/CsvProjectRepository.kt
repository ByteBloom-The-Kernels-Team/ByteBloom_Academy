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
}