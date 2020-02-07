package com.siili.wall.Domain;

import javax.persistence.*;

@Entity(name="Sticker")
@Table(name="sticker")
public class Sticker {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long stickerId;
    private String stickerName;
    private String stickerDescription;
    private String stickerColor;
    private String stickerOwner;
    private int stickerSize;

    public Sticker(){}

    public Sticker(String stickerName, String stickerDescription, String stickerColor,String stickerOwner, int stickerSize){
        super();
        this.stickerName = stickerName;
        this.stickerDescription = stickerDescription;
        this.stickerColor = stickerColor;
        this.stickerOwner = stickerOwner;
        this.stickerSize = stickerSize;
    }

    // GETTERS
    public Long getStickerId() {
        return stickerId;
    }

    public String getStickerName() {
        return stickerName;
    }

    public String getStickerDescription() {
        return stickerDescription;
    }

    public String getStickerColor() {
        return stickerColor;
    }

    public String getStickerOwner() {
        return stickerOwner;
    }

    public int getStickerSize() {
        return stickerSize;
    }

    // SETTERS
    public void setStickerId(Long stickerId) {
        this.stickerId = stickerId;
    }

    public void setStickerName(String stickerName) {
        this.stickerName = stickerName;
    }

    public void setStickerDescription(String stickerDescription) {
        this.stickerDescription = stickerDescription;
    }

    public void setStickerColor(String stickerColor) {
        this.stickerColor = stickerColor;
    }

    public void setStickerOwner(String stickerOwner) {
        this.stickerOwner = stickerOwner;
    }

    public void setStickerSize(int stickerSize) {
        this.stickerSize = stickerSize;
    }

    @Override
    public String toString() {
        return "Sticker{" +
                "stickerId=" + stickerId +
                ", stickerName='" + stickerName + '\'' +
                ", stickerDescription='" + stickerDescription + '\'' +
                ", stickerColor='" + stickerColor + '\'' +
                ", stickerOwner='" + stickerOwner + '\'' +
                ", stickerSize='" + stickerSize + '\'' +
                '}';
    }
}