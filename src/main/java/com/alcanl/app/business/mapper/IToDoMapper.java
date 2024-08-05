package com.alcanl.app.business.mapper;

import com.alcanl.app.business.dto.ToDoInfoDTO;
import com.alcanl.app.data.entity.ToDoInfo;
import org.mapstruct.Mapper;

@Mapper(implementationName = "ToDoMapperImpl", componentModel = "spring")
public interface IToDoMapper {

    ToDoInfoDTO toToDoInfoDTO(ToDoInfo toDoInfo);
    ToDoInfo toToDoInfo(ToDoInfoDTO toDoInfoDTO);
}
