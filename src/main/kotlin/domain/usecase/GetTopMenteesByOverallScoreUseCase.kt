package domain.usecase

import domain.model.Mentee
import domain.repository.MenteeRepository

class GetTopMenteesByOverallScoreUseCase(
    private val menteeRepository: MenteeRepository
) {
    operator fun invoke(limit: Int): List<Mentee> {
        val mentees = menteeRepository.getAllMentees()
        return getTopByScore(mentees, limit)
    }

    private fun getTopByScore(
        mentees: List<Mentee>,
        limit: Int
    ): List<Mentee> =
        mentees
            .sortedByDescending { mentee ->
                mentee.submissions.sumOf { it.score.toIntOrNull() ?: 0 }
            }
            .take(limit)
}