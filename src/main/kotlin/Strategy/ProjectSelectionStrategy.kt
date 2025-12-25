package Strategy

import domain.Project

interface ProjectSelectionStrategy {
    fun findProjectForTeam(
        teamId: String,
        projects: List<Project>
    ): Project?
}