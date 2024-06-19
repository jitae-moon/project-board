package com.example.projectboard.controller;

import com.example.projectboard.config.SecurityConfig;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;

@DisplayName("View 컨트롤러 - 댓글")
@Import(SecurityConfig.class)
@WebMvcTest(ArticleCommentController.class)
class ArticleCommentControllerTest {

}