package com.matchresults.matchresults.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RefereeRepository extends CrudRepository<Referee, Long> {

    List<Referee> findByName(String name);

}
