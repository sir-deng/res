package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.widget.g.a;
import com.tencent.mm.plugin.appbrand.widget.input.z.b;

public final class o extends w {
    private float jxO;
    private a kaB;
    private final InputFilter kdM = new InputFilter() {
        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            if (TextUtils.isEmpty(charSequence) || o.this.kaB == null) {
                return null;
            }
            if (charSequence instanceof Spannable) {
                charSequence = (Spannable) charSequence;
            } else {
                Object spannableStringBuilder = new SpannableStringBuilder(charSequence);
            }
            charSequence.setSpan(o.this.kaB, 0, charSequence.length(), 18);
            return charSequence;
        }
    };
    private float kdN = 0.0f;
    float kdO = 1.2f;
    private float kdP = getTextSize();
    private boolean kdQ = false;
    private MotionEvent kdR;
    private boolean kdS = false;
    final ac<o> kdT = new ac(this);

    public o(Context context) {
        super(context);
        super.setSingleLine(false);
        super.setLineSpacing(0.0f, 1.0f);
        super.setVerticalScrollbarPosition(2);
        super.setSpannableFactory(new Factory() {
            public final Spannable newSpannable(CharSequence charSequence) {
                Spannable newSpannable = super.newSpannable(charSequence);
                if (!(o.this.kaB == null || TextUtils.isEmpty(newSpannable))) {
                    newSpannable.setSpan(o.this.kaB, 0, newSpannable.length(), 18);
                }
                return newSpannable;
            }
        });
        super.a(new b() {
            public final void anu() {
                o.this.anq();
            }
        });
        super.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                return o.this.amZ();
            }
        });
        this.jxO = (float) ViewConfiguration.get(context).getScaledTouchSlop();
        dy(false);
        a(0.0f, false);
    }

    final Editable c(Editable editable) {
        Editable c = super.c(editable);
        if (!(this.kaB == null || TextUtils.isEmpty(c))) {
            c.setSpan(this.kaB, 0, c.length(), 18);
        }
        return c;
    }

    public final void dy(boolean z) {
        this.kdQ = z;
        setVerticalScrollBarEnabled(!this.kdQ);
    }

    protected final void anq() {
        if (!this.kdQ) {
            return;
        }
        if (getMeasuredHeight() > getMaxHeight()) {
            setMeasuredDimension(getMeasuredWidth(), getMaxHeight());
        } else if (getMeasuredHeight() < getMinHeight() && getMinHeight() > 0) {
            setMeasuredDimension(getMeasuredWidth(), getMinHeight());
        }
    }

    public final void setGravity(int i) {
        super.setGravity(((i & -81) & -17) | 48);
    }

    public final void setSingleLine(boolean z) {
    }

    public final void setInputType(int i) {
        super.setInputType(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT | i);
    }

    public final void setFilters(InputFilter[] inputFilterArr) {
        int i = 0;
        if (this.kdM != null) {
            if (inputFilterArr == null) {
                inputFilterArr = new InputFilter[0];
            }
            InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length + 1)];
            while (i < inputFilterArr.length) {
                inputFilterArr2[i] = inputFilterArr[i];
                i++;
            }
            inputFilterArr2[i] = this.kdM;
            inputFilterArr = inputFilterArr2;
        }
        super.setFilters(inputFilterArr);
    }

    final void a(float f, boolean z) {
        if (f <= 0.0f) {
            f = (this.kdO * this.kdP) + this.kdN;
        }
        if (this.kaB == null || this.kaB.ad(f)) {
            this.kaB = new a(f);
            if (!z) {
                return;
            }
            if (hasFocus()) {
                invalidate();
                return;
            }
            anM();
            setText(getEditableText());
            anN();
        }
    }

    @Deprecated
    public final float getLineSpacingMultiplier() {
        return super.getLineSpacingMultiplier();
    }

    @Deprecated
    public final float getLineSpacingExtra() {
        return super.getLineSpacingExtra();
    }

    public final void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        this.kdP = TypedValue.applyDimension(i, f, getResources().getDisplayMetrics());
        a(0.0f, true);
    }

    public final int getLineHeight() {
        if (this.kaB != null) {
            return this.kaB.height;
        }
        return super.getLineHeight();
    }

    public final void setLineSpacing(float f, float f2) {
        this.kdN = f;
        this.kdO = f2;
        a(0.0f, true);
    }

    public final View getInputPanel() {
        return u.bY(this);
    }

    public final boolean anr() {
        return true;
    }

    public final boolean ans() {
        return false;
    }

    public final void ant() {
        af.cd(this).restartInput(this);
    }

    public final boolean amZ() {
        if (!this.kdQ) {
            anI();
            getMeasuredHeight();
        }
        return (isFocusable() || anv()) ? false : true;
    }

    protected final void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }

    public final void scrollTo(int i, int i2) {
        super.scrollTo(i, i2);
    }

    public final void scrollBy(int i, int i2) {
        super.scrollBy(i, i2);
    }

    public final boolean canScrollVertically(int i) {
        if (anI() <= getHeight()) {
            return false;
        }
        return super.canScrollVertically(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
        r14 = this;
        r10 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r3 = 1;
        r4 = 0;
        r0 = r14.amZ();
        if (r0 == 0) goto L_0x031b;
    L_0x000a:
        r0 = r14.getParent();
        r0 = r0 instanceof com.tencent.mm.plugin.appbrand.widget.b.e;
        if (r0 == 0) goto L_0x031b;
    L_0x0012:
        r0 = r15.getActionMasked();
        if (r0 != 0) goto L_0x0024;
    L_0x0018:
        r0 = r14.getParent();
        r0 = (com.tencent.mm.plugin.appbrand.widget.b.e) r0;
        r0 = r0.D(r15);
        if (r0 == 0) goto L_0x0051;
    L_0x0024:
        r6 = r14.kdT;
        r0 = r6.TAG;
        r1 = "processTouchEvent";
        com.tencent.mm.plugin.appbrand.widget.b.b.a(r0, r1, r15);
        r0 = r6.kfb;
        r1 = r15.getActionIndex();
        r2 = r15.getX(r1);
        r1 = r15.getY(r1);
        r5 = r15.getActionMasked();
        if (r5 == 0) goto L_0x0052;
    L_0x0042:
        r5 = r6.kfe;
        if (r5 != 0) goto L_0x0052;
    L_0x0046:
        r0 = r6.TAG;
        r1 = "[textscroll] no pointer down before, just return";
        com.tencent.mm.sdk.platformtools.x.v(r0, r1);
        r6.anP();
    L_0x0051:
        return r4;
    L_0x0052:
        r5 = r15.getActionMasked();
        switch(r5) {
            case 0: goto L_0x00f7;
            case 1: goto L_0x008f;
            case 2: goto L_0x0140;
            case 3: goto L_0x013a;
            default: goto L_0x0059;
        };
    L_0x0059:
        r1 = r4;
    L_0x005a:
        r7 = r6.kfb;
        r0 = r6.kfb;
        r5 = r0.getText();
        r0 = -1;
        r0 = r7.canScrollVertically(r0);
        if (r0 != 0) goto L_0x006f;
    L_0x0069:
        r0 = r7.canScrollVertically(r3);
        if (r0 == 0) goto L_0x0076;
    L_0x006f:
        r0 = r15.getActionMasked();
        switch(r0) {
            case 0: goto L_0x017f;
            case 1: goto L_0x01b3;
            case 2: goto L_0x01c5;
            case 3: goto L_0x01b3;
            default: goto L_0x0076;
        };
    L_0x0076:
        r3 = r4;
    L_0x0077:
        r4 = r1 | r3;
        r0 = r6.TAG;
        r1 = new java.lang.StringBuilder;
        r2 = "[textscroll] handled | ";
        r1.<init>(r2);
        r1 = r1.append(r4);
        r1 = r1.toString();
        com.tencent.mm.plugin.appbrand.widget.b.b.a(r0, r1, r15);
        goto L_0x0051;
    L_0x008f:
        r5 = r6.TAG;
        r7 = "[apptouch] ACTION_UP, pointerDown %B";
        r8 = new java.lang.Object[r3];
        r9 = r6.kff;
        r9 = java.lang.Boolean.valueOf(r9);
        r8[r4] = r9;
        com.tencent.mm.sdk.platformtools.x.v(r5, r7, r8);
        r5 = r6.kff;
        if (r5 == 0) goto L_0x00da;
    L_0x00a5:
        r5 = r6.kfe;
        if (r5 == 0) goto L_0x00da;
    L_0x00a9:
        r5 = r6.kfb;
        r5 = com.tencent.mm.plugin.appbrand.jsapi.m.c.bI(r5);
        r7 = r6.kfd;
        if (r7 == 0) goto L_0x00d2;
    L_0x00b3:
        r7 = r6.kfd;
        r7 = r7.x;
        r8 = r5.x;
        r7 = r7 - r8;
        r7 = java.lang.Math.abs(r7);
        r7 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1));
        if (r7 > 0) goto L_0x00d2;
    L_0x00c2:
        r7 = r6.kfd;
        r7 = r7.y;
        r5 = r5.y;
        r5 = r7 - r5;
        r5 = java.lang.Math.abs(r5);
        r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1));
        if (r5 <= 0) goto L_0x00e0;
    L_0x00d2:
        r0 = r6.TAG;
        r1 = "[apptouch] check tap on ACTION_UP, but view has moved.";
        com.tencent.mm.sdk.platformtools.x.v(r0, r1);
    L_0x00da:
        r6.anP();
        r1 = r4;
        goto L_0x005a;
    L_0x00e0:
        r5 = r6.kfe;
        r5 = r6.a(r5, r15);
        if (r5 != 0) goto L_0x00f1;
    L_0x00e8:
        r0 = r6.TAG;
        r1 = "[apptouch] check tap on ACTION_UP exceed tap scope";
        com.tencent.mm.sdk.platformtools.x.v(r0, r1);
        goto L_0x00da;
    L_0x00f1:
        r0 = (com.tencent.mm.plugin.appbrand.widget.input.z) r0;
        r0.r(r2, r1);
        goto L_0x00da;
    L_0x00f7:
        r1 = android.view.MotionEvent.obtain(r15);
        r6.kfe = r1;
        r1 = com.tencent.mm.plugin.appbrand.jsapi.m.c.bI(r0);
        r6.kfd = r1;
        if (r0 == 0) goto L_0x0132;
    L_0x0105:
        r2 = r0.getParent();
    L_0x0109:
        if (r2 == 0) goto L_0x0132;
    L_0x010b:
        r1 = r2 instanceof android.view.ViewGroup;
        if (r1 == 0) goto L_0x0132;
    L_0x010f:
        r1 = r2;
        r1 = (android.view.ViewGroup) r1;
        r1 = r1.shouldDelayChildPressedState();
        if (r1 == 0) goto L_0x012d;
    L_0x0118:
        r1 = r3;
    L_0x0119:
        r2 = r6.kfg;
        r0.removeCallbacks(r2);
        if (r1 == 0) goto L_0x0134;
    L_0x0120:
        r1 = r6.kfg;
        r2 = android.view.ViewConfiguration.getTapTimeout();
        r8 = (long) r2;
        r0.postDelayed(r1, r8);
    L_0x012a:
        r1 = r3;
        goto L_0x005a;
    L_0x012d:
        r2 = r2.getParent();
        goto L_0x0109;
    L_0x0132:
        r1 = r4;
        goto L_0x0119;
    L_0x0134:
        r0 = r6.kfg;
        r0.run();
        goto L_0x012a;
    L_0x013a:
        r6.anP();
        r1 = r4;
        goto L_0x005a;
    L_0x0140:
        r5 = r6.kfc;
        r7 = -r5;
        r7 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1));
        if (r7 < 0) goto L_0x017a;
    L_0x0147:
        r7 = -r5;
        r7 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1));
        if (r7 < 0) goto L_0x017a;
    L_0x014c:
        r7 = r0.getWidth();
        r7 = (float) r7;
        r7 = r7 + r5;
        r2 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1));
        if (r2 >= 0) goto L_0x017a;
    L_0x0156:
        r2 = r0.getHeight();
        r2 = (float) r2;
        r2 = r2 + r5;
        r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r1 >= 0) goto L_0x017a;
    L_0x0160:
        r1 = r3;
    L_0x0161:
        if (r1 == 0) goto L_0x016b;
    L_0x0163:
        r1 = r6.kfe;
        r1 = r6.a(r1, r15);
        if (r1 != 0) goto L_0x017c;
    L_0x016b:
        r6.kff = r4;
        r1 = r6.kfg;
        r0.removeCallbacks(r1);
        r1 = r6.kfh;
        r0.removeCallbacks(r1);
        r1 = r4;
        goto L_0x005a;
    L_0x017a:
        r1 = r4;
        goto L_0x0161;
    L_0x017c:
        r1 = r3;
        goto L_0x005a;
    L_0x017f:
        r0 = r5.length();
        r2 = com.tencent.mm.plugin.appbrand.widget.input.ae.a.class;
        r0 = r5.getSpans(r4, r0, r2);
        r0 = (com.tencent.mm.plugin.appbrand.widget.input.ae.a[]) r0;
        r2 = r4;
    L_0x018c:
        r8 = r0.length;
        if (r2 >= r8) goto L_0x0197;
    L_0x018f:
        r8 = r0[r2];
        r5.removeSpan(r8);
        r2 = r2 + 1;
        goto L_0x018c;
    L_0x0197:
        r0 = new com.tencent.mm.plugin.appbrand.widget.input.ae$a;
        r2 = r15.getX();
        r8 = r15.getY();
        r9 = r7.getScrollX();
        r7 = r7.getScrollY();
        r0.<init>(r2, r8, r9, r7);
        r2 = 17;
        r5.setSpan(r0, r4, r4, r2);
        goto L_0x0077;
    L_0x01b3:
        r0 = com.tencent.mm.plugin.appbrand.widget.input.ae.e(r7);
        if (r0 == 0) goto L_0x01c2;
    L_0x01b9:
        r2 = r0.length;
        if (r2 <= 0) goto L_0x01c2;
    L_0x01bc:
        r0 = r0[r4];
        r0 = r0.kft;
        if (r0 != 0) goto L_0x0077;
    L_0x01c2:
        r3 = r4;
        goto L_0x0077;
    L_0x01c5:
        r0 = r5.length();
        r2 = com.tencent.mm.plugin.appbrand.widget.input.ae.a.class;
        r0 = r5.getSpans(r4, r0, r2);
        r0 = (com.tencent.mm.plugin.appbrand.widget.input.ae.a[]) r0;
        r2 = r0.length;
        if (r2 <= 0) goto L_0x0076;
    L_0x01d4:
        r2 = r0[r4];
        r2 = r2.kfs;
        if (r2 != 0) goto L_0x020e;
    L_0x01da:
        r2 = r7.getContext();
        r2 = android.view.ViewConfiguration.get(r2);
        r2 = r2.getScaledTouchSlop();
        r8 = r15.getX();
        r9 = r0[r4];
        r9 = r9.abo;
        r8 = r8 - r9;
        r8 = java.lang.Math.abs(r8);
        r9 = (float) r2;
        r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1));
        if (r8 >= 0) goto L_0x020a;
    L_0x01f8:
        r8 = r15.getY();
        r9 = r0[r4];
        r9 = r9.abp;
        r8 = r8 - r9;
        r8 = java.lang.Math.abs(r8);
        r2 = (float) r2;
        r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x020e;
    L_0x020a:
        r2 = r0[r4];
        r2.kfs = r3;
    L_0x020e:
        r2 = r0[r4];
        r2 = r2.kfs;
        if (r2 == 0) goto L_0x0076;
    L_0x0214:
        r2 = r0[r4];
        r2.kft = r3;
        r2 = r15.getMetaState();
        r2 = r2 & 1;
        if (r2 != 0) goto L_0x022e;
    L_0x0220:
        r2 = android.text.method.MetaKeyKeyListener.getMetaState(r5, r3);
        if (r2 == r3) goto L_0x022e;
    L_0x0226:
        r2 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r2 = android.text.method.MetaKeyKeyListener.getMetaState(r5, r2);
        if (r2 == 0) goto L_0x0264;
    L_0x022e:
        r2 = r3;
    L_0x022f:
        if (r2 == 0) goto L_0x0266;
    L_0x0231:
        r2 = r15.getX();
        r5 = r0[r4];
        r5 = r5.abo;
        r5 = r2 - r5;
        r2 = r15.getY();
        r8 = r0[r4];
        r8 = r8.abp;
        r2 = r2 - r8;
    L_0x0244:
        r8 = r0[r4];
        r9 = r15.getX();
        r8.abo = r9;
        r8 = r0[r4];
        r9 = r15.getY();
        r8.abp = r9;
        r8 = r0[r4];
        r8 = r8.kfv;
        if (r8 == 0) goto L_0x027a;
    L_0x025a:
        r2 = r0[r4];
        r2.kfv = r4;
        r0 = r0[r4];
        r0.kfs = r4;
        goto L_0x0076;
    L_0x0264:
        r2 = r4;
        goto L_0x022f;
    L_0x0266:
        r2 = r0[r4];
        r2 = r2.abo;
        r5 = r15.getX();
        r5 = r2 - r5;
        r2 = r0[r4];
        r2 = r2.abp;
        r8 = r15.getY();
        r2 = r2 - r8;
        goto L_0x0244;
    L_0x027a:
        r8 = r7.getScrollX();
        r5 = (int) r5;
        r5 = r5 + r8;
        r8 = r7.getScrollY();
        r2 = (int) r2;
        r2 = r2 + r8;
        r8 = r7.getTotalPaddingTop();
        r9 = r7.getTotalPaddingBottom();
        r8 = r8 + r9;
        r9 = r7.getLayout();
        r10 = r9.getHeight();
        r11 = r7.getHeight();
        r8 = r11 - r8;
        r8 = r10 - r8;
        r2 = java.lang.Math.min(r2, r8);
        r8 = java.lang.Math.max(r2, r4);
        r10 = r7.getScrollX();
        r11 = r7.getScrollY();
        r2 = r7.getTotalPaddingLeft();
        r12 = r7.getTotalPaddingRight();
        r2 = r2 + r12;
        r12 = r7.getWidth();
        r12 = r12 - r2;
        r2 = r9.getLineForVertical(r8);
        r13 = r9.getParagraphAlignment(r2);
        r2 = r9.getParagraphDirection(r2);
        if (r2 <= 0) goto L_0x02f2;
    L_0x02cb:
        r2 = r3;
    L_0x02cc:
        r9 = r12 + 0;
        if (r9 >= r12) goto L_0x0307;
    L_0x02d0:
        r5 = android.text.Layout.Alignment.ALIGN_CENTER;
        if (r13 != r5) goto L_0x02f4;
    L_0x02d4:
        r2 = r12 - r9;
        r2 = r2 / 2;
        r2 = 0 - r2;
    L_0x02da:
        r7.scrollTo(r2, r8);
        r2 = r7.getScrollX();
        if (r10 != r2) goto L_0x02e9;
    L_0x02e3:
        r2 = r7.getScrollY();
        if (r11 == r2) goto L_0x0310;
    L_0x02e9:
        r7.cancelLongPress();
        r0 = r0[r4];
        r0.kfu = r3;
        goto L_0x0077;
    L_0x02f2:
        r2 = r4;
        goto L_0x02cc;
    L_0x02f4:
        if (r2 == 0) goto L_0x02fa;
    L_0x02f6:
        r5 = android.text.Layout.Alignment.ALIGN_OPPOSITE;
        if (r13 == r5) goto L_0x0300;
    L_0x02fa:
        if (r2 != 0) goto L_0x0305;
    L_0x02fc:
        r2 = android.text.Layout.Alignment.ALIGN_NORMAL;
        if (r13 != r2) goto L_0x0305;
    L_0x0300:
        r2 = r12 - r9;
        r2 = 0 - r2;
        goto L_0x02da;
    L_0x0305:
        r2 = r4;
        goto L_0x02da;
    L_0x0307:
        r2 = java.lang.Math.min(r5, r4);
        r2 = java.lang.Math.max(r2, r4);
        goto L_0x02da;
    L_0x0310:
        r0 = r0[r4];
        r0 = r0.kfu;
        if (r0 != 0) goto L_0x0077;
    L_0x0316:
        com.tencent.mm.plugin.appbrand.widget.input.ae.e(r7);
        goto L_0x0076;
    L_0x031b:
        r0 = r15.getActionMasked();
        switch(r0) {
            case 0: goto L_0x035c;
            case 1: goto L_0x0328;
            case 2: goto L_0x0365;
            case 3: goto L_0x0328;
            default: goto L_0x0322;
        };
    L_0x0322:
        r4 = super.onTouchEvent(r15);
        goto L_0x0051;
    L_0x0328:
        r14.kdS = r4;
        r0 = r14.kdR;
        if (r0 == 0) goto L_0x0336;
    L_0x032e:
        r0 = r14.kdR;
        r0.recycle();
        r0 = 0;
        r14.kdR = r0;
    L_0x0336:
        r0 = r14.kdS;
        if (r0 == 0) goto L_0x0353;
    L_0x033a:
        r0 = r15.getActionIndex();
        r0 = r15.getX(r0);
        r1 = r15.getActionIndex();
        r1 = r15.getY(r1);
        r0 = com.tencent.mm.plugin.appbrand.widget.input.af.b.a(r14, r0, r1);
        if (r0 < 0) goto L_0x0353;
    L_0x0350:
        r14.setSelection(r0);
    L_0x0353:
        r0 = r14.getParent();
        if (r0 != 0) goto L_0x0322;
    L_0x0359:
        r4 = r3;
        goto L_0x0051;
    L_0x035c:
        r0 = android.view.MotionEvent.obtain(r15);
        r14.kdR = r0;
        r14.kdS = r3;
        goto L_0x0322;
    L_0x0365:
        r0 = r14.kdS;
        if (r0 == 0) goto L_0x0322;
    L_0x0369:
        r0 = r14.kdR;
        r1 = r14.kdR;
        r1 = r1.getActionIndex();
        r0 = r0.getX(r1);
        r1 = r14.kdR;
        r2 = r14.kdR;
        r2 = r2.getActionIndex();
        r1 = r1.getY(r2);
        r2 = r15.getActionIndex();
        r2 = r15.getX(r2);
        r3 = r15.getActionIndex();
        r3 = r15.getY(r3);
        r0 = r0 - r2;
        r0 = java.lang.Math.abs(r0);
        r2 = r14.jxO;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 > 0) goto L_0x03a8;
    L_0x039c:
        r0 = r1 - r3;
        r0 = java.lang.Math.abs(r0);
        r1 = r14.jxO;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 <= 0) goto L_0x0322;
    L_0x03a8:
        r14.cancelLongPress();
        r14.setPressed(r4);
        r14.kdS = r4;
        goto L_0x0322;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.widget.input.o.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void r(float f, float f2) {
        if (isEnabled()) {
            if (amZ()) {
                int a = b.a(this, f, f2);
                if (a >= 0) {
                    setSelection(a);
                }
            }
            super.performClick();
        }
    }

    public final boolean performHapticFeedback(int i, int i2) {
        return super.performHapticFeedback(i, i2);
    }
}
