package by.example.timetracker.dataModule.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TaskNotFoundException extends ResponseStatusException {
    public TaskNotFoundException()
    {
        super(HttpStatus.NOT_FOUND, "Task not found");
    }
}
