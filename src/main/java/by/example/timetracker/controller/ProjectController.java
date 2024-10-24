package by.example.timetracker.controller;

import by.example.timetracker.dataModule.domain.Project;
import by.example.timetracker.service.ProjectService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@AllArgsConstructor
@Slf4j
public class ProjectController {
    private ProjectService projectService;


    @PostMapping("/{project_id}/getStages")
    public ResponseEntity<?> getStagesByProjectId(@PathVariable("project_id") Long id){
        return ResponseEntity.ok().body(projectService.getStagesByProjectId(id));
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> createProject(@RequestBody Project project) {
        projectService.createProject(project);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Project>> getAllprojects() {
        return ResponseEntity.ok().body(projectService.getAllProjects());
    }

    @GetMapping("/{project_id}")
    public Project getProject(@PathVariable("project_id") Long id) {
        return projectService.getProjectById(id);
    }

    @GetMapping("/{project_id}/drop")
    public ResponseEntity<?> deleteTeam(@PathVariable("project_id") Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> putTeam(Project project) {
        projectService.putTeam(project);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
