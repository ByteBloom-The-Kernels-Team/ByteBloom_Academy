package domain.strategy.project

import domain.module.Project

interface ProjectSelectionStrategy {
    fun findProjectForTeam(
        teamId: String,
        projects: List<Project>
    ): Project?
}