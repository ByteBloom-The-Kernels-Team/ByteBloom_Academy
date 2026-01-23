package domain.usecase

import domain.model.Mentee
import domain.model.SubmissionType
import domain.repository.MenteeRepository
import domain.filter.filterBySubmissionType

class GetMenteesBySubmissionTypeUseCase(
    private val menteeRepository: MenteeRepository
) {
    operator fun invoke(type: SubmissionType): List<Mentee> {
        return menteeRepository
            .getAllMentees()
            .filterBySubmissionType(type)
    }
}