package com.example.projectboard.service;

import com.example.projectboard.domain.ArticleComment;
import com.example.projectboard.dto.ArticleCommentDto;
import com.example.projectboard.dto.ArticleCommentUpdateDto;
import com.example.projectboard.repository.ArticleCommentRepository;
import com.example.projectboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

@DisplayName("비지니스 로직 - 댓글")
@ExtendWith(MockitoExtension.class)
class ArticleCommentServiceTest {

    @InjectMocks private ArticleCommentService sut;

    @Mock private ArticleRepository articleRepository;
    @Mock private ArticleCommentRepository articleCommentRepository;

    @DisplayName("댓글 리스트 조회")
    @Test
    void givenArticleId_whenSearchingArticleComments_thenReturnsArticleCommentsList() {
        // Given
        Long articleId = 1L;

        // When
        Page<ArticleCommentDto> articleComments = sut.searchArticleComments(articleId);

        // Then
        assertThat(articleComments).isNotNull();
    }

    @DisplayName("댓글 생성 테스트")
    @Test
    void givenArticleCommentInfo_whenSavingArticleComment_thenSavingArticleComment() {
        // Given
        given(articleCommentRepository.save(any(ArticleComment.class))).willReturn(null);

        // When
        sut.saveArticleComment(ArticleCommentDto.of("test content", LocalDateTime.now(), "test createdBy"));

        // Then
        then(articleCommentRepository).should().save(any(ArticleComment.class));
    }

    @DisplayName("댓글 수정 테스트")
    @Test
    void givenArticleCommentIdAndModifiedInfo_whenUpdatingArticleComment_thenUpdatesArticleComment() {
        // Given
        Long articleCommentId = 1L;
        given(articleCommentRepository.save(any(ArticleComment.class))).willReturn(null);

        // When
        sut.updateArticleComment(articleCommentId, ArticleCommentUpdateDto.of("test content"));

        // Then
        then(articleCommentRepository).should().save(any(ArticleComment.class));
    }

    @DisplayName("댓글 삭제 테스트")
    @Test
    void givenArticleCommentId_whenDeletingArticleComment_thenDeletesArticleComment() {
        // Given
        Long articleCommentId = 1L;
        willDoNothing().given(articleCommentRepository).delete(any(ArticleComment.class));

        // When
        sut.deleteArticleComment(articleCommentId);

        // Then
        then(articleCommentRepository).should().delete(any(ArticleComment.class));
    }
}