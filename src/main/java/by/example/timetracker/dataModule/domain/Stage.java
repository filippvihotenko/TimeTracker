package by.example.timetracker.dataModule.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name =  "Stage")
@Getter
@Setter
@NoArgsConstructor
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stage_id;
    @NotNull
    private String name;
    private String description;
    @NotNull
    private LocalTime startTime;
    @NotNull
    private LocalTime endTime;
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;
    @ManyToOne
    @JoinColumn(name = "project_id")
    @NotNull
    private Project project;
    @OneToMany(mappedBy = "stage",cascade = CascadeType.ALL)
    private Set<Task> tasks;
}
