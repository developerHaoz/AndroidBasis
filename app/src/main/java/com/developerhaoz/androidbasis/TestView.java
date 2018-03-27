package com.developerhaoz.androidbasis;

import android.content.Context;
import android.support.annotation.Px;
import android.view.View;

import java.util.Deque;

/**
 * @author Haoz
 * @date 2018/3/26.
 */
public class TestView extends View {

    public TestView(Context context) {
        super(context);
    }

    @Override
    public void layout(@Px int l, @Px int t, @Px int r, @Px int b) {
        super.layout(l, t, r, b);
        Deque deque;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
