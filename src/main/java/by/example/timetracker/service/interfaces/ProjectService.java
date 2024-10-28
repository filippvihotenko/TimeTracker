package by.example.timetracker.service.interfaces;

import by.example.timetracker.dataModule.domain.Project;
import by.example.timetracker.dataModule.domain.Stage;

import java.util.List;
import java.util.Set;

public interface ProjectService {
    List<Project> getAllProjects();

    Set<Stage> getStagesByProjectId(Long id);

    Project getProjectById(Long id);

    void createProject(Project project);

    void deleteProject(Long id);

    void putTeam(Project updatedProject);
}
