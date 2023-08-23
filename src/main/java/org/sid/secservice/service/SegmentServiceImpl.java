package org.sid.secservice.service;

import org.sid.secservice.entities.PlantSection;
import org.sid.secservice.entities.Segment;
import org.sid.secservice.repo.PlantSectionRepository;
import org.sid.secservice.repo.SegmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SegmentServiceImpl implements SegmentService{
    private SegmentRepository segmentRepository;

    public SegmentServiceImpl(SegmentRepository segmentRepository) {
        this.segmentRepository = segmentRepository;
    }

    @Override
    public Segment addNewSegment(Segment segment) {
      return this.segmentRepository.save(segment);
    }

    @Override
    public List<Segment> listSegment() {
        return segmentRepository.findAll();
    }

    @Override
    public Segment updateSegment(Segment segment) {
        return  (Segment) segmentRepository.save(segment);
    }

    @Override
    public void removeSegment(Long id) {
        segmentRepository.deleteById(id);
    }

    @Override
    public Segment findSegmentBynomSegment(String nomSegment) {
        return segmentRepository.findSegmentBynomSegment(nomSegment);
    }
}
