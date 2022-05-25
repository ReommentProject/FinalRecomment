package com.example.recomment;

import com.google.gson.annotations.SerializedName;

public class Content {

    @SerializedName("thumbnail")
    private String thumbnail;

    @SerializedName("title")
    private String title;

    @SerializedName("content")
    private String content;


    public Content(String thumbnail, String title, String content) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.content = content;
    }

    public String getThumbnail() { return thumbnail; }
    public String getTitle() { return title; }
    public String getContent() {
        return content;
    }
}
