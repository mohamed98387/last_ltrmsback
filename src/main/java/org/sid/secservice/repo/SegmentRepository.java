package org.sid.secservice.repo;

import org.sid.secservice.entities.PlantSection;
import org.sid.secservice.entities.Segment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SegmentRepository extends JpaRepository<Segment,Long> {
    Segment findSegmentBynomSegment(String nomSegment);
}
