package domain.strategy.performance

import domain.module.Mentee
import domain.module.PerformanceSubmission

interface TeamPerformanceStrategy {
    fun calculateAverage(
        teamId: String,
        mentees: List<Mentee>,
        performances: List<PerformanceSubmission>
    ): Double
}