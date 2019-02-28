package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.test.suitebuilder.annotation.Suppress;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.sdk.platformtools.x;

public class MMTextView extends TextView {
    private long gBK = -1;
    public b yFI = null;
    private GestureDetector yFJ = null;
    private boolean zEA = false;
    private boolean zEB = false;
    private boolean zEC = false;
    private boolean zED = false;
    private a zEE = null;

    public interface a {
        void a(CharSequence charSequence, long j);
    }

    public interface b {
        boolean do(View view);
    }

    public MMTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.yFJ = new GestureDetector(getContext(), new SimpleOnGestureListener() {
            public final boolean onDoubleTap(MotionEvent motionEvent) {
                if (MMTextView.this.yFI == null) {
                    return false;
                }
                return MMTextView.this.yFI.do(MMTextView.this);
            }
        });
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = action == 1 && this.zEA;
        if (z) {
            x.d("MicroMsg.MMTextView", "ignore Action Up Event this time");
            return true;
        }
        boolean z2;
        if (action == 0) {
            this.zEA = false;
        }
        if (this.yFI == null || this.yFJ == null) {
            z2 = false;
        } else {
            z2 = this.yFJ.onTouchEvent(motionEvent);
        }
        if (z2) {
            return z2;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Suppress
    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText(charSequence, bufferType);
        if (this.zEE != null && this.zEB && (charSequence instanceof Spannable) && ((Spannable) charSequence).getSpans(0, charSequence.length(), Object.class) != null) {
            this.zEE.a(charSequence, this.gBK);
        }
        this.zEC = false;
    }

    public void cancelLongPress() {
        x.d("MicroMsg.MMTextView", "cancelLongPress , should ignore Action Up Event next time");
        this.zEA = true;
        super.cancelLongPress();
    }

    public boolean performLongClick() {
        x.d("MicroMsg.MMTextView", "performLongClick , should ignore Action Up Event next time");
        this.zEA = true;
        return super.performLongClick();
    }

    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.MMTextView", th, "", new Object[0]);
        }
    }

    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.MMTextView", th, "", new Object[0]);
        }
    }

    public boolean onPreDraw() {
        try {
            return super.onPreDraw();
        } catch (Throwable th) {
            return true;
        }
    }

    public int getBaseline() {
        try {
            return super.getBaseline();
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.MMTextView", th, "", new Object[0]);
            return -1;
        }
    }
}
