package domain.strategy.team

import domain.model.Mentee
import domain.model.Team

interface MentorSearchStrategy {
    fun findMentorForMentee(menteeId: String): String?
}