package data.mapper

import data.model.AttendanceRaw
import domain.model.Attendance

fun AttendanceRaw.toDomainModel(): Attendance {
    return Attendance(
        menteeId = menteeId,
        weeklyStatus = weeklyStatus
            .map{it.toAttendanceStatus()}
            .toMutableList()
    )
}