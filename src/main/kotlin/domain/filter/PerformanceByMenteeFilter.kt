package domain.filter

import domain.model.PerformanceSubmission

class PerformanceByMenteeFilter {
    fun filter(
        menteeId: String,
        submissions: List<PerformanceSubmission>
    ): List<PerformanceSubmission> {
        return submissions.filter { it.menteeId == menteeId }
    }
}