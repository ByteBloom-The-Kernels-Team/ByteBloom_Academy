package domain.strategy.performance

import domain.model.PerformanceSubmission
import domain.model.SubmissionType

class AnalyzePerformanceByType : MenteePerformanceAnalyzer {

    override fun menteeAnalyze(
        menteeId: String,
        performances: List<PerformanceSubmission>
    ): Map<SubmissionType, List<Double>> {
        val filtered = filterByMentee(menteeId, performances)
        return groupScoresByType(filtered)
    }

    private fun filterByMentee(
        menteeId: String,
        performances: List<PerformanceSubmission>
    ) = performances.filter { it.menteeId == menteeId }

    private fun groupScoresByType(
        performances: List<PerformanceSubmission>
    ) = performances
        .groupBy { it.type }
        .mapValues { (_, subs) -> subs
            .mapNotNull { it.score.toDoubleOrNull() } }
}