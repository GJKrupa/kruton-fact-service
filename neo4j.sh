#!/usr/bin/env bash
docker run --rm -p7687:7687 -p7474:7474 -eNEO4J_AUTH=neo4j/neo4j2 --name=neo4j neo4j