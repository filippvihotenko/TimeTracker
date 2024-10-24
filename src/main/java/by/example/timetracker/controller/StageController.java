package by.example.timetracker.controller;

import by.example.timetracker.dataModule.domain.Stage;
import by.example.timetracker.service.StageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stages")
@AllArgsConstructor
public class StageController {

    private StageService stageService;

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createStage(Stage stage) {
        stageService.createStage(stage);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{stage_id}/tasks")
    public ResponseEntity<?> getTasksById(@PathVariable("stage_id") Long id) {
        return ResponseEntity.ok().body(stageService.getTasksByStageId(id));
    }

    @GetMapping("/{stage_id}")
    public Stage getStageById(@PathVariable("stage_id") Long id) {
        return stageService.getStageById(id);
    }

    @GetMapping("/{stage_id}/drop")
    public ResponseEntity<?> deleteStage(@PathVariable("stage_id") Long id) {
        stageService.deleteStage(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/put")
    public ResponseEntity<?> putStage(Stage stage) {
        stageService.putStage(stage);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
