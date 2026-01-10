package data.mapper

import domain.model.AttendanceStatus

fun String.toAttendanceStatus(): AttendanceStatus {
    return AttendanceStatus
        .valueOf(uppercase())
}