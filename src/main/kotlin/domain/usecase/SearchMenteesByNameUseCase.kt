package domain.usecase

import domain.model.Mentee
import domain.repository.MenteeRepository
import domain.filter.filterByName

class SearchMenteesByNameUseCase(
    private val menteeRepository: MenteeRepository
) {
    operator fun invoke(query: String): List<Mentee> {
        return menteeRepository
            .getAllMentees()
            .filterByName(query)
    }
}