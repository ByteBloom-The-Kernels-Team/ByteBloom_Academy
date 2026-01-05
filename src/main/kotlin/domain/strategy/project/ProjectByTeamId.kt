package domain.strategy.project

import domain.model.Project

class ProjectByTeamId : ProjectSelectionStrategy {

    override fun findProjectForTeam(
        teamId: String,
        projects: List<Project>
    ): Project? {
        val filteredProjects = filterProjectsByTeamId(projects, teamId)
        return selectFirstProject(filteredProjects)
    }

    private fun filterProjectsByTeamId(
        projects: List<Project>,
        teamId: String
    ): List<Project> {
        return projects.filter { it.teamId == teamId }
    }

    private fun selectFirstProject(
        projects: List<Project>
    ): Project? {
        return projects.firstOrNull()
    }
}