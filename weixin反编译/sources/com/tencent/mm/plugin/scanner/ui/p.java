package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.ma;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.ac.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.scanner.a.f;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.plugin.scanner.util.b;
import com.tencent.mm.plugin.scanner.util.d;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.protocal.c.id;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bp;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class p extends i implements e, a, i.a, b.a {
    int bufferSize;
    int frr = 0;
    Object hrp = new Object();
    private int mMode = 0;
    private com.tencent.mm.plugin.scanner.util.e.a qdQ = new com.tencent.mm.plugin.scanner.util.e.a() {
        public final void m(int i, Bundle bundle) {
            x.i("MicroMsg.scanner.ScanModeQRCode", "notify Event: %d", Integer.valueOf(i));
            switch (i) {
                case 0:
                    p.this.qee = false;
                    return;
                case 1:
                    p.this.hw(true);
                    return;
                case 2:
                    p.this.hw(true);
                    return;
                case 3:
                    p.this.qdm.bpJ();
                    return;
                case 4:
                    if (bundle != null) {
                        String string = bundle.getString("geta8key_fullurl");
                        if (string != null && (string.startsWith("http://login.weixin.qq.com") || string.startsWith("https://login.weixin.qq.com"))) {
                            p.this.frr = 2;
                            break;
                        }
                    }
                    break;
                case 5:
                    break;
                default:
                    return;
            }
            p.this.qdm.hL(true);
            p.this.qee = true;
        }
    };
    long qdz = 80;
    d qec;
    AtomicBoolean qed = new AtomicBoolean(false);
    boolean qee = false;
    boolean qef = false;
    private float qeg = 1.5f;
    byte[] qeh;
    Point qei;
    int qej;
    private TextView qek;
    boolean qel = false;
    private OnClickListener qem = new OnClickListener() {
        public final void onClick(View view) {
            if (p.this.qdm == null) {
                x.e("MicroMsg.scanner.ScanModeQRCode", "toMyQRCodeOnclickListener scanUICallback == null");
                return;
            }
            g.pWK.h(11264, Integer.valueOf(3));
            com.tencent.mm.plugin.scanner.b.ihN.au(p.this.qdm.getContext());
        }
    };

    static /* synthetic */ void a(p pVar) {
        pVar.qef = true;
        pVar.qee = true;
        pVar.qdm.bpH();
    }

    public p(i.b bVar, Point point, int i, int i2) {
        super(bVar, point);
        dp(c.a.CTRL_INDEX, c.a.CTRL_INDEX);
        this.frr = i;
        this.mMode = i2;
        this.qdo = true;
        this.qde = 1000;
        if (bi.eZ(bVar.getContext()) < 100) {
            x.w("MicroMsg.scanner.ScanModeQRCode", "memory is not much");
            this.qdz = 280;
        }
    }

    protected final void f(Point point) {
        this.qdf = null;
        super.f(point);
    }

    protected final Rect hO(boolean z) {
        Rect rect = new Rect(y(true, z));
        x.i("MicroMsg.scanner.ScanModeQRCode", "display rect:" + rect);
        int width = rect.width();
        int height = rect.height();
        int i = (int) (((float) width) * this.qeg);
        int i2 = (int) (((float) height) * this.qeg);
        if (i > this.qdh.x) {
            i = this.qdh.x;
        }
        if (i2 > this.qdh.y) {
            i2 = this.qdh.y;
        }
        if (i2 % 2 == 1) {
            i2--;
        }
        if (i % 2 == 1) {
            i--;
        }
        x.i("MicroMsg.scanner.ScanModeQRCode", "newWidth:%d,newHeight:%d", Integer.valueOf(i), Integer.valueOf(i2));
        rect.left -= (i - width) / 2;
        rect.right = ((i - width) / 2) + rect.right;
        rect.top -= (i2 - height) / 2;
        rect.bottom += (i2 - height) / 2;
        x.i("MicroMsg.scanner.ScanModeQRCode", "scan rect:" + rect);
        return rect;
    }

    public final void bpY() {
        this.qdo = false;
    }

    public final boolean bpZ() {
        return this.qdo;
    }

    protected final void h(Rect rect) {
        this.qek = (TextView) this.qdm.findViewById(R.h.cJj);
        this.qek.setOnClickListener(this.qem);
        this.jIt = (TextView) this.qdm.findViewById(R.h.cJg);
        if (rect.bottom > 0) {
            this.qek.setVisibility(0);
            LayoutParams layoutParams = (LayoutParams) this.jIt.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.b(this.qdm.getContext(), 13.0f);
            this.jIt.setLayoutParams(layoutParams);
        }
        if (this.qec != null) {
            this.qec.ozC = this.qdm.bpI();
        }
        bpW();
        if (this.mMode == 2) {
            this.jIt.setText(R.l.eBv);
        } else if (this.mMode == 1) {
            this.jIt.setText(R.l.eBu);
        } else if (this.frr == 1) {
            this.jIt.setText(R.l.eBP);
        } else if (this.frr == 2) {
            this.jIt.setText(R.l.eXw);
        } else {
            this.jIt.setText(R.l.eBQ);
        }
        hN(true);
    }

    protected final void bpx() {
        h(new Rect(0, 0, 0, 0));
        if (this.mMode == 2) {
            this.qdm.b(4, null);
        } else {
            this.qdm.b(0, new OnClickListener() {
                public final void onClick(View view) {
                    p.a(p.this);
                }
            });
        }
        this.qdm.a(this);
        onResume();
    }

    protected final int bpv() {
        return R.i.drr;
    }

    protected final b bpu() {
        if (this.qec == null && this.qdm != null) {
            this.qec = new d(this, this.mMode, this.qdm.bpI());
        }
        return this.qec;
    }

    protected final void bpt() {
        if (this.qdm == null) {
            x.w("MicroMsg.scanner.ScanModeQRCode", "handleNetworkChange(), scanUICallback == null");
        } else {
            bpW();
        }
    }

    private void bpW() {
        if (this.qdm == null) {
            x.e("MicroMsg.scanner.ScanModeQRCode", "dealWithNetWork(), scanUICallback == null");
        } else if (as.CN().Ks() == 6 || as.CN().Ks() == 4) {
            this.qdm.ei(0);
        }
    }

    public final void a(int i, String str, byte[] bArr, int i2, int i3) {
        this.qed.set(false);
        if (this.qdm == null) {
            x.w("MicroMsg.scanner.ScanModeQRCode", "scanUICallback == null");
        } else if (this.qee) {
            x.w("MicroMsg.scanner.ScanModeQRCode", "is decoding, return");
        } else {
            this.qee = true;
            x.d("MicroMsg.scanner.ScanModeQRCode", "decode success:%s", str);
            if (bi.oN(str)) {
                this.qee = false;
            } else if (as.CN().Ks() == 0) {
                Toast.makeText(this.qdm.getContext(), this.qdm.getContext().getString(R.l.eiR), 0).show();
                this.qee = false;
            } else {
                m.qgZ.stop();
                m.qgZ.stop();
                b(i, str, i2, i3);
            }
        }
    }

    private void b(int i, String str, int i2, int i3) {
        int i4 = 1;
        Activity context = this.qdm.getContext();
        com.tencent.mm.sdk.b.b maVar = new ma();
        if (i == 1) {
            maVar.fEq.fEs = 0;
        } else {
            maVar.fEq.fEs = 1;
        }
        maVar.fEq.scanResult = str;
        if (this.qel) {
            x.d("MicroMsg.scanner.ScanModeQRCode", "need to finish on decode success");
            maVar.fEq.fEo = 1;
            com.tencent.mm.sdk.b.a.xmy.m(maVar);
            Intent intent = new Intent();
            intent.putExtra("key_scan_result", str);
            intent.putExtra("key_scan_result_type", i);
            intent.putExtra("key_scan_result_code_type", i2);
            intent.putExtra("key_scan_result_code_version", i3);
            context.setResult(-1, intent);
            context.finish();
            context.overridePendingTransition(0, 0);
            return;
        }
        maVar.fEq.fEo = 0;
        com.tencent.mm.sdk.b.a.xmy.m(maVar);
        if (maVar.fEr.ret == 1 || maVar.fEr.ret == 2) {
            context.finish();
            context.overridePendingTransition(0, 0);
        }
        if (i == 1) {
            this.qdm.bpC();
            this.qdm.hL(true);
            this.qee = false;
            if (maVar.fEr.ret != 2) {
                if (!this.qef) {
                    i4 = 0;
                }
                this.qdm.a(str, i4, i2, i3, this.qdQ);
            }
        } else if (i != 2) {
        } else {
            if (str == null || str.length() <= 0) {
                x.e("MicroMsg.scanner.ScanModeQRCode", "result is null");
                this.qee = false;
                this.qdm.hL(false);
                return;
            }
            String[] split = str.split(",", 2);
            if (split == null || split.length < 2) {
                x.e("MicroMsg.scanner.ScanModeQRCode", "wrong zbar format");
                this.qee = false;
                this.qdm.hL(false);
                return;
            }
            final k fVar = new f(com.tencent.mm.plugin.scanner.util.p.Js(split[0]), split[1], i2, i3);
            fVar.pYM = this.qef;
            as.CN().a(fVar, 0);
            this.qdm.bpC();
            this.qdm.hL(true);
            Context context2 = this.qdm.getContext();
            this.qdm.getContext().getString(R.l.dGZ);
            this.inI = h.a(context2, this.qdm.getContext().getString(R.l.eBO), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    as.CN().c(fVar);
                    p.this.qdm.hL(false);
                    p.this.qee = false;
                }
            });
        }
    }

    public final void bpp() {
        x.i("MicroMsg.scanner.ScanModeQRCode", "decodeFail");
        this.qed.set(false);
        synchronized (this.hrp) {
            bqa();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd: errType = [%s] errCode = [%s] errMsg = [%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.inI != null) {
            this.inI.dismiss();
            this.inI = null;
        }
        if (this.qdm == null || kVar == null) {
            String str2 = "MicroMsg.scanner.ScanModeQRCode";
            String str3 = "onSceneEnd() scene is null [%s]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(kVar == null);
            x.e(str2, str3, objArr);
            this.qee = false;
        } else if (i == 4 && i2 == -4) {
            h.a(this.qdm.getContext(), R.l.eBJ, R.l.dGZ, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    p.this.hw(true);
                }
            });
        } else {
            boolean z;
            switch (i) {
                case 1:
                    if (as.CN().Kt()) {
                        this.qdm.getContext();
                        as.CN().getNetworkServerIp();
                        new StringBuilder().append(i2);
                    } else if (ab.bC(this.qdm.getContext())) {
                        com.tencent.mm.pluginsdk.ui.k.ep(this.qdm.getContext());
                    } else {
                        Toast.makeText(this.qdm.getContext(), this.qdm.getContext().getString(R.l.eiQ, new Object[]{Integer.valueOf(1), Integer.valueOf(i2)}), 1).show();
                    }
                    z = true;
                    break;
                case 2:
                    Toast.makeText(this.qdm.getContext(), this.qdm.getContext().getString(R.l.eiR, new Object[]{Integer.valueOf(2), Integer.valueOf(i2)}), 1).show();
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                hw(true);
            } else if (i == 4 && i2 == -2004) {
                h.h(this.qdm.getContext(), R.l.eBE, R.l.dGZ);
                hw(true);
            } else if (i != 0 || i2 != 0) {
                Toast.makeText(this.qdm.getContext(), this.qdm.getContext().getString(R.l.ejr, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                hw(true);
            } else if (kVar.getType() == 1061) {
                id bpl = ((f) kVar).bpl();
                if (bpl == null) {
                    x.e("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd(), getResp() == null");
                    hw(true);
                    return;
                }
                x.d("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() ScanBarcode Type = %s", Integer.valueOf(bpl.kzz));
                if (bi.oN(bpl.vUI)) {
                    hw(true);
                    return;
                }
                switch (n.a(bpl.kzz, bpl.vUI, this, 4, this.qdQ, ((f) kVar).fqW, ((f) kVar).fqX, ((f) kVar).pYM)) {
                    case 0:
                        this.qdm.getContext().finish();
                        this.qdm.getContext().overridePendingTransition(0, 0);
                        return;
                    case 1:
                        x.d("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
                        break;
                    case 2:
                        x.e("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
                        this.qdm.ei(0);
                        break;
                }
                this.qdm.hL(false);
            } else if (kVar.getType() == 666) {
                if (kVar instanceof aa) {
                    this.qdm.hL(true);
                    this.qdm.getContext().finish();
                    this.qdm.getContext().overridePendingTransition(0, 0);
                }
            } else if (kVar.getType() == 971) {
                this.qdm.hL(true);
                this.qdm.getContext().finish();
                this.qdm.getContext().overridePendingTransition(0, 0);
            }
        }
    }

    protected final void onResume() {
        as.CN().a(1061, (e) this);
        as.CN().a(666, (e) this);
        as.CN().a(971, (e) this);
        if (this.qdm == null) {
            x.w("MicroMsg.scanner.ScanModeQRCode", "scanUICallback == null");
            return;
        }
        if (!this.qef) {
            this.qee = false;
        }
        bpW();
    }

    protected final void onPause() {
        super.onPause();
        hN(false);
        as.CN().b(1061, (e) this);
        as.CN().b(666, (e) this);
        as.CN().b(971, (e) this);
    }

    protected final int bpw() {
        return c.a.CTRL_INDEX;
    }

    public final void b(final Activity activity, int i, int i2, Intent intent) {
        if (activity != null) {
            this.qee = true;
            if (i2 != -1) {
                this.qee = false;
                this.qed.set(false);
                this.qef = false;
                return;
            }
            switch (i) {
                case 1:
                    this.qdm.bpK();
                    return;
                case 4660:
                    if (intent == null) {
                        x.e("MicroMsg.scanner.ScanModeQRCode", "onActivityResult data == null");
                        this.qee = false;
                        this.qed.set(false);
                        this.qef = false;
                        return;
                    }
                    this.qed.set(true);
                    as.Hm();
                    x.d("MicroMsg.scanner.ScanModeQRCode", "select: [%s]", com.tencent.mm.ui.tools.a.c(activity, intent, com.tencent.mm.y.c.Fp()));
                    new ag().post(new Runnable() {
                        public final void run() {
                            p pVar = p.this;
                            Context context = activity;
                            activity.getString(R.l.dGZ);
                            pVar.inI = h.a(context, activity.getString(R.l.eBM), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    p.this.qee = false;
                                    p.this.qed.set(false);
                                    p.this.qef = false;
                                }
                            });
                        }
                    });
                    if (this.qec != null) {
                        this.qec.kM();
                    }
                    if (this.qdm != null) {
                        this.qdm.hL(true);
                    }
                    l.pYQ.reset();
                    com.tencent.mm.plugin.scanner.c.bpi().pYc.a(r0, new com.tencent.mm.plugin.ac.a.b.a() {
                        public final void k(String str, String str2, int i, int i2) {
                            int i3 = 1;
                            l.pYQ.vW(l.pYO);
                            if (p.this.qec != null) {
                                p.this.qec.bqd();
                            }
                            if (p.this.inI == null || !p.this.inI.isShowing()) {
                                p.this.qee = false;
                                p.this.qef = false;
                                return;
                            }
                            if (p.this.qdm != null) {
                                p.this.qdm.hL(true);
                            }
                            p.this.inI.dismiss();
                            if (bi.oN(str2)) {
                                l.pYQ.aUI();
                                h.a(activity, R.l.eBL, R.l.dGZ, new DialogInterface.OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        p.this.qee = false;
                                        p.this.qef = false;
                                        l.pYQ.reset();
                                        l.pYQ.vW(l.pYN);
                                        if (p.this.qdm != null) {
                                            p.this.qdm.hL(false);
                                            p.this.qdm.eh(p.this.qdz);
                                        }
                                    }
                                });
                                return;
                            }
                            bp.HY().c(10237, Integer.valueOf(1));
                            p.this.qdm.bpC();
                            if (!(i == 19 || i == 22)) {
                                i3 = 2;
                            }
                            p.this.b(i3, str2, i, i2);
                            p.this.qef = false;
                            p.this.qed.set(false);
                        }

                        public final void IC(String str) {
                            l.pYQ.vW(l.pYO);
                            if (p.this.qec != null) {
                                p.this.qec.bqd();
                            }
                            if (p.this.inI == null || !p.this.inI.isShowing()) {
                                p.this.qee = false;
                                p.this.qed.set(false);
                                p.this.qef = false;
                                return;
                            }
                            if (p.this.qdm != null) {
                                p.this.qdm.hL(true);
                            }
                            p.this.inI.dismiss();
                            l.pYQ.aUI();
                            h.a(activity, R.l.eBL, R.l.dGZ, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    p.this.qee = false;
                                    p.this.qef = false;
                                    l.pYQ.reset();
                                    l.pYQ.vW(l.pYN);
                                    if (p.this.qdm != null) {
                                        p.this.qdm.hL(false);
                                        p.this.qdm.eh(p.this.qdz);
                                    }
                                }
                            });
                            p.this.qed.set(false);
                        }
                    }, null);
                    return;
                default:
                    return;
            }
        }
    }

    protected final void onDestroy() {
        this.qeh = null;
    }

    public final Context getContext() {
        if (this.qdm != null) {
            return this.qdm.getContext();
        }
        x.e("MicroMsg.scanner.ScanModeQRCode", "getContext(), scanUICallback == null");
        return null;
    }

    public final void hw(boolean z) {
        if (this.qdm == null) {
            x.e("MicroMsg.scanner.ScanModeQRCode", "continueScan, scanUICallback == null");
        } else if (z) {
            this.qdm.hL(false);
        } else {
            this.qdm.getContext().finish();
            this.qdm.getContext().overridePendingTransition(0, 0);
        }
    }

    protected final boolean bpy() {
        return true;
    }

    protected final boolean bpz() {
        return true;
    }

    public final void D(Bundle bundle) {
        if (bundle.containsKey("zoom_action") && bundle.containsKey("zoom_type") && bundle.containsKey("zoom_scale") && this.qdm != null) {
            this.qdm.W(bundle.getInt("zoom_action"), bundle.getInt("zoom_type"), bundle.getInt("zoom_scale"));
        }
    }

    private void bqa() {
        if (!this.qed.get() && this.bufferSize > 0) {
            this.qed.set(true);
            this.bufferSize--;
            if (l.pYQ.pYT % 2 == 0 && (this.mMode == 1 || this.mMode == 0)) {
                ((d) bpu()).qfM = 3;
            } else {
                ((d) bpu()).qfM = this.mMode;
            }
            x.i("MicroMsg.scanner.ScanModeQRCode", "try decode,buffer size:" + this.bufferSize);
            if (l.pYQ.pYT > 0 && this.qdm != null) {
                this.qdm.eh(30);
            }
            if (!(this.qeh == null || this.qei == null)) {
                d dVar = (d) bpu();
                Set dr = d.dr(dVar.qfM, 0);
                if (dVar.qfK) {
                    dVar.f(dr);
                }
                com.tencent.mm.sdk.f.e.b(new com.tencent.mm.plugin.scanner.util.d.AnonymousClass1(this.qeh, this.qei), "scan_decode", 10);
            }
            if (l.pYQ.pYT == 30 && this.qdm != null) {
                this.qdm.bpM();
            }
        } else if (this.qdm != null) {
            this.qdm.eh(0);
        }
    }

    protected final void a(byte[] bArr, Point point, int i, Rect rect) {
        synchronized (this.hrp) {
            if (this.bufferSize == 1) {
                x.d("MicroMsg.scanner.ScanModeQRCode", "decode too slow");
                this.bufferSize = 0;
            }
        }
        if (this.qei == null) {
            this.qei = new Point();
        }
        final byte[] bArr2 = bArr;
        final Point point2 = point;
        final int i2 = i;
        final Rect rect2 = rect;
        com.tencent.mm.sdk.f.e.post(new Runnable() {
            public final void run() {
                Object a = ((d) p.this.bpu()).a(bArr2, point2, i2, rect2, p.this.qei);
                if (a != null) {
                    if (p.this.qeh == null || p.this.qej < a.length) {
                        p.this.qeh = new byte[a.length];
                        p.this.qej = a.length;
                    }
                    System.arraycopy(a, 0, p.this.qeh, 0, a.length);
                    synchronized (p.this.hrp) {
                        p pVar = p.this;
                        pVar.bufferSize++;
                        p.this.bqa();
                    }
                }
            }
        }, "prepare_decode_data");
    }
}
