package domain.strategy.performance

import domain.models.Mentee
import domain.models.PerformanceSubmission

interface TopScoringMenteeStrategy {
    fun findTopMentee(
        mentees: List<Mentee>,
        performances: List<PerformanceSubmission>
    ): Mentee?
}