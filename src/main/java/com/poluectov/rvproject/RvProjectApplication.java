package com.poluectov.rvproject;

import com.poluectov.rvproject.dto.issue.IssueRequestTo;
import com.poluectov.rvproject.dto.marker.MarkerRequestTo;
import com.poluectov.rvproject.dto.message.MessageRequestTo;
import com.poluectov.rvproject.dto.user.UserRequestTo;
import com.poluectov.rvproject.model.Marker;
import com.poluectov.rvproject.repository.IssueRepository;
import com.poluectov.rvproject.repository.MarkerRepository;
import com.poluectov.rvproject.repository.MessageRepository;
import com.poluectov.rvproject.repository.UserRepository;
import com.poluectov.rvproject.repository.inmemory.InMemoryMarkerRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
public class RvProjectApplication {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        SpringApplication.run(RvProjectApplication.class, args);
    }



}
