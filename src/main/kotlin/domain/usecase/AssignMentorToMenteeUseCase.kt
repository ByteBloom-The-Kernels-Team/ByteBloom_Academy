package domain.usecase

import domain.strategy.team.MentorSearchStrategy

class AssignMentorToMenteeUseCase(
    private val mentorSearchStrategy: MentorSearchStrategy
) {
    fun execute(menteeId: String): String? =
        mentorSearchStrategy.findMentorForMentee(menteeId)
}