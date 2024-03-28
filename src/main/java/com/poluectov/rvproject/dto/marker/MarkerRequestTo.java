package com.poluectov.rvproject.dto.marker;

import com.poluectov.rvproject.model.IdentifiedEntity;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigInteger;
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class MarkerRequestTo extends IdentifiedEntity {

    @Size(min = 2, max = 32)
    private String name;

}
