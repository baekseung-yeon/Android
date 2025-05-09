# 🧠 MBTI T/F 성향 테스트 앱 (Thinking vs Feeling Test)

이 앱은 사용자의 MBTI 성향 중 **T(사고형)** 과 **F(감정형)** 중 어떤 성향이 강한지를 판별하는  
10문항의 간단한 테스트 앱입니다.

**Android 프래그먼트 기반 + Java 언어 + MPAndroidChart 없이 텍스트 기반 결과 출력**으로 구성되었으며,  
사용자가 각 문항에 응답하면 해당 성향에 맞는 점수가 누적되고,  
마지막에 그 결과를 통해 성향을 판별합니다.

---

## ✨ 주요 기능

- ✅ 10개의 고정 질문을 통해 사고형(T) 또는 감정형(F) 성향 점수 누적
- ✅ Android Fragment 구조로 설문 진행
- ✅ 결과 화면에 T/F 점수와 함께 성향 분석 메시지 출력
- ✅ "다시 하기" 버튼으로 설문 재시작 가능

---

## 📱 앱 구조

```text
MainActivity
  └─ StartFragment
        [테스트 시작 클릭]
  └─ QuestionFragment (index 0 ~ 9)
        [T or F 선택 → 다음 질문]
  └─ ResultFragment
        [결과 메시지 + 점수 표시]
```

---

## 📂 프로젝트 디렉토리 구조

```
app/
├── java/com/example/myapplication/
│   ├── MainActivity.java
│   ├── model/
│   │   └── TfQuestion.java
│   └── fragment/
│       ├── StartFragment.java
│       ├── QuestionFragment.java
│       └── ResultFragment.java
├── res/layout/
│   ├── activity_main.xml
│   ├── fragment_start.xml
│   ├── fragment_question.xml
│   └── fragment_result.xml
```

---

## 💬 질문 예시 (10문항)

| 질문 | 사고형 선택지 (T) | 감정형 선택지 (F) |
|------|------------------|------------------|
| 친구가 고민을 털어놓으면? | 논리적 해결책 제시 | 감정에 공감하며 위로 |
| 회의에서 충돌 시? | 논리로 설득 | 상대 감정 배려 |
| 결정 내릴 때? | 객관적 기준 | 감정 고려 |
| 실수 상황 | 원인 분석 | 감정 이해 |
| 자기소개서 작성 | 논리적 구조 | 느낌 중심 |
| 친구와 다툼 후 | 분석 | 감정 확인 |
| 피드백 시 | 사실 위주 | 기분 배려 |
| 갈등 해결 | 공정함 우선 | 조화 우선 |
| 팀 프로젝트 | 효율 중심 | 감정 배려 |
| 문제 해결 방식 | 분석적 | 감정 중심 |

---

## 🧠 성향 판별 기준

- ✅ 사고형 선택지 > 감정형 → "당신은 사고형(T) 성향입니다!"
- ✅ 감정형 선택지 > 사고형 → "당신은 감정형(F) 성향입니다!"
- ✅ 동점 → "당신은 균형 잡힌 유형입니다!"

---

## 🚀 실행 방법

1. Android Studio에서 프로젝트 열기
2. MainActivity 실행
3. 시작 → 10문항 응답 → 결과 확인

---

## 🔧 사용 기술

- Java
- Android Fragment API
- View → TextView, Button
- Bundle 인텐트로 Fragment 간 데이터 전달

---

## 💡 확장 아이디어

- 그래프 시각화 (MPAndroidChart 연동)
- 결과 공유 기능 (Intent 공유)
- 다른 MBTI 축 (E/I, S/N, J/P) 테스트 추가
- Firebase에 응답 저장

---

## 🙌 제작 방식

이 앱은 전통적인 일방향 개발이 아니라,  
**AI와 개발자의 실시간 바이브 코딩 방식**으로  
기획 → 모델링 → 설문 → 결과까지 점진적으로 협업하며 완성되었습니다.

---

## 📄 라이선스

본 앱은 학습/포트폴리오 목적에 한해 자유롭게 활용할 수 있습니다.
