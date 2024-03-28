package com.poluectov.rvproject.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class User extends IdentifiedEntity {

    @Size(min = 2, max = 64)
    @Column(unique = true)
    private String login;
    @Size(min = 8, max = 128)
    private String password;
    @Size(min = 2, max = 64)
    private String firstName;
    @Size(min = 2, max = 64)
    private String lastName;

}