package data.repository

import data.datasource.EcosystemDataSource
import domain.model.Attendance
import domain.repository.AttendanceRepository
import data.mapper.toDomainModel

class AttendanceRepositoryImplementation(
    private val dataSource: EcosystemDataSource
) : AttendanceRepository {

    override fun getAllAttendances(): List<Attendance> {
        return dataSource.getAttendance()
            .map {it.toDomainModel()}
    }
}