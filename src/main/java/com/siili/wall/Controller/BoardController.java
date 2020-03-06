package com.siili.wall.Controller;



import com.siili.wall.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class BoardController {
    @Autowired
    BoardRepository brepository;

    @Autowired
    ColumnRepository crepository;

    @Autowired
    CardRepository ccrepository;


    @RequestMapping(value="/boardlist")
    public String boardlist(Model model) {
        model.addAttribute("boards", brepository.findAll());
        model.addAttribute( "column", new Column());
        model.addAttribute("columns", crepository.findAll());
        model.addAttribute("card", new Card());
        model.addAttribute("cards", ccrepository.findAll());
        return "boardlist";
    }

    @RequestMapping(value="/newboard", method= RequestMethod.GET)
    public String newboard(Model model) {
        model.addAttribute("board", new Board());
        return "newboard";
    }

    @RequestMapping(value="/saveboard" ,method=RequestMethod.POST)
    public String saveboard(Board board) {
        brepository.save(board);
        return "redirect:boardlist";
    }

    //This operator saves a column into a board
    @RequestMapping(value="/boards/{id}/columns", method=RequestMethod.GET)
    @CrossOrigin
    public String boardsAddColumn(@PathVariable("id") Long boardId, @PathVariable("id") Long columnId, Model model, Column column) {
        Optional<Board> board = brepository.findById(boardId);
        if (!board.get().hasColumn(column)) {
            board.get().getColumns().add(column);}
        brepository.save(board.get());
        model.addAttribute("board", brepository.findById(boardId));
        model.addAttribute("columns", crepository.findAll());
        return "redirect:/boardlist";
    }

    //This operator saves a card into a column
    @RequestMapping(value="/columns/{id}/cards", method=RequestMethod.GET)
    @CrossOrigin
    public String columnsAddCard(@PathVariable("id") Long columnId, @PathVariable("id") Long cardId, Model model, Card card) {
        Optional<Column> column = crepository.findById(columnId);
        if (!column.get().hasCard(card)) {
            column.get().getCards().add(card);}
        crepository.save(column.get());
        model.addAttribute("column", crepository.findById(columnId));
        model.addAttribute("cards", ccrepository.findAll());
        return "redirect:/boardlist";
    }

}
