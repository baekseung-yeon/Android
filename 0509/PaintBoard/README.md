<h1>그림판 앱 (Drawing App)</h1>

<p>이 앱은 <strong>안드로이드</strong>로 구현된 <strong>간단한 그림판 앱</strong>입니다. 사용자는 펜 색상, 굵기 조절, 지우개 등을 사용하여 그림을 그릴 수 있습니다. 기본적인 그림 그리기, 색상 변경, 지우개 기능 외에도 초기화 버튼을 통해 그림을 초기화할 수 있습니다.</p>

<h2>기능</h2>
<ul>
    <li><strong>펜 색상 변경</strong>: 검정, 빨강, 파랑 색상 선택</li>
    <li><strong>펜 굵기 조절</strong>: SeekBar를 사용하여 펜 굵기 변경</li>
    <li><strong>지우개 기능</strong>: 지우개 버튼을 클릭하여 그림을 지울 수 있음</li>
    <li><strong>초기화 버튼</strong>: 그린 그림을 초기화하여 새로 시작할 수 있음</li>
</ul>

<h2>요구 사항</h2>
<ul>
    <li><strong>Android Studio</strong> (최소 SDK 21 이상)</li>
    <li><strong>Java 8 이상</strong></li>
</ul>

<h2>설치 방법</h2>
<ol>
    <li><strong>프로젝트 클론 또는 다운로드</strong>
        <pre><code>git clone https://github.com/your-repository/drawing-app.git</code></pre>
    </li>
    <li><strong>Android Studio에서 프로젝트 열기</strong>
        <p>Android Studio를 열고, 다운로드한 프로젝트 디렉토리로 이동한 후 프로젝트를 엽니다.</p>
    </li>
    <li><strong>앱 실행</strong>
        <p>Android Studio에서 <strong>Run</strong> 버튼을 클릭하여 앱을 실행합니다. 에뮬레이터 또는 실제 디바이스에서 앱을 테스트할 수 있습니다.</p>
    </li>
</ol>

<h2>사용 방법</h2>
<ol>
    <li>앱을 실행하면 화면에 나타나는 <strong>펜 색상 버튼</strong>을 클릭하여 원하는 색상(검정, 빨강, 파랑)을 선택합니다.</li>
    <li><strong>SeekBar</strong>를 사용하여 펜의 굵기를 조정할 수 있습니다.</li>
    <li><strong>지우개 버튼</strong>을 클릭하여 지우개 모드로 변경하고 그림을 지울 수 있습니다.</li>
    <li><strong>초기화 버튼</strong>을 클릭하여 그린 모든 그림을 지우고 새로 시작할 수 있습니다.</li>
</ol>

<h2>파일 구조</h2>
<pre><code>
/app
    /src
        /main
            /java
                /com
                    /example
                        /myapplication
                            DrawingView.java         # 그리기 기능 구현
                            MainActivity.java        # 메인 액티비티
            /res
                /layout
                    activity_main.xml          # 레이아웃 XML
                /values
                    colors.xml                # 색상 정의
                    styles.xml                # 스타일 정의
                    themes.xml                # 테마 정의
</code></pre>

<h2>기여</h2>
<p>이 프로젝트는 누구든지 기여할 수 있습니다. 기여 방법에 대해 알고 싶다면 <strong>pull request</strong>를 보내주세요.</p>

<h2>라이센스</h2>
<p>MIT 라이센스 - <a href="LICENSE">LICENSE</a></p>

