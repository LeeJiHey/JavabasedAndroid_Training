package com.example.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 뷰의 주소 값을 담을 참조변수
    SeekBar seek1, seek2;
    TextView text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seek1 = (SeekBar)findViewById(R.id.seekBar);
        seek2 = (SeekBar)findViewById(R.id.seekBar2);

        text1 = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView2);


        SeekBarListener listener = new SeekBarListener();
        seek1.setOnSeekBarChangeListener(listener);
        seek2.setOnSeekBarChangeListener(listener);
    }

    public void btn1Method(View view){
        seek1.incrementProgressBy(1);
        seek2.incrementProgressBy(1);
    }

    public void btn2Method(View view){
        seek1.incrementProgressBy(-1);
        seek2.incrementProgressBy(-1);
    }

    public void btn3Method(View view){
        seek1.setProgress(8);
        seek2.setProgress(3);
    }

    public void btn4Method(View view){
        int val1 = seek1.getProgress();
        int val2 = seek2.getProgress();

        text1.setText("seek1 : " + val1);
        text2.setText("seek2 : " + val2);
    }


    class SeekBarListener implements SeekBar.OnSeekBarChangeListener{
        // 현재 값을 변경 시켰을 때 호출 되는 메서드
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            int id = seekBar.getId();

            switch (id) {
                case R.id.seekBar:
                    text1.setText("첫 번째 SeekBar : " + progress);
                    break;
                case R.id.seekBar2:
                    text1.setText("두 번째 SeekBar : " + progress);
                    break;
            }

            if (fromUser == true){
                text2.setText("사용자에 의해 변경되었습니다.");
            } else {
                text2.setText("코드에 의해 변경되었습니다.");
            }

        }

        // 값을 변경하기 위해 터치하면 호출되는 메서드
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            int id = seekBar.getId();
            switch (id) {
                case R.id.seekBar:
                    text2.setText("첫 번째 SeekBar를 터치 하였습니다.");
                    break;
                case R.id.seekBar2:
                    text2.setText("두 번째 SeekBar를 터치 하였습니다.");
                    break;
            }
        }

        // 값을 변경하고 터치를 때면 호출되는 메서드
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            int id = seekBar.getId();
            switch (id) {
                case R.id.seekBar:
                    text2.setText("첫 번째 SeekBar를 떼었습니다.");
                    break;
                case R.id.seekBar2:
                    text2.setText("두 번째 SeekBar를 떼었습니다.");
                    break;
            }

        }
    }
}