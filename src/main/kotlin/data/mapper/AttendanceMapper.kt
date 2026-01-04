package data.mapper

import data.model.AttendanceRaw
import domain.model.Attendance
import domain.model.AttendanceStatus

fun AttendanceRaw.toDomainModel(): Attendance {
    return Attendance(
        menteeId = menteeId,
        weeklyStatus = weeklyStatus
            .map{it.toAttendanceStatus()}
    )
}
fun String.toAttendanceStatus(): AttendanceStatus {
    return AttendanceStatus.valueOf(uppercase())
}