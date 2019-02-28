package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.j;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.fts.a.a;
import com.tencent.mm.plugin.webview.ui.tools.fts.a.b;
import com.tencent.mm.plugin.webview.ui.tools.fts.a.c;
import com.tencent.mm.plugin.webview.ui.tools.fts.a.d;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FtsBrowseHistoryUI extends WebSearchBaseActivity {
    private View mck;
    private TextView mxu;
    private d tKe;
    private RecyclerView tKg;
    private View tKh;
    private View tKi;
    private View tKj;
    private View tKk;
    private TextView tKl;
    private a tKm;
    private Animator tKn;

    static /* synthetic */ void a(FtsBrowseHistoryUI ftsBrowseHistoryUI) {
        ftsBrowseHistoryUI.tKj.setVisibility(8);
        kE(true);
        ftsBrowseHistoryUI.bUD();
        ftsBrowseHistoryUI.tKk.setVisibility(0);
        ftsBrowseHistoryUI.tKl.setText(R.l.elf);
        ftsBrowseHistoryUI.tKn.start();
    }

    static /* synthetic */ void a(FtsBrowseHistoryUI ftsBrowseHistoryUI, c cVar) {
        Intent intent = new Intent();
        x.i("FtsBrowseHistoryUI", "open url %s ,title %s", cVar.url, cVar.title);
        intent.putExtra("rawUrl", r1);
        intent.putExtra("useJs", true);
        intent.putExtra(Columns.TYPE, -255);
        com.tencent.mm.bl.d.b(ftsBrowseHistoryUI.mController.xRr, "webview", ".ui.tools.WebViewUI", intent);
        g.pWK.h(14963, Integer.valueOf(2));
    }

    static /* synthetic */ void b(FtsBrowseHistoryUI ftsBrowseHistoryUI, final c cVar) {
        String string = ftsBrowseHistoryUI.getString(R.l.dEH);
        ArrayList arrayList = new ArrayList();
        arrayList.add(string);
        h.a((Context) ftsBrowseHistoryUI, "", (String[]) arrayList.toArray(new String[0]), null, new h.c() {
            public final void jo(int i) {
                FtsBrowseHistoryUI.c(FtsBrowseHistoryUI.this, cVar);
            }
        });
    }

    static /* synthetic */ void c(FtsBrowseHistoryUI ftsBrowseHistoryUI, c cVar) {
        RecyclerView.a aVar = ftsBrowseHistoryUI.tKm;
        aVar.hkf.remove(cVar);
        aVar.UR.notifyChanged();
        ftsBrowseHistoryUI.bUE();
        ftsBrowseHistoryUI.tKe.c(cVar);
        g.pWK.h(14963, Integer.valueOf(3));
    }

    static /* synthetic */ void ct(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.isEmpty(((c) it.next()).title)) {
                it.remove();
            }
        }
    }

    static /* synthetic */ void e(FtsBrowseHistoryUI ftsBrowseHistoryUI) {
        ftsBrowseHistoryUI.removeOptionMenu(0);
        ftsBrowseHistoryUI.tKi.setVisibility(0);
        ftsBrowseHistoryUI.tKj.setVisibility(0);
        ftsBrowseHistoryUI.mxu.setVisibility(8);
        ftsBrowseHistoryUI.mck.setVisibility(8);
        ftsBrowseHistoryUI.tKe.bUP();
        kE(false);
        ftsBrowseHistoryUI.tKk.setVisibility(0);
        ftsBrowseHistoryUI.tKl.setText(R.l.ele);
        ftsBrowseHistoryUI.tKn.start();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.tKe = new b();
        this.tKh = findViewById(R.h.cty);
        this.mxu = (TextView) findViewById(R.h.cew);
        this.mck = findViewById(R.h.content);
        this.tKi = findViewById(R.h.cPZ);
        this.tKk = findViewById(R.h.cQa);
        this.tKl = (TextView) findViewById(R.h.cQb);
        this.tKj = findViewById(R.h.cPX);
        this.tKg = (RecyclerView) findViewById(R.h.bYR);
        this.tKm = new a();
        this.tKg.a(this.tKm);
        this.tKg.a(new LinearLayoutManager());
        this.tKm.tLq = new a.c() {
            public final void a(c cVar) {
                FtsBrowseHistoryUI.a(FtsBrowseHistoryUI.this, cVar);
            }

            public final void b(c cVar) {
                FtsBrowseHistoryUI.b(FtsBrowseHistoryUI.this, cVar);
            }
        };
        setMMTitle(R.l.ekA);
        this.tKj.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                g.pWK.h(14963, Integer.valueOf(6));
                FtsBrowseHistoryUI.a(FtsBrowseHistoryUI.this);
            }
        });
        this.tKn = AnimatorInflater.loadAnimator(this, R.b.bqK);
        this.tKn.setTarget(this.tKk);
        bUD();
        g.pWK.h(14963, Integer.valueOf(1));
        if (j.Rj().Rk()) {
            this.tKh.setVisibility(0);
            this.mxu.setVisibility(8);
            this.mck.setVisibility(8);
            as.Dt().F(new Runnable() {
                public final void run() {
                    x.i("FtsBrowseHistoryUI", "starting load data");
                    List bUO = FtsBrowseHistoryUI.this.tKe.bUO();
                    FtsBrowseHistoryUI.ct(bUO);
                    RecyclerView.a c = FtsBrowseHistoryUI.this.tKm;
                    c.hkf = bUO;
                    c.UR.notifyChanged();
                    x.i("FtsBrowseHistoryUI", "load data end list.size %d", Integer.valueOf(FtsBrowseHistoryUI.this.tKm.bUN()));
                    ah.y(new Runnable() {
                        public final void run() {
                            x.i("FtsBrowseHistoryUI", "updating ui");
                            FtsBrowseHistoryUI.this.bUE();
                        }
                    });
                }
            });
            return;
        }
        this.tKh.setVisibility(8);
        this.tKi.setVisibility(0);
        this.mck.setVisibility(8);
        this.mxu.setVisibility(8);
    }

    private void bUD() {
        if (j.Rj().Rk()) {
            addIconOptionMenu(0, R.k.dvh, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    final com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(FtsBrowseHistoryUI.this, com.tencent.mm.ui.widget.g.zCt, false);
                    gVar.rQF = new p.c() {
                        public final void a(n nVar) {
                            if (!FtsBrowseHistoryUI.this.tKe.isEmpty()) {
                                nVar.eT(0, R.l.elb);
                            }
                            if (j.Rj().Rk()) {
                                nVar.eT(2, R.l.eld);
                            }
                            nVar.eT(1, R.l.ekZ);
                        }
                    };
                    gVar.rQG = new p.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            com.tencent.mm.ui.base.j.b bVar;
                            switch (menuItem.getItemId()) {
                                case 0:
                                    bVar = new com.tencent.mm.ui.base.j.b(FtsBrowseHistoryUI.this.mController.xRr);
                                    bVar.Zr(FtsBrowseHistoryUI.this.mController.xRr.getString(R.l.ela));
                                    bVar.a(new com.tencent.mm.ui.base.j.a() {
                                        public final void cj(boolean z) {
                                            FtsBrowseHistoryUI.this.aWY();
                                            if (z) {
                                                FtsBrowseHistoryUI.this.tKm.ahM();
                                                FtsBrowseHistoryUI.this.bUE();
                                                FtsBrowseHistoryUI.this.tKe.bUP();
                                                g.pWK.h(14963, Integer.valueOf(4));
                                                gVar.bxR();
                                            }
                                        }
                                    }).pDT.show();
                                    return;
                                case 1:
                                    gVar.bxR();
                                    return;
                                case 2:
                                    bVar = new com.tencent.mm.ui.base.j.b(FtsBrowseHistoryUI.this.mController.xRr);
                                    bVar.Zr(FtsBrowseHistoryUI.this.mController.xRr.getString(R.l.elc));
                                    bVar.a(new com.tencent.mm.ui.base.j.a() {
                                        public final void cj(boolean z) {
                                            FtsBrowseHistoryUI.this.aWY();
                                            if (z) {
                                                FtsBrowseHistoryUI.e(FtsBrowseHistoryUI.this);
                                                g.pWK.h(14963, Integer.valueOf(5));
                                                gVar.bxR();
                                            }
                                        }
                                    }).pDT.show();
                                    return;
                                default:
                                    return;
                            }
                        }
                    };
                    gVar.bUX();
                    return true;
                }
            });
        }
    }

    private static void kE(boolean z) {
        j Rj = j.Rj();
        if (z) {
            Rj.hMO |= HardCoderJNI.ACTION_NET_RX;
        } else {
            Rj.hMO &= -131073;
        }
        int i = z ? 1 : 2;
        if (com.tencent.mm.kernel.g.Do().CF()) {
            as.Hm();
            com.tencent.mm.y.c.Db().set(147457, Long.valueOf(Rj.hMO));
            com.tencent.mm.bp.a wuVar = new wu();
            wuVar.wnP = 47;
            wuVar.wnQ = i;
            as.Hm();
            com.tencent.mm.y.c.Fe().b(new e.a(23, wuVar));
        }
    }

    private void bUE() {
        this.tKh.setVisibility(8);
        if (this.tKm.bUN() == 0) {
            this.mxu.setVisibility(0);
        } else {
            this.mck.setVisibility(0);
        }
    }

    protected final int getLayoutId() {
        return R.i.diT;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == 1) {
                    this.tKm.ahM();
                    bUE();
                    return;
                }
                return;
            default:
                super.onActivityResult(i, i2, intent);
                return;
        }
    }
}
