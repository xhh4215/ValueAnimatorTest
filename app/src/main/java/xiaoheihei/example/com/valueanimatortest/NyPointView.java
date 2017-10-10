package xiaoheihei.example.com.valueanimatortest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by xhh on 2017/10/10.
 */

public class NyPointView extends View{
    private Point mPoint = new Point(100);
    public NyPointView(Context context) {
        super(context);
    }

    public NyPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NyPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        if (mPoint != null){
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(300,300,mPoint.getRadius(),paint);
        }
        super.onDraw(canvas);
    }

    void setPointRadius(int radius){
        mPoint.setRadius(radius);
        invalidate();
    }
}
