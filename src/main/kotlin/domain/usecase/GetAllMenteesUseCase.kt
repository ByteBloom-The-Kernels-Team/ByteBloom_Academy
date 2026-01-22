package domain.usecase

import domain.repository.MenteeRepository

class GetAllMenteesUseCase(
    private val menteeRepository: MenteeRepository
) {
    fun execute(): List<String> =
        menteeRepository.getAllMentees().map { it.name }
}