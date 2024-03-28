package com.poluectov.rvproject.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


import java.math.BigInteger;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class IdentifiedEntity {

    @Nullable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private BigInteger id = null;

}
