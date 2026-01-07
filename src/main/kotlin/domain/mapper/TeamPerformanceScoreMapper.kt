package domain.mapper

import domain.model.PerformanceSubmission

class TeamPerformanceScoreMapper(
    private val scoreMapper: PerformanceScoreMapper
) {
    fun map(
        menteeIds: List<String>,
        performances: List<PerformanceSubmission>
    ): List<Double> {
        return performances
            .filter { it.menteeId in menteeIds }
            .mapNotNull { scoreMapper.map(it) }
    }
}