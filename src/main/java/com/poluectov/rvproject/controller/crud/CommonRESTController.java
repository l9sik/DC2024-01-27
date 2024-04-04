package com.poluectov.rvproject.controller.crud;

import com.poluectov.rvproject.model.IdentifiedEntity;
import com.poluectov.rvproject.service.CommonRestService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


public class CommonRESTController<Entity extends IdentifiedEntity,
        Request extends IdentifiedEntity,
        Response extends IdentifiedEntity> {

    CommonRestService<Entity, Request, Response> service;
    Function<Response, EntityModel<Response>> assembler;

    public CommonRESTController(CommonRestService<Entity, Request, Response> service,
                                Function<Response, EntityModel<Response>> assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Response> /*ResponseEntity<?>*/ all() {
        return service.all();

        /*List<EntityModel<Response>> entityModels = service.all().stream()
                .map(assembler)
                .toList();*/

//        CollectionModel<EntityModel<Response>> collectionModel = CollectionModel.of(entityModels,
//                linkTo(methodOn(this.getClass()).all()).withSelfRel());
//        return ResponseEntity
//                .ok()
//                .location(collectionModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
//                .body(collectionModel);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> newEntity(@RequestBody Request request) {
        Optional<Response> response = service.create(request);

        EntityModel<Response> entityModel =  assembler.apply(response.orElse(null));

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> one(@PathVariable("id") Long id) {
        EntityModel<Response> entityModel = assembler.apply(service.one(id).orElse(null));

        return ResponseEntity
                .ok()
                .location(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public Response /*ResponseEntity<?>*/ updateEntity(
                                        @RequestBody Request request) {
        Long id = request.getId();

        Optional<Response> user = service.update(id, request);

        return user.orElse(null);
        /*EntityModel<Response> entityModel = assembler.apply(user.orElse(null));

        return ResponseEntity
                .ok()
                .location(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    */
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEntity(@PathVariable("id") Long id) {

        service.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /*@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public int deleteEntity(@PathVariable("id") BigInteger id, HttpServletResponse response) {
        Response serviceResponse = service.one(id).orElse(null);
        if (serviceResponse == null) {
            response.setStatus(403);
        }else{
            service.delete(id);
            response.setStatus(204);
        }
        return 0;
    }*/
}
