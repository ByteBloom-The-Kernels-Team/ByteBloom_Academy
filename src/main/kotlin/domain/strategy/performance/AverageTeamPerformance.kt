package domain.strategy.performance

import domain.filter.filterByMentees
import domain.filter.filterByTeam
import domain.mapper.toScores
import domain.model.Mentee
import domain.repository.MenteeRepository
import domain.repository.PerformanceSubmissionRepository

class AverageTeamPerformance(
    private val menteeRepository: MenteeRepository,
    private val performanceRepository: PerformanceSubmissionRepository
) : TeamPerformanceStrategy {

    override fun calculateAverage(teamId: String): Double {
        val teamMentees = getTeamMentees(teamId)
        val teamScores = getTeamScores(teamMentees)
        return calculateScoresAverage(teamScores)
    }

    private fun getTeamMentees(teamId: String): List<Mentee> {
        val allMentees = menteeRepository.getAllMentees()
        return allMentees.filterByTeam(teamId)
    }

    private fun getTeamScores(teamMentees: List<Mentee>): List<Double> {
        val allPerformances = performanceRepository.getAllPerformanceSubmissions()
        val teamMenteeIds = teamMentees.map { it.id }
        return allPerformances.filterByMentees(teamMenteeIds).toScores()
    }

    private fun calculateScoresAverage(scores: List<Double>): Double {
        return if (scores.isEmpty()) 0.0 else scores.average()
    }
}