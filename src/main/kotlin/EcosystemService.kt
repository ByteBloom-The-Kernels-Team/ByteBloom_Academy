import domain.repository.AttendanceRepository
import domain.repository.MenteeRepository
import domain.repository.PerformanceRepository
import domain.repository.ProjectRepository
import domain.repository.TeamRepository

class EcosystemService(
    private val teamRepository: TeamRepository,
    private val menteeRepository: MenteeRepository,
    private val projectRepository: ProjectRepository,
    private val attendanceRepository: AttendanceRepository,
    private val performanceRepository: PerformanceRepository
) {

}