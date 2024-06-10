package com.example.projectboard.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
//@EntityListeners(AuditingEntityListener.class) // MappedSuperclass로 이동
@Entity // 기본 생성자 있어야 함(hibernate 기준)
public class Article extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL은 Identity 방식으로 Auto-increment 됨
    private Long id;

    @Setter @ManyToOne(optional = false) private UserAccount userAccount;

    // Setter를 클래스 레벨에 적용할 경우 id도 바뀔 수가 있음
    @Setter @Column(nullable = false) private String title; // 제목
    @Setter @Column(nullable = false, length = 10000) private String content; // 내용
    @Setter private String hashtag; // 해시태그

    @ToString.Exclude // 순환참조 방지
    @OrderBy("createdAt DESC")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL) // Article table로부터 왔다는 것 명시
    private final Set<ArticleComment> articleComments = new LinkedHashSet<>();

    // 공통 부분 추출 -> MappedSuperclass vs Embedded
//    @CreatedDate @Column(nullable = false) private LocalDateTime createdAt; // 생성일시
//    @CreatedBy @Column(nullable = false, length = 100) private String createdBy; // 생성자
//    @LastModifiedDate @Column(nullable = false) private LocalDateTime modifiedAt; // 수정일시
//    @LastModifiedBy @Column(nullable = false, length = 100) private String modifiedBy; // 수정자

    protected Article() {}

    private Article(UserAccount userAccount, String title, String content, String hashtag) {
        this.userAccount = userAccount;
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

    // Factory method pattern
    public static Article of(UserAccount userAccount, String title, String content, String hashtag) {
        return new Article(userAccount, title, content, hashtag);
    }

    // ID만 검사하면 동일한지 알 수 있음
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return id != null && id.equals(article.id); // DB에 아직 저장 안 되었을 때는 id가 null일 수 있음
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


