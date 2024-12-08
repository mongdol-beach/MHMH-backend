-- situation insert
INSERT INTO situation values ('DATE', '소개팅', '5881F3', 'FFFFFF');
INSERT INTO situation values ('COMPANY', '회사', '5881F3', 'FFFFFF');
INSERT INTO situation values ('COFFEE', '커피챗', '5881F3', 'FFFFFF');
INSERT INTO situation values ('SMALL', '스몰토크', '5881F3', 'FFFFFF');
INSERT INTO situation values ('TOGETHER', '단체 모임', '5881F3', 'FFFFFF');
INSERT INTO situation values ('COUPLE', '커플', '5881F3', 'FFFFFF');

-- INSERT INTO topic_tip (topic_tip_id, title, topic_id) VALUES (1, '소제목 1입니다.', 1);
-- INSERT INTO topic_tip_contents (c_topic_tip_id, contents)
-- VALUES (1, 'Tip Content 1'),
--        (1, 'Tip Content 2');
-- INSERT INTO topic_tip (topic_tip_id, title, topic_id) VALUES (2, '소제목 2입니다.', 1);
-- INSERT INTO topic_tip_contents (c_topic_tip_id, contents)
-- VALUES (2, 'Tip Content 1'),
--        (2, 'Tip Content 2');

-- topic insert
START TRANSACTION;
INSERT INTO topic VALUES (1, '질문입니다.', 'DATE');
INSERT INTO topic VALUES (2, '다른 질문입니다.', 'DATE');
INSERT INTO topic VALUES (3, '또다른 질문입니다.', 'DATE');
INSERT INTO topic VALUES (4, '다른다른또다른질문입니다.', 'DATE');
INSERT INTO topic VALUES (5, '정말 다른 질문입니다.', 'DATE');
INSERT INTO topic VALUES (6, '새로운 질문입니다.', 'DATE');
INSERT INTO topic VALUES (7, '새로운 질문입니다.2', 'DATE');
INSERT INTO topic VALUES (8, '언제 반했어?', 'COUPLE');
INSERT INTO topic VALUES (9, '새로운 질문입니다.', 'DATE');
INSERT INTO topic VALUES (10, '새로운 질문입니다.2', 'DATE');
INSERT INTO topic VALUES (11, '언제 반했어?', 'COUPLE');
INSERT INTO topic VALUES (12, '언제 반했어?', 'COUPLE');
END;