package domain.strategy.performance

import domain.models.PerformanceSubmission
import domain.models.SubmissionType

class AnalyzePerformanceByType: MenteePerformanceAnalyzer {
    override fun menteeAnalyze(
        menteeId: String,
        performances: List<PerformanceSubmission>
    ): Map<SubmissionType, List<Double>> {
        return performances
            .filter { it.id == menteeId }
            .groupBy { it.type }
            .mapValues { entry ->
                entry.value.mapNotNull { it.score.toDoubleOrNull() }
            }
    }
}