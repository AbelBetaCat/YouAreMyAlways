package com.stone.app.guidingPage;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.stone.app.R;
import com.stone.app.login.loginActivity;

import java.util.ArrayList;
import java.util.List;

import static com.stone.app.Util.staticConstUtil.STYLEOLD;
import static com.stone.app.Util.staticConstUtil.STYLEYOUNG;

public class GuidingPageActivity extends Activity implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private ImageView points[];
    private Button startbutton;
    private View view1, view2, view3, view4;
    private int currentIndex;
    private int img[] = {R.mipmap.guide1, R.mipmap.guide2, R.mipmap.guide3};
    SharedPreferences.Editor editor;
    private ViewPager viewPager;
    //    private Myadapter myadapter;
    private List<View> list;
    private Button startbutton_old;
    private Button startbutton_young;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guiding_activity);
        initPoint();
        initviewPager();
    }

    private void initviewPager() {
        viewPager = findViewById(R.id.viewpager);
        list = new ArrayList<View>();
        view1 = View.inflate(GuidingPageActivity.this, R.layout.view1, null);
        view2 = View.inflate(GuidingPageActivity.this, R.layout.view2, null);
        view3 = View.inflate(GuidingPageActivity.this, R.layout.view3, null);
        view4 = View.inflate(GuidingPageActivity.this, R.layout.view4, null);
        editor = getSharedPreferences("autologin", MODE_PRIVATE).edit();
        list.add(view1);
        list.add(view2);
        list.add(view3);
        list.add(view4);
        Myadapter myadapter = new Myadapter(list);
        viewPager.setAdapter(myadapter);
        //设置页卡切换监听
        viewPager.setOnPageChangeListener(GuidingPageActivity.this);
    }

    private void initPoint() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ly1);
        points = new ImageView[4];
        for (int i = 0; i < points.length; i++) {
            points[i] = (ImageView) linearLayout.getChildAt(i);     //遍历LinearLayout下的所有ImageView子节点
            points[i].setEnabled(true);//设置当前状态为允许点击,颜色为浅绿色，和drawable中的point_seletor相对应
            //设置点击监听
            points[i].setOnClickListener(this);
            //额外设置一个标识符，以便点击小圆点时跳转倒对应页面
            points[i].setTag(i);
        }
        //设置首页为当前页(小点着色,深绿色)
        currentIndex = 0;
        points[currentIndex].setEnabled(false);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        if (position == 3) {
            //    按钮在第4个页面（view）才会出现，如果一开始就加载这个按钮监听，就导致空指针异常
            startbutton_old = findViewById(R.id.start_old);
            startbutton_young = findViewById(R.id.start_young);
            startbutton_old.setOnClickListener(GuidingPageActivity.this);
            startbutton_young.setOnClickListener(GuidingPageActivity.this);
        }
        points[position].setEnabled(false);
        points[currentIndex].setEnabled(true);
        currentIndex = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_old:

                editor.putInt("style", STYLEOLD);
                editor.apply();
                startActivity(new Intent(GuidingPageActivity.this, loginActivity.class));
                finish();
                //gotoMainPage
                break;
            case R.id.start_young:
                //gotoMainPage
                editor.putInt("style", STYLEYOUNG);
                editor.apply();
                startActivity(new Intent(GuidingPageActivity.this, loginActivity.class));
                finish();
                break;
            default:
                //小圆点对应的点击事件
             //   viewPager.setCurrentItem((int) view.getTag());
                break;

        }


    }

}
