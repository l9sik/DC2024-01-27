package com.poluectov.rvproject.dto.message;

import com.poluectov.rvproject.dto.issue.IssueResponseTo;
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
public class MessageRequestTo extends IdentifiedEntity {

    private BigInteger issueId;
    @Size(min = 2, max = 2048)
    private String content;

}
