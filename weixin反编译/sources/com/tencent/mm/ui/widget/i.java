package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mm.ca.a.b;
import com.tencent.mm.ca.a.c;
import com.tencent.mm.ca.a.e;
import com.tencent.mm.ca.a.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.q;

public class i implements OnKeyListener, OnItemClickListener, OnDismissListener {
    private static int kMb;
    private static int kMc;
    private static boolean zDr = false;
    private LayoutInflater DF;
    private DisplayMetrics bpg;
    private Context mContext = null;
    private View ogD;
    public d rQG;
    private n rQH;
    private View yRt = null;
    private MMListPopupWindow yzI;
    private a zDl = null;
    private q zDm;
    private int zDn;
    private boolean zDo = false;
    public View zDp;
    public OnCreateContextMenuListener zDq;
    public boolean zDs = false;
    public OnDismissListener zwh;

    private class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(i iVar, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            return kF(i);
        }

        public final int getCount() {
            return i.this.rQH.size();
        }

        private String kF(int i) {
            return (String) ((MenuItem) i.this.rQH.ykH.get(i)).getTitle();
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            if (view == null) {
                view2 = (TextView) i.this.DF.inflate(f.dpA, viewGroup, false);
            } else {
                view2 = (TextView) view;
            }
            CharSequence kF = kF(i);
            view2.setTag(kF);
            view2.setText(kF);
            return view2;
        }
    }

    public i(Context context, View view) {
        this.mContext = context;
        this.yRt = view;
        this.DF = (LayoutInflater) context.getSystemService("layout_inflater");
        initView();
        czH();
    }

    public i(Context context) {
        this.mContext = context;
        this.DF = (LayoutInflater) context.getSystemService("layout_inflater");
        initView();
    }

    public final void c(View view, final OnCreateContextMenuListener onCreateContextMenuListener, d dVar) {
        this.yRt = view;
        czH();
        this.rQG = dVar;
        if (view instanceof AbsListView) {
            x.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView");
            ((AbsListView) view).setOnItemLongClickListener(new OnItemLongClickListener() {
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    i.this.rQH.clear();
                    x.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView long click");
                    ContextMenuInfo adapterContextMenuInfo = new AdapterContextMenuInfo(view, i, j);
                    onCreateContextMenuListener.onCreateContextMenu(i.this.rQH, view, adapterContextMenuInfo);
                    for (MenuItem menuItem : i.this.rQH.ykH) {
                        ((o) menuItem).ykK = adapterContextMenuInfo;
                    }
                    i.this.bV(0, 0);
                    return true;
                }
            });
            return;
        }
        x.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view");
        view.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                x.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view long click");
                i.this.rQH.clear();
                i.this.yRt = view;
                onCreateContextMenuListener.onCreateContextMenu(i.this.rQH, view, null);
                if (view.getTag(e.cSM) instanceof int[]) {
                    int[] iArr = (int[]) view.getTag(e.cSM);
                    i.this.bV(iArr[0], iArr[1]);
                } else {
                    i.this.bV(0, 0);
                }
                return true;
            }
        });
    }

    public final void a(View view, int i, long j, OnCreateContextMenuListener onCreateContextMenuListener, d dVar, int i2, int i3) {
        this.rQG = dVar;
        this.yRt = view;
        czH();
        this.rQH.clear();
        ContextMenuInfo adapterContextMenuInfo = new AdapterContextMenuInfo(view, i, j);
        onCreateContextMenuListener.onCreateContextMenu(this.rQH, view, adapterContextMenuInfo);
        for (MenuItem menuItem : this.rQH.ykH) {
            ((o) menuItem).ykK = adapterContextMenuInfo;
        }
        if (i2 == 0 && i3 == 0) {
            bV(0, 0);
        } else {
            bV(i2, i3);
        }
    }

    public final void a(View view, OnCreateContextMenuListener onCreateContextMenuListener, d dVar, int i, int i2) {
        this.rQG = dVar;
        this.yRt = view;
        if (!(view instanceof TextView) && (i == 0 || i2 == 0)) {
            czH();
        }
        this.rQH.clear();
        onCreateContextMenuListener.onCreateContextMenu(this.rQH, view, null);
        if (i == 0 && i2 == 0) {
            bV(0, 0);
        } else {
            bV(i, i2);
        }
    }

    private boolean fp(int i, int i2) {
        if (isShowing() || czG()) {
            return false;
        }
        if (this.zDq != null) {
            this.zDq.onCreateContextMenu(this.rQH, this.yRt, null);
        }
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(f.dpA, null);
        int count = this.zDl.getCount() * this.mContext.getResources().getDimensionPixelSize(c.bvS);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(c.zIh);
        ListAdapter listAdapter = this.zDl;
        int i3 = 0;
        View view = null;
        int i4 = 0;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count2 = listAdapter.getCount();
        int i5 = 0;
        while (i5 < count2) {
            View view2;
            int itemViewType = listAdapter.getItemViewType(i5);
            if (itemViewType != i4) {
                view2 = null;
            } else {
                itemViewType = i4;
                view2 = view;
            }
            view = listAdapter.getView(i5, view2, new FrameLayout(this.mContext));
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
            i5++;
            i4 = itemViewType;
        }
        i4 = com.tencent.mm.bu.a.ab(this.mContext, c.zIi);
        if (i3 >= i4) {
            i4 = i3;
        }
        boolean z = true;
        if (this.rQH.size() >= 3) {
            z = false;
        }
        if (!this.zDo) {
            if (this.zDp != null) {
                this.zDp.setSelected(true);
            } else {
                this.yRt.setSelected(true);
            }
        }
        if (this.zDs) {
            fq(i, i2);
        } else {
            com.tencent.mm.ui.base.aa.a a = aa.a(this.mContext, i4, i, i2, count, dimensionPixelSize, z);
            this.zDn = i2 - this.mContext.getResources().getDimensionPixelSize(c.zIh);
            x.d("MicroMsg.MMPopupMenu", "showPointY=" + i2 + "verticalOffset=" + this.zDn);
            this.yzI = new MMListPopupWindow(this.mContext, null, 0);
            this.yzI.setOnDismissListener(this);
            this.yzI.SY = new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i.this.rQG != null) {
                        i.this.rQG.onMMMenuItemSelected(i.this.rQH.getItem(i), i);
                    }
                    if (i.this.yzI != null && i.this.yzI.iqe.isShowing()) {
                        i.this.yzI.dismiss();
                    }
                }
            };
            this.yzI.setAdapter(this.zDl);
            this.yzI.cqb();
            this.yzI.setBackgroundDrawable(this.mContext.getResources().getDrawable(com.tencent.mm.ca.a.d.bGz));
            this.yzI.setAnimationStyle(a.ypU);
            this.yzI.SN = a.khb;
            this.yzI.setVerticalOffset(a.rSS);
            this.yzI.SW = this.yRt;
            this.yzI.setContentWidth(i4);
            this.yzI.ff();
            this.yzI.show();
            this.yzI.ykw.setOnKeyListener(this);
            this.yzI.ykw.setDivider(new ColorDrawable(this.mContext.getResources().getColor(b.btR)));
            this.yzI.ykw.setSelector(this.mContext.getResources().getDrawable(com.tencent.mm.ca.a.d.bEK));
            this.yzI.ykw.setDividerHeight(0);
            this.yzI.ykw.setVerticalScrollBarEnabled(false);
            this.yzI.ykw.setHorizontalScrollBarEnabled(false);
        }
        return true;
    }

    private void fq(int i, int i2) {
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(c.bvK);
        int dimensionPixelOffset2 = this.mContext.getResources().getDimensionPixelOffset(c.bvw);
        this.zDm = new q(this.mContext);
        this.zDm.setWidth(-2);
        this.zDm.setHeight(-2);
        this.zDm.setBackgroundDrawable(this.mContext.getResources().getDrawable(com.tencent.mm.ca.a.d.bGz));
        View linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundColor(this.mContext.getResources().getColor(b.white));
        for (int i3 = 0; i3 < this.rQH.size(); i3++) {
            TextView textView = (TextView) this.DF.inflate(f.zIA, null, false);
            textView.setBackground(this.mContext.getResources().getDrawable(com.tencent.mm.ca.a.d.bEK));
            if (i3 == 0) {
                textView.setPadding(dimensionPixelOffset2, 0, dimensionPixelOffset, 0);
            } else if (i3 == this.rQH.size() - 1) {
                textView.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset2, 0);
            }
            textView.setText(((MenuItem) this.rQH.ykH.get(i3)).getTitle());
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (i.this.rQG != null) {
                        i.this.rQG.onMMMenuItemSelected(i.this.rQH.getItem(i3), i3);
                    }
                    i.this.zDm.dismiss();
                }
            });
            linearLayout.addView(textView);
        }
        linearLayout.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = linearLayout.getMeasuredHeight();
        this.zDm.setContentView(linearLayout);
        this.zDm.showAtLocation(this.yRt, 0, i, i2 - measuredHeight);
    }

    private boolean isShowing() {
        return this.yzI != null && this.yzI.iqe.isShowing();
    }

    private boolean czG() {
        return this.zDm != null && this.zDm.isShowing();
    }

    public final boolean csc() {
        if (isShowing()) {
            if (this.yzI == null) {
                return true;
            }
            this.yzI.dismiss();
            return true;
        } else if (!czG()) {
            return false;
        } else {
            if (this.zDm == null) {
                return true;
            }
            this.zDm.dismiss();
            return true;
        }
    }

    public boolean bV(int i, int i2) {
        int i3;
        if (!((this.yRt.equals(this.ogD) && zDr) || (i == 0 && i2 == 0))) {
            kMb = i;
            kMc = i2;
        }
        this.ogD = null;
        int i4 = kMb;
        int i5 = kMc;
        zDr = false;
        if (this.bpg == null) {
            this.bpg = this.mContext.getResources().getDisplayMetrics();
        }
        if (this.yRt != null) {
            int[] iArr = new int[2];
            this.yRt.getLocationOnScreen(iArr);
            if (i4 == 0) {
                i4 = iArr[0] + (this.yRt.getWidth() / 2);
            }
            i3 = iArr[1];
            int height = iArr[1] + this.yRt.getHeight();
            if (i3 < 0) {
                i3 = 0;
            }
            if (height > this.bpg.heightPixels) {
                height = this.bpg.heightPixels;
            }
            if (i5 == 0) {
                int i6 = (i3 + height) / 2;
                i3 = i4;
                i4 = i6;
                x.i("MicroMsg.MMPopupMenu", "show popMenu , xDown:%s, yDown:%s, showPointX:%s, showPointY:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                if (isShowing() || !czG()) {
                    return fp(i3, i4);
                }
                return fp(i3, i4) & csc();
            }
        }
        i3 = i4;
        i4 = i5;
        x.i("MicroMsg.MMPopupMenu", "show popMenu , xDown:%s, yDown:%s, showPointX:%s, showPointY:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (isShowing()) {
        }
        return fp(i3, i4);
    }

    private void initView() {
        csc();
        this.rQH = new n();
        this.zDl = new a();
        this.bpg = this.mContext.getResources().getDisplayMetrics();
    }

    private void czH() {
        this.yRt.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        i.kMb = (int) motionEvent.getRawX();
                        i.kMc = (int) motionEvent.getRawY();
                        i.this.ogD = i.this.yRt;
                        i.zDr = true;
                        x.i("MicroMsg.MMPopupMenu", "popmenu view set , x_down=" + i.kMb + "y_down=" + i.kMc);
                        break;
                }
                return false;
            }
        });
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        return false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public void onDismiss() {
        if (!this.zDo) {
            if (this.zDp != null) {
                this.zDp.setSelected(false);
            } else {
                this.yRt.setSelected(false);
            }
        }
        if (this.zwh != null) {
            this.zwh.onDismiss();
        }
    }
}
