package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {
    private boolean Bt = false;
    private boolean Bu = false;
    private final Runnable Bv = new Runnable() {
        public final void run() {
            ContentLoadingProgressBar.this.Bt = false;
            ContentLoadingProgressBar.this.mStartTime = -1;
            ContentLoadingProgressBar.this.setVisibility(8);
        }
    };
    private final Runnable Bw = new Runnable() {
        public final void run() {
            ContentLoadingProgressBar.this.Bu = false;
            if (!ContentLoadingProgressBar.this.qd) {
                ContentLoadingProgressBar.this.mStartTime = System.currentTimeMillis();
                ContentLoadingProgressBar.this.setVisibility(0);
            }
        }
    };
    private long mStartTime = -1;
    private boolean qd = false;

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        co();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        co();
    }

    private void co() {
        removeCallbacks(this.Bv);
        removeCallbacks(this.Bw);
    }
}
