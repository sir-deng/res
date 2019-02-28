package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DragSortListView extends ListView {
    private int EV = 0;
    private int iNA;
    private int iNz;
    private int jKh;
    private int jKi;
    private int klx;
    private DataSetObserver mObserver;
    private int zAA;
    private int zAB;
    private int zAC;
    private int zAD;
    private b zAE;
    public g zAF;
    public l zAG;
    boolean zAH = true;
    private int zAI = 1;
    private int zAJ;
    private int zAK;
    private int zAL = 0;
    private View[] zAM = new View[1];
    private d zAN;
    private float zAO = 0.33333334f;
    private float zAP = 0.33333334f;
    private int zAQ;
    private int zAR;
    private float zAS;
    private float zAT;
    private float zAU;
    private float zAV;
    private float zAW = 0.5f;
    private c zAX = new c() {
        public final float aG(float f) {
            return DragSortListView.this.zAW * f;
        }
    };
    private int zAY;
    private int zAZ = 0;
    private View zAp;
    private Point zAq = new Point();
    private Point zAr = new Point();
    private int zAs;
    private boolean zAt = false;
    private float zAu = 1.0f;
    private float zAv = 1.0f;
    private int zAw;
    private int zAx;
    private int zAy;
    private boolean zAz = false;
    private boolean zBa = false;
    boolean zBb = false;
    h zBc = null;
    private MotionEvent zBd;
    private int zBe = 0;
    private float zBf = 0.25f;
    private float zBg = 0.0f;
    private a zBh;
    private boolean zBi = false;
    private e zBj;
    private boolean zBk = false;
    private boolean zBl = false;
    private i zBm = new i();
    private k zBn;
    private j zBo;
    private f zBp;
    boolean zBq;
    private float zBr = 0.0f;
    boolean zBs = false;
    private boolean zBt = false;

    private class m implements Runnable {
        boolean Mu;
        private float mAlpha = 0.5f;
        protected long mStartTime;
        private float zBX;
        private float zBY;
        private float zBZ;
        private float zCa;
        private float zCb;

        public m(float f, int i) {
            this.zBX = (float) i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.zCb = f2;
            this.zBY = f2;
            this.zBZ = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.zCa = 1.0f / (1.0f - this.mAlpha);
        }

        public final void start() {
            this.mStartTime = SystemClock.uptimeMillis();
            this.Mu = false;
            onStart();
            DragSortListView.this.post(this);
        }

        public void onStart() {
        }

        public void aH(float f) {
        }

        public void onStop() {
        }

        public void run() {
            if (!this.Mu) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.zBX;
                if (uptimeMillis >= 1.0f) {
                    aH(1.0f);
                    onStop();
                    return;
                }
                if (uptimeMillis < this.mAlpha) {
                    uptimeMillis *= this.zBY * uptimeMillis;
                } else if (uptimeMillis < 1.0f - this.mAlpha) {
                    uptimeMillis = (uptimeMillis * this.zCa) + this.zBZ;
                } else {
                    uptimeMillis = 1.0f - ((uptimeMillis - 1.0f) * (this.zCb * (uptimeMillis - 1.0f)));
                }
                aH(uptimeMillis);
                DragSortListView.this.post(this);
            }
        }
    }

    public interface b {
    }

    private class d implements Runnable {
        private int zBA;
        private float zBB;
        private long zBC;
        int zBD;
        private float zBE;
        boolean zBF = false;
        private boolean zBx;
        private long zBy;
        private long zBz;

        public final void Hn(int i) {
            if (!this.zBF) {
                this.zBx = false;
                this.zBF = true;
                this.zBC = SystemClock.uptimeMillis();
                this.zBy = this.zBC;
                this.zBD = i;
                DragSortListView.this.post(this);
            }
        }

        public final void czA() {
            DragSortListView.this.removeCallbacks(this);
            this.zBF = false;
        }

        public final void run() {
            if (this.zBx) {
                this.zBF = false;
                return;
            }
            View childAt;
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            int lastVisiblePosition = DragSortListView.this.getLastVisiblePosition();
            int count = DragSortListView.this.getCount();
            int paddingTop = DragSortListView.this.getPaddingTop();
            int height = (DragSortListView.this.getHeight() - paddingTop) - DragSortListView.this.getPaddingBottom();
            int min = Math.min(DragSortListView.this.iNA, DragSortListView.this.zAs + DragSortListView.this.zAK);
            int max = Math.max(DragSortListView.this.iNA, DragSortListView.this.zAs - DragSortListView.this.zAK);
            if (this.zBD == 0) {
                childAt = DragSortListView.this.getChildAt(0);
                if (childAt == null) {
                    this.zBF = false;
                    return;
                } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                    this.zBF = false;
                    return;
                } else {
                    this.zBE = DragSortListView.this.zAX.aG((DragSortListView.this.zAT - ((float) max)) / DragSortListView.this.zAU);
                }
            } else {
                View childAt2 = DragSortListView.this.getChildAt(lastVisiblePosition - firstVisiblePosition);
                if (childAt2 == null) {
                    this.zBF = false;
                    return;
                } else if (lastVisiblePosition != count - 1 || childAt2.getBottom() > height + paddingTop) {
                    this.zBE = -DragSortListView.this.zAX.aG((((float) min) - DragSortListView.this.zAS) / DragSortListView.this.zAV);
                } else {
                    this.zBF = false;
                    return;
                }
            }
            this.zBz = SystemClock.uptimeMillis();
            this.zBB = (float) (this.zBz - this.zBy);
            this.zBA = Math.round(this.zBE * this.zBB);
            if (this.zBA >= 0) {
                this.zBA = Math.min(height, this.zBA);
                lastVisiblePosition = firstVisiblePosition;
            } else {
                this.zBA = Math.max(-height, this.zBA);
            }
            childAt = DragSortListView.this.getChildAt(lastVisiblePosition - firstVisiblePosition);
            firstVisiblePosition = childAt.getTop() + this.zBA;
            if (lastVisiblePosition == 0 && firstVisiblePosition > paddingTop) {
                firstVisiblePosition = paddingTop;
            }
            DragSortListView.this.zBk = true;
            DragSortListView.this.setSelectionFromTop(lastVisiblePosition, firstVisiblePosition - paddingTop);
            DragSortListView.this.layoutChildren();
            DragSortListView.this.invalidate();
            DragSortListView.this.zBk = false;
            DragSortListView.this.c(lastVisiblePosition, childAt, false);
            this.zBy = this.zBz;
            DragSortListView.this.post(this);
        }
    }

    private class f extends m {
        private int zBJ;
        private int zBK;
        private float zBL;
        private float zBM;

        public f(int i) {
            super(0.5f, i);
        }

        public final void onStart() {
            this.zBJ = DragSortListView.this.zAw;
            this.zBK = DragSortListView.this.zAA;
            DragSortListView.this.EV = 2;
            this.zBL = (float) (DragSortListView.this.zAq.y - czB());
            this.zBM = (float) (DragSortListView.this.zAq.x - DragSortListView.this.getPaddingLeft());
        }

        private int czB() {
            int j = (DragSortListView.this.zAI + DragSortListView.this.getDividerHeight()) / 2;
            View childAt = DragSortListView.this.getChildAt(this.zBJ - DragSortListView.this.getFirstVisiblePosition());
            if (childAt == null) {
                this.Mu = true;
                return -1;
            } else if (this.zBJ == this.zBK) {
                return childAt.getTop();
            } else {
                if (this.zBJ < this.zBK) {
                    return childAt.getTop() - j;
                }
                return (childAt.getBottom() + j) - DragSortListView.this.zAJ;
            }
        }

        public final void aH(float f) {
            int czB = czB();
            float paddingLeft = (float) (DragSortListView.this.zAq.x - DragSortListView.this.getPaddingLeft());
            float f2 = 1.0f - f;
            if (f2 < Math.abs(((float) (DragSortListView.this.zAq.y - czB)) / this.zBL) || f2 < Math.abs(paddingLeft / this.zBM)) {
                DragSortListView.this.zAq.y = czB + ((int) (this.zBL * f2));
                DragSortListView.this.zAq.x = DragSortListView.this.getPaddingLeft() + ((int) (this.zBM * f2));
                DragSortListView.this.nI(true);
            }
        }

        public final void onStop() {
            DragSortListView.this.czt();
        }
    }

    public interface h {
        View Ho(int i);

        void dN(View view);

        void g(Point point);
    }

    private class k extends m {
        private int liN;
        private int zBK;
        private float zBR;
        private float zBS;
        private float zBT;
        private int zBU = -1;
        private int zBV = -1;
        private int zBW;

        public k(int i) {
            super(0.5f, i);
        }

        public final void onStart() {
            int i = -1;
            this.zBU = -1;
            this.zBV = -1;
            this.liN = DragSortListView.this.zAx;
            this.zBW = DragSortListView.this.zAy;
            this.zBK = DragSortListView.this.zAA;
            DragSortListView.this.EV = 1;
            this.zBR = (float) DragSortListView.this.zAq.x;
            if (DragSortListView.this.zBq) {
                float width = ((float) DragSortListView.this.getWidth()) * 2.0f;
                if (DragSortListView.this.zBr == 0.0f) {
                    DragSortListView dragSortListView = DragSortListView.this;
                    if (this.zBR >= 0.0f) {
                        i = 1;
                    }
                    dragSortListView.zBr = ((float) i) * width;
                    return;
                }
                float f = width * 2.0f;
                if (DragSortListView.this.zBr < 0.0f && DragSortListView.this.zBr > (-f)) {
                    DragSortListView.this.zBr = -f;
                    return;
                } else if (DragSortListView.this.zBr > 0.0f && DragSortListView.this.zBr < f) {
                    DragSortListView.this.zBr = f;
                    return;
                } else {
                    return;
                }
            }
            DragSortListView.this.czz();
        }

        public final void aH(float f) {
            float f2 = 1.0f - f;
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            View childAt = DragSortListView.this.getChildAt(this.liN - firstVisiblePosition);
            if (DragSortListView.this.zBq) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float p = DragSortListView.this.zBr * uptimeMillis;
                    int width = DragSortListView.this.getWidth();
                    DragSortListView.this.zBr = ((((float) (DragSortListView.this.zBr > 0.0f ? 1 : -1)) * uptimeMillis) * ((float) width)) + DragSortListView.this.zBr;
                    this.zBR += p;
                    DragSortListView.this.zAq.x = (int) this.zBR;
                    if (this.zBR < ((float) width) && this.zBR > ((float) (-width))) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        DragSortListView.this.nI(true);
                        return;
                    }
                }
                return;
            }
            if (childAt != null) {
                if (this.zBU == -1) {
                    this.zBU = DragSortListView.this.b(this.liN, childAt, false);
                    this.zBS = (float) (childAt.getHeight() - this.zBU);
                }
                int max = Math.max((int) (this.zBS * f2), 1);
                LayoutParams layoutParams = childAt.getLayoutParams();
                layoutParams.height = max + this.zBU;
                childAt.setLayoutParams(layoutParams);
            }
            if (this.zBW != this.liN) {
                View childAt2 = DragSortListView.this.getChildAt(this.zBW - firstVisiblePosition);
                if (childAt2 != null) {
                    if (this.zBV == -1) {
                        this.zBV = DragSortListView.this.b(this.zBW, childAt2, false);
                        this.zBT = (float) (childAt2.getHeight() - this.zBV);
                    }
                    int max2 = Math.max((int) (this.zBT * f2), 1);
                    LayoutParams layoutParams2 = childAt2.getLayoutParams();
                    layoutParams2.height = max2 + this.zBV;
                    childAt2.setLayoutParams(layoutParams2);
                }
            }
        }

        public final void onStop() {
            DragSortListView.this.Hl(DragSortListView.this.zAA - DragSortListView.this.getHeaderViewsCount());
        }
    }

    private class a extends BaseAdapter {
        private ListAdapter FP;

        public a(ListAdapter listAdapter) {
            this.FP = listAdapter;
            this.FP.registerDataSetObserver(new DataSetObserver(DragSortListView.this) {
                public final void onChanged() {
                    a.this.notifyDataSetChanged();
                }

                public final void onInvalidated() {
                    a.this.notifyDataSetInvalidated();
                }
            });
        }

        public final long getItemId(int i) {
            return this.FP.getItemId(i);
        }

        public final Object getItem(int i) {
            return this.FP.getItem(i);
        }

        public final int getCount() {
            return this.FP.getCount();
        }

        public final boolean areAllItemsEnabled() {
            return this.FP.areAllItemsEnabled();
        }

        public final boolean isEnabled(int i) {
            return this.FP.isEnabled(i);
        }

        public final int getItemViewType(int i) {
            return this.FP.getItemViewType(i);
        }

        public final int getViewTypeCount() {
            return this.FP.getViewTypeCount();
        }

        public final boolean hasStableIds() {
            return this.FP.hasStableIds();
        }

        public final boolean isEmpty() {
            return this.FP.isEmpty();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View childAt;
            View view2;
            if (view != null) {
                view = (c) view;
                childAt = view.getChildAt(0);
                view2 = this.FP.getView(i, childAt, DragSortListView.this);
                if (view2 != childAt) {
                    if (childAt != null) {
                        view.removeViewAt(0);
                    }
                    view.addView(view2);
                }
            } else {
                view2 = this.FP.getView(i, null, DragSortListView.this);
                if (view2 instanceof Checkable) {
                    childAt = new d(DragSortListView.this.getContext());
                } else {
                    childAt = new c(DragSortListView.this.getContext());
                }
                childAt.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                childAt.addView(view2);
                view = childAt;
            }
            DragSortListView.this.a(DragSortListView.this.getHeaderViewsCount() + i, view, true);
            return view;
        }
    }

    private class e {
        File iHM = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
        StringBuilder mBuilder = new StringBuilder();
        int zBG = 0;
        int zBH = 0;
        boolean zBI = false;

        public e() {
            if (!this.iHM.exists()) {
                try {
                    this.iHM.createNewFile();
                    x.d("mobeta", "file created");
                } catch (IOException e) {
                    x.w("mobeta", "Could not create dslv_state.txt");
                    x.d("mobeta", e.getMessage());
                }
            }
        }

        public final void flush() {
            Throwable th;
            if (this.zBI) {
                FileWriter fileWriter = null;
                boolean z = true;
                FileWriter fileWriter2;
                try {
                    if (this.zBH == 0) {
                        z = false;
                    }
                    fileWriter2 = new FileWriter(this.iHM, z);
                    try {
                        fileWriter2.write(this.mBuilder.toString());
                        this.mBuilder.delete(0, this.mBuilder.length());
                        fileWriter2.flush();
                        this.zBH++;
                        try {
                            fileWriter2.close();
                        } catch (IOException e) {
                        }
                    } catch (IOException e2) {
                        if (fileWriter2 != null) {
                            try {
                                fileWriter2.close();
                            } catch (IOException e3) {
                            }
                        }
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        fileWriter = fileWriter2;
                        th = th3;
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (IOException e4) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException e5) {
                    fileWriter2 = null;
                    if (fileWriter2 != null) {
                        fileWriter2.close();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                    throw th;
                }
            }
        }
    }

    public interface g {
        void cu(int i, int i2);
    }

    private class i {
        int xru = 3;
        SparseIntArray zBN = new SparseIntArray(3);
        ArrayList<Integer> zBO = new ArrayList(3);
    }

    public interface c {
        float aG(float f);
    }

    private class j extends m {
        private float zBP;
        private float zBQ;
        final /* synthetic */ DragSortListView zBu;

        public final void onStart() {
            this.zBP = (float) this.zBu.zAC;
            this.zBQ = (float) this.zBu.zAK;
        }

        public final void aH(float f) {
            if (this.zBu.EV != 4) {
                this.Mu = true;
                return;
            }
            this.zBu.zAC = (int) ((this.zBQ * f) + ((1.0f - f) * this.zBP));
            this.zBu.zAq.y = this.zBu.iNA - this.zBu.zAC;
            this.zBu.nI(true);
        }
    }

    public interface l {
        void remove(int i);
    }

    public DragSortListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i = 150;
        int i2 = 150;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.tencent.mm.ca.a.j.fas, 0, 0);
            this.zAI = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(com.tencent.mm.ca.a.j.zJn, 1));
            this.zBi = obtainStyledAttributes.getBoolean(com.tencent.mm.ca.a.j.zJs, false);
            if (this.zBi) {
                this.zBj = new e();
            }
            this.zAu = obtainStyledAttributes.getFloat(com.tencent.mm.ca.a.j.zJt, this.zAu);
            this.zAv = this.zAu;
            this.zAH = obtainStyledAttributes.getBoolean(com.tencent.mm.ca.a.j.zJx, this.zAH);
            this.zBf = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(com.tencent.mm.ca.a.j.zJu, 0.75f)));
            this.zAz = this.zBf > 0.0f;
            float f = obtainStyledAttributes.getFloat(com.tencent.mm.ca.a.j.zJo, this.zAO);
            if (f > 0.5f) {
                this.zAP = 0.5f;
            } else {
                this.zAP = f;
            }
            if (f > 0.5f) {
                this.zAO = 0.5f;
            } else {
                this.zAO = f;
            }
            if (getHeight() != 0) {
                czw();
            }
            this.zAW = obtainStyledAttributes.getFloat(com.tencent.mm.ca.a.j.zJp, this.zAW);
            int i3 = obtainStyledAttributes.getInt(com.tencent.mm.ca.a.j.zJv, 150);
            int i4 = obtainStyledAttributes.getInt(com.tencent.mm.ca.a.j.zJw, 150);
            if (obtainStyledAttributes.getBoolean(com.tencent.mm.ca.a.j.zJE, true)) {
                boolean z = obtainStyledAttributes.getBoolean(com.tencent.mm.ca.a.j.zJz, false);
                int i5 = obtainStyledAttributes.getInt(com.tencent.mm.ca.a.j.zJr, 1);
                boolean z2 = obtainStyledAttributes.getBoolean(com.tencent.mm.ca.a.j.zJy, true);
                int i6 = obtainStyledAttributes.getInt(com.tencent.mm.ca.a.j.zJA, 0);
                int resourceId = obtainStyledAttributes.getResourceId(com.tencent.mm.ca.a.j.zJB, 0);
                int resourceId2 = obtainStyledAttributes.getResourceId(com.tencent.mm.ca.a.j.zJC, 0);
                int resourceId3 = obtainStyledAttributes.getResourceId(com.tencent.mm.ca.a.j.zJD, 0);
                int color = obtainStyledAttributes.getColor(com.tencent.mm.ca.a.j.zJq, WebView.NIGHT_MODE_COLOR);
                Object bVar = new b(this, resourceId, i6, i5, resourceId3, resourceId2);
                bVar.zzW = z;
                bVar.zzV = z2;
                bVar.zFq = color;
                this.zBc = bVar;
                setOnTouchListener(bVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i4;
            i = i3;
        }
        this.zAN = new d();
        if (i > 0) {
            this.zBn = new k(i);
        }
        if (i2 > 0) {
            this.zBp = new f(i2);
        }
        this.zBd = MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.mObserver = new DataSetObserver() {
            private void cancel() {
                if (DragSortListView.this.EV == 4) {
                    DragSortListView.this.czr();
                }
            }

            public final void onChanged() {
                cancel();
            }

            public final void onInvalidated() {
                cancel();
            }
        };
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.zBh = new a(listAdapter);
            listAdapter.registerDataSetObserver(this.mObserver);
            if (listAdapter instanceof g) {
                this.zAF = (g) listAdapter;
            }
            if (listAdapter instanceof b) {
                this.zAE = (b) listAdapter;
            }
            if (listAdapter instanceof l) {
                this.zAG = (l) listAdapter;
            }
        } else {
            this.zBh = null;
        }
        super.setAdapter(this.zBh);
    }

    private void a(int i, Canvas canvas) {
        Drawable divider = getDivider();
        int dividerHeight = getDividerHeight();
        if (divider != null && dividerHeight != 0) {
            ViewGroup viewGroup = (ViewGroup) getChildAt(i - getFirstVisiblePosition());
            if (viewGroup != null) {
                int i2;
                int paddingLeft = getPaddingLeft();
                int width = getWidth() - getPaddingRight();
                int height = viewGroup.getChildAt(0).getHeight();
                if (i > this.zAA) {
                    height += viewGroup.getTop();
                    i2 = height + dividerHeight;
                } else {
                    i2 = viewGroup.getBottom() - height;
                    height = i2 - dividerHeight;
                }
                canvas.save();
                canvas.clipRect(paddingLeft, height, width, i2);
                divider.setBounds(paddingLeft, height, width, i2);
                divider.draw(canvas);
                canvas.restore();
            }
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.EV != 0) {
            if (this.zAx != this.zAA) {
                a(this.zAx, canvas);
            }
            if (!(this.zAy == this.zAx || this.zAy == this.zAA)) {
                a(this.zAy, canvas);
            }
        }
        if (this.zAp != null) {
            float f;
            int width = this.zAp.getWidth();
            int height = this.zAp.getHeight();
            int i = this.zAq.x;
            int width2 = getWidth();
            if (i < 0) {
                i = -i;
            }
            if (i < width2) {
                f = ((float) (width2 - i)) / ((float) width2);
                f *= f;
            } else {
                f = 0.0f;
            }
            int i2 = (int) (f * (255.0f * this.zAv));
            canvas.save();
            canvas.translate((float) this.zAq.x, (float) this.zAq.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, (float) width, (float) height, i2, 31);
            this.zAp.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    private int Hk(int i) {
        View childAt = getChildAt(i - getFirstVisiblePosition());
        if (childAt != null) {
            return childAt.getHeight();
        }
        return fn(i, Hm(i));
    }

    private int fm(int i, int i2) {
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        if (i <= headerViewsCount || i >= getCount() - footerViewsCount) {
            return i2;
        }
        headerViewsCount = getDividerHeight();
        footerViewsCount = this.zAJ - this.zAI;
        int Hm = Hm(i);
        int Hk = Hk(i);
        if (this.zAy <= this.zAA) {
            if (i != this.zAy || this.zAx == this.zAy) {
                if (i > this.zAy && i <= this.zAA) {
                    i2 -= footerViewsCount;
                }
            } else if (i == this.zAA) {
                i2 = (i2 + Hk) - this.zAJ;
            } else {
                i2 = ((Hk - Hm) + i2) - footerViewsCount;
            }
        } else if (i > this.zAA && i <= this.zAx) {
            i2 += footerViewsCount;
        } else if (i == this.zAy && this.zAx != this.zAy) {
            i2 += Hk - Hm;
        }
        if (i <= this.zAA) {
            return (((this.zAJ - headerViewsCount) - Hm(i - 1)) / 2) + i2;
        }
        return (((Hm - headerViewsCount) - this.zAJ) / 2) + i2;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.zBi) {
            e eVar = this.zBj;
            if (eVar.zBI) {
                int i;
                eVar.mBuilder.append("<DSLVState>\n");
                int childCount = eVar.zBu.getChildCount();
                int firstVisiblePosition = eVar.zBu.getFirstVisiblePosition();
                eVar.mBuilder.append("    <Positions>");
                for (i = 0; i < childCount; i++) {
                    eVar.mBuilder.append(firstVisiblePosition + i).append(",");
                }
                eVar.mBuilder.append("</Positions>\n");
                eVar.mBuilder.append("    <Tops>");
                for (i = 0; i < childCount; i++) {
                    eVar.mBuilder.append(eVar.zBu.getChildAt(i).getTop()).append(",");
                }
                eVar.mBuilder.append("</Tops>\n");
                eVar.mBuilder.append("    <Bottoms>");
                for (i = 0; i < childCount; i++) {
                    eVar.mBuilder.append(eVar.zBu.getChildAt(i).getBottom()).append(",");
                }
                eVar.mBuilder.append("</Bottoms>\n");
                eVar.mBuilder.append("    <FirstExpPos>").append(eVar.zBu.zAx).append("</FirstExpPos>\n");
                eVar.mBuilder.append("    <FirstExpBlankHeight>").append(eVar.zBu.Hk(eVar.zBu.zAx) - eVar.zBu.Hm(eVar.zBu.zAx)).append("</FirstExpBlankHeight>\n");
                eVar.mBuilder.append("    <SecondExpPos>").append(eVar.zBu.zAy).append("</SecondExpPos>\n");
                eVar.mBuilder.append("    <SecondExpBlankHeight>").append(eVar.zBu.Hk(eVar.zBu.zAy) - eVar.zBu.Hm(eVar.zBu.zAy)).append("</SecondExpBlankHeight>\n");
                eVar.mBuilder.append("    <SrcPos>").append(eVar.zBu.zAA).append("</SrcPos>\n");
                eVar.mBuilder.append("    <SrcHeight>").append(eVar.zBu.zAJ + eVar.zBu.getDividerHeight()).append("</SrcHeight>\n");
                eVar.mBuilder.append("    <ViewHeight>").append(eVar.zBu.getHeight()).append("</ViewHeight>\n");
                eVar.mBuilder.append("    <LastY>").append(eVar.zBu.jKi).append("</LastY>\n");
                eVar.mBuilder.append("    <FloatY>").append(eVar.zBu.zAs).append("</FloatY>\n");
                eVar.mBuilder.append("    <ShuffleEdges>");
                for (i = 0; i < childCount; i++) {
                    eVar.mBuilder.append(eVar.zBu.fm(firstVisiblePosition + i, eVar.zBu.getChildAt(i).getTop())).append(",");
                }
                eVar.mBuilder.append("</ShuffleEdges>\n");
                eVar.mBuilder.append("</DSLVState>\n");
                eVar.zBG++;
                if (eVar.zBG > 1000) {
                    eVar.flush();
                    eVar.zBG = 0;
                }
            }
        }
    }

    public final void k(int i, float f) {
        if (this.EV == 0 || this.EV == 4) {
            if (this.EV == 0) {
                this.zAA = getHeaderViewsCount() + i;
                this.zAx = this.zAA;
                this.zAy = this.zAA;
                this.zAw = this.zAA;
                View childAt = getChildAt(this.zAA - getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.EV = 1;
            this.zBr = f;
            if (this.zBb) {
                switch (this.zBe) {
                    case 1:
                        super.onTouchEvent(this.zBd);
                        break;
                    case 2:
                        super.onInterceptTouchEvent(this.zBd);
                        break;
                }
            }
            if (this.zBn != null) {
                this.zBn.start();
            } else {
                Hl(i);
            }
        }
    }

    public final void czr() {
        if (this.EV == 4) {
            this.zAN.czA();
            czz();
            czs();
            czx();
            if (this.zBb) {
                this.EV = 3;
            } else {
                this.EV = 0;
            }
        }
    }

    private void czs() {
        this.zAA = -1;
        this.zAx = -1;
        this.zAy = -1;
        this.zAw = -1;
    }

    private void czt() {
        this.EV = 2;
        if (this.zAF != null && this.zAw >= 0 && this.zAw < getCount()) {
            int headerViewsCount = getHeaderViewsCount();
            this.zAF.cu(this.zAA - headerViewsCount, this.zAw - headerViewsCount);
        }
        czz();
        czu();
        czs();
        czx();
        if (this.zBb) {
            this.EV = 3;
        } else {
            this.EV = 0;
        }
    }

    private void Hl(int i) {
        this.EV = 1;
        if (this.zAG != null) {
            this.zAG.remove(i);
        }
        czz();
        czu();
        czs();
        if (this.zBb) {
            this.EV = 3;
        } else {
            this.EV = 0;
        }
    }

    private void czu() {
        int i = 0;
        int firstVisiblePosition = getFirstVisiblePosition();
        if (this.zAA < firstVisiblePosition) {
            View childAt = getChildAt(0);
            if (childAt != null) {
                i = childAt.getTop();
            }
            setSelectionFromTop(firstVisiblePosition - 1, i - getPaddingTop());
        }
    }

    public final boolean aF(float f) {
        this.zBq = true;
        return b(true, f);
    }

    private boolean b(boolean z, float f) {
        if (this.zAp == null) {
            return false;
        }
        this.zAN.czA();
        if (z) {
            k(this.zAA - getHeaderViewsCount(), f);
        } else if (this.zBp != null) {
            this.zBp.start();
        } else {
            czt();
        }
        if (this.zBi) {
            e eVar = this.zBj;
            if (eVar.zBI) {
                eVar.mBuilder.append("</DSLVStates>\n");
                eVar.flush();
                eVar.zBI = false;
            }
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.zBl) {
            this.zBl = false;
            return false;
        } else if (!this.zAH) {
            return super.onTouchEvent(motionEvent);
        } else {
            boolean z = this.zBa;
            this.zBa = false;
            if (!z) {
                N(motionEvent);
            }
            if (this.EV != 4) {
                if (this.EV == 0 && super.onTouchEvent(motionEvent)) {
                    z = true;
                } else {
                    z = false;
                }
                switch (motionEvent.getAction() & 255) {
                    case 1:
                    case 3:
                        czv();
                        break;
                    default:
                        if (z) {
                            this.zBe = 1;
                            break;
                        }
                        break;
                }
            }
            motionEvent.getAction();
            switch (motionEvent.getAction() & 255) {
                case 1:
                    if (this.EV == 4) {
                        this.zBq = false;
                        b(false, 0.0f);
                    }
                    czv();
                    break;
                case 2:
                    int y = (int) motionEvent.getY();
                    this.zAq.x = ((int) motionEvent.getX()) - this.zAB;
                    this.zAq.y = y - this.zAC;
                    nI(true);
                    int min = Math.min(y, this.zAs + this.zAK);
                    y = Math.max(y, this.zAs - this.zAK);
                    d dVar = this.zAN;
                    int i = dVar.zBF ? dVar.zBD : -1;
                    if (min <= this.jKi || min <= this.zAR || i == 1) {
                        if (y >= this.jKi || y >= this.zAQ || i == 0) {
                            if (y >= this.zAQ && min <= this.zAR && this.zAN.zBF) {
                                this.zAN.czA();
                                break;
                            }
                        }
                        if (i != -1) {
                            this.zAN.czA();
                        }
                        this.zAN.Hn(0);
                        break;
                    }
                    if (i != -1) {
                        this.zAN.czA();
                    }
                    this.zAN.Hn(1);
                    break;
                    break;
                case 3:
                    if (this.EV == 4) {
                        czr();
                    }
                    czv();
                    break;
            }
            z = true;
            return z;
        }
    }

    private void czv() {
        this.zBe = 0;
        this.zBb = false;
        if (this.EV == 3) {
            this.EV = 0;
        }
        this.zAv = this.zAu;
        this.zBs = false;
        i iVar = this.zBm;
        iVar.zBN.clear();
        iVar.zBO.clear();
    }

    private void N(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.jKh = this.iNz;
            this.jKi = this.iNA;
        }
        this.iNz = (int) motionEvent.getX();
        this.iNA = (int) motionEvent.getY();
        if (action == 0) {
            this.jKh = this.iNz;
            this.jKi = this.iNA;
        }
        this.klx = ((int) motionEvent.getRawX()) - this.iNz;
        this.zAD = ((int) motionEvent.getRawY()) - this.iNA;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.zAH) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        boolean z;
        N(motionEvent);
        this.zBa = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.EV != 0) {
                this.zBl = true;
                return true;
            }
            this.zBb = true;
        }
        if (this.zAp == null) {
            if (super.onInterceptTouchEvent(motionEvent)) {
                this.zBs = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    czv();
                    break;
                default:
                    if (!z) {
                        this.zBe = 2;
                        break;
                    }
                    this.zBe = 1;
                    break;
            }
        }
        z = true;
        if (action == 1 || action == 3) {
            this.zBb = false;
        }
        return z;
    }

    private void czw() {
        int paddingTop = getPaddingTop();
        int height = (getHeight() - paddingTop) - getPaddingBottom();
        float f = (float) height;
        this.zAT = ((float) paddingTop) + (this.zAO * f);
        this.zAS = (f * (1.0f - this.zAP)) + ((float) paddingTop);
        this.zAQ = (int) this.zAT;
        this.zAR = (int) this.zAS;
        this.zAU = this.zAT - ((float) paddingTop);
        this.zAV = ((float) (paddingTop + height)) - this.zAS;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        czw();
    }

    private void czx() {
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        lastVisiblePosition = Math.min(lastVisiblePosition - firstVisiblePosition, ((getCount() - 1) - getFooterViewsCount()) - firstVisiblePosition);
        for (int max = Math.max(0, getHeaderViewsCount() - firstVisiblePosition); max <= lastVisiblePosition; max++) {
            View childAt = getChildAt(max);
            if (childAt != null) {
                a(firstVisiblePosition + max, childAt, false);
            }
        }
    }

    private void a(int i, View view, boolean z) {
        int fn;
        LayoutParams layoutParams = view.getLayoutParams();
        if (i == this.zAA || i == this.zAx || i == this.zAy) {
            fn = fn(i, b(i, view, z));
        } else {
            fn = -2;
        }
        if (fn != layoutParams.height) {
            layoutParams.height = fn;
            view.setLayoutParams(layoutParams);
        }
        if (i == this.zAx || i == this.zAy) {
            if (i < this.zAA) {
                ((c) view).ug = 80;
            } else if (i > this.zAA) {
                ((c) view).ug = 48;
            }
        }
        int visibility = view.getVisibility();
        fn = 0;
        if (i == this.zAA && this.zAp != null) {
            fn = 4;
        }
        if (fn != visibility) {
            view.setVisibility(fn);
        }
    }

    private int Hm(int i) {
        if (i == this.zAA) {
            return 0;
        }
        View childAt = getChildAt(i - getFirstVisiblePosition());
        if (childAt != null) {
            return b(i, childAt, false);
        }
        int i2 = this.zBm.zBN.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        ListAdapter adapter = getAdapter();
        int itemViewType = adapter.getItemViewType(i);
        int viewTypeCount = adapter.getViewTypeCount();
        if (viewTypeCount != this.zAM.length) {
            this.zAM = new View[viewTypeCount];
        }
        if (itemViewType < 0) {
            childAt = adapter.getView(i, null, this);
        } else if (this.zAM[itemViewType] == null) {
            childAt = adapter.getView(i, null, this);
            this.zAM[itemViewType] = childAt;
        } else {
            childAt = adapter.getView(i, this.zAM[itemViewType], this);
        }
        itemViewType = b(i, childAt, true);
        i iVar = this.zBm;
        i2 = iVar.zBN.get(i, -1);
        if (i2 != itemViewType) {
            if (i2 != -1) {
                iVar.zBO.remove(Integer.valueOf(i));
            } else if (iVar.zBN.size() == iVar.xru) {
                iVar.zBN.delete(((Integer) iVar.zBO.remove(0)).intValue());
            }
            iVar.zBN.put(i, itemViewType);
            iVar.zBO.add(Integer.valueOf(i));
        }
        return itemViewType;
    }

    private int b(int i, View view, boolean z) {
        if (i == this.zAA) {
            return 0;
        }
        if (i >= getHeaderViewsCount() && i < getCount() - getFooterViewsCount()) {
            view = ((ViewGroup) view).getChildAt(0);
        }
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && layoutParams.height > 0) {
            return layoutParams.height;
        }
        int height = view.getHeight();
        if (height != 0 && !z) {
            return height;
        }
        dM(view);
        return view.getMeasuredHeight();
    }

    private int fn(int i, int i2) {
        getDividerHeight();
        Object obj = (!this.zAz || this.zAx == this.zAy) ? null : 1;
        int i3 = this.zAJ - this.zAI;
        int i4 = (int) (this.zBg * ((float) i3));
        if (i == this.zAA) {
            if (this.zAA == this.zAx) {
                if (obj != null) {
                    return i4 + this.zAI;
                }
                return this.zAJ;
            } else if (this.zAA == this.zAy) {
                return this.zAJ - i4;
            } else {
                return this.zAI;
            }
        } else if (i == this.zAx) {
            if (obj != null) {
                return i2 + i4;
            }
            return i2 + i3;
        } else if (i == this.zAy) {
            return (i2 + i3) - i4;
        } else {
            return i2;
        }
    }

    public void requestLayout() {
        if (!this.zBk) {
            super.requestLayout();
        }
    }

    private void dM(View view) {
        int makeMeasureSpec;
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -2);
            view.setLayoutParams(layoutParams);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.zAL, getListPaddingLeft() + getListPaddingRight(), layoutParams.width);
        if (layoutParams.height > 0) {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
        } else {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    private void czy() {
        if (this.zAp != null) {
            dM(this.zAp);
            this.zAJ = this.zAp.getMeasuredHeight();
            this.zAK = this.zAJ / 2;
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.zAp != null) {
            if (this.zAp.isLayoutRequested()) {
                czy();
            }
            this.zAt = true;
        }
        this.zAL = i;
    }

    protected void layoutChildren() {
        super.layoutChildren();
        if (this.zAp != null) {
            if (this.zAp.isLayoutRequested() && !this.zAt) {
                czy();
            }
            this.zAp.layout(0, 0, this.zAp.getMeasuredWidth(), this.zAp.getMeasuredHeight());
            this.zAt = false;
        }
    }

    public final boolean a(int i, View view, int i2, int i3, int i4) {
        if (this.EV != 0 || !this.zBb || this.zAp != null || view == null || !this.zAH) {
            return false;
        }
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        int headerViewsCount = getHeaderViewsCount() + i;
        this.zAx = headerViewsCount;
        this.zAy = headerViewsCount;
        this.zAA = headerViewsCount;
        this.zAw = headerViewsCount;
        this.EV = 4;
        this.zAZ = 0;
        this.zAZ |= i2;
        this.zAp = view;
        czy();
        this.zAB = i3;
        this.zAC = i4;
        this.zAY = this.iNA;
        this.zAq.x = this.iNz - this.zAB;
        this.zAq.y = this.iNA - this.zAC;
        View childAt = getChildAt(this.zAA - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setVisibility(4);
        }
        if (this.zBi) {
            e eVar = this.zBj;
            eVar.mBuilder.append("<DSLVStates>\n");
            eVar.zBH = 0;
            eVar.zBI = true;
        }
        switch (this.zBe) {
            case 1:
                super.onTouchEvent(this.zBd);
                break;
            case 2:
                super.onInterceptTouchEvent(this.zBd);
                break;
        }
        requestLayout();
        if (this.zBo == null) {
            return true;
        }
        this.zBo.start();
        return true;
    }

    private void nI(boolean z) {
        int firstVisiblePosition = getFirstVisiblePosition() + (getChildCount() / 2);
        View childAt = getChildAt(getChildCount() / 2);
        if (childAt != null) {
            c(firstVisiblePosition, childAt, true);
        }
    }

    private void c(int i, View view, boolean z) {
        int count;
        Object obj;
        Object obj2;
        this.zBk = true;
        if (this.zBc != null) {
            this.zAr.set(this.iNz, this.iNA);
            this.zBc.g(this.zAq);
        }
        int i2 = this.zAq.x;
        int i3 = this.zAq.y;
        int paddingLeft = getPaddingLeft();
        if ((this.zAZ & 1) == 0 && i2 > paddingLeft) {
            this.zAq.x = paddingLeft;
        } else if ((this.zAZ & 2) == 0 && i2 < paddingLeft) {
            this.zAq.x = paddingLeft;
        }
        paddingLeft = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        i2 = getPaddingTop();
        if (firstVisiblePosition < paddingLeft) {
            i2 = getChildAt((paddingLeft - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.zAZ & 8) == 0 && firstVisiblePosition <= this.zAA) {
            i2 = Math.max(getChildAt(this.zAA - firstVisiblePosition).getTop(), i2);
        }
        paddingLeft = getHeight() - getPaddingBottom();
        if (lastVisiblePosition >= (getCount() - footerViewsCount) - 1) {
            paddingLeft = getChildAt(((getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.zAZ & 4) == 0 && lastVisiblePosition >= this.zAA) {
            paddingLeft = Math.min(getChildAt(this.zAA - firstVisiblePosition).getBottom(), paddingLeft);
        }
        if (i3 < i2) {
            this.zAq.y = i2;
        } else if (this.zAJ + i3 > paddingLeft) {
            this.zAq.y = paddingLeft - this.zAJ;
        }
        this.zAs = this.zAq.y + this.zAK;
        int i4 = this.zAx;
        int i5 = this.zAy;
        i3 = getFirstVisiblePosition();
        paddingLeft = this.zAx;
        View childAt = getChildAt(paddingLeft - i3);
        if (childAt == null) {
            paddingLeft = i3 + (getChildCount() / 2);
            childAt = getChildAt(paddingLeft - i3);
        }
        footerViewsCount = childAt.getTop();
        i2 = childAt.getHeight();
        i3 = fm(paddingLeft, footerViewsCount);
        lastVisiblePosition = getDividerHeight();
        if (this.zAs >= i3) {
            count = getCount();
            firstVisiblePosition = footerViewsCount;
            footerViewsCount = i2;
            i2 = paddingLeft;
            paddingLeft = i3;
            while (i2 < count) {
                if (i2 != count - 1) {
                    firstVisiblePosition += lastVisiblePosition + footerViewsCount;
                    footerViewsCount = Hk(i2 + 1);
                    i3 = fm(i2 + 1, firstVisiblePosition);
                    if (this.zAs < i3) {
                        break;
                    }
                    i2++;
                    paddingLeft = i3;
                } else {
                    i3 = (firstVisiblePosition + lastVisiblePosition) + footerViewsCount;
                    break;
                }
            }
        }
        i2 = paddingLeft;
        paddingLeft = i3;
        while (i2 >= 0) {
            i2--;
            i3 = Hk(i2);
            if (i2 != 0) {
                footerViewsCount -= i3 + lastVisiblePosition;
                i3 = fm(i2, footerViewsCount);
                if (this.zAs >= i3) {
                    break;
                }
                paddingLeft = i3;
            } else {
                i3 = (footerViewsCount - lastVisiblePosition) - i3;
                break;
            }
        }
        footerViewsCount = getHeaderViewsCount();
        lastVisiblePosition = getFooterViewsCount();
        count = this.zAx;
        int i6 = this.zAy;
        float f = this.zBg;
        if (this.zAz) {
            int abs = Math.abs(i3 - paddingLeft);
            if (this.zAs >= i3) {
                int i7 = paddingLeft;
                paddingLeft = i3;
                i3 = i7;
            }
            abs = (int) (((float) abs) * (0.5f * this.zBf));
            float f2 = (float) abs;
            paddingLeft += abs;
            abs = i3 - abs;
            if (this.zAs < paddingLeft) {
                this.zAx = i2 - 1;
                this.zAy = i2;
                this.zBg = (((float) (paddingLeft - this.zAs)) * 0.5f) / f2;
            } else if (this.zAs >= abs) {
                this.zAx = i2;
                this.zAy = i2 + 1;
                this.zBg = 0.5f * ((((float) (i3 - this.zAs)) / f2) + 1.0f);
            }
            if (this.zAx < footerViewsCount) {
                this.zAx = footerViewsCount;
                this.zAy = footerViewsCount;
                i2 = footerViewsCount;
            } else if (this.zAy >= getCount() - lastVisiblePosition) {
                i2 = (getCount() - lastVisiblePosition) - 1;
                this.zAx = i2;
                this.zAy = i2;
            }
            if (this.zAx != count && this.zAy == i6 && this.zBg == f) {
                obj = null;
            } else {
                obj = 1;
            }
            if (i2 == this.zAw) {
                this.zAw = i2;
                obj2 = 1;
            } else {
                obj2 = obj;
            }
            if (obj2 != null) {
                czx();
                i3 = Hm(i);
                paddingLeft = view.getHeight();
                footerViewsCount = fn(i, i3);
                if (i == this.zAA) {
                    i2 = paddingLeft - i3;
                    i3 = footerViewsCount - i3;
                } else {
                    i2 = paddingLeft;
                    i3 = footerViewsCount;
                }
                lastVisiblePosition = this.zAJ;
                if (!(this.zAA == this.zAx || this.zAA == this.zAy)) {
                    lastVisiblePosition -= this.zAI;
                }
                if (i <= i4) {
                    if (i > this.zAx) {
                        i2 = (lastVisiblePosition - i3) + 0;
                    }
                    i2 = 0;
                } else if (i != i5) {
                    i2 = i > this.zAx ? (i2 - lastVisiblePosition) + 0 : i != this.zAy ? (paddingLeft - footerViewsCount) + 0 : i2 + 0;
                } else if (i > this.zAx) {
                    i2 = 0 - lastVisiblePosition;
                } else {
                    if (i == this.zAy) {
                        i2 = 0 - i3;
                    }
                    i2 = 0;
                }
                setSelectionFromTop(i, (i2 + view.getTop()) - getPaddingTop());
                layoutChildren();
            }
            if (obj2 != null || z) {
                invalidate();
            }
            this.zBk = false;
        }
        this.zAx = i2;
        this.zAy = i2;
        if (this.zAx < footerViewsCount) {
            this.zAx = footerViewsCount;
            this.zAy = footerViewsCount;
            i2 = footerViewsCount;
        } else if (this.zAy >= getCount() - lastVisiblePosition) {
            i2 = (getCount() - lastVisiblePosition) - 1;
            this.zAx = i2;
            this.zAy = i2;
        }
        if (this.zAx != count) {
        }
        obj = 1;
        if (i2 == this.zAw) {
            obj2 = obj;
        } else {
            this.zAw = i2;
            obj2 = 1;
        }
        if (obj2 != null) {
            czx();
            i3 = Hm(i);
            paddingLeft = view.getHeight();
            footerViewsCount = fn(i, i3);
            if (i == this.zAA) {
                i2 = paddingLeft;
                i3 = footerViewsCount;
            } else {
                i2 = paddingLeft - i3;
                i3 = footerViewsCount - i3;
            }
            lastVisiblePosition = this.zAJ;
            lastVisiblePosition -= this.zAI;
            if (i <= i4) {
                if (i > this.zAx) {
                    i2 = (lastVisiblePosition - i3) + 0;
                }
                i2 = 0;
            } else if (i != i5) {
                if (i > this.zAx) {
                    if (i == this.zAy) {
                        i2 = 0 - i3;
                    }
                    i2 = 0;
                } else {
                    i2 = 0 - lastVisiblePosition;
                }
            } else if (i > this.zAx) {
                if (i != this.zAy) {
                }
            }
            setSelectionFromTop(i, (i2 + view.getTop()) - getPaddingTop());
            layoutChildren();
        }
        invalidate();
        this.zBk = false;
    }

    private void czz() {
        if (this.zAp != null) {
            this.zAp.setVisibility(8);
            if (this.zBc != null) {
                this.zBc.dN(this.zAp);
            }
            this.zAp = null;
            invalidate();
        }
    }
}
