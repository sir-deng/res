package com.tencent.mm.ui.conversation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Configuration;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Vibrator;
import android.support.v4.view.ae;
import android.support.v4.view.o;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.k;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ListView.FixedViewInfo;
import com.tencent.mm.R;
import com.tencent.mm.f.a.if;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.appbrand.GyroView;
import com.tencent.mm.ui.v;
import com.tencent.mm.y.as;
import com.tencent.smtt.sdk.WebView;
import java.util.Iterator;
import java.util.LinkedList;

public class ConversationWithAppBrandListView extends ListView implements OnScrollListener, b {
    private int Us = -1;
    private int Ut;
    private int Uu;
    private ValueAnimator fde;
    private boolean hasInit = false;
    private int iN;
    private boolean isInit = true;
    private View klX;
    private float lJL;
    private float lJM;
    private Vibrator lrS;
    private OnScrollListener omt;
    private boolean qir = false;
    private float yev;
    private LinkedList<FixedViewInfo> zgJ = new LinkedList();
    private View zgK;
    View zgL;
    AppBrandRecentView zgM;
    private boolean zgN = false;
    private Paint zgO;
    private Paint zgP;
    private com.tencent.mm.plugin.appbrand.widget.recentview.b zgQ;
    private String zgR;
    private float zgS;
    boolean zgT = false;
    final c<if> zgU = new c<if>() {
        {
            this.xmG = if.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if ifVar = (if) bVar;
            ConversationWithAppBrandListView.this.A((long) ifVar.fzx.delay, ifVar.fzx.type);
            return true;
        }
    };
    private View zgV;
    private a zgW = new a();
    private int zgX = 0;
    private float zgY;
    private float zgZ;
    private float zha = 0.0f;
    private float zhb = 0.0f;
    private boolean zhc;
    private boolean zhd = false;
    private boolean zhe;
    private boolean zhf = false;
    private boolean zhg = false;
    private Runnable zhh;
    private Runnable zhi = new Runnable() {
        public final void run() {
            ConversationWithAppBrandListView.this.qir = false;
            ConversationWithAppBrandListView.this.zhj = true;
            ConversationWithAppBrandListView.this.nn(true);
        }
    };
    private boolean zhj = false;
    private boolean zhk = false;
    private int zhl;

    /* renamed from: com.tencent.mm.ui.conversation.ConversationWithAppBrandListView$4 */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ boolean zhr;

        AnonymousClass4(boolean z) {
            this.zhr = z;
        }

