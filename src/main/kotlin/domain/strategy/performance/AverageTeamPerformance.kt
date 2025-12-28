package domain.strategy.performance

import domain.module.Mentee
import domain.module.PerformanceSubmission

class AverageTeamPerformance: TeamPerformanceStrategy {
    override fun calculateAverage(
        teamId: String,
        mentees: List<Mentee>,
        performances: List<PerformanceSubmission>
    ): Double {
        val teamMenteesIds = mentees
            .filter { it.team == teamId }
            .map { it.id }

        val teamPerformances = performances
            .filter { it.id in teamMenteesIds }
            .mapNotNull { it.score.toDoubleOrNull() }

        if (teamPerformances.isEmpty()) return 0.0

        return teamPerformances.average()
    }
}