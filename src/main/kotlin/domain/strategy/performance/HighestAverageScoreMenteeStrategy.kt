package domain.strategy.performance

import domain.filter.filterByMentee
import domain.mapper.toScores
import domain.model.Mentee
import domain.repository.MenteeRepository
import domain.repository.PerformanceSubmissionRepository

class HighestAverageScoreMenteeStrategy(
    private val menteeRepository: MenteeRepository,
    private val performanceRepository: PerformanceSubmissionRepository
) : TopScoringMenteeStrategy {

    override fun findTopMentee(): Mentee? {
        val allMentees = menteeRepository.getAllMentees()
        return allMentees.maxByOrNull { mentee -> averageScore(mentee.id) }
    }

    private fun averageScore(menteeId: String): Double {
        val scores = extractScores(menteeId)
        return if (scores.isEmpty()) 0.0 else scores.average()
    }

    private fun extractScores(menteeId: String): List<Double> {
        val allPerformances = performanceRepository.getAllPerformanceSubmissions()
        return allPerformances
            .filterByMentee(menteeId)
            .toScores()
    }
}