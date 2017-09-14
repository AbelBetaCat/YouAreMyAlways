package com.stone.app.style_old;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.stone.app.Game.GameRecord.GameRecord;
import com.stone.app.Game.game_judge.game_judgeActivity;
import com.stone.app.Game.game_puzzle.gamestart;
import com.stone.app.R;
import com.stone.app.Util.ToastUtil;
import com.stone.app.Util.getDataUtil;
import com.stone.app.addMember.familyInformation;

public class oldMainActivity extends Activity implements View.OnClickListener {
    private ViewPager viewPager;
    private TextView tv_intro;
    private LinearLayout dot_layout;
//    private ArrayList<Ad> list = new ArrayList<Ad>();
    /**
     * 用于设置自动轮播
     */
    private Handler quitHandle = new Handler() {
        public void handleMessage(Message msg) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            quitHandle.sendEmptyMessageDelayed(0, 4000);
        }
    };
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private TextView game_puzzle;
    private TextView old_seeting;
    private TextView tv_old_puzzle;
    private TextView tv_old_judje;
    private TextView tv_old_result;
    private TextView tv_old_family;
    private String memberID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpageold);
        initView();
        memberID = getDataUtil.getmemberID(oldMainActivity.this);
        //        initData();
        //        initListener();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    //初始化视图
    private void initView() {
        //setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpage);
        tv_intro = (TextView) findViewById(R.id.tv_intro);
        tv_old_judje = (TextView) findViewById(R.id.tv_old_judje);
        old_seeting = (TextView) findViewById(R.id.tv_old_seting);
        tv_old_puzzle = (TextView) findViewById(R.id.tv_old_puzzle);
        tv_old_family = (TextView) findViewById(R.id.tv_old_family);
        tv_old_result = (TextView) findViewById(R.id.tv_old_result);
        dot_layout = (LinearLayout) findViewById(R.id.dot_layout);
         tv_old_judje.setOnClickListener(this);
          old_seeting.setOnClickListener(this);
        tv_old_puzzle.setOnClickListener(this);
        tv_old_family.setOnClickListener(this);
        tv_old_result.setOnClickListener(this);

    }

    //初始化数据
    //    private void initData() {
    //        list.add(new Ad(R.drawable.shamo, "黄色"));
    //        list.add(new Ad(R.drawable.kola, "考拉"));
    //        list.add(new Ad(R.drawable.qier, "腾讯"));
    //        list.add(new Ad(R.drawable.yujinxiang, "明日黄花"));
    //        list.add(new Ad(R.drawable.dengta, "房子"));
    //        list.add(new Ad(R.drawable.juhua, "花"));
    //        list.add(new Ad(R.drawable.baxian, "八仙"));
    //        initDots();
    //        viewPager.setAdapter(new MyPagerAdapter());
    //        int centerValue = Integer.MAX_VALUE / 2;
    //        int value = centerValue % list.size();
    //        //设置viewPager的第一页为最大整数的中间数，实现伪无限循环
    //        viewPager.setCurrentItem(centerValue - value);
    //        updateIntroAndDot();
    //        quitHandle.sendEmptyMessageDelayed(0, 4000);
    //    }

    //初始化文字下方的圆点
    //    private void initDots() {
    //        for (int i = 0; i < list.size(); i++) {
    //            View view = new View(this);
    //            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(8, 8);
    //            if (i != 0) {
    //                params.leftMargin = 5;
    //            }
    //            view.setLayoutParams(params);
    //            view.setBackgroundResource(R.drawable.selector_dot);
    //            dot_layout.addView(view);
    //        }
    //    }

    //初始化监听器，当页面改变时，更新其相应数据
    //    private void initListener() {
    //        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
    //            @Override
    //            public void onPageSelected(int position) {
    //                updateIntroAndDot();
    //            }
    //
    //            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    //            }
    //
    //            public void onPageScrollStateChanged(int state) {
    //            }
    //        });
    //    }

    //更新数据与圆点
    //    private void updateIntroAndDot() {
    //        int currentPage = viewPager.getCurrentItem() % list.size();
    //        tv_intro.setText(list.get(currentPage).getIntro());
    //        for (int i = 0; i < dot_layout.getChildCount(); i++)
    //            dot_layout.getChildAt(i).setEnabled(i == currentPage);
    //    }

    //    @Override
    //    public void onStart() {
    //        super.onStart();

    // ATTENTION: This was auto-generated to implement the App Indexing API.
    // See https://g.co/AppIndexing/AndroidStudio for more information.
    //        client.connect();
    //        Action viewAction = Action.newAction(
    //                Action.TYPE_VIEW, // TODO: choose an action type.
    //                "Main Page", // TODO: Define a title for the content shown.
    //                // TODO: If you have web page content that matches this app activity's content,
    //                // make sure this auto-generated web page URL is correct.
    //                // Otherwise, set the URL to null.
    //                Uri.parse("http://host/path"),
    //                // TODO: Make sure this auto-generated app deep link URI is correct.
    //                Uri.parse("android-app://com.example.homepages/http/host/path")
    //        );
    //        AppIndex.AppIndexApi.start(client, viewAction);
    //    }

    //    @Override
    //    public void onStop() {
    //        super.onStop();
    //
    //        // ATTENTION: This was auto-generated to implement the App Indexing API.
    //        // See https://g.co/AppIndexing/AndroidStudio for more information.
    //        Action viewAction = Action.newAction(
    //                Action.TYPE_VIEW, // TODO: choose an action type.
    //                "Main Page", // TODO: Define a title for the content shown.
    //                // TODO: If you have web page content that matches this app activity's content,
    //                // make sure this auto-generated web page URL is correct.
    //                // Otherwise, set the URL to null.
    //                Uri.parse("http://host/path"),
    //                // TODO: Make sure this auto-generated app deep link URI is correct.
    //                Uri.parse("android-app://com.example.homepages/http/host/path")
    //        );
    //        AppIndex.AppIndexApi.end(client, viewAction);
    //        client.disconnect();
    //    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_old_judje:
                Intent intent_judge = new Intent(oldMainActivity.this, game_judgeActivity.class);
                intent_judge.putExtra("memberID", memberID);
                startActivity(intent_judge);
                break;
            case R.id.tv_old_seting:
                //startActivity(new Intent(oldMainActivity.this, seetingActivity.class));
                break;
            case R.id.tv_old_puzzle:
                Log.i("TAG", "拼图被点击了");
                Intent intent_puzzle = new Intent(oldMainActivity.this, gamestart.class);
                intent_puzzle.putExtra("memberID", memberID);
                startActivity(intent_puzzle);
                break;
            case R.id.tv_old_family:
                Intent intent_familyinfo = new Intent(oldMainActivity.this, familyInformation.class);
                intent_familyinfo.putExtra("memberID", memberID);
                startActivity(intent_familyinfo);
                //                startActivity(new Intent(oldMainActivity.this, familyInformation.class));
                break;
            case R.id.tv_old_result:
                Intent intent_record = new Intent(oldMainActivity.this, GameRecord.class);
                intent_record.putExtra("memberID", memberID);
                startActivity(intent_record);
                break;
        }
    }

    //ViewPager的主体部分
    //    class MyPagerAdapter extends PagerAdapter {
    //        /**
    //         * 返回多少page
    //         */
    //        public int getCount() {
    //            return Integer.MAX_VALUE;
    //        }
    //
    //        /**
    //         * view滑动到一半时是否创建新的view
    //         * true:表示不去创建，使用缓存；false:去重新创建
    //         */
    //        @Override
    //        public boolean isViewFromObject(View view, Object object) {
    //            return view == object;
    //        }
    //
    //        /**
    //         * 类似于BaseAdapter的getView方法
    //         */
    //        @Override
    //        public Object instantiateItem(ViewGroup container, int position) {
    //            View view = View.inflate(oldMainActivity.this, R.layout.adapter_ad, null);
    //            ImageView imageView = (ImageView) view.findViewById(R.id.image);
    //            Ad ad = list.get(position % list.size());
    //            imageView.setImageResource(ad.getIconResId());
    //            container.addView(view);
    //            return view;
    //        }
    //
    //        /**
    //         * @param position:当前需要销毁第几个page
    //         * @param object:当前需要销毁的page
    //         */
    //        @Override
    //        public void destroyItem(ViewGroup container, int position, Object object) {
    //            //super.destroyItem(container, position, object);
    //            container.removeView((View) object);
    //        }
    //    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
    private static boolean isExit = false;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };
    private void exit() {
        if (!isExit) {
            isExit = true;
            ToastUtil.showToast(oldMainActivity.this, "再按一次退出程序");
            //            Toast.makeText(getApplicationContext(), ,
            //                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            quitHandle.sendEmptyMessageDelayed(0, 1500);
        } else {
            finish();
            System.exit(0);
        }
    }
}
