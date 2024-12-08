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

END;