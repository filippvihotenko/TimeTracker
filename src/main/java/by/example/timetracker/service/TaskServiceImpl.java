package by.example.timetracker.service;

import by.example.timetracker.dataModule.domain.Task;
import by.example.timetracker.dataModule.domain.TimeEntry;
import by.example.timetracker.dataModule.exceptions.TaskNotFoundException;
import by.example.timetracker.dataModule.repository.TaskRepository;
import by.example.timetracker.dataModule.repository.TimeEntryRepository;
import by.example.timetracker.service.interfaces.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    private TimeEntryRepository timeEntryRepository;

    @Override
    public Task startTask(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));

        // Создаем новую запись времени
        TimeEntry timeEntry = new TimeEntry();
        timeEntry.setTask(task);
        timeEntry.setStartTime(LocalDateTime.now());

        timeEntryRepository.save(timeEntry);
        return task;
    }

    @Override
    public Task stopTask(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));

        // Найти последний незавершенный TimeEntry
        TimeEntry activeTimeEntry = timeEntryRepository.findFirstByTaskAndEndTimeIsNull(task).orElseThrow(() -> new RuntimeException());

        if (activeTimeEntry != null) {
            // Завершаем запись времени
            activeTimeEntry.setEndTime(LocalDateTime.now());
            timeEntryRepository.save(activeTimeEntry);

            // Обновляем общее время, затраченное на задачу
            long timeSpent = activeTimeEntry.getTimeSpent();
            task.setTotalTimeSpent(task.getTotalTimeSpent() + timeSpent);

            taskRepository.save(task);
        }

        return task;
    }

    @Override
    public long getTotalTimeSpent(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        return task.getTotalTimeSpent();
    }



    @Override
    public List<Task> getAllTasks(){
        return  taskRepository.findAll();
    }
    @Override
    public Set<TimeEntry> getTimeIntriesByTaskId(Long id){
        Task task= getTaskById(id);
        return task.getTimeEntries();
    }

    @Override
    public Task getTaskById(Long id){
        return taskRepository.findById(id).orElseThrow(TaskNotFoundException::new);
    }


    @Override
    public void createTask(Task task){
        taskRepository.save(task);
    }

    @Override
    public void deleteProject(Long id) {
        Task task = getTaskById(id);
        taskRepository.delete(task);
    }

    @Override
    public void  putTask(Task updatedTask) {
        taskRepository.save(updatedTask);
    }
}

