package com.example.springbootpractice.mapper;

import com.example.springbootpractice.model.ArticleVO;
import com.example.springbootpractice.model.SearchVO;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface BoardMapper {
    @Select("SELECT ARTICLE_ID, ARTICLE_TITLE, ARTICLE_WRITER, PUBLISHED_DATE FROM article ORDER BY ARTICLE_ID DESC")
    ArrayList<ArticleVO> selectAritlces(SearchVO searchVO);
    @Select("SELECT ARTICLE_ID, ARTICLE_TITLE, ARTICLE_WRITER, PUBLISHED_DATE FROM article WHERE ARTICLE_ID = (SELECT MAX(ARTICLE_ID) FROM article)")
    ArticleVO selectLatestArticle();
    @Insert("INSERT INTO article (ARTICLE_TITLE, ARTICLE_WRITER) VALUES(#{articleTitle}, #{articleWriter})")
    void InsertArticle(ArticleVO articleVO);
    @Update("UPDATE article SET ARTICLE_TITLE = #{articleTitle} WHERE ARTICLE_ID = #{articleId}")
    void updateArticle(ArticleVO articleVO);
    @Select("SELECT ARTICLE_ID, ARTICLE_TITLE, ARTICLE_WRITER, PUBLISHED_DATE FROM article WHERE ARTICLE_ID = #{articleId}")
    ArticleVO selectArticleByID(String articleId);
    @Delete("DELETE FROM article WHERE ARTICLE_ID = #{articleId}")
    void deleteArticle(int articleId);
    @Select("SELECT COUNT(*) FROM article")
    int countRow();
}
