package repository

import domain.Attendance
import datasource.EcosystemDataSource

class AttendanceRepositoryImplementation(
    private val dataSource: EcosystemDataSource
) : AttendanceRepository {

    override fun getAll(): List<Attendance> {
        return dataSource.getAttendanceRaw().map { raw ->
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
