package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.protocal.c.bfr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import com.tencent.mm.y.be;
import com.tencent.mm.y.be.a;

public class GetQRCodeInfoUI extends MMBaseActivity implements e {
    private ProgressDialog inI = null;
    private ac qmC;

    static /* synthetic */ void a(GetQRCodeInfoUI getQRCodeInfoUI, String str) {
        if (!bi.oN(str)) {
            String str2 = "";
            if (str.startsWith("weixin://qr/")) {
                str2 = str.substring(12) + "@qr";
            } else if (str.startsWith("http://weixin.qq.com/r/")) {
                str2 = str.substring(23) + "@qr";
            }
            as.CN().a(106, (e) getQRCodeInfoUI);
            getQRCodeInfoUI.qmC = new ac(str2, 5);
            as.CN().a(getQRCodeInfoUI.qmC, 0);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.i.empty);
        Uri data = getIntent().getData();
        if (data == null) {
            finish();
            return;
        }
        String oM = bi.oM(data.getHost());
        String oM2 = bi.oM(data.getScheme());
        if (("http".equals(oM2) && "weixin.qq.com".equals(oM)) || ("weixin".equals(oM2) && "qr".equals(oM))) {
            as.CN().a(new be(new a() {
                public final void a(com.tencent.mm.network.e eVar) {
                    if (eVar == null) {
                        GetQRCodeInfoUI.this.finish();
                    } else if (!as.Hp() || as.Cz()) {
                        com.tencent.mm.plugin.setting.a.ihN.s(new Intent(), GetQRCodeInfoUI.this);
                        GetQRCodeInfoUI.this.finish();
                    } else {
                        GetQRCodeInfoUI.a(GetQRCodeInfoUI.this, GetQRCodeInfoUI.this.getIntent().getDataString());
                    }
                }
            }), 0);
        } else {
            finish();
        }
    }

    public void onResume() {
        super.onResume();
        getString(R.l.dGZ);
        this.inI = h.a((Context) this, getString(R.l.dDr), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                GetQRCodeInfoUI.this.finish();
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.qmC != null) {
            as.CN().c(this.qmC);
        }
        as.CN().b(106, (e) this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.GetQRCodeInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.inI != null) {
            this.inI.dismiss();
            this.inI = null;
        }
        if (i == 4 && i2 == -2004) {
            h.a((Context) this, R.l.eBE, R.l.dGZ, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    GetQRCodeInfoUI.this.finish();
                }
            });
        } else if (i == 0 && i2 == 0) {
            bfr Sv = ((ac) kVar).Sv();
            String a = n.a(Sv.wfM);
            com.tencent.mm.ac.n.JF().f(a, n.a(Sv.vNQ));
            ((j) g.h(j.class)).a(new Intent(), Sv, 30);
            if (bi.oM(a).length() > 0) {
                if ((Sv.wCq & 8) > 0) {
                    com.tencent.mm.plugin.report.service.g.pWK.k(10298, a + ",30");
                }
                d.c(this, "profile", ".ui.ContactInfoUI", 1);
            }
        } else {
            h.a((Context) this, getString(R.l.ejr, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), getString(R.l.dGZ), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    GetQRCodeInfoUI.this.finish();
                }
            });
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        com.tencent.mm.plugin.setting.a.ihN.s(new Intent(), this);
        finish();
    }
}
