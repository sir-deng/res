package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bu.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.v.a.d;
import com.tencent.mm.v.a.e;
import com.tencent.mm.v.a.f;

public class MMTabView extends ViewGroup {
    private TextView ikL;
    private int index;
    private int padding;
    public int qnf;
    private TextView xQm;
    private ImageView xSY;

    public MMTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qnf = 3;
        this.padding = 0;
        init();
    }

    public MMTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.qnf = 3;
        this.padding = 0;
        init();
    }

    private MMTabView(Context context) {
        super(context);
        this.qnf = 3;
        this.padding = 0;
        init();
    }

    public MMTabView(Context context, int i) {
        this(context);
        this.index = i;
        cnS();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cnS() {
        /*
        r10 = this;
        r9 = 2;
        r8 = 1;
        r1 = 0;
        r0 = "MicroMsg.MMTabView";
        r2 = "jacks build : %d desc, unread: %s";
        r3 = new java.lang.Object[r9];
        r4 = r10.index;
        r4 = java.lang.Integer.valueOf(r4);
        r3[r1] = r4;
        r4 = r10.cnT();
        r3[r8] = r4;
        com.tencent.mm.sdk.platformtools.x.d(r0, r2, r3);
        r2 = com.tencent.mm.ui.a.a.a.xVN;
        r0 = r10.ikL;
        r0 = r0.getText();
        r0 = r0.toString();
        r3 = r10.cnT();
        r4 = r10.index;
        r5 = r2.cov();
        if (r5 == 0) goto L_0x0042;
    L_0x0036:
        if (r10 == 0) goto L_0x0042;
    L_0x0038:
        r5 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r5 != 0) goto L_0x0042;
    L_0x003e:
        r5 = r2.tI;
        if (r5 != 0) goto L_0x0043;
    L_0x0042:
        return;
    L_0x0043:
        r5 = new com.tencent.mm.ui.a.b;
        r5.<init>();
        r5.YZ(r0);
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r3);
        if (r0 != 0) goto L_0x0097;
    L_0x0051:
        r0 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.getInt(r3, r0);	 Catch:{ Exception -> 0x0096 }
        if (r0 <= 0) goto L_0x0097;
    L_0x0058:
        if (r0 <= 0) goto L_0x0071;
    L_0x005a:
        r3 = r2.tI;
        r3 = r3.getResources();
        r6 = com.tencent.mm.v.a.i.gZW;
        r7 = new java.lang.Object[r8];
        r0 = java.lang.Integer.valueOf(r0);
        r7[r1] = r0;
        r0 = r3.getQuantityString(r6, r8, r7);
        r5.YZ(r0);
    L_0x0071:
        r0 = r2.tI;
        r0 = r0.getResources();
        r2 = com.tencent.mm.v.a.i.gZX;
        r3 = 5;
        r6 = new java.lang.Object[r9];
        r7 = 3;
        r7 = java.lang.Integer.valueOf(r7);
        r6[r1] = r7;
        r1 = r4 + 1;
        r1 = java.lang.Integer.valueOf(r1);
        r6[r8] = r1;
        r0 = r0.getQuantityString(r2, r3, r6);
        r5.YZ(r0);
        r5.dg(r10);
        goto L_0x0042;
    L_0x0096:
        r0 = move-exception;
    L_0x0097:
        r0 = r1;
        goto L_0x0058;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.MMTabView.cnS():void");
    }

    private void init() {
        int ev;
        this.padding = getResources().getDimensionPixelSize(e.bvW);
        String cfV = w.cfV();
        boolean cfR = w.cfR();
        boolean equalsIgnoreCase = cfV.equalsIgnoreCase("en");
        if (cfR) {
            ev = (int) (a.ev(getContext()) * ((float) a.fromDPToPix(getContext(), 2)));
        } else {
            ev = 0;
        }
        this.ikL = new TextView(getContext());
        this.ikL.setSingleLine();
        this.ikL.setEllipsize(TruncateAt.END);
        this.ikL.setTextColor(getResources().getColorStateList(d.buj));
        this.ikL.setTextSize(0, (float) a.aa(getContext(), e.bvt));
        this.ikL.setText("");
        if (cfR) {
            this.ikL.setTextSize(0, ((float) ev) + this.ikL.getTextSize());
            this.ikL.setTypeface(null, 0);
        } else if (equalsIgnoreCase) {
            this.ikL.setTypeface(null, 1);
        }
        addView(this.ikL);
        this.xSY = new ImageView(getContext());
        this.xSY.setBackgroundResource(f.gWP);
        this.xSY.setVisibility(4);
        addView(this.xSY);
        this.xQm = new TextView(getContext());
        this.xQm.setTextColor(getResources().getColor(d.white));
        this.xQm.setTextSize(1, 11.0f);
        this.xQm.setBackgroundResource(s.ge(getContext()));
        this.xQm.setTypeface(Typeface.DEFAULT_BOLD);
        this.xQm.setGravity(17);
        this.xQm.setVisibility(4);
        addView(this.xQm);
        setBackgroundResource(f.bDr);
    }

    public final void setText(int i) {
        this.ikL.setText(i);
    }

    public final void setTextColor(ColorStateList colorStateList) {
        this.ikL.setTextColor(colorStateList);
    }

    private String cnT() {
        return this.xQm.getText().toString();
    }

    public final void YV(final String str) {
        if (bi.oN(str)) {
            this.xQm.setVisibility(4);
            return;
        }
        this.xQm.setVisibility(0);
        this.xQm.post(new Runnable() {
            public final void run() {
                MMTabView.this.xQm.setText(str);
                MMTabView.this.cnS();
            }
        });
    }

    public final void me(boolean z) {
        this.xSY.setVisibility(z ? 0 : 4);
    }

    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec;
        int size = (MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int size2 = (MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
        if (MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE);
        } else {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        }
        this.ikL.measure(MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), makeMeasureSpec);
        this.xSY.measure(MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), makeMeasureSpec);
        this.xQm.measure(MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), makeMeasureSpec);
        setMeasuredDimension(size, size2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int measuredWidth = (i5 - this.ikL.getMeasuredWidth()) / 2;
        int measuredWidth2 = this.ikL.getMeasuredWidth() + measuredWidth;
        int measuredHeight = (i6 - this.ikL.getMeasuredHeight()) / 2;
        this.ikL.layout(measuredWidth, measuredHeight, measuredWidth2, this.ikL.getMeasuredHeight() + measuredHeight);
        measuredHeight = this.padding + measuredWidth2;
        int measuredHeight2 = (i6 - this.xSY.getMeasuredHeight()) / 2;
        this.xSY.layout(measuredHeight, measuredHeight2, this.xSY.getMeasuredWidth() + measuredHeight, this.xSY.getMeasuredHeight() + measuredHeight2);
        if (measuredWidth - this.padding < this.xQm.getMeasuredWidth()) {
            i5 -= this.xQm.getMeasuredWidth();
            i6 = (i6 - this.xQm.getMeasuredHeight()) / 2;
            this.xQm.layout(i5, i6, this.xQm.getMeasuredWidth() + i5, this.xQm.getMeasuredHeight() + i6);
            return;
        }
        i5 = this.padding + measuredWidth2;
        i6 = (i6 - this.xQm.getMeasuredHeight()) / 2;
        this.xQm.layout(i5, i6, this.xQm.getMeasuredWidth() + i5, this.xQm.getMeasuredHeight() + i6);
    }
}
