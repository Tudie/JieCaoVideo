package cn.jzvd.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import cn.jzvd.Jzvd;
import cn.jzvd.demo.CustomJzvd.MyJzvdStd;

/**
 * Created by Nathen on 16/7/22.
 */
public class ActivityMain extends AppCompatActivity {

    MyJzvdStd myJzvdStd;
    private boolean is = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myJzvdStd = findViewById(R.id.jz_video);

        myJzvdStd.setUp("https://xy-pub.oss-cn-shenzhen.aliyuncs.com/license/202011_5fc0951d0899engcubp.mp4"
                , "饺子快长大");

        Glide.with(this).load("https://xy-pub.oss-cn-shenzhen.aliyuncs.com/license/202011_5fc0951d0899engcubp.mp4").into(myJzvdStd.thumbImageView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    public void clicksy(View view) {
        if (is) {
            myJzvdStd.mediaInterface.setVolume(0f,0f);
        } else {
            myJzvdStd.mediaInterface.setVolume(1f,1f);
        }
    }

    public void clickApi(View view) {
        startActivity(new Intent(ActivityMain.this, ActivityApi.class));
    }

    public void clickListView(View view) {
        startActivity(new Intent(ActivityMain.this, ActivityListView.class));
    }

    public void clickTinyWindow(View view) {
        startActivity(new Intent(ActivityMain.this, ActivityTinyWindow.class));
    }

    public void clickDirectPlay(View view) {
        startActivity(new Intent(ActivityMain.this, ActivityDirectPlay.class));
    }

    public void clickWebView(View view) {
        startActivity(new Intent(ActivityMain.this, ActivityWebView.class));
    }

}
