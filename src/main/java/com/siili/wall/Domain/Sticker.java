package com.siili.wall.Domain;

import javax.persistence.*;

@Entity(name="Sticker")
@Table(name="sticker")
public class Sticker {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long stickerId;
    private String stickerName;

    public Sticker(){}

    public Sticker(String stickerName){
        super();
        this.stickerName=stickerName;
    }

    public Long getStickerId() {
        return stickerId;
    }

    public String getStickerName() {
        return stickerName;
    }

    public void setStickerId(Long stickerId) {
        this.stickerId = stickerId;
    }

    public void setStickerName(String stickerName) {
        this.stickerName = stickerName;
    }
}