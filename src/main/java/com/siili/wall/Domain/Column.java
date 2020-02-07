package com.siili.wall.Domain;

import javax.persistence.*;

@Entity(name="Column")
@Table(name="column")
public class Column {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long columnId;
    private String columnName;
    private int columnLimit;

    @ManyToOne
    @JoinColumn(name="boardId")
    private Board board;

    public Column(){}

    public Column(String columnName, int columnLimit, Board board){
        super();
        this.columnName=columnName;
        this.columnLimit=columnLimit;
        this.board = board;
    }

    public Long getColumnId() {
        return columnId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public int getColumnLimit() {
        return columnLimit;
    }

    public void setColumnLimit(int columnLimit) {
        this.columnLimit = columnLimit;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
