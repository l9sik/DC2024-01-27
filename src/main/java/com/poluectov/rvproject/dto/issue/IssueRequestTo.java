package com.poluectov.rvproject.dto.issue;

import com.poluectov.rvproject.model.IdentifiedEntity;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class IssueRequestTo extends IdentifiedEntity {

    private BigInteger userId;
    @Size(min = 2, max = 64)
    private String title;
    @Size(min = 4, max = 2048)
    private String content;
    private Date created;
    private Date modified;

    private List<BigInteger> markers;
}
