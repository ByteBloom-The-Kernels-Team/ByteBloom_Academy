package domain.repository

import domain.models.Attendance

interface AttendanceRepository {
    fun getAll(): List<Attendance>
    fun getByMenteeId(menteeId: String): Attendance?
}
