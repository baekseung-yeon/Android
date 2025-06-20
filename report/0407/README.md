
# 📐 안드로이드 레이아웃

이 저장소는 Android UI 개발에서 자주 사용되는 주요 레이아웃 유형들의 예시를 모아둔 프로젝트입니다. 각 레이아웃은 동일한 로그인 화면 UI를 서로 다른 구조로 구현하여 차이점을 학습할 수 있도록 설계되었습니다.

---

## 📋 포함된 레이아웃 유형

| 레이아웃 타입        | 설명 |
|----------------------|------|
| `ConstraintLayout`   | 제약 조건을 사용한 유연한 레이아웃 배치 |
| `GridLayout`         | 격자 기반의 구조로 항목을 배치 |
| `LinearLayout`       | 수직 또는 수평 방향으로 요소 정렬 |
| `RelativeLayout`     | 요소 간 상대적인 위치 관계 지정 |
| `TableLayout`        | 테이블 형태로 뷰를 정렬 |
| `ImageLayout.xml`      | 이미지 중심의 레이아웃 구성 |

---

## 📌 공통 UI 요소

모든 레이아웃은 다음과 같은 로그인 화면 UI를 포함합니다:

- 상단 로고 이미지 (`ImageView`)
- 아이디 입력란 (`EditText`)
- 패스워드 입력란 (`EditText`)
- 로그인 및 회원가입 버튼 (`Button`)
- 결과 출력 영역 (`TextView`)

---

## 🧱 레이아웃 예시

### 1. `ConstraintLayout`
- 부모 및 다른 뷰에 대한 위치 제약 설정
- 좌우 균등 분할된 버튼 구현
- 성능 최적화에 적합한 최신 레이아웃 방식

### 2. `GridLayout`
- `columnCount` 속성을 통해 열 개수 지정
- 텍스트와 입력 필드를 행렬 형태로 배치
- 컴팩트하고 정렬된 화면에 적합

### 3. `LinearLayout`
- 수직 정렬 기반 구조 (`vertical`)
- 내부에 수평 `LinearLayout`을 중첩 사용해 버튼 정렬
- 간단한 UI에 효과적

### 4. `RelativeLayout`
- 뷰끼리 상대적인 위치 지정 (`layout_below`, `layout_toEndOf` 등)
- 간결하지만 제약이 있는 구조
- 복잡한 정렬엔 부적합할 수 있음

### 5. `TableLayout`
- 행(Row)과 열(Column) 개념 사용
- 각 `TableRow`에 항목 배치
- 폼 기반 입력 UI에 자주 사용됨

- ### 5. `ImageLayout`
- 대표 이미지, 갤러리, 제품 썸네일 등 시각 콘텐츠 표시용으로 적합
- scaleType, contentDescription 등 시각적 배치와 접근성 요소 설정 가능
- 반적으로 LinearLayout, ConstraintLayout 등과 조합하여 사용
  
---

## 🔧 사용 방법

1. Android Studio에서 원하는 레이아웃 XML을 `res/layout/` 디렉터리에 추가합니다.
2. `MainActivity.java` 또는 해당 액티비티에서 `setContentView(R.layout.레이아웃파일명);`으로 연결합니다.
3. 실행하여 레이아웃별 UI 구조를 비교해보세요.

---

## 💡 학습 포인트

- 서로 다른 레이아웃 구조 간의 차이점과 사용 목적 이해
- UI 요소의 배치 전략 비교
- 실무에서 적절한 레이아웃 선택 능력 향상

---
