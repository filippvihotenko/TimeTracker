package by.example.timetracker.controller.AdviceController;

import by.example.timetracker.dataModule.exceptions.ProjectNotFoundException;
import by.example.timetracker.dataModule.exceptions.ResponseError;
import by.example.timetracker.dataModule.exceptions.StagenotFoundException;
import by.example.timetracker.dataModule.exceptions.TaskNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class DefaultAdvice {
    @ExceptionHandler({ProjectNotFoundException.class, StagenotFoundException.class, TaskNotFoundException.class})
    public ResponseError handle(Exception exception){
        log.error(exception.getMessage(), exception);
        return new  ResponseError(HttpStatus.NOT_FOUND, exception.getMessage());
    }
}
