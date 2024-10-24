package by.example.timetracker.service;

import by.example.timetracker.dataModule.domain.Task;
import by.example.timetracker.dataModule.domain.TimeEntry;
import by.example.timetracker.dataModule.repository.TaskRepository;
import by.example.timetracker.dataModule.repository.TimeEntryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@AllArgsConstructor
public class TaskService {

    private TaskRepository taskRepository;

    private TimeEntryRepository timeEntryRepository;

    public Task startTask(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));

        // Создаем новую запись времени
        TimeEntry timeEntry = new TimeEntry();
        timeEntry.setTask(task);
        timeEntry.setStartTime(LocalDateTime.now());

        timeEntryRepository.save(timeEntry);
        return task;
    }

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

    public long getTotalTimeSpent(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        return task.getTotalTimeSpent();
    }



    public List<Task> getAllTasks(){
        return  taskRepository.findAll();
    }
    public Set<TimeEntry> getTasksByTaskId(Long id){
        Task task= getTaskById(id);
        return task.getTimeEntries();
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }


    public void createTask(Task task){
        taskRepository.save(task);
    }

    public void deleteProject(Long id) {
        Task task = getTaskById(id);
        taskRepository.delete(task);
    }

    public void  putTask(Task updatedTask) {
        taskRepository.save(updatedTask);
    }
}

