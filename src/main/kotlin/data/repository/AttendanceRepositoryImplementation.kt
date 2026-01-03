package data.repository

import data.datasource.EcosystemDataSource
import domain.model.Attendance
import domain.model.AttendanceStatus
import domain.repository.AttendanceRepository
import data.model.AttendanceRaw

class AttendanceRepositoryImplementation(
    private val dataSource: EcosystemDataSource
) : AttendanceRepository {

    override fun getAllAttendances(): List<Attendance> {
        return dataSource.getAttendance()
            .map {it.toDomainModel()}
    }

    override fun getAttendanceByMenteeId(menteeId: String): Attendance? {
        return dataSource.getAttendance()
            .find { it.menteeId == menteeId }
            ?.toDomainModel()
    }
}
private fun AttendanceRaw.toDomainModel(): Attendance {
    return Attendance(
        menteeId = menteeId,
        weeklyStatus = weeklyStatus
            .map{it.toAttendanceStatus()}
    )
}
private fun String.toAttendanceStatus(): AttendanceStatus {
    return AttendanceStatus.valueOf(uppercase())
}