package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.f.a.oj;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

public final class j extends i implements a {
    private long pZL;
    private HighlightRectSideView qdt;
    boolean qdu = false;
    private OnClickListener qdv = new OnClickListener() {
        public final void onClick(View view) {
            View inflate = ((LayoutInflater) j.this.qdm.getContext().getSystemService("layout_inflater")).inflate(R.i.drg, null);
            Context context = j.this.qdm.getContext();
            h.a(context, context.getString(R.l.eHB), context.getString(R.l.eHA), inflate, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).show();
        }
    };

    public j(b bVar, Point point, DisplayMetrics displayMetrics, int i) {
        Point point2;
        super(bVar, point);
        if (i == 1) {
            point2 = new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            point2 = new Point(displayMetrics.heightPixels, displayMetrics.widthPixels);
        }
        int i2 = point2.y - ((int) (118.0f * displayMetrics.density));
        Point point3 = new Point((int) (((float) ((int) (((float) i2) * 1.586f))) / displayMetrics.density), (int) (((float) i2) / displayMetrics.density));
        bVar.getContext().setResult(0);
        this.qdk = 0;
        this.qdl = 64;
        dp(point3.x, point3.y);
        if (bi.eZ(bVar.getContext()) < 100) {
            x.w("MicroMsg.ScanModeBankCard", "memory is not much");
            this.pZL = 280;
            return;
        }
        this.pZL = 80;
    }

    protected final void onResume() {
    }

    protected final void onPause() {
    }

    protected final void onDestroy() {
    }

    protected final void bpt() {
    }

    protected final com.tencent.mm.plugin.scanner.util.b bpu() {
        if (this.qdg == null && this.qdm != null) {
            this.qdg = new g(this, this.qdm.bpI(), this.qdu);
        }
        return this.qdg;
    }

    protected final int bpv() {
        return R.i.drf;
    }

    protected final int bpw() {
        return 300;
    }

    protected final void bpx() {
    }

    protected final void h(Rect rect) {
        String str;
        LinearLayout linearLayout = (LinearLayout) this.qdm.findViewById(R.h.bMG);
        TextView textView = (TextView) this.qdm.findViewById(R.h.bMJ);
        this.qdt = (HighlightRectSideView) this.qdm.findViewById(R.h.bMI);
        this.qdt.i(rect);
        Intent intent = this.qdm.getContext().getIntent();
        if (intent != null) {
            String aD = bi.aD(intent.getStringExtra("bank_card_owner"), "");
            textView.setText(String.format(this.qdm.getContext().getResources().getString(R.l.eHC), new Object[]{aD}));
            str = aD;
        } else {
            str = null;
        }
        if (bi.oN(str)) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
            ((ImageView) this.qdm.findViewById(R.h.bMH)).setOnClickListener(this.qdv);
        }
        if (this.qdg != null && this.qdm != null) {
            g gVar = (g) this.qdg;
            boolean bpI = this.qdm.bpI();
            x.d("MicroMsg.ScanBankCardDecoder", "need rotate:" + bpI);
            gVar.qgf = bpI;
        }
    }

    public final void a(int i, String str, byte[] bArr, int i2, int i3) {
        x.d("MicroMsg.ScanModeBankCard", "decode success, resultType:%d", Integer.valueOf(i));
        if (3 != i) {
            x.e("MicroMsg.ScanModeBankCard", "decode success, but result type error:" + i);
            return;
        }
        Bitmap bqk = ((g) this.qdg).bqk();
        if (this.qdu) {
            this.qdm.bpK();
            ConfirmScanBankCardResultUI.c(bqk, str);
            return;
        }
        com.tencent.mm.sdk.b.b ojVar = new oj();
        ojVar.fHc.cardId = str;
        ojVar.fHc.fHd = bqk;
        com.tencent.mm.sdk.b.a.xmy.m(ojVar);
        this.qdm.getContext().finish();
    }

    public final void bpp() {
        x.d("MicroMsg.ScanModeBankCard", "onDecodeFailed");
        if (this.qdm == null) {
            x.e("MicroMsg.ScanModeBankCard", "ui callback is null");
            return;
        }
        this.qdt.b(((g) this.qdg).qgh);
        this.qdm.eh(this.pZL);
    }

    protected final boolean bpy() {
        return false;
    }

    protected final boolean bpz() {
        return false;
    }

    public final void D(Bundle bundle) {
    }
}
