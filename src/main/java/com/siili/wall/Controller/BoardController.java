package com.siili.wall.Controller;



import com.siili.wall.Domain.Board;
import com.siili.wall.Domain.BoardRepository;
import com.siili.wall.Domain.Column;
import com.siili.wall.Domain.ColumnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


    @RequestMapping(value="/boardlist")
    public String boardlist(Model model) {
        model.addAttribute("boards", brepository.findAll());
        model.addAttribute( "column", new Column());
        model.addAttribute("columns", crepository.findAll());
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

    @RequestMapping(value="/boards/{id}/columns", method=RequestMethod.GET)
    public String boardsAddColumn(@PathVariable("id") Long boardId, @PathVariable("id") Long columnId, Model model, Column column) {
        Optional<Board> board = brepository.findById(boardId);
        if (!board.get().hasColumn(column)) {
            board.get().getColumns().add(column);}
        brepository.save(board.get());
        model.addAttribute("board", brepository.findById(boardId));
        model.addAttribute("columns", crepository.findAll());
        return "redirect:/boardlist";
    }

}
