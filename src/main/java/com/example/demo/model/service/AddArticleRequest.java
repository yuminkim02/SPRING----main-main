package com.example.demo.model.service;

import lombok.*;

import com.example.demo.model.domain.Board; // 어노테이션 자동 생성

@NoArgsConstructor // 기본 생성자 추가
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자 추가
@Data // getter, setter, toString, equals 등 자동 생성
public class AddArticleRequest {
    private String title;
    private String content;
    private String user;
    private String newdate;
    private String count;
    private String likec;

    public Board toEntity(){ // Article 객체 생성
        return Board.builder()
            .title(title)
            .content(content)
            .user(user)
            .newdate(newdate)
            .count(count)
            .likec(likec)
            .build();
    }
}
