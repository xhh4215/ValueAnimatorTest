package xiaoheihei.example.com.valueanimatortest;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;
    private LinearLayout linearlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearlayout = (LinearLayout) findViewById(R.id.linearlayoutid);
        final MyPointView mypointview = new MyPointView(this);
        linearlayout.addView(mypointview);
        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mypointview.doPointAnim();
            }
        });


//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                doAnimation();
//            }
//        });
//        textView = (TextView) findViewById(R.id.tv);
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "clicked me", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    private void doAnimation() {
        ValueAnimator valueanimator = ValueAnimator.ofInt(0, 100, 50, 200);
        valueanimator.setDuration(1000);
        valueanimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int curvalue = (int) valueAnimator.getAnimatedValue();
                textView.layout(curvalue, curvalue, curvalue + textView.getWidth(), curvalue + textView.getHeight());
            }
        });
        valueanimator.start();
    }

}
