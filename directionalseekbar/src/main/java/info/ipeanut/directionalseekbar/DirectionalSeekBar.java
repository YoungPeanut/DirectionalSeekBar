package info.ipeanut.directionalseekbar;

import android.content.Context;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by chenshao on 16/3/29.
 */
public class DirectionalSeekBar extends AppCompatSeekBar {
    public DirectionalSeekBar(Context context) {
        super(context);
    }

    public DirectionalSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DirectionalSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    private void trackTouchEvent(MotionEvent event) {
        final int Height = getHeight();
        Log.d("demon", "Y:" + event.getY() + " height:" + Height);
        final int available = Height - getPaddingBottom() - getPaddingTop();
        int Y = (int)event.getY();
        float scale;
        float progress = 0;
        if (Y > Height - getPaddingBottom()) {
            scale = 0.0f;
        } else if (Y  < getPaddingTop()) {
            scale = 1.0f;
        } else {
            scale = (float)(Height - getPaddingBottom()-Y) / (float)available;
        }

        final int max = getMax();
        progress = scale * max;
        setProgress((int) progress);
    }
}
