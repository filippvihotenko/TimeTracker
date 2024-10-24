package by.example.timetracker.dataModule.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "TimeEntry")
public class TimeEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long time_entry_id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    public long getTimeSpent() {
        if (endTime != null) {
            return Duration.between(startTime, endTime).toSeconds();
        }
        return 0;
    }
}
