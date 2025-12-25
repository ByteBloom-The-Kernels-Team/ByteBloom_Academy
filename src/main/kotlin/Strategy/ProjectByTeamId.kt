package Strategy

import domain.Project

class ProjectByTeamId: ProjectSelectionStrategy {
    override fun findProjectForTeam(
        teamId: String,
        projects: List<Project>
    ): Project? {
            return projects.firstOrNull { it.teamId == teamId }
        }
}