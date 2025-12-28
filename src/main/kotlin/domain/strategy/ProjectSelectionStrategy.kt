package domain.strategy

import domain.module.Project

interface ProjectSelectionStrategy {
    fun findProjectForTeam(
        teamId: String,
        projects: List<Project>
    ): Project?
}