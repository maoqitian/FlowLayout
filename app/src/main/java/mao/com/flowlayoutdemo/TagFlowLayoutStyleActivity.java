package mao.com.flowlayoutdemo;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mao.com.flexibleflowlayout.TagAdapter;
import mao.com.flexibleflowlayout.TagFlowLayout;

public class TagFlowLayoutStyleActivity extends AppCompatActivity{


    TagFlowLayout tagFlowLayout;
    private List<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tag_style_activity_main);
        initView();
        initData();
        tagFlowLayout.setMaxSelectCount(0);
        tagFlowLayout.setAdapter(new TagAdapter() {
            @Override
            public int getItemCount() {
                return dataList.size();
            }

            @Override
            public View createView(LayoutInflater inflater, ViewGroup parent, int position) {
                return inflater.inflate(R.layout.flow_text_sq_layout,parent,false);
            }

            @Override
            public void bindView(View view, int position) {
                TextView textView = view.findViewById(R.id.text_tag);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(GradientDrawable.RECTANGLE);//形状
                gradientDrawable.setCornerRadius(5f);//设置圆角Radius
                gradientDrawable.setColor(getRandColor());//颜色
                textView.setText(dataList.get(position));
                view.setBackground(gradientDrawable);
            }
        });
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
        tagFlowLayout = findViewById(R.id.tag_f2);
    }

    public int getRandColor() {
        Random random=new Random();
        int r=0;
        int g=0;
        int b=0;
        for(int i=0;i<2;i++){
            //       result=result*10+random.nextInt(10);
            int temp=random.nextInt(16);
            r=r*16+temp;
            temp=random.nextInt(16);
            g=g*16+temp;
            temp=random.nextInt(16);
            b=b*16+temp;
        }
        return Color.rgb(r,g,b);
    }

}
