package com.siili.wall.Domain;

import javax.persistence.*;
import java.util.List;

@Entity(name="Board")
@Table(name="board")
public class Board {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long boardid;
    private String boardname;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="board")
    private List<Column> columns;


    public Board(){}

    public Board(String boardname, List<Column> columns){
        super();
        this.boardname = boardname;
        this.columns = columns;
    }

    // GETTERS
    public Long getBoardid() {
        return boardid;
    }

    public String getBoardname() {
        return boardname;
    }

    // SETTERS
    public void setBoardid(Long boardid) {
        this.boardid = boardid;
    }

    public void setBoardname(String boardname) {
        this.boardname = boardname;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardid=" + boardid +
                ", boardname='" + boardname + '\'' +
                '}';
    }
}
