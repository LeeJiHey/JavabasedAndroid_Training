package com.example.customlistview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    // 두 개 이상의 뷰에 데이터를 셋팅할 경우 SimpleAdapter!!!

    // 리스트 뷰 항목에 셋팅할 데이터
    int [] imgRes={
            R.drawable.img_flag1, R.drawable.img_flag2, R.drawable.img_flag3, R.drawable.img_flag4,
            R.drawable.img_flag5, R.drawable.img_flag6, R.drawable.img_flag7, R.drawable.img_flag8
    };
    String [] data1 = {
            "대한민국",
            "영국",
            "프랑스",
            "독일",
            "미국",
            "호주",
            "이집트",
            "그리스"
    };
    String [] data2 = {
            "South Korea",
            "England",
            "France",
            "Germany",
            "United States of America",
            "Australia",
            "Egypt",
            "Greece"
    };

    // 뷰의 주소 값을 담을 참조 변수
    ListView list1;
    TextView text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //뷰의 주소 값을 받아 온다.
        list1 = (ListView)findViewById(R.id.list1);
        text3 = (TextView)findViewById(R.id.textView3);

        // 데이터를 가지고 있는 ArrayList를 생성한다.
        ArrayList<HashMap<String, Object>> data_list = new ArrayList<HashMap<String, Object>>();
        // 데이터를 담는다.
        for (int i=0; i < imgRes.length; i++){
            // 항목 하나를 구성하기 위해서 필요한 데이터를 해시 맵에 담는다.
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("flag", imgRes[i]);
            map.put("data1", data1[i]);
            map.put("data2", data2[i]);

            data_list.add(map);
        }

        // 해시 맵 객체에 데이터를 저장할 때 사용한 이름 배열
        String [] keys = {"flag", "data1", "data2"};

        // 데이터를 셋팅할 뷰의 id
        int [] ids = {R.id.imageView, R.id.textView, R.id.textView2};

        // 어뎁터를 만들어준다.
        SimpleAdapter adapter = new SimpleAdapter(this, data_list, R.layout.row, keys, ids);
        list1.setAdapter(adapter);

        // 리스너를 리스트뷰에 셋팅한다.
        ListListener listener = new ListListener();
        list1.setOnItemClickListener(listener);

    }
    // 리스트 뷰의 항목을 터치하면 반응하는 리스너
    class ListListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            text3.setText(data1[i]);
        }
    }
}