package by.example.timetracker.dataModule.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class ProjectNotFoundException extends ResponseStatusException {
    public ProjectNotFoundException() {
        super(HttpStatus.NOT_FOUND, "ProjectNotFound");
    }
}
