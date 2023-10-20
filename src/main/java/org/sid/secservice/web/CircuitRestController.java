package org.sid.secservice.web;

import org.sid.secservice.entities.Chauffeur;
import org.sid.secservice.entities.Circuit;
import org.sid.secservice.repo.CircuitRepository;
import org.sid.secservice.service.CircuitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CircuitRestController {
    private CircuitService circuitService;
    private CircuitRepository circuitRepository;

    public CircuitRestController(CircuitService circuitService) {
        this.circuitService = circuitService;
    }

    public CircuitRestController(CircuitRepository circuitRepository) {
        this.circuitRepository = circuitRepository;
    }
@Autowired
    public CircuitRestController(CircuitService circuitService, CircuitRepository circuitRepository) {
        this.circuitService = circuitService;
        this.circuitRepository = circuitRepository;
    }
    @PostMapping(path = "/addcircuit")
    public Circuit saveCircuit (@RequestBody Circuit circuit) {
        return circuitService.addNewCircuit(circuit);
    }
    @GetMapping(path = "/circuits")
    public List<Circuit> Circuits() {
        return circuitService.listCircuit();
    }
    @PutMapping("/update-circuit")
    public Circuit updateCircuit(@RequestBody Circuit circuit) {
        Circuit circuitsaved= circuitService.updateCircuit(circuit);
        return circuitsaved;
    }
    @DeleteMapping("/remove-circuit/{circuit-id}")
    public void removeCircuit(@PathVariable("circuit-id") Long id) {
        circuitService.removeCircuit(id);
    }

}
