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

### 🧑‍💻 MainActivity.java 설명

```java
// 이미지 탐색을 위한 현재 인덱스와 리스트 선언
private List<ImageInfo> imageList;
private int currentImageIndex = 0;

// onCreate()에서 초기 UI와 권한 확인 실행
protected void onCreate(Bundle savedInstanceState) {
    initializeViews(); // 버튼, 텍스트 등 초기화
    setupPermissions(); // Android 버전에 따라 권한 배열 설정
    checkAndRequestPermissions(); // 권한 체크 및 요청
}

// 이미지 표시 함수
private void displayCurrentImage() {
    // 현재 이미지 정보를 기반으로 ImageView에 표시
    // 파일 크기, 이름 등의 정보를 TextView에 출력
}

// 이미지 새로고침 함수
public void refreshImages(View v) {
    checkAndRequestPermissions(); // 권한 재확인 후 이미지 다시 로딩
}

// 권한 요청 결과 처리
public void onRequestPermissionsResult(...) {
    if (모든 권한 허용) {
        loadAllImages(); // 이미지 로딩
    } else {
        사용자에게 권한 거부 메시지 출력
    }
}

```
---

### 🖼️ activity_main.xml 설명

```xml
<LinearLayout>
    <!-- 상단 탐색 버튼 -->
    <Button android:id="@+id/previous" ... />
    <Button android:id="@+id/next" ... />

    <!-- 이미지 정보 텍스트 -->
    <TextView android:id="@+id/imageCounter" ... />
    <TextView android:id="@+id/imageInfo" ... />

    <!-- 이미지 표시 영역 -->
    <ImageView android:id="@+id/picture" ... />

    <!-- 하단 제어 버튼 -->
    <Button android:id="@+id/refreshButton" ... />
    <Button android:id="@+id/permissionButton" ... />
</LinearLayout>
```
- previous, next 버튼은 이미지 이동
- refreshButton: 이미지 리스트 새로고침
- permissionButton: 권한 재요청 (초기에는 숨겨짐)

---

### 🎨 버튼 배경 XML 설명 (res/drawable)
button_refresh.xml
```xml
<selector>
  <item android:state_pressed="true">
    <shape><solid android:color="#388e3c"/></shape>
  </item>
  <item>
    <shape><solid android:color="#4caf50"/></shape>
  </item>
</selector>
```
- 새로고침 버튼의 눌림/기본 상태 색상 정의
  
button_previous.xml, button_next.xml
```xml
<selector>
  <item android:state_enabled="false">
    <shape><solid android:color="#cccccc"/></shape>
  </item>
  <item android:state_pressed="true">
    <shape><solid android:color="#1976d2"/></shape>
  </item>
  <item>
    <shape><solid android:color="#2196f3"/></shape>
  </item>
</selector>
```
- 새로고침 버튼의 눌림/기본 상태 색상 정의

button_permission.xml

```xml
<selector>
  <item android:state_pressed="true">
    <shape><solid android:color="#f57c00"/></shape>
  </item>
  <item>
    <shape><solid android:color="#ff9800"/></shape>
  </item>
</selector>
```
- 권한 요청 버튼용 오렌지 계열 상태 정의

---

### 🎨 AndroidManifest.xml 설정
```xml
<uses-permission android:name="android.permission.READ_MEDIA_IMAGES" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"
                 android:maxSdkVersion="32" />

<application ... android:requestLegacyExternalStorage="true">
  <activity android:name=".MainActivity" ... >
    <intent-filter>
      <action android:name="android.intent.action.MAIN" />
      <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>
  </activity>
</application>

```

### ✅ 실행 예시
- 앱 실행 시 권한 허용 여부에 따라 자동 동작 또는 수동 요청
- 이미지가 있을 경우 이미지 + 정보 표시
- 이미지 없을 경우 안내 메시지 출력
