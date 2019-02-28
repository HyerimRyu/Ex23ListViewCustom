package kr.co.teada.ex23listviewcustom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    //Adapter 참조변수
    MyAdapter adapter;

    //대량의 데이터
    ArrayList<Member> members = new ArrayList<Member>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //테스트용으로 대량의 데이터를 추가작업
        members.add(new Member(R.drawable.korea,"전현무", "대한민국"));
        members.add(new Member(R.drawable.canada,"기욤", "캐나다"));
        members.add(new Member(R.drawable.china,"장위안", "중국"));
        members.add(new Member(R.drawable.italy,"알베르토", "이탈리아"));
        members.add(new Member(R.drawable.usa,"타일러", "미국"));
        members.add(new Member(R.drawable.australia,"블레어", "호주"));
        members.add(new Member(R.drawable.korea,"전현무", "대한민국"));
        members.add(new Member(R.drawable.canada,"기욤", "캐나다"));
        members.add(new Member(R.drawable.china,"장위안", "중국"));
        members.add(new Member(R.drawable.italy,"알베르토", "이탈리아"));
        members.add(new Member(R.drawable.usa,"타일러", "미국"));
        members.add(new Member(R.drawable.australia,"블레어", "호주"));


        listView=findViewById(R.id.listview);
        //대량의 데이터를 뷰 객체들로 자동으로 만들어주는 Adapter 객체 생성
        LayoutInflater inflater=getLayoutInflater();
        adapter=new MyAdapter(members, inflater);
        listView.setAdapter(adapter); //****만들어 놓은 것 연결! 화면에 보여줘! 위에까지 데이터 연결하고 안보여주면 안보여요~
    }
}
