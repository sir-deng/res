package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v4.view.z;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

@SuppressLint({"ViewConstructor"})
public final class l extends FrameLayout {
    private static final int jdI = g.ixo;
    public View kdn;
    private View kdo;
    int kdp = -1;
    private final int[] kdq = new int[2];
    public com.tencent.mm.plugin.appbrand.widget.d.a kdr;
    private WeakHashMap<View, b> kds = new WeakHashMap();
    private Runnable kdt = new Runnable() {
        public final void run() {
            int i = 0;
            x.i("MicroMsg.AppBrandUIdRootFrameLayout", "hideInativePanelView, mPanel %s", l.this.kdn.getClass().getSimpleName());
            if (l.this.kdn != null) {
                while (i < l.this.getChildCount()) {
                    View childAt = l.this.getChildAt(i);
                    if (!(childAt == null || childAt == l.this.kdo || childAt == l.this.kdn)) {
                        l.bU(childAt);
                    }
                    i++;
                }
            }
        }
    };
    private final Runnable kdu = new Runnable() {
        public final void run() {
            int i = 0;
            x.i("MicroMsg.AppBrandUIdRootFrameLayout", "callOnPanelChanged, size %d", Integer.valueOf(l.this.kdv.size()));
            if (l.this.kdv.size() > 0) {
                a[] aVarArr = new a[l.this.kdv.size()];
                l.this.kdv.toArray(aVarArr);
                int length = aVarArr.length;
                while (i < length) {
                    aVarArr[i].agX();
                    i++;
                }
            }
        }
    };
    public final Set<a> kdv = new HashSet();

    public interface a {
        void agX();
    }

    private static final class b {
        boolean kdx;
        int kdy;

        private b() {
            this.kdy = 8;
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    static /* synthetic */ void bU(View view) {
        if (view != null && view.getVisibility() != 8) {
            view.setVisibility(8);
        }
    }

    public static l bS(View view) {
        return (l) view.getRootView().findViewById(jdI);
    }

    public static l k(Activity activity) {
        return (l) activity.findViewById(jdI);
    }

    public l(Context context, View view) {
        super(context);
        super.setId(jdI);
        this.kdo = view;
        super.addView(view);
    }

    protected final void onMeasure(int i, int i2) {
        if (this.kdp > 0) {
            i2 = MeasureSpec.makeMeasureSpec(this.kdp, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            if (this.kdn == null || !this.kdn.isShown()) {
                Activity ch = j.ch(getContext());
                if (MMActivity.class.isInstance(ch) && ((MMActivity) ch).mController.hideVKB()) {
                    return true;
                }
            }
            this.kdn.setVisibility(8);
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        b bVar = (b) this.kds.get(this.kdn);
        if (bVar != null && bVar.kdx && this.kdn != null && this.kdn.isShown() && motionEvent.getAction() == 0) {
            float rawY = motionEvent.getRawY();
            this.kdn.getLocationOnScreen(this.kdq);
            float f = (float) this.kdq[1];
            float height = ((float) this.kdn.getHeight()) + f;
            if (rawY < f || rawY > height) {
                this.kdn.setVisibility(8);
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void setId(int i) {
    }

    public final void addView(View view) {
        if (view == this.kdo || view == this.kdn) {
            super.addView(view);
        }
    }

    public final void addView(View view, int i) {
        if (view == this.kdo || view == this.kdn) {
            super.addView(view, i);
        }
    }

    public final void addView(View view, int i, int i2) {
        if (view == this.kdo || view == this.kdn) {
            super.addView(view, i, i2);
        }
    }

    public final void addView(View view, LayoutParams layoutParams) {
        if (view == this.kdo || view == this.kdn) {
            super.addView(view, layoutParams);
        }
    }

    public final void addView(View view, int i, LayoutParams layoutParams) {
        if (view == this.kdo || view == this.kdn) {
            super.addView(view, i, layoutParams);
        }
    }

    protected final boolean addViewInLayout(View view, int i, LayoutParams layoutParams) {
        return false;
    }

    protected final boolean addViewInLayout(View view, int i, LayoutParams layoutParams, boolean z) {
        return false;
    }

    public final void g(View view, boolean z) {
        if (this.kdn != null) {
            this.kdn.setVisibility(8);
            this.kdn = null;
        }
        if (this != view.getParent()) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.kdn = view;
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            super.addView(view, layoutParams);
            b bVar = new b();
            bVar.kdx = z;
            this.kds.put(view, bVar);
        }
    }

    public final void bT(View view) {
        g(view, false);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z.ai(this)) {
            Object obj = null;
            int i5 = 1;
            int i6 = 0;
            for (int i7 = 0; i7 < getChildCount(); i7++) {
                View childAt = getChildAt(i7);
                if (!(childAt == null || childAt == this.kdo)) {
                    b bVar = (b) this.kds.get(childAt);
                    if (bVar != null) {
                        if (obj == null && bVar.kdy != 0 && childAt.getVisibility() == 0) {
                            this.kdn = childAt;
                            post(this.kdt);
                            obj = 1;
                        }
                        int i8 = (bVar.kdy == 0 ? 1 : 0) | i6;
                        i5 &= childAt.getVisibility() != 0 ? 1 : 0;
                        bVar.kdy = childAt.getVisibility();
                        i6 = i8;
                    }
                }
            }
            if (!(obj == null && (i6 == 0 || i5 == 0))) {
                post(this.kdu);
            }
        }
        super.onLayout(z, i, i2, i3, i4);
        if (this.kdr != null) {
            this.kdr.bV(this);
        }
    }

    public final void a(a aVar) {
        if (aVar != null && this.kdv.contains(aVar)) {
            this.kdv.remove(aVar);
        }
    }
}
