package com.siili.wall.Controller;

import com.siili.wall.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    BoardRepository brepository;

    @Autowired
    ColumnRepository crepository;

    @Autowired
    CardRepository ccrepository;

    @RequestMapping(value="/boards")
    @CrossOrigin
    public @ResponseBody
    List<Board> boardListRest(){
        List<Board> boards = (List<Board>) brepository.findAll();
        return boards;
    }

    @RequestMapping(value="/board/{id}", method=RequestMethod.GET)
    @CrossOrigin
    public @ResponseBody
    Optional<Board> findBoardRest(@PathVariable("id") Long boardId){
        return brepository.findById(boardId);
    }

    @RequestMapping(value="/columns")
    @CrossOrigin
    public @ResponseBody
    List<Column> columnListRest(){
        return(List<Column>) crepository.findAll();
    }

    @RequestMapping(value="/column/{id}", method=RequestMethod.GET)
    @CrossOrigin
    public @ResponseBody
    Optional<Column> findColumnRest(@PathVariable("id") Long columnId){
        return crepository.findById(columnId);
    }

    @RequestMapping(value="/cards")
    @CrossOrigin
    public @ResponseBody
    List<Card> cardListRest(){
        return(List<Card>) ccrepository.findAll();
    }

    @RequestMapping(value="/card/{id}", method=RequestMethod.GET)
    @CrossOrigin
    public @ResponseBody
    Optional<Card> findCardRest(@PathVariable("id") String id){
        return ccrepository.findById(id);
    }

    //tämä on kesken!!
    //@RequestMapping(value="/boards/{id}/columns", method = RequestMethod.GET)
    //@CrossOrigin
    //public @ResponseBody
    //Optional<Column> getAllCommentsByPostId(@PathVariable ("id") Long boardId
    //                                            ) {
    //    return crepository.findById(boardId);
    //}


    //postamanilla voi postaa boardin
    @RequestMapping(value = "/boardpost", method=RequestMethod.POST)
    @CrossOrigin
    public  Board addNewBoard(@RequestBody Board board){
        return  brepository.save(board);
    }


    //postmanilla voi postaa columnin
    @RequestMapping(value = "/columnpost", method=RequestMethod.POST)
    @CrossOrigin
    public  Column addNewColumn(@RequestBody Column column){
        return  crepository.save(column);
    }


    //
    @RequestMapping(value = "/cardpost", method=RequestMethod.POST)
    @CrossOrigin
    public  Card addNewCard(@RequestBody Card card){
        return  ccrepository.save(card);
    }



    //boardin idn avulla voidaan lisätä column
    @RequestMapping(value="/boardss/{id}/columns", method=RequestMethod.POST)
    @CrossOrigin
    public Iterable<Column> boardsAddColumn(@PathVariable("id") Long boardId, @RequestBody Column column) {
        Optional<Board> board = brepository.findById(boardId);
        if (!board.get().hasColumn(column)) {
            board.get().getColumns().add(column);}
        brepository.save(board.get());
        brepository.findById(boardId);
        return crepository.findAll();
    }

    //columnin idn avulla voidaan lisätä card
    @RequestMapping(value="/columnss/{id}/cards", method=RequestMethod.POST)
    @CrossOrigin
    public Iterable<Card> columnsAddCard(@PathVariable("id") Long columnId, @RequestBody Card card) {
        Optional<Column> column = crepository.findById(columnId);
        if (!column.get().hasCard(card)) {
            column.get().getItems().add(card);}
        crepository.save(column.get());
        crepository.findById(columnId);
        return ccrepository.findAll();
    }

    //delete board
    @RequestMapping(value="/deleteboard/{id}", method=RequestMethod.DELETE)
    @CrossOrigin
    public Iterable<Board> deleteboard(@PathVariable("id") Long boardId) {
        brepository.deleteById(boardId);
        return brepository.findAll();
    }

    //delete column from board
    @RequestMapping(value="/board/{boardid}/deletecolumn/{columnid}", method=RequestMethod.DELETE)
    @CrossOrigin
    public Iterable<Board> deleteboardcolumn(@PathVariable("boardid") Long boardId, @PathVariable("columnid") Long columnId) {
        Optional<Column> column = crepository.findById(columnId);
        Optional<Board> board = brepository.findById(boardId);
        if (board.isPresent()) {
            board.get().getColumns().remove(column.get());
            crepository.deleteById(columnId);
            brepository.save(board.get());
            return brepository.findAll();
        }
        return brepository.findAll();

    }




}
