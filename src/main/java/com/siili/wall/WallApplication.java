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
    public CommandLineRunner studentDemo(BoardRepository brepository, ColumnRepository crepository, ItemRepository irepository) {
        return (args) -> {
            brepository.deleteAll();
            crepository.deleteAll();
            irepository.deleteAll();

            Board board = new Board("Board1");

            Column column1 = new Column((long) 11,"Column1",1);
            Column column2 = new Column((long) 5,"Column2",50);

            board.getColumns().add(column1);
            board.getColumns().add(column2);

            column1.getBoards().add(board);
            column2.getBoards().add(board);

            //test
            Item item1 = new Item("Card1","kortti1","sisältö1","vihreä","valtteri",9,345);
            Item item2 = new Item("Card2","kortti2","sisältö2","sininen","joonas",4,5789);

            column1.getItems().add(item1);
            column2.getItems().add(item2);

            item1.getColumns().add(column1);
            item2.getColumns().add(column1);

            brepository.save(board);

        };
        }
}