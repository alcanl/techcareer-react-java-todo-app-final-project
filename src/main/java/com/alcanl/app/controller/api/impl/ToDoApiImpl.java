package com.alcanl.app.controller.api.impl;


import com.alcanl.app.business.dto.ToDoInfoDTO;
import com.alcanl.app.business.services.IToDoInfoService;
import com.alcanl.app.controller.api.IToDoApi;
import com.alcanl.app.data.entity.ToDoInfo;
import com.alcanl.app.frontend.ReactFrontend;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Log4j2
@RestController
@CrossOrigin(origins = ReactFrontend.TEST_REACT_FRONTEND_PORT_URL)
@RequestMapping("/todo/api/v1")
public class ToDoApiImpl implements IToDoApi<ToDoInfoDTO> {

    private final IToDoInfoService<ToDoInfo, ToDoInfoDTO> m_iToDoInfoService;

    @DeleteMapping("/delete/all")
    @Override
    public ResponseEntity<String> allToDoInfoDelete()
    {
        m_iToDoInfoService.deleteAll();
        return ResponseEntity.ok().build();
    }

    @Override
    @PostMapping("/save")
    public ResponseEntity<?> create(@RequestBody ToDoInfoDTO toDoInfoDTO)
    {
        return ResponseEntity.of(Optional.ofNullable(m_iToDoInfoService.create(toDoInfoDTO)));
    }

    @GetMapping("/get/all")
    @Override
    public ResponseEntity<List<ToDoInfoDTO>> allToDoInfoList()
    {
        return ResponseEntity.of(Optional.ofNullable(m_iToDoInfoService.findAll()));
    }

    @GetMapping("/get")
    @Override
    public ResponseEntity<?> findById(@RequestParam long id)
    {
        return ResponseEntity.of(m_iToDoInfoService.findById(id));
    }

    @PutMapping("/update")
    @Override
    public ResponseEntity<?> update(@RequestBody ToDoInfoDTO toDoInfoDTO)
    {
        return ResponseEntity.of(Optional.ofNullable(m_iToDoInfoService.update(toDoInfoDTO)));
    }

    @DeleteMapping("/delete")
    @Override
    public ResponseEntity<?> deleteById(@RequestParam long id)
    {
        m_iToDoInfoService.deleteById(id);
        return  ResponseEntity.ok().build();
    }
}
