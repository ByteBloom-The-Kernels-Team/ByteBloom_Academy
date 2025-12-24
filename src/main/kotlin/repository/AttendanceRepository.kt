package repository

import domain.Attendance

interface AttendanceRepository {
    fun getAll(): List<Attendance>
    fun getByMenteeId(menteeId: String): Attendance?
}
