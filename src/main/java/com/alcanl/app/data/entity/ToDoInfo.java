package com.alcanl.app.data.entity;

import com.alcanl.app.data.type.ToDoProcessType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "todo_info")
public class ToDoInfo implements Serializable {

    @Serial
    @Transient
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="todo_id")
    @EqualsAndHashCode.Include
    private long toDoId;

    @EqualsAndHashCode.Include
    @Column(name = "todo_create_time")
    private LocalDate createDate = LocalDate.now();

    @Enumerated(EnumType.STRING)
    private ToDoProcessType toDoProcessType;

    @EqualsAndHashCode.Include
    private String content;
}
