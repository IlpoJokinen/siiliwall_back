package com.siili.wall.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore
    private List<Board> boards = new ArrayList<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "column_card",
            joinColumns = @JoinColumn(name = "columnId"),
            inverseJoinColumns = @JoinColumn(name = "cardId")
    )
    private List<Card> cards = new ArrayList<>();

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

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public boolean hasCard(Card card) {
        for (Card columnCard: getCards()) {
            if (columnCard.getCardId() == card.getCardId()) {
                return true;
            }
        }
        return false;
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
