package domain.strategy.team

import domain.module.Mentee
import domain.module.Team

interface MentorSearchStrategy {
    fun findMentorForMentee(
        menteeId: String,
        mentees: List<Mentee>,
        teams: List<Team>
    ): String?
}