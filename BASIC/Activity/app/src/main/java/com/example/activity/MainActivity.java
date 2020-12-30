package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    @Override
    // Activity가 생성될 때 자동으로 호출된다.
    // 화면 회전이 발생했을 때 자동으로 호출된다.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //System.out.println("onCreate 메서드 호출");
        Log.d("test","onCreate 호출");
    }

    @Override
    // OnCreate 메서드 호출 이후에 자동으로 호출
    // Activity가 정지 상태가 되었다가 활동 상태로 돌아올 때 호출
    protected void onStart() {
        super.onStart();
        Log.d("test","onStart 호출");
    }

    @Override
    // onStart 메서드가 호출된 이후에 자동으로 호출된다.
    // Activity가 일시 정지 되었다가 다시 돌아 올때 호출
    // 눈에 안보이는 경우 일시정지->정지// 팝업창은 일시정지
    protected void onResume() {
        super.onResume();
        Log.d("test","onResume 호출");
    } // 복원하여 처리될 때

    @Override
    // Activity가 정지 상태가 되었다가 활동 상태로 돌아갈 때 onStart 메서드 전에 호출됨.
    protected void onRestart() {
        super.onRestart();
        Log.d("test","onRestart 호출");
    }

    @Override
    // Activity가 일시 정지 상태가 될 때 호출된다.
    // 화면상에서 완전히 사라지거나 현재 화면 위에 작은 팝업 창 같은 것이 나타날 때 호출
    protected void onPause() {
        super.onPause();
        Log.d("test","onPause 호출");
    }
    //사용하지 못할 때 여기서 처리.

    @Override
    // Activity가 화면에서 사라질 때 호출된다.
    protected void onStop() {
        super.onStop();
        Log.d("test","onStop 호출");
    }

    @Override
    // 현재 Activity의 수행이 완전히 종료되어 메모리상에서 제거될 때 호출
    protected void onDestroy() {
        super.onDestroy();
        Log.d("test","onDestroy 호출");
    }
}