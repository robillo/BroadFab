package com.robillo.broadfab;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by robinkamboj on 15/08/17.
 */

public class BroadFab extends LinearLayout{

    static public FloatingActionButton fab1, fab2, fabMid, fab4, fab5;

    public BroadFab(Context context) {
        super(context);
        init(context, null);
    }

    public BroadFab(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public BroadFab(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BroadFab(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet set){
        View v = inflate(context, R.layout.broad_fab, this);
        setGravity(Gravity.CENTER);
        fab1 = v.findViewById(R.id.one);
        fab2 = v.findViewById(R.id.two);
        fabMid = v.findViewById(R.id.three);
        fab4 = v.findViewById(R.id.four);
        fab5 = v.findViewById(R.id.five);
        setInitial();
    }

    private static void setInitial(){
        
    }

    public static void hideAll(){

    }

    public static void showAll(){

    }
}
