package domain.usecase

import domain.model.Mentee
import domain.repository.MenteeRepository

class SearchMenteesByNameUseCase(
    private val menteeRepository: MenteeRepository
) {
    operator fun invoke(query: String): List<Mentee> {
        val mentees = menteeRepository.getAllMentees()
        return filterByName(mentees, query)
    }

    private fun filterByName(
        mentees: List<Mentee>,
        query: String
    ): List<Mentee> =
        mentees.filter { it.name.contains(query, ignoreCase = true) }
}