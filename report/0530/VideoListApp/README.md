# 📷 콘텐츠 뷰어 앱 - 이미지 & 비디오 탐색기

이 프로젝트는 Android 기기의 저장소에서 **이미지 또는 비디오 파일**을 탐색하고 사용자에게 표시하는 콘텐츠 뷰어 앱입니다. 

---

## 📦 주요 기능

### 이미지 뷰어 앱 (UsingContent)
- 저장된 **이미지 자동 탐색** 및 **화면 표시**
- `PREVIOUS`, `NEXT` 버튼으로 이미지 **이전/다음 탐색**
- 이미지 상세 정보(파일명, 크기) 출력
- **권한 거부 시 안내 및 재요청 버튼 표시**
- 이미지 목록 **새로고침** 기능 제공

### 비디오 리스트 앱 (VideoListApp)
- 기기 내 **모든 동영상 파일 목록 표시**
- 동영상 파일명, 용량, 길이 정보를 표시
- Android 13+에서는 `READ_MEDIA_VIDEO`, 이하에서는 `READ_EXTERNAL_STORAGE` 권한 자동 구분 요청

---

## 📁 프로젝트 구조 (통합)

```
├── res/
│   ├── layout/
│   │   ├── activity_main.xml         # 이미지 뷰어 레이아웃
│   │   └── activity_video_list.xml   # 비디오 목록 레이아웃 (ListView)
│   ├── drawable/                    # 이미지 뷰어용 버튼 상태 XML
│   │   ├── button_previous.xml
│   │   ├── button_next.xml
│   │   ├── button_refresh.xml
│   │   └── button_permission.xml
│   └── values/
│       └── strings.xml              # 공통 문자열 리소스
├── java/
│   └── com.example.videolistapp/
│       ├── MainActivity.java        # 비디오 목록 탐색 로직
│   └── com.example.usingcontent/
│       ├── MainActivity.java        # 이미지 뷰어 로직
├── AndroidManifest.xml              # 권한 선언 및 앱 구성
```

---

## 🧑‍💻 이미지 뷰어 - `MainActivity.java` 설명 (com.example.usingcontent)

```java
onCreate() {
  initializeViews();
  setupPermissions();
  checkAndRequestPermissions();
}
```

- 이미지 탐색: 내부/외부 저장소에서 이미지 탐색
- 이미지 표시: `displayCurrentImage()`에서 ImageView에 표시, 상세 정보 포함
- 권한 미수락 시: `permissionButton` 보이도록 처리

---

## 🧑‍💻 비디오 리스트 앱 - `MainActivity.java` 설명 (com.example.videolistapp)

```java
onCreate() {
  if (checkPermission()) {
    loadVideoFiles();
  } else {
    requestPermission();
  }
}
```

- 비디오 탐색: `MediaStore.Video.Media.EXTERNAL_CONTENT_URI` 쿼리
- 출력 형식: `파일명 (크기)` 형태로 리스트에 출력
- 권한 요청 분기: Android 버전에 따라 적절한 권한 사용

```java
private String formatFileSize(long size) {
  if (size < 1024) return size + " B";
  else if (size < 1024 * 1024) return String.format("%.1f KB", size / 1024.0);
  else return String.format("%.1f MB", size / (1024.0 * 1024.0));
}
```

---

## 🖼️ 이미지 뷰어 레이아웃 (`activity_main.xml`)

```xml
<LinearLayout>
  <Button android:id="@+id/previous" ... />
  <Button android:id="@+id/next" ... />
  <TextView android:id="@+id/imageCounter" ... />
  <TextView android:id="@+id/imageInfo" ... />
  <ImageView android:id="@+id/picture" ... />
  <Button android:id="@+id/refreshButton" ... />
  <Button android:id="@+id/permissionButton" ... />
</LinearLayout>
```

---

## 🎞️ 비디오 목록 레이아웃 (`activity_video_list.xml`)

```xml
<LinearLayout>
  <TextView android:text="All Video Files" ... />
  <ListView android:id="@+id/listView" ... />
</LinearLayout>
```

- 상단 헤더: 타이틀
- 하단 리스트: 동영상 파일 출력

---

## 🎨 버튼 배경 XML 설명 (이미지 뷰어)

### `button_refresh.xml`
```xml
<selector>
  <item android:state_pressed="true"><shape><solid android:color="#388e3c"/></shape></item>
  <item><shape><solid android:color="#4caf50"/></shape></item>
</selector>
```

### `button_previous.xml`, `button_next.xml`
```xml
<selector>
  <item android:state_enabled="false"><shape><solid android:color="#cccccc"/></shape></item>
  <item android:state_pressed="true"><shape><solid android:color="#1976d2"/></shape></item>
  <item><shape><solid android:color="#2196f3"/></shape></item>
</selector>
```

### `button_permission.xml`
```xml
<selector>
  <item android:state_pressed="true"><shape><solid android:color="#f57c00"/></shape></item>
  <item><shape><solid android:color="#ff9800"/></shape></item>
</selector>
```

---

## ⚙️ AndroidManifest.xml 설정 요약

```xml
<!-- 공통 -->
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"
                 android:maxSdkVersion="32" />

<!-- Android 13+ 전용 -->
<uses-permission android:name="android.permission.READ_MEDIA_IMAGES" />
<uses-permission android:name="android.permission.READ_MEDIA_VIDEO" />
```

```xml
<application>
  <activity android:name=".MainActivity">
    <intent-filter>
      <action android:name="android.intent.action.MAIN" />
      <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>
  </activity>
</application>
```

---

## 📑 strings.xml 샘플

```xml
<resources>
  <string name="app_name">Video List App</string>
  <string name="permission_required">동영상 파일에 접근하려면 권한이 필요합니다.</string>
  <string name="no_videos_found">저장된 동영상 파일이 없습니다.</string>
  <string name="videos_found">개의 동영상 파일을 찾았습니다.</string>
  <string name="loading_error">동영상 파일을 찾을 수 없습니다.</string>
</resources>
```

---

## ✅ 실행 예시 요약

- 이미지 뷰어: 이미지 탐색 및 순환 표시 + 권한 체크 + 새로고침
- 비디오 리스트: 권한 허용 시 전체 동영상 목록 표시, 정보 포함

---

