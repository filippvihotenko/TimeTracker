package by.example.timetracker.service.interfaces;

import by.example.timetracker.dataModule.domain.Task;
import by.example.timetracker.dataModule.domain.TimeEntry;

import java.util.List;
import java.util.Set;

public interface TaskService {
    Task startTask(Long taskId);

    Task stopTask(Long taskId);

    long getTotalTimeSpent(Long taskId);

    List<Task> getAllTasks();

    Set<TimeEntry> getTimeIntriesByTaskId(Long id);

    Task getTaskById(Long id);

    void createTask(Task task);

    void deleteProject(Long id);

    void putTask(Task updatedTask);
}
