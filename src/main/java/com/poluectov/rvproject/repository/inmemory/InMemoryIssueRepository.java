package com.poluectov.rvproject.repository.inmemory;

import com.poluectov.rvproject.dto.issue.IssueRequestTo;
import com.poluectov.rvproject.model.Issue;
import com.poluectov.rvproject.model.Marker;
import com.poluectov.rvproject.repository.IssueRepository;
import com.poluectov.rvproject.repository.MarkerRepository;
import com.poluectov.rvproject.repository.UserRepository;
import com.poluectov.rvproject.repository.exception.EntityNotFoundException;
import com.poluectov.rvproject.utils.dtoconverter.DtoConverter;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class InMemoryIssueRepository extends InMemoryRepository<Issue, IssueRequestTo> implements IssueRepository {

    private final UserRepository userRepository;
    private final MarkerRepository markerRepository;

    public InMemoryIssueRepository(DtoConverter<IssueRequestTo, Issue> convert,
                                   UserRepository userRepository,
                                   MarkerRepository markerRepository) {

        super(convert);
        this.userRepository = userRepository;
        this.markerRepository = markerRepository;
    }

    @Override
    public Issue save(IssueRequestTo issueRequestTo) throws EntityNotFoundException {
        additionalSaveUpdate(issueRequestTo);

        return super.save(issueRequestTo);
    }

    @Override
    public Issue update(IssueRequestTo issueRequestTo) throws EntityNotFoundException {
        additionalSaveUpdate(issueRequestTo);

        return super.update(issueRequestTo);
    }

    private void additionalSaveUpdate(IssueRequestTo issueRequestTo) throws EntityNotFoundException {
        //if there is no such user
        if (userRepository.findById(issueRequestTo.getUserId()) == null){
            throw new EntityNotFoundException("User with id " + issueRequestTo.getUserId() + " not found");
        }
        //if there is no such marker
        List<Long> markerIds = issueRequestTo.getMarkers();

        List<Marker> markers = markerRepository.findAll(markerIds);
        if (markers != null && markerIds != null
                && markers.size() != markerIds.size()){
            throw new EntityNotFoundException("Marker with id " + markerIds + " not found");
        }
    }
}
