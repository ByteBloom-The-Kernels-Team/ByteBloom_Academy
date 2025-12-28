package domain.strategy.performance

import domain.models.Mentee
import domain.models.PerformanceSubmission

interface TeamPerformanceStrategy {
    fun calculateAverage(
        teamId: String,
        mentees: List<Mentee>,
        performances: List<PerformanceSubmission>
    ): Double
}