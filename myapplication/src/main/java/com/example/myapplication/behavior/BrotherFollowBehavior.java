package com.example.myapplication.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.example.myapplication.DependedView;

public class BrotherFollowBehavior extends CoordinatorLayout.Behavior<View> {
    public BrotherFollowBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof DependedView;
    }
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        child.setY(dependency.getBottom() + 50);
        child.setX(dependency.getX());
        return true;
    }
}
