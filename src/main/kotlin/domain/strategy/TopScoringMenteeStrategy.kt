package domain.strategy

import domain.module.Mentee
import domain.module.PerformanceSubmission

interface TopScoringMenteeStrategy {
    fun findTopMentee(
        mentees: List<Mentee>,
        performances: List<PerformanceSubmission>
    ): Mentee?
}