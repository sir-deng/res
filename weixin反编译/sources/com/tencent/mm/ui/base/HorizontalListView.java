package com.tencent.mm.ui.base;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import android.widget.Scroller;
import java.util.LinkedList;
import java.util.Queue;

public class HorizontalListView extends AdapterView<ListAdapter> {
    protected ListAdapter FP;
    public a vyz;
    protected Scroller yJ;
    private int ygA = -1;
    private int ygB = 0;
    protected int ygC;
    protected int ygD;
    private int ygE = Integer.MAX_VALUE;
    private int ygF = 0;
    private GestureDetector ygG;
    private Queue<View> ygH = new LinkedList();
    private OnItemSelectedListener ygI;
    private OnItemClickListener ygJ;
    private boolean ygK = false;
    private DataSetObserver ygL = new DataSetObserver() {
        public final void onChanged() {
            synchronized (HorizontalListView.this) {
                HorizontalListView.this.ygK = true;
            }
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
        }

        public final void onInvalidated() {
            HorizontalListView.this.reset();
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
        }
    };
    private OnGestureListener ygM = new SimpleOnGestureListener() {
        public final boolean onDown(MotionEvent motionEvent) {
            return HorizontalListView.this.cpz();
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return HorizontalListView.this.aD(f);
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            synchronized (HorizontalListView.this) {
                HorizontalListView horizontalListView = HorizontalListView.this;
                horizontalListView.ygD += (int) f;
            }
            HorizontalListView.this.requestLayout();
            return true;
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            Rect rect = new Rect();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= HorizontalListView.this.getChildCount()) {
                    break;
                }
                View childAt = HorizontalListView.this.getChildAt(i2);
                rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    if (HorizontalListView.this.ygJ != null) {
                        HorizontalListView.this.ygJ.onItemClick(HorizontalListView.this, childAt, (HorizontalListView.this.ygA + 1) + i2, HorizontalListView.this.FP.getItemId((HorizontalListView.this.ygA + 1) + i2));
                    }
                    if (HorizontalListView.this.ygI != null) {
                        HorizontalListView.this.ygI.onItemSelected(HorizontalListView.this, childAt, (HorizontalListView.this.ygA + 1) + i2, HorizontalListView.this.FP.getItemId((HorizontalListView.this.ygA + 1) + i2));
                    }
                } else {
                    i = i2 + 1;
                }
            }
            return true;
        }
    };
    public boolean ygz = true;

    public interface a {
        boolean q(MotionEvent motionEvent);
    }

    public /* bridge */ /* synthetic */ Adapter getAdapter() {
        return this.FP;
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    private synchronized void initView() {
        this.ygA = -1;
        this.ygB = 0;
        this.ygF = 0;
        this.ygC = 0;
        this.ygD = 0;
        this.ygE = Integer.MAX_VALUE;
        this.yJ = new Scroller(getContext());
        this.ygG = new GestureDetector(getContext(), this.ygM);
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.ygI = onItemSelectedListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.ygJ = onItemClickListener;
    }

    public View getSelectedView() {
        return null;
    }

    public final void setAdapter(ListAdapter listAdapter) {
        if (this.FP != null) {
            this.FP.unregisterDataSetObserver(this.ygL);
        }
        this.FP = listAdapter;
        this.FP.registerDataSetObserver(this.ygL);
        reset();
    }

    private synchronized void reset() {
        initView();
        removeAllViewsInLayout();
        requestLayout();
    }

    public void setSelection(int i) {
    }

    private void I(View view, int i) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -1);
        }
        addViewInLayout(view, i, layoutParams, true);
        view.measure(MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected synchronized void onLayout(boolean r8, int r9, int r10, int r11, int r12) {
        /*
        r7 = this;
        r1 = 0;
        monitor-enter(r7);
        super.onLayout(r8, r9, r10, r11, r12);	 Catch:{ all -> 0x00a0 }
        r0 = r7.FP;	 Catch:{ all -> 0x00a0 }
        if (r0 != 0) goto L_0x000b;
    L_0x0009:
        monitor-exit(r7);
        return;
    L_0x000b:
        r0 = r7.ygK;	 Catch:{ all -> 0x00a0 }
        if (r0 == 0) goto L_0x001c;
    L_0x000f:
        r0 = r7.ygC;	 Catch:{ all -> 0x00a0 }
        r7.initView();	 Catch:{ all -> 0x00a0 }
        r7.removeAllViewsInLayout();	 Catch:{ all -> 0x00a0 }
        r7.ygD = r0;	 Catch:{ all -> 0x00a0 }
        r0 = 0;
        r7.ygK = r0;	 Catch:{ all -> 0x00a0 }
    L_0x001c:
        r0 = r7.yJ;	 Catch:{ all -> 0x00a0 }
        r0 = r0.computeScrollOffset();	 Catch:{ all -> 0x00a0 }
        if (r0 == 0) goto L_0x002c;
    L_0x0024:
        r0 = r7.yJ;	 Catch:{ all -> 0x00a0 }
        r0 = r0.getCurrX();	 Catch:{ all -> 0x00a0 }
        r7.ygD = r0;	 Catch:{ all -> 0x00a0 }
    L_0x002c:
        r0 = r7.ygD;	 Catch:{ all -> 0x00a0 }
        if (r0 > 0) goto L_0x0039;
    L_0x0030:
        r0 = 0;
        r7.ygD = r0;	 Catch:{ all -> 0x00a0 }
        r0 = r7.yJ;	 Catch:{ all -> 0x00a0 }
        r2 = 1;
        r0.forceFinished(r2);	 Catch:{ all -> 0x00a0 }
    L_0x0039:
        r0 = r7.ygD;	 Catch:{ all -> 0x00a0 }
        r2 = r7.ygE;	 Catch:{ all -> 0x00a0 }
        if (r0 < r2) goto L_0x0049;
    L_0x003f:
        r0 = r7.ygE;	 Catch:{ all -> 0x00a0 }
        r7.ygD = r0;	 Catch:{ all -> 0x00a0 }
        r0 = r7.yJ;	 Catch:{ all -> 0x00a0 }
        r2 = 1;
        r0.forceFinished(r2);	 Catch:{ all -> 0x00a0 }
    L_0x0049:
        r0 = r7.ygC;	 Catch:{ all -> 0x00a0 }
        r2 = r7.ygD;	 Catch:{ all -> 0x00a0 }
        r3 = r0 - r2;
        r0 = 0;
        r0 = r7.getChildAt(r0);	 Catch:{ all -> 0x00a0 }
    L_0x0054:
        if (r0 == 0) goto L_0x007a;
    L_0x0056:
        r2 = r0.getRight();	 Catch:{ all -> 0x00a0 }
        r2 = r2 + r3;
        if (r2 > 0) goto L_0x007a;
    L_0x005d:
        r2 = r7.ygF;	 Catch:{ all -> 0x00a0 }
        r4 = r0.getMeasuredWidth();	 Catch:{ all -> 0x00a0 }
        r2 = r2 + r4;
        r7.ygF = r2;	 Catch:{ all -> 0x00a0 }
        r2 = r7.ygH;	 Catch:{ all -> 0x00a0 }
        r2.offer(r0);	 Catch:{ all -> 0x00a0 }
        r7.removeViewInLayout(r0);	 Catch:{ all -> 0x00a0 }
        r0 = r7.ygA;	 Catch:{ all -> 0x00a0 }
        r0 = r0 + 1;
        r7.ygA = r0;	 Catch:{ all -> 0x00a0 }
        r0 = 0;
        r0 = r7.getChildAt(r0);	 Catch:{ all -> 0x00a0 }
        goto L_0x0054;
    L_0x007a:
        r0 = r7.getChildCount();	 Catch:{ all -> 0x00a0 }
        r0 = r0 + -1;
        r0 = r7.getChildAt(r0);	 Catch:{ all -> 0x00a0 }
        if (r0 == 0) goto L_0x00a3;
    L_0x0086:
        r2 = r0.getLeft();	 Catch:{ all -> 0x00a0 }
        r2 = r2 + r3;
        r4 = r7.getWidth();	 Catch:{ all -> 0x00a0 }
        if (r2 < r4) goto L_0x00a3;
    L_0x0091:
        r2 = r7.ygH;	 Catch:{ all -> 0x00a0 }
        r2.offer(r0);	 Catch:{ all -> 0x00a0 }
        r7.removeViewInLayout(r0);	 Catch:{ all -> 0x00a0 }
        r0 = r7.ygB;	 Catch:{ all -> 0x00a0 }
        r0 = r0 + -1;
        r7.ygB = r0;	 Catch:{ all -> 0x00a0 }
        goto L_0x007a;
    L_0x00a0:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
    L_0x00a3:
        r0 = r7.getChildCount();	 Catch:{ all -> 0x00a0 }
        r0 = r0 + -1;
        r0 = r7.getChildAt(r0);	 Catch:{ all -> 0x00a0 }
        if (r0 == 0) goto L_0x0184;
    L_0x00af:
        r0 = r0.getRight();	 Catch:{ all -> 0x00a0 }
    L_0x00b3:
        r2 = r0;
    L_0x00b4:
        r0 = r2 + r3;
        r4 = r7.getWidth();	 Catch:{ all -> 0x00a0 }
        if (r0 >= r4) goto L_0x0104;
    L_0x00bc:
        r0 = r7.ygB;	 Catch:{ all -> 0x00a0 }
        r4 = r7.FP;	 Catch:{ all -> 0x00a0 }
        r4 = r4.getCount();	 Catch:{ all -> 0x00a0 }
        if (r0 >= r4) goto L_0x0104;
    L_0x00c6:
        r4 = r7.FP;	 Catch:{ all -> 0x00a0 }
        r5 = r7.ygB;	 Catch:{ all -> 0x00a0 }
        r0 = r7.ygH;	 Catch:{ all -> 0x00a0 }
        r0 = r0.poll();	 Catch:{ all -> 0x00a0 }
        r0 = (android.view.View) r0;	 Catch:{ all -> 0x00a0 }
        r0 = r4.getView(r5, r0, r7);	 Catch:{ all -> 0x00a0 }
        r4 = -1;
        r7.I(r0, r4);	 Catch:{ all -> 0x00a0 }
        r0 = r0.getMeasuredWidth();	 Catch:{ all -> 0x00a0 }
        r0 = r0 + r2;
        r2 = r7.ygB;	 Catch:{ all -> 0x00a0 }
        r4 = r7.FP;	 Catch:{ all -> 0x00a0 }
        r4 = r4.getCount();	 Catch:{ all -> 0x00a0 }
        r4 = r4 + -1;
        if (r2 != r4) goto L_0x00f5;
    L_0x00eb:
        r2 = r7.ygC;	 Catch:{ all -> 0x00a0 }
        r2 = r2 + r0;
        r4 = r7.getWidth();	 Catch:{ all -> 0x00a0 }
        r2 = r2 - r4;
        r7.ygE = r2;	 Catch:{ all -> 0x00a0 }
    L_0x00f5:
        r2 = r7.ygE;	 Catch:{ all -> 0x00a0 }
        if (r2 >= 0) goto L_0x00fc;
    L_0x00f9:
        r2 = 0;
        r7.ygE = r2;	 Catch:{ all -> 0x00a0 }
    L_0x00fc:
        r2 = r7.ygB;	 Catch:{ all -> 0x00a0 }
        r2 = r2 + 1;
        r7.ygB = r2;	 Catch:{ all -> 0x00a0 }
        r2 = r0;
        goto L_0x00b4;
    L_0x0104:
        r0 = 0;
        r0 = r7.getChildAt(r0);	 Catch:{ all -> 0x00a0 }
        if (r0 == 0) goto L_0x0182;
    L_0x010b:
        r0 = r0.getLeft();	 Catch:{ all -> 0x00a0 }
    L_0x010f:
        r2 = r0;
    L_0x0110:
        r0 = r2 + r3;
        if (r0 <= 0) goto L_0x0143;
    L_0x0114:
        r0 = r7.ygA;	 Catch:{ all -> 0x00a0 }
        if (r0 < 0) goto L_0x0143;
    L_0x0118:
        r4 = r7.FP;	 Catch:{ all -> 0x00a0 }
        r5 = r7.ygA;	 Catch:{ all -> 0x00a0 }
        r0 = r7.ygH;	 Catch:{ all -> 0x00a0 }
        r0 = r0.poll();	 Catch:{ all -> 0x00a0 }
        r0 = (android.view.View) r0;	 Catch:{ all -> 0x00a0 }
        r4 = r4.getView(r5, r0, r7);	 Catch:{ all -> 0x00a0 }
        r0 = 0;
        r7.I(r4, r0);	 Catch:{ all -> 0x00a0 }
        r0 = r4.getMeasuredWidth();	 Catch:{ all -> 0x00a0 }
        r0 = r2 - r0;
        r2 = r7.ygA;	 Catch:{ all -> 0x00a0 }
        r2 = r2 + -1;
        r7.ygA = r2;	 Catch:{ all -> 0x00a0 }
        r2 = r7.ygF;	 Catch:{ all -> 0x00a0 }
        r4 = r4.getMeasuredWidth();	 Catch:{ all -> 0x00a0 }
        r2 = r2 - r4;
        r7.ygF = r2;	 Catch:{ all -> 0x00a0 }
        r2 = r0;
        goto L_0x0110;
    L_0x0143:
        r0 = r7.getChildCount();	 Catch:{ all -> 0x00a0 }
        if (r0 <= 0) goto L_0x016c;
    L_0x0149:
        r0 = r7.ygF;	 Catch:{ all -> 0x00a0 }
        r0 = r0 + r3;
        r7.ygF = r0;	 Catch:{ all -> 0x00a0 }
        r0 = r7.ygF;	 Catch:{ all -> 0x00a0 }
    L_0x0150:
        r2 = r7.getChildCount();	 Catch:{ all -> 0x00a0 }
        if (r1 >= r2) goto L_0x016c;
    L_0x0156:
        r2 = r7.getChildAt(r1);	 Catch:{ all -> 0x00a0 }
        r3 = r2.getMeasuredWidth();	 Catch:{ all -> 0x00a0 }
        r4 = 0;
        r5 = r0 + r3;
        r6 = r2.getMeasuredHeight();	 Catch:{ all -> 0x00a0 }
        r2.layout(r0, r4, r5, r6);	 Catch:{ all -> 0x00a0 }
        r0 = r0 + r3;
        r1 = r1 + 1;
        goto L_0x0150;
    L_0x016c:
        r0 = r7.ygD;	 Catch:{ all -> 0x00a0 }
        r7.ygC = r0;	 Catch:{ all -> 0x00a0 }
        r0 = r7.yJ;	 Catch:{ all -> 0x00a0 }
        r0 = r0.isFinished();	 Catch:{ all -> 0x00a0 }
        if (r0 != 0) goto L_0x0009;
    L_0x0178:
        r0 = new com.tencent.mm.ui.base.HorizontalListView$2;	 Catch:{ all -> 0x00a0 }
        r0.<init>();	 Catch:{ all -> 0x00a0 }
        r7.post(r0);	 Catch:{ all -> 0x00a0 }
        goto L_0x0009;
    L_0x0182:
        r0 = r1;
        goto L_0x010f;
    L_0x0184:
        r0 = r1;
        goto L_0x00b3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.base.HorizontalListView.onLayout(boolean, int, int, int, int):void");
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.vyz != null) {
            this.vyz.q(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent) | this.ygG.onTouchEvent(motionEvent);
    }

    protected final boolean aD(float f) {
        synchronized (this) {
            this.yJ.fling(this.ygD, 0, (int) (-f), 0, 0, this.ygE, 0, 0);
        }
        requestLayout();
        return true;
    }

    protected final boolean cpz() {
        this.yJ.forceFinished(true);
        return true;
    }
}
