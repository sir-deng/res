package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.protocal.c.ayn;
import com.tencent.mm.protocal.c.bfg;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.LinkedList;
import java.util.Map;

@g(cfE = {BaseScanUI.class})
public final class q extends i implements e, com.tencent.mm.plugin.scanner.util.b.a {
    private static int qdy = 300;
    private float gAh;
    private float gAi;
    private com.tencent.mm.modelgeo.a.a gAn = new com.tencent.mm.modelgeo.a.a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!z) {
                return true;
            }
            q.this.gAh = f2;
            q.this.gAi = f;
            q.this.qev = (int) d2;
            q.this.qew = "";
            q.this.qex = "";
            q.this.qeu = i;
            q.this.qey = true;
            q.b(q.this);
            if (!q.this.hrB) {
                q.this.hrB = true;
                o.a(2012, f, f2, (int) d2);
            }
            return false;
        }
    };
    private boolean hrB = false;
    private c hry;
    private float pitch = -10000.0f;
    private TextView qap;
    private final int qdE = GameJsApiLaunchApplication.CTRL_BYTE;
    private final int qdF = 300;
    private final int qdI = 220;
    private final int qdJ = 240;
    private boolean qeA = false;
    private boolean qeB = false;
    private boolean qeC = false;
    private a qeD;
    protected ag qeE = new ag() {
        public final void handleMessage(Message message) {
            if (q.this.qap != null) {
                q.this.qdm.hL(true);
                q.this.qap.setText(R.l.eIx);
                q.this.qap.setVisibility(0);
            }
        }
    };
    private int qeu;
    private int qev;
    private String qew;
    private String qex;
    private boolean qey = false;
    private float qez = -10000.0f;

    private final class a implements Runnable {
        String url;

        private a() {
        }

        /* synthetic */ a(q qVar, byte b) {
            this();
        }

        public final void run() {
            if (q.this.qdm != null && !q.this.qeA) {
                r.a(new com.tencent.mm.pluginsdk.ui.tools.e());
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("jsapi_args_appid", "wx751a1acca5688ba3");
                intent.putExtra("jsapiargs", bundle);
                intent.putExtra("rawUrl", this.url);
                intent.putExtra("show_bottom", false);
                intent.putExtra("title", R.l.eHO);
                intent.putExtra("webview_bg_color_rsID", R.e.black);
                intent.putExtra("geta8key_scene", 13);
                intent.setFlags(65536);
                b.ihN.j(intent, q.this.qdm.getContext());
                q.this.qdm.getContext().finish();
                q.this.qdm.getContext().overridePendingTransition(0, 0);
            }
        }
    }

    static /* synthetic */ void b(q qVar) {
        if (!qVar.qey || qVar.qeA || qVar.qeC) {
            x.i("MicroMsg.scanner.ScanModeStreetView", "!hasGetLbsInfo || hasPause || hasDoScene,abort");
            return;
        }
        qVar.qeC = true;
        ayn ayn = new ayn();
        ayn.wjx = qVar.qex;
        ayn.wjy = qVar.qeu;
        ayn.vXy = qVar.gAh;
        ayn.vXx = qVar.gAi;
        ayn.wjw = qVar.qew;
        ayn.wjv = qVar.qev;
        if (as.Hp()) {
            as.CN().a(new ab(ayn, qVar.qez, qVar.pitch), 0);
        }
    }

    public q(i.b bVar, Point point) {
        super(bVar, point);
        if (d.ys()) {
            dp(220, 240);
        } else {
            dp(GameJsApiLaunchApplication.CTRL_BYTE, 300);
        }
    }

    protected final void h(Rect rect) {
        this.qap = (TextView) this.qdm.findViewById(R.h.cJd);
        this.qap.setText(R.l.eIf);
        this.jIt = (TextView) this.qdm.findViewById(R.h.cJg);
        if (rect.bottom > 0) {
            LayoutParams layoutParams = (LayoutParams) this.jIt.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.b(this.qdm.getContext(), 13.0f);
            this.jIt.setLayoutParams(layoutParams);
        }
        if (d.ys()) {
            this.jIt.setPadding(BackwardSupportUtil.b.b(this.qdm.getContext(), 54.0f), this.jIt.getPaddingTop(), BackwardSupportUtil.b.b(this.qdm.getContext(), 54.0f), this.jIt.getPaddingBottom());
        }
        bpW();
        hN(true);
    }

    protected final void bpx() {
        h(new Rect(0, 0, 0, 0));
        this.qdm.b(4, null);
        onResume();
    }

    protected final int bpv() {
        return R.i.drs;
    }

    protected final com.tencent.mm.plugin.scanner.util.b bpu() {
        return null;
    }

    protected final void bpt() {
        if (this.qdm == null) {
            x.w("MicroMsg.scanner.ScanModeStreetView", "handleNetworkChange(), scanUICallback == null");
        } else {
            bpW();
        }
    }

    private void bpW() {
        if (this.qdm == null) {
            x.e("MicroMsg.scanner.ScanModeStreetView", "dealWithNetWork(), scanUICallback == null");
        } else if (this.qeB) {
            this.qdm.hL(true);
        } else if (!as.Hp()) {
        } else {
            if (as.CN().Ks() == 6 || as.CN().Ks() == 4) {
                this.qdm.ei(0);
                if (this.hry != null) {
                    return;
                }
                if (this.qdm == null) {
                    x.w("MicroMsg.scanner.ScanModeStreetView", "initLBS(), scanUICallback == null");
                    return;
                }
                if (this.hry == null) {
                    this.hry = c.OV();
                }
                this.gAh = -85.0f;
                this.gAi = -1000.0f;
                this.qev = DownloadResult.CODE_UNDEFINED;
                this.qeu = 1;
                this.qew = "";
                this.qex = "";
                this.hry.a(this.gAn, true);
            }
        }
    }

    public final void a(int i, String str, byte[] bArr, int i2, int i3) {
    }

    public final void bpp() {
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.qdm == null) {
            x.w("MicroMsg.scanner.ScanModeStreetView", "onSceneEnd(), scanUICallback == null");
            return;
        }
        this.qeC = false;
        switch (kVar.getType()) {
            case 424:
                if (i == 0 && i2 == 0) {
                    this.qeC = true;
                    bfg Su = ((ab) kVar).Su();
                    if (Su == null || Su.vUQ == null) {
                        x.d("MicroMsg.scanner.ScanModeStreetView", "resp null");
                        return;
                    }
                    x.i("MicroMsg.scanner.ScanModeStreetView", "onSceneEnd() errType = [%s], errCode = [%s], resp.Type=[%s]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(Su.kzz));
                    String mC;
                    if (Su.kzz == 0) {
                        mC = ab.mC(Su.vUQ);
                        if (bi.oN(mC)) {
                            x.e("MicroMsg.scanner.ScanModeStreetView", "SCAN_STREET_VIEW_TYPE_STREETVIEW url is null");
                            return;
                        }
                        if (this.qeD == null) {
                            this.qeD = new a();
                        }
                        this.qeD.url = mC;
                        ah.K(this.qeD);
                        ah.h(this.qeD, 800);
                        return;
                    } else if (Su.kzz == 2) {
                        if (this.qeE != null && !this.qeA) {
                            this.qeE.removeMessages(0);
                            this.qeE.sendEmptyMessageDelayed(0, 1000);
                            return;
                        }
                        return;
                    } else if (Su.kzz == 1) {
                        try {
                            mC = Su.vUQ;
                            if (mC != null) {
                                Map y = bj.y(mC, "recommend");
                                if (y != null) {
                                    LinkedList f = ab.b.f(y, ".recommend");
                                    ab.b bVar = new ab.b();
                                    bVar.title = bi.oM((String) y.get(".recommend.title"));
                                    bVar.desc = bi.oM((String) y.get(".recommend.desc"));
                                    bVar.hPU = f;
                                    return;
                                }
                                return;
                            }
                            return;
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.scanner.ScanModeStreetView", e, "", new Object[0]);
                            x.e("MicroMsg.scanner.ScanModeStreetView", "MM_SCAN_STREET_VIEW_TYPE_RECOMMEND， [%s]", e.getMessage());
                            return;
                        }
                    } else {
                        return;
                    }
                }
                x.e("MicroMsg.scanner.ScanModeStreetView", "onSceneEnd() errType = [%s], errCode = [%s]", Integer.valueOf(i), Integer.valueOf(i2));
                return;
            default:
                return;
        }
    }

    protected final void onResume() {
        if (as.Hp()) {
            as.CN().a(424, (e) this);
        }
        if (this.qdm == null) {
            x.w("MicroMsg.scanner.ScanModeStreetView", "scanUICallback == null");
        } else {
            bpW();
        }
    }

    protected final void onPause() {
        this.qeA = true;
        hN(false);
        if (as.Hp()) {
            as.CN().b(424, (e) this);
        }
        if (this.hry != null) {
            this.hry.c(this.gAn);
        }
        if (this.qeE != null) {
            this.qeE.removeMessages(0);
        }
    }

    protected final void onDestroy() {
    }

    protected final int bpw() {
        return qdy;
    }

    protected final boolean bpy() {
        return true;
    }

    protected final boolean bpz() {
        return true;
    }

    public final void D(Bundle bundle) {
    }
}
