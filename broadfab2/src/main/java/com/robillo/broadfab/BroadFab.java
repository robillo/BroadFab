package com.robillo.broadfab;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

/**
 * Created by robinkamboj on 15/08/17.
 */

public class BroadFab extends LinearLayout implements View.OnClickListener{

    static FloatingActionButton fab1, fab2, fabMid, fab4, fab5;
    static Animation closeFabs, closeMid, openFabs, openMid, alphaInitialMid;
    static boolean isOpen = false;

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
        closeFabs = AnimationUtils.loadAnimation(getContext(), R.anim.close_fabs);
        closeMid = AnimationUtils.loadAnimation(getContext(), R.anim.close_mid);
        openFabs = AnimationUtils.loadAnimation(getContext(), R.anim.open_fabs);
        openMid = AnimationUtils.loadAnimation(getContext(), R.anim.open_mid);
        alphaInitialMid = AnimationUtils.loadAnimation(getContext(), R.anim.alpha_initial_mid);
        fabMid.setAnimation(alphaInitialMid);
        fabMid.setOnClickListener(this);
        visibilitySwitch(isOpen = false);
    }

    private static void visibilitySwitch(boolean b){
        if(b){
            fab1.setVisibility(VISIBLE);
            fab1.setVisibility(VISIBLE);
            fab1.setVisibility(VISIBLE);
            fab1.setVisibility(VISIBLE);
        }
        else {
            fab1.setVisibility(GONE);
            fab2.setVisibility(GONE);
            fab4.setVisibility(GONE);
            fab5.setVisibility(GONE);
        }
    }

    public static void hideAll(){
        visibilitySwitch(isOpen = false);
        fab1.setAnimation(closeFabs);
        fab2.setAnimation(closeFabs);
        fabMid.setAnimation(closeMid);
        fab4.setAnimation(closeFabs);
        fab5.setAnimation(closeFabs);
    }

    public static void showAll(){
        visibilitySwitch(isOpen = true);
        fab1.setAnimation(openFabs);
        fab2.setAnimation(openFabs);
        fabMid.setAnimation(openMid);
        fab4.setAnimation(openFabs);
        fab5.setAnimation(openFabs);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.three){
            if(isFabOpen()){
                Log.e("CLICKED", "CLOSE");
                hideAll();
                isOpen = false;
            }
            else {
                Log.e("CLICKED", "OPEN");
                showAll();
                isOpen = true;
            }
        }
    }

    public static boolean isFabOpen(){
        return isOpen;
    }
}
