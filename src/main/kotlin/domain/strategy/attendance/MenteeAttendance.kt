package domain.strategy.attendance

data class MenteeAttendance(
    val menteeName: String,
    val weekStatuses: List<String>
)