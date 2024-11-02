package com.zxw.domain;

import lombok.Data;

@Data
public class CharacterResponse {
    private  int id;
    private String name;
    private String roleHigh;
    private String bodyDetail;
    private String clothes;
    private String belt;
    private String face;
    private String character;
    private int storyId;


    public CharacterResponse() {
    }
    public CharacterResponse(String name, String roleHigh, String bodyDetail, String clothes, String belt, String face, String character) {
        this.name = name;
        this.roleHigh = roleHigh;
        this.bodyDetail = bodyDetail;
        this.clothes = clothes;
        this.belt = belt;
        this.face = face;
        this.character = character;

    }


    // 构造函数、getter和setter省略...
}
