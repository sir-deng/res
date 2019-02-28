package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.view.ai;
import android.support.v4.view.o;
import android.support.v4.view.z;
import android.support.v4.widget.k;
import android.support.v4.widget.m;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.reflect.Method;

public class ListPopupWindow {
    private static Method SI;
    private static Method SJ;
    private ListAdapter FP;
    public int Mh;
    public int PV;
    private int RL;
    public PopupWindow SK;
    public a SL;
    public int SM;
    int SN;
    int SO;
    private int SP;
    boolean SQ;
    private boolean SR;
    private boolean SS;
    int ST;
    private View SU;
    int SV;
    public View SW;
    private Drawable SX;
    public OnItemClickListener SY;
    private OnItemSelectedListener SZ;
    private final g Ta;
    private final f Tb;
    private final e Tc;
    private final c Td;
    private Runnable Te;
    private boolean Tf;
    private Rect ey;
    private Context mContext;
    private final Handler mHandler;
    private DataSetObserver mObserver;

    public static abstract class b implements OnTouchListener {
        private final float Tm;
        private final int Tn;
        private final int To;
        private final View Tp;
        private Runnable Tq;
        private Runnable Tr;
        private boolean Ts;
        private boolean Tt;
        private final int[] Tu = new int[2];
        private int fu;

        private class a implements Runnable {
            private a() {
            }

            /* synthetic */ a(b bVar, byte b) {
                this();
            }

            public final void run() {
                b.this.Tp.getParent().requestDisallowInterceptTouchEvent(true);
            }
        }

        private class b implements Runnable {
            private b() {
            }

            /* synthetic */ b(b bVar, byte b) {
                this();
            }

            public final void run() {
                b.b(b.this);
            }
        }

        public abstract ListPopupWindow dq();

        static /* synthetic */ void b(b bVar) {
            bVar.fh();
            View view = bVar.Tp;
            if (view.isEnabled() && !view.isLongClickable() && bVar.dr()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                view.onTouchEvent(obtain);
                obtain.recycle();
                bVar.Ts = true;
                bVar.Tt = true;
            }
        }

