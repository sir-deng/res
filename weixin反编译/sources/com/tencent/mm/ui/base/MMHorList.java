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
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.LinkedList;
import java.util.Queue;

public class MMHorList extends AdapterView<ListAdapter> {
    public boolean oSJ = false;
    private int offset;
    public a yjZ;
    private int yka;
    private int ykb;
    public int ykc;
    private int ykd;
    private int yke = SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING;
    private Queue<View> ykf = new LinkedList();
    private boolean ykg = false;
    private boolean ykh = false;
    protected Scroller yki;
    private GestureDetector ykj;
    private OnItemSelectedListener ykk;
    private OnItemClickListener ykl;
    private ListAdapter ykm;
    private Runnable ykn = new Runnable() {
        public final void run() {
            MMHorList.this.requestLayout();
        }
    };
    public boolean yko = false;
    public boolean ykp = false;
    public int ykq = 0;
    private int ykr = 0;
    private boolean yks = false;
    private DataSetObserver ykt = new DataSetObserver() {
        public final void onChanged() {
            MMHorList.this.ykg = true;
            MMHorList.this.invalidate();
            MMHorList.this.requestLayout();
        }

        public final void onInvalidated() {
            MMHorList.this.reset();
            MMHorList.this.invalidate();
            MMHorList.this.requestLayout();
        }
    };
    private OnGestureListener yku = new SimpleOnGestureListener() {
        public final boolean onDown(MotionEvent motionEvent) {
            return MMHorList.this.cpz();
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return MMHorList.this.aD(f);
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            MMHorList.this.ykd = MMHorList.this.ykd + ((int) f);
            MMHorList.this.requestLayout();
            return true;
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            Rect rect = new Rect();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= MMHorList.this.getChildCount()) {
                    break;
                }
                View childAt = MMHorList.this.getChildAt(i2);
                rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    if (MMHorList.this.ykl != null) {
                        MMHorList.this.ykl.onItemClick(MMHorList.this, childAt, (MMHorList.this.yka + 1) + i2, MMHorList.this.ykm.getItemId((MMHorList.this.yka + 1) + i2));
                    }
                    if (MMHorList.this.ykk != null) {
                        MMHorList.this.ykk.onItemSelected(MMHorList.this, childAt, (MMHorList.this.yka + 1) + i2, MMHorList.this.ykm.getItemId((MMHorList.this.yka + 1) + i2));
                    }
                } else {
                    i = i2 + 1;
                }
            }
            return true;
        }
    };

    public interface a {
        void aYc();

        void bFK();

        void bFL();
    }

    public /* bridge */ /* synthetic */ Adapter getAdapter() {
        return this.ykm;
    }

    private void init() {
        this.yki = new Scroller(getContext());
        this.yka = -1;
        this.ykb = 0;
        this.offset = 0;
        this.ykc = 0;
        this.ykd = 0;
        this.ykg = false;
        this.yke = SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING;
        this.ykj = new GestureDetector(getContext(), this.yku);
    }

    public MMHorList(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.ykk = onItemSelectedListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.ykl = onItemClickListener;
    }

    public MMHorList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public final void setAdapter(ListAdapter listAdapter) {
        if (this.ykm == null) {
            listAdapter.registerDataSetObserver(this.ykt);
        }
        this.ykm = listAdapter;
        reset();
    }

    private int cqa() {
        return this.ykm.getCount() * this.ykq;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.ykm != null) {
            int i5;
            int i6;
            this.ykh = true;
            if (this.ykg) {
                i5 = this.ykc;
                init();
                removeAllViewsInLayout();
                this.ykd = i5;
                if (this.yko) {
                    this.ykr = Math.max(0, (getWidth() - cqa()) / 2);
                    this.offset = this.ykr;
                }
                this.ykg = false;
            }
            if (this.yki.computeScrollOffset()) {
                this.ykd = this.yki.getCurrX();
            }
            if (!this.ykp) {
                if (this.ykd < 0) {
                    this.ykd = 0;
                    this.yki.forceFinished(true);
                }
                if (this.ykd > this.yke) {
                    this.ykd = this.yke;
                    this.yki.forceFinished(true);
                }
            } else if (cqa() > getWidth()) {
                if (this.ykd < getWidth() * -1) {
                    this.ykd = (getWidth() * -1) + 1;
                    this.yki.forceFinished(true);
                }
                if (this.ykd > this.yke + getWidth()) {
                    this.ykd = (this.yke + getWidth()) - 1;
                    this.yki.forceFinished(true);
                }
            } else {
                if (this.ykd < (getWidth() * -1) + this.ykr) {
                    this.ykd = ((getWidth() * -1) + this.ykr) + 1;
                    this.yki.forceFinished(true);
                }
                if (this.ykd > getWidth() - this.ykr) {
                    this.ykd = (getWidth() - this.ykr) - 1;
                    this.yki.forceFinished(true);
                }
            }
            int i7 = this.ykc - this.ykd;
            View childAt = getChildAt(0);
            while (childAt != null && childAt.getRight() + i7 <= 0) {
                this.offset += childAt.getMeasuredWidth();
                this.ykf.offer(childAt);
                removeViewInLayout(childAt);
                this.yka++;
                childAt = getChildAt(0);
                this.ykh = true;
            }
            childAt = getChildAt(getChildCount() - 1);
            while (childAt != null && childAt.getLeft() + i7 >= getWidth()) {
                this.ykf.offer(childAt);
                removeViewInLayout(childAt);
                this.ykb--;
                childAt = getChildAt(getChildCount() - 1);
                this.ykh = true;
            }
            childAt = getChildAt(getChildCount() - 1);
            i5 = childAt != null ? childAt.getRight() : 0;
            while (true) {
                i6 = i5;
                if (i6 + i7 >= getWidth() || this.ykb >= this.ykm.getCount()) {
                    childAt = getChildAt(0);
                } else {
                    childAt = this.ykm.getView(this.ykb, (View) this.ykf.poll(), this);
                    I(childAt, -1);
                    i5 = childAt.getMeasuredWidth() + i6;
                    if (this.ykb == this.ykm.getCount() - 1) {
                        this.yke = (this.ykc + i5) - getWidth();
                    }
                    this.ykb++;
                }
            }
            childAt = getChildAt(0);
            i5 = childAt != null ? childAt.getLeft() : 0;
            while (true) {
                i6 = i5;
                if (i6 + i7 > 0 && this.yka >= 0) {
                    View view = this.ykm.getView(this.yka, (View) this.ykf.poll(), this);
                    I(view, 0);
                    i5 = i6 - view.getMeasuredWidth();
                    this.yka--;
                    this.offset -= view.getMeasuredWidth();
                }
            }
            if (getChildCount() > 0 && this.ykh) {
                this.offset += i7;
                i6 = this.offset;
                for (i5 = 0; i5 < getChildCount(); i5++) {
                    View childAt2 = getChildAt(i5);
                    int measuredWidth = childAt2.getMeasuredWidth();
                    childAt2.layout(i6, 0, i6 + measuredWidth, childAt2.getMeasuredHeight());
                    i6 += measuredWidth;
                }
            }
            this.ykc = this.ykd;
            if (!this.yki.isFinished()) {
                post(this.ykn);
            } else if (this.yjZ != null && this.yks) {
                this.yjZ.aYc();
                this.yks = false;
            }
        }
    }

    private void I(View view, int i) {
        this.ykh = true;
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -1);
        }
        addViewInLayout(view, i, layoutParams, true);
        view.measure(MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
    }

    public View getSelectedView() {
        return null;
    }

    public void setSelection(int i) {
    }

    protected void onMeasure(int i, int i2) {
        if (this.ykm != null && this.ykm.getCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt != null) {
                super.onMeasure(i, MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), Integer.MIN_VALUE));
                return;
            }
        }
        super.onMeasure(i, i2);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.ykj.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0) {
            this.oSJ = true;
            if (this.yjZ != null) {
                this.yjZ.bFK();
            }
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            if (this.ykp) {
                if (cqa() > getWidth()) {
                    if (this.ykc < 0) {
                        this.yki.forceFinished(true);
                        this.yki.startScroll(this.ykc, 0, 0 - this.ykc, 0);
                        requestLayout();
                    } else if (this.ykc > this.yke) {
                        this.yki.forceFinished(true);
                        this.yki.startScroll(this.ykc, 0, this.yke - this.ykc, 0);
                        requestLayout();
                    }
                } else if (this.ykc != this.ykr * -1) {
                    this.yki.forceFinished(true);
                    this.yki.startScroll(this.ykc, 0, 0 - this.ykc, 0);
                    requestLayout();
                }
            }
            this.oSJ = false;
            if (this.yjZ != null) {
                this.yjZ.bFL();
            }
        }
        return onTouchEvent;
    }

    protected final boolean cpz() {
        this.yki.forceFinished(true);
        return true;
    }

    public final void Fg(int i) {
        this.yki.forceFinished(true);
        this.yki.startScroll(this.ykc, 0, i - this.ykc, 0);
        this.yks = true;
        requestLayout();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    protected final boolean aD(float f) {
        this.yki.fling(this.ykd, 0, (int) (-f), 0, 0, this.yke, 0, 0);
        requestLayout();
        return true;
    }

    private void reset() {
        init();
        removeAllViewsInLayout();
        requestLayout();
    }
}
