package com.example.student.personalfinancetracker;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.GestureDetector.OnGestureListener;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity implements OnGestureListener{
    GestureDetector gestureDetector;
    int curMth;
    int curYear;

    Map<Integer, String> monthMap = new HashMap<Integer, String>() {{
        put(0, "January");
        put(1, "February");
        put(2, "March");
        put(3, "April");
        put(4, "May");
        put(5, "June");
        put(6, "July");
        put(7, "August");
        put(8, "September");
        put(9, "October");
        put(10, "November");
        put(11, "December");
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gestureDetector = new GestureDetector(MainActivity.this, MainActivity.this);

        Calendar calendar = Calendar.getInstance();
        curMth = calendar.get(Calendar.MONTH);
        curYear = calendar.get(Calendar.YEAR);

        Toolbar mActionBarToolbar = (Toolbar) findViewById(R.id.monthDisplay);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle(monthMap.get(curMth) + ' ' + Integer.toString(curYear));
    }

    @Override
    public boolean onFling(MotionEvent motionEvent1, MotionEvent motionEvent2, float X, float Y) {
        float distanceY = motionEvent1.getY() - motionEvent2.getY();
        float distanceX = motionEvent1.getX() - motionEvent2.getX();
        double angle = Math.atan(Math.abs(distanceY/distanceX)) * 180/Math.PI;
        if (distanceX < 50 && angle < 30) {
            if (curMth != 0) {
                curMth -= 1;
            }
            else{
                curMth = 11;
                curYear -= 1;
            }
        }

        if (distanceX > 50 && angle < 30) {
            if (curMth != 11) {
                curMth += 1;
            }
            else{
                curMth = 0;
                curYear += 1;
            }
        }

        Toolbar mActionBarToolbar = (Toolbar) findViewById(R.id.monthDisplay);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle(monthMap.get(curMth) + ' ' + Integer.toString(curYear));

        return true;
    }

    @Override
    public void onLongPress(MotionEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onShowPress(MotionEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean onSingleTapUp(MotionEvent arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        // TODO Auto-generated method stub
        return gestureDetector.onTouchEvent(motionEvent);
    }

    @Override
    public boolean onDown(MotionEvent arg0) {
        // TODO Auto-generated method stub
        return false;
    }
}
