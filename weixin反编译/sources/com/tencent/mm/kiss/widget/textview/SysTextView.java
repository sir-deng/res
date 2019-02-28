package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStructure;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;

public class SysTextView extends TextView implements a {
    private static boolean gVO = false;
    private static Field gVP = null;
    public g gVA = new g(this, new a());

    public SysTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SysTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        super.setText(" ", BufferType.SPANNABLE);
        this.gVA.gVC = new a();
        this.gVA.gVC.textColor = super.getTextColors().getDefaultColor();
        this.gVA.gVC.gVo = super.getEllipsize();
        this.gVA.gVC.gravity = super.getGravity();
        this.gVA.gVC.gVS = super.getTextSize();
        if (!gVO) {
            try {
                if (gVP == null) {
                    Field declaredField = TextView.class.getDeclaredField("mSingleLine");
                    gVP = declaredField;
                    declaredField.setAccessible(true);
                }
                if (gVP.getBoolean(this)) {
                    this.gVA.gVC.maxLines = 1;
                }
            } catch (Exception e) {
                x.e("MicroMsg.SysPLTextView", "initSingleLine error: %s", e.getMessage());
                gVO = true;
            }
        }
    }

    protected final f Ep() {
        if (this.gVA == null) {
            return null;
        }
        return this.gVA.Ep();
    }

    public final a El() {
        if (this.gVA == null) {
            return null;
        }
        return this.gVA.gVC;
    }

    public void setSingleLine(boolean z) {
        if (this.gVA != null) {
            this.gVA.setSingleLine(z);
        }
    }

    public void setLines(int i) {
        if (this.gVA != null) {
            this.gVA.setLines(i);
        }
    }

    public boolean onPreDraw() {
        return true;
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        q(charSequence);
    }

    public final void q(CharSequence charSequence) {
        if (this.gVA == null) {
            super.setText("");
        } else {
            this.gVA.setText(charSequence, false);
        }
    }

    public void setTextSize(float f) {
        setTextSize(0, f);
    }

    public void setTextSize(int i, float f) {
        if (this.gVA != null) {
            this.gVA.setTextSize(i, f);
        }
    }

    public void setTextColor(int i) {
        if (this.gVA != null) {
            this.gVA.setTextColor(i);
        }
    }

    public void setGravity(int i) {
        if (this.gVA != null) {
            this.gVA.setGravity(i);
        }
    }

    public void setMaxLines(int i) {
        if (this.gVA != null) {
            this.gVA.setMaxLines(i);
        }
    }

    public void setMinLines(int i) {
        if (this.gVA != null) {
            g gVar = this.gVA;
            if (gVar.gVC.minLines != i) {
                gVar.gVC.minLines = i;
                gVar.Eq();
                gVar.gVL.requestLayout();
                gVar.gVL.invalidate();
            }
        }
    }

    public void setLayoutParams(LayoutParams layoutParams) {
        if (this.gVA != null) {
            this.gVA.Eq();
        }
        super.setLayoutParams(layoutParams);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (this.gVA != null) {
            this.gVA.Eq();
        }
        super.setPadding(i, i2, i3, i4);
    }

    public CharSequence getText() {
        if (this.gVA == null) {
            return null;
        }
        return this.gVA.getText();
    }

    public float getTextSize() {
        if (this.gVA == null) {
            return 0.0f;
        }
        return this.gVA.getTextSize();
    }

    public int getLineCount() {
        if (this.gVA == null) {
            return 0;
        }
        return this.gVA.getLineCount();
    }

    public int getLineHeight() {
        if (this.gVA == null) {
            return 0;
        }
        return this.gVA.getLineHeight();
    }

    public int getSelectionStart() {
        if (getText() == null) {
            return -1;
        }
        return Selection.getSelectionStart(getText());
    }

    public int getSelectionEnd() {
        if (getText() == null) {
            return -1;
        }
        return Selection.getSelectionEnd(getText());
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        if (this.gVA != null) {
            this.gVA.gVI = z;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gVA.Eo() == null) {
            return false;
        }
        boolean v = this.gVA.v(motionEvent);
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (v) {
            return true;
        }
        return onTouchEvent;
    }

    public boolean performClick() {
        if (this.gVA != null && this.gVA.performClick()) {
            return super.performClick();
        }
        return false;
    }

    protected void onDraw(Canvas canvas) {
        try {
            if (this.gVA != null) {
                this.gVA.onDraw(canvas);
            }
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.SysPLTextView", th, "", new Object[0]);
        }
    }

    public final int Eg() {
        if (this.gVA == null) {
            return 0;
        }
        return this.gVA.gVF;
    }

    public final int Eh() {
        if (this.gVA == null) {
            return 0;
        }
        return this.gVA.gVG;
    }

    protected void onMeasure(int i, int i2) {
        try {
            Point aU = this.gVA.aU(i, i2);
            if (aU != null) {
                setMeasuredDimension(aU.x, aU.y);
            } else {
                super.onMeasure(i, i2);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SysPLTextView", e, "onMeasure error: %s", e.getMessage());
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.SysPLTextView", e2, "", new Object[0]);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
    }

    public void onHoverChanged(boolean z) {
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onProvideStructure(ViewStructure viewStructure) {
        try {
            super.onProvideStructure(viewStructure);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SysPLTextView", e, "onProvideStructure error: %s", e.getMessage());
        }
    }

    public void dispatchProvideStructure(ViewStructure viewStructure) {
    }

    public int getBaseline() {
        try {
            return super.getBaseline();
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.SysPLTextView", th, "", new Object[0]);
            return -1;
        }
    }
}
