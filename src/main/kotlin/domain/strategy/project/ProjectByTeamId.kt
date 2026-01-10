package domain.strategy.project

import domain.filter.filterByTeamId
import domain.model.Project
import domain.repository.ProjectRepository

class ProjectByTeamId(
    private val projectRepository: ProjectRepository
) : ProjectSelectionStrategy {

    override fun findProjectForTeam(teamId: String): Project? {
        val allProjects = projectRepository.getAllProjects()
        return allProjects.filterByTeamId(teamId).firstOrNull()
    }
}