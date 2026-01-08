package domain.mapper

import domain.model.PerformanceSubmission
import domain.model.SubmissionType

class PerformanceScoresByTypeMapper(
    private val scoreMapper: PerformanceScoreMapper
) {
    fun map(
        submissions: List<PerformanceSubmission>
    ): Map<SubmissionType, List<Double>> {
        return submissions
            .groupBy { it.type }
            .mapValues { (_, subs) ->
                subs.mapNotNull { scoreMapper.map(it) }
            }
    }
}