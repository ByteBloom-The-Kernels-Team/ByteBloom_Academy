package domain.strategy.performance

import domain.module.PerformanceSubmission
import domain.module.SubmissionType

interface MenteePerformanceAnalyzer {
    fun menteeAnalyze(
        menteeId: String,
        performances: List<PerformanceSubmission>
    ): Map<SubmissionType, List<Double>>
}