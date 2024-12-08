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

TRUNCATE TABLE topic_tip RESTART IDENTITY CASCADE;

DELETE FROM topic; -- 임시 데이터 삭제
ROLLBACK; -- 트랜잭션 롤백

-- START TRANSACTION;
-- 스몰토크 토픽
START TRANSACTION;
INSERT INTO topic VALUES (1, '최근에 본 가장 웃긴 밈이 뭔가요?', 'SMALL');
INSERT INTO topic VALUES (2, '즐겨보는 드라마나 영화가 있나요?', 'SMALL');
INSERT INTO topic VALUES (3, '나만의 스트레스 해소법이 있다면?', 'SMALL');
INSERT INTO topic VALUES (4, '여행 가고싶은 나라가 있나요?', 'SMALL');
INSERT INTO topic VALUES (5, '요즘 즐기는 취미가 있나요?', 'SMALL');
INSERT INTO topic VALUES (6, '좋아하는 계절이 있나요?', 'SMALL');
INSERT INTO topic VALUES (7, '날씨가 ~하네요. 좋아하는 계절에 있나요?', 'SMALL');
INSERT INTO topic VALUES (8, '로또가 당첨되면 뭐할거에요?', 'SMALL');
INSERT INTO topic VALUES (9, '주말에 뭐하세요?', 'SMALL');
INSERT INTO topic VALUES (10, 'MBTI가 어떻게 되세요?', 'SMALL');
INSERT INTO topic VALUES (11, '좋아하는 연예인이 있나요?', 'SMALL');
INSERT INTO topic VALUES (12, '최근에 가장 만족스러웠던 소비는 무엇인가요?', 'SMALL');
INSERT INTO topic VALUES (13, '좋아하는 음식은 무엇인가요?', 'SMALL');
INSERT INTO topic VALUES (14, '선호하는 패션 스타일이 있나요?', 'SMALL');
INSERT INTO topic VALUES (15, '건강 관리 방법이 있나요?', 'SMALL');
INSERT INTO topic VALUES (16, '잠은 잘 주무시나요?', 'SMALL');
INSERT INTO topic VALUES (17, '만약에 내 눈앞에 모든 음식이 똥으로 보인다면?', 'SMALL');
INSERT INTO topic VALUES (18, '아침형 인간이세요?', 'SMALL');
INSERT INTO topic VALUES (19, '여행지 추천해주실 수 있나요?', 'SMALL');
INSERT INTO topic VALUES (20, '최근에 가장 뿌듯했던 순간이 있으세요?', 'SMALL');
INSERT INTO topic VALUES (21, '최근에 새로 배운게 있나요?', 'SMALL');

-- 단체 모임
INSERT INTO topic VALUES (22, '이 모임에 처음 온 사람이 있나요?', 'TOGETHER');
INSERT INTO topic VALUES (23, '처음 모인 순간을 기억하나요?', 'TOGETHER');
INSERT INTO topic VALUES (24, '단체로 여행 간다면 어디로 가고싶은가요?', 'TOGETHER');
INSERT INTO topic VALUES (25, '요즘 모임에 추가되었으면 하는 활동이 있나요?', 'TOGETHER');
INSERT INTO topic VALUES (26, '다음 모임 장소는 어디면 좋을까요?', 'TOGETHER');
INSERT INTO topic VALUES (27, '모임 이름으로 n행시를 지어주세요!', 'TOGETHER');
INSERT INTO topic VALUES (28, '모임에 공유하고 싶은 팁이 있다면?', 'TOGETHER');
INSERT INTO topic VALUES (29, '모임에 참여하게 된 계기가 뭔가요?', 'TOGETHER');
INSERT INTO topic VALUES (30, '보통 뭐 하면서 시간을 보내시나요?', 'TOGETHER');
INSERT INTO topic VALUES (31, '다른 취미 있으신가요?', 'TOGETHER');
INSERT INTO topic VALUES (32, '제일 만족스러웠던 활동이 뭔가요?', 'TOGETHER');
INSERT INTO topic VALUES (33, '이전에 다른 모임 참여해 보신적 있나요?', 'TOGETHER');
INSERT INTO topic VALUES (34, '우리 모임에 개선되었으면 하는 점 있나요?', 'TOGETHER');
INSERT INTO topic VALUES (35, '상상했던 것과 우리 모임이 비슷한가요?', 'TOGETHER');
INSERT INTO topic VALUES (36, '상상했던 것과 우리 모임이 다른 점이 있나요?', 'TOGETHER');
INSERT INTO topic VALUES (37, '우리 모임에 호감가는 사람이 있나요?', 'TOGETHER');
INSERT INTO topic VALUES (38, '우리 모임을 추천해주고 싶은 사람이 있나요?', 'TOGETHER');
INSERT INTO topic VALUES (39, '첫 인상이 어땠나요?', 'TOGETHER');
INSERT INTO topic VALUES (40, '첫인상과 다른 사람이 있나요?', 'TOGETHER');

