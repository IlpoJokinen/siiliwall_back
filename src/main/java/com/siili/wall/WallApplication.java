package com.siili.wall;

import com.siili.wall.Domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WallApplication {

    private static final Logger log = LoggerFactory.getLogger(WallApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WallApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BoardRepository brepository, ColumnRepository crepository, CardRepository ccrepository) {
        return (args) -> {

            crepository.save(new Column("Column1CLR", 0));
            crepository.save(new Column("Column2CLR", 0));



            log.info("nouto");
            for (Board board : brepository.findAll()) {
                log.info(board.toString());
            }

        };
    }

}