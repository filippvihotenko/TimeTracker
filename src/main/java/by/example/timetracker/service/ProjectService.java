package by.example.timetracker.service;

import by.example.timetracker.dataModule.domain.Project;
import by.example.timetracker.dataModule.domain.Stage;
import by.example.timetracker.dataModule.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@AllArgsConstructor
public class ProjectService {
    private ProjectRepository projectRepository;


    public List<Project> getAllProjects(){
       return  projectRepository.findAll();
    }
    public Set<Stage> getStagesByProjectId(Long id){
        Project project= getProjectById(id);
        return project.getStages();
    }

    public Project getProjectById(Long id){
        return projectRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }


    public void createProject(Project project){
        projectRepository.save(project);
    }


    public void deleteProject(Long id) {
        Project project = getProjectById(id);
        projectRepository.delete(project);
    }

    public void  putTeam(Project updatedProject) {
        projectRepository.save(updatedProject);
    }
}
