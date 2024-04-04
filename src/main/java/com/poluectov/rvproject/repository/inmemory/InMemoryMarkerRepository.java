package com.poluectov.rvproject.repository.inmemory;

import com.poluectov.rvproject.dto.marker.MarkerRequestTo;
import com.poluectov.rvproject.model.Marker;
import com.poluectov.rvproject.repository.MarkerRepository;
import com.poluectov.rvproject.utils.dtoconverter.DtoConverter;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;
import java.util.function.Function;

@Component
public class InMemoryMarkerRepository extends InMemoryRepository<Marker, MarkerRequestTo> implements MarkerRepository {
    public InMemoryMarkerRepository(DtoConverter<MarkerRequestTo, Marker> convert) {
        super(convert);
    }

    @Override
    public List<Marker> findAll(List<Long> markerIds) {
        if (markerIds == null){
            return null;
        }
        return data.values().stream().filter(marker -> markerIds.contains(marker.getId())).toList();
    }
}