        public b(View view) {
            this.Tp = view;
            this.Tm = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.Tn = ViewConfiguration.getTapTimeout();
            this.To = (this.Tn + ViewConfiguration.getLongPressTimeout()) / 2;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouch(android.view.View r12, android.view.MotionEvent r13) {
            /*
            r11 = this;
            r5 = 0;
            r8 = 1;
            r7 = 0;
            r10 = r11.Ts;
            if (r10 == 0) goto L_0x0027;
        L_0x0007:
            r0 = r11.Tt;
            if (r0 == 0) goto L_0x0017;
        L_0x000b:
            r0 = r11.l(r13);
        L_0x000f:
            r11.Ts = r0;
            if (r0 != 0) goto L_0x0015;
        L_0x0013:
            if (r10 == 0) goto L_0x0016;
        L_0x0015:
            r7 = r8;
        L_0x0016:
            return r7;
        L_0x0017:
            r0 = r11.l(r13);
            if (r0 != 0) goto L_0x0023;
        L_0x001d:
            r0 = r11.ec();
            if (r0 != 0) goto L_0x0025;
        L_0x0023:
            r0 = r8;
            goto L_0x000f;
        L_0x0025:
            r0 = r7;
            goto L_0x000f;
        L_0x0027:
            r1 = r11.Tp;
            r0 = r1.isEnabled();
            if (r0 == 0) goto L_0x0036;
        L_0x002f:
            r0 = android.support.v4.view.o.d(r13);
            switch(r0) {
                case 0: goto L_0x0057;
                case 1: goto L_0x00d2;
                case 2: goto L_0x0086;
                case 3: goto L_0x00d2;
                default: goto L_0x0036;
            };
        L_0x0036:
            r0 = r7;
        L_0x0037:
            if (r0 == 0) goto L_0x00d7;
        L_0x0039:
            r0 = r11.dr();
            if (r0 == 0) goto L_0x00d7;
        L_0x003f:
            r9 = r8;
        L_0x0040:
            if (r9 == 0) goto L_0x0055;
        L_0x0042:
            r0 = android.os.SystemClock.uptimeMillis();
            r4 = 3;
            r2 = r0;
            r6 = r5;
            r0 = android.view.MotionEvent.obtain(r0, r2, r4, r5, r6, r7);
            r1 = r11.Tp;
            r1.onTouchEvent(r0);
            r0.recycle();
        L_0x0055:
            r0 = r9;
            goto L_0x000f;
        L_0x0057:
            r0 = r13.getPointerId(r7);
            r11.fu = r0;
            r11.Tt = r7;
            r0 = r11.Tq;
            if (r0 != 0) goto L_0x006a;
        L_0x0063:
            r0 = new android.support.v7.widget.ListPopupWindow$b$a;
            r0.<init>(r11, r7);
            r11.Tq = r0;
        L_0x006a:
            r0 = r11.Tq;
            r2 = r11.Tn;
            r2 = (long) r2;
            r1.postDelayed(r0, r2);
            r0 = r11.Tr;
            if (r0 != 0) goto L_0x007d;
        L_0x0076:
            r0 = new android.support.v7.widget.ListPopupWindow$b$b;
            r0.<init>(r11, r7);
            r11.Tr = r0;
        L_0x007d:
            r0 = r11.Tr;
            r2 = r11.To;
            r2 = (long) r2;
            r1.postDelayed(r0, r2);
            goto L_0x0036;
        L_0x0086:
            r0 = r11.fu;
            r0 = r13.findPointerIndex(r0);
            if (r0 < 0) goto L_0x0036;
        L_0x008e:
            r2 = r13.getX(r0);
            r0 = r13.getY(r0);
            r3 = r11.Tm;
            r4 = -r3;
            r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r4 < 0) goto L_0x00d0;
        L_0x009d:
            r4 = -r3;
            r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
            if (r4 < 0) goto L_0x00d0;
        L_0x00a2:
            r4 = r1.getRight();
            r6 = r1.getLeft();
            r4 = r4 - r6;
            r4 = (float) r4;
            r4 = r4 + r3;
            r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r2 >= 0) goto L_0x00d0;
        L_0x00b1:
            r2 = r1.getBottom();
            r4 = r1.getTop();
            r2 = r2 - r4;
            r2 = (float) r2;
            r2 = r2 + r3;
            r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r0 >= 0) goto L_0x00d0;
        L_0x00c0:
            r0 = r8;
        L_0x00c1:
            if (r0 != 0) goto L_0x0036;
        L_0x00c3:
            r11.fh();
            r0 = r1.getParent();
            r0.requestDisallowInterceptTouchEvent(r8);
            r0 = r8;
            goto L_0x0037;
        L_0x00d0:
            r0 = r7;
            goto L_0x00c1;
        L_0x00d2:
            r11.fh();
            goto L_0x0036;
        L_0x00d7:
            r9 = r7;
            goto L_0x0040;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ListPopupWindow.b.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }

        public boolean dr() {
            ListPopupWindow dq = dq();
            if (!(dq == null || dq.SK.isShowing())) {
                dq.show();
            }
            return true;
        }

        protected boolean ec() {
            ListPopupWindow dq = dq();
            if (dq != null && dq.SK.isShowing()) {
                dq.dismiss();
            }
            return true;
        }

        private void fh() {
            if (this.Tr != null) {
                this.Tp.removeCallbacks(this.Tr);
            }
            if (this.Tq != null) {
                this.Tp.removeCallbacks(this.Tq);
            }
        }

        private boolean l(MotionEvent motionEvent) {
            View view = this.Tp;
            ListPopupWindow dq = dq();
            if (dq == null || !dq.SK.isShowing()) {
                return false;
            }
            View a = dq.SL;
            if (a == null || !a.isShown()) {
                return false;
            }
            MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            int[] iArr = this.Tu;
            view.getLocationOnScreen(iArr);
            obtainNoHistory.offsetLocation((float) iArr[0], (float) iArr[1]);
            int[] iArr2 = this.Tu;
            a.getLocationOnScreen(iArr2);
            obtainNoHistory.offsetLocation((float) (-iArr2[0]), (float) (-iArr2[1]));
            boolean h = a.h(obtainNoHistory, this.fu);
            obtainNoHistory.recycle();
            int d = o.d(motionEvent);
            boolean z;
            if (d == 1 || d == 3) {
                z = false;
            } else {
                z = true;
            }
            if (h && z) {
                return true;
            }
            return false;
        }
    }

    private class c implements Runnable {
        private c() {
        }

        /* synthetic */ c(ListPopupWindow listPopupWindow, byte b) {
            this();
        }

        public final void run() {
            ListPopupWindow.this.clearListSelection();
        }
    }

    private class d extends DataSetObserver {
        private d() {
        }

        /* synthetic */ d(ListPopupWindow listPopupWindow, byte b) {
            this();
        }

        public final void onChanged() {
            if (ListPopupWindow.this.SK.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        public final void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    private class e implements OnScrollListener {
        private e() {
        }

        /* synthetic */ e(ListPopupWindow listPopupWindow, byte b) {
            this();
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !ListPopupWindow.this.isInputMethodNotNeeded() && ListPopupWindow.this.SK.getContentView() != null) {
                ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.Ta);
                ListPopupWindow.this.Ta.run();
            }
        }
    }

    private class f implements OnTouchListener {
        private f() {
        }

        /* synthetic */ f(ListPopupWindow listPopupWindow, byte b) {
            this();
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && ListPopupWindow.this.SK != null && ListPopupWindow.this.SK.isShowing() && x >= 0 && x < ListPopupWindow.this.SK.getWidth() && y >= 0 && y < ListPopupWindow.this.SK.getHeight()) {
                ListPopupWindow.this.mHandler.postDelayed(ListPopupWindow.this.Ta, 250);
            } else if (action == 1) {
                ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.Ta);
            }
            return false;
        }
    }

