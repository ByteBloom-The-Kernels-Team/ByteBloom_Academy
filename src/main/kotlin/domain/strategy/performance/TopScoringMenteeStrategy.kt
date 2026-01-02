package domain.strategy.performance

import domain.model.Mentee
import domain.model.PerformanceSubmission

interface TopScoringMenteeStrategy {
    fun findTopMentee(
        mentees: List<Mentee>,
        performances: List<PerformanceSubmission>
    ): Mentee?
}