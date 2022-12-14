package young.projectboard.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName(("View 컨트롤러 - 게시글"))
@WebMvcTest(ArticleController.class) // ArticleController 만 테스트
class ArticleControllerTest {
    
    private final MockMvc mvc;


    ArticleControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[view][GET] 게시글 리스트 ")
    @Test
    public void givenNothing_whenRequestingArticlesView_thenReturnsArticlesView() throws Exception{
        //Given

        //When & Then
        mvc.perform(get("/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("articles/index")) // 어떤 view 인지(= articles/index"가 맞는지) 검사
                .andExpect(model().attributeExists("articles"));
    }
    @Disabled("구현 중")
    @DisplayName("[view][GET] 게시글 상세 페이지")
    @Test
    void givenNothing_whenRequestingArticleView_thenReturnsArticlesView() throws Exception {
        //Given

        //When & Then
        mvc.perform(get("/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(view().name("articles/detail"))
                .andExpect(model().attributeExists("article"))
                .andExpect(model().attributeExists("articleComments"));
    }
    @Disabled("구현 중")
    @DisplayName("[view][GET] 게시글 검색 전용 페이지 ")
    @Test
    void givenNothing_whenRequestingArticleSearchView_thenReturnsArticlesSearchView() throws Exception {
        //Given

        //When & Then
        mvc.perform(get("/articles/search"))
                .andExpect(status().isOk())
                .andExpect(view().name("articles/search"))
                .andExpect(content().contentType(MediaType.TEXT_HTML));
    }
    @Disabled("구현 중")
    @DisplayName("[view][GET] 게시글 해시태그 검색 페이지 ")
    @Test
    void givenNothing_whenRequestingArticleHashtagView_thenReturnsArticlesHashtagView() throws Exception {
        //Given

        //When & Then
        mvc.perform(get("/articles/search-hashtag"))
                .andExpect(status().isOk())
                .andExpect(view().name("articles/search-hastag"))
                .andExpect(content().contentType(MediaType.TEXT_HTML));
    }

}