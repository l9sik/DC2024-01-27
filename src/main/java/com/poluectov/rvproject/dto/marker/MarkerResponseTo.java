package com.poluectov.rvproject.dto.marker;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.poluectov.rvproject.model.IdentifiedEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigInteger;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@JsonRootName("marker")
@AllArgsConstructor
@NoArgsConstructor
public class MarkerResponseTo extends IdentifiedEntity {

    private String name;

}
