package com.alcanl.app.business.dto;

import com.alcanl.app.data.type.ToDoProcessType;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Accessors(prefix = "m_")
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder
public class ToDoInfoDTO implements Serializable {

    @Serial
    private static final long serialVersionUID=1L;

    private long m_toDoId;

    private LocalDate m_createDate = LocalDate.now();

    @NotEmpty(message = "{blog.content.validation.constraints.NotNull.message}")
    @Size(min = 10,message = "{blog.content.least.validation.constraints.NotNull.message}")
    @Lob
    private String m_content;

    private ToDoProcessType m_toDoProcessType;
}
