package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.view.ViewPager.f;
import android.support.v4.view.ae;
import android.support.v4.view.o;
import android.support.v4.view.u;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.support.v4.widget.i;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import junit.framework.Assert;
import org.xwalk.core.R;

public class AdLandingViewPager extends ViewGroup {
    private static final e rsI = new e();
    private static final Comparator<b> yB = new Comparator<b>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((b) obj).position - ((b) obj2).position;
        }
    };
    private static final Interpolator yC = new Interpolator() {
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    private static final int[] yz = new int[]{16842931};
    final ArrayList<b> ep = new ArrayList();
    private final Rect ey = new Rect();
    VelocityTracker ft;
    int fu = -1;
    private boolean iL;
    private int iN;
    private boolean mInLayout;
    private final b rsE = new b();
    private d rsF;
    long rsG;
    Method rsH;
    float xP;
    private float xQ;
    private int yA;
    public u yE;
    public int yF;
    private int yG = -1;
    private Parcelable yH = null;
    private ClassLoader yI = null;
    private Scroller yJ;
    private int yM;
    private Drawable yN;
    private int yO;
    private int yP;
    float yQ = -3.4028235E38f;
    float yR = Float.MAX_VALUE;
    private int yS;
    private int yT;
    private boolean yU;
    boolean yV;
    private int yW = 1;
    private boolean yX;
    private int yY;
    private int yZ;
    private int yi = 0;
    float za;
    private float zb;
    private int zc;
    int zd;
    private int ze;
    private int zf;
    boolean zg;
    private i zh;
    private i zi;
    private boolean zj = true;
    private boolean zk = false;
    private boolean zl;
    private int zm;
    android.support.v4.view.ViewPager.e zo = this.rsK;
    private android.support.v4.view.ViewPager.e zp;
    f zr;
    int zt;
    private ArrayList<View> zu;
    private final Runnable zw = new Runnable() {
        public final void run() {
            AdLandingViewPager.this.ag(0);
            AdLandingViewPager.this.populate();
        }
    };

    interface a {
    }

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = android.support.v4.os.b.a(new android.support.v4.os.c<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        });
        int position;
        Parcelable zE;
        ClassLoader zF;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.zE, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.position = parcel.readInt();
            this.zE = parcel.readParcelable(classLoader);
            this.zF = classLoader;
        }
    }

    static class b {
        Object object;
        int position;
        float zA;
        boolean zy;
        float zz;

        b() {
        }
    }

    class c extends android.support.v4.view.a {
        c() {
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(AdLandingViewPager.class.getName());
            android.support.v4.view.a.f ck = android.support.v4.view.a.f.ck();
            ck.setScrollable(ca());
            if (accessibilityEvent.getEventType() == Downloads.RECV_BUFFER_SIZE && AdLandingViewPager.this.yE != null) {
                ck.setItemCount(AdLandingViewPager.this.yE.getCount());
                ck.setFromIndex(AdLandingViewPager.this.yF);
                ck.setToIndex(AdLandingViewPager.this.yF);
            }
        }

        public final void a(View view, android.support.v4.view.a.b bVar) {
            super.a(view, bVar);
            bVar.setClassName(AdLandingViewPager.class.getName());
            bVar.setScrollable(ca());
            if (AdLandingViewPager.this.canScrollHorizontally(1)) {
                bVar.addAction(Downloads.RECV_BUFFER_SIZE);
            }
            if (AdLandingViewPager.this.canScrollHorizontally(-1)) {
                bVar.addAction(8192);
            }
        }

        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case Downloads.RECV_BUFFER_SIZE /*4096*/:
                    if (!AdLandingViewPager.this.canScrollHorizontally(1)) {
                        return false;
                    }
                    AdLandingViewPager.this.ah(AdLandingViewPager.this.yF + 1);
                    return true;
                case 8192:
                    if (!AdLandingViewPager.this.canScrollHorizontally(-1)) {
                        return false;
                    }
                    AdLandingViewPager.this.ah(AdLandingViewPager.this.yF - 1);
                    return true;
                default:
                    return false;
            }
        }

        private boolean ca() {
            return AdLandingViewPager.this.yE != null && AdLandingViewPager.this.yE.getCount() > 1;
        }
    }

    private class d extends DataSetObserver {
        private d() {
        }

        /* synthetic */ d(AdLandingViewPager adLandingViewPager, byte b) {
            this();
        }

        public final void onChanged() {
            AdLandingViewPager.this.bS();
        }

        public final void onInvalidated() {
            AdLandingViewPager.this.bS();
        }
    }

    public static class LayoutParams extends android.view.ViewGroup.LayoutParams {
        public int gravity;
        int position;
        public boolean zB;
        boolean zC;
        int zD;
        float zz = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AdLandingViewPager.yz);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    static class e implements Comparator<View> {
        e() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            LayoutParams layoutParams = (LayoutParams) ((View) obj).getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) ((View) obj2).getLayoutParams();
            if (layoutParams.zB != layoutParams2.zB) {
                return layoutParams.zB ? 1 : -1;
            } else {
                return layoutParams.position - layoutParams2.position;
            }
        }
    }

    public AdLandingViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context2 = getContext();
        this.yJ = new Scroller(context2, yC);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
        float f = context2.getResources().getDisplayMetrics().density;
        this.iN = ae.a(viewConfiguration);
        this.zc = (int) (400.0f * f);
        this.zd = viewConfiguration.getScaledMaximumFlingVelocity();
        this.zh = new i(context2);
        this.zi = new i(context2);
        this.ze = (int) (25.0f * f);
        this.zf = (int) (2.0f * f);
        this.yY = (int) (16.0f * f);
        z.a((View) this, new c());
        if (z.F(this) == 0) {
            z.i(this, 1);
        }
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.zw);
        super.onDetachedFromWindow();
    }

    private void ag(int i) {
        if (this.yi != i) {
            this.yi = i;
            if (this.zr != null) {
                Object obj = i != 0 ? 1 : null;
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    z.a(getChildAt(i2), obj != null ? 2 : 0, null);
                }
            }
            if (this.zo != null) {
                this.zo.af(i);
            }
        }
    }

    public final void a(u uVar) {
        if (this.yE != null) {
            int i;
            this.yE.unregisterDataSetObserver(this.rsF);
            for (i = 0; i < this.ep.size(); i++) {
                b bVar = (b) this.ep.get(i);
                this.yE.a(this, bVar.position, bVar.object);
            }
            this.yE.aY();
            this.ep.clear();
            i = 0;
            while (i < getChildCount()) {
                if (!((LayoutParams) getChildAt(i).getLayoutParams()).zB) {
                    removeViewAt(i);
                    i--;
                }
                i++;
            }
            this.yF = 0;
            scrollTo(0, 0);
        }
        this.yE = uVar;
        this.yA = 0;
        if (this.yE != null) {
            if (this.rsF == null) {
                this.rsF = new d();
            }
            this.yE.registerDataSetObserver(this.rsF);
            this.yV = false;
            boolean z = this.zj;
            this.zj = true;
            this.yA = this.yE.getCount();
            if (this.yG >= 0) {
                this.yE.a(this.yH, this.yI);
                a(this.yG, false, true);
                this.yG = -1;
                this.yH = null;
                this.yI = null;
            } else if (z) {
                requestLayout();
            } else {
                populate();
            }
        }
    }

    final int bR() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public final void ah(int i) {
        boolean z;
        this.yV = false;
        if (this.zj) {
            z = false;
        } else {
            z = true;
        }
        a(i, z, false);
    }

    public final void d(int i, boolean z) {
        this.yV = false;
        a(i, z, false);
    }

    private void a(int i, boolean z, boolean z2) {
        a(i, z, z2, 0);
    }

    final void a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.yE == null || this.yE.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.yF != i || this.ep.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.yE.getCount()) {
                i = this.yE.getCount() - 1;
            }
            int i3 = this.yW;
            if (i > this.yF + i3 || i < this.yF - i3) {
                for (int i4 = 0; i4 < this.ep.size(); i4++) {
                    ((b) this.ep.get(i4)).zy = true;
                }
            }
            if (this.yF != i) {
                z3 = true;
            }
            if (this.zj) {
                this.yF = i;
                if (z3 && this.zo != null) {
                    this.zo.ae(i);
                }
                if (z3 && this.zp != null) {
                    this.zp.ae(i);
                }
                requestLayout();
                return;
            }
            ai(i);
            a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    private void a(int i, boolean z, int i2, boolean z2) {
        b xx = xx(i);
        int i3 = 0;
        if (xx != null) {
            i3 = (int) (((float) bR()) * Math.max(this.yQ, Math.min(xx.zA, this.yR)));
        }
        if (z) {
            if (getChildCount() == 0) {
                setScrollingCacheEnabled(false);
            } else {
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int i4 = i3 - scrollX;
                int i5 = 0 - scrollY;
                if (i4 == 0 && i5 == 0) {
                    s(false);
                    populate();
                    ag(0);
                } else {
                    setScrollingCacheEnabled(true);
                    ag(2);
                    i3 = bR();
                    int i6 = i3 / 2;
                    float f = (float) i6;
                    float sin = (((float) i6) * ((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, (1.0f * ((float) Math.abs(i4))) / ((float) i3)) - 0.5f)) * 0.4712389167638204d))))) + f;
                    int abs = Math.abs(i2);
                    if (abs > 0) {
                        i3 = Math.round(1000.0f * Math.abs(sin / ((float) abs))) * 4;
                    } else {
                        i3 = (int) (((((float) Math.abs(i4)) / ((((float) i3) * 1.0f) + ((float) this.yM))) + 3.0f) * 100.0f);
                    }
                    this.yJ.startScroll(scrollX, scrollY, i4, i5, Math.min(i3, 600));
                    z.E(this);
                }
            }
            if (z2 && this.zo != null) {
                this.zo.ae(i);
            }
            if (z2 && this.zp != null) {
                this.zp.ae(i);
                return;
            }
            return;
        }
        if (z2 && this.zo != null) {
            this.zo.ae(i);
        }
        if (z2 && this.zp != null) {
            this.zp.ae(i);
        }
        s(false);
        scrollTo(i3, 0);
        ak(i3);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.zt == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) ((View) this.zu.get(i2)).getLayoutParams()).zD;
    }

    public final void xw(int i) {
        if (i <= 0) {
            new StringBuilder("Requested offscreen page limit ").append(i).append(" too small; defaulting to 1");
            i = 1;
        }
        if (i != this.yW) {
            this.yW = i;
            populate();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.yN;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.yN;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    private b dD(int i, int i2) {
        b bVar = new b();
        bVar.position = i;
        bVar.object = this.yE.b(this, i);
        bVar.zz = 1.0f;
        if (i2 < 0 || i2 >= this.ep.size()) {
            this.ep.add(bVar);
        } else {
            this.ep.add(i2, bVar);
        }
        return bVar;
    }

    final void bS() {
        boolean z;
        int max;
        int count = this.yE.getCount();
        this.yA = count;
        if (this.ep.size() >= (this.yW * 2) + 1 || this.ep.size() >= count) {
            z = false;
        } else {
            z = true;
        }
        boolean z2 = false;
        int i = this.yF;
        boolean z3 = z;
        int i2 = 0;
        while (i2 < this.ep.size()) {
            int i3;
            boolean z4;
            boolean z5;
            b bVar = (b) this.ep.get(i2);
            int k = this.yE.k(bVar.object);
            if (k != -1) {
                if (k == -2) {
                    this.ep.remove(i2);
                    i2--;
                    if (!z2) {
                        z2 = true;
                    }
                    this.yE.a(this, bVar.position, bVar.object);
                    if (this.yF == bVar.position) {
                        i3 = i2;
                        z4 = z2;
                        max = Math.max(0, Math.min(this.yF, count - 1));
                        z5 = true;
                    } else {
                        i3 = i2;
                        z4 = z2;
                        max = i;
                        z5 = true;
                    }
                } else if (bVar.position != k) {
                    if (bVar.position == this.yF) {
                        i = k;
                    }
                    bVar.position = k;
                    i3 = i2;
                    z4 = z2;
                    max = i;
                    z5 = true;
                }
                z3 = z5;
                i = max;
                z2 = z4;
                i2 = i3 + 1;
            }
            i3 = i2;
            z4 = z2;
            max = i;
            z5 = z3;
            z3 = z5;
            i = max;
            z2 = z4;
            i2 = i3 + 1;
        }
        if (z2) {
            this.yE.aY();
        }
        Collections.sort(this.ep, yB);
        if (z3) {
            max = getChildCount();
            for (i2 = 0; i2 < max; i2++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
                if (!layoutParams.zB) {
                    layoutParams.zz = 0.0f;
                }
            }
            a(i, false, true);
            requestLayout();
        }
    }

    final void populate() {
        ai(this.yF);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void ai(int r19) {
        /*
        r18 = this;
        r3 = 0;
        r2 = 2;
        r0 = r18;
        r4 = r0.yF;
        r0 = r19;
        if (r4 == r0) goto L_0x0328;
    L_0x000a:
        r0 = r18;
        r2 = r0.yF;
        r0 = r19;
        if (r2 >= r0) goto L_0x0030;
    L_0x0012:
        r2 = 66;
    L_0x0014:
        r0 = r18;
        r3 = r0.yF;
        r0 = r18;
        r3 = r0.xx(r3);
        r0 = r19;
        r1 = r18;
        r1.yF = r0;
        r4 = r3;
        r3 = r2;
    L_0x0026:
        r0 = r18;
        r2 = r0.yE;
        if (r2 != 0) goto L_0x0033;
    L_0x002c:
        r18.bT();
    L_0x002f:
        return;
    L_0x0030:
        r2 = 17;
        goto L_0x0014;
    L_0x0033:
        r0 = r18;
        r2 = r0.yV;
        if (r2 == 0) goto L_0x003d;
    L_0x0039:
        r18.bT();
        goto L_0x002f;
    L_0x003d:
        r2 = r18.getWindowToken();
        if (r2 == 0) goto L_0x002f;
    L_0x0043:
        r0 = r18;
        r2 = r0.yW;
        r5 = 0;
        r0 = r18;
        r6 = r0.yF;
        r6 = r6 - r2;
        r11 = java.lang.Math.max(r5, r6);
        r0 = r18;
        r5 = r0.yE;
        r12 = r5.getCount();
        r5 = r12 + -1;
        r0 = r18;
        r6 = r0.yF;
        r2 = r2 + r6;
        r13 = java.lang.Math.min(r5, r2);
        r0 = r18;
        r2 = r0.yA;
        if (r12 == r2) goto L_0x00d2;
    L_0x006a:
        r2 = r18.getResources();	 Catch:{ NotFoundException -> 0x00c8 }
        r3 = r18.getId();	 Catch:{ NotFoundException -> 0x00c8 }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00c8 }
    L_0x0076:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4.<init>(r5);
        r0 = r18;
        r5 = r0.yA;
        r4 = r4.append(r5);
        r5 = ", found: ";
        r4 = r4.append(r5);
        r4 = r4.append(r12);
        r5 = " Pager id: ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " Pager class: ";
        r2 = r2.append(r4);
        r4 = r18.getClass();
        r2 = r2.append(r4);
        r4 = " Problematic adapter: ";
        r2 = r2.append(r4);
        r0 = r18;
        r4 = r0.yE;
        r4 = r4.getClass();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x00c8:
        r2 = move-exception;
        r2 = r18.getId();
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x0076;
    L_0x00d2:
        r6 = 0;
        r2 = 0;
        r5 = r2;
    L_0x00d5:
        r0 = r18;
        r2 = r0.ep;
        r2 = r2.size();
        if (r5 >= r2) goto L_0x0325;
    L_0x00df:
        r0 = r18;
        r2 = r0.ep;
        r2 = r2.get(r5);
        r2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.b) r2;
        r7 = r2.position;
        r0 = r18;
        r8 = r0.yF;
        if (r7 < r8) goto L_0x0167;
    L_0x00f1:
        r7 = r2.position;
        r0 = r18;
        r8 = r0.yF;
        if (r7 != r8) goto L_0x0325;
    L_0x00f9:
        if (r2 != 0) goto L_0x0322;
    L_0x00fb:
        if (r12 <= 0) goto L_0x0322;
    L_0x00fd:
        r0 = r18;
        r2 = r0.yF;
        r0 = r18;
        r2 = r0.dD(r2, r5);
        r10 = r2;
    L_0x0108:
        if (r10 == 0) goto L_0x028b;
    L_0x010a:
        r9 = 0;
        r8 = r5 + -1;
        if (r8 < 0) goto L_0x016c;
    L_0x010f:
        r0 = r18;
        r2 = r0.ep;
        r2 = r2.get(r8);
        r2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.b) r2;
    L_0x0119:
        r14 = r18.bR();
        if (r14 > 0) goto L_0x016e;
    L_0x011f:
        r6 = 0;
    L_0x0120:
        r0 = r18;
        r7 = r0.yF;
        r7 = r7 + -1;
        r16 = r7;
        r7 = r9;
        r9 = r16;
        r17 = r8;
        r8 = r5;
        r5 = r17;
    L_0x0130:
        if (r9 < 0) goto L_0x01b4;
    L_0x0132:
        r15 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1));
        if (r15 < 0) goto L_0x017e;
    L_0x0136:
        if (r9 >= r11) goto L_0x017e;
    L_0x0138:
        if (r2 == 0) goto L_0x01b4;
    L_0x013a:
        r15 = r2.position;
        if (r9 != r15) goto L_0x0164;
    L_0x013e:
        r15 = r2.zy;
        if (r15 != 0) goto L_0x0164;
    L_0x0142:
        r0 = r18;
        r15 = r0.ep;
        r15.remove(r5);
        r0 = r18;
        r15 = r0.yE;
        r2 = r2.object;
        r0 = r18;
        r15.a(r0, r9, r2);
        r5 = r5 + -1;
        r8 = r8 + -1;
        if (r5 < 0) goto L_0x017c;
    L_0x015a:
        r0 = r18;
        r2 = r0.ep;
        r2 = r2.get(r5);
        r2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.b) r2;
    L_0x0164:
        r9 = r9 + -1;
        goto L_0x0130;
    L_0x0167:
        r2 = r5 + 1;
        r5 = r2;
        goto L_0x00d5;
    L_0x016c:
        r2 = 0;
        goto L_0x0119;
    L_0x016e:
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = r10.zz;
        r6 = r6 - r7;
        r7 = r18.getPaddingLeft();
        r7 = (float) r7;
        r15 = (float) r14;
        r7 = r7 / r15;
        r6 = r6 + r7;
        goto L_0x0120;
    L_0x017c:
        r2 = 0;
        goto L_0x0164;
    L_0x017e:
        if (r2 == 0) goto L_0x0198;
    L_0x0180:
        r15 = r2.position;
        if (r9 != r15) goto L_0x0198;
    L_0x0184:
        r2 = r2.zz;
        r7 = r7 + r2;
        r5 = r5 + -1;
        if (r5 < 0) goto L_0x0196;
    L_0x018b:
        r0 = r18;
        r2 = r0.ep;
        r2 = r2.get(r5);
        r2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.b) r2;
        goto L_0x0164;
    L_0x0196:
        r2 = 0;
        goto L_0x0164;
    L_0x0198:
        r2 = r5 + 1;
        r0 = r18;
        r2 = r0.dD(r9, r2);
        r2 = r2.zz;
        r7 = r7 + r2;
        r8 = r8 + 1;
        if (r5 < 0) goto L_0x01b2;
    L_0x01a7:
        r0 = r18;
        r2 = r0.ep;
        r2 = r2.get(r5);
        r2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.b) r2;
        goto L_0x0164;
    L_0x01b2:
        r2 = 0;
        goto L_0x0164;
    L_0x01b4:
        r6 = r10.zz;
        r9 = r8 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x0286;
    L_0x01be:
        r0 = r18;
        r2 = r0.ep;
        r2 = r2.size();
        if (r9 >= r2) goto L_0x0228;
    L_0x01c8:
        r0 = r18;
        r2 = r0.ep;
        r2 = r2.get(r9);
        r2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.b) r2;
        r7 = r2;
    L_0x01d3:
        if (r14 > 0) goto L_0x022a;
    L_0x01d5:
        r2 = 0;
        r5 = r2;
    L_0x01d7:
        r0 = r18;
        r2 = r0.yF;
        r2 = r2 + 1;
        r16 = r7;
        r7 = r9;
        r9 = r2;
        r2 = r16;
    L_0x01e3:
        if (r9 >= r12) goto L_0x0286;
    L_0x01e5:
        r11 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r11 < 0) goto L_0x0238;
    L_0x01e9:
        if (r9 <= r13) goto L_0x0238;
    L_0x01eb:
        if (r2 == 0) goto L_0x0286;
    L_0x01ed:
        r11 = r2.position;
        if (r9 != r11) goto L_0x031b;
    L_0x01f1:
        r11 = r2.zy;
        if (r11 != 0) goto L_0x031b;
    L_0x01f5:
        r0 = r18;
        r11 = r0.ep;
        r11.remove(r7);
        r0 = r18;
        r11 = r0.yE;
        r2 = r2.object;
        r0 = r18;
        r11.a(r0, r9, r2);
        r0 = r18;
        r2 = r0.ep;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x0236;
    L_0x0211:
        r0 = r18;
        r2 = r0.ep;
        r2 = r2.get(r7);
        r2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.b) r2;
    L_0x021b:
        r16 = r6;
        r6 = r2;
        r2 = r16;
    L_0x0220:
        r9 = r9 + 1;
        r16 = r2;
        r2 = r6;
        r6 = r16;
        goto L_0x01e3;
    L_0x0228:
        r7 = 0;
        goto L_0x01d3;
    L_0x022a:
        r2 = r18.getPaddingRight();
        r2 = (float) r2;
        r5 = (float) r14;
        r2 = r2 / r5;
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r5;
        r5 = r2;
        goto L_0x01d7;
    L_0x0236:
        r2 = 0;
        goto L_0x021b;
    L_0x0238:
        if (r2 == 0) goto L_0x025f;
    L_0x023a:
        r11 = r2.position;
        if (r9 != r11) goto L_0x025f;
    L_0x023e:
        r2 = r2.zz;
        r6 = r6 + r2;
        r7 = r7 + 1;
        r0 = r18;
        r2 = r0.ep;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x025d;
    L_0x024d:
        r0 = r18;
        r2 = r0.ep;
        r2 = r2.get(r7);
        r2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.b) r2;
    L_0x0257:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x0220;
    L_0x025d:
        r2 = 0;
        goto L_0x0257;
    L_0x025f:
        r0 = r18;
        r2 = r0.dD(r9, r7);
        r7 = r7 + 1;
        r2 = r2.zz;
        r6 = r6 + r2;
        r0 = r18;
        r2 = r0.ep;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x0284;
    L_0x0274:
        r0 = r18;
        r2 = r0.ep;
        r2 = r2.get(r7);
        r2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.b) r2;
    L_0x027e:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x0220;
    L_0x0284:
        r2 = 0;
        goto L_0x027e;
    L_0x0286:
        r0 = r18;
        r0.a(r10, r8, r4);
    L_0x028b:
        r0 = r18;
        r4 = r0.yE;
        if (r10 == 0) goto L_0x02d2;
    L_0x0291:
        r2 = r10.object;
    L_0x0293:
        r4.e(r2);
        r0 = r18;
        r2 = r0.yE;
        r2.aY();
        r5 = r18.getChildCount();
        r2 = 0;
        r4 = r2;
    L_0x02a3:
        if (r4 >= r5) goto L_0x02d4;
    L_0x02a5:
        r0 = r18;
        r6 = r0.getChildAt(r4);
        r2 = r6.getLayoutParams();
        r2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.LayoutParams) r2;
        r2.zD = r4;
        r7 = r2.zB;
        if (r7 != 0) goto L_0x02ce;
    L_0x02b7:
        r7 = r2.zz;
        r8 = 0;
        r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1));
        if (r7 != 0) goto L_0x02ce;
    L_0x02be:
        r0 = r18;
        r6 = r0.cy(r6);
        if (r6 == 0) goto L_0x02ce;
    L_0x02c6:
        r7 = r6.zz;
        r2.zz = r7;
        r6 = r6.position;
        r2.position = r6;
    L_0x02ce:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x02a3;
    L_0x02d2:
        r2 = 0;
        goto L_0x0293;
    L_0x02d4:
        r18.bT();
        r2 = r18.hasFocus();
        if (r2 == 0) goto L_0x002f;
    L_0x02dd:
        r2 = r18.findFocus();
        if (r2 == 0) goto L_0x0319;
    L_0x02e3:
        r0 = r18;
        r2 = r0.cz(r2);
    L_0x02e9:
        if (r2 == 0) goto L_0x02f3;
    L_0x02eb:
        r2 = r2.position;
        r0 = r18;
        r4 = r0.yF;
        if (r2 == r4) goto L_0x002f;
    L_0x02f3:
        r2 = 0;
    L_0x02f4:
        r4 = r18.getChildCount();
        if (r2 >= r4) goto L_0x002f;
    L_0x02fa:
        r0 = r18;
        r4 = r0.getChildAt(r2);
        r0 = r18;
        r5 = r0.cy(r4);
        if (r5 == 0) goto L_0x0316;
    L_0x0308:
        r5 = r5.position;
        r0 = r18;
        r6 = r0.yF;
        if (r5 != r6) goto L_0x0316;
    L_0x0310:
        r4 = r4.requestFocus(r3);
        if (r4 != 0) goto L_0x002f;
    L_0x0316:
        r2 = r2 + 1;
        goto L_0x02f4;
    L_0x0319:
        r2 = 0;
        goto L_0x02e9;
    L_0x031b:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x0220;
    L_0x0322:
        r10 = r2;
        goto L_0x0108;
    L_0x0325:
        r2 = r6;
        goto L_0x00f9;
    L_0x0328:
        r4 = r3;
        r3 = r2;
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.ai(int):void");
    }

    private void bT() {
        if (this.zt != 0) {
            if (this.zu == null) {
                this.zu = new ArrayList();
            } else {
                this.zu.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.zu.add(getChildAt(i));
            }
            Collections.sort(this.zu, rsI);
        }
    }

    private void a(b bVar, int i, b bVar2) {
        float f;
        int i2;
        b bVar3;
        float f2;
        int i3;
        int count = this.yE.getCount();
        int bR = bR();
        if (bR > 0) {
            f = ((float) this.yM) / ((float) bR);
        } else {
            f = 0.0f;
        }
        if (bVar2 != null) {
            bR = bVar2.position;
            float f3;
            int i4;
            Object obj;
            int i5;
            if (bR < bVar.position) {
                bR++;
                f3 = (bVar2.zA + bVar2.zz) + f;
                i2 = 0;
                while (true) {
                    i4 = bR;
                    if (i4 > bVar.position || i2 >= this.ep.size()) {
                        break;
                    }
                    obj = this.ep.get(i2);
                    while (true) {
                        bVar3 = (b) obj;
                        if (i4 <= bVar3.position || i2 >= this.ep.size() - 1) {
                            i5 = i4;
                            f2 = f3;
                            i3 = i5;
                        } else {
                            i2++;
                            obj = this.ep.get(i2);
                        }
                    }
                    i5 = i4;
                    f2 = f3;
                    i3 = i5;
                    while (i3 < bVar3.position) {
                        i3++;
                        f2 = (1.0f + f) + f2;
                    }
                    bVar3.zA = f2;
                    f2 += bVar3.zz + f;
                    bR = i3 + 1;
                    f3 = f2;
                }
            } else if (bR > bVar.position) {
                i3 = this.ep.size() - 1;
                f2 = bVar2.zA;
                bR--;
                i2 = i3;
                while (true) {
                    f3 = f2;
                    i4 = bR;
                    if (i4 < bVar.position || i2 < 0) {
                        break;
                    }
                    obj = this.ep.get(i2);
                    while (true) {
                        bVar3 = (b) obj;
                        if (i4 >= bVar3.position || i2 <= 0) {
                            i5 = i4;
                            f2 = f3;
                            i3 = i5;
                        } else {
                            i2--;
                            obj = this.ep.get(i2);
                        }
                    }
                    i5 = i4;
                    f2 = f3;
                    i3 = i5;
                    while (i3 > bVar3.position) {
                        i3--;
                        f2 -= 1.0f + f;
                    }
                    f2 -= bVar3.zz + f;
                    bVar3.zA = f2;
                    bR = i3 - 1;
                }
            }
        }
        int size = this.ep.size();
        f2 = bVar.zA;
        i3 = bVar.position - 1;
        this.yQ = bVar.position == 0 ? bVar.zA : -3.4028235E38f;
        this.yR = bVar.position == count + -1 ? (bVar.zA + bVar.zz) - 1.0f : Float.MAX_VALUE;
        for (i2 = i - 1; i2 >= 0; i2--) {
            bVar3 = (b) this.ep.get(i2);
            while (i3 > bVar3.position) {
                i3--;
                f2 -= 1.0f + f;
            }
            f2 -= bVar3.zz + f;
            bVar3.zA = f2;
            if (bVar3.position == 0) {
                this.yQ = f2;
            }
            i3--;
        }
        f2 = (bVar.zA + bVar.zz) + f;
        i3 = bVar.position + 1;
        for (i2 = i + 1; i2 < size; i2++) {
            bVar3 = (b) this.ep.get(i2);
            while (i3 < bVar3.position) {
                i3++;
                f2 += 1.0f + f;
            }
            if (bVar3.position == count - 1) {
                this.yR = (bVar3.zz + f2) - 1.0f;
            }
            bVar3.zA = f2;
            f2 += bVar3.zz + f;
            i3++;
        }
        this.zk = false;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.yF;
        if (this.yE != null) {
            savedState.zE = this.yE.aZ();
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.yE != null) {
                this.yE.a(savedState.zE, savedState.zF);
                a(savedState.position, false, true);
                return;
            }
            this.yG = savedState.position;
            this.yH = savedState.zE;
            this.yI = savedState.zF;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        android.view.ViewGroup.LayoutParams layoutParams2;
        if (checkLayoutParams(layoutParams)) {
            layoutParams2 = layoutParams;
        } else {
            layoutParams2 = generateLayoutParams(layoutParams);
        }
        Assert.assertNotNull(layoutParams2);
        LayoutParams layoutParams3 = (LayoutParams) layoutParams2;
        layoutParams3.zB |= view instanceof a;
        if (!this.mInLayout) {
            super.addView(view, i, layoutParams2);
        } else if (layoutParams3 == null || !layoutParams3.zB) {
            layoutParams3.zC = true;
            addViewInLayout(view, i, layoutParams2);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    private b cy(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.ep.size()) {
                return null;
            }
            b bVar = (b) this.ep.get(i2);
            if (this.yE.a(view, bVar.object)) {
                return bVar;
            }
            i = i2 + 1;
        }
    }

    private b cz(View view) {
        while (true) {
            AdLandingViewPager parent = view.getParent();
            if (parent == this) {
                return cy(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = parent;
            }
        }
        return null;
    }

    private b xx(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.ep.size()) {
                return null;
            }
            b bVar = (b) this.ep.get(i3);
            if (bVar.position == i) {
                return bVar;
            }
            i2 = i3 + 1;
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.zj = true;
    }

    protected void onMeasure(int i, int i2) {
        LayoutParams layoutParams;
        int i3;
        int i4;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.yZ = Math.min(measuredWidth / 10, this.yY);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.zB) {
                    int i6 = layoutParams.gravity & 7;
                    int i7 = layoutParams.gravity & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
                    i3 = Integer.MIN_VALUE;
                    i4 = Integer.MIN_VALUE;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i4 = 1073741824;
                    }
                    if (layoutParams.width != -2) {
                        i7 = 1073741824;
                        i3 = layoutParams.width != -1 ? layoutParams.width : paddingLeft;
                    } else {
                        i7 = i3;
                        i3 = paddingLeft;
                    }
                    if (layoutParams.height != -2) {
                        i4 = 1073741824;
                        if (layoutParams.height != -1) {
                            measuredWidth = layoutParams.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i4));
                            if (obj != null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i4));
                    if (obj != null) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.yS = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.yT = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        i3 = getChildCount();
        for (i4 = 0; i4 < i3; i4++) {
            View childAt2 = getChildAt(i4);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if ((layoutParams == null || !layoutParams.zB) && layoutParams != null) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.zz * ((float) paddingLeft)), 1073741824), this.yT);
                }
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.yM;
            int i6 = this.yM;
            if (i3 <= 0 || this.ep.isEmpty()) {
                b xx = xx(this.yF);
                i5 = (int) ((xx != null ? Math.min(xx.zA, this.yR) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
                if (i5 != getScrollX()) {
                    s(false);
                    scrollTo(i5, getScrollY());
                    return;
                }
                return;
            }
            i6 = (int) (((float) (i5 + ((i - getPaddingLeft()) - getPaddingRight()))) * (((float) getScrollX()) / ((float) (i6 + ((i3 - getPaddingLeft()) - getPaddingRight())))));
            scrollTo(i6, getScrollY());
            if (!this.yJ.isFinished()) {
                this.yJ.startScroll(i6, 0, (int) (xx(this.yF).zA * ((float) i)), 0, this.yJ.getDuration() - this.yJ.timePassed());
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams;
        int max;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        int i8 = 0;
        while (i8 < childCount) {
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.zB) {
                    int i9 = layoutParams.gravity & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
                    switch (layoutParams.gravity & 7) {
                        case 1:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 3:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i9) {
                        case 16:
                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        case R.styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
                            i10 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = measuredWidth;
                            measuredWidth = i10;
                            break;
                        case 80:
                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            i10 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        default:
                            measuredWidth = paddingTop;
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                    }
                    max += scrollX;
                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i7 + 1;
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    i8++;
                    paddingLeft = paddingLeft;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
                }
            }
            measuredWidth = i7;
            paddingBottom = paddingTop;
            paddingTop = paddingRight;
            i8++;
            paddingLeft = paddingLeft;
            paddingRight = paddingTop;
            paddingTop = i7;
            i7 = measuredWidth;
        }
        max = (i5 - paddingLeft) - paddingRight;
        for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams.zB) {
                    b cy = cy(childAt2);
                    if (cy != null) {
                        i5 = ((int) (cy.zA * ((float) max))) + paddingLeft;
                        if (layoutParams.zC) {
                            layoutParams.zC = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.zz * ((float) max)), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.yO = paddingTop;
        this.yP = i6 - paddingBottom;
        this.zm = i7;
        if (this.zj) {
            a(this.yF, false, 0, false);
        }
        this.zj = false;
    }

    public void computeScroll() {
        if (this.yJ.isFinished() || !this.yJ.computeScrollOffset()) {
            s(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.yJ.getCurrX();
        int currY = this.yJ.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!ak(currX)) {
                this.yJ.abortAnimation();
                scrollTo(0, currY);
            }
        }
        z.E(this);
    }

    final boolean ak(int i) {
        if (this.ep.size() == 0) {
            this.zl = false;
            a(0, 0.0f, 0);
            if (this.zl) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        b byk = byk();
        int bR = bR();
        int i2 = this.yM + bR;
        float f = ((float) this.yM) / ((float) bR);
        int i3 = byk.position;
        float f2 = ((((float) i) / ((float) bR)) - byk.zA) / (byk.zz + f);
        bR = (int) (((float) i2) * f2);
        this.zl = false;
        a(i3, f2, bR);
        if (this.zl) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private void a(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        if (this.zm > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            i3 = 0;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.zB) {
                    int max;
                    switch (layoutParams.gravity & 7) {
                        case 1:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        case 3:
                            max = childAt.getWidth() + paddingLeft;
                            i4 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i4;
                            break;
                        case 5:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            i4 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        default:
                            max = paddingLeft;
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i4 = paddingRight;
                    paddingRight = paddingLeft;
                    paddingLeft = i4;
                }
                i3++;
                i4 = paddingLeft;
                paddingLeft = paddingRight;
                paddingRight = i4;
            }
        }
        if (this.zo != null) {
            this.zo.a(i, f, i2);
        }
        if (this.zp != null) {
            this.zp.a(i, f, i2);
        }
        if (this.zr != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = 0; paddingLeft < i3; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((LayoutParams) childAt2.getLayoutParams()).zB) {
                    this.zr.h(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) bR()));
                }
            }
        }
        this.zl = true;
    }

    private void s(boolean z) {
        int scrollX;
        int scrollY;
        int i = this.yi == 2 ? 1 : 0;
        if (i != 0) {
            setScrollingCacheEnabled(false);
            this.yJ.abortAnimation();
            scrollX = getScrollX();
            scrollY = getScrollY();
            int currX = this.yJ.getCurrX();
            int currY = this.yJ.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
        }
        this.yV = false;
        scrollX = 0;
        while (true) {
            scrollY = i;
            if (scrollX >= this.ep.size()) {
                break;
            }
            b bVar = (b) this.ep.get(scrollX);
            if (bVar.zy) {
                bVar.zy = false;
                scrollY = 1;
            }
            i = scrollX + 1;
        }
        if (scrollY == 0) {
            return;
        }
        if (z) {
            z.a((View) this, this.zw);
        } else {
            this.zw.run();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.iL = false;
            this.yX = false;
            this.fu = -1;
            if (this.ft == null) {
                return false;
            }
            this.ft.recycle();
            this.ft = null;
            return false;
        }
        if (action != 0) {
            if (this.iL) {
                return true;
            }
            if (this.yX) {
                return false;
            }
        }
        float x;
        switch (action) {
            case 0:
                x = motionEvent.getX();
                this.xP = x;
                this.za = x;
                x = motionEvent.getY();
                this.xQ = x;
                this.zb = x;
                this.fu = o.c(motionEvent, 0);
                this.yX = false;
                this.yJ.computeScrollOffset();
                if (this.yi == 2 && Math.abs(this.yJ.getFinalX() - this.yJ.getCurrX()) > this.zf) {
                    this.yJ.abortAnimation();
                    this.yV = false;
                    populate();
                    this.iL = true;
                    ag(1);
                    break;
                }
                s(false);
                this.iL = false;
                break;
            case 2:
                action = this.fu;
                if (action != -1) {
                    action = o.b(motionEvent, action);
                    float d = o.d(motionEvent, action);
                    float f = d - this.za;
                    float abs = Math.abs(f);
                    float e = o.e(motionEvent, action);
                    float abs2 = Math.abs(e - this.xQ);
                    if (f != 0.0f) {
                        x = this.za;
                        boolean z = (x < ((float) this.yZ) && f > 0.0f) || (x > ((float) (getWidth() - this.yZ)) && f < 0.0f);
                        if (!z && a(this, false, (int) f, (int) d, (int) e)) {
                            this.za = d;
                            this.zb = e;
                            this.yX = true;
                            return false;
                        }
                    }
                    if (abs > ((float) this.iN) && 0.5f * abs > abs2) {
                        this.iL = true;
                        ag(1);
                        this.za = f > 0.0f ? this.xP + ((float) this.iN) : this.xP - ((float) this.iN);
                        this.zb = e;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > ((float) this.iN)) {
                        this.yX = true;
                    }
                    if (this.iL && p(d)) {
                        z.E(this);
                        break;
                    }
                }
                break;
            case 6:
                h(motionEvent);
                break;
        }
        if (this.ft == null) {
            this.ft = VelocityTracker.obtain();
        }
        this.ft.addMovement(motionEvent);
        return this.iL;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.zg) {
            return true;
        }
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || this.yE == null || this.yE.getCount() == 0) {
            return false;
        }
        if (this.ft == null) {
            this.ft = VelocityTracker.obtain();
        }
        this.ft.addMovement(motionEvent);
        float x;
        int bR;
        float f;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.yJ.abortAnimation();
                this.yV = false;
                populate();
                this.iL = true;
                ag(1);
                x = motionEvent.getX();
                this.xP = x;
                this.za = x;
                x = motionEvent.getY();
                this.xQ = x;
                this.zb = x;
                this.fu = o.c(motionEvent, 0);
                break;
            case 1:
                if (this.iL) {
                    VelocityTracker velocityTracker = this.ft;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.zd);
                    int a = (int) y.a(velocityTracker, this.fu);
                    this.yV = true;
                    bR = bR();
                    int scrollX = getScrollX();
                    b byk = byk();
                    int i = byk.position;
                    f = ((((float) scrollX) / ((float) bR)) - byk.zA) / byk.zz;
                    bR = o.b(motionEvent, this.fu);
                    if (bR < 0) {
                        bR = 0;
                    }
                    a(a(i, f, a, (int) (o.d(motionEvent, bR) - this.xP)), true, true, a);
                    this.fu = -1;
                    cE();
                    z = this.zi.cw() | this.zh.cw();
                    break;
                }
                break;
            case 2:
                if (!this.iL) {
                    bR = o.b(motionEvent, this.fu);
                    float d = o.d(motionEvent, bR);
                    f = Math.abs(d - this.za);
                    float e = o.e(motionEvent, bR);
                    x = Math.abs(e - this.zb);
                    if (f > ((float) this.iN) && f > x) {
                        this.iL = true;
                        if (d - this.xP > 0.0f) {
                            x = this.xP + ((float) this.iN);
                        } else {
                            x = this.xP - ((float) this.iN);
                        }
                        this.za = x;
                        this.zb = e;
                        ag(1);
                        setScrollingCacheEnabled(true);
                    }
                }
                if (this.iL) {
                    z = p(o.d(motionEvent, o.b(motionEvent, this.fu))) | 0;
                    break;
                }
                break;
            case 3:
                if (this.iL) {
                    a(this.yF, true, 0, false);
                    this.fu = -1;
                    cE();
                    z = this.zi.cw() | this.zh.cw();
                    break;
                }
                break;
            case 5:
                bR = o.e(motionEvent);
                this.za = o.d(motionEvent, bR);
                this.fu = o.c(motionEvent, bR);
                break;
            case 6:
                h(motionEvent);
                this.za = o.d(motionEvent, o.b(motionEvent, this.fu));
                break;
        }
        if (z) {
            z.E(this);
        }
        return true;
    }

    private boolean p(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        float f3 = this.za - f;
        this.za = f;
        float scrollX = ((float) getScrollX()) + f3;
        int bR = bR();
        float f4 = ((float) bR) * this.yQ;
        float f5 = ((float) bR) * this.yR;
        b bVar = (b) this.ep.get(0);
        b bVar2 = (b) this.ep.get(this.ep.size() - 1);
        if (bVar.position != 0) {
            f4 = bVar.zA * ((float) bR);
            z = false;
        } else {
            z = true;
        }
        if (bVar2.position != this.yE.getCount() - 1) {
            f2 = bVar2.zA * ((float) bR);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.zh.x(Math.abs(f4 - scrollX) / ((float) bR));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.zi.x(Math.abs(scrollX - f2) / ((float) bR));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.za += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        ak((int) f4);
        return z3;
    }

    final b byk() {
        float f;
        int bR = bR();
        float scrollX = bR > 0 ? ((float) getScrollX()) / ((float) bR) : 0.0f;
        if (bR > 0) {
            f = ((float) this.yM) / ((float) bR);
        } else {
            f = 0.0f;
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        b bVar = null;
        while (i2 < this.ep.size()) {
            int i3;
            b bVar2;
            b bVar3 = (b) this.ep.get(i2);
            b bVar4;
            if (obj != null || bVar3.position == i + 1) {
                bVar4 = bVar3;
                i3 = i2;
                bVar2 = bVar4;
            } else {
                bVar3 = this.rsE;
                bVar3.zA = (f2 + f3) + f;
                bVar3.position = i + 1;
                bVar3.zz = 1.0f;
                bVar4 = bVar3;
                i3 = i2 - 1;
                bVar2 = bVar4;
            }
            f2 = bVar2.zA;
            f3 = (bVar2.zz + f2) + f;
            if (obj == null && scrollX < f2) {
                return bVar;
            }
            if (scrollX < f3 || i3 == this.ep.size() - 1) {
                return bVar2;
            }
            f3 = f2;
            i = bVar2.position;
            obj = null;
            f2 = bVar2.zz;
            bVar = bVar2;
            i2 = i3 + 1;
        }
        return bVar;
    }

    final int a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.ze || Math.abs(i2) <= this.zc) {
            i = (int) ((i >= this.yF ? 0.85f : 0.15f) + (((float) i) + f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.ep.size() > 0) {
            return Math.max(((b) this.ep.get(0)).position, Math.min(i, ((b) this.ep.get(this.ep.size() - 1)).position));
        }
        return i;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int B = z.B(this);
        if (B == 0 || (B == 1 && this.yE != null && this.yE.getCount() > 1)) {
            int width;
            if (!this.zh.isFinished()) {
                B = canvas.save();
                i = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-i) + getPaddingTop()), this.yQ * ((float) width));
                this.zh.setSize(i, width);
                i = this.zh.draw(canvas) | 0;
                canvas.restoreToCount(B);
            }
            if (!this.zi.isFinished()) {
                B = canvas.save();
                width = getWidth();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.yR + 1.0f)) * ((float) width));
                this.zi.setSize(height, width);
                i |= this.zi.draw(canvas);
                canvas.restoreToCount(B);
            }
        } else {
            this.zh.finish();
            this.zi.finish();
        }
        if (i != 0) {
            z.E(this);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.yM > 0 && this.yN != null && this.ep.size() > 0 && this.yE != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.yM) / ((float) width);
            b bVar = (b) this.ep.get(0);
            float f2 = bVar.zA;
            int size = this.ep.size();
            int i = bVar.position;
            int i2 = ((b) this.ep.get(size - 1)).position;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > bVar.position && i3 < size) {
                    i3++;
                    bVar = (b) this.ep.get(i3);
                }
                if (i4 == bVar.position) {
                    f3 = (bVar.zA + bVar.zz) * ((float) width);
                    f2 = (bVar.zA + bVar.zz) + f;
                } else {
                    f3 = (1.0f + f2) * ((float) width);
                    f2 += 1.0f + f;
                }
                if (((float) this.yM) + f3 > ((float) scrollX)) {
                    this.yN.setBounds((int) f3, this.yO, (int) ((((float) this.yM) + f3) + 0.5f), this.yP);
                    this.yN.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    public final boolean byl() {
        if (this.iL) {
            return false;
        }
        this.zg = true;
        ag(1);
        this.za = 0.0f;
        this.xP = 0.0f;
        if (this.ft == null) {
            this.ft = VelocityTracker.obtain();
        } else {
            this.ft.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.ft.addMovement(obtain);
        obtain.recycle();
        this.rsG = uptimeMillis;
        return true;
    }

    private void h(MotionEvent motionEvent) {
        int e = o.e(motionEvent);
        if (o.c(motionEvent, e) == this.fu) {
            e = e == 0 ? 1 : 0;
            this.za = o.d(motionEvent, e);
            this.fu = o.c(motionEvent, e);
            if (this.ft != null) {
                this.ft.clear();
            }
        }
    }

    final void cE() {
        this.iL = false;
        this.yX = false;
        if (this.ft != null) {
            this.ft.recycle();
            this.ft = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.yU != z) {
            this.yU = z;
        }
    }

    public boolean canScrollHorizontally(int i) {
        if (this.yE == null) {
            return false;
        }
        int bR = bR();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX > ((int) (((float) bR) * this.yQ))) {
                return true;
            }
            return false;
        } else if (i <= 0 || scrollX >= ((int) (((float) bR) * this.yR))) {
            return false;
        } else {
            return true;
        }
    }

    private boolean a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (z && z.g(view, -i)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchKeyEvent(android.view.KeyEvent r5) {
        /*
        r4 = this;
        r0 = 0;
        r1 = 1;
        r2 = super.dispatchKeyEvent(r5);
        if (r2 != 0) goto L_0x0018;
    L_0x0008:
        r2 = r5.getAction();
        if (r2 != 0) goto L_0x0015;
    L_0x000e:
        r2 = r5.getKeyCode();
        switch(r2) {
            case 21: goto L_0x001a;
            case 22: goto L_0x0021;
            case 61: goto L_0x0028;
            default: goto L_0x0015;
        };
    L_0x0015:
        r2 = r0;
    L_0x0016:
        if (r2 == 0) goto L_0x0019;
    L_0x0018:
        r0 = r1;
    L_0x0019:
        return r0;
    L_0x001a:
        r2 = 17;
        r2 = r4.arrowScroll(r2);
        goto L_0x0016;
    L_0x0021:
        r2 = 66;
        r2 = r4.arrowScroll(r2);
        goto L_0x0016;
    L_0x0028:
        r2 = android.os.Build.VERSION.SDK_INT;
        r3 = 11;
        if (r2 < r3) goto L_0x0015;
    L_0x002e:
        r2 = android.support.v4.view.g.a(r5);
        if (r2 == 0) goto L_0x003a;
    L_0x0034:
        r2 = 2;
        r2 = r4.arrowScroll(r2);
        goto L_0x0016;
    L_0x003a:
        r2 = android.support.v4.view.g.a(r5, r1);
        if (r2 == 0) goto L_0x0015;
    L_0x0040:
        r2 = r4.arrowScroll(r1);
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean arrowScroll(int r10) {
        /*
        r9 = this;
        r1 = 0;
        r8 = 66;
        r7 = 17;
        r4 = 1;
        r3 = 0;
        r2 = r9.findFocus();
        if (r2 != r9) goto L_0x003e;
    L_0x000d:
        r0 = r1;
    L_0x000e:
        r1 = android.view.FocusFinder.getInstance();
        r1 = r1.findNextFocus(r9, r0, r10);
        if (r1 == 0) goto L_0x00b3;
    L_0x0018:
        if (r1 == r0) goto L_0x00b3;
    L_0x001a:
        if (r10 != r7) goto L_0x0098;
    L_0x001c:
        r2 = r9.ey;
        r2 = r9.a(r2, r1);
        r2 = r2.left;
        r3 = r9.ey;
        r3 = r9.a(r3, r0);
        r3 = r3.left;
        if (r0 == 0) goto L_0x0093;
    L_0x002e:
        if (r2 < r3) goto L_0x0093;
    L_0x0030:
        r0 = r9.bX();
    L_0x0034:
        if (r0 == 0) goto L_0x003d;
    L_0x0036:
        r1 = android.view.SoundEffectConstants.getContantForFocusDirection(r10);
        r9.playSoundEffect(r1);
    L_0x003d:
        return r0;
    L_0x003e:
        if (r2 == 0) goto L_0x00cb;
    L_0x0040:
        r0 = r2.getParent();
    L_0x0044:
        r5 = r0 instanceof android.view.ViewGroup;
        if (r5 == 0) goto L_0x00ce;
    L_0x0048:
        if (r0 != r9) goto L_0x007c;
    L_0x004a:
        r0 = r4;
    L_0x004b:
        if (r0 != 0) goto L_0x00cb;
    L_0x004d:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r0 = r2.getClass();
        r0 = r0.getSimpleName();
        r5.append(r0);
        r0 = r2.getParent();
    L_0x0061:
        r2 = r0 instanceof android.view.ViewGroup;
        if (r2 == 0) goto L_0x0081;
    L_0x0065:
        r2 = " => ";
        r2 = r5.append(r2);
        r6 = r0.getClass();
        r6 = r6.getSimpleName();
        r2.append(r6);
        r0 = r0.getParent();
        goto L_0x0061;
    L_0x007c:
        r0 = r0.getParent();
        goto L_0x0044;
    L_0x0081:
        r0 = new java.lang.StringBuilder;
        r2 = "arrowScroll tried to find focus based on non-child current focused view ";
        r0.<init>(r2);
        r2 = r5.toString();
        r0.append(r2);
        r0 = r1;
        goto L_0x000e;
    L_0x0093:
        r0 = r1.requestFocus();
        goto L_0x0034;
    L_0x0098:
        if (r10 != r8) goto L_0x00c8;
    L_0x009a:
        r2 = r9.ey;
        r2 = r9.a(r2, r1);
        r2 = r2.left;
        r3 = r9.ey;
        r3 = r9.a(r3, r0);
        r3 = r3.left;
        if (r0 == 0) goto L_0x00ae;
    L_0x00ac:
        if (r2 <= r3) goto L_0x00c2;
    L_0x00ae:
        r0 = r1.requestFocus();
        goto L_0x0034;
    L_0x00b3:
        if (r10 == r7) goto L_0x00b7;
    L_0x00b5:
        if (r10 != r4) goto L_0x00bd;
    L_0x00b7:
        r0 = r9.bX();
        goto L_0x0034;
    L_0x00bd:
        if (r10 == r8) goto L_0x00c2;
    L_0x00bf:
        r0 = 2;
        if (r10 != r0) goto L_0x00c8;
    L_0x00c2:
        r0 = r9.bY();
        goto L_0x0034;
    L_0x00c8:
        r0 = r3;
        goto L_0x0034;
    L_0x00cb:
        r0 = r2;
        goto L_0x000e;
    L_0x00ce:
        r0 = r3;
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.arrowScroll(int):boolean");
    }

    private Rect a(Rect rect, View view) {
        Rect rect2;
        if (rect == null) {
            rect2 = new Rect();
        } else {
            rect2 = rect;
        }
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        AdLandingViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    private boolean bX() {
        if (this.yF <= 0) {
            return false;
        }
        d(this.yF - 1, true);
        return true;
    }

    private boolean bY() {
        if (this.yE == null || this.yF >= this.yE.getCount() - 1) {
            return false;
        }
        d(this.yF + 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        Assert.assertNotNull(arrayList);
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    b cy = cy(childAt);
                    if (cy != null && cy.position == this.yF) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if ((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                b cy = cy(childAt);
                if (cy != null && cy.position == this.yF) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                b cy = cy(childAt);
                if (cy != null && cy.position == this.yF && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == Downloads.RECV_BUFFER_SIZE) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                b cy = cy(childAt);
                if (cy != null && cy.position == this.yF && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
