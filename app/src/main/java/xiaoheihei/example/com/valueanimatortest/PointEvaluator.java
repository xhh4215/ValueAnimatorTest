package xiaoheihei.example.com.valueanimatortest;

import android.animation.TypeEvaluator;

/**
 * Created by xhh on 2017/10/10.
 */

public class PointEvaluator implements TypeEvaluator<Point> {
    @Override
    public Point evaluate(float v, Point point1, Point point2) {
        int radius1 = point1.getRadius();
        int radius2 = point2.getRadius();
        int curValue = (int) (radius1 + (radius2 - radius1) * v);
        return new Point(curValue);
    }
}
