package uk.me.krupa.kruton.facts.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import uk.me.krupa.kruton.facts.entity.Fact;

public interface FactRepository extends GraphRepository<Fact> {

    Fact findByName(String name);

}
