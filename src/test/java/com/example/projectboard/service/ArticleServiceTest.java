package com.example.projectboard.service;

import com.example.projectboard.config.SecurityConfig;
import com.example.projectboard.domain.Article;
import com.example.projectboard.dto.ArticleDto;
import com.example.projectboard.dto.ArticleUpdateDto;
import com.example.projectboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

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
        Page<ArticleDto> articles = sut.searchArticles();

        // Then
        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글 생성 테스트")
    @Test
    void givenArticleInfo_whenSavingArticle_thenSavingArticle() {
        // Given
        given(articleRepository.save(any(Article.class))).willReturn(null);

        // When
        sut.saveArticle(ArticleDto.of("test title", "test content", "test hashtag", LocalDateTime.now(), "test createdBy"));

        // Then
        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("게시글 수정 테스트")
    @Test
    void givenArticleIdAndModifiedInfo_whenUpdatingArticle_thenUpdatesArticle() {
        // Given
        Long articleId = 1L;
        given(articleRepository.save(any(Article.class))).willReturn(null);

        // When
        sut.updateArticle(articleId, ArticleUpdateDto.of("test title", "test content", "test hashtag"));

        // Then
        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("게시글 삭제 테스트")
    @Test
    void givenArticleId_whenDeletingArticle_thenDeletesArticle() {
        // Given
        Long articleId = 1L;
        willDoNothing().given(articleRepository).delete(any(Article.class));

        // When
        sut.deleteArticle(articleId);

        // Then
        then(articleRepository).should().delete(any(Article.class));
    }
}