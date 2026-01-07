package domain.mapper

import domain.model.Mentee
import domain.model.Team

class MenteeTeamMapper {
    fun map(
        mentee: Mentee,
        teams: List<Team>
    ): Team? {
        return teams.firstOrNull { it.id == mentee.team }
    }
}