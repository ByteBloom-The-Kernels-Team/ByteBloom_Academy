package domain.strategy.attendance

import domain.model.Mentee

interface AttendanceStrategy {
    fun getAttendance(): List<Mentee>
}