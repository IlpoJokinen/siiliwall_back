package com.siili.wall.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Column")
@Table(name="columns")
public class Column {
    @Id
    private Long columnId;
    private String name;
    private int columnLimit;

    @ManyToMany(mappedBy = "columns")
    @JsonIgnore
    private List<Board> boards = new ArrayList<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "column_card",
            joinColumns = @JoinColumn(name = "columnId"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<Item> items = new ArrayList<>();

    public Column(){}

    public Column(Long columnId, String name, int columnLimit){
        super();
        this.columnId=columnId;
        this.name=name;
        this.columnLimit=columnLimit;
    }

    // GETTERS
    public Long getColumnId() {
        return columnId;
    }

    public int getColumnLimit() { return columnLimit; }

    public List<Board> getBoards() {
        return boards;
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }


    // SETTERS
    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }

    public void setColumnLimit(int columnLimit) {
        this.columnLimit = columnLimit;
    }

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public boolean hasCard(Item item) {
        for (Item columnItem : getItems()) {
            if (columnItem.getId() == item.getId()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Column{" +
                "columnId=" + columnId +
                ", columnName='" + name + '\'' +
                ", columnLimit='" + columnLimit + '\'' +
                '}';
    }
}
