package com.example.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.zip.DataFormatException;

public class MainActivity extends AppCompatActivity {

    // 뷰의 주소 값을 담을 참조변수
    EditText edit1;
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText)findViewById(R.id.editTextTextPersonName);
        text1 = (TextView)findViewById(R.id.textView);

        EnterListener listener = new EnterListener();
        edit1.setOnEditorActionListener(listener);

        WatcherClass watcher = new WatcherClass();
        edit1.addTextChangedListener(watcher);

    }

    public void btn1Method(View view){
        edit1.setText("새롭게 설정한 문자열");
    }

    public void btn2Method(View view){
        String str = edit1.getText().toString();
        text1.setText("입력한 문자열 : " + str);
    }

    // 엔터 키를 누르면 반응하는 리스너
    class EnterListener implements TextView.OnEditorActionListener{
        @Override
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

            String str = textView.getText().toString();
            text1.setText("입력한 문자열 : " + str);
            return false; // true면 밑으로 내려가지 않음.

        }
    }
    // 입력 할 때마다 반응하는 리스너
    class WatcherClass implements TextWatcher{
        // 문자열 값이 변경되었을 때
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            text1.setText("문자열 변경 중 : " + charSequence);
        }

        // 문자열 값이 변경되기 전
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


        }

        // 문자열 값이 변경된 이후
        @Override
        public void afterTextChanged(Editable editable) {

        }
    }
}