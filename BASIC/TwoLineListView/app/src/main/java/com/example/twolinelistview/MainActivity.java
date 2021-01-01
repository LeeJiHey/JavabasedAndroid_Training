package com.example.twolinelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    // Two Line ListView: 리스트 뷰의 항목 하나에 두 가지 문자열을 보여줄 때 사용
    // 다른 리스트뷰를 제공하는 것은 아니고 항목 하나의 모양을 만들 때
    // 사용할 레이아웃에 TextView가 두 개 존재하면 된다.
    // 안드로이드 OS 자체에서 제공되는 레이아웃 파일을 사용하면 된다.


    // 리스트의 항목을 구성하기 위한 문자열 배열
    String [] data1 = {
            "문자열1", "문자열2", "문자열3", "문자열4",
            "문자열5", "문자열6", "문자열7", "문자열8"
    };

    String [] data2 = {
            "String1", "String2", "String3", "String4",
            "String5", "String6", "String7", "String8"
    };

    // 뷰의 주소 값을 담을 참조 변수
    ListView list1;
    TextView text3;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 뷰의 주소 값을 담는다.
       list1 = (ListView)findViewById(R.id.list1);
       text3 = (TextView)findViewById(R.id.textView);

       // 데이터를 담을 ArrayList 생성
       ArrayList<HashMap<String, String>> data_list = new ArrayList<HashMap<String, String>>();
       // ArrayList에 데이터를 담는다.
       for (int i = 0; i<data1.length; i++){
           HashMap<String, String> map = new HashMap<String, String>();

           map.put("str1", data1[i]);
           map.put("str2", data2[i]);

           data_list.add(map);
       }
       String [] keys = {"str1", "str2"};
       int [] ids = {android.R.id.text1, android.R.id.text2};
       // 어뎁터를 리스트뷰에 셋팅한다.
       SimpleAdapter adapter = new SimpleAdapter(this, data_list, android.R.layout.simple_list_item_2, keys, ids);
       list1.setAdapter(adapter);

       // 리스너 연결
       ListListener listener = new ListListener();
       list1.setOnItemClickListener(listener);
    }

    class ListListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            text3.setText(data1[i]);
        }
    }


}