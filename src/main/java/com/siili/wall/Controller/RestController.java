package com.siili.wall.Controller;

import com.siili.wall.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
