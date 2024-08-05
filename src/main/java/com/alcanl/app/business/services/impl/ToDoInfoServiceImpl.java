package com.alcanl.app.business.services.impl;


import com.alcanl.app.business.dto.ToDoInfoDTO;
import com.alcanl.app.business.mapper.IToDoMapper;
import com.alcanl.app.business.services.IToDoInfoService;
import com.alcanl.app.data.dal.ToDoRepositoryDataHelper;
import com.alcanl.app.data.entity.ToDoInfo;
import com.alcanl.app.exception.RepositoryException;
import com.alcanl.app.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Log4j2
@Service
public class ToDoInfoServiceImpl implements IToDoInfoService<ToDoInfo, ToDoInfoDTO> {

    // INJECTION (Lombok Constructor Field) => 3.YOL
    private final ToDoRepositoryDataHelper m_toDoRepositoryDataHelper;
    private final IToDoMapper m_toDoMapper;

    @Transactional
    @Override
    public void deleteAll()
    {
        try {
            m_toDoRepositoryDataHelper.deleteAll();
        }catch (RepositoryException ex) {
            log.error("error in service while deleting all : {}", ex.getMessage());
            throw new ServiceException(ex.getMessage());
        }
    }

    @Transactional
    @Override
    public ToDoInfoDTO create(ToDoInfoDTO toDoInfoDTO)
    {
        try {
            return m_toDoMapper.toToDoInfoDTO(m_toDoRepositoryDataHelper
                    .save(m_toDoMapper.toToDoInfo(toDoInfoDTO)));
        } catch (RepositoryException ex) {
            log.error("error in service while create : {}", ex.getMessage());
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public List<ToDoInfoDTO> findAll()
    {
        try {
            return StreamSupport.stream(m_toDoRepositoryDataHelper.findAllToDoInfo().spliterator(), false)
                    .map(m_toDoMapper::toToDoInfoDTO).toList();
        }catch (RepositoryException ex) {
            log.error("error in service while finding : {}", ex.getMessage());
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public Optional<ToDoInfoDTO> findById(long id)
    {
        try {
            return m_toDoRepositoryDataHelper.findById(id).map(m_toDoMapper::toToDoInfoDTO);
        } catch (RepositoryException ex) {
            log.error("error in service while finding by id : {}", ex.getMessage());
            throw new ServiceException(ex.getMessage());
        }
    }

    @Transactional
    @Override
    public ToDoInfoDTO update(ToDoInfoDTO toDoInfoDTO)
    {
        try {
            if (!m_toDoRepositoryDataHelper.existById(toDoInfoDTO.getToDoId()))
                throw new UnsupportedOperationException("No record found for id : " + toDoInfoDTO.getToDoId());

            return m_toDoMapper.toToDoInfoDTO(m_toDoRepositoryDataHelper
                    .save(m_toDoMapper.toToDoInfo(toDoInfoDTO)));
        } catch (RepositoryException ex) {
            log.error("error in service while update : {}", ex.getMessage());
            throw new ServiceException(ex.getMessage());
        }
    }

    @Transactional
    @Override
    public void deleteById(long id)
    {
        try {
            m_toDoRepositoryDataHelper.deleteById(id);
        } catch (RepositoryException ex) {
            log.error("error in service while deleting by id : {}", ex.getMessage());
            throw new ServiceException(ex.getMessage());
        }
    }
}
