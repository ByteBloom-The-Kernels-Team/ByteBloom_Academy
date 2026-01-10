package domain.filter

import domain.model.Attendance
import domain.model.AttendanceStatus

fun List<Attendance>.withPerfectAttendance(): List<Attendance> =
    this.filter { attendance ->
        attendance.weeklyStatus.all { it == AttendanceStatus.PRESENT }
    }

fun List<Attendance>.withPoorAttendance(): List<Attendance> =
    this.filter { attendance ->
        attendance.weeklyStatus.any { it != AttendanceStatus.PRESENT }
    }
