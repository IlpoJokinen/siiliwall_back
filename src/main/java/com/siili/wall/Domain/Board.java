package com.siili.wall.Domain;

import javax.persistence.*;
import java.util.List;

@Entity(name="Board")
@Table(name="board")
public class Board {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long boardId;
    private String boardName;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="board")
    private List<Column> columns;


    public Board(){}

    public Board(String boardName, List<Column> columns){
        super();
        this.boardName = boardName;
        this.columns = columns;
    }

    // GETTERS
    public Long getBoardId() {
        return boardId;
    }

    public String getBoardName() {
        return boardName;
    }

    // SETTERS
    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
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
                "boardId=" + boardId +
                ", boardName='" + boardName + '\'' +
                '}';
    }
}
