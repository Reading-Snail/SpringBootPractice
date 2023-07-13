package com.example.springbootpractice.service;

import com.example.springbootpractice.mapper.BoardMapper;
import com.example.springbootpractice.model.ArticleVO;
import com.example.springbootpractice.model.SearchVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BoardService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    BoardMapper boardMapper;
    public ArrayList<ArticleVO> selectArticles(SearchVO searchVO) {
        ArrayList<ArticleVO> list = new ArrayList<>();
        return boardMapper.selectAritlces(searchVO);
    }

    public ArticleVO selectLatestArticle(String articleTitle) {
        return boardMapper.selectLatestArticle();
    }

    public void InsertArticle(ArticleVO articleVO) {
        boardMapper.InsertArticle(articleVO);
    }

    public void updateArticle(ArticleVO articleVO) {
        boardMapper.updateArticle(articleVO);
    }
    public ArticleVO selectArticleByID(String articleId) {
        return boardMapper.selectArticleByID(articleId);
    }

    public void deleteArticle(int articleId) { boardMapper.deleteArticle(articleId);
    }

    public int countRow() { return boardMapper.countRow();
    }
}
