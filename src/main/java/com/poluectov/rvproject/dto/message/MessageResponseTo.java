package com.poluectov.rvproject.dto.message;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.poluectov.rvproject.dto.issue.IssueResponseTo;
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
@JsonRootName("message")
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponseTo extends IdentifiedEntity {

    private BigInteger issueId;
    private String content;
}
