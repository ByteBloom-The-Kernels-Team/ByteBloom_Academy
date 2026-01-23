package domain.strategy.team

import domain.model.Team

interface TeamSearchStrategy {
    fun search(teams: List<Team>, teamName: String): Team?
}