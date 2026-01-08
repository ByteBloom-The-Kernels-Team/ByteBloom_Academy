package domain.mapper

import domain.model.PerformanceSubmission

class PerformanceScoreMapper {
    fun map(submission: PerformanceSubmission): Double? {
        return submission.score.toDoubleOrNull()
    }
}