package by.example.timetracker.dataModule.repository;

import by.example.timetracker.dataModule.domain.Task;
import by.example.timetracker.dataModule.domain.TimeEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long> {

    Optional<TimeEntry> findFirstByTaskAndEndTimeIsNull(Task task);

}
