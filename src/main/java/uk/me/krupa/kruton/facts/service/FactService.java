package uk.me.krupa.kruton.facts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.me.krupa.kruton.facts.entity.Fact;
import uk.me.krupa.kruton.facts.repository.FactRepository;

@RestController
@RequestMapping("/api/fact")
public class FactService {

    @Autowired
    private FactRepository factRepository;

    @GetMapping(path = "/{name}", produces = "application/json")
    @ResponseBody
    public String getFact(@PathVariable("name") String name) {
        Fact byName = factRepository.findByName(name);
        return byName != null ? byName.getDefinition() : null;
    }

    @PostMapping(path = "/{name}", consumes = {"application/json", "text/plain"}, produces = "application/json")
    @ResponseBody
    public String addFact(@PathVariable("name") String name, @RequestBody String definition) {
        Fact existing = factRepository.findByName(name);
        if (existing == null) {
            factRepository.save(new Fact(name, definition));
            return "ADDED";
        } else {
            existing.setDefinition(definition);
            factRepository.save(existing);
            return "UPDATED";
        }
    }

}
