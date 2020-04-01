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
    public CommandLineRunner studentDemo(BoardRepository brepository, ColumnRepository crepository, CardRepository ccrepository) {
        return (args) -> {
            log.info("kokeilu");

            Board board = new Board("aaa");

            Column column1 = new Column("Spring Boot",1);
            Column column2 = new Column("Boot",50);

            board.getColumns().add(column1);
            board.getColumns().add(column2);

            column1.getBoards().add(board);
            column2.getBoards().add(board);

            //test
            //Card card1 = new Card("Card1","aaa","dddd","aaaa",1,5);
            //Card card2 = new Card("Card2","aaa","dddd","aaaa",1,5);

            //column1.getItems().add(card1);
            //column2.getItems().add(card2);

            //card1.getColumns().add(column1);
            //card2.getColumns().add(column1);

            brepository.save(board);

        };
        }
}