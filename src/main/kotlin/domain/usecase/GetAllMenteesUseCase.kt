package domain.usecase

import domain.repository.MenteeRepository

class GetAllMenteesUseCase(
    private val menteeRepository: MenteeRepository
) {
    operator fun invoke(): List<String> =
        menteeRepository.getAllMentees()
            .map { it.name }
}