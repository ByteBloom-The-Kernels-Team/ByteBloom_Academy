package domain.usecase

import domain.model.Mentee
import domain.model.SubmissionType
import domain.repository.MenteeRepository

class GetMenteesBySubmissionTypeUseCase(
    private val menteeRepository: MenteeRepository
) {
    operator fun invoke(type: SubmissionType): List<Mentee> {
        val mentees = menteeRepository.getAllMentees()
        return findMenteesBySubmissionType(mentees, type)
    }

    private fun findMenteesBySubmissionType(
        mentees: List<Mentee>,
        type: SubmissionType
    ): List<Mentee> =
        mentees
            .asSequence()
            .filter { mentee ->
                mentee.submissions.any { it.type == type }
            }
            .toList()
}