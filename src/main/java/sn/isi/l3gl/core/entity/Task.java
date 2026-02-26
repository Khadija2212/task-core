package sn.isi.l3gl.core.entity;

import jakarta.persistence.*;
import lombok.Data;
import sn.isi.l3gl.core.enums.TaskStatus;

@Entity
@Table(name = "tasks")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;
}
