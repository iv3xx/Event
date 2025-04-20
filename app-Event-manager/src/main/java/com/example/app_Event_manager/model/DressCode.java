package com.example.app_Event_manager.model;
import com.example.app_Event_manager.model.enums.DressCodeType;

public class DressCode {
    private DressCodeType type;
    private String comment;

    public DressCode(DressCodeType type, String comment) {
        this.type = type;
        this.comment = comment;
    }

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
