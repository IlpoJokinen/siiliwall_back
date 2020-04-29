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
    ItemRepository irepository;

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
    List<Item> cardListRest(){
        return(List<Item>) irepository.findAll();
    }

    @RequestMapping(value="/card/{id}", method=RequestMethod.GET)
    @CrossOrigin
    public @ResponseBody
    Optional<Item> findCardRest(@PathVariable("id") String id){
        return irepository.findById(id);
    }

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

    //postmanilla voi lisätä uuden kortin
    @RequestMapping(value = "/cardpost", method=RequestMethod.POST)
    @CrossOrigin
    public Item addNewCard(@RequestBody Item item){
        return  irepository.save(item);
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

    //columnin idn avulla voidaan lisätä item
    @RequestMapping(value="/columnss/{id}/cards", method=RequestMethod.POST)
    @CrossOrigin
    public Iterable<Item> columnsAddCard(@PathVariable("id") Long columnId, @RequestBody Item item) {
        Optional<Column> column = crepository.findById(columnId);
        if (!column.get().hasCard(item)) {
            column.get().getItems().add(item);}
        crepository.save(column.get());
        crepository.findById(columnId);
        return irepository.findAll();
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

    //delete card from column using columnname
    @RequestMapping(value="/{columnid}/deletecard/{id}", method=RequestMethod.DELETE)
    @CrossOrigin
    public Iterable<Column> deletecolumncard(@PathVariable("columnid") Long columnId, @PathVariable("id") String id) {
        Optional<Item> item = irepository.findById(id);
        Optional<Column> column = crepository.findById(columnId);
        if (column.isPresent()) {
            column.get().getItems().remove(item.get());
            irepository.deleteById(id);
            crepository.save(column.get());
            return crepository.findAll();
        }
        return crepository.findAll();
    }

    //edit board
    @RequestMapping(value="/editboard/{id}", method = RequestMethod.PUT)
    @CrossOrigin
    public Iterable<Board> editboard(@PathVariable("id") Long boardId, @RequestBody Board board) {
        brepository.findById(boardId);
        brepository.save(board);
        return brepository.findAll();
    }

    //edit column
    @RequestMapping(value="/editcolumn/{id}", method = RequestMethod.PUT)
    @CrossOrigin
    public Iterable<Column> editcolumn(@PathVariable("id") Long columnId, @RequestBody Column column) {
        crepository.findById(columnId);
        crepository.save(column);
        return crepository.findAll();
    }


    //itemin paikkaa voidaan vaihtaa kolumnista toiseen
    @RequestMapping(value="/{columnidstart}/removecard/{id}/moveto/{columniddestination}/{index}", method = RequestMethod.GET)
    @CrossOrigin
    public Iterable<Column> removecard(@PathVariable("columnidstart") Long columnIdStart, @PathVariable("columniddestination") Long columnIdDestination, @PathVariable("id") String id, @PathVariable("index") int index) {
        Optional<Item> item = irepository.findById(id);
        Optional<Column> columnstart = crepository.findById(columnIdStart);
        Optional<Column> columndestination = crepository.findById(columnIdDestination);
        if (columnstart.isPresent()) {
            columnstart.get().getItems().remove(item.get());
            irepository.deleteById(id);
            crepository.save(columnstart.get());
            columndestination.get().getItems().add(index,item.get());
            crepository.save(columndestination.get());
            return crepository.findAll();
        }
        return crepository.findAll();
    }
}
