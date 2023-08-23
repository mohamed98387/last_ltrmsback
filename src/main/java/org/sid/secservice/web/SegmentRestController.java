package org.sid.secservice.web;

import org.sid.secservice.entities.PlantSection;
import org.sid.secservice.entities.Segment;
import org.sid.secservice.repo.SegmentRepository;
import org.sid.secservice.service.SegmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SegmentRestController {
    private SegmentService segmentService;
    private SegmentRepository segmentRepository;

    public SegmentRestController(SegmentService segmentService) {
        this.segmentService = segmentService;
    }

    public SegmentRestController(SegmentRepository segmentRepository) {
        this.segmentRepository = segmentRepository;
    }

    @Autowired
    public SegmentRestController(SegmentService segmentService, SegmentRepository segmentRepository) {
        this.segmentService = segmentService;
        this.segmentRepository = segmentRepository;
    }
    @PostMapping(path = "/addsegment")
    public Segment saveSegment (@RequestBody Segment segment) {
        return segmentService.addNewSegment(segment);
    }
    @GetMapping(path = "/Segments")
    public List<Segment> Segments() {
        return segmentService.listSegment();
    }
    @PutMapping("/update-Segment")
    public Segment updateSegment(@RequestBody Segment segment) {
        Segment segmentsaved= segmentService.updateSegment(segment);
        return segmentsaved;
    }
    @DeleteMapping("/remove-segment/{segment-id}")
    public void removeSegment(@PathVariable("segment-id") Long id) {
        segmentService.removeSegment(id);
    }
    @GetMapping(path = "/findSegmentBynomSegment/{nomSegment}")
    public Segment findSegmentBynomSegment(@PathVariable("nomSegment") String nomSegment) {
        return segmentService.findSegmentBynomSegment(nomSegment);
    }

}
