package com.siili.wall.Domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Column")
@Table(name="columns")
public class Column {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long columnId;
    private String columnName;
    private int columnLimit;

    @ManyToMany(mappedBy = "columns")
    private List<Board> boards = new ArrayList<>();

    public Column(){}

    public Column(String columnName, int columnLimit){
        super();
        this.columnName=columnName;
        this.columnLimit=columnLimit;
    }

    // GETTERS
    public Long getColumnId() {
        return columnId;
    }

    public String getColumnName() {
        return columnName;
    }

    public int getColumnLimit() { return columnLimit; }

    public List<Board> getBoards() {
        return boards;
    }

    // SETTERS
    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public void setColumnLimit(int columnLimit) {
        this.columnLimit = columnLimit;
    }

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }

    @Override
    public String toString() {
        return "Column{" +
                "columnId=" + columnId +
                ", columnName='" + columnName + '\'' +
                ", columnLimit='" + columnLimit + '\'' +
                '}';
    }
}
