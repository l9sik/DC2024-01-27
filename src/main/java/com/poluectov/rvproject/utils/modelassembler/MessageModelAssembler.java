package com.poluectov.rvproject.utils.modelassembler;

import com.poluectov.rvproject.controller.crud.MessageController;
import com.poluectov.rvproject.dto.message.MessageResponseTo;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class MessageModelAssembler implements RepresentationModelAssembler<MessageResponseTo, EntityModel<MessageResponseTo>> {
    @Override
    public EntityModel<MessageResponseTo> toModel(MessageResponseTo entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(MessageController.class).one(entity.getId())).withSelfRel(),
                linkTo(methodOn(MessageController.class).all()).withRel("messages"));
    }
}
