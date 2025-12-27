package repository

import domain.Attendance
import domain.AttendanceStatus

interface AttendanceRepository {
    fun getAll(): List<Attendance>
    fun getByMenteeId(menteeId: String): Attendance?
    fun mapStatus(raw: String): AttendanceStatus

}
