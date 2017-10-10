package xiaoheihei.example.com.valueanimatortest;

import android.animation.PointFEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

/**
 * Created by xhh on 2017/10/10.
 */

public class MyPointView extends View {
    private Point CurPoint;
    public MyPointView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (CurPoint != null){
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(300,300,CurPoint.getRadius(),paint);
        }
    }
    public void doPointAnim(){
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new PointEvaluator(),new Point(20),new Point(200));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CurPoint = (Point) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.setDuration(1000);
        valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.start();
    }

    }
