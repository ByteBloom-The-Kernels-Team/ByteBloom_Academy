package repository
import domain.Mentee

interface MenteeRepository {
    fun getAll(): List<Mentee>
}

