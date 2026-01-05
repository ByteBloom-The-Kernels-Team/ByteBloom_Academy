package domain.model

import domain.model.AttendanceStatus

data class MenteeAttendance(
    val menteeName: String,
    val weekStatuses: List<AttendanceStatus>
)