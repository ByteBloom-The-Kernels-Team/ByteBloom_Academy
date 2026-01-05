package domain.strategy.performance

import domain.model.Mentee
import domain.model.PerformanceSubmission

class AverageTeamPerformance : TeamPerformanceStrategy {

    override fun calculateAverage(
        teamId: String,
        mentees: List<Mentee>,
        performances: List<PerformanceSubmission>
    ): Double {
        val menteeIds = getTeamMenteeIds(teamId, mentees)
        val scores = getScoresForMentees(menteeIds, performances)
        return average(scores)
    }

    private fun getTeamMenteeIds(teamId: String, mentees: List<Mentee>) =
        mentees.filter { it.team == teamId }.map { it.id }

    private fun getScoresForMentees(
        menteeIds: List<String>,
        performances: List<PerformanceSubmission>
    ) = performances
        .filter { it.menteeId in menteeIds }
        .mapNotNull { it.score.toDoubleOrNull() }

    private fun average(scores: List<Double>) =
        if (scores.isEmpty()) 0.0 else scores.average()
}