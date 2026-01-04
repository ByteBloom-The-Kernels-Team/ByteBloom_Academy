package domain.model

data class Attendance(
    val menteeId: String,
    val weeklyStatus: MutableList<AttendanceStatus>
)