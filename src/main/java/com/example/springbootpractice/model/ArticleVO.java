package com.example.springbootpractice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ArticleVO {
    private String  articleId;
    private String  articleTitle;
    private String  articleWriter;
    private Date    publishedDate;

    public ArticleVO(String articleTitle, String articleWriter){
        this.articleTitle = articleTitle;
        this.articleWriter = articleWriter;
    }
}
