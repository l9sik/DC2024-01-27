package com.poluectov.rvproject.utils.dtoconverter;

import com.poluectov.rvproject.dto.message.MessageRequestTo;
import com.poluectov.rvproject.model.Message;
import com.poluectov.rvproject.repository.IssueRepository;
import com.poluectov.rvproject.repository.exception.EntityNotFoundException;
import com.poluectov.rvproject.repository.jpa.JpaIssueRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessageRequestDtoConverter implements DtoConverter<MessageRequestTo, Message> {

    JpaIssueRepository issueRepository;

    @Override
    public Message convert(MessageRequestTo message) {
        return Message.builder()
                .id(message.getId())
                .issue(issueRepository
                        .findById(message.getIssueId())
                        .orElseThrow( () ->
                                new EntityNotFoundException(
                                        "Issue with id " + message.getIssueId() + " not found"
                                )
                        )
                )
                .content(message.getContent())
                .build();
    }
}
