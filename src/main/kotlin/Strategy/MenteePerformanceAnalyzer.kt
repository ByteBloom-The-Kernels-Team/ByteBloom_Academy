package Strategy

import domain.PerformanceSubmission

interface MenteePerformanceAnalyzer {
    fun menteeAnalyze(
        menteeId: String,
        performances: List<PerformanceSubmission>
    ): Map<String, List<Double>>
}