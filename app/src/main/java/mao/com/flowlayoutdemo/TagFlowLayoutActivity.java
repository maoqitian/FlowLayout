package mao.com.flowlayoutdemo;

import android.content.ContextWrapper;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mao.com.flexibleflowlayout.TagAdapter;
import mao.com.flexibleflowlayout.TagFlowLayout;

public class TagFlowLayoutActivity extends AppCompatActivity implements View.OnClickListener {


    TagFlowLayout tagFlowLayout;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    private List<String> dataList;

    TagAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tag_activity_main);
        initView();
        initData();
        mAdapter = new MyTagAdapter();
        ((MyTagAdapter) mAdapter).setDataList(dataList);
        tagFlowLayout.setAdapter(mAdapter);

    }

    private void initData() {
        dataList = new ArrayList<>();
        dataList.add("香克斯");
        dataList.add("路飞");
        dataList.add("索隆");
        dataList.add("香吉士");
        dataList.add("娜美");
        dataList.add("乌索普");
        dataList.add("罗");
        dataList.add("乔巴");
        dataList.add("弗兰奇");
        dataList.add("罗宾");
        dataList.add("布鲁克");
        dataList.add("罗杰");
        dataList.add("鱼人阿龙");
    }

    private void initView() {
        tagFlowLayout = findViewById(R.id.tag_fl);
        button1 = findViewById(R.id.bt_1);
        button2 = findViewById(R.id.bt_2);
        button3 = findViewById(R.id.bt_3);
        button4 = findViewById(R.id.bt_4);
        button4.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    private void reFreshData() {
        dataList.clear();
        dataList.add("亚索");
        dataList.add("劫");
        dataList.add("剑圣");
        dataList.add("盖伦");
        dataList.add("挖掘机");
        dataList.add("赵信");
        dataList.add("皇子");
        dataList.add("虚空掠夺者");
        dataList.add("猪妹");
        dataList.add("屠龙勇士");
        dataList.add("李青");
        dataList.add("莫甘娜");
        dataList.add("混分巨兽");
        dataList.add("贾克斯");

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_1:
                //不能选
                tagFlowLayout.setMaxSelectCount(0);
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.bt_2:
                tagFlowLayout.setMaxSelectCount(1);
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.bt_3:
                tagFlowLayout.setMaxSelectCount(3);
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.bt_4:
                reFreshData();
                ((MyTagAdapter) mAdapter).setDataList(dataList);
                break;
        }
    }


    public class MyTagAdapter extends TagAdapter{

        public void setDataList(List<String> dataList) {
            this.mDataList = dataList;
            notifyDataSetChanged();
        }

        private List<String> mDataList;


        @Override
        public int getItemCount() {
            return mDataList.size();
        }

        @Override
        public View createView(LayoutInflater inflater, ViewGroup parent, int position) {
            return inflater.inflate(R.layout.flow_text_tag_layout,parent,false);
        }

        @Override
        public void bindView(View view, int position) {
            TextView textView = view.findViewById(R.id.flow_text_tag);
            textView.setText(mDataList.get(position));
        }

        @Override
        public void onTagItemViewClick(View v, int position) {
            Toast.makeText(TagFlowLayoutActivity.this,"点击了 "+mDataList.get(position),Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onItemSelected(View v, int position) {
            Log.e("毛麒添","被选中" + position);
            TextView textView = v.findViewById(R.id.flow_text_tag);
            textView.setTextColor(ContextCompat.getColor(TagFlowLayoutActivity.this,R.color.colorPrimaryDark));
        }

        @Override
        public void onItemUnSelected(View v, int position) {
            Log.e("毛麒添","不被选中" + position);
            TextView textView = v.findViewById(R.id.flow_text_tag);
            textView.setTextColor(ContextCompat.getColor(TagFlowLayoutActivity.this,R.color.light_blue));
        }
    }
}
