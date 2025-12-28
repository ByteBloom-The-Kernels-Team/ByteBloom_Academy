package domain.strategy.performance

import domain.models.PerformanceSubmission
import domain.models.SubmissionType

interface MenteePerformanceAnalyzer {
    fun menteeAnalyze(
        menteeId: String,
        performances: List<PerformanceSubmission>
    ): Map<SubmissionType, List<Double>>
}