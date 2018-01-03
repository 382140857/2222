package com.example.administrator.myapplication;

import android.util.Log;

import java.util.Date;

import static java.lang.Thread.sleep;

/**
 * Created by Administrator on 2017/12/13 0013.
 */

public class mathTest {
    public void main(String[] args) throws InterruptedException {
        Date a =new Date();
        sleep(2000);
        Date b=new Date();
  Log.i("开始时间", String.valueOf(a));
        Log.i("结束时间", String.valueOf(b));

    }
}
