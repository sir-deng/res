package com.tencent.mm.ui.account.mobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.hp;
import com.tencent.mm.f.a.hq;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.friend.FindMContactAddUI;
import com.tencent.mm.y.as;

public final class g implements e, b {
    private String liu = null;
    private MobileVerifyUI ydk;
    private String ydo = "";
    private int ydp = 2;

    /* renamed from: com.tencent.mm.ui.account.mobile.g$3 */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] ydn = new int[a.cpo().length];

        static {
            try {
                ydn[a.ydV - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                ydn[a.ydW - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                ydn[a.ydX - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public final void a(MobileVerifyUI mobileVerifyUI) {
        this.ydk = mobileVerifyUI;
        this.liu = mobileVerifyUI.getIntent().getStringExtra("regsetinfo_ticket");
        this.ydo = mobileVerifyUI.getIntent().getStringExtra("regsetinfo_NextStep");
        this.ydp = mobileVerifyUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    }

    public final void start() {
    }

    public final void stop() {
    }

    public final boolean EC(int i) {
        com.tencent.mm.sdk.b.b hpVar;
        String str;
        String str2;
        final k tVar;
        MobileVerifyUI mobileVerifyUI;
        Context context;
        switch (AnonymousClass3.ydn[i - 1]) {
            case 1:
                hpVar = new hp();
                hpVar.fyM.context = this.ydk;
                a.xmy.m(hpVar);
                str = hpVar.fyN.fyO;
                hpVar = new hq();
                a.xmy.m(hpVar);
                str2 = hpVar.fyP.fyQ;
                as.CN().a(132, (e) this);
                tVar = new t(this.ydk.fBa, 2, this.ydk.yce.getText().toString().trim(), "", str, str2);
                as.CN().a(tVar, 0);
                mobileVerifyUI = this.ydk;
                context = this.ydk;
                this.ydk.getString(R.l.dGZ);
                mobileVerifyUI.inI = h.a(context, this.ydk.getString(R.l.dLI), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        as.CN().c(tVar);
                        as.CN().b(132, g.this);
                    }
                });
                break;
            case 2:
                as.CN().a(132, (e) this);
                as.CN().a(new t(this.ydk.fBa, 1, "", 0, ""), 0);
                break;
            case 3:
                hpVar = new hp();
                hpVar.fyM.context = this.ydk;
                a.xmy.m(hpVar);
                str = hpVar.fyN.fyO;
                hpVar = new hq();
                a.xmy.m(hpVar);
                str2 = hpVar.fyP.fyQ;
                as.CN().a(132, (e) this);
                tVar = new t(this.ydk.fBa, 2, this.ydk.yce.getText().toString().trim(), "", str, str2);
                as.CN().a(tVar, 0);
                mobileVerifyUI = this.ydk;
                context = this.ydk;
                this.ydk.getString(R.l.dGZ);
                mobileVerifyUI.inI = h.a(context, this.ydk.getString(R.l.dLI), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        as.CN().c(tVar);
                        as.CN().b(132, g.this);
                    }
                });
                break;
        }
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 0;
        x.i("MicroMsg.MobileVerifyQQRegLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ydk.inI != null) {
            this.ydk.inI.dismiss();
            this.ydk.inI = null;
        }
        if (kVar.getType() == 132) {
            as.CN().b(132, (e) this);
            if (((t) kVar).IY() == 2 && i == 0 && i2 == 0) {
                as.unhold();
                if (com.tencent.mm.pluginsdk.a.dZ(this.ydk).size() != 0) {
                    i3 = 1;
                }
                Intent at;
                if (this.ydo == null || !this.ydo.contains("1") || i3 == 0) {
                    at = com.tencent.mm.plugin.c.a.ihN.at(this.ydk);
                    at.addFlags(67108864);
                    this.ydk.startActivity(at);
                    this.ydk.ydL = 4;
                    this.ydk.finish();
                    return;
                }
                com.tencent.mm.plugin.c.b.oZ("R300_300_QQ");
                at = new Intent(this.ydk, FindMContactAddUI.class);
                at.addFlags(67108864);
                at.putExtra("regsetinfo_ticket", this.liu);
                at.putExtra("regsetinfo_NextStep", this.ydo);
                at.putExtra("regsetinfo_NextStyle", this.ydp);
                at.putExtra("login_type", 1);
                Intent at2 = com.tencent.mm.plugin.c.a.ihN.at(this.ydk);
                at2.addFlags(67108864);
                MMWizardActivity.b(this.ydk, at, at2);
                this.ydk.finish();
            }
        } else if (!this.ydk.o(i, i2, str)) {
            if (i != 0 || i2 != 0) {
                Toast.makeText(this.ydk, this.ydk.getString(R.l.dLK, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }
}
