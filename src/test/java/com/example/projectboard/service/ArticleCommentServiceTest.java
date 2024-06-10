package com.example.projectboard.service;

import com.example.projectboard.domain.Article;
import com.example.projectboard.domain.ArticleComment;
import com.example.projectboard.domain.UserAccount;
import com.example.projectboard.repository.ArticleCommentRepository;
import com.example.projectboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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

        // When

        // Then
    }

    private ArticleComment createArticleComment(String content) {
        return ArticleComment.of(
                Article.of(createUserAccount(), "title", "content", "hashtag"),
                createUserAccount(),
                content
        );
    }

    private UserAccount createUserAccount() {
        return UserAccount.of(
                "test id",
                "test password",
                "test email",
                "test nickname",
                null
        );
    }

    @DisplayName("댓글 생성 테스트")
    @Test
    void givenArticleCommentInfo_whenSavingArticleComment_thenSavingArticleComment() {
        // Given

        // When

        // Then
    }

    @DisplayName("댓글 수정 테스트")
    @Test
    void givenArticleCommentIdAndModifiedInfo_whenUpdatingArticleComment_thenUpdatesArticleComment() {
        // Given

        // When

        // Then
    }

    @DisplayName("댓글 삭제 테스트")
    @Test
    void givenArticleCommentId_whenDeletingArticleComment_thenDeletesArticleComment() {
        // Given

        // When

        // Then
    }
}