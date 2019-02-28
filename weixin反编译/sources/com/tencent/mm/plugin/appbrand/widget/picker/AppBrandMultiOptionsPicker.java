package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.annotation.Keep;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.q.g;

public final class AppBrandMultiOptionsPicker extends FrameLayout implements e<int[]> {
    private boolean Ue;
    private boolean Uf;
    private final Drawable kiO;
    public LinearLayout kiP;
    private d kiQ;
    public final com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker.a kiR = new com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker.a() {
        public final void a(YANumberPicker yANumberPicker, int i) {
            if (AppBrandMultiOptionsPicker.this.kiQ != null) {
                int intValue = ((Integer) yANumberPicker.getTag(g.iwR)).intValue();
                d a = AppBrandMultiOptionsPicker.this.kiQ;
                Object obj = new int[]{intValue, i};
                if (a.kje != null) {
                    a.kje.be(obj);
                }
            }
        }
    };

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker$2 */
    class AnonymousClass2 extends c {
        public AnonymousClass2(Context context) {
            super(context);
        }
    }

    public static final class a {
        public final String[] kiT;
        public final int kiU;

        public a(String[] strArr, int i) {
            this.kiT = strArr;
            this.kiU = Math.max(0, Math.min(i, strArr.length - 1));
        }
    }

    public final /* synthetic */ Object aoq() {
        int i = 0;
        int aor = aor();
        if (aor <= 0) {
            return new int[0];
        }
        Object obj = new int[aor];
        while (i < aor) {
            obj[i] = mD(i).getValue();
            i++;
        }
        return obj;
    }

    @Keep
    public AppBrandMultiOptionsPicker(Context context) {
        super(context);
        this.kiO = context.getResources().getDrawable(f.ivz);
        this.kiP = new LinearLayout(context);
        this.kiP.setPadding(com.tencent.mm.bu.a.fromDPToPix(context, 2), 0, com.tencent.mm.bu.a.fromDPToPix(context, 2), 0);
        this.kiP.setOrientation(0);
        addView(this.kiP, new LayoutParams(-1, -1, 17));
        this.kiP.setDividerDrawable(this.kiO);
        this.kiP.setShowDividers(2);
    }

    public final void T(boolean z) {
        if (this.Uf != z) {
            this.Uf = z;
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            } else if (this.Ue) {
                requestLayout();
            }
        }
    }

    public final void requestLayout() {
        if (this.Uf) {
            this.Ue = true;
        } else {
            super.requestLayout();
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Uf) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Uf) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final c mD(int i) {
        if (i >= 0 && this.kiP != null) {
            return (c) this.kiP.getChildAt(i);
        }
        return null;
    }

    public final int aor() {
        return this.kiP == null ? 0 : this.kiP.getChildCount();
    }

    public final void mE(int i) {
        if (i > 0) {
            int aor = aor() - 1;
            while (i > 0) {
                this.kiP.removeViewAt(aor);
                aor--;
                i--;
            }
        }
    }

    public final View getView() {
        return this;
    }

    public final void a(d dVar) {
        this.kiQ = dVar;
    }

    public final void aoo() {
        int aor = aor();
        for (int i = 0; i < aor; i++) {
            c mD = mD(i);
            if (mD != null) {
                mD.aoC();
            }
        }
    }

    public final void b(d dVar) {
        this.kiQ = dVar;
    }

    public final void aop() {
        this.kiQ = null;
    }
}
