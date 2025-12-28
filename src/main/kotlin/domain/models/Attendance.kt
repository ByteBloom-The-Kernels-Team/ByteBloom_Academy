package domain.models

data class Attendance(
    val menteeId: String,
    val week1Status: AttendanceStatus,
    val week2Status: AttendanceStatus,
    val week3Status: AttendanceStatus
)