package org.sid.secservice.service;

import org.sid.secservice.entities.PlantSection;
import org.sid.secservice.entities.Segment;

import java.util.List;

public interface SegmentService {
    Segment addNewSegment(Segment segment);
    List<Segment> listSegment();
    public Segment updateSegment(Segment segment);
    public void removeSegment(Long id);
    Segment findSegmentBynomSegment(String nomSegment);
}
