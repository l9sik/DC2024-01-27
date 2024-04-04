package com.poluectov.rvproject.service;

import com.poluectov.rvproject.dto.message.MessageRequestTo;
import com.poluectov.rvproject.dto.message.MessageResponseTo;
import com.poluectov.rvproject.model.Message;
import com.poluectov.rvproject.repository.MessageRepository;
import com.poluectov.rvproject.repository.jpa.JpaMessageRepository;
import com.poluectov.rvproject.utils.dtoconverter.IssueRequestDtoConverter;
import com.poluectov.rvproject.utils.dtoconverter.IssueResponseDtoConverter;
import com.poluectov.rvproject.utils.dtoconverter.MessageRequestDtoConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MessageService extends CommonRestService<Message, MessageRequestTo, MessageResponseTo> {

    public MessageService(
            JpaMessageRepository repository,
            MessageRequestDtoConverter messageRequestDtoConverter) {
        super(repository, messageRequestDtoConverter);
    }

    Optional<MessageResponseTo> mapResponseTo(Message message) {
        return Optional.ofNullable(MessageResponseTo.builder()
                .id(message.getId())
                .issueId(message.getIssue().getId())
                .content(message.getContent())
                .build());
    }

    @Override
    void update(Message one, Message found) {
        one.setIssue(found.getIssue());
        one.setContent(found.getContent());
    }
}
