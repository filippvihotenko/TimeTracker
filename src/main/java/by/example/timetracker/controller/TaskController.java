package by.example.timetracker.controller;

import by.example.timetracker.dataModule.domain.Task;
import by.example.timetracker.service.interfaces.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
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
    @Operation(summary = "Возобновить работу по id")
    public ResponseEntity<?> startTask(@PathVariable Long taskId) {
        Task task = taskService.startTask(taskId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/{taskId}/stop")
    @Operation(summary = "Остановить работу")
    public ResponseEntity<?> stopTask(@PathVariable Long taskId) {
        Task task = taskService.stopTask(taskId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{taskId}/time-spent")
    @Operation(summary = "По id получить временные промежутки выполнения задачи")
    public ResponseEntity<Long> getTotalTimeSpent(@PathVariable Long taskId) {
        long totalTimeSpent = taskService.getTotalTimeSpent(taskId);
        return ResponseEntity.ok(totalTimeSpent);
    }

    @PostMapping("/create")
    @Operation(summary = "Создать задание")
    public ResponseEntity<?> createTask(@Valid Task task){
        taskService.createTask(task);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}

