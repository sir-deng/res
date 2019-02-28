package com.tencent.mm.ui.account.mobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.g.a;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.account.LoginUI;
import com.tencent.mm.ui.account.mobile.MobileInputUI.b;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;

public final class c implements e, b {
    private SecurityImage xSF = null;
    private a xZt = null;
    private MobileInputUI ycs;

    /* renamed from: com.tencent.mm.ui.account.mobile.c$3 */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] ycu = new int[a.cpn().length];

        static {
            try {
                ycu[a.ycR - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    public final void a(final MobileInputUI mobileInputUI) {
        this.ycs = mobileInputUI;
        mobileInputUI.xYI.setVisibility(0);
        mobileInputUI.ycD.setVisibility(0);
        mobileInputUI.ycE.requestFocus();
        mobileInputUI.xYT.setText(R.l.dGb);
        mobileInputUI.xYT.setVisibility(0);
        mobileInputUI.ycI.setVisibility(0);
        mobileInputUI.ycJ.setText(R.l.etF);
        mobileInputUI.ycJ.setVisibility(0);
        mobileInputUI.ycJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                mobileInputUI.ofG[0] = 1;
                Intent intent = new Intent();
                intent.putExtra("from_switch_account", mobileInputUI.xYl);
                intent.setClass(mobileInputUI, LoginUI.class);
                mobileInputUI.startActivity(intent);
                mobileInputUI.finish();
            }
        });
    }

    public final void start() {
        as.CN().a((int) com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX, (e) this);
        com.tencent.mm.plugin.c.b.b(true, as.CI() + "," + getClass().getName() + ",L200_100," + as.fJ("L200_100") + ",1");
        com.tencent.mm.plugin.c.b.oY("L200_100");
    }

    public final void stop() {
        as.CN().b((int) com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX, (e) this);
        com.tencent.mm.plugin.c.b.b(false, as.CI() + "," + getClass().getName() + ",L200_100," + as.fJ("L200_100") + ",2");
    }

    public final void EB(int i) {
        switch (AnonymousClass3.ycu[i - 1]) {
            case 1:
                this.ycs.ycK = ap.VS(this.ycs.countryCode);
                this.ycs.pny = this.ycs.ycE.getText().toString();
                String VQ = ap.VQ(this.ycs.ycK + this.ycs.pny);
                MobileInputUI mobileInputUI = this.ycs;
                Context context = this.ycs;
                this.ycs.getString(R.l.dGZ);
                mobileInputUI.xXM = h.a(context, this.ycs.getString(R.l.eDK), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                as.CN().a(new s(VQ, 13, "", 0, ""), 0);
                return;
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.MobileInputLoginLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.ycs.xXM != null) {
            this.ycs.xXM.dismiss();
            this.ycs.xXM = null;
        }
        if (kVar.getType() == 701 && this.xZt != null) {
            this.xZt.xYn = this.ycs.xYn;
            this.xZt.a(this.ycs, i, i2, str, kVar);
        } else if (kVar.getType() != com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX || ((s) kVar).IY() != 13) {
        } else {
            if (i2 == -41) {
                a eC = a.eC(str);
                if (eC != null) {
                    eC.a(this.ycs, null, null);
                } else {
                    h.h(this.ycs, R.l.eDR, R.l.eDS);
                }
            } else if (i2 == -1) {
                Toast.makeText(this.ycs, this.ycs.getString(R.l.eiB, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            } else if (i2 == -34) {
                h.b(this.ycs, this.ycs.getString(R.l.dLe), "", true);
            } else {
                this.ycs.aWY();
                Intent intent = new Intent(this.ycs, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", -1);
                intent.putExtra("mobile_auth_type", 7);
                intent.putExtra("from_switch_account", this.ycs.xYl);
                intent.putExtra("input_country_code", this.ycs.countryCode);
                intent.putExtra("input_mobile_number", this.ycs.pny);
                this.ycs.startActivity(intent);
            }
        }
    }
}
