package com.poluectov.rvproject.repository;

import com.poluectov.rvproject.model.IdentifiedEntity;
import com.poluectov.rvproject.model.User;
import com.poluectov.rvproject.repository.exception.EntityNotFoundException;

import java.math.BigInteger;
import java.util.List;

public interface ICommonRepository<Entity extends IdentifiedEntity, Request extends IdentifiedEntity> {

    List<Entity> findAll() throws EntityNotFoundException;

    /**
     * Saves new if id is null
     * @param
     */
    Entity save(Request entity) throws EntityNotFoundException;

    Entity update(Request entity) throws EntityNotFoundException;
    void delete(BigInteger id) throws EntityNotFoundException;

    Entity find(BigInteger id) throws EntityNotFoundException;
}