    private class g implements Runnable {
        private g() {
        }

        /* synthetic */ g(ListPopupWindow listPopupWindow, byte b) {
            this();
        }

        public final void run() {
            if (ListPopupWindow.this.SL != null && z.ak(ListPopupWindow.this.SL) && ListPopupWindow.this.SL.getCount() > ListPopupWindow.this.SL.getChildCount() && ListPopupWindow.this.SL.getChildCount() <= ListPopupWindow.this.ST) {
                ListPopupWindow.this.SK.setInputMethodMode(2);
                ListPopupWindow.this.show();
            }
        }
    }

    private static class a extends ListViewCompat {
        private boolean Th;
        private boolean Ti;
        private boolean Tj;
        private ai Tk;
        private k Tl;

        public a(Context context, boolean z) {
            super(context, null, android.support.v7.a.a.a.dropDownListViewStyle);
            this.Ti = z;
            setCacheColorHint(0);
        }

        public final boolean h(MotionEvent motionEvent, int i) {
            boolean z;
            boolean z2;
            View childAt;
            int d = o.d(motionEvent);
            switch (d) {
                case 1:
                    z = false;
                    break;
                case 2:
                    z = true;
                    break;
                case 3:
                    z = false;
                    z2 = false;
                    break;
                default:
                    z = false;
                    z2 = true;
                    break;
            }
            int findPointerIndex = motionEvent.findPointerIndex(i);
            if (findPointerIndex < 0) {
                z = false;
                z2 = false;
            } else {
                int x = (int) motionEvent.getX(findPointerIndex);
                findPointerIndex = (int) motionEvent.getY(findPointerIndex);
                int pointToPosition = pointToPosition(x, findPointerIndex);
                if (pointToPosition == -1) {
                    z2 = z;
                    z = true;
                } else {
                    View childAt2 = getChildAt(pointToPosition - getFirstVisiblePosition());
                    float f = (float) x;
                    float f2 = (float) findPointerIndex;
                    this.Tj = true;
                    if (VERSION.SDK_INT >= 21) {
                        drawableHotspotChanged(f, f2);
                    }
                    if (!isPressed()) {
                        setPressed(true);
                    }
                    layoutChildren();
                    if (this.TC != -1) {
                        childAt = getChildAt(this.TC - getFirstVisiblePosition());
                        if (!(childAt == null || childAt == childAt2 || !childAt.isPressed())) {
                            childAt.setPressed(false);
                        }
                    }
                    this.TC = pointToPosition;
                    float left = f - ((float) childAt2.getLeft());
                    float top = f2 - ((float) childAt2.getTop());
                    if (VERSION.SDK_INT >= 21) {
                        childAt2.drawableHotspotChanged(left, top);
                    }
                    if (!childAt2.isPressed()) {
                        childAt2.setPressed(true);
                    }
                    Drawable selector = getSelector();
                    if (selector == null || pointToPosition == -1) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        selector.setVisible(false, false);
                    }
                    super.a(pointToPosition, childAt2);
                    if (z) {
                        Rect rect = this.Tx;
                        float exactCenterX = rect.exactCenterX();
                        float exactCenterY = rect.exactCenterY();
                        if (getVisibility() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        selector.setVisible(z, false);
                        android.support.v4.b.a.a.a(selector, exactCenterX, exactCenterY);
                    }
                    Drawable selector2 = getSelector();
                    if (!(selector2 == null || pointToPosition == -1)) {
                        android.support.v4.b.a.a.a(selector2, f, f2);
                    }
                    R(false);
                    refreshDrawableState();
                    if (d == 1) {
                        performItemClick(childAt2, pointToPosition, getItemIdAtPosition(pointToPosition));
                    }
                    z = false;
                    z2 = true;
                }
            }
            if (!z2 || r0) {
                this.Tj = false;
                setPressed(false);
                drawableStateChanged();
                childAt = getChildAt(this.TC - getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setPressed(false);
                }
                if (this.Tk != null) {
                    this.Tk.cancel();
                    this.Tk = null;
                }
            }
            if (z2) {
                if (this.Tl == null) {
                    this.Tl = new k(this);
                }
                this.Tl.t(true);
                this.Tl.onTouch(this, motionEvent);
            } else if (this.Tl != null) {
                this.Tl.t(false);
            }
            return z2;
        }

