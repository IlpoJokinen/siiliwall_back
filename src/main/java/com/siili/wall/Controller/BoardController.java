package com.siili.wall.Controller;



import com.siili.wall.Domain.Board;
import com.siili.wall.Domain.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
    @Autowired
    BoardRepository brepository;


    @RequestMapping(value="/boardlist")
    public String boardlist(Model model) {
        model.addAttribute("boards", brepository.findAll());
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

}
