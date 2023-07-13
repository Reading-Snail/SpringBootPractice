package com.example.springbootpractice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SearchVO {
    private String  SearchTitle;
    private String  SearchWriter;

    public SearchVO(String SearchTitle, String SearchWriter){
        this.SearchTitle = SearchTitle;
        this.SearchWriter = SearchWriter;
    }
}
