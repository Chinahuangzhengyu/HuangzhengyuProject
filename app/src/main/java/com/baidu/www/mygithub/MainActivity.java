package com.baidu.www.mygithub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.baidu.www.mygithub.view.MyLinearLayout;

public class MainActivity extends AppCompatActivity {

    private MyLinearLayout mytitlelinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mytitlelinear = (MyLinearLayout) findViewById(R.id.mytitlelinear);
        mytitlelinear.setLintener(new MyLinearLayout.MyLiftOnClickLintener() {
            @Override
            public void Click(View view) {
                Toast.makeText(MainActivity.this, "点击了返回", Toast.LENGTH_SHORT).show();
            }
        });
        mytitlelinear.setRightlintener(new MyLinearLayout.MyRightOnClickLintener() {
            @Override
            public void Click(View view) {
                Toast.makeText(MainActivity.this, "点击了更多", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
