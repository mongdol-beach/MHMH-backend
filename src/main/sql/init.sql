-- situation insert
INSERT INTO situation values ('DATE', '소개팅', '5881F3', 'FFFFFF');
INSERT INTO situation values ('COMPANY', '회사', '5881F3', 'FFFFFF');
INSERT INTO situation values ('COFFEE', '커피챗', '5881F3', 'FFFFFF');
INSERT INTO situation values ('SMALL', '스몰토크', '5881F3', 'FFFFFF');
INSERT INTO situation values ('TOGETHER', '단체 모임', '5881F3', 'FFFFFF');
INSERT INTO situation values ('COUPLE', '커플', '5881F3', 'FFFFFF');

-- topic insert
START TRANSACTION;

INSERT INTO topic VALUES (1, '질문입니다.', 'DATE');
INSERT INTO topic_tip (topic_tip_id, title, topic_id) VALUES (1, '소제목 1입니다.', 1);
INSERT INTO topic_tip_contents (c_topic_tip_id, contents)
VALUES (1, 'Tip Content 1'),
       (1, 'Tip Content 2');
INSERT INTO topic_tip (topic_tip_id, title, topic_id) VALUES (2, '소제목 2입니다.', 1);
INSERT INTO topic_tip_contents (c_topic_tip_id, contents)
VALUES (2, 'Tip Content 1'),
       (2, 'Tip Content 2');

INSERT INTO topic VALUES (2, '다른 질문입니다.', 'DATE');
INSERT INTO topic_tip (topic_tip_id, title, topic_id) VALUES (3, '소제목 1입니다.', 2);
INSERT INTO topic_tip_contents (c_topic_tip_id, contents)
VALUES (3, 'Tip Content 1'),
       (3, 'Tip Content 2');

INSERT INTO topic VALUES (3, '또다른 질문입니다.', 'DATE');
INSERT INTO topic_tip (topic_tip_id, title, topic_id) VALUES (4, '소제목 1입니다.', 3);
INSERT INTO topic_tip_contents (c_topic_tip_id, contents)
VALUES (4, 'Tip Content 1'),
       (4, 'Tip Content 2');
INSERT INTO topic_tip (topic_tip_id, title, topic_id) VALUES (5, '소제목 2입니다.', 3);
INSERT INTO topic_tip_contents (c_topic_tip_id, contents)
VALUES (5, 'Tip Content 1'),
       (5, 'Tip Content 2');

INSERT INTO topic VALUES (4, '다른다른또다른질문입니다.', 'DATE');
INSERT INTO topic_tip (topic_tip_id, title, topic_id) VALUES (6, '소제목 1입니다.', 4);
INSERT INTO topic_tip_contents (c_topic_tip_id, contents)
VALUES (6, 'Tip Content 1'),
       (6, 'Tip Content 2');
INSERT INTO topic_tip (topic_tip_id, title, topic_id) VALUES (7, '소제목 2입니다.', 4);
INSERT INTO topic_tip_contents (c_topic_tip_id, contents)
VALUES (7, 'Tip Content 1'),
       (7, 'Tip Content 2');

INSERT INTO topic VALUES (5, '정말 다른 질문입니다.', 'DATE');
INSERT INTO topic_tip (topic_tip_id, title, topic_id) VALUES (8, '소제목 1입니다.', 5);
INSERT INTO topic_tip_contents (c_topic_tip_id, contents)
VALUES (8, 'Tip Content 1'),
       (8, 'Tip Content 2');
INSERT INTO topic_tip (topic_tip_id, title, topic_id) VALUES (9, '소제목 2입니다.', 5);
INSERT INTO topic_tip_contents (c_topic_tip_id, contents)
VALUES (9, 'Tip Content 1'),
       (9, 'Tip Content 2');

INSERT INTO topic VALUES (6, '새로운 질문입니다.', 'DATE');
INSERT INTO topic_tip (topic_tip_id, title, topic_id) VALUES (10, '소제목 1입니다.', 6);
INSERT INTO topic_tip_contents (c_topic_tip_id, contents)
VALUES (10, 'Tip Content 1'),
       (10, 'Tip Content 2');
INSERT INTO topic_tip (topic_tip_id, title, topic_id) VALUES (11, '소제목 2입니다.', 6);
INSERT INTO topic_tip_contents (c_topic_tip_id, contents)
VALUES (11, 'Tip Content 1'),
       (11, 'Tip Content 2');

INSERT INTO topic VALUES (7, '새로운 질문입니다.2', 'DATE');
INSERT INTO topic_tip (topic_tip_id, title, topic_id) VALUES (12, '소제목 1입니다.', 7);
INSERT INTO topic_tip_contents (c_topic_tip_id, contents)
VALUES (12, 'Tip Content 1'),
       (12, 'Tip Content 2');
INSERT INTO topic_tip (topic_tip_id, title, topic_id) VALUES (13, '소제목 2입니다.', 7);
INSERT INTO topic_tip_contents (c_topic_tip_id, contents)
VALUES (13, 'Tip Content 1'),
       (13, 'Tip Content 2');

END;