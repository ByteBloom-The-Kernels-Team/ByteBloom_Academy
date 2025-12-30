package domain.models

data class MenteeAttendance(
    val menteeName: String,
    val weekStatuses: List<AttendanceStatus>
)