package com.example.yzu_community;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class RoundedCornerLayout extends LinearLayout {
    //自定义圆角矩形控件

    private Paint paint;
    private RectF rect;

    private float cornerRadius; //圆角弧度

    private int backgroundColor;//背景颜色

    public RoundedCornerLayout(Context context) {
        super(context);
        init();
    }

    public RoundedCornerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        @SuppressLint("Recycle") TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RoundedCornerLayout);
        backgroundColor = a.getColor(R.styleable.RoundedCornerLayout_backgroundColor, Color.WHITE);
        cornerRadius = a.getDimension(R.styleable.RoundedCornerLayout_cornerRadius, 40);
        setBackgroundColor(getResources().getColor(R.color.recttemp));
        init();
    }

    public RoundedCornerLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(backgroundColor);
        paint.setAntiAlias(true);
        rect = new RectF();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        rect.set(0, 0, getWidth(), getHeight());
        canvas.drawRoundRect(rect, cornerRadius, cornerRadius, paint);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        super.dispatchDraw(canvas); //绘制子控件
        canvas.clipRect(getLeft(), getTop(), getRight(), getBottom());
        canvas.restore();
    }
}
