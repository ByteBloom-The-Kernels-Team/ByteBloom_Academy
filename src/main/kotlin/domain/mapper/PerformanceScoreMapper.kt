package domain.mapper

import domain.model.PerformanceSubmission
import domain.model.SubmissionType

fun List<PerformanceSubmission>.toScores(): List<Double> =
    this.mapNotNull { it.score.toDoubleOrNull() }

fun List<PerformanceSubmission>.mapScoresByType(): Map<SubmissionType, List<Double>> {
    return this.groupBy { it.type }
        .mapValues { (_, subs) ->
            subs.mapNotNull { it.score.toDoubleOrNull() }
        }
}