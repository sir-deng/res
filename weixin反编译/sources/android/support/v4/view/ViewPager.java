package android.support.v4.view;

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
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.xwalk.core.R;

public class ViewPager extends ViewGroup {
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
    private static final i zv = new i();
    private final ArrayList<b> ep = new ArrayList();
    private final Rect ey = new Rect();
    private VelocityTracker ft;
    private int fu = -1;
    private boolean iL;
    private int iN;
    private boolean mInLayout;
    private float xP;
    private float xQ;
    private int yA;
    private final b yD = new b();
    public u yE;
    public int yF;
    private int yG = -1;
    private Parcelable yH = null;
    private ClassLoader yI = null;
    private Scroller yJ;
    private boolean yK;
    private g yL;
    private int yM;
    private Drawable yN;
    private int yO;
    private int yP;
    private float yQ = -3.4028235E38f;
    private float yR = Float.MAX_VALUE;
    private int yS;
    private int yT;
    private boolean yU;
    private boolean yV;
    public int yW = 1;
    private boolean yX;
    private int yY;
    private int yZ;
    private int yi = 0;
    private float za;
    private float zb;
    private int zc;
    private int zd;
    private int ze;
    private int zf;
    private boolean zg;
    private android.support.v4.widget.i zh;
    private android.support.v4.widget.i zi;
    private boolean zj = true;
    private boolean zk = false;
    private boolean zl;
    private int zm;
    public List<e> zn;
    public e zo;
    private e zp;
    d zq;
    private f zr;
    private int zt;
    private ArrayList<View> zu;
    private final Runnable zw = new Runnable() {
        public final void run() {
            ViewPager.this.ag(0);
            ViewPager.this.populate();
        }
    };

    static class b {
        Object object;
        int position;
        float zA;
        boolean zy;
        float zz;

        b() {
        }
    }

    interface d {
        void b(u uVar, u uVar2);
    }

    public interface e {
        void a(int i, float f, int i2);

        void ae(int i);

        void af(int i);
    }

    public interface f {
        void h(View view, float f);
    }

    private class g extends DataSetObserver {
        private g() {
        }

        /* synthetic */ g(ViewPager viewPager, byte b) {
            this();
        }

        public final void onChanged() {
            ViewPager.this.bS();
        }

        public final void onInvalidated() {
            ViewPager.this.bS();
        }
    }

    static class i implements Comparator<View> {
        i() {
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

    class c extends a {
        c() {
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            android.support.v4.view.a.f a = android.support.v4.view.a.a.a(accessibilityEvent);
            a.setScrollable(ca());
            if (accessibilityEvent.getEventType() == Downloads.RECV_BUFFER_SIZE && ViewPager.this.yE != null) {
                a.setItemCount(ViewPager.this.yE.getCount());
                a.setFromIndex(ViewPager.this.yF);
                a.setToIndex(ViewPager.this.yF);
            }
        }

        public final void a(View view, android.support.v4.view.a.b bVar) {
            super.a(view, bVar);
            bVar.setClassName(ViewPager.class.getName());
            bVar.setScrollable(ca());
            if (ViewPager.this.canScrollHorizontally(1)) {
                bVar.addAction(Downloads.RECV_BUFFER_SIZE);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                bVar.addAction(8192);
            }
        }

        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case Downloads.RECV_BUFFER_SIZE /*4096*/:
                    if (!ViewPager.this.canScrollHorizontally(1)) {
                        return false;
                    }
                    ViewPager.this.ah(ViewPager.this.yF + 1);
                    return true;
                case 8192:
                    if (!ViewPager.this.canScrollHorizontally(-1)) {
                        return false;
                    }
                    ViewPager.this.ah(ViewPager.this.yF - 1);
                    return true;
                default:
                    return false;
            }
        }

        private boolean ca() {
            return ViewPager.this.yE != null && ViewPager.this.yE.getCount() > 1;
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
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.yz);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    interface a {
    }

    public static class h implements e {
        public void a(int i, float f, int i2) {
        }

        public void ae(int i) {
        }

        public void af(int i) {
        }
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

