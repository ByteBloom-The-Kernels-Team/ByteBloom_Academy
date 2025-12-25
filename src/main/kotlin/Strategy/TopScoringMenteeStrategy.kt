package Strategy

import domain.Mentee
import domain.PerformanceSubmission

interface TopScoringMenteeStrategy {
    fun findTopMentee(
        mentees: List<Mentee>,
        performances: List<PerformanceSubmission>
    ): Mentee?
}