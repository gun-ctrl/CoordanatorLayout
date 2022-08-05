package com.example.myapplication.behavior;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.example.myapplication.DependedView;

public class BrotherChameleonBehavior extends CoordinatorLayout.Behavior<View> {
    private ArgbEvaluator mArgbEvaluator = new ArgbEvaluator();
    public BrotherChameleonBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        return dependency instanceof DependedView;
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        int color = (int)mArgbEvaluator.evaluate(dependency.getY()/parent.getHeight(), Color.WHITE,Color.BLACK);
        child.setBackgroundColor(color);
        return false;
    }
}
