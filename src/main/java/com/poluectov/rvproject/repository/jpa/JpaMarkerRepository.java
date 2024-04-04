package com.poluectov.rvproject.repository.jpa;

import com.poluectov.rvproject.model.Marker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface JpaMarkerRepository extends CrudRepository<Marker, Long> {

    @Query("SELECT m FROM Marker m WHERE m.id IN (:ids)")
    List<Marker> findByIdIn(List<Long> ids);
}
