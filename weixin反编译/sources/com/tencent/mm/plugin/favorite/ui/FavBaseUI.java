package com.tencent.mm.plugin.favorite.ui;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.ew;
import com.tencent.mm.plugin.favorite.a.p;
import com.tencent.mm.plugin.favorite.a.q;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.ui.base.c;
import com.tencent.mm.plugin.favorite.ui.base.c.a;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.v;
import com.tencent.mm.y.as;

public abstract class FavBaseUI extends MMActivity implements OnItemClickListener {
    protected ag hbP = new ag(Looper.getMainLooper());
    private final Object lockObj = new Object();
    protected h muM;
    protected a mxA = null;
    private e mxB = new e() {
        public final void a(int i, int i2, String str, k kVar) {
            x.i("MicroMsg.FavoriteBaseUI", "on fav sync end");
            if (((p) kVar).mwt) {
                x.i("MicroMsg.FavoriteBaseUI", "need batch get return");
                return;
            }
            x.i("MicroMsg.FavoriteBaseUI", "dismiss loading dialog");
            if (FavBaseUI.this.mxr) {
                FavBaseUI.this.mxr = false;
            }
            FavBaseUI.this.fc(false);
            FavBaseUI.this.aJM();
        }
    };
    private e mxC = new e() {
        public final void a(int i, int i2, String str, k kVar) {
            x.i("MicroMsg.FavoriteBaseUI", "on batch get end");
            if (FavBaseUI.this.mxr) {
                x.i("MicroMsg.FavoriteBaseUI", "init currently, dismiss dialog");
                FavBaseUI.this.mxr = false;
                FavBaseUI.this.fc(false);
            }
        }
    };
    private Runnable mxD = new Runnable() {
        public final void run() {
            com.tencent.mm.plugin.favorite.ui.a.a aJI = FavBaseUI.this.aJI();
            aJI.aKa();
            aJI.aKb();
            FavBaseUI.this.aJM();
        }
    };
    protected Runnable mxE = new Runnable() {
        public final void run() {
            com.tencent.mm.plugin.favorite.ui.a.a aJI = FavBaseUI.this.aJI();
            if (aJI.isEmpty() || SystemClock.elapsedRealtime() - FavBaseUI.this.mxs >= 400) {
                FavBaseUI.this.mxp = false;
                FavBaseUI.this.mxs = SystemClock.elapsedRealtime();
                x.v("MicroMsg.FavoriteBaseUI", "do refresh job");
                aJI.notifyDataSetChanged();
                FavBaseUI.this.a(aJI);
                if (FavBaseUI.this.mxq) {
                    x.v("MicroMsg.FavoriteBaseUI", "do scroll to first");
                    FavBaseUI.this.mxt.setSelection(0);
                    FavBaseUI.this.mxq = false;
                    return;
                }
                return;
            }
            x.d("MicroMsg.FavoriteBaseUI", "try refresh, time limit, now %d last %d delay %d", Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(FavBaseUI.this.mxs), Integer.valueOf(400));
            FavBaseUI.this.hbP.postDelayed(this, 200);
        }
    };
    private Runnable mxF = new Runnable() {
        public final void run() {
            synchronized (FavBaseUI.this.lockObj) {
                FavBaseUI.this.aJJ();
                FavBaseUI.this.aJI().aKb();
                FavBaseUI.this.aJM();
            }
        }
    };
    private j.a mxG = new j.a() {
        long mxI = 0;

        public final void a(String str, l lVar) {
            FavBaseUI.this.mxw.removeCallbacks(FavBaseUI.this.mxF);
            if (bi.bB(this.mxI) > 200) {
                this.mxI = bi.Wz();
                FavBaseUI.this.mxw.post(FavBaseUI.this.mxF);
                return;
            }
            FavBaseUI.this.mxw.postDelayed(FavBaseUI.this.mxF, 200);
        }
    };
    private boolean mxp = false;
    protected boolean mxq = false;
    private boolean mxr = false;
    private long mxs = 0;
    protected ListView mxt;
    protected TextView mxu;
    private HandlerThread mxv;
    protected ag mxw;
    protected View mxx;
    private View mxy;
    protected c mxz;

