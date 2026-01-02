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
        return dataSource.getAttendance().map {it.toDomainModel()}
    }

    override fun getAttendanceByMenteeId(menteeId: String): Attendance? {
        return getAllAttendances().find { it.menteeId == menteeId }
    }
}
private fun AttendanceRaw.toDomainModel(): Attendance {
    val weeklyStatusesList = listOf(
        this.week1Status,
        this.week2Status,
        this.week3Status
    ).map { it.toAttendanceStatus() }
    return Attendance(
        menteeId = menteeId,
        weeklyStatus = weeklyStatusesList
    )
}
private fun String.toAttendanceStatus(): AttendanceStatus {
    return AttendanceStatus.valueOf(uppercase())
}