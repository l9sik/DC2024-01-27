package com.poluectov.rvproject.utils.modelassembler;

import com.poluectov.rvproject.controller.crud.IssueController;
import com.poluectov.rvproject.controller.crud.MarkerController;
import com.poluectov.rvproject.controller.crud.UserController;
import com.poluectov.rvproject.dto.issue.IssueResponseTo;
import com.poluectov.rvproject.dto.marker.MarkerResponseTo;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class IssueModelAssembler implements RepresentationModelAssembler<IssueResponseTo, EntityModel<IssueResponseTo>> {
    @Override
    public EntityModel<IssueResponseTo> toModel(IssueResponseTo entity) {
            EntityModel<IssueResponseTo> model = EntityModel.of(entity,
                linkTo(methodOn(IssueController.class).one(entity.getId())).withSelfRel(),
                linkTo(methodOn(UserController.class).one(entity.getUserId())).withRel("users"),
                linkTo(methodOn(IssueController.class).all()).withRel("issues"));

        if (entity.getMarkers() != null) {
            for (BigInteger marker : entity.getMarkers()) {
                model.add(linkTo(methodOn(MarkerController.class).one(marker)).withRel("markers"));
            }
        }

        return model;
    }
}
