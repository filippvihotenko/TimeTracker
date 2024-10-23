package by.example.timetracker.dataModule.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.processing.Generated;
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
    private String name;
    private String description;
    private boolean active;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<Stage> stages;
}
