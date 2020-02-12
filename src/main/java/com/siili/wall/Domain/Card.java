package com.siili.wall.Domain;

import javax.persistence.*;

@Entity(name="Card")
@Table(name="cards")
public class Card {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long cardId;
    private String cardName;
    private String cardDescription;
    private String cardColor;
    private String cardOwner;
    private int cardSize;
    private int cardDifficulty;

    @ManyToOne
    @JoinColumn(name="columnId")
    private Column column;

    public Card(){}

    public Card(String cardName, String cardDescription, String cardColor, String cardOwner, int cardSize, int cardDifficulty, Column column){
        super();
        this.cardName = cardName;
        this.cardDescription = cardDescription;
        this.cardColor = cardColor;
        this.cardOwner = cardOwner;
        this.cardSize = cardSize;
        this.cardDifficulty = cardDifficulty;
        this.column = column;
    }

    // GETTERS
    public Long getCardId() {
        return cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardDescription() {
        return cardDescription;
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
    public Column getColumn() {
        return column;
    }

    // SETTERS
    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public void setCardDescription(String cardDescription) {
        this.cardDescription = cardDescription;
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

    public void setColumn(Column column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId=" + cardId +
                ", cardName='" + cardName + '\'' +
                ", cardDescription='" + cardDescription + '\'' +
                ", cardColor='" + cardColor + '\'' +
                ", cardOwner='" + cardOwner + '\'' +
                ", cardSize='" + cardSize + '\'' +
                ", cardDifficulty='" + cardDifficulty + '\'' +
                '}';
    }
}