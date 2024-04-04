package com.poluectov.rvproject.repository.inmemory;

import com.poluectov.rvproject.model.IdentifiedEntity;
import com.poluectov.rvproject.repository.exception.EntityNotFoundException;
import com.poluectov.rvproject.utils.dtoconverter.DtoConverter;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@NoArgsConstructor
public abstract class InMemoryRepository<Entity extends IdentifiedEntity, Request extends IdentifiedEntity> {

    protected ConcurrentMap<Long, Entity> data;
    Long lastId = 1L;

    DtoConverter<Request, Entity> convert;

    public InMemoryRepository(DtoConverter<Request, Entity> convert) {
        data = new ConcurrentHashMap<>();
        this.convert = convert;
    }

    public List<Entity> findAll() {
        return data.values().stream().toList();
    }

    public Entity save(Request request) throws EntityNotFoundException {
        if (request.getId() == null || request.getId().equals(BigInteger.ZERO)) {
            request.setId(lastId);
            lastId = lastId + (1l);
        }
        if (data.containsKey(request.getId())) {
            throw new EntityNotFoundException(getEntityName() + " with id " + request.getId() + " already exists");
        }
        Entity entity = convert.convert(request);
        data.put(request.getId(), entity);
        return entity;
    }

    public Entity update(Request request) throws EntityNotFoundException {
        if (!data.containsKey(request.getId())){
            throw new EntityNotFoundException(getEntityName() + " with id " + request.getId() + " not found");
        }
        Entity entity = convert.convert(request);
        data.put(request.getId(), entity);
        return entity;
    }

    public void deleteById(Long id) throws EntityNotFoundException {
        if (!data.containsKey(id)){
            throw new EntityNotFoundException(getEntityName() + " with id " + id + " not found");
        }
        data.remove(id);
    }

    public Entity findById(Long id) throws EntityNotFoundException {
        if (!data.containsKey(id)){
            throw new EntityNotFoundException(getEntityName() + " with id " + id + " not found");
        }
        return data.get(id);
    }

    protected String getEntityName(){
        String className = this.getClass().getSimpleName();
        className = className.replace("Repository", "");
        for(int i = className.length() - 1; i >= 0; i--){
            if(Character.isUpperCase(className.charAt(i))){
                className = className.substring(i);
                break;
            }
        }
        return className;
    }

}
