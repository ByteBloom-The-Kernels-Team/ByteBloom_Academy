package domain.usecase

import domain.model.PerformanceSubmission
import domain.model.SubmissionType
import domain.repository.PerformanceSubmissionRepository

class GetPerformanceBreakdownForMenteeUseCase(
    private val performanceSubmissionRepository: PerformanceSubmissionRepository
) {
    operator fun invoke(menteeId: String): Map<SubmissionType, List<Double>> {
        val allPerformances = performanceSubmissionRepository.getAllPerformanceSubmissions()
        val filteredPerformances = filterByMentee(allPerformances, menteeId)

        return mapScoresByType(filteredPerformances)
    }

    private fun mapScoresByType(
        submissions: List<PerformanceSubmission>
    ): Map<SubmissionType, List<Double>> {
        return submissions.groupBy { it.type }
            .mapValues { entry ->
                entry.value.mapNotNull { it.score.toDoubleOrNull() }
            }
    }

    private fun filterByMentee(
        submissions: List<PerformanceSubmission>,
        menteeId: String
    ): List<PerformanceSubmission> =
         submissions.filter { it.menteeId == menteeId }

}