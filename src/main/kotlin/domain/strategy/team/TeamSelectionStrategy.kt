package domain.strategy.team

import domain.model.Project
import domain.model.Team

public interface TeamSelectionStrategy {
    fun selectTeams(
        teams: List<Team>,
        projects: List<Project>
    ): List<Team>
}