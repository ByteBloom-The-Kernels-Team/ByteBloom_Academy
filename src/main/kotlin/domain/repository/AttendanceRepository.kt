package domain.repository

import domain.model.Attendance

interface AttendanceRepository {
    fun getAllAttendances(): List<Attendance>
    fun getAttendanceByMenteeId(menteeId: String): Attendance?
}