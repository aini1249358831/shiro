package com.example.shiro2.menu;

import java.util.List;

public class PhotoButton extends AbstractButton {
    private String type = "pic_sysphoto";
    private String key;
    private List<SubButton> sub_button;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<SubButton> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<SubButton> sub_button) {
        this.sub_button = sub_button;
    }

    public PhotoButton(String name, String key) {
        super(name);
        setName(name);
       setSub_button(null);
       setKey(key);
        this.key = key;
    }
}
