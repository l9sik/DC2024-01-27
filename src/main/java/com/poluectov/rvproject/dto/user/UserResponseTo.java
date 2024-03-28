package com.poluectov.rvproject.dto.user;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.poluectov.rvproject.model.IdentifiedEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.math.BigInteger;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@JsonRootName("user")
public class UserResponseTo extends IdentifiedEntity {

    private String login;
    private String hashedPassword;
    private String firstname;
    private String lastname;

}