package com.example.springbootpractice.controller;

import com.example.springbootpractice.model.ArticleVO;
import com.example.springbootpractice.model.SearchVO;
import com.example.springbootpractice.service.BoardService;
import com.example.springbootpractice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/article")
public class BoardController {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    BoardService boardService;

    //페이지 로딩
    @GetMapping("")
    public ModelAndView list(){
        return new ModelAndView("board");
    }
    //모든 리소스 취득
    @GetMapping("/load")
    public ResponseEntity<List<ArticleVO>> loadList(){
        SearchVO searchVO = new SearchVO();
        List<ArticleVO> list = boardService.selectArticles(searchVO);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    //리소스 생성 (CREAT)
    /*@PostMapping("")
    public ResponseEntity<ArticleVO> writeArticle(@RequestBody ArticleVO articleVO){
        ArticleVO articleVO = boardService.InsertArticle(articleVO);
        return ResponseEntity.status(HttpStatus.CREATED).body(articleVO);
    }*/

    //특정 리소스 삭제
    @DeleteMapping("/delete/{articleId}")
    public ResponseEntity<Object> delete(@PathVariable("articleId") int articleId){
        boardService.deleteArticle(articleId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