-- 회사 토픽
INSERT INTO topic VALUES (41, '회사 주변 맛집 아세요?', 'COMPANY');
INSERT INTO topic VALUES (42, '출퇴근 시간 얼마나 걸리세요?', 'COMPANY');
INSERT INTO topic VALUES (43, '요즘 즐겨보는 유투버 있어요?', 'COMPANY');
INSERT INTO topic VALUES (44, '휴가 계획 있어요?', 'COMPANY');
INSERT INTO topic VALUES (45, '요즘에 즐기는 취미 있어요?', 'COMPANY');
INSERT INTO topic VALUES (46, '쉬는날엔 뭐하세요?', 'COMPANY');
INSERT INTO topic VALUES (47, '업무의 효율을 어떻게 끌어올리나요?', 'COMPANY');
INSERT INTO topic VALUES (48, '출퇴근 시간에 뭐 하세요?', 'COMPANY');
INSERT INTO topic VALUES (49, '회사에 나만 아는 스팟이 있나요?', 'COMPANY');
INSERT INTO topic VALUES (50, '점심 메뉴 고르는 꿀팁 있나요?', 'COMPANY');
INSERT INTO topic VALUES (51, '스트레스 해소법이 어떻게 되나요?', 'COMPANY');
INSERT INTO topic VALUES (52, '보통 퇴근하면 뭐 하시나요?', 'COMPANY');
INSERT INTO topic VALUES (53, '재택 근무와 출근 중 어떤 걸 선호하시나요?', 'COMPANY');
INSERT INTO topic VALUES (54, '요즘 일이 힘들진 않으신가요?', 'COMPANY');
INSERT INTO topic VALUES (55, '점심시간에 뭐 하시나요?', 'COMPANY');
INSERT INTO topic VALUES (56, '회사에 있었으면 하는 복지가 있나요?', 'COMPANY');
INSERT INTO topic VALUES (57, '보통 몇시쯤 일어나세요?', 'COMPANY');
INSERT INTO topic VALUES (58, '주말 잘 보내셨어요?', 'COMPANY');
INSERT INTO topic VALUES (59, '업무할때 노래 들으세요?', 'COMPANY');
INSERT INTO topic VALUES (60, '사무실 꿀템 추천해주세요!', 'COMPANY');

-- 커피챗 토픽
INSERT INTO topic VALUES (61, '요즘 주로 사용하는 앱이나 툴은 뭔가요?', 'COFFEE');
INSERT INTO topic VALUES (62, '평소에 인사이트는 어디서 얻으세요?', 'COFFEE');
INSERT INTO topic VALUES (63, '지금까지의 커피쳇 경험 중 가장 기억에 남은 순간이 있나요?', 'COFFEE');
INSERT INTO topic VALUES (64, '업무 중,요가장 긴장했던 순간이 있다면?', 'COFFEE');
INSERT INTO topic VALUES (65, '가장 해주고싶은 조언이 있을까요?', 'COFFEE');
INSERT INTO topic VALUES (66, '업무와 휴식을 어떻게 분리하나요?', 'COFFEE');
INSERT INTO topic VALUES (67, '가장 좋았던 워크숍 경험이 있다면?', 'COFFEE');
INSERT INTO topic VALUES (68, '최근 업계 트랜드는 어떻게 변하고 있나요?', 'COFFEE');
INSERT INTO topic VALUES (69, '요즘 관심있는 기술이 있다면?', 'COFFEE');
INSERT INTO topic VALUES (70, '추천하고 싶은 강의가 있다면?', 'COFFEE');
INSERT INTO topic VALUES (71, '최근에 가입한 유익한 커뮤니티가 있나요?', 'COFFEE');
INSERT INTO topic VALUES (72, '커뮤니케이션 팁이 있을까요?', 'COFFEE');
INSERT INTO topic VALUES (73, '다음 커리어 목표는 어떻게 되세요?', 'COFFEE');
INSERT INTO topic VALUES (74, '이 업계를 선택한 이유가 있나요?', 'COFFEE');
INSERT INTO topic VALUES (75, '스트레스 해소법이 있을까요?', 'COFFEE');
INSERT INTO topic VALUES (76, '번아웃이 온 적 있으세요?', 'COFFEE');
INSERT INTO topic VALUES (77, '이직 팁 있으세요?', 'COFFEE');
INSERT INTO topic VALUES (78, '회사 분위기는 어떤가요?', 'COFFEE');
INSERT INTO topic VALUES (79, '책 읽는 거 좋아하세요?', 'COFFEE');
INSERT INTO topic VALUES (80, '현재 직무에서 주로 어떤 일을 하시나요?', 'COFFEE');
INSERT INTO topic VALUES (81, '현재 직무를 선택하게 된 특별한 계기가 있으신가요?', 'COFFEE');

