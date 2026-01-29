package domain.usecase

import domain.model.PerformanceSubmission
import domain.model.SubmissionType
import domain.repository.PerformanceSubmissionRepository

class GetPerformanceBreakdownForMenteeUseCase(
    private val performanceSubmissionRepository: PerformanceSubmissionRepository
) {
    operator fun invoke(menteeId: String): Map<SubmissionType, List<Double>> {
        return performanceSubmissionRepository.getAllPerformanceSubmissions()
            .asSequence()
            .filter { it.menteeId == menteeId }
            .groupBy { it.type }
            .mapValues { (_, submissions) ->
                extractScores(submissions)
            }
    }

    private fun extractScores(submissions: List<PerformanceSubmission>): List<Double> = submissions.mapNotNull { it.score }
}