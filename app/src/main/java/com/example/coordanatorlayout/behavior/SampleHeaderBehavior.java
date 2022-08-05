package com.example.coordanatorlayout.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

public class SampleHeaderBehavior extends CoordinatorLayout.Behavior<TextView> {
    private int mOffsetTopAndBottom;
    private int mLayoutTop;
    public SampleHeaderBehavior(){

    }
    public SampleHeaderBehavior(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    @Override
    public boolean onLayoutChild(@NonNull CoordinatorLayout parent, @NonNull TextView child, int layoutDirection) {
        parent.onLayoutChild(child,layoutDirection);
        mLayoutTop = child.getTop();
        return true;
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return true;
    }


    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        int consumedy = 0;//记录消费的距离
        int offset = mOffsetTopAndBottom - dy;
        //因为offset是带方向的，这里获取到最大可滑动距离需要在前面添加负号
        int minOffset = -getChildScrollRange(child);
        int maxOffset = 0;
        offset = offset<minOffset? minOffset:(Math.min(offset, maxOffset));
        ViewCompat.offsetTopAndBottom(child,offset-(child.getTop()-mLayoutTop));
        consumedy = mOffsetTopAndBottom - offset;
        //将本次滑动到的位置记录下来
        mOffsetTopAndBottom = offset;
        consumed[1] = consumedy;
    }

    //获取childView最大可滑动距离
    private int getChildScrollRange(View childView){
        if (childView==null){
            return 0;
        }
        return childView.getHeight();
    }
}
