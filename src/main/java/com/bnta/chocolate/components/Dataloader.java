package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component //Allows spring to create a bean for you
//Application runner is used to execute the code after the spring boot application has started
public class Dataloader implements ApplicationRunner {

    @Autowired //Dependency injections (it means we don't have to new the objects)
    ChocolateRepository chocolateRepository;
    @Autowired
    EstateRepository estateRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Estate estate1 = new Estate("Nestle", "Switzerland");
        estateRepository.save(estate1);
        Estate estate2 = new Estate("Cadbury", "UK");
        estateRepository.save(estate2);

        Chocolate chocolate1 = new Chocolate("KitKat", 10, estate1);
        chocolateRepository.save(chocolate1);
        Chocolate chocolate2 = new Chocolate("Milkybar", 7, estate1);
        chocolateRepository.save(chocolate2);
        Chocolate chocolate3 = new Chocolate("Dairy Milk", 7, estate2);
        chocolateRepository.save(chocolate3);
        Chocolate chocolate4 = new Chocolate("Double Decker", 9, estate2);
        chocolateRepository.save(chocolate4);
    }
}
