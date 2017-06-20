package com.william.model;

import org.springframework.stereotype.Component;

@Component
public class TitleSearch {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}