    public ViewPager(Context context, AttributeSet attributeSet) {
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
        this.zh = new android.support.v4.widget.i(context2);
        this.zi = new android.support.v4.widget.i(context2);
        this.ze = (int) (25.0f * f);
        this.zf = (int) (2.0f * f);
        this.yY = (int) (16.0f * f);
        z.a((View) this, new c());
        if (z.F(this) == 0) {
            z.i(this, 1);
        }
        z.b((View) this, new t() {
            private final Rect ey = new Rect();

            public final ap a(View view, ap apVar) {
                ap a = z.a(view, apVar);
                if (a.isConsumed()) {
                    return a;
                }
                Rect rect = this.ey;
                rect.left = a.getSystemWindowInsetLeft();
                rect.top = a.getSystemWindowInsetTop();
                rect.right = a.getSystemWindowInsetRight();
                rect.bottom = a.getSystemWindowInsetBottom();
                int childCount = ViewPager.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    ap b = z.b(ViewPager.this.getChildAt(i), a);
                    rect.left = Math.min(b.getSystemWindowInsetLeft(), rect.left);
                    rect.top = Math.min(b.getSystemWindowInsetTop(), rect.top);
                    rect.right = Math.min(b.getSystemWindowInsetRight(), rect.right);
                    rect.bottom = Math.min(b.getSystemWindowInsetBottom(), rect.bottom);
                }
                return a.e(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.zw);
        if (!(this.yJ == null || this.yJ.isFinished())) {
            this.yJ.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    private void ag(int i) {
        int i2 = 0;
        if (this.yi != i) {
            this.yi = i;
            if (this.zr != null) {
                int i3 = i != 0 ? 1 : 0;
                int childCount = getChildCount();
                for (int i4 = 0; i4 < childCount; i4++) {
                    z.a(getChildAt(i4), i3 != 0 ? 2 : 0, null);
                }
            }
            if (this.zo != null) {
                this.zo.af(i);
            }
            if (this.zn != null) {
                int size = this.zn.size();
                while (i2 < size) {
                    e eVar = (e) this.zn.get(i2);
                    if (eVar != null) {
                        eVar.af(i);
                    }
                    i2++;
                }
            }
            if (this.zp != null) {
                this.zp.af(i);
            }
        }
    }

    public final void a(u uVar) {
        if (this.yE != null) {
            int i;
            this.yE.a(null);
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
        u uVar2 = this.yE;
        this.yE = uVar;
        this.yA = 0;
        if (this.yE != null) {
            if (this.yL == null) {
                this.yL = new g();
            }
            this.yE.a(this.yL);
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
        if (this.zq != null && uVar2 != uVar) {
            this.zq.b(uVar2, uVar);
        }
    }

    private int bR() {
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

    private void a(int i, boolean z, boolean z2, int i2) {
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
                if (z3) {
                    al(i);
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
        int bR;
        b aj = aj(i);
        if (aj != null) {
            bR = (int) (((float) bR()) * Math.max(this.yQ, Math.min(aj.zA, this.yR)));
        } else {
            bR = 0;
        }
        if (z) {
            if (getChildCount() == 0) {
                setScrollingCacheEnabled(false);
            } else {
                int currX;
                int i3;
                Object obj = (this.yJ == null || this.yJ.isFinished()) ? null : 1;
                if (obj != null) {
                    currX = this.yK ? this.yJ.getCurrX() : this.yJ.getStartX();
                    this.yJ.abortAnimation();
                    setScrollingCacheEnabled(false);
                    i3 = currX;
                } else {
                    i3 = getScrollX();
                }
                int scrollY = getScrollY();
                bR -= i3;
                int i4 = 0 - scrollY;
                if (bR == 0 && i4 == 0) {
                    s(false);
                    populate();
                    ag(0);
                } else {
                    setScrollingCacheEnabled(true);
                    ag(2);
                    currX = bR();
                    int i5 = currX / 2;
                    float sin = (((float) i5) * ((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, (1.0f * ((float) Math.abs(bR))) / ((float) currX)) - 0.5f)) * 0.4712389167638204d))))) + ((float) i5);
                    int abs = Math.abs(i2);
                    i5 = Math.min(abs > 0 ? Math.round(1000.0f * Math.abs(sin / ((float) abs))) * 4 : (int) (((((float) Math.abs(bR)) / ((((float) currX) * 1.0f) + ((float) this.yM))) + 1.0f) * 100.0f), 600);
                    this.yK = false;
                    this.yJ.startScroll(i3, scrollY, bR, i4, i5);
                    z.E(this);
                }
            }
            if (z2) {
                al(i);
                return;
            }
            return;
        }
        if (z2) {
            al(i);
        }
        s(false);
        scrollTo(bR, 0);
        ak(bR);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.zt == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) ((View) this.zu.get(i2)).getLayoutParams()).zD;
    }

    final e a(e eVar) {
        e eVar2 = this.zp;
        this.zp = eVar;
        return eVar2;
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

    private b o(int i, int i2) {
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
        int max;
        int count = this.yE.getCount();
        this.yA = count;
        boolean z = this.ep.size() < (this.yW * 2) + 1 && this.ep.size() < count;
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

    public final void populate() {
        ai(this.yF);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void ai(int r18) {
        /*
        r17 = this;
        r2 = 0;
        r0 = r17;
        r3 = r0.yF;
        r0 = r18;
        if (r3 == r0) goto L_0x030c;
    L_0x0009:
        r0 = r17;
        r2 = r0.yF;
        r0 = r17;
        r2 = r0.aj(r2);
        r0 = r18;
        r1 = r17;
        r1.yF = r0;
        r3 = r2;
    L_0x001a:
        r0 = r17;
        r2 = r0.yE;
        if (r2 != 0) goto L_0x0024;
    L_0x0020:
        r17.bT();
    L_0x0023:
        return;
    L_0x0024:
        r0 = r17;
        r2 = r0.yV;
        if (r2 == 0) goto L_0x002e;
    L_0x002a:
        r17.bT();
        goto L_0x0023;
    L_0x002e:
        r2 = r17.getWindowToken();
        if (r2 == 0) goto L_0x0023;
    L_0x0034:
        r0 = r17;
        r2 = r0.yW;
        r4 = 0;
        r0 = r17;
        r5 = r0.yF;
        r5 = r5 - r2;
        r10 = java.lang.Math.max(r4, r5);
        r0 = r17;
        r4 = r0.yE;
        r11 = r4.getCount();
        r4 = r11 + -1;
        r0 = r17;
        r5 = r0.yF;
        r2 = r2 + r5;
        r12 = java.lang.Math.min(r4, r2);
        r0 = r17;
        r2 = r0.yA;
        if (r11 == r2) goto L_0x00c3;
    L_0x005b:
        r2 = r17.getResources();	 Catch:{ NotFoundException -> 0x00b9 }
        r3 = r17.getId();	 Catch:{ NotFoundException -> 0x00b9 }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00b9 }
    L_0x0067:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4.<init>(r5);
        r0 = r17;
        r5 = r0.yA;
        r4 = r4.append(r5);
        r5 = ", found: ";
        r4 = r4.append(r5);
        r4 = r4.append(r11);
        r5 = " Pager id: ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " Pager class: ";
        r2 = r2.append(r4);
        r4 = r17.getClass();
        r2 = r2.append(r4);
        r4 = " Problematic adapter: ";
        r2 = r2.append(r4);
        r0 = r17;
        r4 = r0.yE;
        r4 = r4.getClass();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x00b9:
        r2 = move-exception;
        r2 = r17.getId();
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x0067;
    L_0x00c3:
        r5 = 0;
        r2 = 0;
        r4 = r2;
    L_0x00c6:
        r0 = r17;
        r2 = r0.ep;
        r2 = r2.size();
        if (r4 >= r2) goto L_0x0309;
    L_0x00d0:
        r0 = r17;
        r2 = r0.ep;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.b) r2;
        r6 = r2.position;
        r0 = r17;
        r7 = r0.yF;
        if (r6 < r7) goto L_0x0156;
    L_0x00e2:
        r6 = r2.position;
        r0 = r17;
        r7 = r0.yF;
        if (r6 != r7) goto L_0x0309;
    L_0x00ea:
        if (r2 != 0) goto L_0x0306;
    L_0x00ec:
        if (r11 <= 0) goto L_0x0306;
    L_0x00ee:
        r0 = r17;
        r2 = r0.yF;
        r0 = r17;
        r2 = r0.o(r2, r4);
        r9 = r2;
    L_0x00f9:
        if (r9 == 0) goto L_0x0270;
    L_0x00fb:
        r8 = 0;
        r7 = r4 + -1;
        if (r7 < 0) goto L_0x015b;
    L_0x0100:
        r0 = r17;
        r2 = r0.ep;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.ViewPager.b) r2;
    L_0x010a:
        r13 = r17.bR();
        if (r13 > 0) goto L_0x015d;
    L_0x0110:
        r5 = 0;
    L_0x0111:
        r0 = r17;
        r6 = r0.yF;
        r6 = r6 + -1;
        r15 = r6;
        r6 = r8;
        r8 = r15;
        r16 = r7;
        r7 = r4;
        r4 = r16;
    L_0x011f:
        if (r8 < 0) goto L_0x01a3;
    L_0x0121:
        r14 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r14 < 0) goto L_0x016d;
    L_0x0125:
        if (r8 >= r10) goto L_0x016d;
    L_0x0127:
        if (r2 == 0) goto L_0x01a3;
    L_0x0129:
        r14 = r2.position;
        if (r8 != r14) goto L_0x0153;
    L_0x012d:
        r14 = r2.zy;
        if (r14 != 0) goto L_0x0153;
    L_0x0131:
        r0 = r17;
        r14 = r0.ep;
        r14.remove(r4);
        r0 = r17;
        r14 = r0.yE;
        r2 = r2.object;
        r0 = r17;
        r14.a(r0, r8, r2);
        r4 = r4 + -1;
        r7 = r7 + -1;
        if (r4 < 0) goto L_0x016b;
    L_0x0149:
        r0 = r17;
        r2 = r0.ep;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.b) r2;
    L_0x0153:
        r8 = r8 + -1;
        goto L_0x011f;
    L_0x0156:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x00c6;
    L_0x015b:
        r2 = 0;
        goto L_0x010a;
    L_0x015d:
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r6 = r9.zz;
        r5 = r5 - r6;
        r6 = r17.getPaddingLeft();
        r6 = (float) r6;
        r14 = (float) r13;
        r6 = r6 / r14;
        r5 = r5 + r6;
        goto L_0x0111;
    L_0x016b:
        r2 = 0;
        goto L_0x0153;
    L_0x016d:
        if (r2 == 0) goto L_0x0187;
    L_0x016f:
        r14 = r2.position;
        if (r8 != r14) goto L_0x0187;
    L_0x0173:
        r2 = r2.zz;
        r6 = r6 + r2;
        r4 = r4 + -1;
        if (r4 < 0) goto L_0x0185;
    L_0x017a:
        r0 = r17;
        r2 = r0.ep;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.b) r2;
        goto L_0x0153;
    L_0x0185:
        r2 = 0;
        goto L_0x0153;
    L_0x0187:
        r2 = r4 + 1;
        r0 = r17;
        r2 = r0.o(r8, r2);
        r2 = r2.zz;
        r6 = r6 + r2;
        r7 = r7 + 1;
        if (r4 < 0) goto L_0x01a1;
    L_0x0196:
        r0 = r17;
        r2 = r0.ep;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.b) r2;
        goto L_0x0153;
    L_0x01a1:
        r2 = 0;
        goto L_0x0153;
    L_0x01a3:
        r5 = r9.zz;
        r8 = r7 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x026b;
    L_0x01ad:
        r0 = r17;
        r2 = r0.ep;
        r2 = r2.size();
        if (r8 >= r2) goto L_0x0211;
    L_0x01b7:
        r0 = r17;
        r2 = r0.ep;
        r2 = r2.get(r8);
        r2 = (android.support.v4.view.ViewPager.b) r2;
        r6 = r2;
    L_0x01c2:
        if (r13 > 0) goto L_0x0213;
    L_0x01c4:
        r2 = 0;
        r4 = r2;
    L_0x01c6:
        r0 = r17;
        r2 = r0.yF;
        r2 = r2 + 1;
        r15 = r6;
        r6 = r8;
        r8 = r2;
        r2 = r15;
    L_0x01d0:
        if (r8 >= r11) goto L_0x026b;
    L_0x01d2:
        r10 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1));
        if (r10 < 0) goto L_0x0221;
    L_0x01d6:
        if (r8 <= r12) goto L_0x0221;
    L_0x01d8:
        if (r2 == 0) goto L_0x026b;
    L_0x01da:
        r10 = r2.position;
        if (r8 != r10) goto L_0x0301;
    L_0x01de:
        r10 = r2.zy;
        if (r10 != 0) goto L_0x0301;
    L_0x01e2:
        r0 = r17;
        r10 = r0.ep;
        r10.remove(r6);
        r0 = r17;
        r10 = r0.yE;
        r2 = r2.object;
        r0 = r17;
        r10.a(r0, r8, r2);
        r0 = r17;
        r2 = r0.ep;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x021f;
    L_0x01fe:
        r0 = r17;
        r2 = r0.ep;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.b) r2;
    L_0x0208:
        r15 = r5;
        r5 = r2;
        r2 = r15;
    L_0x020b:
        r8 = r8 + 1;
        r15 = r2;
        r2 = r5;
        r5 = r15;
        goto L_0x01d0;
    L_0x0211:
        r6 = 0;
        goto L_0x01c2;
    L_0x0213:
        r2 = r17.getPaddingRight();
        r2 = (float) r2;
        r4 = (float) r13;
        r2 = r2 / r4;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r4;
        r4 = r2;
        goto L_0x01c6;
    L_0x021f:
        r2 = 0;
        goto L_0x0208;
    L_0x0221:
        if (r2 == 0) goto L_0x0246;
    L_0x0223:
        r10 = r2.position;
        if (r8 != r10) goto L_0x0246;
    L_0x0227:
        r2 = r2.zz;
        r5 = r5 + r2;
        r6 = r6 + 1;
        r0 = r17;
        r2 = r0.ep;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x0244;
    L_0x0236:
        r0 = r17;
        r2 = r0.ep;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.b) r2;
    L_0x0240:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x020b;
    L_0x0244:
        r2 = 0;
        goto L_0x0240;
    L_0x0246:
        r0 = r17;
        r2 = r0.o(r8, r6);
        r6 = r6 + 1;
        r2 = r2.zz;
        r5 = r5 + r2;
        r0 = r17;
        r2 = r0.ep;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x0269;
    L_0x025b:
        r0 = r17;
        r2 = r0.ep;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.b) r2;
    L_0x0265:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x020b;
    L_0x0269:
        r2 = 0;
        goto L_0x0265;
    L_0x026b:
        r0 = r17;
        r0.a(r9, r7, r3);
    L_0x0270:
        r0 = r17;
        r3 = r0.yE;
        if (r9 == 0) goto L_0x02b7;
    L_0x0276:
        r2 = r9.object;
    L_0x0278:
        r3.e(r2);
        r0 = r17;
        r2 = r0.yE;
        r2.aY();
        r4 = r17.getChildCount();
        r2 = 0;
        r3 = r2;
    L_0x0288:
        if (r3 >= r4) goto L_0x02b9;
    L_0x028a:
        r0 = r17;
        r5 = r0.getChildAt(r3);
        r2 = r5.getLayoutParams();
        r2 = (android.support.v4.view.ViewPager.LayoutParams) r2;
        r2.zD = r3;
        r6 = r2.zB;
        if (r6 != 0) goto L_0x02b3;
    L_0x029c:
        r6 = r2.zz;
        r7 = 0;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 != 0) goto L_0x02b3;
    L_0x02a3:
        r0 = r17;
        r5 = r0.ao(r5);
        if (r5 == 0) goto L_0x02b3;
    L_0x02ab:
        r6 = r5.zz;
        r2.zz = r6;
        r5 = r5.position;
        r2.position = r5;
    L_0x02b3:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x0288;
    L_0x02b7:
        r2 = 0;
        goto L_0x0278;
    L_0x02b9:
        r17.bT();
        r2 = r17.hasFocus();
        if (r2 == 0) goto L_0x0023;
    L_0x02c2:
        r2 = r17.findFocus();
        if (r2 == 0) goto L_0x02ff;
    L_0x02c8:
        r0 = r17;
        r2 = r0.ap(r2);
    L_0x02ce:
        if (r2 == 0) goto L_0x02d8;
    L_0x02d0:
        r2 = r2.position;
        r0 = r17;
        r3 = r0.yF;
        if (r2 == r3) goto L_0x0023;
    L_0x02d8:
        r2 = 0;
    L_0x02d9:
        r3 = r17.getChildCount();
        if (r2 >= r3) goto L_0x0023;
    L_0x02df:
        r0 = r17;
        r3 = r0.getChildAt(r2);
        r0 = r17;
        r4 = r0.ao(r3);
        if (r4 == 0) goto L_0x02fc;
    L_0x02ed:
        r4 = r4.position;
        r0 = r17;
        r5 = r0.yF;
        if (r4 != r5) goto L_0x02fc;
    L_0x02f5:
        r4 = 2;
        r3 = r3.requestFocus(r4);
        if (r3 != 0) goto L_0x0023;
    L_0x02fc:
        r2 = r2 + 1;
        goto L_0x02d9;
    L_0x02ff:
        r2 = 0;
        goto L_0x02ce;
    L_0x0301:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x020b;
    L_0x0306:
        r9 = r2;
        goto L_0x00f9;
    L_0x0309:
        r2 = r5;
        goto L_0x00ea;
    L_0x030c:
        r3 = r2;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.ai(int):void");
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
            Collections.sort(this.zu, zv);
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

    private b ao(View view) {
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

    private b ap(View view) {
        while (true) {
            ViewPager parent = view.getParent();
            if (parent == this) {
                return ao(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = parent;
            }
        }
        return null;
    }

    private b aj(int i) {
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

    public void onMeasure(int i, int i2) {
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
                if (layoutParams == null || !layoutParams.zB) {
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
                b aj = aj(this.yF);
                i5 = (int) ((aj != null ? Math.min(aj.zA, this.yR) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
                if (i5 != getScrollX()) {
                    s(false);
                    scrollTo(i5, getScrollY());
                }
            } else if (this.yJ.isFinished()) {
                scrollTo((int) (((float) (i5 + ((i - getPaddingLeft()) - getPaddingRight()))) * (((float) getScrollX()) / ((float) (i6 + ((i3 - getPaddingLeft()) - getPaddingRight()))))), getScrollY());
            } else {
                this.yJ.setFinalX(this.yF * bR());
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
                    b ao = ao(childAt2);
                    if (ao != null) {
                        i5 = ((int) (ao.zA * ((float) max))) + paddingLeft;
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
        this.yK = true;
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

    private boolean ak(int i) {
        if (this.ep.size() != 0) {
            b bW = bW();
            int bR = bR();
            int i2 = this.yM + bR;
            float f = ((float) this.yM) / ((float) bR);
            int i3 = bW.position;
            float f2 = ((((float) i) / ((float) bR)) - bW.zA) / (bW.zz + f);
            bR = (int) (((float) i2) * f2);
            this.zl = false;
            a(i3, f2, bR);
            if (this.zl) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.zj) {
            return false;
        } else {
            this.zl = false;
            a(0, 0.0f, 0);
            if (this.zl) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
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
        if (this.zn != null) {
            paddingRight = this.zn.size();
            for (paddingLeft = 0; paddingLeft < paddingRight; paddingLeft++) {
                e eVar = (e) this.zn.get(paddingLeft);
                if (eVar != null) {
                    eVar.a(i, f, i2);
                }
            }
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

    private void al(int i) {
        if (this.zo != null) {
            this.zo.ae(i);
        }
        if (this.zn != null) {
            int size = this.zn.size();
            for (int i2 = 0; i2 < size; i2++) {
                e eVar = (e) this.zn.get(i2);
                if (eVar != null) {
                    eVar.ae(i);
                }
            }
        }
        if (this.zp != null) {
            this.zp.ae(i);
        }
    }

    private void s(boolean z) {
        int scrollX;
        int scrollY;
        int i = this.yi == 2 ? 1 : 0;
        if (i != 0) {
            boolean z2;
            setScrollingCacheEnabled(false);
            if (this.yJ.isFinished()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                this.yJ.abortAnimation();
                scrollX = getScrollX();
                scrollY = getScrollY();
                int currX = this.yJ.getCurrX();
                int currY = this.yJ.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        ak(currX);
                    }
                }
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
            bU();
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
                this.yK = true;
                this.yJ.computeScrollOffset();
                if (this.yi == 2 && Math.abs(this.yJ.getFinalX() - this.yJ.getCurrX()) > this.zf) {
                    this.yJ.abortAnimation();
                    this.yV = false;
                    populate();
                    this.iL = true;
                    bV();
                    ag(1);
                    break;
                }
                s(false);
                this.iL = false;
                break;
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
                        bV();
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
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.yE == null || this.yE.getCount() == 0) {
            return false;
        }
        if (this.ft == null) {
            this.ft = VelocityTracker.obtain();
        }
        this.ft.addMovement(motionEvent);
        float x;
        int i;
        float f;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.yJ.abortAnimation();
                this.yV = false;
                populate();
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
                    int bR = bR();
                    int scrollX = getScrollX();
                    b bW = bW();
                    float f2 = ((float) this.yM) / ((float) bR);
                    i = bW.position;
                    f = ((((float) scrollX) / ((float) bR)) - bW.zA) / (bW.zz + f2);
                    if (Math.abs((int) (o.d(motionEvent, o.b(motionEvent, this.fu)) - this.xP)) <= this.ze || Math.abs(a) <= this.zc) {
                        scrollX = (int) ((((float) i) + f) + (i >= this.yF ? 0.4f : 0.6f));
                    } else {
                        if (a <= 0) {
                            i++;
                        }
                        scrollX = i;
                    }
                    if (this.ep.size() > 0) {
                        scrollX = Math.max(((b) this.ep.get(0)).position, Math.min(scrollX, ((b) this.ep.get(this.ep.size() - 1)).position));
                    }
                    a(scrollX, true, true, a);
                    z = bU();
                    break;
                }
                break;
            case 2:
                if (!this.iL) {
                    i = o.b(motionEvent, this.fu);
                    if (i == -1) {
                        z = bU();
                        break;
                    }
                    float d = o.d(motionEvent, i);
                    f = Math.abs(d - this.za);
                    float e = o.e(motionEvent, i);
                    x = Math.abs(e - this.zb);
                    if (f > ((float) this.iN) && f > x) {
                        this.iL = true;
                        bV();
                        if (d - this.xP > 0.0f) {
                            x = this.xP + ((float) this.iN);
                        } else {
                            x = this.xP - ((float) this.iN);
                        }
                        this.za = x;
                        this.zb = e;
                        ag(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
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
                    z = bU();
                    break;
                }
                break;
            case 5:
                i = o.e(motionEvent);
                this.za = o.d(motionEvent, i);
                this.fu = o.c(motionEvent, i);
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

    private boolean bU() {
        this.fu = -1;
        this.iL = false;
        this.yX = false;
        if (this.ft != null) {
            this.ft.recycle();
            this.ft = null;
        }
        return this.zh.cw() | this.zi.cw();
    }

    private void bV() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
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

    private b bW() {
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
                bVar3 = this.yD;
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
                    this.yN.setBounds(Math.round(f3), this.yO, Math.round(((float) this.yM) + f3), this.yP);
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
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.dispatchKeyEvent(android.view.KeyEvent):boolean");
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
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.arrowScroll(int):boolean");
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
        ViewPager parent = view.getParent();
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
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    b ao = ao(childAt);
                    if (ao != null && ao.position == this.yF) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                b ao = ao(childAt);
                if (ao != null && ao.position == this.yF) {
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
                b ao = ao(childAt);
                if (ao != null && ao.position == this.yF && childAt.requestFocus(i, rect)) {
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
                b ao = ao(childAt);
                if (ao != null && ao.position == this.yF && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
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
