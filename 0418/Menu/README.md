메뉴 파일이 실행이 안될 때 : 원인은 themes.xml파일에서 .NoActionBar 안지웠음.

<resources xmlns:tools="http://schemas.android.com/tools">
    <!-- Base application theme. -->
    <style name="Base.Theme.MyApplication" parent="Theme.Material3.DayNight.NoActionBar">
        <!-- Customize your light theme here. -->
        <!-- <item name="colorPrimary">@color/my_light_primary</item> -->
    </style>

    <style name="Theme.MyApplication" parent="Base.Theme.MyApplication" />
</resources>

  <style name="Base.Theme.MyApplication" parent="Theme.Material3.DayNight.NoActionBar"> => .NoActionBar을 안지웠음 지워야 실행됨 
