package com.poluectov.rvproject.service;

import com.poluectov.rvproject.dto.issue.IssueRequestTo;
import com.poluectov.rvproject.dto.issue.IssueResponseTo;
import com.poluectov.rvproject.dto.marker.MarkerResponseTo;
import com.poluectov.rvproject.model.Issue;
import com.poluectov.rvproject.model.Marker;
import com.poluectov.rvproject.repository.IssueRepository;
import com.poluectov.rvproject.utils.dtoconverter.MarkerResponseDtoConverter;
import com.poluectov.rvproject.utils.dtoconverter.UserResponseDtoConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Component
public class IssueService extends CommonRestService<Issue, IssueRequestTo, IssueResponseTo> {

    UserResponseDtoConverter userResponseDtoConverter;
    MarkerResponseDtoConverter markerResponseDtoConverter;
    public IssueService(IssueRepository repository,
                        UserResponseDtoConverter userResponseDtoConverter,
                        MarkerResponseDtoConverter markerResponseDtoConverter) {
        super(repository);
        this.userResponseDtoConverter = userResponseDtoConverter;
        this.markerResponseDtoConverter = markerResponseDtoConverter;
    }

    @Override
    Optional<IssueResponseTo> mapResponseTo(Issue message) {
        List<Marker> markerList = message.getMarkers();
        List<BigInteger> markers = null;
        if (markerList != null) {
            markers = markerList.stream().map(Marker::getId).toList();
        }
        return Optional.ofNullable(IssueResponseTo.builder()
                .id(message.getId())
                .title(message.getTitle())
                .userId(message.getUser().getId())
                .content(message.getContent())
                .created(message.getCreated())
                .modified(message.getModified())
                .markers(markers)
                .build());
    }
}
