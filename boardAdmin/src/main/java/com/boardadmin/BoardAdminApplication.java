package com.boardadmin;

import com.boardadmin.entity.User;
import com.boardadmin.repository.BoardRepository;
import com.boardadmin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class BoardAdminApplication implements CommandLineRunner {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(BoardAdminApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
    }
}
