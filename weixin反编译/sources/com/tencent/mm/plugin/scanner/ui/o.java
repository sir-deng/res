package com.tencent.mm.plugin.scanner.ui;

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
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckIsSupportSoterAuthentication;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.j;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.protocal.c.aua;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class o extends i implements e, a {
    private int pYL;
    int qdB = 0;
    int qdC = 2;
    private long qdD;
    private final int qdE = 184;
    private final int qdF = 46;
    private final int qdG = JsApiCheckIsSupportSoterAuthentication.CTRL_INDEX;
    private final int qdH = 70;
    private float qdM;
    private final int qdP = 50;
    com.tencent.mm.plugin.scanner.a.e qdU;
    private int qdV = 0;
    private TextView qdW;
    private TextView qdX;
    private final int qdY = 5000;
    private final int qdZ = 8000;
    private ag qea = new ag() {
        public final void handleMessage(Message message) {
            if (o.this.qdB >= o.this.qdC) {
                if (o.this.qdU != null) {
                    as.CN().c(o.this.qdU);
                }
                o oVar = o.this;
                oVar.qdB--;
            }
        }
    };

    public o(b bVar, Point point) {
        super(bVar, point, (byte) 0);
        dp(184, 46);
        this.qdM = p.dt(JsApiCheckIsSupportSoterAuthentication.CTRL_INDEX, this.qdi);
        x.d("MicroMsg.scanner.ScanModeOCR", "frameRectWidth = [%s], frameRectHeight = [%s], scaleRate = [%s]", Integer.valueOf(this.qdi), Integer.valueOf(this.qdj), Float.valueOf(this.qdM));
        this.pYL = (int) (System.currentTimeMillis() & -1);
    }

    protected final void h(Rect rect) {
        this.jIt = (TextView) this.qdm.findViewById(R.h.cJg);
        this.qdX = (TextView) this.qdm.findViewById(R.h.cBE);
        this.qdW = (TextView) this.qdm.findViewById(R.h.cBF);
        this.jIt = (TextView) this.qdm.findViewById(R.h.cJg);
        if (rect.bottom > 0) {
            LayoutParams layoutParams = (LayoutParams) this.jIt.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.b(this.qdm.getContext(), 13.0f);
            this.jIt.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) this.qdW.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.b(this.qdm.getContext(), 13.0f);
            this.qdW.setLayoutParams(layoutParams);
            this.qdW.setVisibility(4);
        }
        if (d.ys()) {
            this.jIt.setPadding(BackwardSupportUtil.b.b(this.qdm.getContext(), 54.0f), this.jIt.getPaddingTop(), BackwardSupportUtil.b.b(this.qdm.getContext(), 54.0f), this.jIt.getPaddingBottom());
            this.qdW.setPadding(BackwardSupportUtil.b.b(this.qdm.getContext(), 54.0f), this.qdW.getPaddingTop(), BackwardSupportUtil.b.b(this.qdm.getContext(), 54.0f), this.qdW.getPaddingBottom());
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
        this.qdm.ei(0);
        onResume();
    }

    protected final int bpv() {
        return R.i.drp;
    }

    protected final com.tencent.mm.plugin.scanner.util.b bpu() {
        if (this.qdg == null) {
            int i = 50;
            if (q.gHF.gFU > 0) {
                i = q.gHF.gFU;
                x.d("MicroMsg.scanner.ScanModeOCR", "ImageQuality=[%s]", Integer.valueOf(q.gHF.gFU));
            }
            if (ao.is2G(this.qdm.getContext())) {
                this.qdg = new j(this, i - 10, this.qdM, true, this.qdm.bpI());
            } else {
                this.qdg = new j(this, i, this.qdM, true, this.qdm.bpI());
            }
        }
        return this.qdg;
    }

    protected final void bpt() {
        if (this.qdm == null) {
            x.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
        } else {
            bpW();
        }
    }

    private void bpW() {
        if (this.qdm == null) {
            x.e("MicroMsg.scanner.ScanModeOCR", "dealWithNetWork(), scanUICallback == null");
        } else if (as.CN().Ks() == 6 || as.CN().Ks() == 4) {
            this.qdm.ei(0);
        } else {
            this.qdW.setText("");
            this.qdX.setText("");
            this.qdm.hL(true);
        }
    }

    public final void a(int i, String str, byte[] bArr, int i2, int i3) {
        if (this.qdm == null) {
            x.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
        } else if (bArr == null || bArr.length <= 0) {
            String str2 = "MicroMsg.scanner.ScanModeOCR";
            String str3 = "greyData null:[%s]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(bArr == null);
            x.w(str2, str3, objArr);
            if (System.currentTimeMillis() - this.qdD <= 1840 || !((j) this.qdg).qgM) {
                this.qdm.eh(40);
            } else {
                this.qdD = System.currentTimeMillis();
                this.qdm.ei(0);
            }
            this.qdV = 0;
        } else if (this.qdB >= this.qdC) {
            if (System.currentTimeMillis() - this.qdD <= 1840 || !((j) this.qdg).qgM) {
                this.qdm.eh(40);
            } else {
                this.qdD = System.currentTimeMillis();
                this.qdm.ei(0);
            }
            x.w("MicroMsg.scanner.ScanModeOCR", "hasDoSceneCount[%s], maxDoSceneCount[%s]", Integer.valueOf(this.qdB), Integer.valueOf(this.qdC));
        } else {
            this.qdU = new com.tencent.mm.plugin.scanner.a.e(bArr, "en", "zh_CN", this.pYL);
            as.CN().a(this.qdU, 0);
            this.qdB++;
            this.qea.removeMessages(0);
            if (ao.is2G(this.qdm.getContext())) {
                this.qea.sendEmptyMessageDelayed(0, 8000);
            } else {
                this.qea.sendEmptyMessageDelayed(0, 5000);
            }
            this.qdn += bArr.length;
            x.d("MicroMsg.scanner.ScanModeOCR", "totalNetworkFlow[%s], hasTakePicNum[%s], maxDoSceneCount[%s]", Integer.valueOf(this.qdn), Integer.valueOf(this.qdV), Integer.valueOf(this.qdC));
            if (System.currentTimeMillis() - this.qdD <= 1840 || !((j) this.qdg).qgM) {
                this.qdm.eh(40);
            } else {
                this.qdD = System.currentTimeMillis();
                this.qdm.ei(0);
            }
            x.v("MicroMsg.scanner.ScanModeOCR", "onDecodeFinished:" + this.qdB + "," + this.qdV);
        }
    }

    public final void bpp() {
        x.d("MicroMsg.scanner.ScanModeOCR", "decodeFail");
        if (this.qdm == null) {
            x.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
        } else if (System.currentTimeMillis() - this.qdD <= 1840 || !((j) this.qdg).qgM) {
            this.qdm.eh(40);
        } else {
            this.qdD = System.currentTimeMillis();
            this.qdm.ei(0);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        this.qea.removeMessages(0);
        switch (kVar.getType()) {
            case 392:
                this.qdB--;
                if (i == 0 && i2 == 0) {
                    aua aua;
                    x.d("MicroMsg.scanner.ScanModeOCR", "onSceneEnd() errType = [%s], errCode = [%s]", Integer.valueOf(i), Integer.valueOf(i2));
                    com.tencent.mm.plugin.scanner.a.e eVar = (com.tencent.mm.plugin.scanner.a.e) kVar;
                    if (eVar.gLB == null || eVar.gLB.hnR.hnY == null) {
                        aua = null;
                    } else {
                        aua = (aua) eVar.gLB.hnR.hnY;
                    }
                    if (aua == null) {
                        x.e("MicroMsg.scanner.ScanModeOCR", "onSceneEnd(), getResp() == null");
                        ea(null, null);
                        return;
                    }
                    x.d("MicroMsg.scanner.ScanModeOCR", "onSceneEnd() clientScanID = %s, imageType = %s, source = %s, translate = %s", Integer.valueOf(aua.vUK), Integer.valueOf(aua.vUO), aua.wIO, aua.wIP);
                    if (!bi.oN(aua.wIP)) {
                        ea(aua.wIO, aua.wIP);
                        if (this.qdU != null) {
                            as.CN().c(this.qdU);
                            return;
                        }
                        return;
                    }
                    return;
                }
                x.e("MicroMsg.scanner.ScanModeOCR", "onSceneEnd() errType = [%s], errCode = [%s]", Integer.valueOf(i), Integer.valueOf(i2));
                this.qdD -= 300;
                ea(null, null);
                return;
            default:
                return;
        }
    }

    private void ea(String str, String str2) {
        if (bi.oN(str)) {
            this.qdW.setText("");
        } else {
            this.jIt.setVisibility(8);
            this.qdW.setText(str);
            this.qdW.setVisibility(0);
        }
        if (bi.oN(str2)) {
            this.qdX.setText("");
            return;
        }
        this.jIt.setVisibility(8);
        this.qdX.setText(str2);
        this.qdX.setVisibility(0);
    }

    protected final void onResume() {
        as.CN().a(392, (e) this);
        if (this.qdm == null) {
            x.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
        } else {
            bpW();
        }
    }

    protected final void onPause() {
        hN(false);
        as.CN().b(392, (e) this);
    }

    protected final int bpw() {
        return 0;
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
