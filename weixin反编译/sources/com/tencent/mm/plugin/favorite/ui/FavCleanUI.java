package com.tencent.mm.plugin.favorite.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.JsApiDownloadSilkVoice;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.a.q;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.d;
import com.tencent.mm.plugin.favorite.ui.a.b;
import com.tencent.mm.plugin.favorite.ui.b.a.c;
import com.tencent.mm.plugin.favorite.ui.base.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.v;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FavCleanUI extends MMActivity implements c {
    protected ag hbP = new ag(Looper.getMainLooper());
    private Runnable mxD = new Runnable() {
        public final void run() {
            if (FavCleanUI.this.mxK != null) {
                FavCleanUI.this.mxK.aKa();
            }
            FavCleanUI.this.aJM();
        }
    };
    protected Runnable mxE = new Runnable() {
        public final void run() {
            if (FavCleanUI.this.mxK != null) {
                if (FavCleanUI.this.mxK.isEmpty() || SystemClock.elapsedRealtime() - FavCleanUI.this.mxs >= 1000) {
                    FavCleanUI.this.mxp = false;
                    FavCleanUI.this.mxs = SystemClock.elapsedRealtime();
                    x.v("MicroMsg.FavCleanUI", "do refresh job");
                    FavCleanUI.d(FavCleanUI.this);
                    if (FavCleanUI.this.mxq) {
                        x.v("MicroMsg.FavCleanUI", "do scroll to first");
                        FavCleanUI.this.mxL.setSelection(0);
                        FavCleanUI.this.mxq = false;
                        return;
                    }
                    return;
                }
                x.d("MicroMsg.FavCleanUI", "try refresh, time limit, now %d last %d delay %d", Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(FavCleanUI.this.mxs), Integer.valueOf(1000));
                FavCleanUI.this.hbP.postDelayed(this, 500);
            }
        }
    };
    private h mxJ;
    private b mxK;
    private ListView mxL;
    private TextView mxM;
    private a mxN;
    private boolean mxO = false;
    private int mxP = 0;
    private com.tencent.mm.plugin.favorite.a.a.a mxQ = new com.tencent.mm.plugin.favorite.a.a.a() {
        public final void onFinish() {
            x.i("MicroMsg.FavCleanUI", "FavCleanFirstLoader onRefreshed()");
            FavCleanUI.c(FavCleanUI.this);
            FavCleanUI.d(FavCleanUI.this);
        }
    };
    private e mxR = new e() {
        public final void a(int i, int i2, String str, k kVar) {
            x.i("MicroMsg.FavCleanUI", "on getfavinfo scene end");
            if (FavCleanUI.this.mxN != null) {
                FavCleanUI.this.mxN.mAx = j.aJr();
            }
        }
    };
    private boolean mxp = false;
    protected boolean mxq = false;
    private long mxs = 0;
    private HandlerThread mxv;
    protected ag mxw;
    protected View mxx;
    private View mxy;

    static /* synthetic */ boolean a(FavCleanUI favCleanUI) {
        if (favCleanUI.mxL.getChildAt(favCleanUI.mxL.getChildCount() - 1) == null || favCleanUI.mxL.getLastVisiblePosition() != favCleanUI.mxL.getAdapter().getCount() - 1) {
            return false;
        }
        x.i("MicroMsg.FavCleanUI", "at bottom call back");
        return true;
    }

    static /* synthetic */ void b(FavCleanUI favCleanUI) {
        x.v("MicroMsg.FavCleanUI", "on pull down callback");
        if (favCleanUI.mxK.mAj) {
            x.i("MicroMsg.FavCleanUI", "has shown all, do not load data");
        } else if (favCleanUI.mxp) {
            x.w("MicroMsg.FavCleanUI", "onBottomLoadData loading, return");
        } else {
            favCleanUI.mxp = true;
            favCleanUI.ff(true);
            x.i("MicroMsg.FavCleanUI", "on bottom load data listener");
            favCleanUI.mxw.removeCallbacks(favCleanUI.mxD);
            favCleanUI.mxw.post(favCleanUI.mxD);
        }
    }

    static /* synthetic */ void c(FavCleanUI favCleanUI) {
        favCleanUI.mxJ = new h(ad.getContext(), 16);
        favCleanUI.mxK = new b(favCleanUI.mxJ, true);
        favCleanUI.mxK.mAh = favCleanUI;
        favCleanUI.mxL.setAdapter(favCleanUI.mxK);
        favCleanUI.mxL.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (FavCleanUI.this.mxK != null) {
                    FavCleanUI.this.mxK.onItemClick(adapterView, view, i, j);
                }
            }
        });
        favCleanUI.mxL.setOnTouchListener(null);
        favCleanUI.mxL.setOnItemLongClickListener(null);
    }

    static /* synthetic */ void d(FavCleanUI favCleanUI) {
        favCleanUI.mxK.notifyDataSetChanged();
        if (favCleanUI.mxK.isEmpty()) {
            favCleanUI.fe(true);
            if (8 != favCleanUI.mxL.getVisibility()) {
                favCleanUI.mxL.setVisibility(8);
            }
        } else {
            favCleanUI.fe(false);
            if (favCleanUI.mxN != null) {
                favCleanUI.mxN.show();
            }
            if (favCleanUI.mxL.getVisibility() != 0) {
                favCleanUI.mxL.setVisibility(0);
            }
        }
        favCleanUI.ff(false);
    }

    protected final int getLayoutId() {
        return R.i.dhy;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mxP = getIntent().getIntExtra("key_enter_fav_cleanui_from", 0);
        this.mxv = com.tencent.mm.sdk.f.e.WL(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
        this.mxv.start();
        this.mxw = new ag(this.mxv.getLooper());
        this.mxL = (ListView) findViewById(R.h.cgu);
        setMMTitle(R.l.eeO);
        this.mxO = true;
        as.CN().a(new q(), 0);
        as.CN().a((int) JsApiDownloadSilkVoice.CTRL_INDEX, this.mxR);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                FavCleanUI.this.finish();
                return true;
            }
        });
        ViewStub viewStub = (ViewStub) findViewById(R.h.cem);
        if (viewStub != null) {
            this.mxy = viewStub.inflate();
        } else {
            this.mxy = findViewById(R.h.chx);
        }
        this.mxM = (TextView) findViewById(R.h.cek);
        this.mxy.setVisibility(0);
        this.mxM.setVisibility(8);
        this.mxL.removeFooterView(this.mxx);
        if (this.mxN != null) {
            this.mxN.hide();
        }
        this.mxx = v.fw(this).inflate(R.i.dhL, null);
        this.mxL.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0 && FavCleanUI.a(FavCleanUI.this)) {
                    x.i("MicroMsg.FavCleanUI", "force bottom load data");
                    FavCleanUI.b(FavCleanUI.this);
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        if (this.mxO) {
            this.mxN = new a();
            a aVar = this.mxN;
            View findViewById = findViewById(R.h.cgt);
            aVar.mAz = false;
            aVar.mAA = findViewById;
            this.mxN.mAB = new a.a() {
                public final void aJN() {
                    com.tencent.mm.ui.base.h.a(FavCleanUI.this.mController.xRr, FavCleanUI.this.getString(R.l.eeN), "", new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            long aKe = FavCleanUI.this.mxK.aKe();
                            final List fg = FavCleanUI.this.mxK.fg(true);
                            a f = FavCleanUI.this.mxN;
                            f.mAx += aKe;
                            j.dj(j.aJt() - aKe);
                            if (!fg.isEmpty()) {
                                g.pWK.h(14110, Integer.valueOf(FavCleanUI.this.mxP), Integer.valueOf(fg.size()), Integer.valueOf((int) ((((double) aKe) * 1.0d) / 1024.0d)));
                                final Dialog a = com.tencent.mm.ui.base.h.a(FavCleanUI.this.mController.xRr, FavCleanUI.this.getString(R.l.eeW), false, null);
                                as.Dt().F(new Runnable() {
                                    public final void run() {
                                        j.aM(fg);
                                        ah.y(new Runnable() {
                                            public final void run() {
                                                b e = FavCleanUI.this.mxK;
                                                List<f> list = fg;
                                                if (e.mzW != null) {
                                                    List arrayList = new ArrayList();
                                                    for (f fVar : e.mzW) {
                                                        if (fVar != null) {
                                                            Object obj;
                                                            for (f fVar2 : list) {
                                                                if (fVar2 != null && fVar.field_localId == fVar2.field_localId) {
                                                                    obj = 1;
                                                                    break;
                                                                }
                                                            }
                                                            obj = null;
                                                            if (obj == null) {
                                                                arrayList.add(fVar);
                                                            }
                                                        }
                                                    }
                                                    e.mzW = arrayList;
                                                    arrayList = new ArrayList();
                                                    for (Long l : e.mzZ) {
                                                        Object obj2;
                                                        for (f fVar3 : list) {
                                                            if (fVar3 != null && l.equals(Long.valueOf(fVar3.field_localId))) {
                                                                obj2 = 1;
                                                                break;
                                                            }
                                                        }
                                                        obj2 = null;
                                                        if (obj2 == null) {
                                                            arrayList.add(l);
                                                        }
                                                    }
                                                    e.mzZ = arrayList;
                                                }
                                                FavCleanUI.this.mxK.notifyDataSetChanged();
                                                FavCleanUI.this.mxN.aKf();
                                                a.dismiss();
                                            }

                                            public final String toString() {
                                                return super.toString() + "|batchDelFavItems";
                                            }
                                        });
                                    }
                                });
                                g.pWK.h(11125, Integer.valueOf(fg.size()), Integer.valueOf(3));
                            }
                        }
                    }, null);
                }
            };
            this.mxO = false;
        }
        com.tencent.mm.plugin.favorite.a.a.aJd().a(this.mxQ);
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.favorite.a.a aJd = com.tencent.mm.plugin.favorite.a.a.aJd();
        com.tencent.mm.plugin.favorite.a.a.a aVar = this.mxQ;
        if (aJd.mve.contains(aVar)) {
            aJd.mve.remove(aVar);
        }
        if (this.mxJ != null) {
            this.mxJ.destory();
            this.mxJ = null;
        }
        if (this.mxK != null) {
            this.mxK.finish();
        }
        this.mxv.quit();
        as.CN().b((int) JsApiDownloadSilkVoice.CTRL_INDEX, this.mxR);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        x.d("MicroMsg.FavCleanUI", "on create options menu");
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    protected final void aJM() {
        x.i("MicroMsg.FavCleanUI", "on storage change, try refresh job");
        this.hbP.removeCallbacks(this.mxE);
        this.hbP.post(this.mxE);
    }

    private void fe(boolean z) {
        if (z) {
            this.mxy.setVisibility(8);
            this.mxM.setVisibility(0);
            this.mxL.removeFooterView(this.mxx);
            if (this.mxN != null) {
                this.mxN.hide();
                return;
            }
            return;
        }
        this.mxy.setVisibility(8);
        this.mxM.setVisibility(8);
        this.mxL.removeFooterView(this.mxx);
        if (this.mxN != null) {
            this.mxN.show();
        }
    }

    private void ff(boolean z) {
        if (!z) {
            this.mxL.removeFooterView(this.mxx);
        } else if (this.mxL.getFooterViewsCount() == 0) {
            this.mxL.addFooterView(this.mxx);
        }
    }

    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    public final void dr(long j) {
        long j2;
        f dc = com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().dc(j);
        if (!(dc == null || dc.field_favProto == null || dc.field_favProto.wlY.size() == 0)) {
            Iterator it = dc.field_favProto.wlY.iterator();
            while (it.hasNext()) {
                j2 = ((uz) it.next()).wki;
            }
        }
        if (this.mxK.mAi) {
            boolean z;
            a aVar = this.mxN;
            if (this.mxK.aKd() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (aVar.mAz) {
                aVar.lmo.setEnabled(z);
            }
            a aVar2 = this.mxN;
            List fg = this.mxK.fg(false);
            j2 = this.mxK.aKe();
            if (fg.size() == 0 || j2 <= 0) {
                aVar2.aKf();
                return;
            }
            aVar2.lmv.setText(aVar2.lmv.getContext().getString(R.l.eeM, new Object[]{d.dh(j2)}));
            aVar2.lmo.setEnabled(true);
        }
    }
}
