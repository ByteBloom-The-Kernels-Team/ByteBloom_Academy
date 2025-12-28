package repository

import datasource.EcosystemDataSource
import domain.Attendance
import domain.AttendanceStatus


class AttendanceRepositoryImplementation(
    private val dataSource: EcosystemDataSource
) : AttendanceRepository {

    override fun getAll(): List<Attendance> {
        return dataSource.getAttendanceRaw().map { raw ->
            Attendance(
                menteeId = raw.menteeId,
                week1Status = mapStatus(raw.week1Status),
                week2Status = mapStatus(raw.week2Status),
                week3Status = mapStatus(raw.week3Status)
            )
        }
    }

    override fun getByMenteeId(menteeId: String): Attendance? {
        return getAll().find { it.menteeId == menteeId }
    }

    private fun mapStatus(raw: String): AttendanceStatus {
        return AttendanceStatus.valueOf(raw.uppercase())
    }
}
