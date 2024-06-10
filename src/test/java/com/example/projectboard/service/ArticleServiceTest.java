package com.example.projectboard.service;

import com.example.projectboard.config.SecurityConfig;
import com.example.projectboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Import;

@DisplayName("비지니스 로직 - 게시글")
@Import(SecurityConfig.class)
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks private ArticleService sut;

    @Mock private ArticleRepository articleRepository;

    @DisplayName("게시글 조회 테스트")
    @Test
    void givenNothing_whenSearchingArticles_thenReturnsArticlesList() {
        // Given

        // When

        // Then
    }

    @DisplayName("게시글 생성 테스트")
    @Test
    void givenArticleInfo_whenSavingArticle_thenSavingArticle() {
        // Given

        // When

        // Then
    }

    @DisplayName("게시글 수정 테스트")
    @Test
    void givenArticleIdAndModifiedInfo_whenUpdatingArticle_thenUpdatesArticle() {
        // Given

        // When

        // Then
    }

    @DisplayName("게시글 삭제 테스트")
    @Test
    void givenArticleId_whenDeletingArticle_thenDeletesArticle() {
        // Given

        // When

        // Then
    }

}