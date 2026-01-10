package domain.strategy.performance

import domain.filter.filterByMentee
import domain.mapper.mapScoresByType
import domain.model.PerformanceSubmission
import domain.model.SubmissionType
import domain.repository.PerformanceSubmissionRepository

class AnalyzePerformanceByType(
    private val performanceRepository: PerformanceSubmissionRepository
) : MenteePerformanceAnalyzer {

    override fun menteeAnalyze(
        menteeId: String,
    ): Map<SubmissionType, List<Double>> {
        val allPerformances: List<PerformanceSubmission> = performanceRepository.getAllPerformanceSubmissions()
        val filteredPerformances = allPerformances.filterByMentee(menteeId)
        return filteredPerformances.mapScoresByType()
    }
}