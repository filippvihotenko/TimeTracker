package by.example.timetracker.dataModule.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class StagenotFoundException extends ResponseStatusException {

    public StagenotFoundException() {
        super(HttpStatus.NOT_FOUND, "Stage not found");
    }
}
