package com.poluectov.rvproject.service;

import com.poluectov.rvproject.model.IdentifiedEntity;
import com.poluectov.rvproject.repository.ICommonRepository;
import com.poluectov.rvproject.repository.exception.EntityNotFoundException;
import com.poluectov.rvproject.utils.dtoconverter.DtoConverter;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.mediatype.MessageResolver;
import org.springframework.validation.annotation.Validated;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Validated
public abstract class CommonRestService<Entity extends IdentifiedEntity, Request extends IdentifiedEntity, Response extends IdentifiedEntity> {

    ICommonRepository<Entity, Request> repository;

    public CommonRestService(ICommonRepository<Entity, Request> repository) {
        this.repository = repository;
    }

    abstract Optional<Response> mapResponseTo(Entity entity);

    public List<Response> all() {
        return repository.findAll().stream().map( one -> {
            Optional<Response> to = mapResponseTo(one);
            return to.orElse(null);
        } ).toList();
    }

    public Optional<Response> one(BigInteger id) {
        return mapResponseTo(repository.find(id));
    }

    public Optional<Response> create(@Valid Request request) {
        Entity entity = repository.save(request);
        return mapResponseTo(entity);
    }

    public Optional<Response> update(BigInteger id, @Valid Request request) {
        //repository updates by id
        request.setId(id);
        Entity entity = repository.update(request);
        return mapResponseTo(entity);
    }
    public void delete(BigInteger id) throws EntityNotFoundException {
        repository.delete(id);
    }

}
