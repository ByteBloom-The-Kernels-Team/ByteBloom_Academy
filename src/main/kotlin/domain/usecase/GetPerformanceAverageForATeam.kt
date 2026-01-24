package domain.usecase

import domain.repository.MenteeRepository
import domain.repository.PerformanceSubmissionRepository

class GetPerformanceAverageForATeam(
    private val menteeRepository: MenteeRepository,
    private val performanceRepository: PerformanceSubmissionRepository
) {
    operator fun invoke(teamId: String): Double? {
        val performanceScores = getPerformanceScoresForTeam(teamId)
        return performanceScores.takeIf { it.isNotEmpty() }?.average()
    }

    private fun getMenteeIdsForTeam(teamId: String) =
        menteeRepository.getAllMentees()
            .filter { it.team == teamId }
            .map { it.id }

    private fun getPerformanceScoresForTeam(teamId: String): List<Double> {
        val teamMenteeIds = getMenteeIdsForTeam(teamId)

        return performanceRepository.getAllPerformanceSubmissions()
            .filter { it.menteeId in teamMenteeIds }
            .mapNotNull { it.score.toDoubleOrNull() }
    }
}