package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    // 이미지를 넣는 폴더 drawable 폴더
    // mipmap도 이미지를 넣는데 비트맵이 아닌 벡터 방식의 이미지를 그리게 된다.
    // mipmap은 런처 아이콘용 이미지를 넣는 폴더로 사용한다.

    // 뷰의 주소 값을 담을 참조변수
    ImageView img3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 뷰의 주소 값을 받아온다.
        img3 = (ImageView)findViewById(R.id.imageView3);
        // 이미지를 셋팅한다.
        img3.setImageResource(R.drawable.ic_launcher_background);
    }

    // [메서드] setImageResource : res 폴더에 있는 이미지를 설정한다.


}