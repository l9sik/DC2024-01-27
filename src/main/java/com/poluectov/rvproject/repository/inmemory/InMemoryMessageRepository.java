package com.poluectov.rvproject.repository.inmemory;

import com.poluectov.rvproject.dto.message.MessageRequestTo;
import com.poluectov.rvproject.model.Message;
import com.poluectov.rvproject.repository.IssueRepository;
import com.poluectov.rvproject.repository.MessageRepository;
import com.poluectov.rvproject.repository.exception.EntityNotFoundException;
import com.poluectov.rvproject.utils.dtoconverter.DtoConverter;
import org.springframework.stereotype.Component;

@Component
public class InMemoryMessageRepository extends InMemoryRepository<Message, MessageRequestTo> implements MessageRepository {

    IssueRepository issueRepository;
    public InMemoryMessageRepository(DtoConverter<MessageRequestTo, Message> convert,
                                     IssueRepository issueRepository) {
        super(convert);
        this.issueRepository = issueRepository;
    }

    @Override
    public Message save(MessageRequestTo request) throws EntityNotFoundException {
        if (issueRepository.findById(request.getIssueId()) == null){
            throw new EntityNotFoundException("Issue with id " + request.getIssueId() + " not found");
        }

        return super.save(request);
    }

}