    public abstract com.tencent.mm.plugin.favorite.ui.a.a aJI();

    protected abstract void aJJ();

    protected abstract boolean aJK();

    protected abstract void aJL();

    static /* synthetic */ boolean a(FavBaseUI favBaseUI) {
        if (favBaseUI.mxt.getChildAt(favBaseUI.mxt.getChildCount() - 1) == null || favBaseUI.mxt.getLastVisiblePosition() != favBaseUI.mxt.getAdapter().getCount() - 1) {
            return false;
        }
        x.i("MicroMsg.FavoriteBaseUI", "at bottom call back");
        return true;
    }

    static /* synthetic */ boolean b(FavBaseUI favBaseUI) {
        x.v("MicroMsg.FavoriteBaseUI", "on pull down callback");
        if (!com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().q(favBaseUI.aJI().aJY(), favBaseUI.aJI().getType())) {
            if (com.tencent.mm.plugin.favorite.a.j.aJo()) {
                x.w("MicroMsg.FavoriteBaseUI", "doing batchget, do not load data");
            } else if (favBaseUI.mxp) {
                x.w("MicroMsg.FavoriteBaseUI", "onBottomLoadData loading, return");
            } else {
                favBaseUI.mxp = true;
                x.i("MicroMsg.FavoriteBaseUI", "on bottom load data listener");
                favBaseUI.mxw.removeCallbacks(favBaseUI.mxD);
                favBaseUI.mxw.post(favBaseUI.mxD);
            }
        }
        return true;
    }

    protected final int getLayoutId() {
        return R.i.dhZ;
    }

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        if (com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().aIF() == null) {
            com.tencent.mm.plugin.favorite.h.aIT().muY = ew.wm();
            finish();
            return;
        }
        x.i("MicroMsg.FavoriteBaseUI", "onCreate MMCore.accHasReady[%b]", Boolean.valueOf(as.Hp()));
        as.CN().a(new q(), 0);
        com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().c(this.mxG);
        as.CN().a(400, this.mxB);
        as.CN().a((int) com.tencent.mm.plugin.appbrand.jsapi.a.e.CTRL_INDEX, this.mxC);
        this.mxv = com.tencent.mm.sdk.f.e.WL(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
        this.mxv.start();
        this.mxw = new ag(this.mxv.getLooper());
        this.muM = new h(this.mController.xRr, 64);
        initView();
        as.Hm();
        if (bi.e((Integer) com.tencent.mm.y.c.Db().get(8217, null)) == 0) {
            x.i("MicroMsg.FavoriteBaseUI", "do init data for first time");
            this.mxr = true;
            as.CN().a(new p(), 0);
            if (this.mxr) {
                x.i("MicroMsg.FavoriteBaseUI", "show loading dialog");
                if (aJI() == null || aJI().isEmpty()) {
                    fc(true);
                }
                fd(false);
            }
        } else {
            com.tencent.mm.plugin.favorite.a.j.startSync();
            if (aJI().isEmpty()) {
                fc(true);
                fd(false);
                this.mxx.setVisibility(8);
            } else {
                fc(false);
                fd(false);
            }
        }
        com.tencent.mm.plugin.favorite.h.aIY().run();
        com.tencent.mm.plugin.favorite.h.aIV().run();
        com.tencent.mm.plugin.favorite.h.aIU().run();
        com.tencent.mm.plugin.favorite.h.aIW().run();
        as.Dt().F(new Runnable() {
            public final void run() {
                com.tencent.mm.plugin.favorite.a.j.aJp();
            }
        });
        x.d("MicroMsg.FavoriteBaseUI", "on create use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    protected void onResume() {
        super.onResume();
        i.CU(5);
    }

    protected void onPause() {
        super.onPause();
        aJI();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().aIF() != null) {
            this.muM.destory();
            this.muM = null;
            this.mxv.quit();
            com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().j(this.mxG);
            as.CN().b(400, this.mxB);
            as.CN().b((int) com.tencent.mm.plugin.appbrand.jsapi.a.e.CTRL_INDEX, this.mxC);
        }
    }

