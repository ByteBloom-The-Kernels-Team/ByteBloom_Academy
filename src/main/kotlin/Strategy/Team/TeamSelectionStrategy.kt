package Strategy.Team

import domain.Project
import domain.Team

public interface TeamSelectionStrategy {
    fun selectTeams(
        teams: List<Team>,
        projects: List<Project>
    ): List<Team>
}