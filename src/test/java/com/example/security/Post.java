package com.example.security;

import lombok.Data;

import java.util.Date;

@Data
public class Post {
    private Integer id;
    private Integer userId;
    private String title;
    private String body;
    private Date date;
}
