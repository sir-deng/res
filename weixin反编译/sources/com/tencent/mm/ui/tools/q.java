package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.v.a.d;
import com.tencent.mm.v.a.e;
import com.tencent.mm.v.a.f;
import com.tencent.mm.v.a.l;

public abstract class q implements OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener {
    private int LZ;
    private ViewTreeObserver Md;
    private ViewGroup Me;
    private int dividerHeight;
    private View hH;
    private BaseAdapter kUZ;
    private boolean kgm = false;
    protected Context mContext;
    private boolean tMG = false;
    private MMListPopupWindow yzI;
    private int yzJ = l.haz;
    private OnCancelListener zwg;
    private OnDismissListener zwh;
    private boolean zwi = true;
    private View zwj;
    private int zwk;
    private int zwl = 0;
    private int zwm = 0;
    private int zwn = 0;
    private float zwo = 0.0f;
    private float zwp = 0.0f;

    public abstract BaseAdapter atB();

    public q(Context context) {
        this.mContext = context;
        Resources resources = context.getResources();
        this.LZ = Math.min((resources.getDisplayMetrics().widthPixels * 4) / 5, resources.getDimensionPixelSize(e.abc_config_prefDialogWidth));
        if (this.mContext instanceof Activity) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) this.mContext).getWindow().getDecorView();
            if (viewGroup.getChildCount() > 0) {
                this.hH = viewGroup.getChildAt(0);
            } else {
                this.hH = viewGroup;
            }
        }
        this.dividerHeight = b.b(this.mContext, 1.0f);
        this.zwl = resources.getDimensionPixelSize(e.bvK) * 2;
        this.zwm = resources.getDimensionPixelSize(e.bvS);
        this.zwn = b.b(this.mContext, 36.0f);
        this.kUZ = atB();
    }

    public final void nD(boolean z) {
        this.kgm = z;
        if (z) {
            this.yzJ = l.hay;
        } else {
            this.yzJ = l.haz;
        }
    }

    public boolean dN() {
        int height;
        boolean z;
        Rect rect = new Rect();
        if (this.mContext instanceof ActionBarActivity) {
            height = ((ActionBarActivity) this.mContext).getSupportActionBar().getHeight();
        } else {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            height = displayMetrics.widthPixels > displayMetrics.heightPixels ? b.b(this.mContext, 40.0f) : b.b(this.mContext, 49.0f);
        }
        int dimensionPixelSize = height - this.mContext.getResources().getDimensionPixelSize(e.bvK);
        if (this.mContext instanceof Activity) {
            ((Activity) this.mContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int height2 = ((Activity) this.mContext).getWindow().getDecorView().getHeight();
            int[] iArr = new int[2];
            ((Activity) this.mContext).getWindow().getDecorView().getLocationOnScreen(iArr);
            if (height2 - rect.height() < 0 || iArr[1] <= 200) {
                height = rect.top + dimensionPixelSize;
            } else {
                height = (height2 - rect.height()) + dimensionPixelSize;
            }
        } else {
            height = dimensionPixelSize;
        }
        this.tMG = baC();
        if (this.yzI == null || true == this.zwi) {
            this.yzI = new MMListPopupWindow(this.mContext, null, 0);
        }
        this.yzI.setOnDismissListener(this);
        this.yzI.SY = this;
        this.yzI.setAdapter(this.kUZ);
        this.yzI.cqb();
        this.yzI.setBackgroundDrawable(this.mContext.getResources().getDrawable(f.gWF));
        this.yzI.setAnimationStyle(this.yzJ);
        this.yzI.SN = 0;
        this.yzI.SW = this.hH;
        if (this.hH != null) {
            z = this.Md == null;
            this.Md = this.hH.getViewTreeObserver();
            x.v("MicroMsg.SubMenuHelperBase", "tryshow addGlobalListener:%b", Boolean.valueOf(z));
            if (z) {
                this.Md.addOnGlobalLayoutListener(this);
            }
        }
        this.yzI.setVerticalOffset(height);
        this.yzI.kgm = this.kgm;
        this.yzI.setContentWidth(Math.min(b(this.kUZ), this.LZ));
        this.yzI.ff();
        if (!(this.zwo == 0.0f || this.zwp == 0.0f)) {
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            ((Activity) this.mContext).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics2);
            z = displayMetrics2.widthPixels > displayMetrics2.heightPixels;
            Rect rect2 = new Rect();
            ((Activity) this.mContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect2);
            height = ((Activity) this.mContext).getWindow().getDecorView().getHeight();
            int height3 = height > rect2.height() ? rect2.height() : height;
            x.d("MicroMsg.SubMenuHelperBase", "menuHeightPercentPort(%f), menuHeightPercentLand(%f), frameHeight(%d), decorViewHeight(%d), menuHeight(%d)", Float.valueOf(this.zwo), Float.valueOf(this.zwp), Integer.valueOf(rect2.height()), Integer.valueOf(height3), Integer.valueOf(z ? (int) (this.zwp * ((float) height3)) : (int) (this.zwo * ((float) height3))));
            height = Math.round((float) (height / this.zwm));
            if (height <= 0 || this.kUZ == null) {
                x.e("MicroMsg.SubMenuHelperBase", "[cpan] setpopuHeight error.");
            } else {
                dimensionPixelSize = (this.zwm * height) + this.zwl;
                if (dimensionPixelSize == 0 || dimensionPixelSize >= this.kUZ.getCount() * this.zwm) {
                    x.w("MicroMsg.SubMenuHelperBase", "[cpan] menuheight:%d,listHeight:%d", Integer.valueOf(dimensionPixelSize), Integer.valueOf(this.kUZ.getCount() * this.zwm));
                } else {
                    this.yzI.SM = (((height - 1) * this.zwm) + this.zwl) + this.zwn;
                }
            }
        }
        if (!(this.yzI == null || this.zwj == null)) {
            MMListPopupWindow mMListPopupWindow = this.yzI;
            View view = this.zwj;
            boolean isShowing = mMListPopupWindow.iqe.isShowing();
            if (isShowing) {
                mMListPopupWindow.anX();
            }
            mMListPopupWindow.SU = view;
            if (isShowing) {
                mMListPopupWindow.show();
            }
            this.yzI.SV = this.zwk;
        }
        this.yzI.show();
        this.yzI.ykw.setOnKeyListener(this);
        this.yzI.ykw.setSelector(new ColorDrawable(this.mContext.getResources().getColor(d.transparent)));
        this.yzI.ykw.setDividerHeight(0);
        this.yzI.ykw.setVerticalScrollBarEnabled(true);
        this.yzI.ykw.setHorizontalScrollBarEnabled(false);
        return true;
    }

    private boolean baC() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return true;
        }
        return false;
    }

    public final void dismiss() {
        if (isShowing()) {
            this.yzI.dismiss();
        }
    }

    private int b(ListAdapter listAdapter) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i = 0;
        int i2 = 0;
        View view = null;
        int i3 = 0;
        while (i < count) {
            View view2;
            int itemViewType = listAdapter.getItemViewType(i);
            if (itemViewType != i2) {
                view2 = null;
            } else {
                itemViewType = i2;
                view2 = view;
            }
            if (this.Me == null) {
                this.Me = new FrameLayout(this.mContext);
            }
            view = listAdapter.getView(i, view2, this.Me);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
            i++;
            i2 = itemViewType;
        }
        return i3;
    }

    public void onDismiss() {
        this.yzI = null;
        if (this.Md != null) {
            if (!this.Md.isAlive()) {
                this.Md = this.hH.getViewTreeObserver();
            }
            this.Md.removeGlobalOnLayoutListener(this);
            this.Md = null;
        }
        if (this.zwg != null) {
            this.zwg.onCancel(null);
        }
        if (this.zwh != null) {
            this.zwh.onDismiss();
        }
    }

    public final boolean isShowing() {
        return this.yzI != null && this.yzI.iqe.isShowing();
    }

    public void onGlobalLayout() {
        x.v("MicroMsg.SubMenuHelperBase", "onGlobalLayout showing:%b, anchorshown:%b", Boolean.valueOf(isShowing()), Boolean.valueOf(this.hH.isShown()));
        if (isShowing()) {
            View view = this.hH;
            if (view == null || !view.isShown()) {
                dismiss();
            } else if (isShowing() && this.tMG != baC()) {
                this.yzI.dismiss();
            }
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        x.v("MicroMsg.SubMenuHelperBase", "onKey");
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        dismiss();
    }
}
