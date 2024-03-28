package com.poluectov.rvproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class Issue extends IdentifiedEntity {

    @ManyToOne
    private User user;

    @Size(min = 2, max = 64)
    @Column(unique = true)
    private String title;

    @Size(min = 4, max = 2048)
    private String content;
    private Date created;
    private Date modified;

    @ManyToMany
    private List<Marker> markers;
}
