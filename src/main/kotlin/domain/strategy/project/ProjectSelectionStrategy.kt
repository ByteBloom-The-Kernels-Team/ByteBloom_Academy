package domain.strategy.project

import domain.model.Project

interface ProjectSelectionStrategy {
    fun findProjectForTeam(teamId: String): Project?
}