package com.siili.wall.Domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Board")
@Table(name="boards")
public class Board {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long boardId;
    private String boardName;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "board_column",
            joinColumns = @JoinColumn(name = "boardId"),
            inverseJoinColumns = @JoinColumn(name = "columnId")
    )
    private List<Column> columns = new ArrayList<>();

    public Board(){}

    public Board(String boardName){
        super();
        this.boardName = boardName;
    }

    // GETTERS
    public Long getBoardId() {
        return boardId;
    }

    public String getBoardName() {
        return boardName;
    }

    public List<Column> getColumns() {
        return columns;
    }

    // SETTERS
    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public boolean hasColumn(Column column) {
        for (Column boardColumn: getColumns()) {
            if (boardColumn.getColumnId() == column.getColumnId()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardId=" + boardId +
                ", boardName='" + boardName + '\'' +
                ", List<Column>='" + columns + '\'' +
                '}';
    }
}
