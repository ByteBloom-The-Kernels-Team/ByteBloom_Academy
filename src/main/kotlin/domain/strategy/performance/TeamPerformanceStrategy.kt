package domain.strategy.performance

import domain.model.Mentee
import domain.model.PerformanceSubmission

interface TeamPerformanceStrategy {
    fun calculateAverage(
        teamId: String,
        mentees: List<Mentee>,
        performances: List<PerformanceSubmission>
    ): Double
}