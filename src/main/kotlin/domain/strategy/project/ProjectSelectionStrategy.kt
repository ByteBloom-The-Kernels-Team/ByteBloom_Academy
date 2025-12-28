package domain.strategy.project

import domain.models.Project

interface ProjectSelectionStrategy {
    fun findProjectForTeam(
        teamId: String,
        projects: List<Project>
    ): Project?
}