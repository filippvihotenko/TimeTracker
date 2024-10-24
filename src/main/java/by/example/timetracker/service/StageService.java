package by.example.timetracker.service;

import by.example.timetracker.dataModule.domain.Stage;
import by.example.timetracker.dataModule.domain.Task;
import by.example.timetracker.dataModule.repository.StageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Set;

@Service
@AllArgsConstructor
public class StageService {
    private StageRepository stageRepository;


    public Set<Task> getTasksByStageId(Long id){
        Stage stage = getStageById(id);
        return stage.getTasks();
    }


    public void createStage(Stage stage){
        stageRepository.save(stage);
    }


    public Stage getStageById(Long id){
        return stageRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }

    public void deleteStage(Long id) {
        Stage stage = getStageById(id);
        stageRepository.delete(stage);
    }

    public void  putStage(Stage updatedStage) {
        stageRepository.save(updatedStage);
    }

}
