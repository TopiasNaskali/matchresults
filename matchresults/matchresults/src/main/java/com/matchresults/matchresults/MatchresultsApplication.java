package com.matchresults.matchresults;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.matchresults.matchresults.domain.MatchRepository;
import com.matchresults.matchresults.domain.AppUser;
import com.matchresults.matchresults.domain.AppUserRepository;
import com.matchresults.matchresults.domain.Match;
import com.matchresults.matchresults.domain.Referee;
import com.matchresults.matchresults.domain.RefereeRepository;

@SpringBootApplication
public class MatchresultsApplication {
	// private static final Logger log =
	// LoggerFactory.getLogger(MatchresultsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MatchresultsApplication.class, args);
	}

	@Bean
	public CommandLineRunner demodata(MatchRepository matchRepository, RefereeRepository refereeRepository,
			AppUserRepository urepository) {
		return (args) -> {

			// Teams
			Referee referee1 = new Referee("Johan Johansson");
			refereeRepository.save(referee1);
			Referee referee2 = new Referee("Pär Pärsson");
			refereeRepository.save(referee2);
			Referee referee3 = new Referee("Eric Eriksson");
			refereeRepository.save(referee3);
			Referee referee4 = new Referee("Alfred Alfredsson");
			refereeRepository.save(referee4);
			Referee referee5 = new Referee("Jussi Jussila");
			refereeRepository.save(referee5);

			// Matches
			Match ottelu1 = new Match("FC Bossit", 2, "FC Pomot", 1, referee1);
			matchRepository.save(ottelu1);
			Match ottelu2 = new Match("FC Rusinat", 1, "FC Pelicans", 1, referee2);
			matchRepository.save(ottelu2);
			Match ottelu3 = new Match("FC Omenat", 5, "FC Piirakat", 3, referee3);
			matchRepository.save(ottelu3);
			Match ottelu4 = new Match("FC Perunat", 4, "FC Porkkanat", 7, referee4);
			matchRepository.save(ottelu4);

			// Users,
			AppUser user1 = new AppUser("User", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("Admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C",
					"ADMIN");
			urepository.save(user1);
			urepository.save(user2);

		};
	}

}
