package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;

public class AsyncNormalTextView extends CollapsibleTextView {
    public String content;
    private Context context;
    public av rfY;
    private c rxe;
    public int rxf = 0;
    public ay rxg;

    public AsyncNormalTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public final void c(c cVar) {
        this.rxe = cVar;
        bzH();
    }

    public final void bzH() {
        if (!bi.oN(this.content)) {
            System.currentTimeMillis();
            setVisibility(0);
            if (this.rxf == 1) {
                this.content = this.content.length() > 100 ? this.content.substring(0, 100) + "..." : this.content;
                a(this.rxf, new SpannableStringBuilder(i.b(this.context, this.content, this.rxZ.getTextSize())), BufferType.NORMAL, this.rfY.rye, this.rxg.ryG, this.rxg.rPM, this.rfY, this.content, this.rxg.rxi);
            } else if (this.content.length() < 400 || this.rxg.rxi) {
                CharSequence charSequence = null;
                if (this.rxg != null) {
                    charSequence = this.rxg.rPK;
                }
                if (charSequence == null) {
                    charSequence = new SpannableStringBuilder(i.b(this.context, this.content, this.rxZ.getTextSize()));
                }
                if (this.rxg != null) {
                    a(this.rxf, charSequence, BufferType.SPANNABLE, this.rfY.rye, this.rxg.ryG, this.rxg.rPM, this.rfY, this.content, this.rxg.rxi);
                }
            } else {
                a(this.rxf, this.content, BufferType.NORMAL, this.rfY.rye, this.rxg.ryG, this.rxg.rPM, this.rfY, this.content, this.rxg.rxi);
            }
            as asVar = new as(this.rxg.rPM, this.rxg.ryG, false, false, 1);
            this.rxZ.setTag(asVar);
            if (this.rya != null) {
                this.rya.setTag(asVar);
            }
            this.ryb.setTag(this.rxe);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.getText().add(this.content);
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setText(this.content);
    }

    public final void setContentWidth(int i) {
        if (this.rya != null) {
            this.rxZ.rXP = i;
            LayoutParams layoutParams = new LinearLayout.LayoutParams(i, -2);
            this.rya.setLayoutParams(layoutParams);
            this.rxZ.setLayoutParams(layoutParams);
            this.ryb.setLayoutParams(layoutParams);
        }
    }
}
