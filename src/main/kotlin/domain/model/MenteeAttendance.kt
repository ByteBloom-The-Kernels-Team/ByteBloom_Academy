package domain.model

data class MenteeAttendance(
    val menteeName: String,
    val weekStatuses: List<AttendanceStatus>
)