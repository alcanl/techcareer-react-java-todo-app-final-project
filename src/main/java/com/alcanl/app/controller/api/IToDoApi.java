package com.alcanl.app.controller.api;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IToDoApi<D> {

    public ResponseEntity<String> allToDoInfoDelete();

    public ResponseEntity<?>  create(D d);

    public ResponseEntity<List<D>>  allToDoInfoList();

    public ResponseEntity<?>  findById(long id);

    public ResponseEntity<?>  update(D d);

    public ResponseEntity<?>  deleteById(long id);

}