-- 소개팅 토픽
INSERT INTO topic VALUES (82, '휴가를 간다면 어디로 가고 싶으세요?', 'DATE');
INSERT INTO topic VALUES (83, '이상형이 어떻게 되세요?', 'DATE');
INSERT INTO topic VALUES (84, '취미가 어떻게 되세요?', 'DATE');
INSERT INTO topic VALUES (85, '좋아하는 동물 있으세요?', 'DATE');
INSERT INTO topic VALUES (86, '하시는 운동 있으세요?', 'DATE');
INSERT INTO topic VALUES (87, '가장 좋아하는 음식이 뭐예요?', 'DATE');
INSERT INTO topic VALUES (88, '자기 전엔 주로 무엇을 하시나요?', 'DATE');
INSERT INTO topic VALUES (89, 'MBTI가 어떻게 되세요?', 'DATE');
INSERT INTO topic VALUES (90, '어제 뭐 하셨어요?', 'DATE');
INSERT INTO topic VALUES (91, '어릴때 꿈이 무엇이었나요?', 'DATE');
INSERT INTO topic VALUES (92, '연애할 때 가장 중요하게 생각하는게 뭔가요?', 'DATE');
INSERT INTO topic VALUES (93, '어떻게 소개받게된 거에요?', 'DATE');
INSERT INTO topic VALUES (94, '첫만남에서 꼭 알고 싶은게 있으신가요?', 'DATE');
INSERT INTO topic VALUES (95, '일 하신지는 얼마나 되셨어요?', 'DATE');
INSERT INTO topic VALUES (96, '못 드시는 음식이 있으세요?', 'DATE');
INSERT INTO topic VALUES (97, '어떤 노래 좋아하세요?', 'DATE');
INSERT INTO topic VALUES (98, '쉴땐 주로 무엇을 하시나요?', 'DATE');
INSERT INTO topic VALUES (99, '요즘 행복하다고 느끼는 순간이 있나요?', 'DATE');
INSERT INTO topic VALUES (100, '커피 좋아하세요?', 'DATE');
INSERT INTO topic VALUES (101, '오시는 길은 괜찮으셨어요?', 'DATE');
INSERT INTO topic VALUES (102, '새로 배워보고 싶은거 있으세요?', 'DATE');
INSERT INTO topic VALUES (103, '보통 몇시에 출근하고 퇴근하세요?', 'DATE');
INSERT INTO topic VALUES (104, '올해 꼭 이루고 싶은게 있으세요?', 'DATE');
INSERT INTO topic VALUES (105, '자주 보시는 유튜브 채널 있으세요?', 'DATE');
INSERT INTO topic VALUES (106, '책 읽는 거 좋아하세요?', 'DATE');

-- 커플
INSERT INTO topic VALUES (107, '가장 좋았던 여행지를 말해볼까요?', 'COUPLE');
INSERT INTO topic VALUES (108, '서운했던 일을 말해보세요!', 'COUPLE');
INSERT INTO topic VALUES (109, '서로의 좋은 점을 하나씩 말해볼까요?', 'COUPLE');
INSERT INTO topic VALUES (110, '서로의 외모 중 가장 마음에 드는 곳이 어디인가요?', 'COUPLE');
INSERT INTO topic VALUES (111, '결혼은 몇살에 하고 싶은가요?', 'COUPLE');
INSERT INTO topic VALUES (112, '서로의 첫인상에 대해 말해보아요!', 'COUPLE');
INSERT INTO topic VALUES (113, '같이 보고싶은 영화가 있나요?', 'COUPLE');
INSERT INTO topic VALUES (114, '기념일에 해보고싶은 활동이 있나요?', 'COUPLE');
INSERT INTO topic VALUES (115, '서로 닮은 동물 찾아볼까요?', 'COUPLE');
INSERT INTO topic VALUES (116, '최근에 고마웠던 순간이 있을까요?', 'COUPLE');
INSERT INTO topic VALUES (117, '기억나는 첫만남을 말해보세요!', 'COUPLE');
INSERT INTO topic VALUES (118, '버킷리스트를 공유해볼까요?', 'COUPLE');
INSERT INTO topic VALUES (119, '여행가고 싶은 곳을 서로 알려주세요!', 'COUPLE');
INSERT INTO topic VALUES (120, '결혼 한다면 자녀 계획을 상상해볼까요?', 'COUPLE');
INSERT INTO topic VALUES (121, '데이트 통장에 대해 어떻게 생각하세요?', 'COUPLE');
INSERT INTO topic VALUES (122, '만약에 사랑하는 사람이 내 눈앞에서 돌맹이로 변한다면?', 'COUPLE');
INSERT INTO topic VALUES (123, '내가 바퀴벌레로 변한다면?', 'COUPLE');
INSERT INTO topic VALUES (124, '상대방에게 가족을 소개시켜 주고 싶나요?', 'COUPLE');
INSERT INTO topic VALUES (125, '상대방이 바람을 피운다면?', 'COUPLE');
INSERT INTO topic VALUES (126, '상대방이 나랑 헤어지고 내 친한친구랑 사귄다면?', 'COUPLE');

END;