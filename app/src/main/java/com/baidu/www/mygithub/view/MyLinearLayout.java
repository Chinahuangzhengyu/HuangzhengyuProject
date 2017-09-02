package com.baidu.www.mygithub.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.www.mygithub.R;

/**
 * Created by 黄郑宇 on 2017/9/2.
 */

public class MyLinearLayout extends LinearLayout {

    private Button myleftbtn;
    private Button myrightbtn;
    private TextView tv;
    private MyLiftOnClickLintener lintener;
    private MyRightOnClickLintener rightlintener;

    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initview(context,attrs);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public interface MyLiftOnClickLintener{
        void Click(View view);
    }

    public void setRightlintener(MyRightOnClickLintener lintener) {
        rightlintener = lintener;
    }
    public interface MyRightOnClickLintener{
        void Click(View view);
    }

    public void setLintener(MyLiftOnClickLintener rightlintener) {
        lintener = rightlintener;
    }



    private void initview(Context context, AttributeSet attrs) {
        View view = LayoutInflater.from(context).inflate(R.layout.myitem, this);
        myleftbtn = (Button) view.findViewById(R.id.myleftbtn);
        myrightbtn = (Button) view.findViewById(R.id.myrightbtn);
        tv = (TextView) view.findViewById(R.id.mytitle);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MyLinearLayout);
        Drawable leftcolor = array.getDrawable(R.styleable.MyLinearLayout_leftbackground);
        Drawable rightcolor = array.getDrawable(R.styleable.MyLinearLayout_rightbackground);
        int centercolor = array.getColor(R.styleable.MyLinearLayout_titlebackground, 0xffffff);
        int lefttextcolor = array.getColor(R.styleable.MyLinearLayout_lefttextColor, 0xffffff);
        int righttextcolor = array.getColor(R.styleable.MyLinearLayout_righttextColor, 0xffffff);
        int titletextcolor = array.getColor(R.styleable.MyLinearLayout_titletextColor, 0xffffff);
        float textSize = array.getDimension(R.styleable.MyLinearLayout_titletextSize, 12);
        float lefttextSize = array.getDimension(R.styleable.MyLinearLayout_righttextSize, 12);
        float righttextSize = array.getDimension(R.styleable.MyLinearLayout_lefttextSize, 12);
        String left = array.getString(R.styleable.MyLinearLayout_lefttext);
        String right = array.getString(R.styleable.MyLinearLayout_righttext);
        String title = array.getString(R.styleable.MyLinearLayout_titletext);
        tv.setText(title);
        tv.setTextColor(titletextcolor);
        tv.setBackgroundColor(centercolor);
        tv.setTextSize(textSize);
        myleftbtn.setText(left);
        myleftbtn.setTextColor(lefttextcolor);
        myleftbtn.setBackground(leftcolor);
        myleftbtn.setBackgroundDrawable(leftcolor);
        myleftbtn.setTextSize(lefttextSize);
        myrightbtn.setText(right);
        myrightbtn.setTextColor(righttextcolor);
        myrightbtn.setTextSize(righttextSize);
        myrightbtn.setBackground(rightcolor);
        myleftbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                lintener.Click(v);
            }
        });
        myrightbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                rightlintener.Click(v);
            }
        });
    }


}
