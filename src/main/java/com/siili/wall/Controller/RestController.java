package com.siili.wall.Controller;

import com.siili.wall.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class RestController {

    @Autowired
    BoardRepository brepository;

    @Autowired
    ColumnRepository crepository;

    @Autowired
    CardRepository ccrepository;

    @RequestMapping(value="/boards", method= RequestMethod.GET)
    public @ResponseBody
    List<Board> boardListRest(){
        return(List<Board>) brepository.findAll();
    }

    @RequestMapping(value="/board/{id}", method=RequestMethod.GET)
    public @ResponseBody
    Optional<Board> findBoardRest(@PathVariable("id") Long boardId){
        return brepository.findById(boardId);
    }

    @RequestMapping(value="/columns", method= RequestMethod.GET)
    public @ResponseBody
    List<Column> columnListRest(){
        return(List<Column>) crepository.findAll();
    }

    @RequestMapping(value="/column/{id}", method=RequestMethod.GET)
    public @ResponseBody
    Optional<Column> findColumnRest(@PathVariable("id") Long columnId){
        return crepository.findById(columnId);
    }

    @RequestMapping(value="/cards", method= RequestMethod.GET)
    public @ResponseBody
    List<Card> cardListRest(){
        return(List<Card>) ccrepository.findAll();
    }

    //tämä on kesken
    @RequestMapping(value="/boards/{id}/columns", method = RequestMethod.GET)
    public @ResponseBody
    Optional<Column> getAllCommentsByPostId(@PathVariable ("id") Long boardId
                                                ) {
        return crepository.findById(boardId);
    }
}
