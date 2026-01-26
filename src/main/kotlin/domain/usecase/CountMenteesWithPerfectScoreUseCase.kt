package domain.usecase

import domain.model.Mentee
import domain.repository.MenteeRepository

class CountMenteesWithPerfectScoreUseCase(
    private val menteeRepository: MenteeRepository
) {
    operator fun invoke(): Int {
        val mentees = menteeRepository.getAllMentees()
        return countPerfectScores(mentees)
    }

    private fun countPerfectScores(mentees: List<Mentee>): Int =
        mentees.count { mentee ->
            mentee.submissions.any { it.score == PERFECT_SCORE }
        }

    companion object{
        private const val PERFECT_SCORE = 100
    }
}