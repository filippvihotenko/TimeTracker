package by.example.timetracker.service.interfaces;

import by.example.timetracker.dataModule.domain.Stage;
import by.example.timetracker.dataModule.domain.Task;

import java.util.Set;

public interface StageService {
    Set<Task> getTasksByStageId(Long id);

    void createStage(Stage stage);

    Stage getStageById(Long id);

    void deleteStage(Long id);

    void putStage(Stage updatedStage);
}
