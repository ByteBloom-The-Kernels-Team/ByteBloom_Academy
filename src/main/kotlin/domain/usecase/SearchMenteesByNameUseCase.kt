package domain.usecase

import domain.model.Mentee
import domain.repository.MenteeRepository

class SearchMenteesByNameUseCase(
    private val menteeRepository: MenteeRepository
) {
    operator fun invoke(query: String): List<Mentee> {
        val mentees = menteeRepository.getAllMentees()
        return findMenteesMatchingName(mentees, query)
    }

    private fun findMenteesMatchingName(
        mentees: List<Mentee>,
        query: String
    ): List<Mentee> =
        mentees
            .asSequence()
            .filter { it.name.contains(query, ignoreCase = true) }
            .toList()
}