package domain.usecase

import domain.model.Mentee
import domain.model.SubmissionType
import domain.repository.MenteeRepository

class GetMenteesBySubmissionTypeUseCase(
    private val menteeRepository: MenteeRepository
) {
    operator fun invoke(type: SubmissionType): List<Mentee> {
        val mentees = menteeRepository.getAllMentees()
        return filterBySubmissionType(mentees, type)
    }

    private fun filterBySubmissionType(
        mentees: List<Mentee>,
        type: SubmissionType
    ): List<Mentee> =
        mentees.filter { mentee ->
            mentee.submissions.any { it.type == type }
        }
}