        protected final boolean fg() {
            return this.Tj || super.fg();
        }

        public final boolean isInTouchMode() {
            return (this.Ti && this.Th) || super.isInTouchMode();
        }

        public final boolean hasWindowFocus() {
            return this.Ti || super.hasWindowFocus();
        }

        public final boolean isFocused() {
            return this.Ti || super.isFocused();
        }

        public final boolean hasFocus() {
            return this.Ti || super.hasFocus();
        }
    }

    static {
        try {
            SI = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
        }
        try {
            SJ = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, android.support.v7.a.a.a.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.a.a.a.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.SM = -2;
        this.PV = -2;
        this.SP = 1002;
        this.Mh = 0;
        this.SR = false;
        this.SS = false;
        this.ST = Integer.MAX_VALUE;
        this.SV = 0;
        this.Ta = new g();
        this.Tb = new f();
        this.Tc = new e();
        this.Td = new c();
        this.ey = new Rect();
        this.mContext = context;
        this.mHandler = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.a.a.k.ListPopupWindow, i, i2);
        this.SN = obtainStyledAttributes.getDimensionPixelOffset(android.support.v7.a.a.k.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.SO = obtainStyledAttributes.getDimensionPixelOffset(android.support.v7.a.a.k.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.SO != 0) {
            this.SQ = true;
        }
        obtainStyledAttributes.recycle();
        this.SK = new AppCompatPopupWindow(context, attributeSet, i);
        this.SK.setInputMethodMode(1);
        this.RL = android.support.v4.d.f.getLayoutDirectionFromLocale(this.mContext.getResources().getConfiguration().locale);
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (this.mObserver == null) {
            this.mObserver = new d();
        } else if (this.FP != null) {
            this.FP.unregisterDataSetObserver(this.mObserver);
        }
        this.FP = listAdapter;
        if (this.FP != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        if (this.SL != null) {
            this.SL.setAdapter(this.FP);
        }
    }

    public final void setModal(boolean z) {
        this.Tf = z;
        this.SK.setFocusable(z);
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.SK.setBackgroundDrawable(drawable);
    }

    public final void setVerticalOffset(int i) {
        this.SO = i;
        this.SQ = true;
    }

    public final void setContentWidth(int i) {
        Drawable background = this.SK.getBackground();
        if (background != null) {
            background.getPadding(this.ey);
            this.PV = (this.ey.left + this.ey.right) + i;
            return;
        }
        this.PV = i;
    }

    public void show() {
        int i;
        int i2;
        boolean z;
        int makeMeasureSpec;
        boolean z2 = true;
        LayoutParams layoutParams;
        View view;
        if (this.SL == null) {
            Context context = this.mContext;
            this.Te = new Runnable() {
                public final void run() {
                    View view = ListPopupWindow.this.SW;
                    if (view != null && view.getWindowToken() != null) {
                        ListPopupWindow.this.show();
                    }
                }
            };
            this.SL = new a(context, !this.Tf);
            if (this.SX != null) {
                this.SL.setSelector(this.SX);
            }
            this.SL.setAdapter(this.FP);
            this.SL.setOnItemClickListener(this.SY);
            this.SL.setFocusable(true);
            this.SL.setFocusableInTouchMode(true);
            this.SL.setOnItemSelectedListener(new OnItemSelectedListener() {
                public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i != -1) {
                        a a = ListPopupWindow.this.SL;
                        if (a != null) {
                            a.Th = false;
                        }
                    }
                }

                public final void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.SL.setOnScrollListener(this.Tc);
            if (this.SZ != null) {
                this.SL.setOnItemSelectedListener(this.SZ);
            }
            View view2 = this.SL;
            View view3 = this.SU;
            if (view3 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                switch (this.SV) {
                    case 0:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams2);
                        break;
                    case 1:
                        linearLayout.addView(view2, layoutParams2);
                        linearLayout.addView(view3);
                        break;
                    default:
                        new StringBuilder("Invalid hint position ").append(this.SV);
                        break;
                }
                if (this.PV >= 0) {
                    i = this.PV;
                    i2 = Integer.MIN_VALUE;
                } else {
                    i2 = 0;
                    i = 0;
                }
                view3.measure(MeasureSpec.makeMeasureSpec(i, i2), 0);
                layoutParams = (LayoutParams) view3.getLayoutParams();
                i2 = layoutParams.bottomMargin + (view3.getMeasuredHeight() + layoutParams.topMargin);
                view = linearLayout;
            } else {
                view = view2;
                i2 = 0;
            }
            this.SK.setContentView(view);
        } else {
            this.SK.getContentView();
            view = this.SU;
            if (view != null) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                i2 = layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                i2 = 0;
            }
        }
        Drawable background = this.SK.getBackground();
        if (background != null) {
            background.getPadding(this.ey);
            i = this.ey.top + this.ey.bottom;
            if (!this.SQ) {
                this.SO = -this.ey.top;
            }
        } else {
            this.ey.setEmpty();
            i = 0;
        }
        if (this.SK.getInputMethodMode() == 2) {
            z = true;
        } else {
            z = false;
        }
        int b = b(this.SW, this.SO, z);
        if (this.SR || this.SM == -1) {
            i2 = b + i;
        } else {
            switch (this.PV) {
                case -2:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.ey.left + this.ey.right), Integer.MIN_VALUE);
                    break;
                case -1:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.ey.left + this.ey.right), 1073741824);
                    break;
                default:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.PV, 1073741824);
                    break;
            }
            makeMeasureSpec = this.SL.P(makeMeasureSpec, b - i2);
            if (makeMeasureSpec > 0) {
                i2 += i;
            }
            i2 += makeMeasureSpec;
        }
        z = isInputMethodNotNeeded();
        m.a(this.SK, this.SP);
        PopupWindow popupWindow;
        if (this.SK.isShowing()) {
            if (this.PV == -1) {
                i = -1;
            } else if (this.PV == -2) {
                i = this.SW.getWidth();
            } else {
                i = this.PV;
            }
            if (this.SM == -1) {
                if (z) {
                    makeMeasureSpec = i2;
                } else {
                    makeMeasureSpec = -1;
                }
                PopupWindow popupWindow2;
                if (z) {
                    popupWindow2 = this.SK;
                    if (this.PV == -1) {
                        i2 = -1;
                    } else {
                        i2 = 0;
                    }
                    popupWindow2.setWidth(i2);
                    this.SK.setHeight(0);
                    b = makeMeasureSpec;
                } else {
                    popupWindow2 = this.SK;
                    if (this.PV == -1) {
                        i2 = -1;
                    } else {
                        i2 = 0;
                    }
                    popupWindow2.setWidth(i2);
                    this.SK.setHeight(-1);
                    b = makeMeasureSpec;
                }
            } else if (this.SM == -2) {
                b = i2;
            } else {
                b = this.SM;
            }
            popupWindow = this.SK;
            if (this.SS || this.SR) {
                z2 = false;
            }
            popupWindow.setOutsideTouchable(z2);
            popupWindow = this.SK;
            View view4 = this.SW;
            int i3 = this.SN;
            makeMeasureSpec = this.SO;
            if (i < 0) {
                i = -1;
            }
            if (b < 0) {
                b = -1;
            }
            popupWindow.update(view4, i3, makeMeasureSpec, i, b);
            return;
        }
        if (this.PV == -1) {
            makeMeasureSpec = -1;
        } else if (this.PV == -2) {
            makeMeasureSpec = this.SW.getWidth();
        } else {
            makeMeasureSpec = this.PV;
        }
        if (this.SM == -1) {
            i2 = -1;
        } else if (this.SM != -2) {
            i2 = this.SM;
        }
        this.SK.setWidth(makeMeasureSpec);
        this.SK.setHeight(i2);
        if (SI != null) {
            try {
                SI.invoke(this.SK, new Object[]{Boolean.valueOf(true)});
            } catch (Exception e) {
            }
        }
        popupWindow = this.SK;
        if (this.SS || this.SR) {
            z2 = false;
        }
        popupWindow.setOutsideTouchable(z2);
        this.SK.setTouchInterceptor(this.Tb);
        m.a(this.SK, this.SW, this.SN, this.SO, this.Mh);
        this.SL.setSelection(-1);
        if (!this.Tf || this.SL.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.Tf) {
            this.mHandler.post(this.Td);
        }
    }

    public final void dismiss() {
        this.SK.dismiss();
        if (this.SU != null) {
            ViewParent parent = this.SU.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.SU);
            }
        }
        this.SK.setContentView(null);
        this.SL = null;
        this.mHandler.removeCallbacks(this.Ta);
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        this.SK.setOnDismissListener(onDismissListener);
    }

    public final void ff() {
        this.SK.setInputMethodMode(2);
    }

    public final void clearListSelection() {
        a aVar = this.SL;
        if (aVar != null) {
            aVar.Th = true;
            aVar.requestLayout();
        }
    }

    public final boolean isInputMethodNotNeeded() {
        return this.SK.getInputMethodMode() == 2;
    }

    private int b(View view, int i, boolean z) {
        if (SJ != null) {
            try {
                return ((Integer) SJ.invoke(this.SK, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception e) {
            }
        }
        return this.SK.getMaxAvailableHeight(view, i);
    }
}
