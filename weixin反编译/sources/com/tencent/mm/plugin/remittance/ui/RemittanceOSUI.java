package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.n;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.tt;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.remittance.model.z;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.q;

@a(19)
public class RemittanceOSUI extends RemittanceBaseUI implements d.a {
    private int pUZ;
    private String pVa;
    private String pVb;
    private String pVc;
    private String pVd;
    private boolean pVe = false;
    private c pVf = new c<tt>() {
        {
            this.xmG = tt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (RemittanceOSUI.this.pVe) {
                RemittanceOSUI.this.finish();
            }
            return false;
        }
    };

    public final void boo() {
    }

    public final void boq() {
        g.pWK.h(13337, Integer.valueOf(2));
    }

    public final void bor() {
        u.makeText(this.mController.xRr, getString(i.uUA, new Object[]{this.pVa}), 0).show();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.xmy.a(this.pVf);
        this.zSi.jl(1622);
        this.zSi.jl(1574);
        initView();
        this.lrK.yb("");
        n.JF().a((d.a) this);
        this.pUZ = getIntent().getIntExtra("os_currency", 0);
        this.pVa = getIntent().getStringExtra("os_currencyuint");
        this.pVb = getIntent().getStringExtra("os_currencywording");
        this.pVc = getIntent().getStringExtra("os_notice");
        this.pVd = getIntent().getStringExtra("os_notice_url");
        this.lrK.yb(this.pVa);
        bou();
    }

    public final void dX(String str, String str2) {
        String Ga = q.Ga();
        if (bi.oN(Ga)) {
            Ga = q.FY();
        }
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.k.a Xv = ((h) com.tencent.mm.kernel.g.h(h.class)).Ff().Xv(this.gBJ);
        String str3 = this.gBJ;
        if (((int) Xv.gKO) != 0) {
            str3 = Xv.AX();
        }
        k zVar = new z(this.pRD, Ga, this.gBJ, str3, str, this.pUZ);
        zVar.gQd = "RemittanceProcess";
        l(zVar);
        g.pWK.h(13337, Integer.valueOf(1), Double.valueOf(this.pRD));
    }

    protected final void IZ(String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        com.tencent.mm.bl.d.b(this, "webview", ".ui.tools.WebViewUI", intent, 3);
        this.pVe = true;
    }

    protected final void Ja(String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        com.tencent.mm.bl.d.b(this, "webview", ".ui.tools.WebViewUI", intent, 3);
        this.pVe = true;
    }

    public final void bou() {
        if (bi.oN(this.pVc)) {
            x.i("MicroMsg.RemittanceOSUI", "no bulletin data");
        } else {
            e.a((TextView) findViewById(f.ulY), "", this.pVc, this.pVd);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xmy.c(this.pVf);
        n.JF().b(this);
        this.zSi.jm(1622);
        this.zSi.jm(1574);
    }

    public final void jk(String str) {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.RemittanceOSUI", "reqcode=" + i + ", resultCode=" + i2 + ", username=" + this.gBJ);
        this.pVe = false;
        if (i == 3 && i2 == -1) {
            finish();
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uKD;
    }

    public final void b(int i, int i2, String str, k kVar, boolean z) {
        super.b(i, i2, str, kVar, z);
        if (i == 0 && i2 == 0 && (kVar instanceof z)) {
            int i3;
            final z zVar = (z) kVar;
            boolean i32;
            if (zVar.pQu <= 0) {
                i32 = false;
            } else if (zVar.pRr == 0) {
                com.tencent.mm.ui.base.h.a((Context) this, getString(i.uUD, new Object[]{Integer.valueOf(zVar.pQu)}), getString(i.dGE), getString(i.uTI), getString(i.uUz), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        RemittanceOSUI.this.IZ(zVar.pQo);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        RemittanceOSUI.this.Ja(zVar.pRq);
                    }
                });
                i32 = 1;
            } else if (zVar.pRr == 1) {
                com.tencent.mm.ui.base.h.a((Context) this, getString(i.uUD, new Object[]{Integer.valueOf(zVar.pQu)}), getString(i.dGE), getString(i.uTI), getString(i.uUz), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        RemittanceOSUI.this.IZ(zVar.pQo);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        RemittanceOSUI.this.Ja(zVar.pRq);
                    }
                });
                i32 = 1;
            } else {
                i32 = false;
            }
            if (i32 == 0) {
                String str2 = ((z) kVar).pQo;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                intent.putExtra("showShare", false);
                com.tencent.mm.bl.d.b(this, "webview", ".ui.tools.WebViewUI", intent, 3);
            }
        }
    }
}
