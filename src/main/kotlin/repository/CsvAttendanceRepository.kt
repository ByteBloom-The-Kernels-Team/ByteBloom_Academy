package repository
import domain.Attendance
import parseAttendanceData

class CsvAttendanceRepository : AttendanceRepository {

    override fun getAll(): List<Attendance> {
        return parseAttendanceData().map { raw ->
            Attendance(
                menteeId = raw.menteeId,
                week1Status = raw.week1Status,
                week2Status = raw.week2Status,
                week3Status = raw.week3Status
            )
        }
    }
    override fun getByMenteeId(menteeId: String): Attendance? {
        return getAll().find { it.menteeId == menteeId }
    }
}
