package com.matchresults.matchresults.web;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.matchresults.matchresults.domain.Match;
import com.matchresults.matchresults.domain.MatchRepository;
import com.matchresults.matchresults.domain.Referee;
import com.matchresults.matchresults.domain.RefereeRepository;

@RestController
public class RestMatchController {

    private static final Logger log = LoggerFactory.getLogger(RestMatchController.class);
    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private RefereeRepository refereeRepository;

    // return list of matches
    @GetMapping("/matches")
    public Iterable<Match> getMatches() {
        log.info("//fetch and return matches");
        return matchRepository.findAll();
    }

    // Add
    @PostMapping("matches")
    Match newMatch(@RequestBody Match newMatch) {
        log.info("save new match " + newMatch);

        return matchRepository.save(newMatch);
    }

    // Edit
    @PutMapping("/matches/{id}")
    Match editMatch(@RequestBody Match editedMatch, @PathVariable Long id) {
        log.info("edit match " + editedMatch);
        editedMatch.setMatchId(id);
        return matchRepository.save(editedMatch);

    }

    // Delete
    @DeleteMapping("/matches{id}")

    public Iterable<Match> deleteMatch(@PathVariable Long id) {
        log.info("delete match, id = " + id);
        matchRepository.deleteById(id);
        return matchRepository.findAll();
    }

    // Get specific mathc via id
    @GetMapping("/match/{id}")
    Optional<Match> getOneMatch(@PathVariable Long id) {

        log.info("find vaate, id = " + id);
        return matchRepository.findById(id);
    }

    // return list of referees
    @GetMapping("/referees")
    public Iterable<Referee> getReferees() {
        log.info("//fetch and return referees");
        return refereeRepository.findAll();
    }

    // Add
    @PostMapping("referees")
    Referee newReferee(@RequestBody Referee newReferee) {
        log.info("save new referee " + newReferee);

        return refereeRepository.save(newReferee);
    }

    // Edit
    @PutMapping("/referees/{id}")
    Referee editReferee(@RequestBody Referee editedReferee, @PathVariable Long id) {
        log.info("edit match " + editedReferee);
        editedReferee.setRefereeId(id);
        return refereeRepository.save(editedReferee);
    }

    // Delete
    @DeleteMapping("/referees{id}")

    public Iterable<Referee> deleteReferee(@PathVariable Long id) {
        log.info("delete referee, id = " + id);
        refereeRepository.deleteById(id);
        return refereeRepository.findAll();
    }

    // Get specific with id
    @GetMapping("/referee/{id}")
    Optional<Referee> getOneReferee(@PathVariable Long id) {

        log.info("find vaate, id = " + id);
        return refereeRepository.findById(id);
    }
}
