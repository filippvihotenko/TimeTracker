package by.example.timetracker.dataModule.repository;

import by.example.timetracker.dataModule.domain.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageRepository  extends JpaRepository<Stage, Long> {
}
