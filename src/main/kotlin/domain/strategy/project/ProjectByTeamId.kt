package domain.strategy.project

import domain.model.Project

class ProjectByTeamId : ProjectSelectionStrategy {
    override fun findProjectForTeam(
        teamId: String,
        projects: List<Project>
    ): Project? {
        return projects.firstOrNull { it.teamId == teamId }
    }
}