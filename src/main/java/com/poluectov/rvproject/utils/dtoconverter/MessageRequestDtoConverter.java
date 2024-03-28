package com.poluectov.rvproject.utils.dtoconverter;

import com.poluectov.rvproject.dto.message.MessageRequestTo;
import com.poluectov.rvproject.model.Message;
import com.poluectov.rvproject.repository.IssueRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessageRequestDtoConverter implements DtoConverter<MessageRequestTo, Message> {

    IssueRepository issueRepository;

    @Override
    public Message convert(MessageRequestTo message) {
        return Message.builder()
                .id(message.getId())
                .issue(issueRepository.find(message.getIssueId()))
                .content(message.getContent())
                .build();
    }
}
