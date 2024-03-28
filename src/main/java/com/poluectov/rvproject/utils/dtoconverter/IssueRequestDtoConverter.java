package com.poluectov.rvproject.utils.dtoconverter;

import com.poluectov.rvproject.dto.issue.IssueRequestTo;
import com.poluectov.rvproject.model.Issue;
import com.poluectov.rvproject.repository.MarkerRepository;
import com.poluectov.rvproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class IssueRequestDtoConverter implements DtoConverter<IssueRequestTo, Issue> {

    private UserRepository userRepository;

    private MarkerRepository markerRepository;

    @Override
    public Issue convert(IssueRequestTo issue) {
        if (issue == null) {
            return null;
        }
        return Issue.builder()

                .id(issue.getId())
                .user(userRepository.find(issue.getUserId()))
                .title(issue.getTitle())
                .content(issue.getContent())
                .created(issue.getCreated())
                .modified(issue.getModified())

                .markers(markerRepository.findAll(issue.getMarkers()))

                .build();
    }
}
