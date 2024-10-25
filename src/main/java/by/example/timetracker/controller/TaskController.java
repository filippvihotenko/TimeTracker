package by.example.timetracker.controller;

import by.example.timetracker.dataModule.domain.Task;
import by.example.timetracker.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private TaskService taskService;

    @PostMapping("/{taskId}/start")
    public ResponseEntity<?> startTask(@PathVariable Long taskId) {
        Task task = taskService.startTask(taskId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/{taskId}/stop")
    public ResponseEntity<?> stopTask(@PathVariable Long taskId) {
        Task task = taskService.stopTask(taskId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{taskId}/time-spent")
    public ResponseEntity<Long> getTotalTimeSpent(@PathVariable Long taskId) {
        long totalTimeSpent = taskService.getTotalTimeSpent(taskId);
        return ResponseEntity.ok(totalTimeSpent);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTask(Task task){
        taskService.createTask(task);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}

