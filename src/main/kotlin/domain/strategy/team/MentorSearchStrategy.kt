package domain.strategy.team

import domain.models.Mentee
import domain.models.Team

interface MentorSearchStrategy {
    fun findMentorForMentee(
        menteeId: String,
        mentees: List<Mentee>,
        teams: List<Team>
    ): String?
}