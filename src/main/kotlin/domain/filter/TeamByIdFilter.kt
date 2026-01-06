package domain.filter

import domain.model.Team

class TeamByIdFilter {
    fun filter(
        teamId: String,
        teams: List<Team>
    ): Team? {
        return teams.firstOrNull { it.id == teamId }
    }
}