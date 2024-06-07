package com.example.projectboard.service;

import com.example.projectboard.dto.ArticleCommentDto;
import com.example.projectboard.dto.ArticleCommentUpdateDto;
import com.example.projectboard.repository.ArticleCommentRepository;
import com.example.projectboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleCommentService {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;


    public Page<ArticleCommentDto> searchArticleComments(Long articleId) {
        return Page.empty();
    }

    public void saveArticleComment(ArticleCommentDto dto) {

    }

    public void updateArticleComment(Long articleCommentId, ArticleCommentUpdateDto dto) {

    }

    public void deleteArticleComment(Long articleCommentId) {

    }
}
