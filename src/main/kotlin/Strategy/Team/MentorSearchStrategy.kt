package Strategy.Team

import domain.Mentee
import domain.Team

interface MentorSearchStrategy {
    fun findMentorForMentee(
        menteeId: String,
        mentees: List<Mentee>,
        teams: List<Team>
    ): String?
}