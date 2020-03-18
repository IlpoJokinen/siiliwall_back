package com.siili.wall.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Card")
@Table(name="cards")
public class Card {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String cardName;
    private String content;
    private String cardColor;
    private String cardOwner;
    private int cardSize;
    private int cardDifficulty;

    @ManyToMany(mappedBy = "items")
    @JsonIgnore
    private List<Column> columns = new ArrayList<>();

    public Card(){}

    public Card(String cardName, String content, String cardColor, String cardOwner, int cardSize, int cardDifficulty, Column column){
        super();
        this.cardName = cardName;
        this.content = content;
        this.cardColor = cardColor;
        this.cardOwner = cardOwner;
        this.cardSize = cardSize;
        this.cardDifficulty = cardDifficulty;

    }

    // GETTERS


    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardColor() {
        return cardColor;
    }

    public String getCardOwner() {
        return cardOwner;
    }

    public int getCardSize() {
        return cardSize;
    }

    public int getCardDifficulty() {
        return cardDifficulty;
    }

    public List<Column> getColumns() {
        return columns;
    }

    // SETTERS


    public void setCardName(String cardName) {
        this.cardName = cardName;
    }


    public void setCardColor(String cardColor) {
        this.cardColor = cardColor;
    }

    public void setCardOwner(String cardOwner) {
        this.cardOwner = cardOwner;
    }

    public void setCardSize(int cardSize) {
        this.cardSize = cardSize;
    }

    public void setCardDifficulty(int cardDifficulty) {
        this.cardDifficulty = cardDifficulty;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId=" + id +
                ", cardName='" + cardName + '\'' +
                ", cardDescription='" + content + '\'' +
                ", cardColor='" + cardColor + '\'' +
                ", cardOwner='" + cardOwner + '\'' +
                ", cardSize='" + cardSize + '\'' +
                ", cardDifficulty='" + cardDifficulty + '\'' +
                '}';
    }
}