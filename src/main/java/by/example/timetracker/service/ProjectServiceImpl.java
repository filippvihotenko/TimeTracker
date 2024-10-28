package by.example.timetracker.service;

import by.example.timetracker.dataModule.domain.Project;
import by.example.timetracker.dataModule.domain.Stage;
import by.example.timetracker.dataModule.exceptions.ProjectNotFoundException;
import by.example.timetracker.dataModule.repository.ProjectRepository;
import by.example.timetracker.service.interfaces.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;


    @Override
    public List<Project> getAllProjects(){
       return  projectRepository.findAll();
    }
    @Override
    public Set<Stage> getStagesByProjectId(Long id){
        Project project= getProjectById(id);
        return project.getStages();
    }

    @Override
    public Project getProjectById(Long id){
        return projectRepository.findById(id).orElseThrow(ProjectNotFoundException::new);
    }


    @Override
    public void createProject(Project project){
        projectRepository.save(project);
    }


    @Override
    public void deleteProject(Long id) {
        Project project = getProjectById(id);
        projectRepository.delete(project);
    }

    @Override
    public void  putTeam(Project updatedProject) {
        projectRepository.save(updatedProject);
    }
}
