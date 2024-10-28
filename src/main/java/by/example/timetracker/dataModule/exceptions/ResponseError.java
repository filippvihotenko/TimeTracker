package by.example.timetracker.dataModule.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class ResponseError {
    private final HttpStatus httpStatus;
    private final String massage;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private final LocalDateTime localDateTime = LocalDateTime.now();


    public ResponseError(HttpStatus httpStatus, String massage) {
        this.httpStatus = httpStatus;
        this.massage = massage;
    }
}

