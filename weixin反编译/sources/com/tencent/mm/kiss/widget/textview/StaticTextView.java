package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Point;
import android.text.Layout;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.bi;

public class StaticTextView extends View implements a {
    protected g gVA = new g(this, Em());

    public StaticTextView(Context context) {
        super(context);
        this.gVA.init();
    }

    public StaticTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gVA.init();
    }

    public StaticTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gVA.init();
    }

    public final a El() {
        if (this.gVA == null) {
            return null;
        }
        return this.gVA.gVC;
    }

    public a Em() {
        return new a();
    }

    public final void b(a aVar) {
        this.gVA.gVC = aVar;
    }

    public final void O(float f) {
        this.gVA.setTextSize(1, f);
    }

    public final void b(f fVar) {
        this.gVA.b(fVar);
    }

    public final void setTextColor(int i) {
        this.gVA.setTextColor(i);
    }

    public final void En() {
        this.gVA.setGravity(16);
    }

    public void setMaxLines(int i) {
        this.gVA.setMaxLines(i);
    }

    public final void setText(CharSequence charSequence, boolean z) {
        this.gVA.setText(charSequence, z);
        setContentDescription(charSequence);
    }

    public void setText(CharSequence charSequence) {
        setText(charSequence, true);
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

    public final CharSequence getText() {
        return this.gVA.getText();
    }

    public final float getTextSize() {
        return this.gVA.getTextSize();
    }

    public final Layout Eo() {
        return this.gVA.Eo();
    }

    public final f Ep() {
        if (this.gVA == null) {
            return null;
        }
        return this.gVA.Ep();
    }

    public final int getLineCount() {
        return this.gVA.getLineCount();
    }

    public final int getLineHeight() {
        return this.gVA.getLineHeight();
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
        super.onDraw(canvas);
        if (this.gVA != null) {
            this.gVA.onDraw(canvas);
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

    public void onMeasure(int i, int i2) {
        if (this.gVA == null) {
            super.onMeasure(i, i2);
            return;
        }
        Point aU = this.gVA.aU(i, i2);
        if (aU != null) {
            setMeasuredDimension(aU.x, aU.y);
        } else {
            super.onMeasure(i, i2);
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

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        if (!bi.N(this.gVA.getText())) {
            accessibilityEvent.getText().add(this.gVA.getText());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (!bi.N(this.gVA.getText())) {
            accessibilityNodeInfo.addAction(256);
            accessibilityNodeInfo.addAction(WXMediaMessage.TITLE_LENGTH_LIMIT);
            accessibilityNodeInfo.setMovementGranularities(31);
            if (d.fN(18)) {
                accessibilityNodeInfo.addAction(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            }
        }
        if (isFocused() && d.fN(18)) {
            accessibilityNodeInfo.addAction(16384);
            accessibilityNodeInfo.addAction(WXMediaMessage.THUMB_LENGTH_LIMIT);
            accessibilityNodeInfo.addAction(65536);
        }
        if (d.fN(19)) {
            g gVar = this.gVA;
            if ((gVar.gVC != null ? gVar.gVC.maxLines : -1) > 1) {
                accessibilityNodeInfo.setMultiLine(true);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 8192) {
            accessibilityEvent.setFromIndex(Selection.getSelectionStart(this.gVA.getText()));
            accessibilityEvent.setToIndex(Selection.getSelectionEnd(this.gVA.getText()));
            if (!bi.N(this.gVA.getText())) {
                accessibilityEvent.setItemCount(this.gVA.getText().length());
            }
        }
    }
}
