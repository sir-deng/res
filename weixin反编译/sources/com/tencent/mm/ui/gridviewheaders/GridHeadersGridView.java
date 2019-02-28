package com.tencent.mm.ui.gridviewheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.ArrayList;
import java.util.List;

public class GridHeadersGridView extends GridView implements OnScrollListener, OnItemClickListener, OnItemLongClickListener, OnItemSelectedListener {
    private DataSetObserver BD;
    private OnItemSelectedListener Gu;
    private OnItemClickListener XC;
    protected int YQ;
    private int iN;
    private ag mHandler;
    private int mNumColumns;
    private OnScrollListener rXo;
    protected boolean ygK;
    private int ygr;
    private int ygs;
    private int yi;
    private Runnable ylT;
    private OnItemLongClickListener ysH;
    public a znP;
    public b znQ;
    private boolean znR;
    private final Rect znS;
    private boolean znT;
    private boolean znU;
    private int znV;
    private long znW;
    private int znX;
    private float znY;
    private boolean znZ;
    private int zoa;
    public c zob;
    d zoc;
    private e zod;
    private View zoe;
    protected c zof;
    protected int zog;
    private boolean zoh;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (byte) 0);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean zom;

        /* synthetic */ SavedState(Parcel parcel, byte b) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.zom = parcel.readByte() != (byte) 0;
        }

        public String toString() {
            return "StickyGridHeadersGridView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " areHeadersSticky=" + this.zom + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte((byte) (this.zom ? 1 : 0));
        }
    }

    private class f {
        private int ylY;

        private f() {
        }

        /* synthetic */ f(GridHeadersGridView gridHeadersGridView, byte b) {
            this();
        }

        public final void cyh() {
            this.ylY = GridHeadersGridView.this.getWindowAttachCount();
        }

        public final boolean cyi() {
            return GridHeadersGridView.this.hasWindowFocus() && GridHeadersGridView.this.getWindowAttachCount() == this.ylY;
        }
    }

    private class a extends f implements Runnable {
        private a() {
            super(GridHeadersGridView.this, (byte) 0);
        }

        /* synthetic */ a(GridHeadersGridView gridHeadersGridView, byte b) {
            this();
        }

        public final void run() {
            View GW = GridHeadersGridView.this.GW(GridHeadersGridView.this.zog);
            if (GW != null) {
                boolean z;
                GridHeadersGridView.a(GridHeadersGridView.this, GridHeadersGridView.this.zog);
                if (!cyi() || GridHeadersGridView.this.ygK) {
                    z = false;
                } else {
                    GridHeadersGridView gridHeadersGridView = GridHeadersGridView.this;
                    if (gridHeadersGridView.zoc != null) {
                        z = gridHeadersGridView.zoc.cyg();
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (GW != null) {
                            GW.sendAccessibilityEvent(2);
                        }
                        gridHeadersGridView.performHapticFeedback(0);
                    }
                }
                if (z) {
                    GridHeadersGridView.this.YQ = -2;
                    GridHeadersGridView.this.setPressed(false);
                    GW.setPressed(false);
                    return;
                }
                GridHeadersGridView.this.YQ = 2;
            }
        }
    }

    public interface c {
        void cl(View view);
    }

    public interface d {
        boolean cyg();
    }

    final class b implements Runnable {
        b() {
        }

        public final void run() {
            if (GridHeadersGridView.this.YQ == 0) {
                GridHeadersGridView.this.YQ = 1;
                View GW = GridHeadersGridView.this.GW(GridHeadersGridView.this.zog);
                if (GW != null && !GW.hasFocusable()) {
                    if (GridHeadersGridView.this.ygK) {
                        GridHeadersGridView.this.YQ = 2;
                        return;
                    }
                    GW.setPressed(true);
                    GridHeadersGridView.this.setPressed(true);
                    GridHeadersGridView.this.refreshDrawableState();
                    int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    if (GridHeadersGridView.this.isLongClickable()) {
                        if (GridHeadersGridView.this.znP == null) {
                            GridHeadersGridView.this.znP = new a(GridHeadersGridView.this, (byte) 0);
                        }
                        GridHeadersGridView.this.znP.cyh();
                        GridHeadersGridView.this.mHandler.postDelayed(GridHeadersGridView.this.znP, (long) longPressTimeout);
                        return;
                    }
                    GridHeadersGridView.this.YQ = 2;
                }
            }
        }
    }

    private class e extends f implements Runnable {
        int zol;

        private e() {
            super(GridHeadersGridView.this, (byte) 0);
        }

        /* synthetic */ e(GridHeadersGridView gridHeadersGridView, byte b) {
            this();
        }

        public final void run() {
            if (!GridHeadersGridView.this.ygK && GridHeadersGridView.this.zof != null && GridHeadersGridView.this.zof.getCount() > 0 && this.zol != -1 && this.zol < GridHeadersGridView.this.zof.getCount() && cyi()) {
                View GW = GridHeadersGridView.this.GW(this.zol);
                if (GW != null) {
                    GridHeadersGridView gridHeadersGridView = GridHeadersGridView.this;
                    GridHeadersGridView.a(GridHeadersGridView.this, this.zol);
                    if (gridHeadersGridView.zob != null) {
                        gridHeadersGridView.playSoundEffect(0);
                        if (GW != null) {
                            GW.sendAccessibilityEvent(1);
                        }
                        gridHeadersGridView.zob.cl(GW);
                    }
                }
            }
        }
    }

    static /* synthetic */ long a(GridHeadersGridView gridHeadersGridView, int i) {
        return i == -2 ? gridHeadersGridView.znW : gridHeadersGridView.zof.oE(gridHeadersGridView.getFirstVisiblePosition() + i);
    }

    public GridHeadersGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842865);
    }

    public GridHeadersGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new ag();
        this.znR = true;
        this.znS = new Rect();
        this.znW = -1;
        this.BD = new DataSetObserver() {
            public final void onChanged() {
                GridHeadersGridView.this.reset();
            }

            public final void onInvalidated() {
                GridHeadersGridView.this.reset();
            }
        };
        this.zoa = 1;
        this.yi = 0;
        this.zoh = true;
        super.setOnScrollListener(this);
        setVerticalFadingEdgeEnabled(false);
        if (!this.znZ) {
            this.mNumColumns = -1;
        }
        this.iN = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public final View GW(int i) {
        if (i == -2) {
            return this.zoe;
        }
        try {
            return (View) getChildAt(i).getTag();
        } catch (Exception e) {
            return null;
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.XC.onItemClick(adapterView, view, this.zof.GV(i).mPosition, j);
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return this.ysH.onItemLongClick(adapterView, view, this.zof.GV(i).mPosition, j);
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.Gu.onItemSelected(adapterView, view, this.zof.GV(i).mPosition, j);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
        this.Gu.onNothingSelected(adapterView);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.znR = savedState.zom;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.zom = this.znR;
        return savedState;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.rXo != null) {
            this.rXo.onScroll(absListView, i, i2, i3);
        }
        if (VERSION.SDK_INT >= 8) {
            GX(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.rXo != null) {
            this.rXo.onScrollStateChanged(absListView, i);
        }
        this.yi = i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r11) {
        /*
        r10 = this;
        r1 = -2;
        r4 = 1;
        r2 = 0;
        r3 = -1;
        r0 = r11.getAction();
        r0 = r0 & 255;
        switch(r0) {
            case 0: goto L_0x0011;
            case 1: goto L_0x00b4;
            case 2: goto L_0x0082;
            default: goto L_0x000d;
        };
    L_0x000d:
        r0 = r2;
    L_0x000e:
        if (r0 == 0) goto L_0x013a;
    L_0x0010:
        return r2;
    L_0x0011:
        r0 = r10.znQ;
        if (r0 != 0) goto L_0x001c;
    L_0x0015:
        r0 = new com.tencent.mm.ui.gridviewheaders.GridHeadersGridView$b;
        r0.<init>();
        r10.znQ = r0;
    L_0x001c:
        r0 = r10.mHandler;
        r4 = r10.znP;
        r5 = android.view.ViewConfiguration.getTapTimeout();
        r6 = (long) r5;
        r0.postDelayed(r4, r6);
        r0 = r11.getY();
        r0 = (int) r0;
        r4 = (float) r0;
        r10.znY = r4;
        r4 = (float) r0;
        r0 = r10.zoe;
        if (r0 == 0) goto L_0x004e;
    L_0x0035:
        r0 = r10.zoe;
        r0 = r0.getBottom();
        r0 = (float) r0;
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 > 0) goto L_0x004e;
    L_0x0040:
        r10.zog = r1;
        r0 = r10.zog;
        if (r0 == r3) goto L_0x000d;
    L_0x0046:
        r0 = r10.yi;
        r1 = 2;
        if (r0 == r1) goto L_0x000d;
    L_0x004b:
        r10.YQ = r2;
        goto L_0x000d;
    L_0x004e:
        r0 = r10.getFirstVisiblePosition();
        r1 = r2;
    L_0x0053:
        r5 = r10.getLastVisiblePosition();
        if (r0 > r5) goto L_0x0080;
    L_0x0059:
        r6 = r10.getItemIdAtPosition(r0);
        r8 = -1;
        r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r5 != 0) goto L_0x0079;
    L_0x0063:
        r5 = r10.getChildAt(r1);
        r6 = r5.getBottom();
        r5 = r5.getTop();
        r6 = (float) r6;
        r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r6 > 0) goto L_0x0079;
    L_0x0074:
        r5 = (float) r5;
        r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1));
        if (r5 >= 0) goto L_0x0040;
    L_0x0079:
        r5 = r10.zoa;
        r0 = r0 + r5;
        r5 = r10.zoa;
        r1 = r1 + r5;
        goto L_0x0053;
    L_0x0080:
        r1 = r3;
        goto L_0x0040;
    L_0x0082:
        r0 = r10.zog;
        if (r0 == r3) goto L_0x000d;
    L_0x0086:
        r0 = r11.getY();
        r1 = r10.znY;
        r0 = r0 - r1;
        r0 = java.lang.Math.abs(r0);
        r1 = r10.iN;
        r1 = (float) r1;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 <= 0) goto L_0x000d;
    L_0x0098:
        r10.YQ = r3;
        r0 = r10.zog;
        r0 = r10.GW(r0);
        if (r0 == 0) goto L_0x00a5;
    L_0x00a2:
        r0.setPressed(r2);
    L_0x00a5:
        r0 = r10.znP;
        if (r0 == 0) goto L_0x00b0;
    L_0x00a9:
        r0 = r10.mHandler;
        r1 = r10.znP;
        r0.removeCallbacks(r1);
    L_0x00b0:
        r10.zog = r3;
        goto L_0x000d;
    L_0x00b4:
        r0 = r10.YQ;
        if (r0 == r1) goto L_0x000d;
    L_0x00b8:
        r0 = r10.YQ;
        if (r0 == r3) goto L_0x000d;
    L_0x00bc:
        r0 = r10.zog;
        if (r0 == r3) goto L_0x000d;
    L_0x00c0:
        r0 = r10.zog;
        r1 = r10.GW(r0);
        if (r1 == 0) goto L_0x012c;
    L_0x00c8:
        r0 = r1.hasFocusable();
        if (r0 != 0) goto L_0x012c;
    L_0x00ce:
        r0 = r10.YQ;
        if (r0 == 0) goto L_0x00d5;
    L_0x00d2:
        r1.setPressed(r2);
    L_0x00d5:
        r0 = r10.zod;
        if (r0 != 0) goto L_0x00e0;
    L_0x00d9:
        r0 = new com.tencent.mm.ui.gridviewheaders.GridHeadersGridView$e;
        r0.<init>(r10, r2);
        r10.zod = r0;
    L_0x00e0:
        r5 = r10.zod;
        r0 = r10.zog;
        r5.zol = r0;
        r5.cyh();
        r0 = r10.YQ;
        if (r0 != 0) goto L_0x00f1;
    L_0x00ed:
        r0 = r10.YQ;
        if (r0 == r4) goto L_0x0130;
    L_0x00f1:
        r6 = r10.mHandler;
        r0 = r10.YQ;
        if (r0 != 0) goto L_0x0127;
    L_0x00f7:
        r0 = r10.znQ;
    L_0x00f9:
        r6.removeCallbacks(r0);
        r0 = r10.ygK;
        if (r0 != 0) goto L_0x012a;
    L_0x0100:
        r10.YQ = r4;
        r1.setPressed(r4);
        r10.setPressed(r4);
        r0 = r10.ylT;
        if (r0 == 0) goto L_0x0111;
    L_0x010c:
        r0 = r10.ylT;
        r10.removeCallbacks(r0);
    L_0x0111:
        r0 = new com.tencent.mm.ui.gridviewheaders.GridHeadersGridView$2;
        r0.<init>(r1, r5);
        r10.ylT = r0;
        r0 = r10.mHandler;
        r1 = r10.ylT;
        r3 = android.view.ViewConfiguration.getPressedStateDuration();
        r6 = (long) r3;
        r0.postDelayed(r1, r6);
        r0 = r4;
        goto L_0x000e;
    L_0x0127:
        r0 = r10.znP;
        goto L_0x00f9;
    L_0x012a:
        r10.YQ = r3;
    L_0x012c:
        r10.YQ = r3;
        goto L_0x000d;
    L_0x0130:
        r0 = r10.ygK;
        if (r0 != 0) goto L_0x012c;
    L_0x0134:
        r5.run();
        r0 = r4;
        goto L_0x000e;
    L_0x013a:
        r2 = super.dispatchTouchEvent(r11);
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAdapter(ListAdapter listAdapter) {
        b bVar;
        if (!(this.zof == null || this.BD == null)) {
            this.zof.unregisterDataSetObserver(this.BD);
        }
        if (!this.znU) {
            this.znT = true;
        }
        Object bVar2;
        if (listAdapter instanceof b) {
            bVar2 = (b) listAdapter;
        } else if (listAdapter instanceof e) {
            bVar2 = new f((e) listAdapter);
        } else {
            bVar2 = new d(listAdapter);
        }
        this.zof = new c(getContext(), this, bVar2);
        this.zof.registerDataSetObserver(this.BD);
        reset();
        super.setAdapter(this.zof);
    }

    public void setClipToPadding(boolean z) {
        super.setClipToPadding(z);
        this.znT = z;
        this.znU = true;
    }

    public void setColumnWidth(int i) {
        super.setColumnWidth(i);
        this.znV = i;
    }

    public void setHorizontalSpacing(int i) {
        super.setHorizontalSpacing(i);
        this.ygr = i;
    }

    public void setNumColumns(int i) {
        super.setNumColumns(i);
        this.znZ = true;
        this.mNumColumns = i;
        if (i != -1 && this.zof != null) {
            this.zof.setNumColumns(i);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.XC = onItemClickListener;
        super.setOnItemClickListener(this);
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.ysH = onItemLongClickListener;
        super.setOnItemLongClickListener(this);
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.Gu = onItemSelectedListener;
        super.setOnItemSelectedListener(this);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.rXo = onScrollListener;
    }

    public void setVerticalSpacing(int i) {
        super.setVerticalSpacing(i);
        this.ygs = i;
    }

    private int cye() {
        if (this.zoe != null) {
            return this.zoe.getMeasuredHeight();
        }
        return 0;
    }

    private void cyf() {
        if (this.zoe != null) {
            int makeMeasureSpec;
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec((getWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824);
            LayoutParams layoutParams = this.zoe.getLayoutParams();
            if (layoutParams == null || layoutParams.height <= 0) {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            } else {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            }
            this.zoe.measure(makeMeasureSpec2, makeMeasureSpec);
            this.zoe.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.zoe.getMeasuredHeight());
        }
    }

    private void reset() {
        this.znX = 0;
        this.zoe = null;
        this.znW = Long.MIN_VALUE;
    }

    private void GX(int i) {
        if (this.zof != null && this.zof.getCount() != 0 && this.znR && ((d) getChildAt(0)) != null) {
            int i2;
            long oE;
            int childCount;
            View view;
            int i3;
            View view2;
            View view3;
            int i4 = i - this.zoa;
            if (i4 < 0) {
                i4 = i;
            }
            int i5 = this.zoa + i;
            if (i5 >= this.zof.getCount()) {
                i5 = i;
            }
            if (this.ygs != 0) {
                if (this.ygs < 0) {
                    this.zof.oE(i);
                    if (getChildAt(this.zoa).getTop() <= 0) {
                        i2 = i5;
                        oE = this.zof.oE(i5);
                    } else {
                        oE = this.zof.oE(i);
                        i2 = i;
                    }
                } else {
                    i5 = getChildAt(0).getTop();
                    if (i5 > 0 && i5 < this.ygs) {
                        i2 = i4;
                        oE = this.zof.oE(i4);
                    }
                }
                if (this.znW != oE) {
                    this.zoe = this.zof.a(i2, this.zoe, this);
                    cyf();
                    this.znW = oE;
                }
                childCount = getChildCount();
                if (childCount != 0) {
                    view = null;
                    i2 = 99999;
                    i3 = 0;
                    while (i3 < childCount) {
                        view2 = (d) super.getChildAt(i3);
                        if (this.znT) {
                            i5 = view2.getTop();
                        } else {
                            i5 = view2.getTop() - getPaddingTop();
                        }
                        if (i5 >= 0 || !(view2.getChildAt(0) instanceof b) || i5 >= i2) {
                            i4 = i2;
                            view3 = view;
                        } else {
                            int i6 = i5;
                            view3 = view2;
                            i4 = i6;
                        }
                        i3 = this.zoa + i3;
                        view = view3;
                        i2 = i4;
                    }
                    i4 = cye();
                    if (view != null) {
                        this.znX = i4;
                        if (this.znT) {
                            this.znX += getPaddingTop();
                            return;
                        }
                        return;
                    } else if (i != 0 && super.getChildAt(0).getTop() > 0 && !this.znT) {
                        this.znX = 0;
                        return;
                    } else if (this.znT) {
                        this.znX = Math.min(view.getTop(), i4);
                        if (this.znX >= 0) {
                            i4 = this.znX;
                        }
                        this.znX = i4;
                        return;
                    } else {
                        this.znX = Math.min(view.getTop(), getPaddingTop() + i4);
                        this.znX = this.znX >= getPaddingTop() ? i4 + getPaddingTop() : this.znX;
                    }
                }
            }
            oE = this.zof.oE(i);
            i2 = i;
            if (this.znW != oE) {
                this.zoe = this.zof.a(i2, this.zoe, this);
                cyf();
                this.znW = oE;
            }
            childCount = getChildCount();
            if (childCount != 0) {
                view = null;
                i2 = 99999;
                i3 = 0;
                while (i3 < childCount) {
                    view2 = (d) super.getChildAt(i3);
                    if (this.znT) {
                        i5 = view2.getTop();
                    } else {
                        i5 = view2.getTop() - getPaddingTop();
                    }
                    if (i5 >= 0) {
                    }
                    i4 = i2;
                    view3 = view;
                    i3 = this.zoa + i3;
                    view = view3;
                    i2 = i4;
                }
                i4 = cye();
                if (view != null) {
                    this.znX = i4;
                    if (this.znT) {
                        this.znX += getPaddingTop();
                        return;
                    }
                    return;
                }
                if (i != 0) {
                }
                if (this.znT) {
                    this.znX = Math.min(view.getTop(), i4);
                    if (this.znX >= 0) {
                        i4 = this.znX;
                    }
                    this.znX = i4;
                    return;
                }
                this.znX = Math.min(view.getTop(), getPaddingTop() + i4);
                if (this.znX >= getPaddingTop()) {
                }
                this.znX = this.znX >= getPaddingTop() ? i4 + getPaddingTop() : this.znX;
            }
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        Object obj;
        if (VERSION.SDK_INT < 8) {
            GX(getFirstVisiblePosition());
        }
        if (this.zoe != null && this.znR && this.zoe.getVisibility() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        int cye = cye();
        int i = this.znX - cye;
        if (obj != null && this.zoh) {
            this.znS.left = getPaddingLeft();
            this.znS.right = getWidth() - getPaddingRight();
            this.znS.top = this.znX;
            this.znS.bottom = getHeight();
            canvas.save();
            canvas.clipRect(this.znS);
        }
        super.dispatchDraw(canvas);
        List arrayList = new ArrayList();
        int i2 = 0;
        int firstVisiblePosition = getFirstVisiblePosition();
        while (firstVisiblePosition <= getLastVisiblePosition()) {
            if (getItemIdAtPosition(firstVisiblePosition) == -1) {
                arrayList.add(Integer.valueOf(i2));
            }
            firstVisiblePosition += this.zoa;
            i2 += this.zoa;
        }
        firstVisiblePosition = 0;
        while (true) {
            int i3 = firstVisiblePosition;
            if (i3 < arrayList.size()) {
                d dVar = (d) getChildAt(((Integer) arrayList.get(i3)).intValue());
                try {
                    View view = (View) dVar.getTag();
                    Object obj2 = (((long) ((b) dVar.getChildAt(0)).znL) == this.znW && dVar.getTop() < 0 && this.znR) ? 1 : null;
                    if (view.getVisibility() == 0 && obj2 == null) {
                        view.measure(MeasureSpec.makeMeasureSpec(getWidth(), (1073741824 - getPaddingLeft()) - getPaddingRight()), MeasureSpec.makeMeasureSpec(0, 0));
                        view.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), dVar.getHeight());
                        this.znS.left = getPaddingLeft();
                        this.znS.right = getWidth() - getPaddingRight();
                        this.znS.bottom = dVar.getBottom();
                        this.znS.top = dVar.getTop();
                        canvas.save();
                        canvas.clipRect(this.znS);
                        canvas.translate((float) getPaddingLeft(), (float) dVar.getTop());
                        view.draw(canvas);
                        canvas.restore();
                    }
                    firstVisiblePosition = i3 + 1;
                } catch (Exception e) {
                    return;
                }
            }
            if (obj != null && this.zoh) {
                canvas.restore();
            } else if (obj == null) {
                return;
            }
            if (this.zoe.getWidth() != (getWidth() - getPaddingLeft()) - getPaddingRight()) {
                this.zoe.measure(MeasureSpec.makeMeasureSpec(getWidth(), (1073741824 - getPaddingLeft()) - getPaddingRight()), MeasureSpec.makeMeasureSpec(0, 0));
                this.zoe.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.zoe.getHeight());
            }
            this.znS.left = getPaddingLeft();
            this.znS.right = getWidth() - getPaddingRight();
            this.znS.bottom = i + cye;
            if (this.znT) {
                this.znS.top = getPaddingTop();
            } else {
                this.znS.top = 0;
            }
            canvas.save();
            canvas.clipRect(this.znS);
            canvas.translate((float) getPaddingLeft(), (float) i);
            canvas.saveLayerAlpha(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (int) ((255.0f * ((float) this.znX)) / ((float) cye)), 4);
            this.zoe.draw(canvas);
            canvas.restore();
            canvas.restore();
            return;
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1;
        if (this.mNumColumns == -1) {
            if (this.znV > 0) {
                int max = Math.max((MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight(), 0);
                int i4 = max / this.znV;
                if (i4 > 0) {
                    while (i4 != 1 && (this.znV * i4) + ((i4 - 1) * this.ygr) > max) {
                        i4--;
                    }
                    i3 = i4;
                }
            } else {
                i3 = 2;
            }
            this.zoa = i3;
        } else {
            this.zoa = this.mNumColumns;
        }
        if (this.zof != null) {
            this.zof.setNumColumns(this.zoa);
        }
        cyf();
        super.onMeasure(i, i2);
    }
}
