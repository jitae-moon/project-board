-- UserAccount
insert into user_account (user_id, user_password, email, nickname, memo, created_at, created_by, modified_at, modified_by) values ('test id', 'test password', 'test email', 'test nickname', 'test memo', now(), 'test admin', now(), 'test admin');

-- Article(500)
insert into article (user_account_id, title, content, hashtag, created_at, created_by, modified_at, modified_by) values (1, 'nulla', 'Sed ante.', 'mauris', '2024-06-16', 'Lucio', '2024-04-15', 'Earle');

-- ArticleComment(1000)
insert into article_comment (user_account_id, article_id, content, created_at, created_by, modified_at, modified_by) values (1, 1, 'lorem vitae mattis nibh ligula', '2023-08-18', 'Irv', '2024-05-23', 'Dinnie');
