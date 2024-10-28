package by.example.timetracker.service;

import by.example.timetracker.dataModule.domain.Stage;
import by.example.timetracker.dataModule.domain.Task;
import by.example.timetracker.dataModule.exceptions.StagenotFoundException;
import by.example.timetracker.dataModule.repository.StageRepository;
import by.example.timetracker.service.interfaces.StageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Set;

@Service
@AllArgsConstructor
public class StageServiceImpl implements StageService {
    private StageRepository stageRepository;


    @Override
    public Set<Task> getTasksByStageId(Long id){
        Stage stage = getStageById(id);
        return stage.getTasks();
    }


    @Override
    public void createStage(Stage stage){
        stageRepository.save(stage);
    }


    @Override
    public Stage getStageById(Long id){
        return stageRepository.findById(id).orElseThrow(StagenotFoundException::new);
    }

    @Override
    public void deleteStage(Long id) {
        Stage stage = getStageById(id);
        stageRepository.delete(stage);
    }

    @Override
    public void  putStage(Stage updatedStage) {
        stageRepository.save(updatedStage);
    }

}
