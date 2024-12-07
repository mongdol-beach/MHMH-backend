package com.mondol.mhmh.balanceGame.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.mondol.mhmh.balanceGame.rqrs.BalanceQuestion;

@Service
public class BalanceGameService {

    public List<BalanceQuestion> readBalanceQuestionList() {
        List<BalanceQuestion> list = new ArrayList<>();
        list.add(new BalanceQuestion(1, "강동원", "유병재"));
        list.add(new BalanceQuestion(2, "평생 두통", "평생 치통"));
        list.add(new BalanceQuestion(3, "겨울에 에어컨", "여름에 히터"));
        list.add(new BalanceQuestion(4, "언제 죽을지 알기", "어떻게 죽을지 알기"));
        list.add(new BalanceQuestion(5, "고양이 키우기", "강아지 키우기"));
        list.add(new BalanceQuestion(6, "휴대폰 배터리 1%", "인터넷 안됨"));
        list.add(new BalanceQuestion(7, "과거로 돌아가기", "미래로 가보기"));
        list.add(new BalanceQuestion(8, "똥 맛 카레 먹기", "카레맛 똥 먹기"));
        list.add(new BalanceQuestion(9, "잠수 이별 당하기", "환승 이별 당하기"));
        list.add(new BalanceQuestion(10, "나를 좋아하는 사람", "내가 좋아하는 사람"));
        list.add(new BalanceQuestion(11, "인스타 평생 금지", "유튜브 평생 금지"));
        list.add(new BalanceQuestion(12, "연인과 하루에 100번 연락하기", "연인과 한 달에 한 번 연락하기"));
        list.add(new BalanceQuestion(13, "(싫어하는 사람한테)단톡에서 고백받기", "(싫어하는 사람한테)사람많은 길거리에서 고백받기"));
        list.add(new BalanceQuestion(14, "일주일 내내 집에 있기", "일주일 내내 외출하기"));
        list.add(new BalanceQuestion(15, "키 130cm", "키 250cm"));
        list.add(new BalanceQuestion(16, "평생 여드름 피부", "평생 탈모"));
        list.add(new BalanceQuestion(17, "365일 폭염", "365일 장마"));
        list.add(new BalanceQuestion(18, "100% 확률로 1억 받기", "50% 확률로 5억 받기"));
        list.add(new BalanceQuestion(19, "(실패했을 때)위로와 격려 받기", "(실패했을 때)냉정한 피드백 받기"));
        list.add(new BalanceQuestion(20, "전화", "카톡 or 문자"));
        list.add(new BalanceQuestion(21, "돈 많이 주는 하기 싫은 일", "돈 적게 주는 하고 싶은 일"));
        list.add(new BalanceQuestion(22, "서서 30분 출퇴근", "앉아서 1시간 출퇴근"));
        list.add(new BalanceQuestion(23, "애인과 1시간 싸우기", "상사한테 1시간 혼나기"));
        list.add(new BalanceQuestion(24, "일 잘하는데 성격 안좋음", "일 잘하는데 성격 좋음"));
        list.add(new BalanceQuestion(25, "지나치게 간섭하는 사수", "아무것도 안 알려주는 사수"));
        list.add(new BalanceQuestion(26, "(사녀 연애할 때)공개", "(사녀 연애할 때)비공개"));
        list.add(new BalanceQuestion(27, "평생 쌀만 먹기", "평생 빵만 먹기"));
        list.add(new BalanceQuestion(28, "음악에 재능 갖기", "미술에 재능 갖기"));
        list.add(new BalanceQuestion(29, "머리카락 못 자르기", "손톱 못 자르기"));
        list.add(new BalanceQuestion(30, "원하는 얼굴로 살기", "원하는 몸매로 살기"));
        list.add(new BalanceQuestion(31, "평생 긴팔 입기", "평생 반팔 입기"));
        list.add(new BalanceQuestion(32, "존잘 노잼", "존못 꿀잼"));
        list.add(new BalanceQuestion(33, "딸기 라면", "초콜렛 카레"));
        list.add(new BalanceQuestion(34, "상사한테 야동 링크 잘못 보내기", "상사한테 뒷담화 카톡 잘못 보내기"));
        list.add(new BalanceQuestion(35, "눈 3개", "눈 1개"));
        list.add(new BalanceQuestion(36, "세상 사람들이 나한테만 말걸기", "세상 사람들이 나한테만 말 안걸기"));
        list.add(new BalanceQuestion(37, "미지근하고 탄산 있는 콜라", "시원한데 탄산 없는 콜라"));
        list.add(new BalanceQuestion(38, "이성 친구와 1박2일 여행가는 애인", "전 애인과 밤에 단둘이 술 마시는 애인"));
        list.add(new BalanceQuestion(39, "파인애플 피자", "민트 초코"));
        list.add(new BalanceQuestion(40, "싸운 후 다 이야기하고 다니는 애인", "싸운 후 전혀 타격감 없는 애인"));
        return list;
    }

    public List<BalanceQuestion> readFiveRandomBalanceQuestionList() {
        List<BalanceQuestion> allQuestions = readBalanceQuestionList();
        List<BalanceQuestion> randomQuestions = new ArrayList<>();

        Random random = new Random();
        Set<Integer> selectedIndices = new HashSet<>();

        while (selectedIndices.size() < 5) {
            int randomIndex = random.nextInt(allQuestions.size());
            if (selectedIndices.add(randomIndex)) {
                randomQuestions.add(allQuestions.get(randomIndex));
            }
        }

        return randomQuestions;
    }
}
