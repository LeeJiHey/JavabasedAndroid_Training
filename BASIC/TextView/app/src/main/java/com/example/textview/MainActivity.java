package com.example.textview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 뷰의 주소값을 담을 참조 변수를 선언
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 뷰의 주소값을 호출할 때 setContectVIew다음에 하기

        // id 속성이 text2인 뷰의 주소 값을 얻어낸다.
        text1 = (TextView)findViewById(R.id.text2);
        //새로운 문자열을 설정한다.
        text1.setText("새로운 문자열");


    }
}