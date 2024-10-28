package by.example.timetracker.controller;

import by.example.timetracker.dataModule.domain.Project;
import by.example.timetracker.service.interfaces.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@AllArgsConstructor
@Slf4j
@PreAuthorize("hasRole('ADMIN')")
public class ProjectController {
    private ProjectService projectService;

    @PostMapping("/{project_id}/getStages")
    @Operation(summary = "Получить стадии по id проекта")
    public ResponseEntity<?> getStagesByProjectId(@PathVariable("project_id") Long id){
        return ResponseEntity.ok().body(projectService.getStagesByProjectId(id));
    }

    @PostMapping("/create")
    @Operation(summary = "Создать проект")
    public ResponseEntity<HttpStatus> createProject(@RequestBody @Valid Project project) {
        projectService.createProject(project);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/all")
    @Operation(summary = "Получить все проекты")
    public ResponseEntity<List<Project>> getAllprojects() {
        return ResponseEntity.ok().body(projectService.getAllProjects());
    }

    @GetMapping("/{project_id}")
    @Operation(summary = "Получить проект по id")
    public Project getProject(@PathVariable("project_id") Long id) {
        return projectService.getProjectById(id);
    }

    @GetMapping("/{project_id}/delete")
    @Operation(summary = "Удалить проект")
    public ResponseEntity<?> deleteTeam(@PathVariable("project_id") Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/update")
    @Operation(summary = "Обновить проект")
    public ResponseEntity<?> putTeam( @Valid Project project) {
        projectService.putTeam(project);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}