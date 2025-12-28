package domain.strategy

import domain.module.Project

class ProjectByTeamId: ProjectSelectionStrategy {
    override fun findProjectForTeam(
        teamId: String,
        projects: List<Project>
    ): Project? {
            return projects.firstOrNull { it.teamId == teamId }
        }
}