        public final void run() {
            ConversationWithAppBrandListView.this.setSelection(0);
            ConversationWithAppBrandListView.this.postDelayed(new Runnable() {
                public final void run() {
                    if (AnonymousClass4.this.zhr) {
                        ConversationWithAppBrandListView.this.zhf = true;
                        ConversationWithAppBrandListView.this.GJ(MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN);
                        ConversationWithAppBrandListView.this.postDelayed(new Runnable() {
                            public final void run() {
                                ConversationWithAppBrandListView.this.zhf = false;
                            }
                        }, 2000);
                        return;
                    }
                    super.setSelection(0);
                }
            }, 666);
        }
    }

    class a implements Runnable {
        a() {
        }

        public final void run() {
            View childAt = ConversationWithAppBrandListView.this.getChildAt(0);
            if (ConversationWithAppBrandListView.this.getFirstVisiblePosition() == 0 && childAt != null && childAt.getTop() < 0) {
                x.i("MicroMsg.ConversationWithAppBrandListView", "[UpAppBrandHeaderTask] run...");
                if (((float) childAt.getBottom()) >= ConversationWithAppBrandListView.this.yev) {
                    ConversationWithAppBrandListView.this.GJ(250);
                } else {
                    ConversationWithAppBrandListView.this.GK(0);
                }
            }
        }
    }

    public ConversationWithAppBrandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setAdapter(final ListAdapter listAdapter) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[init] ");
        this.zgU.cfB();
        this.lrS = (Vibrator) getContext().getSystemService("vibrator");
        this.iN = ae.a(ViewConfiguration.get(getContext()));
        this.zgO = new Paint(1);
        this.zgP = new Paint(1);
        this.zgO.setColor(getResources().getColor(R.e.bru));
        this.zgP.setColor(WebView.NIGHT_MODE_COLOR);
        this.zgP.setAlpha(0);
        this.zgP.setTextSize(getResources().getDimension(R.f.bvX));
        nr(false);
        if (g.h(d.class) != null) {
            this.zgQ = ((d) g.h(d.class)).amQ();
        }
        this.yev = 100.0f * getResources().getDisplayMetrics().density;
        this.zgR = getResources().getString(R.l.dXQ);
        this.zgS = this.zgP.measureText(this.zgR);
        super.setOnScrollListener(this);
        listAdapter.registerDataSetObserver(new DataSetObserver() {
            int zhm = -1;

            public final void onChanged() {
                if (this.zhm != listAdapter.getCount()) {
                    String str = "MicroMsg.ConversationWithAppBrandListView";
                    String str2 = "[onChanged] isDelete:%s";
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(this.zhm > listAdapter.getCount());
                    x.i(str, str2, objArr);
                    if (this.zhm > listAdapter.getCount()) {
                        ConversationWithAppBrandListView.this.nm(false);
                        ConversationWithAppBrandListView.this.nm(true);
                    } else {
                        ConversationWithAppBrandListView.this.nm(true);
                    }
                }
                this.zhm = listAdapter.getCount();
            }
        });
        cxn();
        View linearLayout = new LinearLayout(getContext());
        this.zgV = new View(getContext());
        this.zgV.setLayoutParams(new LayoutParams(-1, 0));
        linearLayout.addView(this.zgV);
        linearLayout.setBackgroundColor(getContext().getResources().getColor(R.e.white));
        addFooterView(linearLayout);
        super.setAdapter(listAdapter);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && nr(true) && this.isInit) {
            nm(true);
            this.isInit = false;
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        x.i("MicroMsg.ConversationWithAppBrandListView", "[onConfigurationChanged] orientation:%s", Integer.valueOf(configuration.orientation));
        this.zgT = true;
        nm(true);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (getFirstVisiblePosition() != 0) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int d = o.d(motionEvent);
        int e = o.e(motionEvent);
        switch (d) {
            case 0:
                this.Us = o.c(motionEvent, 0);
                this.Ut = (int) (motionEvent.getX() + 0.5f);
                this.Uu = (int) (motionEvent.getY() + 0.5f);
                return super.onInterceptTouchEvent(motionEvent);
            case 2:
                d = o.b(motionEvent, this.Us);
                if (d < 0) {
                    return false;
                }
                boolean z;
                e = (int) (o.d(motionEvent, d) + 0.5f);
                e -= this.Ut;
                d = ((int) (o.e(motionEvent, d) + 0.5f)) - this.Uu;
                if (Math.abs(d) <= this.iN || Math.abs(d) < Math.abs(e)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z && super.onInterceptTouchEvent(motionEvent)) {
                    return true;
                }
                return false;
            case 5:
                this.Us = o.c(motionEvent, e);
                this.Ut = (int) (o.d(motionEvent, e) + 0.5f);
                this.Uu = (int) (o.e(motionEvent, e) + 0.5f);
                return super.onInterceptTouchEvent(motionEvent);
            default:
                return super.onInterceptTouchEvent(motionEvent);
        }
    }

    public void addHeaderView(View view, Object obj, boolean z) {
        FixedViewInfo fixedViewInfo = new FixedViewInfo(this);
        fixedViewInfo.view = view;
        fixedViewInfo.data = obj;
        fixedViewInfo.isSelectable = z;
        this.zgJ.add(fixedViewInfo);
        if (getAdapter() != null) {
            super.addHeaderView(fixedViewInfo.view, fixedViewInfo.data, fixedViewInfo.isSelectable);
        }
    }

    public void setOnItemClickListener(final OnItemClickListener onItemClickListener) {
        super.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(adapterView, view, i, j);
                }
                if (ConversationWithAppBrandListView.this.nr(true) && ConversationWithAppBrandListView.this.getFirstVisiblePosition() == 0) {
                    ConversationWithAppBrandListView.this.A(500, 8);
                }
            }
        });
    }

    public void setOnItemLongClickListener(final OnItemLongClickListener onItemLongClickListener) {
        super.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if ((i == 0 && ConversationWithAppBrandListView.this.nr(true)) || onItemLongClickListener == null) {
                    return false;
                }
                return onItemLongClickListener.onItemLongClick(adapterView, view, i, j);
            }
        });
    }

    public final void cmo() {
        if (getFirstVisiblePosition() > cxq() + 16) {
            setSelection(cxq() + 16);
        }
        post(new Runnable() {
            public final void run() {
                ConversationWithAppBrandListView.this.smoothScrollToPositionFromTop(0, 0, 300);
            }
        });
    }

    public final void A(long j, int i) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[hideAppBrandRecentView] delay:%s", Long.valueOf(j));
        if (nr(true)) {
            if (getFirstVisiblePosition() == 0) {
                if (!(this.zgQ == null || this.zgM == null)) {
                    this.zgQ.cd(Math.max(0, this.zgM.getCount() - 1), i);
                }
                if (j > 0) {
                    postDelayed(new Runnable() {
                        public final void run() {
                            if (ConversationWithAppBrandListView.this.zgM != null) {
                                ConversationWithAppBrandListView.this.zgM.smoothScrollToPosition(0);
                            }
                            View childAt = ConversationWithAppBrandListView.this.getChildAt(0);
                            int bottom = childAt == null ? 0 : childAt.getBottom();
                            if (bottom != 0) {
                                ConversationWithAppBrandListView.this.smoothScrollBy(bottom, 0);
                            }
                            ConversationWithAppBrandListView.this.setSelection(0);
                        }
                    }, j);
                } else {
                    if (this.zgM != null) {
                        this.zgM.smoothScrollToPosition(0);
                    }
                    setSelection(0);
                }
                cxp();
            }
        } else if (this.zgL != null) {
            this.zgL.setVisibility(8);
        }
    }

    public final void mK(int i) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[onDone] size:%s isAppBrandHeaderEnable:%s", Integer.valueOf(i), Boolean.valueOf(this.zgN));
        if (nr(true)) {
            if (i == 1 && this.zgL != null) {
                no(true);
            } else if (i > 1 && this.zgL != null) {
                no(false);
            }
            if (this.zgL != null && this.zgL.getVisibility() == 8) {
                this.zgL.setVisibility(0);
                setSelection(getFirstVisiblePosition());
                return;
            }
            return;
        }
        x.w("MicroMsg.ConversationWithAppBrandListView", "[onDone] is disable!");
        if (this.zgL != null) {
            this.zgL.setVisibility(8);
        }
    }

    final void nm(boolean z) {
        if (this.zgV != null && nr(true)) {
            if (z) {
                postDelayed(new Runnable() {
                    public final void run() {
                        ConversationWithAppBrandListView.this.cxm();
                    }
                }, 60);
            } else {
                cxm();
            }
        }
    }

    private void cxm() {
        boolean z;
        int cxq = cxq();
        LayoutParams layoutParams = (LayoutParams) this.zgV.getLayoutParams();
        int i = layoutParams.height;
        int count = getAdapter() == null ? 0 : getAdapter().getCount();
        x.d("MicroMsg.ConversationWithAppBrandListView", "[isFull] totalItemCount:" + count + " getFirstVisiblePosition:" + getFirstVisiblePosition() + " getLastVisiblePosition:" + getLastVisiblePosition() + " getHeaderViewsCount:" + getHeaderViewsCount() + " getFooterViewsCount:" + getFooterViewsCount());
        float measuredHeight = (float) (getMeasuredHeight() - (((int) getResources().getDimension(R.f.bvJ)) * ((count - getHeaderViewsCount()) - getFooterViewsCount())));
        x.i("MicroMsg.ConversationWithAppBrandListView", "[isFull] height:%s rawCount:%s extraHeight:%s", Integer.valueOf(getHeight()), Integer.valueOf((count - getHeaderViewsCount()) - getFooterViewsCount()), Float.valueOf(measuredHeight));
        if (measuredHeight < 0.0f) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.ConversationWithAppBrandListView", "[checkEmptyFooter] isRealFull:" + z);
        if (z) {
            layoutParams.height = 0;
        } else {
            layoutParams.height = (int) measuredHeight;
            if (this.isInit) {
                post(new Runnable() {
                    public final void run() {
                        ConversationWithAppBrandListView.this.setSelection(0);
                    }
                });
            }
        }
        if (i != layoutParams.height) {
            this.zgV.setLayoutParams(layoutParams);
            if (!this.isInit) {
                super.setSelection(cxq);
            }
        }
    }

    private void nn(boolean z) {
        if (z) {
            ah.K(this.zgW);
            return;
        }
        ah.K(this.zgW);
        ah.h(this.zgW, 1000);
    }

    private void no(boolean z) {
        int i = 0;
        x.i("MicroMsg.ConversationWithAppBrandListView", "[setEmptyViewVisible] isShow:%s", Boolean.valueOf(z));
        if (this.klX != null) {
            this.klX.setVisibility(z ? 0 : 8);
        }
        if (this.zgL != null) {
            View findViewById = this.zgL.findViewById(R.h.bKO);
            if (findViewById != null) {
                if (z) {
                    i = 4;
                }
                findViewById.setVisibility(i);
            }
        }
    }

    private void cxn() {
        this.zgK = v.fw(getContext()).inflate(R.i.bKM, null);
        this.zgL = this.zgK.findViewById(R.h.bKN);
        this.zgL.setVisibility(8);
        this.klX = this.zgL.findViewById(R.h.ces);
        this.zgK.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        ViewGroup viewGroup = (ViewGroup) this.zgK.findViewById(R.h.bKO);
        if (g.h(d.class) != null) {
            this.zgM = ((d) g.h(d.class)).y(getContext(), d.b.klu);
            this.zgX = this.zgM.getLayoutParams().height;
            this.zgM.kkO = this;
            this.zgM.refresh();
            viewGroup.addView(this.zgM);
            viewGroup.setTranslationY(-(this.yev - (((float) this.zgX) - getResources().getDimension(R.f.bwd))));
            this.zgM.fn().a(new RecyclerView.c() {
                public final void aa(int i, int i2) {
                    super.aa(i, i2);
                    if (ConversationWithAppBrandListView.this.zgM.fn().getItemCount() == 1) {
                        ConversationWithAppBrandListView.this.no(true);
                    } else {
                        ConversationWithAppBrandListView.this.no(false);
                    }
                }
            });
            this.zgM.a(new com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.a() {
                public final boolean a(View view, final com.tencent.mm.plugin.appbrand.widget.recentview.a aVar, float f, float f2) {
                    ConversationWithAppBrandListView.this.zgK.postDelayed(new Runnable() {
                        public final void run() {
                            if (ConversationWithAppBrandListView.this.zgQ != null && aVar != null) {
                                if (aVar.type != 1 || aVar.kkN == null) {
                                    ConversationWithAppBrandListView.this.A(0, 2);
                                    return;
                                }
                                ConversationWithAppBrandListView.this.zgQ.kkX.append(aVar.kkN.appId + ":");
                            }
                        }
                    }, 666);
                    return false;
                }

                public final boolean b(View view, com.tencent.mm.plugin.appbrand.widget.recentview.a aVar, float f, float f2) {
                    if (!(aVar == null || aVar.kkN == null || aVar.type != 1 || ConversationWithAppBrandListView.this.zgQ == null)) {
                        com.tencent.mm.plugin.appbrand.widget.recentview.b e = ConversationWithAppBrandListView.this.zgQ;
                        String str = aVar.kkN.appId;
                        e.kkV++;
                        e.kkY.append(str + ":");
                    }
                    return false;
                }
            });
            this.zgM.a(new k() {
                LinearLayoutManager roP = ((LinearLayoutManager) ConversationWithAppBrandListView.this.zgM.TV);
                int zhq = 0;

                public final void c(RecyclerView recyclerView, int i, int i2) {
                    super.c(recyclerView, i, i2);
                    LinearLayoutManager linearLayoutManager = this.roP;
                    View a = linearLayoutManager.a(0, linearLayoutManager.getChildCount(), true, false);
                    int bd = a == null ? -1 : h.bd(a);
                    if (!(ConversationWithAppBrandListView.this.zgQ == null || bd / 4 == this.zhq || recyclerView.getChildCount() <= 4)) {
                        com.tencent.mm.plugin.appbrand.widget.recentview.b e = ConversationWithAppBrandListView.this.zgQ;
                        e.kkU++;
                    }
                    this.zhq = bd / 4;
                }
            });
            this.zgJ.remove(this.zgK);
            FixedViewInfo fixedViewInfo = new FixedViewInfo(this);
            fixedViewInfo.view = this.zgK;
            fixedViewInfo.data = null;
            fixedViewInfo.isSelectable = true;
            this.zgJ.addFirst(fixedViewInfo);
            Iterator it = this.zgJ.iterator();
            while (it.hasNext()) {
                fixedViewInfo = (FixedViewInfo) it.next();
                super.addHeaderView(fixedViewInfo.view, fixedViewInfo.data, fixedViewInfo.isSelectable);
            }
            return;
        }
        this.zgN = false;
        x.e("MicroMsg.ConversationWithAppBrandListView", "MMKernel.service(IAppBrandRecentViewService.class) is null!");
    }

    public void setSelection(int i) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[setSelection] position:%s", Integer.valueOf(i));
        if (i == 0 && nr(true)) {
            super.setSelection(cxq());
            if (this.zgQ != null) {
                this.zgQ.cd(Math.max(0, this.zgM.getCount() - 1), 7);
                return;
            }
            return;
        }
        super.setSelection(i);
    }

    public void smoothScrollToPosition(int i) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPosition] position:%s", Integer.valueOf(i));
        if (i == 0 && nr(true)) {
            super.smoothScrollToPosition(cxq());
        } else {
            super.smoothScrollToPosition(i);
        }
    }

    public void smoothScrollToPositionFromTop(int i, int i2) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPositionFromTop] position:%s offset:%s", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && nr(true)) {
            super.smoothScrollToPositionFromTop(cxq(), i2);
        } else {
            super.smoothScrollToPositionFromTop(i, i2);
        }
    }

    public void smoothScrollToPositionFromTop(int i, int i2, int i3) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPositionFromTop] position:%s offset:%s duration:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i == 0 && nr(true)) {
            super.smoothScrollToPositionFromTop(cxq(), i2, i3);
        } else {
            super.smoothScrollToPositionFromTop(i, i2, i3);
        }
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.omt = onScrollListener;
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        if (!nr(true) || getFirstVisiblePosition() != 0 || i2 >= 0) {
            return super.dispatchNestedPreScroll(i, i2, iArr, iArr2);
        }
        iArr[1] = (int) (((float) i2) / 3.0f);
        super.dispatchNestedPreScroll(i, i2, iArr, iArr2);
        return true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                float x = motionEvent.getX();
                this.lJL = x;
                this.zgY = x;
                x = motionEvent.getY();
                this.lJM = x;
                this.zgZ = x;
            }
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            return dispatchTouchEvent;
        } finally {
            this.lJL = motionEvent.getX();
            this.lJM = motionEvent.getY();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!nr(true)) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            if (getFirstVisiblePosition() != 0) {
                this.zhj = true;
            }
        } else if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && getFirstVisiblePosition() == 0) {
            View childAt = getChildAt(0);
            if (childAt == null) {
                return true;
            }
            if (Math.abs(motionEvent.getX() - this.lJL) < 3.0f && Math.abs(motionEvent.getY() - this.lJM) < 3.0f) {
                super.onTouchEvent(motionEvent);
            }
            if (cxo() < 60.0f * getResources().getDisplayMetrics().density) {
                float abs = Math.abs(motionEvent.getX() - this.zgY) - Math.abs(motionEvent.getY() - this.zgZ);
                if ((motionEvent.getY() - this.zgZ < 0.0f && abs < 0.0f && getFirstVisiblePosition() == 0) || (childAt.getBottom() > 0 && ((float) childAt.getBottom()) < this.yev)) {
                    GK(4);
                } else if (((float) childAt.getBottom()) >= this.yev && motionEvent.getY() - this.zgZ > 0.0f) {
                    GJ(250);
                }
            }
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            nn(true);
            this.zhc = false;
            if (cxo() > 0.0f) {
                GJ(250);
            }
        }
        if (!L(motionEvent)) {
            if (this.zhc && motionEvent.getAction() == 2) {
                motionEvent.setAction(0);
                super.onTouchEvent(motionEvent);
                motionEvent.setAction(2);
                this.zhc = false;
            }
            return super.onTouchEvent(motionEvent);
        } else if (motionEvent.getAction() == 0) {
            super.onTouchEvent(motionEvent);
            return true;
        } else if (motionEvent.getAction() == 2 && !this.zhc && Math.abs(motionEvent.getY() - this.lJM) > 2.0f) {
            motionEvent.setAction(3);
            super.onTouchEvent(motionEvent);
            this.zhc = true;
            return true;
        } else if (this.zhc) {
            return true;
        } else {
            super.onTouchEvent(motionEvent);
            return true;
        }
    }

    private boolean L(MotionEvent motionEvent) {
        int i = 0;
        if (!cxr()) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.zhb = motionEvent.getY();
            if (this.fde != null) {
                this.fde.cancel();
            }
        } else if (motionEvent.getActionMasked() == 5) {
            this.zhb = motionEvent.getY();
        } else if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.zgK.getTop() == 0 && cxo() != 0.0f) {
            np(true);
            this.zhd = false;
            x.d("MicroMsg.ConversationWithAppBrandListView", "[animationChild] offset:%s delay:%s duration%s", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(180));
            if (cxr()) {
                if (this.fde != null) {
                    this.fde.cancel();
                }
                PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("deltaY", new float[]{cxo() + 0.0f, 0.0f});
                String str = "headerDeltaY";
                float[] fArr = new float[2];
                View childAt = getChildAt(0);
                fArr[0] = (childAt == null ? 0.0f : childAt.getTranslationY()) + 0.0f;
                fArr[1] = 0.0f;
                PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(str, fArr);
                this.fde = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat, ofFloat2});
                this.fde.setDuration(180);
                this.fde.addUpdateListener(new AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
                        float floatValue2 = ((Float) valueAnimator.getAnimatedValue("headerDeltaY")).floatValue();
                        for (int i = 0; i < ConversationWithAppBrandListView.this.getChildCount(); i++) {
                            if (i == 0) {
                                ConversationWithAppBrandListView.this.getChildAt(i).setTranslationY(floatValue2);
                            } else {
                                ConversationWithAppBrandListView.this.getChildAt(i).setTranslationY(floatValue);
                            }
                            ConversationWithAppBrandListView.this.zha = floatValue;
                        }
                        ConversationWithAppBrandListView.this.invalidate();
                    }
                });
                this.fde.addListener(new AnimatorListener() {
                    public final void onAnimationStart(Animator animator) {
                    }

                    public final void onAnimationEnd(Animator animator) {
                        ConversationWithAppBrandListView.this.cxp();
                    }

                    public final void onAnimationCancel(Animator animator) {
                        ConversationWithAppBrandListView.this.cxp();
                    }

                    public final void onAnimationRepeat(Animator animator) {
                    }
                });
                this.fde.setStartDelay(0);
                this.fde.start();
            }
        }
        try {
            if (!(motionEvent.getAction() == 2 && Math.abs(motionEvent.getY() - this.lJM) > 2.0f && getFirstVisiblePosition() == 0 && this.zgK.getTop() == 0) && cxo() == 0.0f) {
                this.zhb = motionEvent.getY();
                return false;
            }
            nn(true);
            if (((float) ((getHeight() - this.zgX) / 2)) <= this.zha) {
                np(false);
            } else {
                np(true);
            }
            float height = (float) (getHeight() - this.zgX);
            this.zha = ((motionEvent.getY() - this.zhb) * 0.4f) + this.zha;
            if (this.zha < 0.0f) {
                this.zha = 0.0f;
                cxp();
                invalidate();
                return false;
            }
            if (height < this.zha) {
                this.zha = height;
            }
            while (i < getChildCount()) {
                if (i == 0) {
                    getChildAt(i).setTranslationY(this.zha * 0.5f);
                } else {
                    getChildAt(i).setTranslationY(this.zha);
                }
                i++;
            }
            invalidate();
            this.zhb = motionEvent.getY();
            return true;
        } finally {
            this.zhb = motionEvent.getY();
        }
    }

    private void GJ(int i) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[openAppBrandRecentView] isOpenAppBrandRecentView:%s isHeadsetPluged:%s", Boolean.valueOf(this.zhe), Boolean.valueOf(as.Hn().xY()));
        if (!this.zhe) {
            com.tencent.mm.sdk.platformtools.as.a(getContext(), R.l.dEl, b.NOTSET, 3, false, null);
            if (!(this.zgQ == null || this.zgM == null)) {
                com.tencent.mm.plugin.appbrand.widget.recentview.b bVar = this.zgQ;
                int max = Math.max(0, this.zgM.getCount() - 1);
                bVar.kkQ = System.currentTimeMillis() / 1000;
                bVar.kkR = max;
            }
        }
        if (this.zgT && this.zgM != null) {
            this.zgM.fn().UR.notifyChanged();
            this.zgT = true;
        }
        super.smoothScrollToPositionFromTop(0, 0, i);
        nn(true);
        this.zhe = true;
    }

    private void GK(int i) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[closeAppBrandRecentView] isOpenAppBrandRecentView:%s type:%s", Boolean.valueOf(this.zhe), Integer.valueOf(i));
        if (!(!this.zhe || getChildAt(0) == null || this.zgQ == null || this.zgM == null)) {
            this.zgQ.cd(Math.max(0, this.zgM.getCount() - 1), i);
        }
        if (getFirstVisiblePosition() == 0) {
            View childAt = getChildAt(0);
            if ((childAt == null ? 0 : childAt.getBottom()) != 0) {
                smoothScrollToPositionFromTop(cxq(), 0, 150);
            }
        }
        cxp();
        nn(true);
        this.zhe = false;
    }

    private float cxo() {
        View childAt = getChildAt(1);
        return childAt == null ? 0.0f : childAt.getTranslationY();
    }

    private void cxp() {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setTranslationY(0.0f);
        }
        this.zha = 0.0f;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getFirstVisiblePosition() == 0 && this.zgK != null) {
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), ((float) this.zgK.getBottom()) + this.zha, this.zgO);
            if (getChildAt(1) != null) {
                int i = (getHeight() == 0 || !this.zhg) ? 0 : 1;
                if (i != 0) {
                    canvas.drawText(this.zgR, (((float) getWidth()) - this.zgS) / 2.0f, (((float) this.zgK.getBottom()) + this.zha) - getResources().getDimension(R.f.bvz), this.zgP);
                }
            }
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.omt != null) {
            this.omt.onScrollStateChanged(absListView, i);
        }
        if (getFirstVisiblePosition() != 0 && i == 2 && !this.zhf) {
            this.qir = true;
        }
    }

    private void np(boolean z) {
        if (z && this.zhh != null) {
            ah.K(this.zhh);
            this.zhh = null;
            if (this.zhg) {
                nq(false);
            }
        } else if (!z && this.zhh == null) {
            Runnable anonymousClass7 = new Runnable() {
                public final void run() {
                    x.i("MicroMsg.ConversationWithAppBrandListView", "[CheckShowTipTask]");
                    ConversationWithAppBrandListView.this.nq(true);
                }
            };
            this.zhh = anonymousClass7;
            ah.h(anonymousClass7, 3000);
        }
    }

    private void nq(boolean z) {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[showTipWithAnim] isShow:%s", Boolean.valueOf(z));
        PropertyValuesHolder ofInt;
        ValueAnimator ofPropertyValuesHolder;
        if (z) {
            this.zhg = true;
            ofInt = PropertyValuesHolder.ofInt("alpha", new int[]{0, 77});
            ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt});
            ofPropertyValuesHolder.setDuration(200);
            ofPropertyValuesHolder.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ConversationWithAppBrandListView.this.zgP.setAlpha(((Integer) valueAnimator.getAnimatedValue("alpha")).intValue());
                    ConversationWithAppBrandListView.this.invalidate();
                }
            });
            ofPropertyValuesHolder.start();
            if (this.zgQ != null) {
                com.tencent.mm.plugin.appbrand.widget.recentview.b bVar = this.zgQ;
                bVar.kkW++;
                return;
            }
            return;
        }
        ofInt = PropertyValuesHolder.ofInt("alpha", new int[]{77, 0});
        ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt});
        ofPropertyValuesHolder.setDuration(200);
        ofPropertyValuesHolder.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ConversationWithAppBrandListView.this.zgP.setAlpha(((Integer) valueAnimator.getAnimatedValue("alpha")).intValue());
                ConversationWithAppBrandListView.this.invalidate();
            }
        });
        ofPropertyValuesHolder.addListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                ConversationWithAppBrandListView.this.zhg = false;
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        ofPropertyValuesHolder.start();
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.omt != null) {
            this.omt.onScroll(absListView, i, i2, i3);
        }
        if (nr(true)) {
            float bottom;
            if (i == 0) {
                nn(false);
                View childAt = absListView.getChildAt(0);
                if (childAt != null && childAt.getId() == R.h.bKM) {
                    View findViewById = childAt.findViewById(R.h.bKN);
                    if (findViewById != null && findViewById.getVisibility() != 8) {
                        View findViewById2 = childAt.findViewById(R.h.bKO);
                        GyroView gyroView = (GyroView) childAt.findViewById(R.h.cof);
                        float dimension = this.yev - (((float) this.zgX) - getResources().getDimension(R.f.bwd));
                        float dimension2 = (this.yev - (((float) this.zgX) - getResources().getDimension(R.f.bwd))) - getResources().getDimension(R.f.bvu);
                        if (childAt.getBottom() <= 3) {
                            findViewById2.setTranslationY(-dimension);
                            this.klX.setTranslationY(-dimension2);
                            if (gyroView.getVisibility() == 0) {
                                gyroView.aC(0.0f);
                                gyroView.setVisibility(8);
                            }
                            this.zhk = false;
                        }
                        if (childAt.getBottom() > 3 && ((float) childAt.getBottom()) <= this.yev && findViewById2.getTranslationY() != 0.0f) {
                            if (gyroView.getVisibility() == 8) {
                                gyroView.setVisibility(0);
                            }
                            gyroView.setAlpha(1.0f);
                            gyroView.setTranslationY((float) (((-childAt.getBottom()) / 2) + (gyroView.getHeight() / 2)));
                            gyroView.aC((float) childAt.getBottom());
                        } else if (((float) childAt.getBottom()) > this.yev && findViewById2.getTranslationY() != 0.0f) {
                            bottom = (float) ((1.0d * ((double) (((float) childAt.getBottom()) - this.yev))) / ((double) (((float) this.zgX) - this.yev)));
                            findViewById2.setTranslationY((-dimension) * (1.0f - bottom));
                            this.klX.setTranslationY((-dimension2) * (1.0f - bottom));
                            gyroView.setTranslationY((((-this.yev) / 2.0f) + ((float) (gyroView.getHeight() / 2))) + (((this.yev / 2.0f) + ((float) gyroView.getHeight())) * bottom));
                            gyroView.setAlpha(1.0f - (2.0f * bottom));
                            if (!(this.zhk || 1.0f == bottom)) {
                                this.lrS.vibrate(10);
                                this.zhk = true;
                            }
                            nn(true);
                        }
                    } else {
                        return;
                    }
                }
            }
            if (this.zgK != null) {
                ViewGroup viewGroup = (ViewGroup) this.zgK.findViewById(R.h.bKO);
                bottom = this.yev - (((float) this.zgX) - getResources().getDimension(R.f.bwd));
                float dimension3 = (this.yev - (((float) this.zgX) - getResources().getDimension(R.f.bwd))) - getResources().getDimension(R.f.bvu);
                if (!(viewGroup == null || viewGroup.getTranslationY() == bottom)) {
                    viewGroup.setTranslationY(-bottom);
                }
                this.klX.setTranslationY(-dimension3);
            }
            if (this.zhl == 0 && i != 0) {
                GK(4);
                np(true);
                nn(true);
            }
            this.zhl = i;
            if (this.zhj && this.qir && i == 0) {
                x.e("MicroMsg.ConversationWithAppBrandListView", "[Stop fling!]");
                smoothScrollBy(0, 0);
                post(new Runnable() {
                    public final void run() {
                        View childAt = ConversationWithAppBrandListView.this.getChildAt(0);
                        x.i("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollBy] offset: " + (childAt == null ? 0 : childAt.getBottom()));
                        ConversationWithAppBrandListView.this.smoothScrollToPositionFromTop(ConversationWithAppBrandListView.this.cxq(), 0, 300);
                        ConversationWithAppBrandListView.this.nn(true);
                    }
                });
                this.zhj = false;
            }
            ah.K(this.zhi);
            ah.h(this.zhi, 50);
        }
    }

    public final int cxq() {
        Iterator it = this.zgJ.iterator();
        int i = 0;
        while (it.hasNext()) {
            FixedViewInfo fixedViewInfo = (FixedViewInfo) it.next();
            if (fixedViewInfo.view == this.zgK) {
                i++;
            } else {
                if (fixedViewInfo.view != null && (fixedViewInfo.view instanceof ViewGroup)) {
                    View childAt = ((ViewGroup) fixedViewInfo.view).getChildAt(0);
                    if (childAt != null && childAt.getVisibility() == 0) {
                        x.i("MicroMsg.ConversationWithAppBrandListView", "[getFirstHeaderVisible] index:%s", Integer.valueOf(i));
                        break;
                    }
                }
                i++;
            }
        }
        x.i("MicroMsg.ConversationWithAppBrandListView", "[getFirstHeaderVisible] index:%s", Integer.valueOf(i));
        return i;
    }

    final boolean nr(boolean z) {
        if (!((this.hasInit && z) || g.h(d.class) == null)) {
            g.h(d.class);
            this.zgN = true;
            x.i("MicroMsg.ConversationWithAppBrandListView", "[isAppBrandHeaderEnable] :%s", Boolean.valueOf(this.zgN));
            this.hasInit = true;
        }
        return this.zgN;
    }

    private boolean cxr() {
        if (this.zgL == null) {
            return false;
        }
        if (nr(true) && this.zgL.getVisibility() == 0) {
            return true;
        }
        return false;
    }
}
