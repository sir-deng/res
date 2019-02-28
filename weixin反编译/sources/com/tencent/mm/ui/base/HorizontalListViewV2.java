package com.tencent.mm.ui.base;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.z;
import android.support.v4.widget.i;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HorizontalListViewV2 extends AdapterView<ListAdapter> {
    protected ListAdapter FP;
    private Drawable RZ = null;
    private int Sa = 0;
    private Rect fD = new Rect();
    private GestureDetector jwN;
    private OnClickListener mOnClickListener;
    protected int ygC;
    protected int ygD;
    private int ygE = Integer.MAX_VALUE;
    private int ygF;
    private boolean ygK = false;
    protected Scroller ygO = new Scroller(getContext());
    private final a ygP = new a();
    private List<Queue<View>> ygQ = new ArrayList();
    private View ygR = null;
    private Integer ygS = null;
    private int ygT;
    private int ygU;
    private int ygV;
    private e ygW = null;
    private int ygX = 0;
    private boolean ygY = false;
    public d ygZ = null;
    private int yha = a.yhj;
    private i yhb;
    private i yhc;
    private int yhd;
    private boolean yhe = false;
    private boolean yhf = false;
    private DataSetObserver yhg = new DataSetObserver() {
        public final void onChanged() {
            HorizontalListViewV2.this.ygK = true;
            HorizontalListViewV2.this.ygY = false;
            HorizontalListViewV2.this.cpD();
            HorizontalListViewV2.this.invalidate();
            HorizontalListViewV2.this.requestLayout();
        }

        public final void onInvalidated() {
            HorizontalListViewV2.this.ygY = false;
            HorizontalListViewV2.this.cpD();
            HorizontalListViewV2.this.reset();
            HorizontalListViewV2.this.invalidate();
            HorizontalListViewV2.this.requestLayout();
        }
    };
    private Runnable yhh = new Runnable() {
        public final void run() {
            HorizontalListViewV2.this.requestLayout();
        }
    };

    @TargetApi(11)
    private static final class b {
        static {
            if (VERSION.SDK_INT < 11) {
                throw new RuntimeException("sdk is >= 11!");
            }
        }

        public static void a(Scroller scroller) {
            if (scroller != null) {
                scroller.setFriction(0.009f);
            }
        }
    }

    public interface d {

        public enum a {
            ;

            static {
                yhj = 1;
                yhk = 2;
                yhl = 3;
                yhm = new int[]{yhj, yhk, yhl};
            }
        }

        void sm(int i);
    }

    private class a extends SimpleOnGestureListener {
        private a() {
        }

        /* synthetic */ a(HorizontalListViewV2 horizontalListViewV2, byte b) {
            this();
        }

        public final boolean onDown(MotionEvent motionEvent) {
            return HorizontalListViewV2.this.onDown(motionEvent);
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return HorizontalListViewV2.this.aD(f);
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            HorizontalListViewV2.this.h(Boolean.valueOf(true));
            HorizontalListViewV2.this.EM(a.yhk);
            HorizontalListViewV2.this.cpD();
            HorizontalListViewV2 horizontalListViewV2 = HorizontalListViewV2.this;
            horizontalListViewV2.ygD += (int) f;
            HorizontalListViewV2.b(HorizontalListViewV2.this, Math.round(f));
            HorizontalListViewV2.this.requestLayout();
            return true;
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            HorizontalListViewV2.this.cpD();
            OnItemClickListener onItemClickListener = HorizontalListViewV2.this.getOnItemClickListener();
            int a = HorizontalListViewV2.this.eR((int) motionEvent.getX(), (int) motionEvent.getY());
            if (a >= 0 && !HorizontalListViewV2.this.yhe) {
                View childAt = HorizontalListViewV2.this.getChildAt(a);
                int g = HorizontalListViewV2.this.ygT + a;
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(HorizontalListViewV2.this, childAt, g, HorizontalListViewV2.this.FP.getItemId(g));
                    return true;
                }
            }
            if (!(HorizontalListViewV2.this.mOnClickListener == null || HorizontalListViewV2.this.yhe)) {
                HorizontalListViewV2.this.mOnClickListener.onClick(HorizontalListViewV2.this);
            }
            return false;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            HorizontalListViewV2.this.cpD();
            int a = HorizontalListViewV2.this.eR((int) motionEvent.getX(), (int) motionEvent.getY());
            if (a >= 0 && !HorizontalListViewV2.this.yhe) {
                View childAt = HorizontalListViewV2.this.getChildAt(a);
                OnItemLongClickListener onItemLongClickListener = HorizontalListViewV2.this.getOnItemLongClickListener();
                if (onItemLongClickListener != null) {
                    int g = HorizontalListViewV2.this.ygT + a;
                    if (onItemLongClickListener.onItemLongClick(HorizontalListViewV2.this, childAt, g, HorizontalListViewV2.this.FP.getItemId(g))) {
                        HorizontalListViewV2.this.performHapticFeedback(0);
                    }
                }
            }
        }
    }

    @TargetApi(14)
    private static final class c {
        static {
            if (VERSION.SDK_INT < 14) {
                throw new RuntimeException("sdk is >= 14!");
            }
        }

        public static float b(Scroller scroller) {
            return scroller.getCurrVelocity();
        }
    }

    public interface e {
    }

    static /* synthetic */ void b(HorizontalListViewV2 horizontalListViewV2, int i) {
        if (horizontalListViewV2.yhb != null && horizontalListViewV2.yhc != null) {
            int i2 = horizontalListViewV2.ygC + i;
            if (horizontalListViewV2.ygO != null && !horizontalListViewV2.ygO.isFinished()) {
                return;
            }
            if (i2 < 0) {
                horizontalListViewV2.yhb.x(((float) Math.abs(i)) / ((float) horizontalListViewV2.cpC()));
                if (!horizontalListViewV2.yhc.isFinished()) {
                    horizontalListViewV2.yhc.cw();
                }
            } else if (i2 > horizontalListViewV2.ygE) {
                horizontalListViewV2.yhc.x(((float) Math.abs(i)) / ((float) horizontalListViewV2.cpC()));
                if (!horizontalListViewV2.yhb.isFinished()) {
                    horizontalListViewV2.yhb.cw();
                }
            }
        }
    }

    public /* bridge */ /* synthetic */ Adapter getAdapter() {
        return this.FP;
    }

    public HorizontalListViewV2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yhb = new i(context);
        this.yhc = new i(context);
        this.jwN = new GestureDetector(context, this.ygP);
        setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return HorizontalListViewV2.this.jwN.onTouchEvent(motionEvent);
            }
        });
        initView();
        setWillNotDraw(false);
        if (VERSION.SDK_INT >= 11) {
            b.a(this.ygO);
        }
    }

    private void h(Boolean bool) {
        if (this.yhf != bool.booleanValue()) {
            View view = this;
            while (view.getParent() instanceof View) {
                if ((view.getParent() instanceof ListView) || (view.getParent() instanceof ScrollView)) {
                    view.getParent().requestDisallowInterceptTouchEvent(bool.booleanValue());
                    this.yhf = bool.booleanValue();
                    return;
                }
                view = (View) view.getParent();
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
        bundle.putInt("BUNDLE_ID_CURRENT_X", this.ygC);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.ygS = Integer.valueOf(bundle.getInt("BUNDLE_ID_CURRENT_X"));
            super.onRestoreInstanceState(bundle.getParcelable("BUNDLE_ID_PARENT_STATE"));
        }
    }

    private void initView() {
        this.ygT = -1;
        this.ygU = -1;
        this.ygF = 0;
        this.ygC = 0;
        this.ygD = 0;
        this.ygE = Integer.MAX_VALUE;
        EM(a.yhj);
    }

    private void reset() {
        initView();
        removeAllViewsInLayout();
        requestLayout();
    }

    public void setSelection(int i) {
        this.ygV = i;
    }

    public View getSelectedView() {
        int i = this.ygV;
        return (i < this.ygT || i > this.ygU) ? null : getChildAt(i - this.ygT);
    }

    public final void setAdapter(ListAdapter listAdapter) {
        int i = 0;
        if (this.FP != null) {
            this.FP.unregisterDataSetObserver(this.yhg);
        }
        if (listAdapter != null) {
            this.ygY = false;
            this.FP = listAdapter;
            this.FP.registerDataSetObserver(this.yhg);
        }
        if (this.FP != null) {
            int viewTypeCount = this.FP.getViewTypeCount();
            this.ygQ.clear();
            while (i < viewTypeCount) {
                this.ygQ.add(new LinkedList());
                i++;
            }
        }
        reset();
    }

    private View EI(int i) {
        int itemViewType = this.FP.getItemViewType(i);
        if (EJ(itemViewType)) {
            return (View) ((Queue) this.ygQ.get(itemViewType)).poll();
        }
        return null;
    }

    private void j(int i, View view) {
        int itemViewType = this.FP.getItemViewType(i);
        if (EJ(itemViewType)) {
            ((Queue) this.ygQ.get(itemViewType)).offer(view);
        }
    }

    private boolean EJ(int i) {
        return i < this.ygQ.size();
    }

    private void I(View view, int i) {
        addViewInLayout(view, i, dj(view), true);
        LayoutParams dj = dj(view);
        view.measure(dj.width > 0 ? MeasureSpec.makeMeasureSpec(dj.width, 1073741824) : MeasureSpec.makeMeasureSpec(0, 0), ViewGroup.getChildMeasureSpec(this.yhd, getPaddingTop() + getPaddingBottom(), dj.height));
    }

    private static LayoutParams dj(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return new LayoutParams(-2, -1);
        }
        return layoutParams;
    }

    @SuppressLint({"WrongCall"})
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2 = false;
        super.onLayout(z, i, i2, i3, i4);
        if (this.FP != null) {
            int i5;
            int i6;
            View cpB;
            View view;
            int i7;
            invalidate();
            if (this.ygK) {
                i5 = this.ygC;
                initView();
                removeAllViewsInLayout();
                this.ygD = i5;
                this.ygK = false;
            }
            if (this.ygS != null) {
                this.ygD = this.ygS.intValue();
                this.ygS = null;
            }
            if (this.ygO.computeScrollOffset()) {
                this.ygD = this.ygO.getCurrX();
            }
            if (this.ygD < 0) {
                this.ygD = 0;
                if (this.yhb.isFinished()) {
                    this.yhb.ap((int) cpA());
                }
                this.ygO.forceFinished(true);
                EM(a.yhj);
            } else if (this.ygD > this.ygE) {
                this.ygD = this.ygE;
                if (this.yhc.isFinished()) {
                    this.yhc.ap((int) cpA());
                }
                this.ygO.forceFinished(true);
                EM(a.yhj);
            }
            int i8 = this.ygC - this.ygD;
            View childAt = getChildAt(0);
            while (childAt != null && childAt.getRight() + i8 <= 0) {
                i6 = this.ygF;
                if (EK(this.ygT)) {
                    i5 = childAt.getMeasuredWidth();
                } else {
                    i5 = this.Sa + childAt.getMeasuredWidth();
                }
                this.ygF = i5 + i6;
                j(this.ygT, childAt);
                removeViewInLayout(childAt);
                this.ygT++;
                childAt = getChildAt(0);
            }
            while (true) {
                cpB = cpB();
                if (cpB == null || cpB.getLeft() + i8 < getWidth()) {
                    cpB = cpB();
                } else {
                    j(this.ygU, cpB);
                    removeViewInLayout(cpB);
                    this.ygU--;
                }
            }
            cpB = cpB();
            i5 = cpB != null ? cpB.getRight() : 0;
            while ((i5 + i8) + this.Sa < getWidth() && this.ygU + 1 < this.FP.getCount()) {
                this.ygU++;
                if (this.ygT < 0) {
                    this.ygT = this.ygU;
                }
                view = this.FP.getView(this.ygU, EI(this.ygU), this);
                I(view, -1);
                i5 += (this.ygU == 0 ? 0 : this.Sa) + view.getMeasuredWidth();
                if (!(this.ygW == null || this.FP == null || this.FP.getCount() - (this.ygU + 1) >= this.ygX || this.ygY)) {
                    this.ygY = true;
                }
            }
            cpB = getChildAt(0);
            i5 = cpB != null ? cpB.getLeft() : 0;
            while ((i5 + i8) - this.Sa > 0 && this.ygT > 0) {
                this.ygT--;
                view = this.FP.getView(this.ygT, EI(this.ygT), this);
                I(view, 0);
                i5 -= this.ygT == 0 ? view.getMeasuredWidth() : this.Sa + view.getMeasuredWidth();
                this.ygF -= i5 + i8 == 0 ? view.getMeasuredWidth() : this.Sa + view.getMeasuredWidth();
            }
            i6 = getChildCount();
            if (i6 > 0) {
                this.ygF += i8;
                i7 = this.ygF;
                for (i5 = 0; i5 < i6; i5++) {
                    View childAt2 = getChildAt(i5);
                    int paddingLeft = getPaddingLeft() + i7;
                    int paddingTop = getPaddingTop();
                    childAt2.layout(paddingLeft, paddingTop, childAt2.getMeasuredWidth() + paddingLeft, childAt2.getMeasuredHeight() + paddingTop);
                    i7 += childAt2.getMeasuredWidth() + this.Sa;
                }
            }
            this.ygC = this.ygD;
            if (EK(this.ygU)) {
                cpB = cpB();
                if (cpB != null) {
                    i7 = this.ygE;
                    this.ygE = ((cpB.getRight() - getPaddingLeft()) + this.ygC) - cpC();
                    if (this.ygE < 0) {
                        this.ygE = 0;
                    }
                    if (this.ygE != i7) {
                        z2 = true;
                    }
                }
            }
            if (z2) {
                onLayout(z, i, i2, i3, i4);
            } else if (!this.ygO.isFinished()) {
                z.a((View) this, this.yhh);
            } else if (this.yha == a.yhl) {
                EM(a.yhj);
            }
        }
    }

    protected float getLeftFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (this.ygC == 0) {
            return 0.0f;
        }
        if (this.ygC < horizontalFadingEdgeLength) {
            return ((float) this.ygC) / ((float) horizontalFadingEdgeLength);
        }
        return 1.0f;
    }

    protected float getRightFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (this.ygC == this.ygE) {
            return 0.0f;
        }
        if (this.ygE - this.ygC < horizontalFadingEdgeLength) {
            return ((float) (this.ygE - this.ygC)) / ((float) horizontalFadingEdgeLength);
        }
        return 1.0f;
    }

    private float cpA() {
        if (VERSION.SDK_INT >= 14) {
            return c.b(this.ygO);
        }
        return 30.0f;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.yhd = i2;
    }

    private View cpB() {
        return getChildAt(getChildCount() - 1);
    }

    private int eR(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).getHitRect(this.fD);
            if (this.fD.contains(i, i2)) {
                return i3;
            }
        }
        return -1;
    }

    private boolean EK(int i) {
        return i == this.FP.getCount() + -1;
    }

    private int cpC() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public final void EL(int i) {
        this.ygO.startScroll(this.ygD, 0, i - this.ygD, 0);
        EM(a.yhl);
        requestLayout();
    }

    public int getFirstVisiblePosition() {
        return this.ygT;
    }

    public int getLastVisiblePosition() {
        return this.ygU;
    }

    private void a(Canvas canvas, Rect rect) {
        if (this.RZ != null) {
            this.RZ.setBounds(rect);
            this.RZ.draw(canvas);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int childCount = getChildCount();
        Rect rect = this.fD;
        this.fD.top = getPaddingTop();
        this.fD.bottom = this.fD.top + ((getHeight() - getPaddingTop()) - getPaddingBottom());
        for (int i = 0; i < childCount; i++) {
            if (i != childCount - 1 || !EK(this.ygU)) {
                View childAt = getChildAt(i);
                rect.left = childAt.getRight();
                rect.right = childAt.getRight() + this.Sa;
                if (rect.left < getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                }
                if (rect.right > getWidth() - getPaddingRight()) {
                    rect.right = getWidth() - getPaddingRight();
                }
                a(canvas, rect);
                if (i == 0 && childAt.getLeft() > getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                    rect.right = childAt.getLeft();
                    a(canvas, rect);
                }
            }
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    protected void dispatchSetPressed(boolean z) {
    }

    protected final boolean aD(float f) {
        this.ygO.fling(this.ygD, 0, (int) (-f), 0, 0, this.ygE, 0, 0);
        EM(a.yhl);
        requestLayout();
        return true;
    }

    protected final boolean onDown(MotionEvent motionEvent) {
        this.yhe = !this.ygO.isFinished();
        this.ygO.forceFinished(true);
        EM(a.yhj);
        cpD();
        if (!this.yhe) {
            int eR = eR((int) motionEvent.getX(), (int) motionEvent.getY());
            if (eR >= 0) {
                this.ygR = getChildAt(eR);
                if (this.ygR != null) {
                    this.ygR.setPressed(true);
                    refreshDrawableState();
                }
            }
        }
        return true;
    }

    private void cpD() {
        if (this.ygR != null) {
            this.ygR.setPressed(false);
            refreshDrawableState();
            this.ygR = null;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.ygO == null || this.ygO.isFinished()) {
                EM(a.yhj);
            }
            h(Boolean.valueOf(false));
            cpE();
        } else if (motionEvent.getAction() == 3) {
            cpD();
            cpE();
            h(Boolean.valueOf(false));
        }
        return super.onTouchEvent(motionEvent);
    }

    private void cpE() {
        if (this.yhb != null) {
            this.yhb.cw();
        }
        if (this.yhc != null) {
            this.yhc.cw();
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    private void EM(int i) {
        if (!(this.yha == i || this.ygZ == null)) {
            this.ygZ.sm(i);
        }
        this.yha = i;
    }
}
