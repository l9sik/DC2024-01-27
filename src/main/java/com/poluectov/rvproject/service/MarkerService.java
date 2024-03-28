package com.poluectov.rvproject.service;

import com.poluectov.rvproject.dto.marker.MarkerRequestTo;
import com.poluectov.rvproject.dto.marker.MarkerResponseTo;
import com.poluectov.rvproject.model.Marker;
import com.poluectov.rvproject.repository.MarkerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MarkerService extends CommonRestService<Marker, MarkerRequestTo, MarkerResponseTo> {
    public MarkerService(MarkerRepository repository) {
        super(repository);
    }

    @Override
    Optional<MarkerResponseTo> mapResponseTo(Marker marker) {
        if (marker == null) {
            return Optional.empty();
        }
        return Optional.of(MarkerResponseTo.builder()
                .id(marker.getId())
                .name(marker.getName())
                .build());
    }

}
