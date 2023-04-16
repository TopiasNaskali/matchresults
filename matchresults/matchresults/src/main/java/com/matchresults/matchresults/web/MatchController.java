package com.matchresults.matchresults.web;

//import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;

import com.matchresults.matchresults.domain.Match;
import com.matchresults.matchresults.domain.MatchRepository;
import com.matchresults.matchresults.domain.Referee;
import com.matchresults.matchresults.domain.RefereeRepository;

@Controller
public class MatchController {
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private RefereeRepository refereeRepository;

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    // Get all
    @RequestMapping(value = { "", "/", "matchlist" })
    public String MatchList(Model model) {
        model.addAttribute("matches", matchRepository.findAll());
        return "matchlist";
    }

    /*
     * // RESTful service to get all matches
     * 
     * @RequestMapping(value = "/matches")
     * public @ResponseBody List<Match> matchListRest() {
     * return (List<Match>) matchRepository.findAll();
     * }
     * 
     * // RESTful service to get match by id
     * 
     * @RequestMapping(value = "/match/{id}", method = RequestMethod.GET)
     * public @ResponseBody Optional<Match> findMatchRest(@PathVariable("id") Long
     * matchId) {
     * return matchRepository.findById(matchId);
     * }
     * 
     * // RESTful service to get all referees
     * 
     * @RequestMapping(value = "/referees")
     * public @ResponseBody List<Referee> refereeListRest() {
     * return (List<Referee>) refereeRepository.findAll();
     * }
     * 
     * // RESTful service to get referee by id
     * 
     * @RequestMapping(value = "/referee/{id}", method = RequestMethod.GET)
     * public @ResponseBody Optional<Referee> findRefereeRest(@PathVariable("id")
     * Long refereeId) {
     * return refereeRepository.findById(refereeId);
     * }
     */

    // Save matches
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveMatch(Match match, Model model) {
        matchRepository.save(match);
        return "redirect:/matchlist";
    }

    // Add a new match
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addMatch(Model model) {
        model.addAttribute("match", new Match());
        model.addAttribute("referees", refereeRepository.findAll());

        return "addmatch";
    }

    // Delete match
    @RequestMapping(value = "/delete/{matchId}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteMatch(@PathVariable("matchId") Long matchId, Model model) {
        matchRepository.deleteById(matchId);
        return "redirect:/matchlist";
    }

    // Edit match
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editMatch(@PathVariable("id") Long matchId, Model model) {
        model.addAttribute("match", matchRepository.findById(matchId));
        model.addAttribute("referees", refereeRepository.findAll());
        return "editmatch";
    }

    // Update
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Match match) {
        matchRepository.save(match);
        return "redirect:matchlist";
    }

    // Referee:
    // Get all referees
    @RequestMapping(value = { "refereelist" })
    public String refereeList(Model model) {
        model.addAttribute("referees", refereeRepository.findAll());
        return "refereelist";
    }

    // Save Referee
    @RequestMapping(value = "/savereferee", method = RequestMethod.POST)
    public String saveReferee(Referee referee, Model model) {
        refereeRepository.save(referee);
        return "redirect:/refereelist";
    }

    // Add a new referee
    @RequestMapping(value = "/addreferee", method = RequestMethod.GET)
    public String addReferee(Model model) {
        model.addAttribute("referee", new Referee());
        return "addreferee";
    }

    // Delete referee
    /*
     * @RequestMapping(value = "/deletereferee/{refereeId}", method =
     * RequestMethod.GET)
     * 
     * @PreAuthorize("hasAuthority('ADMIN')")
     * public String deleteReferee(@PathVariable("refereeId") Long refereeId,
     * Model model) {
     * refereeRepository.deleteById(refereeId);
     * return "redirect:/refereelist";
     * }
     */
    @RequestMapping(value = "/deletereferee/{refereeId}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteReferee(@PathVariable("refereeId") Long refereeId, Model model) {
        model.addAttribute("matches", refereeRepository.findById(refereeId).get().getMatches());
        try {
            refereeRepository.deleteById(refereeId);
            return "redirect:/refereelist";
        } catch (RuntimeException ex) {
            return "error";
        }
    }

    // Edit referee
    @RequestMapping(value = "/editreferee/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editReferee(@PathVariable("id") Long refereeId, Model model) {
        model.addAttribute("referee", refereeRepository.findById(refereeId));
        return "editreferee";
    }

}
