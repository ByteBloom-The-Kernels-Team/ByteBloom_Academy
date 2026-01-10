package domain.mapper

import domain.model.Attendance
import domain.model.AttendanceStatus

fun Attendance?.weeklyStatusOrEmpty(): List<AttendanceStatus> =
    this?.weeklyStatus ?: emptyList()

fun List<Attendance>.mapToMenteeIds(): Set<String> =
    this.map { it.menteeId }.toSet()

fun List<Attendance>.mapByMenteeId(): Map<String, Attendance> =
    this.associateBy { it.menteeId }