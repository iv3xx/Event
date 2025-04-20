package com.example.app_Event_manager.dto;

import com.example.app_Event_manager.model.enums.DressCodeType;

public class DressCodeDTO {
    private DressCodeType type;
    private String comment;

    // геттеры и сеттеры
    public DressCodeType getType() {
        return type;
    }

    public void setType(DressCodeType type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
