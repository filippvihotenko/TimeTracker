package by.example.timetracker.dataModule.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "Project")
@Getter
@Setter
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long project_id;
    @NotNull
    private String name;

    private String description;
    @NotNull
    private boolean active;
    @NotNull
    private LocalTime startTime;
    @NotNull
    private LocalTime endTime;
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<Stage> stages;
}
