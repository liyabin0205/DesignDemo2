package com.app.designdemo2;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author: liyabin
 * @description:
 * @projectName: DesignDemo2
 * @date: 2016-09-03
 * @time: 17:40
 */
public class MyBehavior extends CoordinatorLayout.Behavior {

    public MyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        if (dy > 0) {
            ViewCompat.animate(child).scaleX(0).scaleY(0).start();
        } else {
            ViewCompat.animate(child).scaleX(1).scaleY(1).start();
        }
    }
}
