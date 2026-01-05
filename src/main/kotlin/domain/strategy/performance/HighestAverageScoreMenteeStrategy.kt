package domain.strategy.performance

import domain.model.Mentee
import domain.model.PerformanceSubmission

class HighestAverageScoreMenteeStrategy : TopScoringMenteeStrategy {

    override fun findTopMentee(
        mentees: List<Mentee>,
        performances: List<PerformanceSubmission>
    ): Mentee? {
        return mentees.maxByOrNull { mentee ->
            averageScore(mentee.id, performances)
        }
    }

    private fun averageScore(
        menteeId: String,
        performances: List<PerformanceSubmission>
    ): Double {
        val scores = extractScores(menteeId, performances)
        return if (scores.isEmpty()) 0.0 else scores.average()
    }

    private fun extractScores(
        menteeId: String,
        performances: List<PerformanceSubmission>
    ): List<Double> {
        return performances
            .filter { it.menteeId == menteeId }
            .mapNotNull { it.score.toDoubleOrNull() }
    }
}