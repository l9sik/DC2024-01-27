package com.poluectov.rvproject.service;

import com.poluectov.rvproject.dto.message.MessageRequestTo;
import com.poluectov.rvproject.dto.message.MessageResponseTo;
import com.poluectov.rvproject.model.Message;
import com.poluectov.rvproject.repository.MessageRepository;
import com.poluectov.rvproject.utils.dtoconverter.IssueResponseDtoConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MessageService extends CommonRestService<Message, MessageRequestTo, MessageResponseTo> {

    IssueResponseDtoConverter issueResponseDtoConverter;

    public MessageService(MessageRepository repository,
                          IssueResponseDtoConverter issueResponseDtoConverter) {
        super(repository);
        this.issueResponseDtoConverter = issueResponseDtoConverter;
    }

    Optional<MessageResponseTo> mapResponseTo(Message message) {
        return Optional.ofNullable(MessageResponseTo.builder()
                .id(message.getId())
                .issueId(message.getIssue().getId())
                .content(message.getContent())
                .build());
    }
}
