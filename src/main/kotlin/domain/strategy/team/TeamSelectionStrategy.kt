package domain.strategy.team

import domain.models.Project
import domain.models.Team

public interface TeamSelectionStrategy {
    fun selectTeams(
        teams: List<Team>,
        projects: List<Project>
    ): List<Team>
}