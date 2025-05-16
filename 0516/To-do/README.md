# SQLite To-Do 리스트 앱

## 개요
안드로이드 앱에서 SQLite를 사용하여 간단한 To-Do 리스트를 구현한 프로젝트입니다.  
앱 내에서 할 일 목록을 추가, 삭제할 수 있으며, 데이터는 SQLite 데이터베이스에 저장되어 앱 종료 후에도 유지됩니다.

## 주요 기능
- 할 일 입력 및 추가
- 할 일 목록 화면에 표시
- 목록 아이템 클릭 시 해당 할 일 삭제
- SQLite 데이터베이스에 할 일 데이터 영구 저장

## 주요 파일
- `activity_todo_sqlite.xml`: To-Do 리스트 화면 UI 레이아웃
- `TodoDatabaseHelper.java`: SQLite 데이터베이스 관리 클래스
- `TodoSqliteActivity.java`: UI 및 데이터 연동하는 액티비티

## 사용 방법
1. 앱 실행 후 To-Do 화면에서 할 일을 입력합니다.
2. '추가' 버튼을 눌러 할 일을 저장합니다.
3. 목록에 저장된 할 일이 표시됩니다.
4. 목록의 할 일을 누르면 삭제됩니다.
5. 데이터는 SQLite DB에 저장되어 앱 종료 후에도 유지됩니다.

## 주의 사항
- SQLite는 내부 저장소에 데이터를 저장하므로 외부 접근이 불가합니다.
- 데이터베이스 버전 관리 및 마이그레이션은 단순 구현에선 고려하지 않았습니다.

## 확장 가능성
- 할 일 수정 기능 추가
- 완료 여부 체크박스 추가
- 외부 백업 혹은 동기화 기능 추가

## AndroidManifest.xml에 등록
```xml
<activity android:name=".TodoSqliteActivity" />
```
# AndroidManifest.xml에 등록 위치
app > manifests > AndroidManifest.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">

    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.MyApplication"
        tools:targetApi="31">
        <activity
            android:name=".TodoSqliteActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```
