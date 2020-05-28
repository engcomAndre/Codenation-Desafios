package com.challenge;

import com.challenge.entity.Company;
import com.challenge.entity.User;
import com.challenge.repository.CompanyRepository;
import com.challenge.repository.UserRepository;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Arrays;

@EnableJpaAuditing
@SpringBootApplication
public class SpringOauth2Application implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringOauth2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        User userA = new User("fullName", "meninobom1@gmail.com", "nickname1", "1234");
        User userB = new User("fullName2", "meninobom2@gmail.com", "nickname2", "4321");

        userRepository.saveAll(Arrays.asList(userA, userB));

        Company companyA = new Company("company A","slug Comppany A");
        Company companyB = new Company("company B","slug Comppany B");

        companyRepository.saveAll(Arrays.asList(companyA,companyB));
    }
}
