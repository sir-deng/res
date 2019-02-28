package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.i.a;

public class AppInstallerUI extends MMBaseActivity {
    private static AppInstallerUI xkA = null;
    private String desc;
    private String frM;
    private i pDT = null;
    private int rAU;
    private OnClickListener xkB = new OnClickListener() {
        public final void onClick(DialogInterface dialogInterface, int i) {
            x.d("MicroMsg.AppInstallerUI", "getBtn (ok button) is click");
            if (AppInstallerUI.this.rAU == 2) {
                i.af(AppInstallerUI.this, 3);
            }
            String Jg = c.Jg(AppInstallerUI.this.frM);
            x.d("MicroMsg.AppInstallerUI", Jg);
            if (Jg != null) {
                a.xme.ad(1, true);
                g.pWK.a(405, 72, 1, true);
                new ag().postDelayed(new Runnable(Jg) {
                    public final void run() {
                        AppInstallerUI.this.startActivity(bi.Wc(r5));
                        AppInstallerUI.this.finish();
                    }
                }, 300);
                return;
            }
            g.pWK.a(405, 73, 1, true);
            x.e("MicroMsg.AppInstallerUI", "pack not found!");
            h.bu(AppInstallerUI.this, AppInstallerUI.this.getString(R.l.eSi));
            i.cfo();
            AppInstallerUI.this.finish();
        }
    };
    private i xkz = null;

    static /* synthetic */ void a(AppInstallerUI appInstallerUI) {
        x.d("MicroMsg.AppInstallerUI", "showInstallCancelAlert");
        if (appInstallerUI.pDT != null && appInstallerUI.pDT.isShowing()) {
            appInstallerUI.pDT.dismiss();
        }
        if (appInstallerUI.xkz == null || !appInstallerUI.xkz.isShowing()) {
            appInstallerUI.xkz = h.a((Context) appInstallerUI, R.l.dNz, R.l.dGZ, R.l.dNA, R.l.dXP, false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    x.d("MicroMsg.AppInstallerUI", "install dialog had been canceled");
                    if (AppInstallerUI.this.pDT != null && AppInstallerUI.this.pDT.isShowing()) {
                        AppInstallerUI.this.pDT.dismiss();
                    }
                    a.xme.ad(2, true);
                    if (AppInstallerUI.this.rAU == 2) {
                        i.af(AppInstallerUI.this, 4);
                    }
                    g.pWK.a(405, 74, 1, true);
                    i.cfj();
                    AppInstallerUI.this.finish();
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    g.pWK.a(405, 75, 1, true);
                    if (AppInstallerUI.this.pDT != null && !AppInstallerUI.this.pDT.isShowing()) {
                        AppInstallerUI.this.pDT.show();
                    }
                }
            });
            return;
        }
        x.d("MicroMsg.AppInstallerUI", "cancelDialog already shown");
    }

    public static AppInstallerUI ceV() {
        return xkA;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.d("MicroMsg.AppInstallerUI", "onCreate");
        com.tencent.mm.sandbox.c.h(hashCode(), this);
        MMActivity.initLanguage(this);
        if (AppUpdaterUI.ceW() != null && !AppUpdaterUI.ceW().isFinishing()) {
            x.d("MicroMsg.AppInstallerUI", "AppUpdaterUI is there, finish self");
            finish();
        } else if (xkA == null || xkA.isFinishing() || xkA == this) {
            xkA = this;
            this.frM = i.bZL();
            if (bi.oN(this.frM) || c.Jg(this.frM) == null) {
                finish();
                return;
            }
            this.desc = i.cfg();
            this.rAU = i.cfh();
            setContentView(R.i.empty);
            a aVar = new a(this);
            aVar.ES(R.l.ejC);
            aVar.mp(true);
            aVar.d(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppInstallerUI.a(AppInstallerUI.this);
                }
            });
            aVar.Zn(getString(R.l.ejF, new Object[]{this.desc}));
            aVar.EV(R.l.epL).a(false, this.xkB);
            aVar.EW(R.l.eSg).b(null);
            this.pDT = aVar.ale();
            this.pDT.setCanceledOnTouchOutside(false);
            this.pDT.show();
            g.pWK.a(405, 71, 1, true);
            if (this.rAU == 2) {
                i.f(this, 2, i.cfi() + 1);
            }
        } else {
            x.d("MicroMsg.AppInstallerUI", "duplicate instance, finish self");
            finish();
        }
    }

    protected void onDestroy() {
        x.d("MicroMsg.AppInstallerUI", "onDestroy");
        if (this.pDT != null && this.pDT.isShowing()) {
            this.pDT.dismiss();
        }
        if (this.xkz != null && this.xkz.isShowing()) {
            this.xkz.dismiss();
        }
        if (xkA == this) {
            xkA = null;
        }
        com.tencent.mm.sandbox.c.i(hashCode(), this);
        super.onDestroy();
    }
}
