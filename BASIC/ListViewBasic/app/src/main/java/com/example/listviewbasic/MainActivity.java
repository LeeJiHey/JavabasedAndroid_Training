package com.example.listviewbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    //AdapterView: 뷰를 구성하기 위해 개발자가 코드를 통해 결정해 줘야 하는 항목이 있는 뷰.

    // 뷰의 주소 값을 담을 참조변수
    ListView list1;
    TextView text1;
    // 리스트뷰 구성을 위해 필요한 문자열 배열
    String [] data1 = {
            "리스트1", "리스트2", "리스트3", "리스트4","리스트5",
            "리스트6","리스트7","리스트8","리스트9","리스트10",
            "리스트11","리스트12","리스트13","리스트14","리스트15",
            "리스트16","리스트17","리스트18","리스트19","리스트20"
    };
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //뷰의 주소 값을 얻어온다.

       list1 = (ListView)findViewById(R.id.list1);
       text1 = (TextView)findViewById(R.id.textView);
       // 어댑터 객체가 어댑터뷰에 필요한 데이터를 담는 객체이다.
       // setAdapter: 리스트뷰를 구성하기 위한 어댑터 객체를 설정한다.

       // 몇 개의 항목을 보여줄 것인가?         => 배열이나 리스트의 항목 갯수
       // 각 항목에 어떤 데이터를 보여줄 것인가? => 배열이나 리스트에 들어있는 값
       // 각 항목은 어떤 모양으로 보여줄 것인가? => 레이아웃 지정.

       ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data1);
       // 리스트뷰에 어뎁터를 설정한다.
       list1.setAdapter(adapter);

       // OnItemClickListener: 리스트 뷰의 항목을 터치하면 반응하는 리스너

       // 리스너를 설정한다.
       ListListener listener = new ListListener();
       list1.setOnItemClickListener(listener);

    }

    class ListListener implements AdapterView.OnItemClickListener{
       // 항목을 터치하면 호출되는 메서드
       @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
           // i가 사용자가 터치한 index 번호.
           text1.setText(data1[i]);
        }
    }
}

