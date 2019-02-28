package com.tencent.mm.ui.base;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.Locale;

public class MMListPopupWindow {
    private ListAdapter FP;
    private int PV;
    public int SM;
    public int SN;
    private int SO;
    private boolean SQ;
    private boolean SR;
    private boolean SS;
    int ST;
    public View SU;
    public int SV;
    public View SW;
    private Drawable SX;
    public OnItemClickListener SY;
    private OnItemSelectedListener SZ;
    private Runnable Te;
    private boolean Tf;
    private Rect ey;
    public q iqe;
    public boolean kgm;
    private Context mContext;
    private ag mHandler;
    private DataSetObserver mObserver;
    private final b ykA;
    public a ykw;
    private final f ykx;
    private final e yky;
    private final d ykz;

    private class e implements OnTouchListener {
        private e() {
        }

        /* synthetic */ e(MMListPopupWindow mMListPopupWindow, byte b) {
            this();
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && MMListPopupWindow.this.iqe != null && MMListPopupWindow.this.iqe.isShowing() && x >= 0 && x < MMListPopupWindow.this.iqe.getWidth() && y >= 0 && y < MMListPopupWindow.this.iqe.getHeight()) {
                MMListPopupWindow.this.mHandler.postDelayed(MMListPopupWindow.this.ykx, 250);
            } else if (action == 1) {
                MMListPopupWindow.this.mHandler.removeCallbacks(MMListPopupWindow.this.ykx);
            }
            return false;
        }
    }

    private class f implements Runnable {
        private f() {
        }

        /* synthetic */ f(MMListPopupWindow mMListPopupWindow, byte b) {
            this();
        }

        public final void run() {
            if (MMListPopupWindow.this.ykw != null && MMListPopupWindow.this.ykw.getCount() > MMListPopupWindow.this.ykw.getChildCount() && MMListPopupWindow.this.ykw.getChildCount() <= MMListPopupWindow.this.ST) {
                MMListPopupWindow.this.iqe.setInputMethodMode(2);
                MMListPopupWindow.this.show();
            }
        }
    }

    private class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(MMListPopupWindow mMListPopupWindow, byte b) {
            this();
        }

        public final void run() {
            MMListPopupWindow.this.clearListSelection();
        }
    }

    private class d implements OnScrollListener {
        private d() {
        }

        /* synthetic */ d(MMListPopupWindow mMListPopupWindow, byte b) {
            this();
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (MMListPopupWindow.this.ykw != null && MMListPopupWindow.this.SU != null && MMListPopupWindow.this.FP != null && MMListPopupWindow.this.ykw != null) {
                if (MMListPopupWindow.this.ykw.getLastVisiblePosition() != MMListPopupWindow.this.FP.getCount() - 1 || MMListPopupWindow.this.ykw.getChildAt(MMListPopupWindow.this.ykw.getChildCount() - 1) == null || MMListPopupWindow.this.ykw.getChildAt(MMListPopupWindow.this.ykw.getChildCount() - 1).getBottom() > MMListPopupWindow.this.ykw.getHeight()) {
                    MMListPopupWindow.this.SU.setVisibility(0);
                } else {
                    MMListPopupWindow.this.SU.setVisibility(8);
                }
            }
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !MMListPopupWindow.this.isInputMethodNotNeeded() && MMListPopupWindow.this.iqe.getContentView() != null) {
                MMListPopupWindow.this.mHandler.removeCallbacks(MMListPopupWindow.this.ykx);
                MMListPopupWindow.this.ykx.run();
            }
        }
    }

    private static class a extends ListView {
        private boolean Th;
        private boolean Ti;

        public a(Context context, boolean z) {
            super(context, null, com.tencent.mm.ca.a.a.dropDownListViewStyle);
            this.Ti = z;
            setCacheColorHint(0);
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

        final int P(int i, int i2) {
            int listPaddingTop = getListPaddingTop();
            int listPaddingBottom = getListPaddingBottom();
            getListPaddingLeft();
            getListPaddingRight();
            int dividerHeight = getDividerHeight();
            Drawable divider = getDivider();
            ListAdapter adapter = getAdapter();
            if (adapter == null) {
                return listPaddingTop + listPaddingBottom;
            }
            listPaddingBottom += listPaddingTop;
            if (dividerHeight <= 0 || divider == null) {
                dividerHeight = 0;
            }
            int count = adapter.getCount();
            int i3 = 0;
            View view = null;
            for (int i4 = 0; i4 < count; i4++) {
                View view2;
                listPaddingTop = adapter.getItemViewType(i4);
                if (listPaddingTop != i3) {
                    i3 = listPaddingTop;
                    view2 = null;
                } else {
                    view2 = view;
                }
                view = adapter.getView(i4, view2, this);
                listPaddingTop = view.getLayoutParams().height;
                if (listPaddingTop > 0) {
                    listPaddingTop = MeasureSpec.makeMeasureSpec(listPaddingTop, 1073741824);
                } else {
                    listPaddingTop = MeasureSpec.makeMeasureSpec(0, 0);
                }
                view.measure(i, listPaddingTop);
                if (i4 > 0) {
                    listPaddingTop = listPaddingBottom + dividerHeight;
                } else {
                    listPaddingTop = listPaddingBottom;
                }
                listPaddingBottom = view.getMeasuredHeight() + listPaddingTop;
                if (listPaddingBottom >= i2) {
                    return i2;
                }
            }
            return listPaddingBottom;
        }
    }

    private class c extends DataSetObserver {
        private c() {
        }

        /* synthetic */ c(MMListPopupWindow mMListPopupWindow, byte b) {
            this();
        }

        public final void onChanged() {
            if (MMListPopupWindow.this.iqe.isShowing()) {
                MMListPopupWindow.this.show();
            }
        }

        public final void onInvalidated() {
            MMListPopupWindow.this.dismiss();
        }
    }

    public MMListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.tencent.mm.ca.a.a.listPopupWindowStyle);
    }

    public MMListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this.SM = -2;
        this.PV = -2;
        this.SR = false;
        this.SS = false;
        this.ST = Integer.MAX_VALUE;
        this.SV = 0;
        this.ykx = new f();
        this.yky = new e();
        this.ykz = new d();
        this.ykA = new b();
        this.mHandler = new ag();
        this.ey = new Rect();
        this.kgm = false;
        this.mContext = context;
        this.iqe = new q(context);
        this.iqe.setInputMethodMode(1);
        Locale locale = this.mContext.getResources().getConfiguration().locale;
    }

    public final void setAdapter(ListAdapter listAdapter) {
        if (this.mObserver == null) {
            this.mObserver = new c();
        } else if (this.FP != null) {
            this.FP.unregisterDataSetObserver(this.mObserver);
        }
        this.FP = listAdapter;
        if (this.FP != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        if (this.ykw != null) {
            this.ykw.setAdapter(this.FP);
        }
    }

    public final void cqb() {
        this.Tf = true;
        this.iqe.setFocusable(true);
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.iqe.setBackgroundDrawable(drawable);
    }

    public final void setAnimationStyle(int i) {
        this.iqe.setAnimationStyle(i);
    }

    public final void setVerticalOffset(int i) {
        this.SO = i;
        this.SQ = true;
    }

    public final void setContentWidth(int i) {
        Drawable background = this.iqe.getBackground();
        if (background != null) {
            background.getPadding(this.ey);
            this.PV = (this.ey.left + this.ey.right) + i;
            return;
        }
        this.PV = i;
    }

    public final void show() {
        int i;
        int i2;
        boolean z;
        boolean z2 = true;
        int i3 = -1;
        View frameLayout;
        if (this.ykw == null) {
            Context context = this.mContext;
            this.Te = new Runnable() {
                public final void run() {
                    View view = MMListPopupWindow.this.SW;
                    if (view != null && view.getWindowToken() != null) {
                        MMListPopupWindow.this.show();
                    }
                }
            };
            this.ykw = new a(context, !this.Tf);
            if (this.SX != null) {
                this.ykw.setSelector(this.SX);
            }
            this.ykw.setAdapter(this.FP);
            this.ykw.setOnItemClickListener(this.SY);
            this.ykw.setFocusable(true);
            this.ykw.setFocusableInTouchMode(true);
            this.ykw.setDivider(null);
            this.ykw.setDividerHeight(0);
            this.ykw.setOnItemSelectedListener(new OnItemSelectedListener() {
                public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i != -1) {
                        a a = MMListPopupWindow.this.ykw;
                        if (a != null) {
                            a.Th = false;
                        }
                    }
                }

                public final void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.ykw.setOnScrollListener(this.ykz);
            if (this.SZ != null) {
                this.ykw.setOnItemSelectedListener(this.SZ);
            }
            View view = this.ykw;
            View view2 = this.SU;
            if (view2 != null) {
                anX();
                frameLayout = new FrameLayout(context);
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                switch (this.SV) {
                    case 0:
                        layoutParams2.gravity = 48;
                        frameLayout.addView(view, layoutParams);
                        frameLayout.addView(view2, layoutParams2);
                        break;
                    case 1:
                        layoutParams2.gravity = 80;
                        frameLayout.addView(view, layoutParams);
                        frameLayout.addView(view2, layoutParams2);
                        break;
                    default:
                        new StringBuilder("Invalid hint position ").append(this.SV);
                        break;
                }
                view2.measure(MeasureSpec.makeMeasureSpec(this.PV, Integer.MIN_VALUE), 0);
            } else {
                frameLayout = view;
            }
            this.iqe.setContentView(frameLayout);
            i = 0;
        } else {
            this.iqe.getContentView();
            frameLayout = this.SU;
            i = frameLayout != null ? frameLayout.getMeasuredHeight() : 0;
        }
        Drawable background = this.iqe.getBackground();
        if (background != null) {
            background.getPadding(this.ey);
            i2 = this.ey.top + this.ey.bottom;
            if (!this.SQ) {
                this.SO = -this.ey.top;
            }
        } else {
            this.ey.setEmpty();
            i2 = 0;
        }
        if (this.iqe.getInputMethodMode() == 2) {
            z = true;
        } else {
            z = false;
        }
        View view3 = this.SW;
        int i4 = this.SO;
        Rect rect = new Rect();
        view3.getWindowVisibleDisplayFrame(rect);
        view3.getLocationOnScreen(new int[2]);
        int i5 = (z ? view3.getContext().getResources().getDisplayMetrics().heightPixels : rect.bottom) - i4;
        if (this.iqe.getBackground() != null) {
            this.iqe.getBackground().getPadding(this.ey);
            i5 -= this.ey.top + this.ey.bottom;
        }
        if (this.SR || this.SM == -1) {
            i = i5 + i2;
        } else {
            int makeMeasureSpec;
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
            i5 = this.ykw.P(makeMeasureSpec, i5 - i);
            if (i5 > 0) {
                i += i2;
            }
            i += i5;
        }
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        q qVar;
        if (this.iqe.isShowing()) {
            if (this.PV == -1) {
                i2 = -1;
            } else if (this.PV == -2) {
                i2 = this.SW.getWidth();
            } else {
                i2 = this.PV;
            }
            if (this.SM == -1) {
                if (isInputMethodNotNeeded) {
                    i5 = i;
                } else {
                    i5 = -1;
                }
                if (isInputMethodNotNeeded) {
                    qVar = this.iqe;
                    if (this.PV != -1) {
                        i3 = 0;
                    }
                    qVar.setWindowLayoutMode(i3, 0);
                    i = i5;
                } else {
                    this.iqe.setWindowLayoutMode(this.PV == -1 ? -1 : 0, -1);
                    i = i5;
                }
            } else if (this.SM != -2) {
                i = this.SM;
            }
            this.iqe.update(i2, i);
            qVar = this.iqe;
            if (this.SS || this.SR) {
                z2 = false;
            }
            qVar.setOutsideTouchable(z2);
            if (this.kgm) {
                this.iqe.showAtLocation(this.SW, 17, 0, 0);
                return;
            } else {
                this.iqe.showAtLocation(this.SW, 53, this.SN, this.SO);
                return;
            }
        }
        if (this.PV == -1) {
            i2 = -1;
        } else if (this.PV == -2) {
            this.iqe.setWidth(this.SW.getWidth());
            i2 = 0;
        } else {
            this.iqe.setWidth(this.PV);
            i2 = 0;
        }
        if (this.SM == -1) {
            i = -1;
        } else if (this.SM == -2) {
            this.iqe.setHeight(i);
            i = 0;
        } else {
            this.iqe.setHeight(this.SM);
            i = 0;
        }
        this.iqe.setWindowLayoutMode(i2, i);
        qVar = this.iqe;
        if (this.SS || this.SR) {
            z2 = false;
        }
        qVar.setOutsideTouchable(z2);
        this.iqe.setTouchInterceptor(this.yky);
        if (this.kgm) {
            this.iqe.showAtLocation(this.SW, 17, 0, 0);
        } else {
            this.iqe.showAtLocation(this.SW, 53, this.SN, this.SO);
        }
        this.ykw.setSelection(-1);
        if (!this.Tf || this.ykw.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.Tf) {
            this.mHandler.post(this.ykA);
        }
    }

    public final void dismiss() {
        this.iqe.dismiss();
        anX();
        this.iqe.setContentView(null);
        this.ykw = null;
        this.mHandler.removeCallbacks(this.ykx);
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        this.iqe.setOnDismissListener(onDismissListener);
    }

    public final void anX() {
        if (this.SU != null) {
            ViewParent parent = this.SU.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.SU);
            }
        }
    }

    public final void ff() {
        this.iqe.setInputMethodMode(2);
    }

    public final void clearListSelection() {
        a aVar = this.ykw;
        if (aVar != null) {
            aVar.Th = true;
            aVar.requestLayout();
        }
    }

    public final boolean isInputMethodNotNeeded() {
        return this.iqe.getInputMethodMode() == 2;
    }
}
