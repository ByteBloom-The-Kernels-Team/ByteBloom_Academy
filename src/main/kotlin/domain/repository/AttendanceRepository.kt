package domain.repository
import domain.module.Attendance

interface AttendanceRepository {
    fun getAll(): List<Attendance>
    fun getByMenteeId(menteeId: String): Attendance?
}
