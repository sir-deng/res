package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.JsApiGetResPath;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.scanner.a.g;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.j;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.protocal.c.if;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class k extends i implements e, a {
    private static int qdy = 300;
    private int pYL;
    private TextView qap;
    private View qaq;
    g qdA;
    private int qdB = 0;
    private int qdC = 1;
    private long qdD;
    private final int qdE = GameJsApiLaunchApplication.CTRL_BYTE;
    private final int qdF = 300;
    private final int qdG = 390;
    private final int qdH = JsApiGetResPath.CTRL_INDEX;
    private final int qdI = 220;
    private final int qdJ = 240;
    private final int qdK = 330;
    private final int qdL = 360;
    private float qdM;
    private final long qdN = 30000;
    private long qdO;
    private final int qdP = 50;
    private com.tencent.mm.plugin.scanner.util.e.a qdQ = new com.tencent.mm.plugin.scanner.util.e.a() {
        public final void m(int i, Bundle bundle) {
            switch (i) {
                case 3:
                    k.this.qdm.bpJ();
                    return;
                default:
                    return;
            }
        }
    };
    private OnTouchListener qdR;
    private long qdz = 130;

    public k(b bVar, Point point) {
        super(bVar, point);
        if (d.ys()) {
            dp(220, 240);
            this.qdM = p.dt(330, this.qdi);
        } else {
            dp(GameJsApiLaunchApplication.CTRL_BYTE, 300);
            this.qdM = p.dt(390, this.qdi);
        }
        x.d("MicroMsg.scanner.ScanModeImage", "frameRectWidth = [%s], frameRectHeight = [%s], scaleRate = [%s]", Integer.valueOf(this.qdi), Integer.valueOf(this.qdj), Float.valueOf(this.qdM));
        if (bi.eZ(bVar.getContext()) < 100) {
            x.w("MicroMsg.scanner.ScanModeImage", "memory is not much");
            this.qdz = 300;
        }
        this.pYL = (int) (System.currentTimeMillis() & -1);
        this.qdO = System.currentTimeMillis();
    }

    protected final void h(Rect rect) {
        this.qaq = this.qdm.findViewById(R.h.cJc);
        this.qap = (TextView) this.qdm.findViewById(R.h.cJd);
        this.jIt = (TextView) this.qdm.findViewById(R.h.cJg);
        this.jIt.setText(p.ec(p.qhf, this.qdm.getContext().getString(R.l.eHU)));
        if (rect.bottom > 0) {
            LayoutParams layoutParams = (LayoutParams) this.jIt.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.b(this.qdm.getContext(), 13.0f);
            this.jIt.setLayoutParams(layoutParams);
        }
        if (d.ys()) {
            this.jIt.setPadding(BackwardSupportUtil.b.b(this.qdm.getContext(), 54.0f), this.jIt.getPaddingTop(), BackwardSupportUtil.b.b(this.qdm.getContext(), 54.0f), this.jIt.getPaddingBottom());
        }
        if (this.qdg != null) {
            ((j) this.qdg).ozC = this.qdm.bpI();
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
        return R.i.drn;
    }

    protected final com.tencent.mm.plugin.scanner.util.b bpu() {
        if (this.qdg == null) {
            int i = 50;
            if (q.gHF.gFU > 0) {
                i = q.gHF.gFU;
                x.d("MicroMsg.scanner.ScanModeImage", "ImageQuality=[%s]", Integer.valueOf(q.gHF.gFU));
            }
            if (ao.is2G(this.qdm.getContext())) {
                this.qdg = new j(this, i - 10, this.qdM, false, this.qdm.bpI());
            } else {
                this.qdg = new j(this, i, this.qdM, false, this.qdm.bpI());
            }
        }
        return this.qdg;
    }

    protected final void bpt() {
        if (this.qdm == null) {
            x.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
        } else {
            bpW();
        }
    }

    private void bpW() {
        if (this.qdm == null) {
            x.e("MicroMsg.scanner.ScanModeImage", "dealWithNetWork(), scanUICallback == null");
        } else if (as.CN().Ks() == 6 || as.CN().Ks() == 4) {
            this.qdm.ei(0);
        }
    }

    public final void a(int i, String str, byte[] bArr, int i2, int i3) {
        if (this.qdm == null) {
            x.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
        } else if (bArr == null || bArr.length <= 0) {
            x.w("MicroMsg.scanner.ScanModeImage", "greyData null");
            if (System.currentTimeMillis() - this.qdD <= this.qdz + 1800 || !((j) this.qdg).qgM) {
                this.qdm.eh(this.qdz);
                return;
            }
            this.qdD = System.currentTimeMillis();
            this.qdm.ei(0);
        } else {
            bpX();
            if (this.qdB >= this.qdC) {
                x.i("MicroMsg.scanner.ScanModeImage", "too quick to send image, return now");
                this.qdm.eh(this.qdz);
                if (System.currentTimeMillis() - this.qdD <= this.qdz + 1800 || !((j) this.qdg).qgM) {
                    this.qdm.eh(this.qdz);
                    return;
                }
                this.qdD = System.currentTimeMillis();
                this.qdm.ei(0);
                return;
            }
            this.qdA = new g(bArr, bArr.length, this.pYL);
            as.CN().a(this.qdA, 0);
            this.qdB++;
            this.qdn += bArr.length;
            x.d("MicroMsg.scanner.ScanModeImage", "totalNetworkFlow : [%s]", Integer.valueOf(this.qdn));
            if (System.currentTimeMillis() - this.qdD <= this.qdz + 1800 || !((j) this.qdg).qgM) {
                this.qdm.eh(this.qdz);
                return;
            }
            this.qdD = System.currentTimeMillis();
            this.qdm.ei(0);
        }
    }

    public final void bpp() {
        x.d("MicroMsg.scanner.ScanModeImage", "decodeFail");
        if (this.qdm == null) {
            x.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
            return;
        }
        bpX();
        if (System.currentTimeMillis() - this.qdD <= 1800 + this.qdz || !((j) this.qdg).qgM) {
            this.qdm.eh(this.qdz);
            return;
        }
        this.qdD = System.currentTimeMillis();
        this.qdm.ei(0);
    }

    private void bpX() {
        ah.y(new Runnable() {
            public final void run() {
                if (System.currentTimeMillis() - k.this.qdO > 30000) {
                    x.d("MicroMsg.scanner.ScanModeImage", "show scan img nothing recognize");
                    k.this.qdm.hL(true);
                    k.this.jIt.setVisibility(8);
                    k.this.qap.setText(R.l.eHS);
                    k.this.qap.setVisibility(0);
                    if (k.this.qdR == null) {
                        k.this.qdR = new OnTouchListener() {
                            public final boolean onTouch(View view, MotionEvent motionEvent) {
                                k.this.qdm.hL(false);
                                k.this.jIt.setVisibility(0);
                                k.this.jIt.setText(p.ec(p.qhf, k.this.qdm.getContext().getString(R.l.eHU)));
                                k.this.qap.setVisibility(8);
                                k.this.qdO = System.currentTimeMillis();
                                return false;
                            }
                        };
                    }
                    k.this.qaq.setOnTouchListener(k.this.qdR);
                }
            }
        });
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        this.qdB = 0;
        if (this.qdm == null || kVar == null) {
            boolean z;
            String str2 = "MicroMsg.scanner.ScanModeImage";
            String str3 = "onSceneEnd() scene is null [%s]";
            Object[] objArr = new Object[1];
            if (kVar == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.e(str2, str3, objArr);
        } else if (kVar.getType() == 1062) {
            if (i == 0 && i2 == 0) {
                this.qdB = this.qdC;
                g gVar = (g) kVar;
                if ifVar = (gVar.gLB == null || gVar.gLB.hnR.hnY == null) ? null : (if) gVar.gLB.hnR.hnY;
                if (ifVar != null) {
                    x.d("MicroMsg.scanner.ScanModeImage", "onSceneEnd() clientScanID = %s, imageType = %s", Integer.valueOf(ifVar.vUK), Integer.valueOf(ifVar.vUO));
                    switch (n.a(ifVar.kzz, ifVar.vUQ, this, 3, this.qdQ, 0, 0, false)) {
                        case 0:
                            this.qdm.bpC();
                            if (!(this.qdm == null || this.qdm.getContext() == null)) {
                                this.qdm.bpJ();
                                break;
                            }
                        case 1:
                            x.d("MicroMsg.scanner.ScanModeImage", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
                            break;
                        case 2:
                            x.e("MicroMsg.scanner.ScanModeImage", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
                            break;
                    }
                }
                x.e("MicroMsg.scanner.ScanModeImage", "onSceneEnd(), getResp() == null");
                return;
            }
            x.e("MicroMsg.scanner.ScanModeImage", "onSceneEnd() errType = [%s], errCode = [%s]", Integer.valueOf(i), Integer.valueOf(i2));
            this.jIt.setText(p.ec(p.qhf, this.qdm.getContext().getString(R.l.eHU)));
            if (this.qdA != null) {
                as.CN().c(this.qdA);
            }
        }
    }

    protected final void onResume() {
        as.CN().a(1062, (e) this);
        if (this.qdm == null) {
            x.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
            return;
        }
        this.qdB = 0;
        bpW();
    }

    protected final void onPause() {
        super.onPause();
        hN(false);
        as.CN().b(1062, (e) this);
    }

    protected final int bpw() {
        return qdy;
    }

    protected final void onDestroy() {
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
