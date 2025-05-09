<h1>🎨그림판 앱</h1>

<p>이 앱은 <strong>안드로이드</strong>로 구현된 <strong>간단한 그림판 앱</strong>입니다. 사용자는 펜 색상, 굵기 조절, 지우개 등을 사용하여 그림을 그릴 수 있습니다. 기본적인 그림 그리기, 색상 변경, 지우개 기능 외에도 초기화 버튼을 통해 그림을 초기화할 수 있습니다.</p>

<h2>📌기능</h2>
<ul>
    <li><strong>펜 색상 변경</strong>: 검정, 빨강, 파랑 색상 선택</li>
    <li><strong>펜 굵기 조절</strong>: <strong>SeekBar</strong>를 사용하여 펜 굵기를 실시간으로 조정할 수 있습니다.</li>
    <li><strong>지우개 기능</strong>: 지우개 버튼을 클릭하여 지우개 모드로 전환하고, 원하는 부분을 지울 수 있습니다.</li>
    <li><strong>초기화 버튼</strong>: 그린 그림을 초기화하여 새로 시작할 수 있습니다.</li>
</ul>

<h2>📌사용 방법</h2>
<ol>
    <li>앱을 실행하면 화면에 나타나는 <strong>펜 색상 버튼</strong>을 클릭하여 원하는 색상(검정, 빨강, 파랑)을 선택합니다.</li>
    <li><strong>SeekBar</strong>를 사용하여 펜의 굵기를 조정할 수 있습니다.</li>
    <li><strong>지우개 버튼</strong>을 클릭하여 지우개 모드로 변경하고 그림을 지울 수 있습니다.</li>
    <li><strong>초기화 버튼</strong>을 클릭하여 그린 모든 그림을 지우고 새로 시작할 수 있습니다.</li>
</ol>

<h2>📌파일 구조</h2>
<pre><code>
 >/app
 > > src
 > > > /main
 > > > > /java
 > > > > > /com
                    /example
                        /myapplication
                            DrawingView.java         # 그리기 기능 구현
                            MainActivity.java        # 메인 액티비티
            /res
                /layout
                    activity_main.xml          # 레이아웃 XML
</code></pre>

<


