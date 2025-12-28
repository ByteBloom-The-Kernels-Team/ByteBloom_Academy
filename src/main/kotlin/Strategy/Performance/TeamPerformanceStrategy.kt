package Strategy.Performance

import domain.Mentee
import domain.PerformanceSubmission

interface TeamPerformanceStrategy {
    fun calculateAverage(
        teamId: String,
        mentees: List<Mentee>,
        performances: List<PerformanceSubmission>
    ): Double
}