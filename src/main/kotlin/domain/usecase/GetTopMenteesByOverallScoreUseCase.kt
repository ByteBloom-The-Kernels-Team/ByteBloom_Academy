package domain.usecase

import domain.model.Mentee
import domain.repository.MenteeRepository
import domain.filter.filterTopByOverallScore

class GetTopMenteesByOverallScoreUseCase(
    private val menteeRepository: MenteeRepository
) {
    operator fun invoke(limit: Int): List<Mentee> {
        return menteeRepository
            .getAllMentees()
            .filterTopByOverallScore(limit)
    }
}