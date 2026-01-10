package domain.strategy.performance

import domain.model.PerformanceSubmission
import domain.model.SubmissionType

interface MenteePerformanceAnalyzer {
    fun menteeAnalyze(
        menteeId: String,
    ): Map<SubmissionType, List<Double>>
}