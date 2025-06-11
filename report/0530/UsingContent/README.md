# 📷 이미지 뷰어 앱 - UsingContent

이 프로젝트는 Android 기기의 저장소에서 이미지 파일들을 읽어와 사용자에게 표시하는 간단한 콘텐츠 뷰어 앱입니다. Android 6.0 이상부터 Android 13까지 다양한 버전의 권한 요청을 지원하며, 이미지 탐색 및 권한 수동 요청, 이미지 새로고침 기능을 제공합니다.

---

## 📦 주요 기능

- 기기 내 저장된 **이미지 자동 탐색** 및 **표시**
- `PREVIOUS`, `NEXT` 버튼으로 이미지 **이전/다음 이동**
- 이미지 상세 정보(이름, 크기) 제공
- **권한 거부 시 안내 및 수동 요청 버튼 노출**
- 이미지 **리스트 새로고침** 기능 지원
- Android 6.0~13 권한 시스템 대응

---

## 📁 프로젝트 구조

```plaintext
.
├── res/
│   ├── layout/
│   │   └── activity_main.xml         # 메인 레이아웃
│   ├── drawable/
│   │   ├── button_previous.xml       # 이전 버튼 배경 상태 정의
│   │   ├── button_next.xml           # 다음 버튼 배경 상태 정의
│   │   ├── button_refresh.xml        # 새로고침 버튼 배경 상태 정의
│   │   └── button_permission.xml     # 권한 요청 버튼 배경 상태 정의
├── java/
│   └── com.example.usingcontent/
│       └── MainActivity.java         # 메인 액티비티 (권한 처리 + 이미지 로딩)
├── AndroidManifest.xml              # 권한 선언 및 앱 설정
```

---

## 📁 MainActivity 기능 설명
- initializeViews(): UI 요소 초기화
- setupPermissions(): Android 버전에 따라 필요한 권한 설정
- checkAndRequestPermissions(): 권한 체크 및 사용자 요청
- loadAllImages(): 내부/외부 저장소 이미지 읽기
- displayCurrentImage(): 현재 인덱스 이미지 화면에 표시
- refreshImages(): 이미지 목록 다시 로드
- requestPermissionsManually(): 사용자가 직접 권한 요청
- displayPreviousImage() / displayNextImage(): 이전/다음 이미지 탐색

---

## ⚙️ 권한 처리

### Manifest에 선언된 권한:
```xml
<uses-permission android:name="android.permission.READ_MEDIA_IMAGES" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" android:maxSdkVersion="32" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" android:maxSdkVersion="28" />

```

---

## 📁 버튼 스타일 정의 (res/drawable/)
- button_previous.xml, button_next.xml: 활성화/비활성화 및 클릭 시 색상 변경
- button_refresh.xml: 새로고침용 녹색 계열 색상
- button_permission.xml: 권한 요청용 주황색 계열 색상

---
