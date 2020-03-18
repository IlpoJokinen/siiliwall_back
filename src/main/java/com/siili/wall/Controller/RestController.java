package com.siili.wall.Controller;

import com.siili.wall.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value="/boards", method= RequestMethod.GET)
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

    @RequestMapping(value="/columns", method= RequestMethod.GET)
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

    @RequestMapping(value="/cards", method= RequestMethod.GET)
    @CrossOrigin
    public @ResponseBody
    List<Card> cardListRest(){
        return(List<Card>) ccrepository.findAll();
    }

    @RequestMapping(value="/card/{id}", method=RequestMethod.GET)
    @CrossOrigin
    public @ResponseBody
    Optional<Card> findCardRest(@PathVariable("id") Long cardId){
        return ccrepository.findById(cardId);
    }

    //tämä on kesken!!
    //@RequestMapping(value="/boards/{id}/columns", method = RequestMethod.GET)
    //@CrossOrigin
    //public @ResponseBody
    //Optional<Column> getAllCommentsByPostId(@PathVariable ("id") Long boardId
    //                                            ) {
    //    return crepository.findById(boardId);
    //}



}
