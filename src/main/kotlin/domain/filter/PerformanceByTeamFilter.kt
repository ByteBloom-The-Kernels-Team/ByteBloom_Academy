package domain.filter

import domain.model.Mentee
import domain.model.PerformanceSubmission

class PerformanceByTeamFilter {
    fun filter(
        teamId: String,
        mentees: List<Mentee>,
        submissions: List<PerformanceSubmission>
    ): List<PerformanceSubmission> {

        val menteeIds = mentees
            .filter { it.team == teamId }
            .map { it.id }

        return submissions.filter { it.menteeId in menteeIds }
    }
}