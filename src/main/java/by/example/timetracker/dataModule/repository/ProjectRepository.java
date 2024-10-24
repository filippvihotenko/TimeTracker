package by.example.timetracker.dataModule.repository;

import by.example.timetracker.dataModule.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {


}
