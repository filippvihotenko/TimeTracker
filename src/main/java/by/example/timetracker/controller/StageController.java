package by.example.timetracker.controller;

import by.example.timetracker.dataModule.domain.Stage;
import by.example.timetracker.service.interfaces.StageService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stages")
@AllArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class StageController {

    private StageService stageService;

    @PostMapping("/create")
    @Operation(summary = "Создать стадию проекта")
    public ResponseEntity<HttpStatus> createStage(@Valid Stage stage) {
        stageService.createStage(stage);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{stage_id}/tasks")
    @Operation(summary = "По id стадии получить задания")
    public ResponseEntity<?> getTasksById(@PathVariable("stage_id") Long id) {
        return ResponseEntity.ok().body(stageService.getTasksByStageId(id));
    }


    @GetMapping("/{stage_id}")
    @Operation(summary = "По id получить стадию")
    public Stage getStageById(@PathVariable("stage_id") Long id) {
        return stageService.getStageById(id);
    }

    @GetMapping("/{stage_id}/drop")
    @Operation(summary = "По id удалить стадию")
    public ResponseEntity<?> deleteStage(@PathVariable("stage_id") Long id) {
        stageService.deleteStage(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/put")
    @Operation(summary = "По id обновить стадию")
    public ResponseEntity<?> putStage(@Valid Stage stage) {
        stageService.putStage(stage);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
