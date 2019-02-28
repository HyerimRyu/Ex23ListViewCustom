package kr.co.teada.ex23listviewcustom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    ArrayList<Member> members;
    LayoutInflater inflater;

    //생성자 alt+insert
    public MyAdapter(ArrayList<Member> members, LayoutInflater inflater) {
        this.members=members;
        this.inflater=inflater;
    }

    @Override
    public int getCount() {
        return members.size();//데이터의 총 개수
    }

    @Override
    public Object getItem(int position) {
        return members.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //이 메소드가 항목(Item) 하나의 View 객체를 만들어서 리턴하는 작업수행
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //첫 번째 매개변수(파라미터)로 전달되어 온 position번째의 Data로
        //View 객체를 만들어서 리턴시켜줘야 함

        //1. new View(틀 만들어: 유투브, 넷플릭스 틀: 뷰객체를 만드는 작업)
        //**************혹시 재활용할 View가 없니? 없다면 만들고, 있으면 그냥 데이터만 연결!!!! 페북, 인스타 등등

        //위 코드에서 두 번째 파라미터가 재활용할 뷰 참조변수야
        //재활용 할지 안할지 어떻게 알아? 위의 convertView가 재활용 있으면 하고, 없으면 null
        if(convertView==null){
            //res 폴더 안에 layout 폴더 안에 listview_item.xml의 모양으로
            //View 객체를 생성해주는 능력을 가진 객체에게 의뢰
            convertView =inflater.inflate(R.layout.listview_item, null);
            //인플레이터야. 인플레이트 해줘(R.layout.listview_item xml 설계도면대로 만들어줘)
        }

        //항목View 안에 있는 ImageView 1개, TextView 2개 참조하기
        ImageView iv=convertView.findViewById(R.id.item_iv);
        TextView tvName=convertView.findViewById(R.id.item_tv_name);
        TextView tvNation=convertView.findViewById(R.id.item_tv_nation);


        //2. bind View(데이터 넣어: 내용 바뀌는거 : 만들어진 뷰에 Data의 값들을 연결하는 작업)
        //position번째 View에 연결할 position번째 데이터 얻어오기
        Member member=members.get(position);

        iv.setImageResource(member.imgId);
        tvName.setText(member.name);
        tvNation.setText(member.nation);


        return convertView;
    }
}