    protected final void initView() {
        long currentTimeMillis = System.currentTimeMillis();
        this.mxt = (ListView) findViewById(R.h.chy);
        this.mxt.setDrawingCacheEnabled(false);
        AnonymousClass3 anonymousClass3 = new OnClickListener() {
            public final void onClick(View view) {
                BackwardSupportUtil.c.a(FavBaseUI.this.mxt);
            }
        };
        initHeaderView();
        this.mxx = v.fw(this).inflate(R.i.dhL, null);
        this.mxt.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    return;
                }
                if (com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().q(FavBaseUI.this.aJI().aJY(), FavBaseUI.this.aJI().getType())) {
                    x.v("MicroMsg.FavoriteBaseUI", "has shown all, do not load data");
                } else if (FavBaseUI.a(FavBaseUI.this)) {
                    x.i("MicroMsg.FavoriteBaseUI", "force bottom load data");
                    FavBaseUI.b(FavBaseUI.this);
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.mxt.setOnItemClickListener(this);
        this.mxt.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                FavBaseUI.this.aWY();
                return false;
            }
        });
        this.mxt.setAdapter(aJI());
        a(aJI());
        x.d("MicroMsg.FavoriteBaseUI", "init view use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    protected final void fc(boolean z) {
        if (z) {
            if (this.mxy == null) {
                this.mxy = ((ViewStub) findViewById(R.h.cem)).inflate();
            }
            this.mxy.setVisibility(0);
        } else if (this.mxy != null) {
            this.mxy.setVisibility(8);
        }
    }

    private void fd(boolean z) {
        if (z) {
            if (this.mxu == null) {
                this.mxu = (TextView) ((ViewStub) findViewById(R.h.cex)).inflate().findViewById(R.h.cek);
            }
            this.mxu.setVisibility(0);
        } else if (this.mxu != null) {
            this.mxu.setVisibility(8);
        }
    }

    protected void initHeaderView() {
        this.mxz = new c(this.mController.xRr);
        this.mxz.mAL = this.mxA;
        this.mxz.fh(false);
        this.mxz.mAJ.setVisibility(8);
        this.mxz.mAK.setVisibility(8);
        x.d("MicroMsg.FavoriteBaseUI", "padding %s, %s", Integer.valueOf(this.mxz.getPaddingTop()), Integer.valueOf(this.mxz.getPaddingBottom()));
        this.mxt.addHeaderView(this.mxz);
    }

    protected void aJM() {
        x.i("MicroMsg.FavoriteBaseUI", "on storage change, try refresh job");
        this.hbP.removeCallbacks(this.mxE);
        this.hbP.post(this.mxE);
    }

    protected final void a(com.tencent.mm.plugin.favorite.ui.a.a aVar) {
        if (aVar == null) {
            x.w("MicroMsg.FavoriteBaseUI", "handle empty view fail, adapter is null");
            return;
        }
        if (!aVar.isEmpty()) {
            fc(false);
            fd(false);
        } else if (aJK()) {
            fc(true);
            fd(false);
        } else {
            fc(false);
            fd(true);
            aJL();
        }
        if (aVar.isEmpty() || com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().q(aVar.aJY(), aVar.getType())) {
            this.mxt.removeFooterView(this.mxx);
        } else if (this.mxt.getFooterViewsCount() == 0) {
            this.mxt.addFooterView(this.mxx);
        }
    }
}
