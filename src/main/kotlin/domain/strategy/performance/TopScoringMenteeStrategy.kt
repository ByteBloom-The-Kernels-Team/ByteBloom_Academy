package domain.strategy.performance

import domain.module.Mentee
import domain.module.PerformanceSubmission

interface TopScoringMenteeStrategy {
    fun findTopMentee(
        mentees: List<Mentee>,
        performances: List<PerformanceSubmission>
    ): Mentee?
}