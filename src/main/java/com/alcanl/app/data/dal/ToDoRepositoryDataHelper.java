package com.alcanl.app.data.dal;

import com.alcanl.app.data.entity.ToDoInfo;
import com.alcanl.app.data.repository.IToDoRepository;
import com.alcanl.app.exception.RepositoryException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
@AllArgsConstructor
public class ToDoRepositoryDataHelper {
    private final IToDoRepository m_toDoRepository;

    public Iterable<ToDoInfo> findAllToDoInfo()
    {
        try {
            return m_toDoRepository.findAll();
        }catch (Throwable ex) {
            log.error("error while finding all to do info : {}", ex.getMessage());
            throw new RepositoryException(ex.getMessage());
        }
    }

    public boolean existById(long id)
    {
        try {
            return m_toDoRepository.existsById(id);
        } catch (Throwable ex) {
            log.error("error while find exists by id : {}", ex.getMessage());
            throw new RepositoryException(ex.getMessage());
        }
    }

    public ToDoInfo save(ToDoInfo toDoInfo)
    {
        try {
            return m_toDoRepository.save(toDoInfo);
        } catch (Throwable ex) {
            log.error("error while saving toDoInfo : {}", ex.getMessage());
            throw new RepositoryException(ex.getMessage());
        }
    }
    public void deleteById(long id)
    {
        try {
            m_toDoRepository.deleteById(id);
        } catch (Throwable ex) {
            log.error("error while deleting toDoInfo : {}", ex.getMessage());
            throw new RepositoryException(ex.getMessage());
        }
    }
    public Optional<ToDoInfo> findById(long id)
    {
        try {
            return m_toDoRepository.findById(id);
        } catch (Throwable ex) {
            log.error("error while finding toDoInfo : {}", ex.getMessage());
            throw new RepositoryException(ex.getMessage());
        }
    }
    public void deleteAll()
    {
        try {
            m_toDoRepository.deleteAll();
        } catch (Throwable ex) {
            log.error("error while deleting all toDoInfo : {}", ex.getMessage());
            throw new RepositoryException(ex.getMessage());
        }
    }
}
