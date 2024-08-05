package com.alcanl.app.data.repository;

import com.alcanl.app.data.entity.ToDoInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IToDoRepository extends CrudRepository<ToDoInfo, Long> {
}
