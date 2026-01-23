package domain.strategy.team

import domain.model.Team
class SearchTeamByNameStrategy : TeamSearchStrategy{
    override fun search(teams: List<Team>, teamName: String): Team? {
        return teams.find {
            it.name.equals(teamName, ignoreCase = true) }
    }
}