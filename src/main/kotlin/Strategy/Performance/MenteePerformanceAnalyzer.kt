package Strategy.Performance

import domain.PerformanceSubmission
import domain.SubmissionType

interface MenteePerformanceAnalyzer {
    fun menteeAnalyze(
        menteeId: String,
        performances: List<PerformanceSubmission>
    ): Map<SubmissionType, List<Double>>
}