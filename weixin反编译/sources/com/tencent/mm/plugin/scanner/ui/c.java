package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.f.a.ol;
import com.tencent.mm.plugin.scanner.util.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.protocal.c.ig;
import com.tencent.mm.protocal.c.ih;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.as;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public abstract class c extends i implements a {
    private long pZL;
    int pZM;
    private HighlightRectSideView pZN;
    k pZO;
    private r pZP;
    private i pZQ;

    protected abstract b a(a aVar);

    protected abstract float bpq();

    protected abstract String bpr();

    protected abstract int bps();

    static /* synthetic */ void a(c cVar, final String str) {
        if (cVar.pZQ != null) {
            cVar.pZQ.dismiss();
        }
        cVar.pZQ = h.a(cVar.qdm.getContext(), R.l.eHX, R.l.dGZ, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                as.CN().c(c.this.pZO);
                com.tencent.mm.sdk.b.b olVar = new ol();
                olVar.fHf.cardType = str;
                olVar.fHf.fHg = 2;
                com.tencent.mm.sdk.b.a.xmy.m(olVar);
                c.this.qdm.getContext().finish();
            }
        }, null);
    }

    public c(i.b bVar, Point point, DisplayMetrics displayMetrics, int i) {
        super(bVar, point);
        this.pZM = 0;
        this.pZO = null;
        this.pZP = null;
        this.pZQ = null;
        this.qdk = 0;
        this.qdl = 0;
        float bpq = bpq();
        Point point2 = i == 1 ? new Point(displayMetrics.widthPixels, displayMetrics.heightPixels) : new Point(displayMetrics.heightPixels, displayMetrics.widthPixels);
        int i2 = (int) (((float) point2.y) * 0.8f);
        int i3 = (int) (((float) point2.x) * 0.8f);
        if (((float) i2) * bpq > ((float) point2.x)) {
            i2 = (int) (((float) i3) / bpq);
        } else {
            i3 = (int) (((float) i2) * bpq);
        }
        Point point3 = new Point((int) (((float) i3) / displayMetrics.density), (int) (((float) i2) / displayMetrics.density));
        this.qdl = (int) (((((float) point2.y) / displayMetrics.density) - ((float) point3.y)) / 2.0f);
        dp(point3.x, point3.y);
        if (bi.eZ(bVar.getContext()) < 100) {
            x.w("MicroMsg.BaseScanModeLicence", "memory is not much");
            this.pZL = 280;
            return;
        }
        this.pZL = 80;
    }

    protected final void onResume() {
    }

    protected final void onDestroy() {
    }

    protected final void bpt() {
    }

    protected final b bpu() {
        if (this.qdg == null) {
            this.qdg = a(this);
        }
        return this.qdg;
    }

    protected final int bpv() {
        return R.i.dro;
    }

    protected final int bpw() {
        return 0;
    }

    protected final void bpx() {
    }

    protected final void cr(View view) {
        if (view != null) {
            TextView textView = (TextView) view.findViewById(R.h.bSm);
            if (textView != null) {
                textView.setText(view.getContext().getString(R.l.eHW, new Object[]{view.getContext().getString(bps())}));
            }
        }
    }

    protected final boolean bpy() {
        return false;
    }

    protected final boolean bpz() {
        return false;
    }

    protected final void h(Rect rect) {
        x.d("MicroMsg.BaseScanModeLicence", "smoothie, maskRect = %s", rect);
        HighlightRectSideView highlightRectSideView = (HighlightRectSideView) this.qdm.findViewById(R.h.bQO);
        if (highlightRectSideView != null) {
            highlightRectSideView.i(rect);
        }
        this.pZN = highlightRectSideView;
    }

    public void a(int i, String str, byte[] bArr, int i2, int i3) {
        x.d("MicroMsg.BaseScanModeLicence", "onDecodeSuccess");
        Bitmap bitmap = ((com.tencent.mm.plugin.scanner.util.k) this.qdg).qgR;
        final String bpr = bpr();
        if (this.pZP != null) {
            this.pZP.dismiss();
        }
        Context context = this.qdm.getContext();
        context.getString(R.l.dGZ);
        this.pZP = h.a(context, context.getString(R.l.eIb), false, null);
        this.pZP.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4 || keyEvent.getAction() != 1) {
                    return false;
                }
                c.a(c.this, bpr);
                return true;
            }
        });
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new ig();
        aVar.hnU = new ih();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanlicense";
        aVar.hnS = 1803;
        com.tencent.mm.ad.b Kf = aVar.Kf();
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap.compress(CompressFormat.JPEG, 80, byteArrayOutputStream)) {
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            if (bi.by(toByteArray)) {
                r(2, bpr, "");
                return;
            }
            ig igVar = (ig) Kf.hnQ.hnY;
            igVar.vUU = new com.tencent.mm.bp.b(toByteArray);
            if (bpr.equals("driving")) {
                igVar.vUT = 0;
            } else if (bpr.equals("identity")) {
                igVar.vUT = 1;
            }
            this.pZO = u.a(Kf, new u.a() {
                public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                    x.i("MicroMsg.BaseScanModeLicence", "errType: %d, errCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
                    c cVar = c.this;
                    cVar.pZM++;
                    c.this.r(i2, bpr, ((ih) bVar.hnR.hnY).vUV);
                    return 0;
                }
            }, false);
            return;
        }
        r(2, bpr, "");
    }

    public final void bpp() {
        x.d("MicroMsg.BaseScanModeLicence", "onDecodeFail");
        if (this.qdm == null) {
            x.e("MicroMsg.BaseScanModeLicence", "ui callback is null");
        } else {
            bpA();
        }
    }

    private void bpA() {
        this.pZN.b(((com.tencent.mm.plugin.scanner.util.k) this.qdg).bqu());
        this.qdm.eh(this.pZL);
    }

    private void r(int i, String str, String str2) {
        com.tencent.mm.sdk.b.b olVar;
        com.tencent.mm.sdk.b.b olVar2;
        if (i == 0) {
            olVar = new ol();
            olVar.fHf.cardType = str;
            olVar.fHf.fHg = 1;
            olVar.fHf.fHh = str2;
            if (this.qdg instanceof com.tencent.mm.plugin.scanner.util.k) {
                olVar.fHf.fHi = ((com.tencent.mm.plugin.scanner.util.k) this.qdg).qgR;
            }
            com.tencent.mm.sdk.b.a.xmy.a(olVar, Looper.getMainLooper());
            if (this.pZP != null) {
                this.pZP.dismiss();
            }
            this.qdm.getContext().finish();
        } else if ((i & 2) > 0 && (i & 1) > 0) {
            olVar2 = new ol();
            olVar2.fHf.cardType = str;
            olVar2.fHf.fHg = 0;
            olVar2.fHf.fHh = str2;
            com.tencent.mm.sdk.b.a.xmy.a(olVar2, Looper.getMainLooper());
            if (this.pZP != null) {
                this.pZP.dismiss();
            }
            this.qdm.getContext().finish();
        } else if (this.pZM >= 3) {
            olVar = new ol();
            olVar.fHf.cardType = str;
            olVar.fHf.fHg = 1;
            olVar.fHf.fHh = str2;
            if (this.qdg instanceof com.tencent.mm.plugin.scanner.util.k) {
                olVar.fHf.fHi = ((com.tencent.mm.plugin.scanner.util.k) this.qdg).qgR;
            }
            com.tencent.mm.sdk.b.a.xmy.a(olVar, Looper.getMainLooper());
            if (this.pZP != null) {
                this.pZP.dismiss();
            }
            this.qdm.getContext().finish();
        } else if ((i & 1) <= 0 || this.pZM >= 3) {
            olVar2 = new ol();
            olVar2.fHf.cardType = str;
            olVar2.fHf.fHg = 0;
            olVar2.fHf.fHh = str2;
            com.tencent.mm.sdk.b.a.xmy.a(olVar2, Looper.getMainLooper());
            if (this.pZP != null) {
                this.pZP.dismiss();
            }
            this.qdm.getContext().finish();
        } else {
            if (this.pZP != null) {
                this.pZP.dismiss();
            }
            bpu().bqd();
            int i2 = (i & 32) > 0 ? R.l.eHZ : (i & 64) > 0 ? R.l.eIa : R.l.eHY;
            Toast.makeText(this.qdm.getContext(), i2, 0).show();
            bpA();
        }
    }

    public final void D(Bundle bundle) {
    }
}
