package com.siili.wall.Domain;

import javax.persistence.*;
import java.util.List;

@Entity(name="Column")
@Table(name="columns")
public class Column {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long columnId;
    private String columnName;
    private int columnLimit;

    @ManyToOne
    @JoinColumn(name="boardId")
    private Board board;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="column")
    private List<Card> cards;

    public Column(){}

    public Column(String columnName, int columnLimit, Board board, List<Card> cards){
        super();
        this.columnName=columnName;
        this.columnLimit=columnLimit;
        this.board = board;
        this.cards = cards;
    }

    // GETTERS
    public Long getColumnId() {
        return columnId;
    }

    public String getColumnName() {
        return columnName;
    }

    public int getColumnLimit() { return columnLimit; }

    public Board getBoard() {
        return board;
    }

    public List<Card> getCards() {
        return cards;
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

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Column{" +
                "columnId=" + columnId +
                ", columnName='" + columnName + '\'' +
                ", columnLimit='" + columnLimit + '\'' +
                ", board='" + board + '\'' +
                ", List<Card>='" + cards + '\'' +
                '}';
    }
}
