package domain.strategy;

import domain.module.Project
import domain.module.Team

public interface TeamSelectionStrategy {
    fun selectTeams(
        teams: List<Team>,
        projects: List<Project>
    ): List<Team>
}
