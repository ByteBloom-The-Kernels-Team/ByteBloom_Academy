package domain.filter

import domain.model.Project

class ProjectByTeamFilter {
    fun filter(
        teamId: String,
        projects: List<Project>
    ): List<Project> {
        return projects.filter { it.teamId == teamId }
    }
}