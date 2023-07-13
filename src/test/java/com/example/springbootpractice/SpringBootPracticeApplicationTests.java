package com.example.springbootpractice;

import com.example.springbootpractice.model.ArticleVO;
import com.example.springbootpractice.model.SearchVO;
import com.example.springbootpractice.service.BoardService;
import com.example.springbootpractice.service.UserService;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@ContextConfiguration(classes = SpringBootPracticeApplication.class)
class SpringBootPracticeApplicationTests {
    @Autowired
    BoardService boardService;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @BeforeAll
    public static void beforeAll() {
        logger.info("@BeforeAll");
    }

    @AfterAll
    public static void AfterAll() {
        logger.info("@AfterAll");
    }

    @BeforeEach
    public void beforeEach() {
        logger.info("@BeforeEach");
    }

    @AfterEach
    public void AfterEach() {
        logger.info("@AfterEach");
    }

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("TDD for selectAll()")
    public void selectAllTest() {
        logger.info("=====TDD for selectAll()=====START=");
        SearchVO searchVO = new SearchVO("안","YUN");
        ArrayList<?> list = boardService.selectArticles(searchVO);
        assertFalse(list.isEmpty());
        logger.info("=====TDD for selectAll()======END==");
    }

    @Test
    @DisplayName("TDD for InsertArticle()")
    public void InsertArticleTest() {
        logger.info("=====TDD for InsertArticle()=====START=");
        ArticleVO expected = new ArticleVO("제목:안녕하세요", "abc");      // Input: expected
        boardService.InsertArticle(expected);                                               // process
        ArticleVO actual = boardService.selectLatestArticle(expected.getArticleTitle());    // Output: actual
        Assertions.assertEquals(expected.getArticleTitle(), actual.getArticleTitle());      // expected =? actual
        Assertions.assertEquals(expected.getArticleWriter(), actual.getArticleWriter());
        logger.info("=====TDD for InsertArticle()======END==");
    }

    /*@Test
    @DisplayName("TDD for updateArticle()")
    public void updateArticleTest() {
        logger.info("=====TDD for updateArticle()=====START=");
        // Input: expected
        ArticleVO expected = new ArticleVO();
        expected.setArticleId("4");
        expected.setArticleTitle("수정 된 글제목");
        // process
        boardService.updateArticle(expected);
        // Output: actual
        ArticleVO actual = boardService.selectArticleByID(expected.getArticleId());
        // Evaluate: expected =? actual
        Assertions.assertEquals(expected.getArticleId(), actual.getArticleId());
        Assertions.assertEquals(expected.getArticleTitle(), actual.getArticleTitle());
        logger.info("=====TDD for updateArticle()======END==");
    }*/
    @Test
    @DisplayName("TDD for deleteArticle()")
    public void deleteArticle(){
        logger.info("=====TDD for InsertArticle()=====START=");
        int expected = boardService.countRow();

        int articleId = 6;
        boardService.deleteArticle(articleId);                                               // process

        int actual = boardService.countRow();
        Assertions.assertEquals(expected -1 , actual);


        logger.info("=====TDD for InsertArticle()======END==");
    }
}
