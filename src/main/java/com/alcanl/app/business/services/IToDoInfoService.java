package com.alcanl.app.business.services;

import java.util.List;
import java.util.Optional;

public interface IToDoInfoService<E, D> {

    void deleteAll();

    D create(D d);

    List<D> findAll();

    Optional<D> findById(long id);

    D update(D d);

    void deleteById(long id);
}
