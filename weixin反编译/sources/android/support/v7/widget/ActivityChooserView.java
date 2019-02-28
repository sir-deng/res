package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.d;
import android.support.v4.view.z;
import android.support.v7.a.a.f;
import android.support.v7.a.a.h;
import android.support.v7.a.a.i;
import android.support.v7.a.a.k;
import android.support.v7.widget.d.c;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.wcdb.database.SQLiteGlobal;

public class ActivityChooserView extends ViewGroup {
    private final ImageView OA;
    private final int OB;
    d OC;
    private final DataSetObserver OD;
    private final OnGlobalLayoutListener OE;
    private ListPopupWindow OF;
    private OnDismissListener OG;
    boolean OH;
    int OI;
    private int OJ;
    private final a Ot;
    private final b Ou;
    private final LinearLayoutCompat Ov;
    private final Drawable Ow;
    private final FrameLayout Ox;
    private final ImageView Oy;
    private final FrameLayout Oz;
    boolean hq;

    public static class InnerLayout extends LinearLayoutCompat {
        private static final int[] KP = new int[]{16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            ap a = ap.a(context, attributeSet, KP);
            setBackgroundDrawable(a.getDrawable(0));
            a.Zu.recycle();
        }
    }

    private class b implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
        private b() {
        }

        /* synthetic */ b(ActivityChooserView activityChooserView, byte b) {
            this();
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((a) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    ActivityChooserView.this.eo();
                    if (!ActivityChooserView.this.OH) {
                        if (!ActivityChooserView.this.Ot.OO) {
                            i++;
                        }
                        Intent aK = ActivityChooserView.this.Ot.OL.aK(i);
                        if (aK != null) {
                            aK.addFlags(SQLiteGlobal.journalSizeLimit);
                            ActivityChooserView.this.getContext().startActivity(aK);
                            return;
                        }
                        return;
                    } else if (i > 0) {
                        d dVar = ActivityChooserView.this.Ot.OL;
                        synchronized (dVar.Og) {
                            dVar.ei();
                            android.support.v7.widget.d.a aVar = (android.support.v7.widget.d.a) dVar.Oh.get(i);
                            android.support.v7.widget.d.a aVar2 = (android.support.v7.widget.d.a) dVar.Oh.get(0);
                            dVar.a(new c(new ComponentName(aVar.resolveInfo.activityInfo.packageName, aVar.resolveInfo.activityInfo.name), System.currentTimeMillis(), aVar2 != null ? (aVar2.weight - aVar.weight) + 5.0f : 1.0f));
                        }
                        return;
                    } else {
                        return;
                    }
                case 1:
                    ActivityChooserView.this.aL(Integer.MAX_VALUE);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public final void onClick(View view) {
            if (view == ActivityChooserView.this.Oz) {
                ActivityChooserView.this.eo();
                Intent aK = ActivityChooserView.this.Ot.OL.aK(ActivityChooserView.this.Ot.OL.a(ActivityChooserView.this.Ot.OL.eh()));
                if (aK != null) {
                    aK.addFlags(SQLiteGlobal.journalSizeLimit);
                    ActivityChooserView.this.getContext().startActivity(aK);
                }
            } else if (view == ActivityChooserView.this.Ox) {
                ActivityChooserView.this.OH = false;
                ActivityChooserView.this.aL(ActivityChooserView.this.OI);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public final boolean onLongClick(View view) {
            if (view == ActivityChooserView.this.Oz) {
                if (ActivityChooserView.this.Ot.getCount() > 0) {
                    ActivityChooserView.this.OH = true;
                    ActivityChooserView.this.aL(ActivityChooserView.this.OI);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        public final void onDismiss() {
            if (ActivityChooserView.this.OG != null) {
                ActivityChooserView.this.OG.onDismiss();
            }
            if (ActivityChooserView.this.OC != null) {
                ActivityChooserView.this.OC.q(false);
            }
        }
    }

    private class a extends BaseAdapter {
        d OL;
        private int OM;
        boolean OO;
        private boolean OP;
        private boolean OQ;

        private a() {
            this.OM = 4;
        }

        /* synthetic */ a(ActivityChooserView activityChooserView, byte b) {
            this();
        }

        public final int getItemViewType(int i) {
            if (this.OQ && i == getCount() - 1) {
                return 1;
            }
            return 0;
        }

        public final int getViewTypeCount() {
            return 3;
        }

        public final int getCount() {
            int eg = this.OL.eg();
            if (!(this.OO || this.OL.eh() == null)) {
                eg--;
            }
            eg = Math.min(eg, this.OM);
            if (this.OQ) {
                return eg + 1;
            }
            return eg;
        }

        public final Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!(this.OO || this.OL.eh() == null)) {
                        i++;
                    }
                    return this.OL.aJ(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != f.list_item) {
                        view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(h.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    ((ImageView) view.findViewById(f.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(f.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (this.OO && i == 0 && this.OP) {
                        z.b(view, true);
                        return view;
                    }
                    z.b(view, false);
                    return view;
                case 1:
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(h.abc_activity_chooser_view_list_item, viewGroup, false);
                    view.setId(1);
                    ((TextView) view.findViewById(f.title)).setText(ActivityChooserView.this.getContext().getString(i.abc_activity_chooser_view_see_all));
                    return view;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public final int er() {
            int i = 0;
            int i2 = this.OM;
            this.OM = Integer.MAX_VALUE;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i3 = 0;
            while (i < count) {
                view = getView(i, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 = Math.max(i3, view.getMeasuredWidth());
                i++;
            }
            this.OM = i2;
            return i3;
        }

        public final void aM(int i) {
            if (this.OM != i) {
                this.OM = i;
                notifyDataSetChanged();
            }
        }

        public final void M(boolean z) {
            if (this.OQ != z) {
                this.OQ = z;
                notifyDataSetChanged();
            }
        }

        public final void d(boolean z, boolean z2) {
            if (this.OO != z || this.OP != z2) {
                this.OO = z;
                this.OP = z2;
                notifyDataSetChanged();
            }
        }
    }

    static /* synthetic */ void c(ActivityChooserView activityChooserView) {
        if (activityChooserView.Ot.getCount() > 0) {
            activityChooserView.Ox.setEnabled(true);
        } else {
            activityChooserView.Ox.setEnabled(false);
        }
        int eg = activityChooserView.Ot.OL.eg();
        int historySize = activityChooserView.Ot.OL.getHistorySize();
        if (eg == 1 || (eg > 1 && historySize > 0)) {
            activityChooserView.Oz.setVisibility(0);
            ResolveInfo eh = activityChooserView.Ot.OL.eh();
            PackageManager packageManager = activityChooserView.getContext().getPackageManager();
            activityChooserView.OA.setImageDrawable(eh.loadIcon(packageManager));
            if (activityChooserView.OJ != 0) {
                CharSequence loadLabel = eh.loadLabel(packageManager);
                activityChooserView.Oz.setContentDescription(activityChooserView.getContext().getString(activityChooserView.OJ, new Object[]{loadLabel}));
            }
        } else {
            activityChooserView.Oz.setVisibility(8);
        }
        if (activityChooserView.Oz.getVisibility() == 0) {
            activityChooserView.Ov.setBackgroundDrawable(activityChooserView.Ow);
        } else {
            activityChooserView.Ov.setBackgroundDrawable(null);
        }
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.OD = new DataSetObserver() {
            public final void onChanged() {
                super.onChanged();
                ActivityChooserView.this.Ot.notifyDataSetChanged();
            }

            public final void onInvalidated() {
                super.onInvalidated();
                ActivityChooserView.this.Ot.notifyDataSetInvalidated();
            }
        };
        this.OE = new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                if (!ActivityChooserView.this.ep()) {
                    return;
                }
                if (ActivityChooserView.this.isShown()) {
                    ActivityChooserView.this.eq().show();
                    if (ActivityChooserView.this.OC != null) {
                        ActivityChooserView.this.OC.q(true);
                        return;
                    }
                    return;
                }
                ActivityChooserView.this.eq().dismiss();
            }
        };
        this.OI = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.ActivityChooserView, i, 0);
        this.OI = obtainStyledAttributes.getInt(k.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(k.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(h.abc_activity_chooser_view, this, true);
        this.Ou = new b();
        this.Ov = (LinearLayoutCompat) findViewById(f.activity_chooser_view_content);
        this.Ow = this.Ov.getBackground();
        this.Oz = (FrameLayout) findViewById(f.default_activity_button);
        this.Oz.setOnClickListener(this.Ou);
        this.Oz.setOnLongClickListener(this.Ou);
        this.OA = (ImageView) this.Oz.findViewById(f.image);
        FrameLayout frameLayout = (FrameLayout) findViewById(f.expand_activities_button);
        frameLayout.setOnClickListener(this.Ou);
        frameLayout.setOnTouchListener(new android.support.v7.widget.ListPopupWindow.b(frameLayout) {
            public final ListPopupWindow dq() {
                return ActivityChooserView.this.eq();
            }

            protected final boolean dr() {
                ActivityChooserView activityChooserView = ActivityChooserView.this;
                if (!activityChooserView.ep() && activityChooserView.hq) {
                    activityChooserView.OH = false;
                    activityChooserView.aL(activityChooserView.OI);
                }
                return true;
            }

            protected final boolean ec() {
                ActivityChooserView.this.eo();
                return true;
            }
        });
        this.Ox = frameLayout;
        this.Oy = (ImageView) frameLayout.findViewById(f.image);
        this.Oy.setImageDrawable(drawable);
        this.Ot = new a();
        this.Ot.registerDataSetObserver(new DataSetObserver() {
            public final void onChanged() {
                super.onChanged();
                ActivityChooserView.c(ActivityChooserView.this);
            }
        });
        Resources resources = context.getResources();
        this.OB = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(android.support.v7.a.a.d.abc_config_prefDialogWidth));
    }

    final void aL(int i) {
        if (this.Ot.OL == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.OE);
        boolean z = this.Oz.getVisibility() == 0;
        int eg = this.Ot.OL.eg();
        int i2;
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i == Integer.MAX_VALUE || eg <= i2 + i) {
            this.Ot.M(false);
            this.Ot.aM(i);
        } else {
            this.Ot.M(true);
            this.Ot.aM(i - 1);
        }
        ListPopupWindow eq = eq();
        if (!eq.SK.isShowing()) {
            if (this.OH || !z) {
                this.Ot.d(true, z);
            } else {
                this.Ot.d(false, false);
            }
            eq.setContentWidth(Math.min(this.Ot.er(), this.OB));
            eq.show();
            if (this.OC != null) {
                this.OC.q(true);
            }
            eq.SL.setContentDescription(getContext().getString(i.abc_activitychooserview_choose_application));
        }
    }

    public final boolean eo() {
        if (eq().SK.isShowing()) {
            eq().dismiss();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.OE);
            }
        }
        return true;
    }

    public final boolean ep() {
        return eq().SK.isShowing();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d dVar = this.Ot.OL;
        if (dVar != null) {
            dVar.registerObserver(this.OD);
        }
        this.hq = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVar = this.Ot.OL;
        if (dVar != null) {
            dVar.unregisterObserver(this.OD);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.OE);
        }
        if (ep()) {
            eo();
        }
        this.hq = false;
    }

    protected void onMeasure(int i, int i2) {
        View view = this.Ov;
        if (this.Oz.getVisibility() != 0) {
            i2 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.Ov.layout(0, 0, i3 - i, i4 - i2);
        if (!ep()) {
            eo();
        }
    }

    private ListPopupWindow eq() {
        if (this.OF == null) {
            this.OF = new ListPopupWindow(getContext());
            this.OF.setAdapter(this.Ot);
            this.OF.SW = this;
            this.OF.setModal(true);
            this.OF.SY = this.Ou;
            this.OF.setOnDismissListener(this.Ou);
        }
        return this.OF;
    }
}
