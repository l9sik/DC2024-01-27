package com.poluectov.rvproject.dto.issue;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.poluectov.rvproject.dto.marker.MarkerResponseTo;
import com.poluectov.rvproject.dto.user.UserResponseTo;
import com.poluectov.rvproject.model.IdentifiedEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@JsonRootName("issue")
@AllArgsConstructor
@NoArgsConstructor
public class IssueResponseTo extends IdentifiedEntity {

    private BigInteger userId;
    private String title;
    private String content;
    private Date created;
    private Date modified;

    private List<BigInteger> markers;
}
